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
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.horizonalList.widget.e {
    public BarImageView cTk;
    public TextView cTl;
    public EntelechyUserLikeButton cTn;
    private com.baidu.tieba.card.data.e eKD;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.cTk = null;
        this.cTl = null;
        this.cTn = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.e)) {
            this.eKD = (com.baidu.tieba.card.data.e) cVar;
            this.cTk.setTag(this.eKD.forumAvatar);
            this.cTk.setTag(R.id.tag_forum_name, this.eKD.forumName);
            this.cTk.startLoad(this.eKD.forumAvatar, 15, false);
            this.cTl.setText(aq.getFixedText(this.eKD.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.cTl.setTag(R.id.tag_forum_name, this.eKD.forumName);
            this.cTn.setTag(R.id.tag_forum_id, Long.valueOf(this.eKD.forumId));
            this.cTn.setTag(R.id.tag_forum_name, this.eKD.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.eKD.forumId));
            getView().setTag(R.id.tag_forum_name, this.eKD.forumName);
            a(this.cTn, this.eKD.isLiked);
            this.cTk.setOnClickListener(this.czV);
            this.cTn.setOnClickListener(this.czV);
            this.cTl.setOnClickListener(this.czV);
            getView().setOnClickListener(this.czV);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bB(View view) {
        c cVar = new c(view);
        cVar.cTk = (BarImageView) view.findViewById(R.id.forum_avatar);
        cVar.cTk.setGifIconSupport(false);
        cVar.cTl = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cVar.cTn = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        cVar.gqX = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(this.cTl, (int) R.color.cp_cont_b);
            a(this.cTn, this.eKD.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.ew(z);
        }
    }
}
