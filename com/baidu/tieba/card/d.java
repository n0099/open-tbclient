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
    public BarImageView bZp;
    public TextView bZq;
    public EntelechyUserLikeButton bZr;
    private com.baidu.tieba.card.data.e bZs;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.bZp = null;
        this.bZq = null;
        this.bZr = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar != null && (dVar instanceof com.baidu.tieba.card.data.e)) {
            this.bZs = (com.baidu.tieba.card.data.e) dVar;
            this.bZp.setTag(this.bZs.forumAvatar);
            this.bZp.setTag(d.g.tag_forum_name, this.bZs.forumName);
            this.bZp.startLoad(this.bZs.forumAvatar, 15, false);
            this.bZq.setText(am.getFixedText(this.bZs.forumName, 4, true) + getView().getContext().getResources().getString(d.j.forum));
            this.bZq.setTag(d.g.tag_forum_name, this.bZs.forumName);
            this.bZr.setTag(d.g.tag_forum_id, Long.valueOf(this.bZs.forumId));
            this.bZr.setTag(d.g.tag_forum_name, this.bZs.forumName);
            getView().setTag(d.g.tag_forum_id, Long.valueOf(this.bZs.forumId));
            getView().setTag(d.g.tag_forum_name, this.bZs.forumName);
            a(this.bZr, this.bZs.isLiked);
            this.bZp.setOnClickListener(this.avq);
            this.bZr.setOnClickListener(this.avq);
            this.bZq.setOnClickListener(this.avq);
            getView().setOnClickListener(this.avq);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f ag(View view) {
        d dVar = new d(view);
        dVar.bZp = (BarImageView) view.findViewById(d.g.forum_avatar);
        dVar.bZp.setGifIconSupport(false);
        dVar.bZq = (TextView) view.findViewById(d.g.m_forum_name_textview);
        dVar.bZr = (EntelechyUserLikeButton) view.findViewById(d.g.forum_add_love);
        dVar.duS = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.k(getView(), d.C0095d.cp_bg_line_d);
            aj.i(this.bZq, d.C0095d.cp_cont_b);
            a(this.bZr, this.bZs.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(d.g.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.aN(z);
        }
    }
}
