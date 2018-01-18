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
    private TbPageContext aQp;
    public TextView cPN;
    public ClickableHeaderImageView cSR;
    public TextView cSS;
    public EntelechyUserLikeButton cST;
    private com.baidu.tbadk.core.view.userLike.c cSU;
    private com.baidu.tieba.card.data.i cSV;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public g(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.cSV != null && g.this.cSV.aNu != null && !StringUtils.isNull(g.this.cSV.aNu.getName_show()) && !StringUtils.isNull(g.this.cSV.aNu.getUserId())) {
                    if (g.this.bjG != null) {
                        g.this.bjG.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(g.this.aQp.getPageActivity(), g.this.cSV.aNu.getUserId(), g.this.cSV.aNu.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.aQp = tbPageContext;
        this.cSR = (ClickableHeaderImageView) view.findViewById(d.g.rec_god_item_header);
        this.cSR.setGodIconMargin(d.e.ds6);
        this.cPN = (TextView) view.findViewById(d.g.rec_god_item_user_name);
        this.cSS = (TextView) view.findViewById(d.g.rec_god_item_user_describe);
        this.cST = (EntelechyUserLikeButton) view.findViewById(d.g.rec_god_item_user_like_btn);
        this.cSU = new com.baidu.tbadk.core.view.userLike.c(this.aQp, this.cST);
        this.cSU.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f bA(View view) {
        g gVar = new g(view, this.aQp);
        gVar.cSU.h(this.uniqueId);
        return gVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar instanceof com.baidu.tieba.card.data.i) {
            this.cSV = (com.baidu.tieba.card.data.i) dVar;
            if (this.cSV.aNu != null) {
                getView().setTag(d.g.rec_god_item_root, this.cSV.aNu.getUserId());
                this.cSR.setTag(d.g.rec_god_item_root, this.cSV.aNu.getUserId());
                this.cST.setTag(this.cSV.aNu);
                this.cSR.setData(this.cSV.aNu);
                this.cSR.setAfterClickListener(this.bjG);
                this.cPN.setText(am.t(this.cSV.aNu.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.cSV.aNu.getGodUserData() != null) {
                    this.cSS.setText(am.t(this.cSV.aNu.getGodUserData().getIntro(), 6));
                }
                this.cSU.a(this.cSV.aNu);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.r(this.cPN, d.C0107d.cp_cont_b);
            aj.r(this.cSS, d.C0107d.cp_cont_d);
            if (this.cST != null) {
                this.cST.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
