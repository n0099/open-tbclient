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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class k extends com.baidu.tieba.horizonalList.widget.e {
    public TextView eeA;
    public ClickableHeaderImageView ehg;
    public TextView ehh;
    public EntelechyUserLikeButton ehi;
    private com.baidu.tbadk.core.view.userLike.c ehj;
    private com.baidu.tieba.card.data.i ehk;
    private TbPageContext mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public k(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.ehk != null && k.this.ehk.bBJ != null && !StringUtils.isNull(k.this.ehk.bBJ.getName_show()) && !StringUtils.isNull(k.this.ehk.bBJ.getUserId())) {
                    if (k.this.ccC != null) {
                        k.this.ccC.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(k.this.mContext.getPageActivity(), k.this.ehk.bBJ.getUserId(), k.this.ehk.bBJ.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mContext = tbPageContext;
        this.ehg = (ClickableHeaderImageView) view.findViewById(d.g.rec_god_item_header);
        this.ehg.setGodIconMargin(d.e.ds6);
        this.eeA = (TextView) view.findViewById(d.g.rec_god_item_user_name);
        this.ehh = (TextView) view.findViewById(d.g.rec_god_item_user_describe);
        this.ehi = (EntelechyUserLikeButton) view.findViewById(d.g.rec_god_item_user_like_btn);
        this.ehj = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.ehi);
        this.ehj.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bv(View view) {
        k kVar = new k(view, this.mContext);
        kVar.ehj.i(this.uniqueId);
        return kVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.ehk = (com.baidu.tieba.card.data.i) cVar;
            if (this.ehk.bBJ != null) {
                getView().setTag(d.g.rec_god_item_root, this.ehk.bBJ.getUserId());
                this.ehg.setTag(d.g.rec_god_item_root, this.ehk.bBJ.getUserId());
                this.ehi.setTag(this.ehk.bBJ);
                this.ehg.setData(this.ehk.bBJ);
                this.ehg.setAfterClickListener(this.ccC);
                this.eeA.setText(ap.V(this.ehk.bBJ.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.ehk.bBJ.getGodUserData() != null) {
                    this.ehh.setText(ap.V(this.ehk.bBJ.getGodUserData().getIntro(), 6));
                }
                this.ehj.a(this.ehk.bBJ);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.j(this.eeA, d.C0277d.cp_cont_b);
            al.j(this.ehh, d.C0277d.cp_cont_d);
            if (this.ehi != null) {
                this.ehi.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
