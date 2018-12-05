package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.horizonalList.widget.e {
    public BarImageView bnk;
    public TextView bnl;
    public EntelechyUserLikeButton bnn;
    private com.baidu.tieba.card.data.e cSv;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.bnk = null;
        this.bnl = null;
        this.bnn = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.e)) {
            this.cSv = (com.baidu.tieba.card.data.e) cVar;
            this.bnk.setTag(this.cSv.forumAvatar);
            this.bnk.setTag(e.g.tag_forum_name, this.cSv.forumName);
            this.bnk.startLoad(this.cSv.forumAvatar, 15, false);
            this.bnl.setText(ao.getFixedText(this.cSv.forumName, 4, true) + getView().getContext().getResources().getString(e.j.forum));
            this.bnl.setTag(e.g.tag_forum_name, this.cSv.forumName);
            this.bnn.setTag(e.g.tag_forum_id, Long.valueOf(this.cSv.forumId));
            this.bnn.setTag(e.g.tag_forum_name, this.cSv.forumName);
            getView().setTag(e.g.tag_forum_id, Long.valueOf(this.cSv.forumId));
            getView().setTag(e.g.tag_forum_name, this.cSv.forumName);
            a(this.bnn, this.cSv.isLiked);
            this.bnk.setOnClickListener(this.aSY);
            this.bnn.setOnClickListener(this.aSY);
            this.bnl.setOnClickListener(this.aSY);
            getView().setOnClickListener(this.aSY);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ay(View view) {
        d dVar = new d(view);
        dVar.bnk = (BarImageView) view.findViewById(e.g.forum_avatar);
        dVar.bnk.setGifIconSupport(false);
        dVar.bnl = (TextView) view.findViewById(e.g.m_forum_name_textview);
        dVar.bnn = (EntelechyUserLikeButton) view.findViewById(e.g.forum_add_love);
        dVar.eza = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.j(getView(), e.d.cp_bg_line_d);
            al.h(this.bnl, e.d.cp_cont_b);
            a(this.bnn, this.cSv.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(e.g.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.bK(z);
        }
    }
}
