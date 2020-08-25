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
    public BarImageView faE;
    public TextView faF;
    public EntelechyUserLikeButton faH;
    private com.baidu.tieba.card.data.h hht;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.faE = null;
        this.faF = null;
        this.faH = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.h)) {
            this.hht = (com.baidu.tieba.card.data.h) cVar;
            this.faE.setTag(this.hht.forumAvatar);
            this.faE.setTag(R.id.tag_forum_name, this.hht.forumName);
            this.faE.startLoad(this.hht.forumAvatar, 15, false);
            this.faF.setText(at.getFixedText(this.hht.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.faF.setTag(R.id.tag_forum_name, this.hht.forumName);
            this.faH.setTag(R.id.tag_forum_id, Long.valueOf(this.hht.forumId));
            this.faH.setTag(R.id.tag_forum_name, this.hht.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.hht.forumId));
            getView().setTag(R.id.tag_forum_name, this.hht.forumName);
            a(this.faH, this.hht.isLiked);
            this.faE.setOnClickListener(this.eFC);
            this.faH.setOnClickListener(this.eFC);
            this.faF.setOnClickListener(this.eFC);
            getView().setOnClickListener(this.eFC);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bT(View view) {
        d dVar = new d(view);
        dVar.faE = (BarImageView) view.findViewById(R.id.forum_avatar);
        dVar.faE.setGifIconSupport(false);
        dVar.faF = (TextView) view.findViewById(R.id.m_forum_name_textview);
        dVar.faH = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        dVar.iWU = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            ap.setViewTextColor(this.faF, R.color.cp_cont_b);
            a(this.faH, this.hht.isLiked);
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
