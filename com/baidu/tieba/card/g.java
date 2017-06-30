package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.horizonalList.widget.m {
    public BarImageView bAD;
    public TextView bAE;
    public EntelechyUserLikeButton bAF;
    private com.baidu.tieba.card.data.e bAG;
    private int mSkinType;

    public g(View view) {
        super(view);
        this.bAD = null;
        this.bAE = null;
        this.bAF = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.m
    public void a(com.baidu.tieba.horizonalList.widget.k kVar) {
        if (kVar != null && (kVar instanceof com.baidu.tieba.card.data.e)) {
            this.bAG = (com.baidu.tieba.card.data.e) kVar;
            this.bAD.setTag(this.bAG.forumAvatar);
            this.bAD.setTag(w.h.tag_forum_name, this.bAG.forumName);
            this.bAD.c(this.bAG.forumAvatar, 15, false);
            this.bAE.setText(String.valueOf(com.baidu.tbadk.core.util.aw.getFixedText(this.bAG.forumName, 4, true)) + getView().getContext().getResources().getString(w.l.forum));
            this.bAE.setTag(w.h.tag_forum_name, this.bAG.forumName);
            this.bAF.setTag(w.h.tag_forum_id, Long.valueOf(this.bAG.forumId));
            this.bAF.setTag(w.h.tag_forum_name, this.bAG.forumName);
            getView().setTag(w.h.tag_forum_id, Long.valueOf(this.bAG.forumId));
            getView().setTag(w.h.tag_forum_name, this.bAG.forumName);
            a(this.bAF, this.bAG.isLiked);
            this.bAD.setOnClickListener(this.atM);
            this.bAF.setOnClickListener(this.atM);
            this.bAE.setOnClickListener(this.atM);
            getView().setOnClickListener(this.atM);
        }
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.m
    public com.baidu.tieba.horizonalList.widget.m V(View view) {
        g gVar = new g(view);
        gVar.bAD = (BarImageView) view.findViewById(w.h.forum_avatar);
        gVar.bAD.setGifIconSupport(false);
        gVar.bAE = (TextView) view.findViewById(w.h.m_forum_name_textview);
        gVar.bAF = (EntelechyUserLikeButton) view.findViewById(w.h.forum_add_love);
        gVar.cOp = 16908308;
        return gVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.m
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.as.k(getView(), w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.as.i(this.bAE, w.e.cp_cont_b);
            a(this.bAF, this.bAG.isLiked);
        }
        this.mSkinType = i;
    }

    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(w.h.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.aP(z);
        }
    }
}
