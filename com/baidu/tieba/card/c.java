package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.horizonalList.widget.n {
    public BarImageView btD;
    public TextView btE;
    public EntelechyUserLikeButton btF;
    private com.baidu.tieba.card.data.e btG;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.btD = null;
        this.btE = null;
        this.btF = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void a(com.baidu.tieba.horizonalList.widget.l lVar) {
        if (lVar != null && (lVar instanceof com.baidu.tieba.card.data.e)) {
            this.btG = (com.baidu.tieba.card.data.e) lVar;
            this.btD.setTag(this.btG.forumAvatar);
            this.btD.setTag(w.h.tag_forum_name, this.btG.forumName);
            this.btD.c(this.btG.forumAvatar, 15, false);
            this.btE.setText(String.valueOf(com.baidu.tbadk.core.util.au.getFixedText(this.btG.forumName, 4, true)) + getView().getContext().getResources().getString(w.l.forum));
            this.btE.setTag(w.h.tag_forum_name, this.btG.forumName);
            this.btF.setTag(w.h.tag_forum_id, Long.valueOf(this.btG.forumId));
            this.btF.setTag(w.h.tag_forum_name, this.btG.forumName);
            getView().setTag(w.h.tag_forum_id, Long.valueOf(this.btG.forumId));
            getView().setTag(w.h.tag_forum_name, this.btG.forumName);
            a(this.btF, this.btG.isLiked);
            this.btD.setOnClickListener(this.asV);
            this.btF.setOnClickListener(this.asV);
            this.btE.setOnClickListener(this.asV);
            getView().setOnClickListener(this.asV);
        }
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public com.baidu.tieba.horizonalList.widget.n V(View view) {
        c cVar = new c(view);
        cVar.btD = (BarImageView) view.findViewById(w.h.forum_avatar);
        cVar.btD.setGifIconSupport(false);
        cVar.btE = (TextView) view.findViewById(w.h.m_forum_name_textview);
        cVar.btF = (EntelechyUserLikeButton) view.findViewById(w.h.forum_add_love);
        cVar.cGK = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.k(getView(), w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.i(this.btE, w.e.cp_cont_b);
            a(this.btF, this.btG.isLiked);
        }
        this.mSkinType = i;
    }

    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(w.h.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.aQ(z);
        }
    }
}
