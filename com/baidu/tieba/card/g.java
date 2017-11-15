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
    private TbPageContext abI;
    public TextView bOy;
    public ClickableHeaderImageView bRF;
    public TextView bRG;
    public EntelechyUserLikeButton bRH;
    private com.baidu.tbadk.core.view.userLike.c bRI;
    private com.baidu.tieba.card.data.i bRJ;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public g(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.bRJ != null && g.this.bRJ.YJ != null && !StringUtils.isNull(g.this.bRJ.YJ.getName_show()) && !StringUtils.isNull(g.this.bRJ.YJ.getUserId())) {
                    if (g.this.auH != null) {
                        g.this.auH.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(g.this.abI.getPageActivity(), g.this.bRJ.YJ.getUserId(), g.this.bRJ.YJ.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.abI = tbPageContext;
        this.bRF = (ClickableHeaderImageView) view.findViewById(d.g.rec_god_item_header);
        this.bRF.setGodIconMargin(d.e.ds6);
        this.bOy = (TextView) view.findViewById(d.g.rec_god_item_user_name);
        this.bRG = (TextView) view.findViewById(d.g.rec_god_item_user_describe);
        this.bRH = (EntelechyUserLikeButton) view.findViewById(d.g.rec_god_item_user_like_btn);
        this.bRI = new com.baidu.tbadk.core.view.userLike.c(this.abI, this.bRH);
        this.bRI.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f ae(View view) {
        g gVar = new g(view, this.abI);
        gVar.bRI.h(this.uniqueId);
        return gVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar instanceof com.baidu.tieba.card.data.i) {
            this.bRJ = (com.baidu.tieba.card.data.i) dVar;
            if (this.bRJ.YJ != null) {
                getView().setTag(d.g.rec_god_item_root, this.bRJ.YJ.getUserId());
                this.bRF.setTag(d.g.rec_god_item_root, this.bRJ.YJ.getUserId());
                this.bRH.setTag(this.bRJ.YJ);
                this.bRF.setData(this.bRJ.YJ);
                this.bRF.setAfterClickListener(this.auH);
                this.bOy.setText(am.t(this.bRJ.YJ.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.bRJ.YJ.getGodUserData() != null) {
                    this.bRG.setText(am.t(this.bRJ.YJ.getGodUserData().getIntro(), 6));
                }
                this.bRI.a(this.bRJ.YJ);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.i(this.bOy, d.C0080d.cp_cont_b);
            aj.i(this.bRG, d.C0080d.cp_cont_d);
            if (this.bRH != null) {
                this.bRH.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
