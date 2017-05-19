package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.horizonalList.widget.m {
    public BarImageView btW;
    public TextView btX;
    public EntelechyUserLikeButton btY;
    private com.baidu.tieba.card.data.e btZ;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.btW = null;
        this.btX = null;
        this.btY = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.m
    public void a(com.baidu.tieba.horizonalList.widget.k kVar) {
        if (kVar != null && (kVar instanceof com.baidu.tieba.card.data.e)) {
            this.btZ = (com.baidu.tieba.card.data.e) kVar;
            this.btW.setTag(this.btZ.forumAvatar);
            this.btW.setTag(w.h.tag_forum_name, this.btZ.forumName);
            this.btW.c(this.btZ.forumAvatar, 15, false);
            this.btX.setText(String.valueOf(com.baidu.tbadk.core.util.au.getFixedText(this.btZ.forumName, 4, true)) + getView().getContext().getResources().getString(w.l.forum));
            this.btX.setTag(w.h.tag_forum_name, this.btZ.forumName);
            this.btY.setTag(w.h.tag_forum_id, Long.valueOf(this.btZ.forumId));
            this.btY.setTag(w.h.tag_forum_name, this.btZ.forumName);
            getView().setTag(w.h.tag_forum_id, Long.valueOf(this.btZ.forumId));
            getView().setTag(w.h.tag_forum_name, this.btZ.forumName);
            a(this.btY, this.btZ.isLiked);
            this.btW.setOnClickListener(this.asZ);
            this.btY.setOnClickListener(this.asZ);
            this.btX.setOnClickListener(this.asZ);
            getView().setOnClickListener(this.asZ);
        }
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.m
    public com.baidu.tieba.horizonalList.widget.m U(View view) {
        c cVar = new c(view);
        cVar.btW = (BarImageView) view.findViewById(w.h.forum_avatar);
        cVar.btW.setGifIconSupport(false);
        cVar.btX = (TextView) view.findViewById(w.h.m_forum_name_textview);
        cVar.btY = (EntelechyUserLikeButton) view.findViewById(w.h.forum_add_love);
        cVar.cAU = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.m
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.k(getView(), w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.i(this.btX, w.e.cp_cont_b);
            a(this.btY, this.btZ.isLiked);
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
