package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class c extends com.baidu.tieba.horizonalList.widget.e {
    public BarImageView dKY;
    public TextView dKZ;
    public EntelechyUserLikeButton dLb;
    private com.baidu.tieba.card.data.g fHt;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.dKY = null;
        this.dKZ = null;
        this.dLb = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.g)) {
            this.fHt = (com.baidu.tieba.card.data.g) cVar;
            this.dKY.setTag(this.fHt.forumAvatar);
            this.dKY.setTag(R.id.tag_forum_name, this.fHt.forumName);
            this.dKY.startLoad(this.fHt.forumAvatar, 15, false);
            this.dKZ.setText(aq.getFixedText(this.fHt.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.dKZ.setTag(R.id.tag_forum_name, this.fHt.forumName);
            this.dLb.setTag(R.id.tag_forum_id, Long.valueOf(this.fHt.forumId));
            this.dLb.setTag(R.id.tag_forum_name, this.fHt.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.fHt.forumId));
            getView().setTag(R.id.tag_forum_name, this.fHt.forumName);
            a(this.dLb, this.fHt.isLiked);
            this.dKY.setOnClickListener(this.dri);
            this.dLb.setOnClickListener(this.dri);
            this.dKZ.setOnClickListener(this.dri);
            getView().setOnClickListener(this.dri);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bD(View view) {
        c cVar = new c(view);
        cVar.dKY = (BarImageView) view.findViewById(R.id.forum_avatar);
        cVar.dKY.setGifIconSupport(false);
        cVar.dKZ = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cVar.dLb = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        cVar.hjP = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(this.dKZ, (int) R.color.cp_cont_b);
            a(this.dLb, this.fHt.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.fU(z);
        }
    }
}
