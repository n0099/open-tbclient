package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.horizonalList.widget.e {
    public BarImageView cyA;
    public TextView cyB;
    public EntelechyUserLikeButton cyD;
    private com.baidu.tieba.card.data.e efF;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.cyA = null;
        this.cyB = null;
        this.cyD = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.e)) {
            this.efF = (com.baidu.tieba.card.data.e) cVar;
            this.cyA.setTag(this.efF.forumAvatar);
            this.cyA.setTag(d.g.tag_forum_name, this.efF.forumName);
            this.cyA.startLoad(this.efF.forumAvatar, 15, false);
            this.cyB.setText(ap.getFixedText(this.efF.forumName, 4, true) + getView().getContext().getResources().getString(d.j.forum));
            this.cyB.setTag(d.g.tag_forum_name, this.efF.forumName);
            this.cyD.setTag(d.g.tag_forum_id, Long.valueOf(this.efF.forumId));
            this.cyD.setTag(d.g.tag_forum_name, this.efF.forumName);
            getView().setTag(d.g.tag_forum_id, Long.valueOf(this.efF.forumId));
            getView().setTag(d.g.tag_forum_name, this.efF.forumName);
            a(this.cyD, this.efF.isLiked);
            this.cyA.setOnClickListener(this.ccA);
            this.cyD.setOnClickListener(this.ccA);
            this.cyB.setOnClickListener(this.ccA);
            getView().setOnClickListener(this.ccA);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bv(View view) {
        c cVar = new c(view);
        cVar.cyA = (BarImageView) view.findViewById(d.g.forum_avatar);
        cVar.cyA.setGifIconSupport(false);
        cVar.cyB = (TextView) view.findViewById(d.g.m_forum_name_textview);
        cVar.cyD = (EntelechyUserLikeButton) view.findViewById(d.g.forum_add_love);
        cVar.fSK = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.l(getView(), d.C0277d.cp_bg_line_d);
            al.j(this.cyB, d.C0277d.cp_cont_b);
            a(this.cyD, this.efF.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(d.g.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.dU(z);
        }
    }
}
