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
    public TextView bGp;
    public ClickableHeaderImageView cnX;
    public TextView cnY;
    public EntelechyUserLikeButton cnZ;
    private com.baidu.tbadk.core.view.userLike.c coa;
    private com.baidu.tieba.card.data.i cob;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public l(View view2, TbPageContext tbPageContext) {
        super(view2);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (l.this.cob != null && l.this.cob.aae != null && !StringUtils.isNull(l.this.cob.aae.getName_show()) && !StringUtils.isNull(l.this.cob.aae.getUserId())) {
                    if (l.this.axG != null) {
                        l.this.axG.onClick(view3);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(l.this.adf.getPageActivity(), l.this.cob.aae.getUserId(), l.this.cob.aae.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.adf = tbPageContext;
        this.cnX = (ClickableHeaderImageView) view2.findViewById(d.g.rec_god_item_header);
        this.cnX.setGodIconMargin(d.e.ds6);
        this.bGp = (TextView) view2.findViewById(d.g.rec_god_item_user_name);
        this.cnY = (TextView) view2.findViewById(d.g.rec_god_item_user_describe);
        this.cnZ = (EntelechyUserLikeButton) view2.findViewById(d.g.rec_god_item_user_like_btn);
        this.coa = new com.baidu.tbadk.core.view.userLike.c(this.adf, this.cnZ);
        this.coa.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ad(View view2) {
        l lVar = new l(view2, this.adf);
        lVar.coa.h(this.uniqueId);
        return lVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.cob = (com.baidu.tieba.card.data.i) cVar;
            if (this.cob.aae != null) {
                getView().setTag(d.g.rec_god_item_root, this.cob.aae.getUserId());
                this.cnX.setTag(d.g.rec_god_item_root, this.cob.aae.getUserId());
                this.cnZ.setTag(this.cob.aae);
                this.cnX.setData(this.cob.aae);
                this.cnX.setAfterClickListener(this.axG);
                this.bGp.setText(an.t(this.cob.aae.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.cob.aae.getGodUserData() != null) {
                    this.cnY.setText(an.t(this.cob.aae.getGodUserData().getIntro(), 6));
                }
                this.coa.a(this.cob.aae);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.h(this.bGp, d.C0126d.cp_cont_b);
            ak.h(this.cnY, d.C0126d.cp_cont_d);
            if (this.cnZ != null) {
                this.cnZ.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
