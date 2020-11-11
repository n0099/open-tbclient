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
    public BarImageView fEd;
    public TextView fEe;
    public EntelechyUserLikeButton fEg;
    private com.baidu.tieba.card.data.h hVO;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.fEd = null;
        this.fEe = null;
        this.fEg = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.h)) {
            this.hVO = (com.baidu.tieba.card.data.h) cVar;
            this.fEd.setTag(this.hVO.forumAvatar);
            this.fEd.setTag(R.id.tag_forum_name, this.hVO.forumName);
            this.fEd.startLoad(this.hVO.forumAvatar, 15, false);
            this.fEe.setText(at.getFixedText(this.hVO.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.fEe.setTag(R.id.tag_forum_name, this.hVO.forumName);
            this.fEg.setTag(R.id.tag_forum_id, Long.valueOf(this.hVO.forumId));
            this.fEg.setTag(R.id.tag_forum_name, this.hVO.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.hVO.forumId));
            getView().setTag(R.id.tag_forum_name, this.hVO.forumName);
            a(this.fEg, this.hVO.isLiked);
            this.fEd.setOnClickListener(this.fii);
            this.fEg.setOnClickListener(this.fii);
            this.fEe.setOnClickListener(this.fii);
            getView().setOnClickListener(this.fii);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e cp(View view) {
        d dVar = new d(view);
        dVar.fEd = (BarImageView) view.findViewById(R.id.forum_avatar);
        dVar.fEd.setGifIconSupport(false);
        dVar.fEe = (TextView) view.findViewById(R.id.m_forum_name_textview);
        dVar.fEg = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        dVar.jNc = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            ap.setViewTextColor(this.fEe, R.color.cp_cont_b);
            a(this.fEg, this.hVO.isLiked);
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
