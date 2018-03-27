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
    private TbPageContext aRI;
    public ClickableHeaderImageView cVX;
    public TextView cVY;
    public EntelechyUserLikeButton cVZ;
    private com.baidu.tbadk.core.view.userLike.c cWa;
    private com.baidu.tieba.card.data.i cWb;
    public TextView cql;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public g(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.cWb != null && g.this.cWb.aOG != null && !StringUtils.isNull(g.this.cWb.aOG.getName_show()) && !StringUtils.isNull(g.this.cWb.aOG.getUserId())) {
                    if (g.this.blT != null) {
                        g.this.blT.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(g.this.aRI.getPageActivity(), g.this.cWb.aOG.getUserId(), g.this.cWb.aOG.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.aRI = tbPageContext;
        this.cVX = (ClickableHeaderImageView) view.findViewById(d.g.rec_god_item_header);
        this.cVX.setGodIconMargin(d.e.ds6);
        this.cql = (TextView) view.findViewById(d.g.rec_god_item_user_name);
        this.cVY = (TextView) view.findViewById(d.g.rec_god_item_user_describe);
        this.cVZ = (EntelechyUserLikeButton) view.findViewById(d.g.rec_god_item_user_like_btn);
        this.cWa = new com.baidu.tbadk.core.view.userLike.c(this.aRI, this.cVZ);
        this.cWa.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f bz(View view) {
        g gVar = new g(view, this.aRI);
        gVar.cWa.h(this.uniqueId);
        return gVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar instanceof com.baidu.tieba.card.data.i) {
            this.cWb = (com.baidu.tieba.card.data.i) dVar;
            if (this.cWb.aOG != null) {
                getView().setTag(d.g.rec_god_item_root, this.cWb.aOG.getUserId());
                this.cVX.setTag(d.g.rec_god_item_root, this.cWb.aOG.getUserId());
                this.cVZ.setTag(this.cWb.aOG);
                this.cVX.setData(this.cWb.aOG);
                this.cVX.setAfterClickListener(this.blT);
                this.cql.setText(am.t(this.cWb.aOG.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.cWb.aOG.getGodUserData() != null) {
                    this.cVY.setText(am.t(this.cWb.aOG.getGodUserData().getIntro(), 6));
                }
                this.cWa.a(this.cWb.aOG);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.r(this.cql, d.C0141d.cp_cont_b);
            aj.r(this.cVY, d.C0141d.cp_cont_d);
            if (this.cVZ != null) {
                this.cVZ.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
