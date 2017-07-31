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
    private TbPageContext acp;
    public ClickableHeaderImageView bGq;
    public TextView bGr;
    public TextView bGs;
    public EntelechyUserLikeButton bGt;
    private com.baidu.tbadk.core.view.userLike.c bGu;
    private com.baidu.tieba.card.data.i bGv;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public g(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.bGv != null && g.this.bGv.author != null && !StringUtils.isNull(g.this.bGv.author.getName_show()) && !StringUtils.isNull(g.this.bGv.author.getUserId())) {
                    if (g.this.avV != null) {
                        g.this.avV.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(g.this.acp.getPageActivity(), g.this.bGv.author.getUserId(), g.this.bGv.author.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.acp = tbPageContext;
        this.bGq = (ClickableHeaderImageView) view.findViewById(d.h.rec_god_item_header);
        this.bGq.setGodIconMargin(d.f.ds6);
        this.bGr = (TextView) view.findViewById(d.h.rec_god_item_user_name);
        this.bGs = (TextView) view.findViewById(d.h.rec_god_item_user_describe);
        this.bGt = (EntelechyUserLikeButton) view.findViewById(d.h.rec_god_item_user_like_btn);
        this.bGu = new com.baidu.tbadk.core.view.userLike.c(this.acp, this.bGt);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f V(View view) {
        g gVar = new g(view, this.acp);
        gVar.bGu.i(this.uniqueId);
        return gVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar instanceof com.baidu.tieba.card.data.i) {
            this.bGv = (com.baidu.tieba.card.data.i) dVar;
            if (this.bGv.author != null) {
                getView().setTag(d.h.rec_god_item_root, this.bGv.author.getUserId());
                this.bGq.setTag(d.h.rec_god_item_root, this.bGv.author.getUserId());
                this.bGt.setTag(this.bGv.author);
                this.bGq.setData(this.bGv.author);
                this.bGq.setAfterClickListener(this.avV);
                this.bGr.setText(al.t(this.bGv.author.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.bGv.author.getGodUserData() != null) {
                    this.bGs.setText(al.t(this.bGv.author.getGodUserData().getIntro(), 6));
                }
                this.bGu.a(this.bGv.author);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ai.i(this.bGr, d.e.cp_cont_b);
            ai.i(this.bGs, d.e.cp_cont_d);
            if (this.bGt != null) {
                this.bGt.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
