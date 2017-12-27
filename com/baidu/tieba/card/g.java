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
    private TbPageContext aQq;
    public TextView cLm;
    public ClickableHeaderImageView cOq;
    public TextView cOr;
    public EntelechyUserLikeButton cOs;
    private com.baidu.tbadk.core.view.userLike.c cOt;
    private com.baidu.tieba.card.data.i cOu;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public g(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.cOu != null && g.this.cOu.aNy != null && !StringUtils.isNull(g.this.cOu.aNy.getName_show()) && !StringUtils.isNull(g.this.cOu.aNy.getUserId())) {
                    if (g.this.bjw != null) {
                        g.this.bjw.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(g.this.aQq.getPageActivity(), g.this.cOu.aNy.getUserId(), g.this.cOu.aNy.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.aQq = tbPageContext;
        this.cOq = (ClickableHeaderImageView) view.findViewById(d.g.rec_god_item_header);
        this.cOq.setGodIconMargin(d.e.ds6);
        this.cLm = (TextView) view.findViewById(d.g.rec_god_item_user_name);
        this.cOr = (TextView) view.findViewById(d.g.rec_god_item_user_describe);
        this.cOs = (EntelechyUserLikeButton) view.findViewById(d.g.rec_god_item_user_like_btn);
        this.cOt = new com.baidu.tbadk.core.view.userLike.c(this.aQq, this.cOs);
        this.cOt.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f by(View view) {
        g gVar = new g(view, this.aQq);
        gVar.cOt.h(this.uniqueId);
        return gVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar instanceof com.baidu.tieba.card.data.i) {
            this.cOu = (com.baidu.tieba.card.data.i) dVar;
            if (this.cOu.aNy != null) {
                getView().setTag(d.g.rec_god_item_root, this.cOu.aNy.getUserId());
                this.cOq.setTag(d.g.rec_god_item_root, this.cOu.aNy.getUserId());
                this.cOs.setTag(this.cOu.aNy);
                this.cOq.setData(this.cOu.aNy);
                this.cOq.setAfterClickListener(this.bjw);
                this.cLm.setText(am.t(this.cOu.aNy.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.cOu.aNy.getGodUserData() != null) {
                    this.cOr.setText(am.t(this.cOu.aNy.getGodUserData().getIntro(), 6));
                }
                this.cOt.a(this.cOu.aNy);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.r(this.cLm, d.C0108d.cp_cont_b);
            aj.r(this.cOr, d.C0108d.cp_cont_d);
            if (this.cOs != null) {
                this.cOs.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
