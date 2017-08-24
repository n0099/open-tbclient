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
    public ClickableHeaderImageView bHa;
    public TextView bHb;
    public TextView bHc;
    public EntelechyUserLikeButton bHd;
    private com.baidu.tbadk.core.view.userLike.c bHe;
    private com.baidu.tieba.card.data.i bHf;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public g(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.bHf != null && g.this.bHf.author != null && !StringUtils.isNull(g.this.bHf.author.getName_show()) && !StringUtils.isNull(g.this.bHf.author.getUserId())) {
                    if (g.this.avX != null) {
                        g.this.avX.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(g.this.acr.getPageActivity(), g.this.bHf.author.getUserId(), g.this.bHf.author.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.acr = tbPageContext;
        this.bHa = (ClickableHeaderImageView) view.findViewById(d.h.rec_god_item_header);
        this.bHa.setGodIconMargin(d.f.ds6);
        this.bHb = (TextView) view.findViewById(d.h.rec_god_item_user_name);
        this.bHc = (TextView) view.findViewById(d.h.rec_god_item_user_describe);
        this.bHd = (EntelechyUserLikeButton) view.findViewById(d.h.rec_god_item_user_like_btn);
        this.bHe = new com.baidu.tbadk.core.view.userLike.c(this.acr, this.bHd);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f U(View view) {
        g gVar = new g(view, this.acr);
        gVar.bHe.i(this.uniqueId);
        return gVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar instanceof com.baidu.tieba.card.data.i) {
            this.bHf = (com.baidu.tieba.card.data.i) dVar;
            if (this.bHf.author != null) {
                getView().setTag(d.h.rec_god_item_root, this.bHf.author.getUserId());
                this.bHa.setTag(d.h.rec_god_item_root, this.bHf.author.getUserId());
                this.bHd.setTag(this.bHf.author);
                this.bHa.setData(this.bHf.author);
                this.bHa.setAfterClickListener(this.avX);
                this.bHb.setText(al.t(this.bHf.author.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.bHf.author.getGodUserData() != null) {
                    this.bHc.setText(al.t(this.bHf.author.getGodUserData().getIntro(), 6));
                }
                this.bHe.a(this.bHf.author);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ai.i(this.bHb, d.e.cp_cont_b);
            ai.i(this.bHc, d.e.cp_cont_d);
            if (this.bHd != null) {
                this.bHd.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
