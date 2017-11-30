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
    public BarImageView bZh;
    public TextView bZi;
    public EntelechyUserLikeButton bZj;
    private com.baidu.tieba.card.data.e bZk;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.bZh = null;
        this.bZi = null;
        this.bZj = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar != null && (dVar instanceof com.baidu.tieba.card.data.e)) {
            this.bZk = (com.baidu.tieba.card.data.e) dVar;
            this.bZh.setTag(this.bZk.forumAvatar);
            this.bZh.setTag(d.g.tag_forum_name, this.bZk.forumName);
            this.bZh.startLoad(this.bZk.forumAvatar, 15, false);
            this.bZi.setText(am.getFixedText(this.bZk.forumName, 4, true) + getView().getContext().getResources().getString(d.j.forum));
            this.bZi.setTag(d.g.tag_forum_name, this.bZk.forumName);
            this.bZj.setTag(d.g.tag_forum_id, Long.valueOf(this.bZk.forumId));
            this.bZj.setTag(d.g.tag_forum_name, this.bZk.forumName);
            getView().setTag(d.g.tag_forum_id, Long.valueOf(this.bZk.forumId));
            getView().setTag(d.g.tag_forum_name, this.bZk.forumName);
            a(this.bZj, this.bZk.isLiked);
            this.bZh.setOnClickListener(this.avi);
            this.bZj.setOnClickListener(this.avi);
            this.bZi.setOnClickListener(this.avi);
            getView().setOnClickListener(this.avi);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f af(View view) {
        d dVar = new d(view);
        dVar.bZh = (BarImageView) view.findViewById(d.g.forum_avatar);
        dVar.bZh.setGifIconSupport(false);
        dVar.bZi = (TextView) view.findViewById(d.g.m_forum_name_textview);
        dVar.bZj = (EntelechyUserLikeButton) view.findViewById(d.g.forum_add_love);
        dVar.dtJ = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.k(getView(), d.C0082d.cp_bg_line_d);
            aj.i(this.bZi, d.C0082d.cp_cont_b);
            a(this.bZj, this.bZk.isLiked);
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
