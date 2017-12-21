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
    private TbPageContext aca;
    public TextView bWF;
    public ClickableHeaderImageView bZL;
    public TextView bZM;
    public EntelechyUserLikeButton bZN;
    private com.baidu.tbadk.core.view.userLike.c bZO;
    private com.baidu.tieba.card.data.i bZP;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public g(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.bZP != null && g.this.bZP.YZ != null && !StringUtils.isNull(g.this.bZP.YZ.getName_show()) && !StringUtils.isNull(g.this.bZP.YZ.getUserId())) {
                    if (g.this.avq != null) {
                        g.this.avq.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(g.this.aca.getPageActivity(), g.this.bZP.YZ.getUserId(), g.this.bZP.YZ.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.aca = tbPageContext;
        this.bZL = (ClickableHeaderImageView) view.findViewById(d.g.rec_god_item_header);
        this.bZL.setGodIconMargin(d.e.ds6);
        this.bWF = (TextView) view.findViewById(d.g.rec_god_item_user_name);
        this.bZM = (TextView) view.findViewById(d.g.rec_god_item_user_describe);
        this.bZN = (EntelechyUserLikeButton) view.findViewById(d.g.rec_god_item_user_like_btn);
        this.bZO = new com.baidu.tbadk.core.view.userLike.c(this.aca, this.bZN);
        this.bZO.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f ag(View view) {
        g gVar = new g(view, this.aca);
        gVar.bZO.h(this.uniqueId);
        return gVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar instanceof com.baidu.tieba.card.data.i) {
            this.bZP = (com.baidu.tieba.card.data.i) dVar;
            if (this.bZP.YZ != null) {
                getView().setTag(d.g.rec_god_item_root, this.bZP.YZ.getUserId());
                this.bZL.setTag(d.g.rec_god_item_root, this.bZP.YZ.getUserId());
                this.bZN.setTag(this.bZP.YZ);
                this.bZL.setData(this.bZP.YZ);
                this.bZL.setAfterClickListener(this.avq);
                this.bWF.setText(am.t(this.bZP.YZ.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.bZP.YZ.getGodUserData() != null) {
                    this.bZM.setText(am.t(this.bZP.YZ.getGodUserData().getIntro(), 6));
                }
                this.bZO.a(this.bZP.YZ);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.i(this.bWF, d.C0095d.cp_cont_b);
            aj.i(this.bZM, d.C0095d.cp_cont_d);
            if (this.bZN != null) {
                this.bZN.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
