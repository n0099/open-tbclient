package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class l extends com.baidu.tieba.horizonalList.widget.e {
    private com.baidu.tbadk.core.view.userLike.c cMA;
    private com.baidu.tieba.card.data.i cMB;
    public ClickableHeaderImageView cMx;
    public TextView cMy;
    public EntelechyUserLikeButton cMz;
    public TextView chf;
    private TbPageContext mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public l(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (l.this.cMB != null && l.this.cMB.apx != null && !StringUtils.isNull(l.this.cMB.apx.getName_show()) && !StringUtils.isNull(l.this.cMB.apx.getUserId())) {
                    if (l.this.aOJ != null) {
                        l.this.aOJ.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(l.this.mContext.getPageActivity(), l.this.cMB.apx.getUserId(), l.this.cMB.apx.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mContext = tbPageContext;
        this.cMx = (ClickableHeaderImageView) view.findViewById(e.g.rec_god_item_header);
        this.cMx.setGodIconMargin(e.C0175e.ds6);
        this.chf = (TextView) view.findViewById(e.g.rec_god_item_user_name);
        this.cMy = (TextView) view.findViewById(e.g.rec_god_item_user_describe);
        this.cMz = (EntelechyUserLikeButton) view.findViewById(e.g.rec_god_item_user_like_btn);
        this.cMA = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.cMz);
        this.cMA.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e aw(View view) {
        l lVar = new l(view, this.mContext);
        lVar.cMA.h(this.uniqueId);
        return lVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.cMB = (com.baidu.tieba.card.data.i) cVar;
            if (this.cMB.apx != null) {
                getView().setTag(e.g.rec_god_item_root, this.cMB.apx.getUserId());
                this.cMx.setTag(e.g.rec_god_item_root, this.cMB.apx.getUserId());
                this.cMz.setTag(this.cMB.apx);
                this.cMx.setData(this.cMB.apx);
                this.cMx.setAfterClickListener(this.aOJ);
                this.chf.setText(ao.z(this.cMB.apx.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.cMB.apx.getGodUserData() != null) {
                    this.cMy.setText(ao.z(this.cMB.apx.getGodUserData().getIntro(), 6));
                }
                this.cMA.a(this.cMB.apx);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.h(this.chf, e.d.cp_cont_b);
            al.h(this.cMy, e.d.cp_cont_d);
            if (this.cMz != null) {
                this.cMz.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
