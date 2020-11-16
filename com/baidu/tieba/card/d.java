package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class d extends com.baidu.tieba.horizonalList.widget.e {
    public BarImageView fDG;
    public TextView fDH;
    public EntelechyUserLikeButton fDJ;
    private com.baidu.tieba.card.data.g hWo;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.fDG = null;
        this.fDH = null;
        this.fDJ = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.g)) {
            this.hWo = (com.baidu.tieba.card.data.g) cVar;
            this.fDG.setTag(this.hWo.forumAvatar);
            this.fDG.setTag(R.id.tag_forum_name, this.hWo.forumName);
            this.fDG.startLoad(this.hWo.forumAvatar, 15, false);
            this.fDH.setText(au.getFixedText(this.hWo.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.fDH.setTag(R.id.tag_forum_name, this.hWo.forumName);
            this.fDJ.setTag(R.id.tag_forum_id, Long.valueOf(this.hWo.forumId));
            this.fDJ.setTag(R.id.tag_forum_name, this.hWo.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.hWo.forumId));
            getView().setTag(R.id.tag_forum_name, this.hWo.forumName);
            a(this.fDJ, this.hWo.isLiked);
            this.fDG.setOnClickListener(this.fhp);
            this.fDJ.setOnClickListener(this.fhp);
            this.fDH.setOnClickListener(this.fhp);
            getView().setOnClickListener(this.fhp);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ct(View view) {
        d dVar = new d(view);
        dVar.fDG = (BarImageView) view.findViewById(R.id.forum_avatar);
        dVar.fDG.setGifIconSupport(false);
        dVar.fDH = (TextView) view.findViewById(R.id.m_forum_name_textview);
        dVar.fDJ = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        dVar.jNM = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(getView(), R.color.CAM_X0201);
            ap.setViewTextColor(this.fDH, R.color.CAM_X0105);
            a(this.fDJ, this.hWo.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.aP(z);
        }
    }
}
