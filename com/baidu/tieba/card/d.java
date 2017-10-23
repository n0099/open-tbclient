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
    public BarImageView bJq;
    public TextView bJr;
    public EntelechyUserLikeButton bJs;
    private com.baidu.tieba.card.data.e bJt;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.bJq = null;
        this.bJr = null;
        this.bJs = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar != null && (dVar instanceof com.baidu.tieba.card.data.e)) {
            this.bJt = (com.baidu.tieba.card.data.e) dVar;
            this.bJq.setTag(this.bJt.forumAvatar);
            this.bJq.setTag(d.h.tag_forum_name, this.bJt.forumName);
            this.bJq.c(this.bJt.forumAvatar, 15, false);
            this.bJr.setText(am.getFixedText(this.bJt.forumName, 4, true) + getView().getContext().getResources().getString(d.l.forum));
            this.bJr.setTag(d.h.tag_forum_name, this.bJt.forumName);
            this.bJs.setTag(d.h.tag_forum_id, Long.valueOf(this.bJt.forumId));
            this.bJs.setTag(d.h.tag_forum_name, this.bJt.forumName);
            getView().setTag(d.h.tag_forum_id, Long.valueOf(this.bJt.forumId));
            getView().setTag(d.h.tag_forum_name, this.bJt.forumName);
            a(this.bJs, this.bJt.isLiked);
            this.bJq.setOnClickListener(this.auc);
            this.bJs.setOnClickListener(this.auc);
            this.bJr.setOnClickListener(this.auc);
            getView().setOnClickListener(this.auc);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f ab(View view) {
        d dVar = new d(view);
        dVar.bJq = (BarImageView) view.findViewById(d.h.forum_avatar);
        dVar.bJq.setGifIconSupport(false);
        dVar.bJr = (TextView) view.findViewById(d.h.m_forum_name_textview);
        dVar.bJs = (EntelechyUserLikeButton) view.findViewById(d.h.forum_add_love);
        dVar.ddO = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.k(getView(), d.e.cp_bg_line_d);
            aj.i(this.bJr, d.e.cp_cont_b);
            a(this.bJs, this.bJt.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(d.h.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.aO(z);
        }
    }
}
