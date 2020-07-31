package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class d extends com.baidu.tieba.horizonalList.widget.e {
    public BarImageView ePY;
    public TextView ePZ;
    public EntelechyUserLikeButton eQb;
    private com.baidu.tieba.card.data.g gUB;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.ePY = null;
        this.ePZ = null;
        this.eQb = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.g)) {
            this.gUB = (com.baidu.tieba.card.data.g) cVar;
            this.ePY.setTag(this.gUB.forumAvatar);
            this.ePY.setTag(R.id.tag_forum_name, this.gUB.forumName);
            this.ePY.startLoad(this.gUB.forumAvatar, 15, false);
            this.ePZ.setText(as.getFixedText(this.gUB.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.ePZ.setTag(R.id.tag_forum_name, this.gUB.forumName);
            this.eQb.setTag(R.id.tag_forum_id, Long.valueOf(this.gUB.forumId));
            this.eQb.setTag(R.id.tag_forum_name, this.gUB.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.gUB.forumId));
            getView().setTag(R.id.tag_forum_name, this.gUB.forumName);
            a(this.eQb, this.gUB.isLiked);
            this.ePY.setOnClickListener(this.eve);
            this.eQb.setOnClickListener(this.eve);
            this.ePZ.setOnClickListener(this.eve);
            getView().setOnClickListener(this.eve);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bR(View view) {
        d dVar = new d(view);
        dVar.ePY = (BarImageView) view.findViewById(R.id.forum_avatar);
        dVar.ePY.setGifIconSupport(false);
        dVar.ePZ = (TextView) view.findViewById(R.id.m_forum_name_textview);
        dVar.eQb = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        dVar.iHU = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            ao.setViewTextColor(this.ePZ, R.color.cp_cont_b);
            a(this.eQb, this.gUB.isLiked);
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
