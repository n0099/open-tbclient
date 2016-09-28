package com.baidu.tieba.card;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.UserLikeButton;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.horizonalList.widget.n {
    public TextView aVU;
    public ClickableHeaderImageView aZr;
    public TextView aZs;
    public UserLikeButton aZt;
    private com.baidu.tieba.card.data.l aZu;
    private BdUniqueId ahL;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public p(View view, Context context) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new q(this);
        this.mContext = context;
        this.aZr = (ClickableHeaderImageView) view.findViewById(r.g.rec_god_item_header);
        this.aZr.setGodIconMargin(r.e.ds6);
        this.aVU = (TextView) view.findViewById(r.g.rec_god_item_user_name);
        this.aZs = (TextView) view.findViewById(r.g.rec_god_item_user_describe);
        this.aZt = (UserLikeButton) view.findViewById(r.g.rec_god_item_user_like_btn);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ahL = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public com.baidu.tieba.horizonalList.widget.n S(View view) {
        p pVar = new p(view, this.mContext);
        pVar.aZt.i(this.ahL);
        return pVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void a(com.baidu.tieba.horizonalList.widget.l lVar) {
        if (lVar instanceof com.baidu.tieba.card.data.l) {
            this.aZu = (com.baidu.tieba.card.data.l) lVar;
            if (this.aZu.author != null) {
                getView().setTag(r.g.rec_god_item_root, this.aZu.author.getUserId());
                this.aZr.setTag(r.g.rec_god_item_root, this.aZu.author.getUserId());
                this.aZt.setTag(this.aZu.author);
                this.aZr.setData(this.aZu.author);
                this.aZr.setAfterClickListener(this.anF);
                this.aVU.setText(com.baidu.tbadk.core.util.az.t(this.aZu.author.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.aZu.author.getGodUserData() != null) {
                    this.aZs.setText(com.baidu.tbadk.core.util.az.t(this.aZu.author.getGodUserData().getIntro(), 6));
                }
                this.aZt.setData(this.aZu.author);
                this.aZt.setAfterClickListener(this.anF);
                onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.j((View) this.aVU, r.d.cp_cont_b);
            com.baidu.tbadk.core.util.av.j((View) this.aZs, r.d.cp_cont_d);
            if (this.aZt != null) {
                this.aZt.tx();
            }
        }
        this.mSkinType = i;
    }
}
