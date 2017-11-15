package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.horizonalList.widget.f {
    public BarImageView bRj;
    public TextView bRk;
    public EntelechyUserLikeButton bRl;
    private com.baidu.tieba.card.data.e bRm;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.bRj = null;
        this.bRk = null;
        this.bRl = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar != null && (dVar instanceof com.baidu.tieba.card.data.e)) {
            this.bRm = (com.baidu.tieba.card.data.e) dVar;
            this.bRj.setTag(this.bRm.forumAvatar);
            this.bRj.setTag(d.g.tag_forum_name, this.bRm.forumName);
            this.bRj.startLoad(this.bRm.forumAvatar, 15, false);
            this.bRk.setText(am.getFixedText(this.bRm.forumName, 4, true) + getView().getContext().getResources().getString(d.j.forum));
            this.bRk.setTag(d.g.tag_forum_name, this.bRm.forumName);
            this.bRl.setTag(d.g.tag_forum_id, Long.valueOf(this.bRm.forumId));
            this.bRl.setTag(d.g.tag_forum_name, this.bRm.forumName);
            getView().setTag(d.g.tag_forum_id, Long.valueOf(this.bRm.forumId));
            getView().setTag(d.g.tag_forum_name, this.bRm.forumName);
            a(this.bRl, this.bRm.isLiked);
            this.bRj.setOnClickListener(this.auH);
            this.bRl.setOnClickListener(this.auH);
            this.bRk.setOnClickListener(this.auH);
            getView().setOnClickListener(this.auH);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f ae(View view) {
        d dVar = new d(view);
        dVar.bRj = (BarImageView) view.findViewById(d.g.forum_avatar);
        dVar.bRj.setGifIconSupport(false);
        dVar.bRk = (TextView) view.findViewById(d.g.m_forum_name_textview);
        dVar.bRl = (EntelechyUserLikeButton) view.findViewById(d.g.forum_add_love);
        dVar.dlV = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.k(getView(), d.C0080d.cp_bg_line_d);
            aj.i(this.bRk, d.C0080d.cp_cont_b);
            a(this.bRl, this.bRm.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(d.g.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.aM(z);
        }
    }
}
