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
    public BarImageView boc;
    public TextView bod;
    public EntelechyUserLikeButton bof;
    private com.baidu.tieba.card.data.e cVX;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.boc = null;
        this.bod = null;
        this.bof = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.e)) {
            this.cVX = (com.baidu.tieba.card.data.e) cVar;
            this.boc.setTag(this.cVX.forumAvatar);
            this.boc.setTag(e.g.tag_forum_name, this.cVX.forumName);
            this.boc.startLoad(this.cVX.forumAvatar, 15, false);
            this.bod.setText(ao.getFixedText(this.cVX.forumName, 4, true) + getView().getContext().getResources().getString(e.j.forum));
            this.bod.setTag(e.g.tag_forum_name, this.cVX.forumName);
            this.bof.setTag(e.g.tag_forum_id, Long.valueOf(this.cVX.forumId));
            this.bof.setTag(e.g.tag_forum_name, this.cVX.forumName);
            getView().setTag(e.g.tag_forum_id, Long.valueOf(this.cVX.forumId));
            getView().setTag(e.g.tag_forum_name, this.cVX.forumName);
            a(this.bof, this.cVX.isLiked);
            this.boc.setOnClickListener(this.aTJ);
            this.bof.setOnClickListener(this.aTJ);
            this.bod.setOnClickListener(this.aTJ);
            getView().setOnClickListener(this.aTJ);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e aB(View view) {
        d dVar = new d(view);
        dVar.boc = (BarImageView) view.findViewById(e.g.forum_avatar);
        dVar.boc.setGifIconSupport(false);
        dVar.bod = (TextView) view.findViewById(e.g.m_forum_name_textview);
        dVar.bof = (EntelechyUserLikeButton) view.findViewById(e.g.forum_add_love);
        dVar.eCE = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.j(getView(), e.d.cp_bg_line_d);
            al.h(this.bod, e.d.cp_cont_b);
            a(this.bof, this.cVX.isLiked);
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
