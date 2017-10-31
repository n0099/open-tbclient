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
    private TbPageContext abI;
    public TextView bOl;
    public ClickableHeaderImageView bRs;
    public TextView bRt;
    public EntelechyUserLikeButton bRu;
    private com.baidu.tbadk.core.view.userLike.c bRv;
    private com.baidu.tieba.card.data.i bRw;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public g(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.bRw != null && g.this.bRw.YJ != null && !StringUtils.isNull(g.this.bRw.YJ.getName_show()) && !StringUtils.isNull(g.this.bRw.YJ.getUserId())) {
                    if (g.this.auz != null) {
                        g.this.auz.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(g.this.abI.getPageActivity(), g.this.bRw.YJ.getUserId(), g.this.bRw.YJ.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.abI = tbPageContext;
        this.bRs = (ClickableHeaderImageView) view.findViewById(d.g.rec_god_item_header);
        this.bRs.setGodIconMargin(d.e.ds6);
        this.bOl = (TextView) view.findViewById(d.g.rec_god_item_user_name);
        this.bRt = (TextView) view.findViewById(d.g.rec_god_item_user_describe);
        this.bRu = (EntelechyUserLikeButton) view.findViewById(d.g.rec_god_item_user_like_btn);
        this.bRv = new com.baidu.tbadk.core.view.userLike.c(this.abI, this.bRu);
        this.bRv.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f ae(View view) {
        g gVar = new g(view, this.abI);
        gVar.bRv.h(this.uniqueId);
        return gVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar instanceof com.baidu.tieba.card.data.i) {
            this.bRw = (com.baidu.tieba.card.data.i) dVar;
            if (this.bRw.YJ != null) {
                getView().setTag(d.g.rec_god_item_root, this.bRw.YJ.getUserId());
                this.bRs.setTag(d.g.rec_god_item_root, this.bRw.YJ.getUserId());
                this.bRu.setTag(this.bRw.YJ);
                this.bRs.setData(this.bRw.YJ);
                this.bRs.setAfterClickListener(this.auz);
                this.bOl.setText(am.t(this.bRw.YJ.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.bRw.YJ.getGodUserData() != null) {
                    this.bRt.setText(am.t(this.bRw.YJ.getGodUserData().getIntro(), 6));
                }
                this.bRv.a(this.bRw.YJ);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.i(this.bOl, d.C0080d.cp_cont_b);
            aj.i(this.bRt, d.C0080d.cp_cont_d);
            if (this.bRu != null) {
                this.bRu.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
