package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.ItemViewHolder;
/* loaded from: classes.dex */
public class CardExtendForumItemHolder extends ItemViewHolder {
    public BarImageView fUY;
    public TextView fUZ;
    public EntelechyUserLikeButton fVb;
    private com.baidu.tieba.card.data.g itI;
    private int mSkinType;

    public CardExtendForumItemHolder(View view) {
        super(view);
        this.fUY = null;
        this.fUZ = null;
        this.fVb = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.g)) {
            this.itI = (com.baidu.tieba.card.data.g) cVar;
            this.fUY.setTag(this.itI.forumAvatar);
            this.fUY.setTag(R.id.tag_forum_name, this.itI.forumName);
            this.fUY.startLoad(this.itI.forumAvatar, 15, false);
            this.fUZ.setText(at.getFixedText(this.itI.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.fUZ.setTag(R.id.tag_forum_name, this.itI.forumName);
            this.fVb.setTag(R.id.tag_forum_id, Long.valueOf(this.itI.forumId));
            this.fVb.setTag(R.id.tag_forum_name, this.itI.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.itI.forumId));
            getView().setTag(R.id.tag_forum_name, this.itI.forumName);
            a(this.fVb, this.itI.isLiked);
            this.fUY.setOnClickListener(this.onClickListener);
            this.fVb.setOnClickListener(this.onClickListener);
            this.fUZ.setOnClickListener(this.onClickListener);
            getView().setOnClickListener(this.onClickListener);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder cK(View view) {
        CardExtendForumItemHolder cardExtendForumItemHolder = new CardExtendForumItemHolder(view);
        cardExtendForumItemHolder.fUY = (BarImageView) view.findViewById(R.id.forum_avatar);
        cardExtendForumItemHolder.fUY.setGifIconSupport(false);
        cardExtendForumItemHolder.fUZ = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cardExtendForumItemHolder.fVb = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        cardExtendForumItemHolder.koD = 16908308;
        return cardExtendForumItemHolder;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundColor(getView(), R.color.CAM_X0201);
            ao.setViewTextColor(this.fUZ, R.color.CAM_X0105);
            a(this.fVb, this.itI.isLiked);
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
