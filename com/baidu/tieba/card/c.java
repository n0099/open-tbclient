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
/* loaded from: classes5.dex */
public class c extends com.baidu.tieba.horizonalList.widget.e {
    public BarImageView dGJ;
    public TextView dGK;
    public EntelechyUserLikeButton dGM;
    private com.baidu.tieba.card.data.g fBJ;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.dGJ = null;
        this.dGK = null;
        this.dGM = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.g)) {
            this.fBJ = (com.baidu.tieba.card.data.g) cVar;
            this.dGJ.setTag(this.fBJ.forumAvatar);
            this.dGJ.setTag(R.id.tag_forum_name, this.fBJ.forumName);
            this.dGJ.startLoad(this.fBJ.forumAvatar, 15, false);
            this.dGK.setText(aq.getFixedText(this.fBJ.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.dGK.setTag(R.id.tag_forum_name, this.fBJ.forumName);
            this.dGM.setTag(R.id.tag_forum_id, Long.valueOf(this.fBJ.forumId));
            this.dGM.setTag(R.id.tag_forum_name, this.fBJ.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.fBJ.forumId));
            getView().setTag(R.id.tag_forum_name, this.fBJ.forumName);
            a(this.dGM, this.fBJ.isLiked);
            this.dGJ.setOnClickListener(this.dmK);
            this.dGM.setOnClickListener(this.dmK);
            this.dGK.setOnClickListener(this.dmK);
            getView().setOnClickListener(this.dmK);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e by(View view) {
        c cVar = new c(view);
        cVar.dGJ = (BarImageView) view.findViewById(R.id.forum_avatar);
        cVar.dGJ.setGifIconSupport(false);
        cVar.dGK = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cVar.dGM = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        cVar.hej = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(this.dGK, (int) R.color.cp_cont_b);
            a(this.dGM, this.fBJ.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.fI(z);
        }
    }
}
