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
public class r extends com.baidu.tieba.horizonalList.widget.n {
    public TextView aVl;
    public ClickableHeaderImageView aYX;
    public TextView aYY;
    public UserLikeButton aYZ;
    private com.baidu.tieba.card.data.l aZa;
    private BdUniqueId aid;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public r(View view, Context context) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new s(this);
        this.mContext = context;
        this.aYX = (ClickableHeaderImageView) view.findViewById(t.g.rec_god_item_header);
        this.aYX.setGodIconMargin(t.e.ds6);
        this.aVl = (TextView) view.findViewById(t.g.rec_god_item_user_name);
        this.aYY = (TextView) view.findViewById(t.g.rec_god_item_user_describe);
        this.aYZ = (UserLikeButton) view.findViewById(t.g.rec_god_item_user_like_btn);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aid = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public com.baidu.tieba.horizonalList.widget.n S(View view) {
        r rVar = new r(view, this.mContext);
        rVar.aYZ.i(this.aid);
        return rVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void a(com.baidu.tieba.horizonalList.widget.l lVar) {
        if (lVar instanceof com.baidu.tieba.card.data.l) {
            this.aZa = (com.baidu.tieba.card.data.l) lVar;
            if (this.aZa.author != null) {
                getView().setTag(t.g.rec_god_item_root, this.aZa.author.getUserId());
                this.aYX.setTag(t.g.rec_god_item_root, this.aZa.author.getUserId());
                this.aYZ.setTag(this.aZa.author);
                this.aYX.setData(this.aZa.author);
                this.aYX.setAfterClickListener(this.anX);
                this.aVl.setText(com.baidu.tbadk.core.util.ba.t(this.aZa.author.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.aZa.author.getGodUserData() != null) {
                    this.aYY.setText(com.baidu.tbadk.core.util.ba.t(this.aZa.author.getGodUserData().getIntro(), 6));
                }
                this.aYZ.setData(this.aZa.author);
                this.aYZ.setAfterClickListener(this.anX);
                onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.j((View) this.aVl, t.d.cp_cont_b);
            com.baidu.tbadk.core.util.av.j((View) this.aYY, t.d.cp_cont_d);
            if (this.aYZ != null) {
                this.aYZ.ti();
            }
        }
        this.mSkinType = i;
    }
}
