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
    public BarImageView dKX;
    public TextView dKY;
    public EntelechyUserLikeButton dLa;
    private com.baidu.tieba.card.data.g fHr;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.dKX = null;
        this.dKY = null;
        this.dLa = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.g)) {
            this.fHr = (com.baidu.tieba.card.data.g) cVar;
            this.dKX.setTag(this.fHr.forumAvatar);
            this.dKX.setTag(R.id.tag_forum_name, this.fHr.forumName);
            this.dKX.startLoad(this.fHr.forumAvatar, 15, false);
            this.dKY.setText(aq.getFixedText(this.fHr.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.dKY.setTag(R.id.tag_forum_name, this.fHr.forumName);
            this.dLa.setTag(R.id.tag_forum_id, Long.valueOf(this.fHr.forumId));
            this.dLa.setTag(R.id.tag_forum_name, this.fHr.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.fHr.forumId));
            getView().setTag(R.id.tag_forum_name, this.fHr.forumName);
            a(this.dLa, this.fHr.isLiked);
            this.dKX.setOnClickListener(this.drh);
            this.dLa.setOnClickListener(this.drh);
            this.dKY.setOnClickListener(this.drh);
            getView().setOnClickListener(this.drh);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bD(View view) {
        c cVar = new c(view);
        cVar.dKX = (BarImageView) view.findViewById(R.id.forum_avatar);
        cVar.dKX.setGifIconSupport(false);
        cVar.dKY = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cVar.dLa = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        cVar.hjN = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(this.dKY, (int) R.color.cp_cont_b);
            a(this.dLa, this.fHr.isLiked);
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
