package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.horizonalList.widget.f {
    public BarImageView bGE;
    public TextView bGF;
    public EntelechyUserLikeButton bGG;
    private com.baidu.tieba.card.data.e bGH;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.bGE = null;
        this.bGF = null;
        this.bGG = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar != null && (dVar instanceof com.baidu.tieba.card.data.e)) {
            this.bGH = (com.baidu.tieba.card.data.e) dVar;
            this.bGE.setTag(this.bGH.forumAvatar);
            this.bGE.setTag(d.h.tag_forum_name, this.bGH.forumName);
            this.bGE.c(this.bGH.forumAvatar, 15, false);
            this.bGF.setText(al.getFixedText(this.bGH.forumName, 4, true) + getView().getContext().getResources().getString(d.l.forum));
            this.bGF.setTag(d.h.tag_forum_name, this.bGH.forumName);
            this.bGG.setTag(d.h.tag_forum_id, Long.valueOf(this.bGH.forumId));
            this.bGG.setTag(d.h.tag_forum_name, this.bGH.forumName);
            getView().setTag(d.h.tag_forum_id, Long.valueOf(this.bGH.forumId));
            getView().setTag(d.h.tag_forum_name, this.bGH.forumName);
            a(this.bGG, this.bGH.isLiked);
            this.bGE.setOnClickListener(this.avX);
            this.bGG.setOnClickListener(this.avX);
            this.bGF.setOnClickListener(this.avX);
            getView().setOnClickListener(this.avX);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f U(View view) {
        d dVar = new d(view);
        dVar.bGE = (BarImageView) view.findViewById(d.h.forum_avatar);
        dVar.bGE.setGifIconSupport(false);
        dVar.bGF = (TextView) view.findViewById(d.h.m_forum_name_textview);
        dVar.bGG = (EntelechyUserLikeButton) view.findViewById(d.h.forum_add_love);
        dVar.dal = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ai.k(getView(), d.e.cp_bg_line_d);
            ai.i(this.bGF, d.e.cp_cont_b);
            a(this.bGG, this.bGH.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(d.h.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.aQ(z);
        }
    }
}
