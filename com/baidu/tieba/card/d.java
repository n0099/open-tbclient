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
    public BarImageView cNU;
    public TextView cNV;
    public EntelechyUserLikeButton cNW;
    private com.baidu.tieba.card.data.e cNX;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.cNU = null;
        this.cNV = null;
        this.cNW = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar != null && (dVar instanceof com.baidu.tieba.card.data.e)) {
            this.cNX = (com.baidu.tieba.card.data.e) dVar;
            this.cNU.setTag(this.cNX.forumAvatar);
            this.cNU.setTag(d.g.tag_forum_name, this.cNX.forumName);
            this.cNU.startLoad(this.cNX.forumAvatar, 15, false);
            this.cNV.setText(am.getFixedText(this.cNX.forumName, 4, true) + getView().getContext().getResources().getString(d.j.forum));
            this.cNV.setTag(d.g.tag_forum_name, this.cNX.forumName);
            this.cNW.setTag(d.g.tag_forum_id, Long.valueOf(this.cNX.forumId));
            this.cNW.setTag(d.g.tag_forum_name, this.cNX.forumName);
            getView().setTag(d.g.tag_forum_id, Long.valueOf(this.cNX.forumId));
            getView().setTag(d.g.tag_forum_name, this.cNX.forumName);
            a(this.cNW, this.cNX.isLiked);
            this.cNU.setOnClickListener(this.bjw);
            this.cNW.setOnClickListener(this.bjw);
            this.cNV.setOnClickListener(this.bjw);
            getView().setOnClickListener(this.bjw);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f by(View view) {
        d dVar = new d(view);
        dVar.cNU = (BarImageView) view.findViewById(d.g.forum_avatar);
        dVar.cNU.setGifIconSupport(false);
        dVar.cNV = (TextView) view.findViewById(d.g.m_forum_name_textview);
        dVar.cNW = (EntelechyUserLikeButton) view.findViewById(d.g.forum_add_love);
        dVar.egV = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.t(getView(), d.C0108d.cp_bg_line_d);
            aj.r(this.cNV, d.C0108d.cp_cont_b);
            a(this.cNW, this.cNX.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(d.g.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.bt(z);
        }
    }
}
