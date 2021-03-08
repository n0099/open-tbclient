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
    public BarImageView fUe;
    public TextView fUf;
    public EntelechyUserLikeButton fUh;
    private com.baidu.tieba.card.data.g iwC;
    private int mSkinType;

    public CardExtendForumItemHolder(View view) {
        super(view);
        this.fUe = null;
        this.fUf = null;
        this.fUh = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.g)) {
            this.iwC = (com.baidu.tieba.card.data.g) cVar;
            this.fUe.setTag(this.iwC.forumAvatar);
            this.fUe.setTag(R.id.tag_forum_name, this.iwC.forumName);
            this.fUe.startLoad(this.iwC.forumAvatar, 15, false);
            this.fUf.setText(au.getFixedText(this.iwC.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.fUf.setTag(R.id.tag_forum_name, this.iwC.forumName);
            this.fUh.setTag(R.id.tag_forum_id, Long.valueOf(this.iwC.forumId));
            this.fUh.setTag(R.id.tag_forum_name, this.iwC.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.iwC.forumId));
            getView().setTag(R.id.tag_forum_name, this.iwC.forumName);
            a(this.fUh, this.iwC.isLiked);
            this.fUe.setOnClickListener(this.onClickListener);
            this.fUh.setOnClickListener(this.onClickListener);
            this.fUf.setOnClickListener(this.onClickListener);
            getView().setOnClickListener(this.onClickListener);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder cI(View view) {
        CardExtendForumItemHolder cardExtendForumItemHolder = new CardExtendForumItemHolder(view);
        cardExtendForumItemHolder.fUe = (BarImageView) view.findViewById(R.id.forum_avatar);
        cardExtendForumItemHolder.fUe.setGifIconSupport(false);
        cardExtendForumItemHolder.fUf = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cardExtendForumItemHolder.fUh = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        cardExtendForumItemHolder.kuv = 16908308;
        return cardExtendForumItemHolder;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(getView(), R.color.CAM_X0201);
            ap.setViewTextColor(this.fUf, R.color.CAM_X0105);
            a(this.fUh, this.iwC.isLiked);
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
