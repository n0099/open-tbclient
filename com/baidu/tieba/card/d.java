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
    public BarImageView bKp;
    public TextView bKq;
    public EntelechyUserLikeButton bKr;
    private com.baidu.tieba.card.data.e bKs;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.bKp = null;
        this.bKq = null;
        this.bKr = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar != null && (dVar instanceof com.baidu.tieba.card.data.e)) {
            this.bKs = (com.baidu.tieba.card.data.e) dVar;
            this.bKp.setTag(this.bKs.forumAvatar);
            this.bKp.setTag(d.h.tag_forum_name, this.bKs.forumName);
            this.bKp.c(this.bKs.forumAvatar, 15, false);
            this.bKq.setText(am.getFixedText(this.bKs.forumName, 4, true) + getView().getContext().getResources().getString(d.l.forum));
            this.bKq.setTag(d.h.tag_forum_name, this.bKs.forumName);
            this.bKr.setTag(d.h.tag_forum_id, Long.valueOf(this.bKs.forumId));
            this.bKr.setTag(d.h.tag_forum_name, this.bKs.forumName);
            getView().setTag(d.h.tag_forum_id, Long.valueOf(this.bKs.forumId));
            getView().setTag(d.h.tag_forum_name, this.bKs.forumName);
            a(this.bKr, this.bKs.isLiked);
            this.bKp.setOnClickListener(this.avg);
            this.bKr.setOnClickListener(this.avg);
            this.bKq.setOnClickListener(this.avg);
            getView().setOnClickListener(this.avg);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f ac(View view) {
        d dVar = new d(view);
        dVar.bKp = (BarImageView) view.findViewById(d.h.forum_avatar);
        dVar.bKp.setGifIconSupport(false);
        dVar.bKq = (TextView) view.findViewById(d.h.m_forum_name_textview);
        dVar.bKr = (EntelechyUserLikeButton) view.findViewById(d.h.forum_add_love);
        dVar.dhO = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.k(getView(), d.e.cp_bg_line_d);
            aj.i(this.bKq, d.e.cp_cont_b);
            a(this.bKr, this.bKs.isLiked);
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
