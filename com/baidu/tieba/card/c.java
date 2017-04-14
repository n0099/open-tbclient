package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.horizonalList.widget.n {
    public BarImageView brl;
    public TextView brm;
    public EntelechyUserLikeButton brn;
    private com.baidu.tieba.card.data.e bro;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.brl = null;
        this.brm = null;
        this.brn = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void a(com.baidu.tieba.horizonalList.widget.l lVar) {
        if (lVar != null && (lVar instanceof com.baidu.tieba.card.data.e)) {
            this.bro = (com.baidu.tieba.card.data.e) lVar;
            this.brl.setTag(this.bro.forumAvatar);
            this.brl.setTag(w.h.tag_forum_name, this.bro.forumName);
            this.brl.c(this.bro.forumAvatar, 15, false);
            this.brm.setText(String.valueOf(com.baidu.tbadk.core.util.au.getFixedText(this.bro.forumName, 4, true)) + getView().getContext().getResources().getString(w.l.forum));
            this.brm.setTag(w.h.tag_forum_name, this.bro.forumName);
            this.brn.setTag(w.h.tag_forum_id, Long.valueOf(this.bro.forumId));
            this.brn.setTag(w.h.tag_forum_name, this.bro.forumName);
            getView().setTag(w.h.tag_forum_id, Long.valueOf(this.bro.forumId));
            getView().setTag(w.h.tag_forum_name, this.bro.forumName);
            a(this.brn, this.bro.isLiked);
            this.brl.setOnClickListener(this.asT);
            this.brn.setOnClickListener(this.asT);
            this.brm.setOnClickListener(this.asT);
            getView().setOnClickListener(this.asT);
        }
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public com.baidu.tieba.horizonalList.widget.n V(View view) {
        c cVar = new c(view);
        cVar.brl = (BarImageView) view.findViewById(w.h.forum_avatar);
        cVar.brl.setGifIconSupport(false);
        cVar.brm = (TextView) view.findViewById(w.h.m_forum_name_textview);
        cVar.brn = (EntelechyUserLikeButton) view.findViewById(w.h.forum_add_love);
        cVar.cEt = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.k(getView(), w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.i(this.brm, w.e.cp_cont_b);
            a(this.brn, this.bro.isLiked);
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
