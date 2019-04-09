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
    public BarImageView cyD;
    public TextView cyE;
    public EntelechyUserLikeButton cyG;
    private com.baidu.tieba.card.data.e efs;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.cyD = null;
        this.cyE = null;
        this.cyG = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.e)) {
            this.efs = (com.baidu.tieba.card.data.e) cVar;
            this.cyD.setTag(this.efs.forumAvatar);
            this.cyD.setTag(d.g.tag_forum_name, this.efs.forumName);
            this.cyD.startLoad(this.efs.forumAvatar, 15, false);
            this.cyE.setText(ap.getFixedText(this.efs.forumName, 4, true) + getView().getContext().getResources().getString(d.j.forum));
            this.cyE.setTag(d.g.tag_forum_name, this.efs.forumName);
            this.cyG.setTag(d.g.tag_forum_id, Long.valueOf(this.efs.forumId));
            this.cyG.setTag(d.g.tag_forum_name, this.efs.forumName);
            getView().setTag(d.g.tag_forum_id, Long.valueOf(this.efs.forumId));
            getView().setTag(d.g.tag_forum_name, this.efs.forumName);
            a(this.cyG, this.efs.isLiked);
            this.cyD.setOnClickListener(this.ccD);
            this.cyG.setOnClickListener(this.ccD);
            this.cyE.setOnClickListener(this.ccD);
            getView().setOnClickListener(this.ccD);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bv(View view) {
        c cVar = new c(view);
        cVar.cyD = (BarImageView) view.findViewById(d.g.forum_avatar);
        cVar.cyD.setGifIconSupport(false);
        cVar.cyE = (TextView) view.findViewById(d.g.m_forum_name_textview);
        cVar.cyG = (EntelechyUserLikeButton) view.findViewById(d.g.forum_add_love);
        cVar.fSy = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.l(getView(), d.C0277d.cp_bg_line_d);
            al.j(this.cyE, d.C0277d.cp_cont_b);
            a(this.cyG, this.efs.isLiked);
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
