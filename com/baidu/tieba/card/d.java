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
    public BarImageView bFU;
    public TextView bFV;
    public EntelechyUserLikeButton bFW;
    private com.baidu.tieba.card.data.e bFX;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.bFU = null;
        this.bFV = null;
        this.bFW = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar != null && (dVar instanceof com.baidu.tieba.card.data.e)) {
            this.bFX = (com.baidu.tieba.card.data.e) dVar;
            this.bFU.setTag(this.bFX.forumAvatar);
            this.bFU.setTag(d.h.tag_forum_name, this.bFX.forumName);
            this.bFU.c(this.bFX.forumAvatar, 15, false);
            this.bFV.setText(al.getFixedText(this.bFX.forumName, 4, true) + getView().getContext().getResources().getString(d.l.forum));
            this.bFV.setTag(d.h.tag_forum_name, this.bFX.forumName);
            this.bFW.setTag(d.h.tag_forum_id, Long.valueOf(this.bFX.forumId));
            this.bFW.setTag(d.h.tag_forum_name, this.bFX.forumName);
            getView().setTag(d.h.tag_forum_id, Long.valueOf(this.bFX.forumId));
            getView().setTag(d.h.tag_forum_name, this.bFX.forumName);
            a(this.bFW, this.bFX.isLiked);
            this.bFU.setOnClickListener(this.avV);
            this.bFW.setOnClickListener(this.avV);
            this.bFV.setOnClickListener(this.avV);
            getView().setOnClickListener(this.avV);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f V(View view) {
        d dVar = new d(view);
        dVar.bFU = (BarImageView) view.findViewById(d.h.forum_avatar);
        dVar.bFU.setGifIconSupport(false);
        dVar.bFV = (TextView) view.findViewById(d.h.m_forum_name_textview);
        dVar.bFW = (EntelechyUserLikeButton) view.findViewById(d.h.forum_add_love);
        dVar.cYm = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ai.k(getView(), d.e.cp_bg_line_d);
            ai.i(this.bFV, d.e.cp_cont_b);
            a(this.bFW, this.bFX.isLiked);
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
