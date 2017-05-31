package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.horizonalList.widget.m {
    public BarImageView bzK;
    public TextView bzL;
    public EntelechyUserLikeButton bzM;
    private com.baidu.tieba.card.data.e bzN;
    private int mSkinType;

    public g(View view) {
        super(view);
        this.bzK = null;
        this.bzL = null;
        this.bzM = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.m
    public void a(com.baidu.tieba.horizonalList.widget.k kVar) {
        if (kVar != null && (kVar instanceof com.baidu.tieba.card.data.e)) {
            this.bzN = (com.baidu.tieba.card.data.e) kVar;
            this.bzK.setTag(this.bzN.forumAvatar);
            this.bzK.setTag(w.h.tag_forum_name, this.bzN.forumName);
            this.bzK.c(this.bzN.forumAvatar, 15, false);
            this.bzL.setText(String.valueOf(com.baidu.tbadk.core.util.au.getFixedText(this.bzN.forumName, 4, true)) + getView().getContext().getResources().getString(w.l.forum));
            this.bzL.setTag(w.h.tag_forum_name, this.bzN.forumName);
            this.bzM.setTag(w.h.tag_forum_id, Long.valueOf(this.bzN.forumId));
            this.bzM.setTag(w.h.tag_forum_name, this.bzN.forumName);
            getView().setTag(w.h.tag_forum_id, Long.valueOf(this.bzN.forumId));
            getView().setTag(w.h.tag_forum_name, this.bzN.forumName);
            a(this.bzM, this.bzN.isLiked);
            this.bzK.setOnClickListener(this.asJ);
            this.bzM.setOnClickListener(this.asJ);
            this.bzL.setOnClickListener(this.asJ);
            getView().setOnClickListener(this.asJ);
        }
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.m
    public com.baidu.tieba.horizonalList.widget.m U(View view) {
        g gVar = new g(view);
        gVar.bzK = (BarImageView) view.findViewById(w.h.forum_avatar);
        gVar.bzK.setGifIconSupport(false);
        gVar.bzL = (TextView) view.findViewById(w.h.m_forum_name_textview);
        gVar.bzM = (EntelechyUserLikeButton) view.findViewById(w.h.forum_add_love);
        gVar.cGt = 16908308;
        return gVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.m
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.k(getView(), w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.i(this.bzL, w.e.cp_cont_b);
            a(this.bzM, this.bzN.isLiked);
        }
        this.mSkinType = i;
    }

    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(w.h.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.aO(z);
        }
    }
}
