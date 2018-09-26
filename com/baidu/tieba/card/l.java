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
/* loaded from: classes2.dex */
public class l extends com.baidu.tieba.horizonalList.widget.e {
    public TextView bYF;
    public ClickableHeaderImageView cEd;
    public TextView cEe;
    public EntelechyUserLikeButton cEf;
    private com.baidu.tbadk.core.view.userLike.c cEg;
    private com.baidu.tieba.card.data.i cEh;
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
                if (l.this.cEh != null && l.this.cEh.akB != null && !StringUtils.isNull(l.this.cEh.akB.getName_show()) && !StringUtils.isNull(l.this.cEh.akB.getUserId())) {
                    if (l.this.aKh != null) {
                        l.this.aKh.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(l.this.mContext.getPageActivity(), l.this.cEh.akB.getUserId(), l.this.cEh.akB.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mContext = tbPageContext;
        this.cEd = (ClickableHeaderImageView) view.findViewById(e.g.rec_god_item_header);
        this.cEd.setGodIconMargin(e.C0141e.ds6);
        this.bYF = (TextView) view.findViewById(e.g.rec_god_item_user_name);
        this.cEe = (TextView) view.findViewById(e.g.rec_god_item_user_describe);
        this.cEf = (EntelechyUserLikeButton) view.findViewById(e.g.rec_god_item_user_like_btn);
        this.cEg = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.cEf);
        this.cEg.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e aw(View view) {
        l lVar = new l(view, this.mContext);
        lVar.cEg.h(this.uniqueId);
        return lVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.cEh = (com.baidu.tieba.card.data.i) cVar;
            if (this.cEh.akB != null) {
                getView().setTag(e.g.rec_god_item_root, this.cEh.akB.getUserId());
                this.cEd.setTag(e.g.rec_god_item_root, this.cEh.akB.getUserId());
                this.cEf.setTag(this.cEh.akB);
                this.cEd.setData(this.cEh.akB);
                this.cEd.setAfterClickListener(this.aKh);
                this.bYF.setText(ao.y(this.cEh.akB.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.cEh.akB.getGodUserData() != null) {
                    this.cEe.setText(ao.y(this.cEh.akB.getGodUserData().getIntro(), 6));
                }
                this.cEg.a(this.cEh.akB);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.h(this.bYF, e.d.cp_cont_b);
            al.h(this.cEe, e.d.cp_cont_d);
            if (this.cEf != null) {
                this.cEf.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
