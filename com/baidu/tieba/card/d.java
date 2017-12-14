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
    public BarImageView bZl;
    public TextView bZm;
    public EntelechyUserLikeButton bZn;
    private com.baidu.tieba.card.data.e bZo;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.bZl = null;
        this.bZm = null;
        this.bZn = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar != null && (dVar instanceof com.baidu.tieba.card.data.e)) {
            this.bZo = (com.baidu.tieba.card.data.e) dVar;
            this.bZl.setTag(this.bZo.forumAvatar);
            this.bZl.setTag(d.g.tag_forum_name, this.bZo.forumName);
            this.bZl.startLoad(this.bZo.forumAvatar, 15, false);
            this.bZm.setText(am.getFixedText(this.bZo.forumName, 4, true) + getView().getContext().getResources().getString(d.j.forum));
            this.bZm.setTag(d.g.tag_forum_name, this.bZo.forumName);
            this.bZn.setTag(d.g.tag_forum_id, Long.valueOf(this.bZo.forumId));
            this.bZn.setTag(d.g.tag_forum_name, this.bZo.forumName);
            getView().setTag(d.g.tag_forum_id, Long.valueOf(this.bZo.forumId));
            getView().setTag(d.g.tag_forum_name, this.bZo.forumName);
            a(this.bZn, this.bZo.isLiked);
            this.bZl.setOnClickListener(this.avn);
            this.bZn.setOnClickListener(this.avn);
            this.bZm.setOnClickListener(this.avn);
            getView().setOnClickListener(this.avn);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f ag(View view) {
        d dVar = new d(view);
        dVar.bZl = (BarImageView) view.findViewById(d.g.forum_avatar);
        dVar.bZl.setGifIconSupport(false);
        dVar.bZm = (TextView) view.findViewById(d.g.m_forum_name_textview);
        dVar.bZn = (EntelechyUserLikeButton) view.findViewById(d.g.forum_add_love);
        dVar.duO = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.k(getView(), d.C0096d.cp_bg_line_d);
            aj.i(this.bZm, d.C0096d.cp_cont_b);
            a(this.bZn, this.bZo.isLiked);
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
