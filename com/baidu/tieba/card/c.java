package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.horizonalList.widget.n {
    public BarImageView brt;
    public TextView bru;
    public EntelechyUserLikeButton brv;
    private com.baidu.tieba.card.data.e brw;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.brt = null;
        this.bru = null;
        this.brv = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void a(com.baidu.tieba.horizonalList.widget.l lVar) {
        if (lVar != null && (lVar instanceof com.baidu.tieba.card.data.e)) {
            this.brw = (com.baidu.tieba.card.data.e) lVar;
            this.brt.setTag(this.brw.forumAvatar);
            this.brt.setTag(w.h.tag_forum_name, this.brw.forumName);
            this.brt.c(this.brw.forumAvatar, 15, false);
            this.bru.setText(String.valueOf(com.baidu.tbadk.core.util.au.getFixedText(this.brw.forumName, 4, true)) + getView().getContext().getResources().getString(w.l.forum));
            this.bru.setTag(w.h.tag_forum_name, this.brw.forumName);
            this.brv.setTag(w.h.tag_forum_id, Long.valueOf(this.brw.forumId));
            this.brv.setTag(w.h.tag_forum_name, this.brw.forumName);
            getView().setTag(w.h.tag_forum_id, Long.valueOf(this.brw.forumId));
            getView().setTag(w.h.tag_forum_name, this.brw.forumName);
            a(this.brv, this.brw.isLiked);
            this.brt.setOnClickListener(this.asD);
            this.brv.setOnClickListener(this.asD);
            this.bru.setOnClickListener(this.asD);
            getView().setOnClickListener(this.asD);
        }
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public com.baidu.tieba.horizonalList.widget.n V(View view) {
        c cVar = new c(view);
        cVar.brt = (BarImageView) view.findViewById(w.h.forum_avatar);
        cVar.brt.setGifIconSupport(false);
        cVar.bru = (TextView) view.findViewById(w.h.m_forum_name_textview);
        cVar.brv = (EntelechyUserLikeButton) view.findViewById(w.h.forum_add_love);
        cVar.cFU = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.k(getView(), w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.i((View) this.bru, w.e.cp_cont_b);
            a(this.brv, this.brw.isLiked);
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
