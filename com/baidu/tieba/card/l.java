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
    public ClickableHeaderImageView cXa;
    public TextView cXb;
    public EntelechyUserLikeButton cXc;
    private com.baidu.tbadk.core.view.userLike.c cXd;
    private com.baidu.tieba.card.data.i cXe;
    public TextView clo;
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
                if (l.this.cXe != null && l.this.cXe.atK != null && !StringUtils.isNull(l.this.cXe.atK.getName_show()) && !StringUtils.isNull(l.this.cXe.atK.getUserId())) {
                    if (l.this.aTa != null) {
                        l.this.aTa.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(l.this.mContext.getPageActivity(), l.this.cXe.atK.getUserId(), l.this.cXe.atK.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mContext = tbPageContext;
        this.cXa = (ClickableHeaderImageView) view.findViewById(e.g.rec_god_item_header);
        this.cXa.setGodIconMargin(e.C0210e.ds6);
        this.clo = (TextView) view.findViewById(e.g.rec_god_item_user_name);
        this.cXb = (TextView) view.findViewById(e.g.rec_god_item_user_describe);
        this.cXc = (EntelechyUserLikeButton) view.findViewById(e.g.rec_god_item_user_like_btn);
        this.cXd = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.cXc);
        this.cXd.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e aB(View view) {
        l lVar = new l(view, this.mContext);
        lVar.cXd.h(this.uniqueId);
        return lVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.cXe = (com.baidu.tieba.card.data.i) cVar;
            if (this.cXe.atK != null) {
                getView().setTag(e.g.rec_god_item_root, this.cXe.atK.getUserId());
                this.cXa.setTag(e.g.rec_god_item_root, this.cXe.atK.getUserId());
                this.cXc.setTag(this.cXe.atK);
                this.cXa.setData(this.cXe.atK);
                this.cXa.setAfterClickListener(this.aTa);
                this.clo.setText(ao.z(this.cXe.atK.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.cXe.atK.getGodUserData() != null) {
                    this.cXb.setText(ao.z(this.cXe.atK.getGodUserData().getIntro(), 6));
                }
                this.cXd.a(this.cXe.atK);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.h(this.clo, e.d.cp_cont_b);
            al.h(this.cXb, e.d.cp_cont_d);
            if (this.cXc != null) {
                this.cXc.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
