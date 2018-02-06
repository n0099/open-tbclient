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
    private TbPageContext aRR;
    public ClickableHeaderImageView cWg;
    public TextView cWh;
    public EntelechyUserLikeButton cWi;
    private com.baidu.tbadk.core.view.userLike.c cWj;
    private com.baidu.tieba.card.data.i cWk;
    public TextView cqu;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public g(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.cWk != null && g.this.cWk.aOQ != null && !StringUtils.isNull(g.this.cWk.aOQ.getName_show()) && !StringUtils.isNull(g.this.cWk.aOQ.getUserId())) {
                    if (g.this.bmd != null) {
                        g.this.bmd.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(g.this.aRR.getPageActivity(), g.this.cWk.aOQ.getUserId(), g.this.cWk.aOQ.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.aRR = tbPageContext;
        this.cWg = (ClickableHeaderImageView) view.findViewById(d.g.rec_god_item_header);
        this.cWg.setGodIconMargin(d.e.ds6);
        this.cqu = (TextView) view.findViewById(d.g.rec_god_item_user_name);
        this.cWh = (TextView) view.findViewById(d.g.rec_god_item_user_describe);
        this.cWi = (EntelechyUserLikeButton) view.findViewById(d.g.rec_god_item_user_like_btn);
        this.cWj = new com.baidu.tbadk.core.view.userLike.c(this.aRR, this.cWi);
        this.cWj.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f bz(View view) {
        g gVar = new g(view, this.aRR);
        gVar.cWj.h(this.uniqueId);
        return gVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar instanceof com.baidu.tieba.card.data.i) {
            this.cWk = (com.baidu.tieba.card.data.i) dVar;
            if (this.cWk.aOQ != null) {
                getView().setTag(d.g.rec_god_item_root, this.cWk.aOQ.getUserId());
                this.cWg.setTag(d.g.rec_god_item_root, this.cWk.aOQ.getUserId());
                this.cWi.setTag(this.cWk.aOQ);
                this.cWg.setData(this.cWk.aOQ);
                this.cWg.setAfterClickListener(this.bmd);
                this.cqu.setText(am.t(this.cWk.aOQ.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.cWk.aOQ.getGodUserData() != null) {
                    this.cWh.setText(am.t(this.cWk.aOQ.getGodUserData().getIntro(), 6));
                }
                this.cWj.a(this.cWk.aOQ);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.r(this.cqu, d.C0140d.cp_cont_b);
            aj.r(this.cWh, d.C0140d.cp_cont_d);
            if (this.cWi != null) {
                this.cWi.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
