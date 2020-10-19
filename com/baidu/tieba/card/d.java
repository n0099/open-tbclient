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
    public BarImageView fpO;
    public TextView fpP;
    public EntelechyUserLikeButton fpR;
    private com.baidu.tieba.card.data.h hDv;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.fpO = null;
        this.fpP = null;
        this.fpR = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.h)) {
            this.hDv = (com.baidu.tieba.card.data.h) cVar;
            this.fpO.setTag(this.hDv.forumAvatar);
            this.fpO.setTag(R.id.tag_forum_name, this.hDv.forumName);
            this.fpO.startLoad(this.hDv.forumAvatar, 15, false);
            this.fpP.setText(at.getFixedText(this.hDv.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.fpP.setTag(R.id.tag_forum_name, this.hDv.forumName);
            this.fpR.setTag(R.id.tag_forum_id, Long.valueOf(this.hDv.forumId));
            this.fpR.setTag(R.id.tag_forum_name, this.hDv.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.hDv.forumId));
            getView().setTag(R.id.tag_forum_name, this.hDv.forumName);
            a(this.fpR, this.hDv.isLiked);
            this.fpO.setOnClickListener(this.eTU);
            this.fpR.setOnClickListener(this.eTU);
            this.fpP.setOnClickListener(this.eTU);
            getView().setOnClickListener(this.eTU);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e cg(View view) {
        d dVar = new d(view);
        dVar.fpO = (BarImageView) view.findViewById(R.id.forum_avatar);
        dVar.fpO.setGifIconSupport(false);
        dVar.fpP = (TextView) view.findViewById(R.id.m_forum_name_textview);
        dVar.fpR = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        dVar.juF = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            ap.setViewTextColor(this.fpP, R.color.cp_cont_b);
            a(this.fpR, this.hDv.isLiked);
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
