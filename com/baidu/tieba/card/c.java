package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.horizonalList.widget.n {
    public BarImageView bkB;
    public TextView bkC;
    public EntelechyUserLikeButton bkD;
    private com.baidu.tieba.card.data.e bkE;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.bkB = null;
        this.bkC = null;
        this.bkD = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void a(com.baidu.tieba.horizonalList.widget.l lVar) {
        if (lVar != null && (lVar instanceof com.baidu.tieba.card.data.e)) {
            this.bkE = (com.baidu.tieba.card.data.e) lVar;
            this.bkB.setTag(this.bkE.forumAvatar);
            this.bkB.setTag(r.h.tag_forum_name, this.bkE.forumName);
            this.bkB.c(this.bkE.forumAvatar, 15, false);
            this.bkC.setText(String.valueOf(com.baidu.tbadk.core.util.at.getFixedText(this.bkE.forumName, 4, true)) + getView().getContext().getResources().getString(r.l.forum));
            this.bkC.setTag(r.h.tag_forum_name, this.bkE.forumName);
            this.bkD.setTag(r.h.tag_forum_id, Long.valueOf(this.bkE.forumId));
            this.bkD.setTag(r.h.tag_forum_name, this.bkE.forumName);
            getView().setTag(r.h.tag_forum_id, Long.valueOf(this.bkE.forumId));
            getView().setTag(r.h.tag_forum_name, this.bkE.forumName);
            a(this.bkD, this.bkE.isLiked);
            this.bkB.setOnClickListener(this.ani);
            this.bkD.setOnClickListener(this.ani);
            this.bkC.setOnClickListener(this.ani);
            getView().setOnClickListener(this.ani);
        }
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public com.baidu.tieba.horizonalList.widget.n X(View view) {
        c cVar = new c(view);
        cVar.bkB = (BarImageView) view.findViewById(r.h.forum_avatar);
        cVar.bkB.setGifIconSupport(false);
        cVar.bkC = (TextView) view.findViewById(r.h.m_forum_name_textview);
        cVar.bkD = (EntelechyUserLikeButton) view.findViewById(r.h.forum_add_love);
        cVar.cEy = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.k(getView(), r.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.ap.i((View) this.bkC, r.e.cp_cont_b);
            a(this.bkD, this.bkE.isLiked);
        }
        this.mSkinType = i;
    }

    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(r.h.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.aP(z);
        }
    }
}
