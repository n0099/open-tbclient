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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class l extends com.baidu.tieba.horizonalList.widget.e {
    private TbPageContext adf;
    public TextView bGo;
    public ClickableHeaderImageView cnU;
    public TextView cnV;
    public EntelechyUserLikeButton cnW;
    private com.baidu.tbadk.core.view.userLike.c cnX;
    private com.baidu.tieba.card.data.i cnY;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public l(View view2, TbPageContext tbPageContext) {
        super(view2);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (l.this.cnY != null && l.this.cnY.aae != null && !StringUtils.isNull(l.this.cnY.aae.getName_show()) && !StringUtils.isNull(l.this.cnY.aae.getUserId())) {
                    if (l.this.axG != null) {
                        l.this.axG.onClick(view3);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(l.this.adf.getPageActivity(), l.this.cnY.aae.getUserId(), l.this.cnY.aae.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.adf = tbPageContext;
        this.cnU = (ClickableHeaderImageView) view2.findViewById(d.g.rec_god_item_header);
        this.cnU.setGodIconMargin(d.e.ds6);
        this.bGo = (TextView) view2.findViewById(d.g.rec_god_item_user_name);
        this.cnV = (TextView) view2.findViewById(d.g.rec_god_item_user_describe);
        this.cnW = (EntelechyUserLikeButton) view2.findViewById(d.g.rec_god_item_user_like_btn);
        this.cnX = new com.baidu.tbadk.core.view.userLike.c(this.adf, this.cnW);
        this.cnX.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ad(View view2) {
        l lVar = new l(view2, this.adf);
        lVar.cnX.h(this.uniqueId);
        return lVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.cnY = (com.baidu.tieba.card.data.i) cVar;
            if (this.cnY.aae != null) {
                getView().setTag(d.g.rec_god_item_root, this.cnY.aae.getUserId());
                this.cnU.setTag(d.g.rec_god_item_root, this.cnY.aae.getUserId());
                this.cnW.setTag(this.cnY.aae);
                this.cnU.setData(this.cnY.aae);
                this.cnU.setAfterClickListener(this.axG);
                this.bGo.setText(an.t(this.cnY.aae.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.cnY.aae.getGodUserData() != null) {
                    this.cnV.setText(an.t(this.cnY.aae.getGodUserData().getIntro(), 6));
                }
                this.cnX.a(this.cnY.aae);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.h(this.bGo, d.C0126d.cp_cont_b);
            ak.h(this.cnV, d.C0126d.cp_cont_d);
            if (this.cnW != null) {
                this.cnW.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
