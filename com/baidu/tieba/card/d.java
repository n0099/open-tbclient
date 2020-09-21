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
/* loaded from: classes20.dex */
public class d extends com.baidu.tieba.horizonalList.widget.e {
    public BarImageView fdB;
    public TextView fdC;
    public EntelechyUserLikeButton fdE;
    private com.baidu.tieba.card.data.h hoB;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.fdB = null;
        this.fdC = null;
        this.fdE = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.h)) {
            this.hoB = (com.baidu.tieba.card.data.h) cVar;
            this.fdB.setTag(this.hoB.forumAvatar);
            this.fdB.setTag(R.id.tag_forum_name, this.hoB.forumName);
            this.fdB.startLoad(this.hoB.forumAvatar, 15, false);
            this.fdC.setText(at.getFixedText(this.hoB.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.fdC.setTag(R.id.tag_forum_name, this.hoB.forumName);
            this.fdE.setTag(R.id.tag_forum_id, Long.valueOf(this.hoB.forumId));
            this.fdE.setTag(R.id.tag_forum_name, this.hoB.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.hoB.forumId));
            getView().setTag(R.id.tag_forum_name, this.hoB.forumName);
            a(this.fdE, this.hoB.isLiked);
            this.fdB.setOnClickListener(this.eHN);
            this.fdE.setOnClickListener(this.eHN);
            this.fdC.setOnClickListener(this.eHN);
            getView().setOnClickListener(this.eHN);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e cc(View view) {
        d dVar = new d(view);
        dVar.fdB = (BarImageView) view.findViewById(R.id.forum_avatar);
        dVar.fdB.setGifIconSupport(false);
        dVar.fdC = (TextView) view.findViewById(R.id.m_forum_name_textview);
        dVar.fdE = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        dVar.jfG = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            ap.setViewTextColor(this.fdC, R.color.cp_cont_b);
            a(this.fdE, this.hoB.isLiked);
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
