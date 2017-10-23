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
    private TbPageContext abm;
    public TextView bHb;
    public ClickableHeaderImageView bJM;
    public TextView bJN;
    public EntelechyUserLikeButton bJO;
    private com.baidu.tbadk.core.view.userLike.c bJP;
    private com.baidu.tieba.card.data.i bJQ;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public g(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.bJQ != null && g.this.bJQ.author != null && !StringUtils.isNull(g.this.bJQ.author.getName_show()) && !StringUtils.isNull(g.this.bJQ.author.getUserId())) {
                    if (g.this.auc != null) {
                        g.this.auc.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(g.this.abm.getPageActivity(), g.this.bJQ.author.getUserId(), g.this.bJQ.author.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.abm = tbPageContext;
        this.bJM = (ClickableHeaderImageView) view.findViewById(d.h.rec_god_item_header);
        this.bJM.setGodIconMargin(d.f.ds6);
        this.bHb = (TextView) view.findViewById(d.h.rec_god_item_user_name);
        this.bJN = (TextView) view.findViewById(d.h.rec_god_item_user_describe);
        this.bJO = (EntelechyUserLikeButton) view.findViewById(d.h.rec_god_item_user_like_btn);
        this.bJP = new com.baidu.tbadk.core.view.userLike.c(this.abm, this.bJO);
        this.bJP.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f ab(View view) {
        g gVar = new g(view, this.abm);
        gVar.bJP.h(this.uniqueId);
        return gVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar instanceof com.baidu.tieba.card.data.i) {
            this.bJQ = (com.baidu.tieba.card.data.i) dVar;
            if (this.bJQ.author != null) {
                getView().setTag(d.h.rec_god_item_root, this.bJQ.author.getUserId());
                this.bJM.setTag(d.h.rec_god_item_root, this.bJQ.author.getUserId());
                this.bJO.setTag(this.bJQ.author);
                this.bJM.setData(this.bJQ.author);
                this.bJM.setAfterClickListener(this.auc);
                this.bHb.setText(am.t(this.bJQ.author.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.bJQ.author.getGodUserData() != null) {
                    this.bJN.setText(am.t(this.bJQ.author.getGodUserData().getIntro(), 6));
                }
                this.bJP.a(this.bJQ.author);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.i(this.bHb, d.e.cp_cont_b);
            aj.i(this.bJN, d.e.cp_cont_d);
            if (this.bJO != null) {
                this.bJO.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
