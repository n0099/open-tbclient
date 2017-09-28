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
    public BarImageView bJC;
    public TextView bJD;
    public EntelechyUserLikeButton bJE;
    private com.baidu.tieba.card.data.e bJF;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.bJC = null;
        this.bJD = null;
        this.bJE = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar != null && (dVar instanceof com.baidu.tieba.card.data.e)) {
            this.bJF = (com.baidu.tieba.card.data.e) dVar;
            this.bJC.setTag(this.bJF.forumAvatar);
            this.bJC.setTag(d.h.tag_forum_name, this.bJF.forumName);
            this.bJC.c(this.bJF.forumAvatar, 15, false);
            this.bJD.setText(am.getFixedText(this.bJF.forumName, 4, true) + getView().getContext().getResources().getString(d.l.forum));
            this.bJD.setTag(d.h.tag_forum_name, this.bJF.forumName);
            this.bJE.setTag(d.h.tag_forum_id, Long.valueOf(this.bJF.forumId));
            this.bJE.setTag(d.h.tag_forum_name, this.bJF.forumName);
            getView().setTag(d.h.tag_forum_id, Long.valueOf(this.bJF.forumId));
            getView().setTag(d.h.tag_forum_name, this.bJF.forumName);
            a(this.bJE, this.bJF.isLiked);
            this.bJC.setOnClickListener(this.auo);
            this.bJE.setOnClickListener(this.auo);
            this.bJD.setOnClickListener(this.auo);
            getView().setOnClickListener(this.auo);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f ab(View view) {
        d dVar = new d(view);
        dVar.bJC = (BarImageView) view.findViewById(d.h.forum_avatar);
        dVar.bJC.setGifIconSupport(false);
        dVar.bJD = (TextView) view.findViewById(d.h.m_forum_name_textview);
        dVar.bJE = (EntelechyUserLikeButton) view.findViewById(d.h.forum_add_love);
        dVar.deb = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.k(getView(), d.e.cp_bg_line_d);
            aj.i(this.bJD, d.e.cp_cont_b);
            a(this.bJE, this.bJF.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(d.h.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.aP(z);
        }
    }
}
