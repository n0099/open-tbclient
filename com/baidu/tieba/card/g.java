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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.horizonalList.widget.f {
    private TbPageContext aQs;
    public TextView cQi;
    public ClickableHeaderImageView cTm;
    public TextView cTn;
    public EntelechyUserLikeButton cTo;
    private com.baidu.tbadk.core.view.userLike.c cTp;
    private com.baidu.tieba.card.data.i cTq;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public g(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.cTq != null && g.this.cTq.aNx != null && !StringUtils.isNull(g.this.cTq.aNx.getName_show()) && !StringUtils.isNull(g.this.cTq.aNx.getUserId())) {
                    if (g.this.bjO != null) {
                        g.this.bjO.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(g.this.aQs.getPageActivity(), g.this.cTq.aNx.getUserId(), g.this.cTq.aNx.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.aQs = tbPageContext;
        this.cTm = (ClickableHeaderImageView) view.findViewById(d.g.rec_god_item_header);
        this.cTm.setGodIconMargin(d.e.ds6);
        this.cQi = (TextView) view.findViewById(d.g.rec_god_item_user_name);
        this.cTn = (TextView) view.findViewById(d.g.rec_god_item_user_describe);
        this.cTo = (EntelechyUserLikeButton) view.findViewById(d.g.rec_god_item_user_like_btn);
        this.cTp = new com.baidu.tbadk.core.view.userLike.c(this.aQs, this.cTo);
        this.cTp.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f bA(View view) {
        g gVar = new g(view, this.aQs);
        gVar.cTp.h(this.uniqueId);
        return gVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar instanceof com.baidu.tieba.card.data.i) {
            this.cTq = (com.baidu.tieba.card.data.i) dVar;
            if (this.cTq.aNx != null) {
                getView().setTag(d.g.rec_god_item_root, this.cTq.aNx.getUserId());
                this.cTm.setTag(d.g.rec_god_item_root, this.cTq.aNx.getUserId());
                this.cTo.setTag(this.cTq.aNx);
                this.cTm.setData(this.cTq.aNx);
                this.cTm.setAfterClickListener(this.bjO);
                this.cQi.setText(am.t(this.cTq.aNx.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.cTq.aNx.getGodUserData() != null) {
                    this.cTn.setText(am.t(this.cTq.aNx.getGodUserData().getIntro(), 6));
                }
                this.cTp.a(this.cTq.aNx);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.r(this.cQi, d.C0108d.cp_cont_b);
            aj.r(this.cTn, d.C0108d.cp_cont_d);
            if (this.cTo != null) {
                this.cTo.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
