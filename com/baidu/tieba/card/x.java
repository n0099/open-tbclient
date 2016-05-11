package com.baidu.tieba.card;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.UserLikeButton;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class x extends com.baidu.tieba.horizonalList.widget.n {
    public TextView aLz;
    private com.baidu.tieba.card.a.k aPA;
    public ClickableHeaderImageView aPx;
    public TextView aPy;
    public UserLikeButton aPz;
    private BdUniqueId atA;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public x(View view, Context context) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new y(this);
        this.mContext = context;
        this.aPx = (ClickableHeaderImageView) view.findViewById(t.g.rec_god_item_header);
        this.aPx.setGodIconMargin(t.e.ds6);
        this.aLz = (TextView) view.findViewById(t.g.rec_god_item_user_name);
        this.aPy = (TextView) view.findViewById(t.g.rec_god_item_user_describe);
        this.aPz = (UserLikeButton) view.findViewById(t.g.rec_god_item_user_like_btn);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.atA = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public com.baidu.tieba.horizonalList.widget.n S(View view) {
        x xVar = new x(view, this.mContext);
        xVar.aPz.i(this.atA);
        return xVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void a(com.baidu.tieba.horizonalList.widget.l lVar) {
        if (lVar instanceof com.baidu.tieba.card.a.k) {
            this.aPA = (com.baidu.tieba.card.a.k) lVar;
            if (this.aPA.author != null) {
                getView().setTag(t.g.rec_god_item_root, this.aPA.author.getUserId());
                this.aPx.setTag(t.g.rec_god_item_root, this.aPA.author.getUserId());
                this.aPz.setTag(this.aPA.author);
                this.aPx.setData(this.aPA.author);
                this.aPx.setAfterClickListener(this.ajv);
                this.aLz.setText(com.baidu.tbadk.core.util.ay.t(this.aPA.author.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.aPA.author.getGodUserData() != null) {
                    this.aPy.setText(com.baidu.tbadk.core.util.ay.t(this.aPA.author.getGodUserData().getIntro(), 6));
                }
                this.aPz.setData(this.aPA.author);
                this.aPz.setAfterClickListener(this.ajv);
                onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.j((View) this.aLz, t.d.cp_cont_b);
            com.baidu.tbadk.core.util.at.j((View) this.aPy, t.d.cp_cont_d);
        }
        this.mSkinType = i;
    }
}
