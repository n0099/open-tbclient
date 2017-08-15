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
    public BarImageView bGD;
    public TextView bGE;
    public EntelechyUserLikeButton bGF;
    private com.baidu.tieba.card.data.e bGG;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.bGD = null;
        this.bGE = null;
        this.bGF = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar != null && (dVar instanceof com.baidu.tieba.card.data.e)) {
            this.bGG = (com.baidu.tieba.card.data.e) dVar;
            this.bGD.setTag(this.bGG.forumAvatar);
            this.bGD.setTag(d.h.tag_forum_name, this.bGG.forumName);
            this.bGD.c(this.bGG.forumAvatar, 15, false);
            this.bGE.setText(al.getFixedText(this.bGG.forumName, 4, true) + getView().getContext().getResources().getString(d.l.forum));
            this.bGE.setTag(d.h.tag_forum_name, this.bGG.forumName);
            this.bGF.setTag(d.h.tag_forum_id, Long.valueOf(this.bGG.forumId));
            this.bGF.setTag(d.h.tag_forum_name, this.bGG.forumName);
            getView().setTag(d.h.tag_forum_id, Long.valueOf(this.bGG.forumId));
            getView().setTag(d.h.tag_forum_name, this.bGG.forumName);
            a(this.bGF, this.bGG.isLiked);
            this.bGD.setOnClickListener(this.avW);
            this.bGF.setOnClickListener(this.avW);
            this.bGE.setOnClickListener(this.avW);
            getView().setOnClickListener(this.avW);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f V(View view) {
        d dVar = new d(view);
        dVar.bGD = (BarImageView) view.findViewById(d.h.forum_avatar);
        dVar.bGD.setGifIconSupport(false);
        dVar.bGE = (TextView) view.findViewById(d.h.m_forum_name_textview);
        dVar.bGF = (EntelechyUserLikeButton) view.findViewById(d.h.forum_add_love);
        dVar.dal = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ai.k(getView(), d.e.cp_bg_line_d);
            ai.i(this.bGE, d.e.cp_cont_b);
            a(this.bGF, this.bGG.isLiked);
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
