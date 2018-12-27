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
    public BarImageView bnn;
    public TextView bno;
    public EntelechyUserLikeButton bnq;
    private com.baidu.tieba.card.data.e cVl;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.bnn = null;
        this.bno = null;
        this.bnq = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.e)) {
            this.cVl = (com.baidu.tieba.card.data.e) cVar;
            this.bnn.setTag(this.cVl.forumAvatar);
            this.bnn.setTag(e.g.tag_forum_name, this.cVl.forumName);
            this.bnn.startLoad(this.cVl.forumAvatar, 15, false);
            this.bno.setText(ao.getFixedText(this.cVl.forumName, 4, true) + getView().getContext().getResources().getString(e.j.forum));
            this.bno.setTag(e.g.tag_forum_name, this.cVl.forumName);
            this.bnq.setTag(e.g.tag_forum_id, Long.valueOf(this.cVl.forumId));
            this.bnq.setTag(e.g.tag_forum_name, this.cVl.forumName);
            getView().setTag(e.g.tag_forum_id, Long.valueOf(this.cVl.forumId));
            getView().setTag(e.g.tag_forum_name, this.cVl.forumName);
            a(this.bnq, this.cVl.isLiked);
            this.bnn.setOnClickListener(this.aTa);
            this.bnq.setOnClickListener(this.aTa);
            this.bno.setOnClickListener(this.aTa);
            getView().setOnClickListener(this.aTa);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e aB(View view) {
        d dVar = new d(view);
        dVar.bnn = (BarImageView) view.findViewById(e.g.forum_avatar);
        dVar.bnn.setGifIconSupport(false);
        dVar.bno = (TextView) view.findViewById(e.g.m_forum_name_textview);
        dVar.bnq = (EntelechyUserLikeButton) view.findViewById(e.g.forum_add_love);
        dVar.eBR = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.j(getView(), e.d.cp_bg_line_d);
            al.h(this.bno, e.d.cp_cont_b);
            a(this.bnq, this.cVl.isLiked);
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
