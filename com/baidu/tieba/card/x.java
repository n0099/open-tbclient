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
    public TextView aPR;
    public ClickableHeaderImageView aTP;
    public TextView aTQ;
    public UserLikeButton aTR;
    private com.baidu.tieba.card.a.l aTS;
    private BdUniqueId afi;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public x(View view, Context context) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new y(this);
        this.mContext = context;
        this.aTP = (ClickableHeaderImageView) view.findViewById(u.g.rec_god_item_header);
        this.aTP.setGodIconMargin(u.e.ds6);
        this.aPR = (TextView) view.findViewById(u.g.rec_god_item_user_name);
        this.aTQ = (TextView) view.findViewById(u.g.rec_god_item_user_describe);
        this.aTR = (UserLikeButton) view.findViewById(u.g.rec_god_item_user_like_btn);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.afi = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public com.baidu.tieba.horizonalList.widget.n T(View view) {
        x xVar = new x(view, this.mContext);
        xVar.aTR.i(this.afi);
        return xVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void a(com.baidu.tieba.horizonalList.widget.l lVar) {
        if (lVar instanceof com.baidu.tieba.card.a.l) {
            this.aTS = (com.baidu.tieba.card.a.l) lVar;
            if (this.aTS.author != null) {
                getView().setTag(u.g.rec_god_item_root, this.aTS.author.getUserId());
                this.aTP.setTag(u.g.rec_god_item_root, this.aTS.author.getUserId());
                this.aTR.setTag(this.aTS.author);
                this.aTP.setData(this.aTS.author);
                this.aTP.setAfterClickListener(this.akQ);
                this.aPR.setText(com.baidu.tbadk.core.util.ba.t(this.aTS.author.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.aTS.author.getGodUserData() != null) {
                    this.aTQ.setText(com.baidu.tbadk.core.util.ba.t(this.aTS.author.getGodUserData().getIntro(), 6));
                }
                this.aTR.setData(this.aTS.author);
                this.aTR.setAfterClickListener(this.akQ);
                onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.j((View) this.aPR, u.d.cp_cont_b);
            com.baidu.tbadk.core.util.av.j((View) this.aTQ, u.d.cp_cont_d);
            if (this.aTR != null) {
                this.aTR.sd();
            }
        }
        this.mSkinType = i;
    }
}
