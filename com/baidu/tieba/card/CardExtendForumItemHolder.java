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
    public BarImageView fQr;
    public TextView fQs;
    public EntelechyUserLikeButton fQu;
    private com.baidu.tieba.card.data.g ipb;
    private int mSkinType;

    public CardExtendForumItemHolder(View view) {
        super(view);
        this.fQr = null;
        this.fQs = null;
        this.fQu = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.g)) {
            this.ipb = (com.baidu.tieba.card.data.g) cVar;
            this.fQr.setTag(this.ipb.forumAvatar);
            this.fQr.setTag(R.id.tag_forum_name, this.ipb.forumName);
            this.fQr.startLoad(this.ipb.forumAvatar, 15, false);
            this.fQs.setText(at.getFixedText(this.ipb.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.fQs.setTag(R.id.tag_forum_name, this.ipb.forumName);
            this.fQu.setTag(R.id.tag_forum_id, Long.valueOf(this.ipb.forumId));
            this.fQu.setTag(R.id.tag_forum_name, this.ipb.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.ipb.forumId));
            getView().setTag(R.id.tag_forum_name, this.ipb.forumName);
            a(this.fQu, this.ipb.isLiked);
            this.fQr.setOnClickListener(this.onClickListener);
            this.fQu.setOnClickListener(this.onClickListener);
            this.fQs.setOnClickListener(this.onClickListener);
            getView().setOnClickListener(this.onClickListener);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder cK(View view) {
        CardExtendForumItemHolder cardExtendForumItemHolder = new CardExtendForumItemHolder(view);
        cardExtendForumItemHolder.fQr = (BarImageView) view.findViewById(R.id.forum_avatar);
        cardExtendForumItemHolder.fQr.setGifIconSupport(false);
        cardExtendForumItemHolder.fQs = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cardExtendForumItemHolder.fQu = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        cardExtendForumItemHolder.kjY = 16908308;
        return cardExtendForumItemHolder;
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundColor(getView(), R.color.CAM_X0201);
            ao.setViewTextColor(this.fQs, R.color.CAM_X0105);
            a(this.fQu, this.ipb.isLiked);
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
