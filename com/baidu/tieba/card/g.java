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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.horizonalList.widget.f {
    private TbPageContext acr;
    public ClickableHeaderImageView bGZ;
    public TextView bHa;
    public TextView bHb;
    public EntelechyUserLikeButton bHc;
    private com.baidu.tbadk.core.view.userLike.c bHd;
    private com.baidu.tieba.card.data.i bHe;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public g(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.bHe != null && g.this.bHe.author != null && !StringUtils.isNull(g.this.bHe.author.getName_show()) && !StringUtils.isNull(g.this.bHe.author.getUserId())) {
                    if (g.this.avW != null) {
                        g.this.avW.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(g.this.acr.getPageActivity(), g.this.bHe.author.getUserId(), g.this.bHe.author.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.acr = tbPageContext;
        this.bGZ = (ClickableHeaderImageView) view.findViewById(d.h.rec_god_item_header);
        this.bGZ.setGodIconMargin(d.f.ds6);
        this.bHa = (TextView) view.findViewById(d.h.rec_god_item_user_name);
        this.bHb = (TextView) view.findViewById(d.h.rec_god_item_user_describe);
        this.bHc = (EntelechyUserLikeButton) view.findViewById(d.h.rec_god_item_user_like_btn);
        this.bHd = new com.baidu.tbadk.core.view.userLike.c(this.acr, this.bHc);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f V(View view) {
        g gVar = new g(view, this.acr);
        gVar.bHd.i(this.uniqueId);
        return gVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar instanceof com.baidu.tieba.card.data.i) {
            this.bHe = (com.baidu.tieba.card.data.i) dVar;
            if (this.bHe.author != null) {
                getView().setTag(d.h.rec_god_item_root, this.bHe.author.getUserId());
                this.bGZ.setTag(d.h.rec_god_item_root, this.bHe.author.getUserId());
                this.bHc.setTag(this.bHe.author);
                this.bGZ.setData(this.bHe.author);
                this.bGZ.setAfterClickListener(this.avW);
                this.bHa.setText(al.t(this.bHe.author.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.bHe.author.getGodUserData() != null) {
                    this.bHb.setText(al.t(this.bHe.author.getGodUserData().getIntro(), 6));
                }
                this.bHd.a(this.bHe.author);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ai.i(this.bHa, d.e.cp_cont_b);
            ai.i(this.bHb, d.e.cp_cont_d);
            if (this.bHc != null) {
                this.bHc.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
