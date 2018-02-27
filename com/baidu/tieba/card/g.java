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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.horizonalList.widget.f {
    private TbPageContext aRG;
    public ClickableHeaderImageView cVU;
    public TextView cVV;
    public EntelechyUserLikeButton cVW;
    private com.baidu.tbadk.core.view.userLike.c cVX;
    private com.baidu.tieba.card.data.i cVY;
    public TextView cqi;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public g(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.cVY != null && g.this.cVY.aOF != null && !StringUtils.isNull(g.this.cVY.aOF.getName_show()) && !StringUtils.isNull(g.this.cVY.aOF.getUserId())) {
                    if (g.this.blQ != null) {
                        g.this.blQ.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(g.this.aRG.getPageActivity(), g.this.cVY.aOF.getUserId(), g.this.cVY.aOF.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.aRG = tbPageContext;
        this.cVU = (ClickableHeaderImageView) view.findViewById(d.g.rec_god_item_header);
        this.cVU.setGodIconMargin(d.e.ds6);
        this.cqi = (TextView) view.findViewById(d.g.rec_god_item_user_name);
        this.cVV = (TextView) view.findViewById(d.g.rec_god_item_user_describe);
        this.cVW = (EntelechyUserLikeButton) view.findViewById(d.g.rec_god_item_user_like_btn);
        this.cVX = new com.baidu.tbadk.core.view.userLike.c(this.aRG, this.cVW);
        this.cVX.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f bz(View view) {
        g gVar = new g(view, this.aRG);
        gVar.cVX.h(this.uniqueId);
        return gVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar instanceof com.baidu.tieba.card.data.i) {
            this.cVY = (com.baidu.tieba.card.data.i) dVar;
            if (this.cVY.aOF != null) {
                getView().setTag(d.g.rec_god_item_root, this.cVY.aOF.getUserId());
                this.cVU.setTag(d.g.rec_god_item_root, this.cVY.aOF.getUserId());
                this.cVW.setTag(this.cVY.aOF);
                this.cVU.setData(this.cVY.aOF);
                this.cVU.setAfterClickListener(this.blQ);
                this.cqi.setText(am.t(this.cVY.aOF.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.cVY.aOF.getGodUserData() != null) {
                    this.cVV.setText(am.t(this.cVY.aOF.getGodUserData().getIntro(), 6));
                }
                this.cVX.a(this.cVY.aOF);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.r(this.cqi, d.C0141d.cp_cont_b);
            aj.r(this.cVV, d.C0141d.cp_cont_d);
            if (this.cVW != null) {
                this.cVW.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
