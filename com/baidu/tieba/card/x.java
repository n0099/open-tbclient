package com.baidu.tieba.card;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.UserLikeButton;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class x extends com.baidu.tieba.horizonalList.widget.n {
    public TextView aOX;
    public ClickableHeaderImageView aST;
    public TextView aSU;
    public UserLikeButton aSV;
    private com.baidu.tieba.card.a.l aSW;
    private BdUniqueId aeu;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public x(View view, Context context) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new y(this);
        this.mContext = context;
        this.aST = (ClickableHeaderImageView) view.findViewById(u.g.rec_god_item_header);
        this.aST.setGodIconMargin(u.e.ds6);
        this.aOX = (TextView) view.findViewById(u.g.rec_god_item_user_name);
        this.aSU = (TextView) view.findViewById(u.g.rec_god_item_user_describe);
        this.aSV = (UserLikeButton) view.findViewById(u.g.rec_god_item_user_like_btn);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aeu = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public com.baidu.tieba.horizonalList.widget.n T(View view) {
        x xVar = new x(view, this.mContext);
        xVar.aSV.i(this.aeu);
        return xVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void a(com.baidu.tieba.horizonalList.widget.l lVar) {
        if (lVar instanceof com.baidu.tieba.card.a.l) {
            this.aSW = (com.baidu.tieba.card.a.l) lVar;
            if (this.aSW.author != null) {
                getView().setTag(u.g.rec_god_item_root, this.aSW.author.getUserId());
                this.aST.setTag(u.g.rec_god_item_root, this.aSW.author.getUserId());
                this.aSV.setTag(this.aSW.author);
                this.aST.setData(this.aSW.author);
                this.aST.setAfterClickListener(this.akb);
                this.aOX.setText(com.baidu.tbadk.core.util.ba.t(this.aSW.author.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.aSW.author.getGodUserData() != null) {
                    this.aSU.setText(com.baidu.tbadk.core.util.ba.t(this.aSW.author.getGodUserData().getIntro(), 6));
                }
                this.aSV.setData(this.aSW.author);
                this.aSV.setAfterClickListener(this.akb);
                onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.j((View) this.aOX, u.d.cp_cont_b);
            com.baidu.tbadk.core.util.av.j((View) this.aSU, u.d.cp_cont_d);
        }
        this.mSkinType = i;
    }
}
