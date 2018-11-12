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
    public ClickableHeaderImageView cND;
    public TextView cNE;
    public EntelechyUserLikeButton cNF;
    private com.baidu.tbadk.core.view.userLike.c cNG;
    private com.baidu.tieba.card.data.i cNH;
    public TextView chp;
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
                if (l.this.cNH != null && l.this.cNH.aqk != null && !StringUtils.isNull(l.this.cNH.aqk.getName_show()) && !StringUtils.isNull(l.this.cNH.aqk.getUserId())) {
                    if (l.this.aPz != null) {
                        l.this.aPz.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(l.this.mContext.getPageActivity(), l.this.cNH.aqk.getUserId(), l.this.cNH.aqk.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mContext = tbPageContext;
        this.cND = (ClickableHeaderImageView) view.findViewById(e.g.rec_god_item_header);
        this.cND.setGodIconMargin(e.C0200e.ds6);
        this.chp = (TextView) view.findViewById(e.g.rec_god_item_user_name);
        this.cNE = (TextView) view.findViewById(e.g.rec_god_item_user_describe);
        this.cNF = (EntelechyUserLikeButton) view.findViewById(e.g.rec_god_item_user_like_btn);
        this.cNG = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.cNF);
        this.cNG.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ay(View view) {
        l lVar = new l(view, this.mContext);
        lVar.cNG.h(this.uniqueId);
        return lVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.cNH = (com.baidu.tieba.card.data.i) cVar;
            if (this.cNH.aqk != null) {
                getView().setTag(e.g.rec_god_item_root, this.cNH.aqk.getUserId());
                this.cND.setTag(e.g.rec_god_item_root, this.cNH.aqk.getUserId());
                this.cNF.setTag(this.cNH.aqk);
                this.cND.setData(this.cNH.aqk);
                this.cND.setAfterClickListener(this.aPz);
                this.chp.setText(ao.z(this.cNH.aqk.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.cNH.aqk.getGodUserData() != null) {
                    this.cNE.setText(ao.z(this.cNH.aqk.getGodUserData().getIntro(), 6));
                }
                this.cNG.a(this.cNH.aqk);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.h(this.chp, e.d.cp_cont_b);
            al.h(this.cNE, e.d.cp_cont_d);
            if (this.cNF != null) {
                this.cNF.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
