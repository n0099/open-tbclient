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
public class ai extends com.baidu.tieba.horizonalList.widget.n {
    public TextView aPp;
    public ClickableHeaderImageView aTj;
    public TextView aTk;
    public UserLikeButton aTl;
    private com.baidu.tieba.card.a.r aTm;
    private BdUniqueId axz;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public ai(View view, Context context) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new aj(this);
        this.mContext = context;
        this.aTj = (ClickableHeaderImageView) view.findViewById(t.g.rec_god_item_header);
        this.aTj.setGodIconMargin(t.e.ds6);
        this.aPp = (TextView) view.findViewById(t.g.rec_god_item_user_name);
        this.aTk = (TextView) view.findViewById(t.g.rec_god_item_user_describe);
        this.aTl = (UserLikeButton) view.findViewById(t.g.rec_god_item_user_like_btn);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.axz = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public com.baidu.tieba.horizonalList.widget.n Q(View view) {
        ai aiVar = new ai(view, this.mContext);
        aiVar.aTl.i(this.axz);
        return aiVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void a(com.baidu.tieba.horizonalList.widget.l lVar) {
        if (lVar instanceof com.baidu.tieba.card.a.r) {
            this.aTm = (com.baidu.tieba.card.a.r) lVar;
            if (this.aTm.author != null) {
                getView().setTag(t.g.rec_god_item_root, this.aTm.author.getUserId());
                this.aTj.setTag(t.g.rec_god_item_root, this.aTm.author.getUserId());
                this.aTl.setTag(this.aTm.author);
                this.aTj.setData(this.aTm.author);
                this.aTj.setAfterClickListener(this.anH);
                this.aPp.setText(com.baidu.tbadk.core.util.ay.s(this.aTm.author.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.aTm.author.getGodUserData() != null) {
                    this.aTk.setText(com.baidu.tbadk.core.util.ay.s(this.aTm.author.getGodUserData().getIntro(), 6));
                }
                this.aTl.setData(this.aTm.author);
                this.aTl.setAfterClickListener(this.anH);
                onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.j((View) this.aPp, t.d.cp_cont_b);
            com.baidu.tbadk.core.util.at.j((View) this.aTk, t.d.cp_cont_d);
        }
        this.mSkinType = i;
    }
}
