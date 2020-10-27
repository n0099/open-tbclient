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
/* loaded from: classes21.dex */
public class d extends com.baidu.tieba.horizonalList.widget.e {
    public BarImageView fyn;
    public TextView fyo;
    public EntelechyUserLikeButton fyq;
    private com.baidu.tieba.card.data.h hPR;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.fyn = null;
        this.fyo = null;
        this.fyq = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.h)) {
            this.hPR = (com.baidu.tieba.card.data.h) cVar;
            this.fyn.setTag(this.hPR.forumAvatar);
            this.fyn.setTag(R.id.tag_forum_name, this.hPR.forumName);
            this.fyn.startLoad(this.hPR.forumAvatar, 15, false);
            this.fyo.setText(at.getFixedText(this.hPR.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.fyo.setTag(R.id.tag_forum_name, this.hPR.forumName);
            this.fyq.setTag(R.id.tag_forum_id, Long.valueOf(this.hPR.forumId));
            this.fyq.setTag(R.id.tag_forum_name, this.hPR.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.hPR.forumId));
            getView().setTag(R.id.tag_forum_name, this.hPR.forumName);
            a(this.fyq, this.hPR.isLiked);
            this.fyn.setOnClickListener(this.fcr);
            this.fyq.setOnClickListener(this.fcr);
            this.fyo.setOnClickListener(this.fcr);
            getView().setOnClickListener(this.fcr);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ck(View view) {
        d dVar = new d(view);
        dVar.fyn = (BarImageView) view.findViewById(R.id.forum_avatar);
        dVar.fyn.setGifIconSupport(false);
        dVar.fyo = (TextView) view.findViewById(R.id.m_forum_name_textview);
        dVar.fyq = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        dVar.jHe = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            ap.setViewTextColor(this.fyo, R.color.cp_cont_b);
            a(this.fyq, this.hPR.isLiked);
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
