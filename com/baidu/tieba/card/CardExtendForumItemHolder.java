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
import com.baidu.tieba.horizonalList.widget.ItemViewHolder;
/* loaded from: classes.dex */
public class CardExtendForumItemHolder extends ItemViewHolder {
    public BarImageView fSE;
    public TextView fSF;
    public EntelechyUserLikeButton fSH;
    private com.baidu.tieba.card.data.g iuF;
    private int mSkinType;

    public CardExtendForumItemHolder(View view) {
        super(view);
        this.fSE = null;
        this.fSF = null;
        this.fSH = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.g)) {
            this.iuF = (com.baidu.tieba.card.data.g) cVar;
            this.fSE.setTag(this.iuF.forumAvatar);
            this.fSE.setTag(R.id.tag_forum_name, this.iuF.forumName);
            this.fSE.startLoad(this.iuF.forumAvatar, 15, false);
            this.fSF.setText(au.getFixedText(this.iuF.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.fSF.setTag(R.id.tag_forum_name, this.iuF.forumName);
            this.fSH.setTag(R.id.tag_forum_id, Long.valueOf(this.iuF.forumId));
            this.fSH.setTag(R.id.tag_forum_name, this.iuF.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.iuF.forumId));
            getView().setTag(R.id.tag_forum_name, this.iuF.forumName);
            a(this.fSH, this.iuF.isLiked);
            this.fSE.setOnClickListener(this.onClickListener);
            this.fSH.setOnClickListener(this.onClickListener);
            this.fSF.setOnClickListener(this.onClickListener);
            getView().setOnClickListener(this.onClickListener);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder cI(View view) {
        CardExtendForumItemHolder cardExtendForumItemHolder = new CardExtendForumItemHolder(view);
        cardExtendForumItemHolder.fSE = (BarImageView) view.findViewById(R.id.forum_avatar);
        cardExtendForumItemHolder.fSE.setGifIconSupport(false);
        cardExtendForumItemHolder.fSF = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cardExtendForumItemHolder.fSH = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        cardExtendForumItemHolder.ksf = 16908308;
        return cardExtendForumItemHolder;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(getView(), R.color.CAM_X0201);
            ap.setViewTextColor(this.fSF, R.color.CAM_X0105);
            a(this.fSH, this.iuF.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.aM(z);
        }
    }
}
