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
    public BarImageView bob;
    public TextView boc;
    public EntelechyUserLikeButton boe;
    private com.baidu.tieba.card.data.e cVW;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.bob = null;
        this.boc = null;
        this.boe = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.e)) {
            this.cVW = (com.baidu.tieba.card.data.e) cVar;
            this.bob.setTag(this.cVW.forumAvatar);
            this.bob.setTag(e.g.tag_forum_name, this.cVW.forumName);
            this.bob.startLoad(this.cVW.forumAvatar, 15, false);
            this.boc.setText(ao.getFixedText(this.cVW.forumName, 4, true) + getView().getContext().getResources().getString(e.j.forum));
            this.boc.setTag(e.g.tag_forum_name, this.cVW.forumName);
            this.boe.setTag(e.g.tag_forum_id, Long.valueOf(this.cVW.forumId));
            this.boe.setTag(e.g.tag_forum_name, this.cVW.forumName);
            getView().setTag(e.g.tag_forum_id, Long.valueOf(this.cVW.forumId));
            getView().setTag(e.g.tag_forum_name, this.cVW.forumName);
            a(this.boe, this.cVW.isLiked);
            this.bob.setOnClickListener(this.aTI);
            this.boe.setOnClickListener(this.aTI);
            this.boc.setOnClickListener(this.aTI);
            getView().setOnClickListener(this.aTI);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e aB(View view) {
        d dVar = new d(view);
        dVar.bob = (BarImageView) view.findViewById(e.g.forum_avatar);
        dVar.bob.setGifIconSupport(false);
        dVar.boc = (TextView) view.findViewById(e.g.m_forum_name_textview);
        dVar.boe = (EntelechyUserLikeButton) view.findViewById(e.g.forum_add_love);
        dVar.eCD = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.j(getView(), e.d.cp_bg_line_d);
            al.h(this.boc, e.d.cp_cont_b);
            a(this.boe, this.cVW.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(e.g.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.bL(z);
        }
    }
}
