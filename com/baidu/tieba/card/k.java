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
    public TextView eeB;
    public ClickableHeaderImageView ehh;
    public TextView ehi;
    public EntelechyUserLikeButton ehj;
    private com.baidu.tbadk.core.view.userLike.c ehk;
    private com.baidu.tieba.card.data.i ehl;
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
                if (k.this.ehl != null && k.this.ehl.bBK != null && !StringUtils.isNull(k.this.ehl.bBK.getName_show()) && !StringUtils.isNull(k.this.ehl.bBK.getUserId())) {
                    if (k.this.ccD != null) {
                        k.this.ccD.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(k.this.mContext.getPageActivity(), k.this.ehl.bBK.getUserId(), k.this.ehl.bBK.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mContext = tbPageContext;
        this.ehh = (ClickableHeaderImageView) view.findViewById(d.g.rec_god_item_header);
        this.ehh.setGodIconMargin(d.e.ds6);
        this.eeB = (TextView) view.findViewById(d.g.rec_god_item_user_name);
        this.ehi = (TextView) view.findViewById(d.g.rec_god_item_user_describe);
        this.ehj = (EntelechyUserLikeButton) view.findViewById(d.g.rec_god_item_user_like_btn);
        this.ehk = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.ehj);
        this.ehk.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bv(View view) {
        k kVar = new k(view, this.mContext);
        kVar.ehk.i(this.uniqueId);
        return kVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.ehl = (com.baidu.tieba.card.data.i) cVar;
            if (this.ehl.bBK != null) {
                getView().setTag(d.g.rec_god_item_root, this.ehl.bBK.getUserId());
                this.ehh.setTag(d.g.rec_god_item_root, this.ehl.bBK.getUserId());
                this.ehj.setTag(this.ehl.bBK);
                this.ehh.setData(this.ehl.bBK);
                this.ehh.setAfterClickListener(this.ccD);
                this.eeB.setText(ap.V(this.ehl.bBK.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.ehl.bBK.getGodUserData() != null) {
                    this.ehi.setText(ap.V(this.ehl.bBK.getGodUserData().getIntro(), 6));
                }
                this.ehk.a(this.ehl.bBK);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.j(this.eeB, d.C0277d.cp_cont_b);
            al.j(this.ehi, d.C0277d.cp_cont_d);
            if (this.ehj != null) {
                this.ehj.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
