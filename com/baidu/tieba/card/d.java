package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.horizonalList.widget.f {
    public BarImageView cVC;
    public TextView cVD;
    public EntelechyUserLikeButton cVE;
    private com.baidu.tieba.card.data.e cVF;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.cVC = null;
        this.cVD = null;
        this.cVE = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar != null && (dVar instanceof com.baidu.tieba.card.data.e)) {
            this.cVF = (com.baidu.tieba.card.data.e) dVar;
            this.cVC.setTag(this.cVF.forumAvatar);
            this.cVC.setTag(d.g.tag_forum_name, this.cVF.forumName);
            this.cVC.startLoad(this.cVF.forumAvatar, 15, false);
            this.cVD.setText(am.getFixedText(this.cVF.forumName, 4, true) + getView().getContext().getResources().getString(d.j.forum));
            this.cVD.setTag(d.g.tag_forum_name, this.cVF.forumName);
            this.cVE.setTag(d.g.tag_forum_id, Long.valueOf(this.cVF.forumId));
            this.cVE.setTag(d.g.tag_forum_name, this.cVF.forumName);
            getView().setTag(d.g.tag_forum_id, Long.valueOf(this.cVF.forumId));
            getView().setTag(d.g.tag_forum_name, this.cVF.forumName);
            a(this.cVE, this.cVF.isLiked);
            this.cVC.setOnClickListener(this.blT);
            this.cVE.setOnClickListener(this.blT);
            this.cVD.setOnClickListener(this.blT);
            getView().setOnClickListener(this.blT);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f bz(View view) {
        d dVar = new d(view);
        dVar.cVC = (BarImageView) view.findViewById(d.g.forum_avatar);
        dVar.cVC.setGifIconSupport(false);
        dVar.cVD = (TextView) view.findViewById(d.g.m_forum_name_textview);
        dVar.cVE = (EntelechyUserLikeButton) view.findViewById(d.g.forum_add_love);
        dVar.emZ = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.t(getView(), d.C0141d.cp_bg_line_d);
            aj.r(this.cVD, d.C0141d.cp_cont_b);
            a(this.cVE, this.cVF.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(d.g.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.bz(z);
        }
    }
}
