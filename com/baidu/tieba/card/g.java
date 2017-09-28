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
    private TbPageContext abz;
    public TextView bHn;
    public ClickableHeaderImageView bJY;
    public TextView bJZ;
    public EntelechyUserLikeButton bKa;
    private com.baidu.tbadk.core.view.userLike.c bKb;
    private com.baidu.tieba.card.data.i bKc;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public g(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.bKc != null && g.this.bKc.author != null && !StringUtils.isNull(g.this.bKc.author.getName_show()) && !StringUtils.isNull(g.this.bKc.author.getUserId())) {
                    if (g.this.auo != null) {
                        g.this.auo.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(g.this.abz.getPageActivity(), g.this.bKc.author.getUserId(), g.this.bKc.author.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.abz = tbPageContext;
        this.bJY = (ClickableHeaderImageView) view.findViewById(d.h.rec_god_item_header);
        this.bJY.setGodIconMargin(d.f.ds6);
        this.bHn = (TextView) view.findViewById(d.h.rec_god_item_user_name);
        this.bJZ = (TextView) view.findViewById(d.h.rec_god_item_user_describe);
        this.bKa = (EntelechyUserLikeButton) view.findViewById(d.h.rec_god_item_user_like_btn);
        this.bKb = new com.baidu.tbadk.core.view.userLike.c(this.abz, this.bKa);
        this.bKb.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f ab(View view) {
        g gVar = new g(view, this.abz);
        gVar.bKb.h(this.uniqueId);
        return gVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar instanceof com.baidu.tieba.card.data.i) {
            this.bKc = (com.baidu.tieba.card.data.i) dVar;
            if (this.bKc.author != null) {
                getView().setTag(d.h.rec_god_item_root, this.bKc.author.getUserId());
                this.bJY.setTag(d.h.rec_god_item_root, this.bKc.author.getUserId());
                this.bKa.setTag(this.bKc.author);
                this.bJY.setData(this.bKc.author);
                this.bJY.setAfterClickListener(this.auo);
                this.bHn.setText(am.t(this.bKc.author.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.bKc.author.getGodUserData() != null) {
                    this.bJZ.setText(am.t(this.bKc.author.getGodUserData().getIntro(), 6));
                }
                this.bKb.a(this.bKc.author);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.i(this.bHn, d.e.cp_cont_b);
            aj.i(this.bJZ, d.e.cp_cont_d);
            if (this.bKa != null) {
                this.bKa.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
