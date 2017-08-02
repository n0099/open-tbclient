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
    public BarImageView bEK;
    public TextView bEL;
    public EntelechyUserLikeButton bEM;
    private com.baidu.tieba.card.data.e bEN;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.bEK = null;
        this.bEL = null;
        this.bEM = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar != null && (dVar instanceof com.baidu.tieba.card.data.e)) {
            this.bEN = (com.baidu.tieba.card.data.e) dVar;
            this.bEK.setTag(this.bEN.forumAvatar);
            this.bEK.setTag(d.h.tag_forum_name, this.bEN.forumName);
            this.bEK.c(this.bEN.forumAvatar, 15, false);
            this.bEL.setText(al.getFixedText(this.bEN.forumName, 4, true) + getView().getContext().getResources().getString(d.l.forum));
            this.bEL.setTag(d.h.tag_forum_name, this.bEN.forumName);
            this.bEM.setTag(d.h.tag_forum_id, Long.valueOf(this.bEN.forumId));
            this.bEM.setTag(d.h.tag_forum_name, this.bEN.forumName);
            getView().setTag(d.h.tag_forum_id, Long.valueOf(this.bEN.forumId));
            getView().setTag(d.h.tag_forum_name, this.bEN.forumName);
            a(this.bEM, this.bEN.isLiked);
            this.bEK.setOnClickListener(this.auE);
            this.bEM.setOnClickListener(this.auE);
            this.bEL.setOnClickListener(this.auE);
            getView().setOnClickListener(this.auE);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f V(View view) {
        d dVar = new d(view);
        dVar.bEK = (BarImageView) view.findViewById(d.h.forum_avatar);
        dVar.bEK.setGifIconSupport(false);
        dVar.bEL = (TextView) view.findViewById(d.h.m_forum_name_textview);
        dVar.bEM = (EntelechyUserLikeButton) view.findViewById(d.h.forum_add_love);
        dVar.cWT = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ai.k(getView(), d.e.cp_bg_line_d);
            ai.i(this.bEL, d.e.cp_cont_b);
            a(this.bEM, this.bEN.isLiked);
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
