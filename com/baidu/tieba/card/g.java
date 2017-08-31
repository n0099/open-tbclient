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
    public TextView bEL;
    public ClickableHeaderImageView bJU;
    public TextView bJV;
    public EntelechyUserLikeButton bJW;
    private com.baidu.tbadk.core.view.userLike.c bJX;
    private com.baidu.tieba.card.data.i bJY;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public g(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.bJY != null && g.this.bJY.author != null && !StringUtils.isNull(g.this.bJY.author.getName_show()) && !StringUtils.isNull(g.this.bJY.author.getUserId())) {
                    if (g.this.avj != null) {
                        g.this.avj.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(g.this.aby.getPageActivity(), g.this.bJY.author.getUserId(), g.this.bJY.author.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.aby = tbPageContext;
        this.bJU = (ClickableHeaderImageView) view.findViewById(d.h.rec_god_item_header);
        this.bJU.setGodIconMargin(d.f.ds6);
        this.bEL = (TextView) view.findViewById(d.h.rec_god_item_user_name);
        this.bJV = (TextView) view.findViewById(d.h.rec_god_item_user_describe);
        this.bJW = (EntelechyUserLikeButton) view.findViewById(d.h.rec_god_item_user_like_btn);
        this.bJX = new com.baidu.tbadk.core.view.userLike.c(this.aby, this.bJW);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f ac(View view) {
        g gVar = new g(view, this.aby);
        gVar.bJX.i(this.uniqueId);
        return gVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar instanceof com.baidu.tieba.card.data.i) {
            this.bJY = (com.baidu.tieba.card.data.i) dVar;
            if (this.bJY.author != null) {
                getView().setTag(d.h.rec_god_item_root, this.bJY.author.getUserId());
                this.bJU.setTag(d.h.rec_god_item_root, this.bJY.author.getUserId());
                this.bJW.setTag(this.bJY.author);
                this.bJU.setData(this.bJY.author);
                this.bJU.setAfterClickListener(this.avj);
                this.bEL.setText(am.t(this.bJY.author.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.bJY.author.getGodUserData() != null) {
                    this.bJV.setText(am.t(this.bJY.author.getGodUserData().getIntro(), 6));
                }
                this.bJX.a(this.bJY.author);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.i(this.bEL, d.e.cp_cont_b);
            aj.i(this.bJV, d.e.cp_cont_d);
            if (this.bJW != null) {
                this.bJW.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
