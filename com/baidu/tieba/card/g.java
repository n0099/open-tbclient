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
    private TbPageContext abX;
    public TextView bWB;
    public ClickableHeaderImageView bZH;
    public TextView bZI;
    public EntelechyUserLikeButton bZJ;
    private com.baidu.tbadk.core.view.userLike.c bZK;
    private com.baidu.tieba.card.data.i bZL;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public g(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.bZL != null && g.this.bZL.YW != null && !StringUtils.isNull(g.this.bZL.YW.getName_show()) && !StringUtils.isNull(g.this.bZL.YW.getUserId())) {
                    if (g.this.avn != null) {
                        g.this.avn.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(g.this.abX.getPageActivity(), g.this.bZL.YW.getUserId(), g.this.bZL.YW.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.abX = tbPageContext;
        this.bZH = (ClickableHeaderImageView) view.findViewById(d.g.rec_god_item_header);
        this.bZH.setGodIconMargin(d.e.ds6);
        this.bWB = (TextView) view.findViewById(d.g.rec_god_item_user_name);
        this.bZI = (TextView) view.findViewById(d.g.rec_god_item_user_describe);
        this.bZJ = (EntelechyUserLikeButton) view.findViewById(d.g.rec_god_item_user_like_btn);
        this.bZK = new com.baidu.tbadk.core.view.userLike.c(this.abX, this.bZJ);
        this.bZK.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f ag(View view) {
        g gVar = new g(view, this.abX);
        gVar.bZK.h(this.uniqueId);
        return gVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar instanceof com.baidu.tieba.card.data.i) {
            this.bZL = (com.baidu.tieba.card.data.i) dVar;
            if (this.bZL.YW != null) {
                getView().setTag(d.g.rec_god_item_root, this.bZL.YW.getUserId());
                this.bZH.setTag(d.g.rec_god_item_root, this.bZL.YW.getUserId());
                this.bZJ.setTag(this.bZL.YW);
                this.bZH.setData(this.bZL.YW);
                this.bZH.setAfterClickListener(this.avn);
                this.bWB.setText(am.t(this.bZL.YW.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.bZL.YW.getGodUserData() != null) {
                    this.bZI.setText(am.t(this.bZL.YW.getGodUserData().getIntro(), 6));
                }
                this.bZK.a(this.bZL.YW);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.i(this.bWB, d.C0096d.cp_cont_b);
            aj.i(this.bZI, d.C0096d.cp_cont_d);
            if (this.bZJ != null) {
                this.bZJ.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
