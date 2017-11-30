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
    private TbPageContext acd;
    public TextView bWx;
    public ClickableHeaderImageView bZD;
    public TextView bZE;
    public EntelechyUserLikeButton bZF;
    private com.baidu.tbadk.core.view.userLike.c bZG;
    private com.baidu.tieba.card.data.i bZH;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public g(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.bZH != null && g.this.bZH.Zc != null && !StringUtils.isNull(g.this.bZH.Zc.getName_show()) && !StringUtils.isNull(g.this.bZH.Zc.getUserId())) {
                    if (g.this.avi != null) {
                        g.this.avi.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(g.this.acd.getPageActivity(), g.this.bZH.Zc.getUserId(), g.this.bZH.Zc.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.acd = tbPageContext;
        this.bZD = (ClickableHeaderImageView) view.findViewById(d.g.rec_god_item_header);
        this.bZD.setGodIconMargin(d.e.ds6);
        this.bWx = (TextView) view.findViewById(d.g.rec_god_item_user_name);
        this.bZE = (TextView) view.findViewById(d.g.rec_god_item_user_describe);
        this.bZF = (EntelechyUserLikeButton) view.findViewById(d.g.rec_god_item_user_like_btn);
        this.bZG = new com.baidu.tbadk.core.view.userLike.c(this.acd, this.bZF);
        this.bZG.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f af(View view) {
        g gVar = new g(view, this.acd);
        gVar.bZG.h(this.uniqueId);
        return gVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar instanceof com.baidu.tieba.card.data.i) {
            this.bZH = (com.baidu.tieba.card.data.i) dVar;
            if (this.bZH.Zc != null) {
                getView().setTag(d.g.rec_god_item_root, this.bZH.Zc.getUserId());
                this.bZD.setTag(d.g.rec_god_item_root, this.bZH.Zc.getUserId());
                this.bZF.setTag(this.bZH.Zc);
                this.bZD.setData(this.bZH.Zc);
                this.bZD.setAfterClickListener(this.avi);
                this.bWx.setText(am.t(this.bZH.Zc.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.bZH.Zc.getGodUserData() != null) {
                    this.bZE.setText(am.t(this.bZH.Zc.getGodUserData().getIntro(), 6));
                }
                this.bZG.a(this.bZH.Zc);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.i(this.bWx, d.C0082d.cp_cont_b);
            aj.i(this.bZE, d.C0082d.cp_cont_d);
            if (this.bZF != null) {
                this.bZF.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
