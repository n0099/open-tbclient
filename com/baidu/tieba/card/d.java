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
    public BarImageView bQW;
    public TextView bQX;
    public EntelechyUserLikeButton bQY;
    private com.baidu.tieba.card.data.e bQZ;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.bQW = null;
        this.bQX = null;
        this.bQY = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar != null && (dVar instanceof com.baidu.tieba.card.data.e)) {
            this.bQZ = (com.baidu.tieba.card.data.e) dVar;
            this.bQW.setTag(this.bQZ.forumAvatar);
            this.bQW.setTag(d.g.tag_forum_name, this.bQZ.forumName);
            this.bQW.startLoad(this.bQZ.forumAvatar, 15, false);
            this.bQX.setText(am.getFixedText(this.bQZ.forumName, 4, true) + getView().getContext().getResources().getString(d.j.forum));
            this.bQX.setTag(d.g.tag_forum_name, this.bQZ.forumName);
            this.bQY.setTag(d.g.tag_forum_id, Long.valueOf(this.bQZ.forumId));
            this.bQY.setTag(d.g.tag_forum_name, this.bQZ.forumName);
            getView().setTag(d.g.tag_forum_id, Long.valueOf(this.bQZ.forumId));
            getView().setTag(d.g.tag_forum_name, this.bQZ.forumName);
            a(this.bQY, this.bQZ.isLiked);
            this.bQW.setOnClickListener(this.auz);
            this.bQY.setOnClickListener(this.auz);
            this.bQX.setOnClickListener(this.auz);
            getView().setOnClickListener(this.auz);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f ae(View view) {
        d dVar = new d(view);
        dVar.bQW = (BarImageView) view.findViewById(d.g.forum_avatar);
        dVar.bQW.setGifIconSupport(false);
        dVar.bQX = (TextView) view.findViewById(d.g.m_forum_name_textview);
        dVar.bQY = (EntelechyUserLikeButton) view.findViewById(d.g.forum_add_love);
        dVar.dlB = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.k(getView(), d.C0080d.cp_bg_line_d);
            aj.i(this.bQX, d.C0080d.cp_cont_b);
            a(this.bQY, this.bQZ.isLiked);
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
