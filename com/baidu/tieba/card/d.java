package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class d extends com.baidu.tieba.horizonalList.widget.e {
    public BarImageView faI;
    public TextView faJ;
    public EntelechyUserLikeButton faL;
    private com.baidu.tieba.card.data.h hhx;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.faI = null;
        this.faJ = null;
        this.faL = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.h)) {
            this.hhx = (com.baidu.tieba.card.data.h) cVar;
            this.faI.setTag(this.hhx.forumAvatar);
            this.faI.setTag(R.id.tag_forum_name, this.hhx.forumName);
            this.faI.startLoad(this.hhx.forumAvatar, 15, false);
            this.faJ.setText(at.getFixedText(this.hhx.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.faJ.setTag(R.id.tag_forum_name, this.hhx.forumName);
            this.faL.setTag(R.id.tag_forum_id, Long.valueOf(this.hhx.forumId));
            this.faL.setTag(R.id.tag_forum_name, this.hhx.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.hhx.forumId));
            getView().setTag(R.id.tag_forum_name, this.hhx.forumName);
            a(this.faL, this.hhx.isLiked);
            this.faI.setOnClickListener(this.eFG);
            this.faL.setOnClickListener(this.eFG);
            this.faJ.setOnClickListener(this.eFG);
            getView().setOnClickListener(this.eFG);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bT(View view) {
        d dVar = new d(view);
        dVar.faI = (BarImageView) view.findViewById(R.id.forum_avatar);
        dVar.faI.setGifIconSupport(false);
        dVar.faJ = (TextView) view.findViewById(R.id.m_forum_name_textview);
        dVar.faL = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        dVar.iXa = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            ap.setViewTextColor(this.faJ, R.color.cp_cont_b);
            a(this.faL, this.hhx.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.aN(z);
        }
    }
}
