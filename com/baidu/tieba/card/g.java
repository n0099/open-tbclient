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
    private TbPageContext aby;
    public TextView bFC;
    public ClickableHeaderImageView bKL;
    public TextView bKM;
    public EntelechyUserLikeButton bKN;
    private com.baidu.tbadk.core.view.userLike.c bKO;
    private com.baidu.tieba.card.data.i bKP;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public g(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.bKP != null && g.this.bKP.author != null && !StringUtils.isNull(g.this.bKP.author.getName_show()) && !StringUtils.isNull(g.this.bKP.author.getUserId())) {
                    if (g.this.avg != null) {
                        g.this.avg.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(g.this.aby.getPageActivity(), g.this.bKP.author.getUserId(), g.this.bKP.author.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.aby = tbPageContext;
        this.bKL = (ClickableHeaderImageView) view.findViewById(d.h.rec_god_item_header);
        this.bKL.setGodIconMargin(d.f.ds6);
        this.bFC = (TextView) view.findViewById(d.h.rec_god_item_user_name);
        this.bKM = (TextView) view.findViewById(d.h.rec_god_item_user_describe);
        this.bKN = (EntelechyUserLikeButton) view.findViewById(d.h.rec_god_item_user_like_btn);
        this.bKO = new com.baidu.tbadk.core.view.userLike.c(this.aby, this.bKN);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f ac(View view) {
        g gVar = new g(view, this.aby);
        gVar.bKO.i(this.uniqueId);
        return gVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar instanceof com.baidu.tieba.card.data.i) {
            this.bKP = (com.baidu.tieba.card.data.i) dVar;
            if (this.bKP.author != null) {
                getView().setTag(d.h.rec_god_item_root, this.bKP.author.getUserId());
                this.bKL.setTag(d.h.rec_god_item_root, this.bKP.author.getUserId());
                this.bKN.setTag(this.bKP.author);
                this.bKL.setData(this.bKP.author);
                this.bKL.setAfterClickListener(this.avg);
                this.bFC.setText(am.t(this.bKP.author.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.bKP.author.getGodUserData() != null) {
                    this.bKM.setText(am.t(this.bKP.author.getGodUserData().getIntro(), 6));
                }
                this.bKO.a(this.bKP.author);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.i(this.bFC, d.e.cp_cont_b);
            aj.i(this.bKM, d.e.cp_cont_d);
            if (this.bKN != null) {
                this.bKN.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
