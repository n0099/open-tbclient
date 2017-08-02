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
    private TbPageContext aaS;
    public ClickableHeaderImageView bFg;
    public TextView bFh;
    public TextView bFi;
    public EntelechyUserLikeButton bFj;
    private com.baidu.tbadk.core.view.userLike.c bFk;
    private com.baidu.tieba.card.data.i bFl;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public g(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.bFl != null && g.this.bFl.author != null && !StringUtils.isNull(g.this.bFl.author.getName_show()) && !StringUtils.isNull(g.this.bFl.author.getUserId())) {
                    if (g.this.auE != null) {
                        g.this.auE.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(g.this.aaS.getPageActivity(), g.this.bFl.author.getUserId(), g.this.bFl.author.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.aaS = tbPageContext;
        this.bFg = (ClickableHeaderImageView) view.findViewById(d.h.rec_god_item_header);
        this.bFg.setGodIconMargin(d.f.ds6);
        this.bFh = (TextView) view.findViewById(d.h.rec_god_item_user_name);
        this.bFi = (TextView) view.findViewById(d.h.rec_god_item_user_describe);
        this.bFj = (EntelechyUserLikeButton) view.findViewById(d.h.rec_god_item_user_like_btn);
        this.bFk = new com.baidu.tbadk.core.view.userLike.c(this.aaS, this.bFj);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f V(View view) {
        g gVar = new g(view, this.aaS);
        gVar.bFk.i(this.uniqueId);
        return gVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar instanceof com.baidu.tieba.card.data.i) {
            this.bFl = (com.baidu.tieba.card.data.i) dVar;
            if (this.bFl.author != null) {
                getView().setTag(d.h.rec_god_item_root, this.bFl.author.getUserId());
                this.bFg.setTag(d.h.rec_god_item_root, this.bFl.author.getUserId());
                this.bFj.setTag(this.bFl.author);
                this.bFg.setData(this.bFl.author);
                this.bFg.setAfterClickListener(this.auE);
                this.bFh.setText(al.t(this.bFl.author.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.bFl.author.getGodUserData() != null) {
                    this.bFi.setText(al.t(this.bFl.author.getGodUserData().getIntro(), 6));
                }
                this.bFk.a(this.bFl.author);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ai.i(this.bFh, d.e.cp_cont_b);
            ai.i(this.bFi, d.e.cp_cont_d);
            if (this.bFj != null) {
                this.bFj.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
