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
    public BarImageView dLB;
    public TextView dLC;
    public EntelechyUserLikeButton dLE;
    private com.baidu.tieba.card.data.g fIo;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.dLB = null;
        this.dLC = null;
        this.dLE = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.g)) {
            this.fIo = (com.baidu.tieba.card.data.g) cVar;
            this.dLB.setTag(this.fIo.forumAvatar);
            this.dLB.setTag(R.id.tag_forum_name, this.fIo.forumName);
            this.dLB.startLoad(this.fIo.forumAvatar, 15, false);
            this.dLC.setText(aq.getFixedText(this.fIo.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.dLC.setTag(R.id.tag_forum_name, this.fIo.forumName);
            this.dLE.setTag(R.id.tag_forum_id, Long.valueOf(this.fIo.forumId));
            this.dLE.setTag(R.id.tag_forum_name, this.fIo.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.fIo.forumId));
            getView().setTag(R.id.tag_forum_name, this.fIo.forumName);
            a(this.dLE, this.fIo.isLiked);
            this.dLB.setOnClickListener(this.drJ);
            this.dLE.setOnClickListener(this.drJ);
            this.dLC.setOnClickListener(this.drJ);
            getView().setOnClickListener(this.drJ);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bD(View view) {
        c cVar = new c(view);
        cVar.dLB = (BarImageView) view.findViewById(R.id.forum_avatar);
        cVar.dLB.setGifIconSupport(false);
        cVar.dLC = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cVar.dLE = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        cVar.hlB = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(this.dLC, (int) R.color.cp_cont_b);
            a(this.dLE, this.fIo.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.fV(z);
        }
    }
}
