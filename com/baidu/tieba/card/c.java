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
    public BarImageView cIh;
    public TextView cIi;
    public EntelechyUserLikeButton cIk;
    private com.baidu.tieba.card.data.e eAf;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.cIh = null;
        this.cIi = null;
        this.cIk = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.e)) {
            this.eAf = (com.baidu.tieba.card.data.e) cVar;
            this.cIh.setTag(this.eAf.forumAvatar);
            this.cIh.setTag(R.id.tag_forum_name, this.eAf.forumName);
            this.cIh.startLoad(this.eAf.forumAvatar, 15, false);
            this.cIi.setText(aq.getFixedText(this.eAf.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.cIi.setTag(R.id.tag_forum_name, this.eAf.forumName);
            this.cIk.setTag(R.id.tag_forum_id, Long.valueOf(this.eAf.forumId));
            this.cIk.setTag(R.id.tag_forum_name, this.eAf.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.eAf.forumId));
            getView().setTag(R.id.tag_forum_name, this.eAf.forumName);
            a(this.cIk, this.eAf.isLiked);
            this.cIh.setOnClickListener(this.clU);
            this.cIk.setOnClickListener(this.clU);
            this.cIi.setOnClickListener(this.clU);
            getView().setOnClickListener(this.clU);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bE(View view) {
        c cVar = new c(view);
        cVar.cIh = (BarImageView) view.findViewById(R.id.forum_avatar);
        cVar.cIh.setGifIconSupport(false);
        cVar.cIi = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cVar.cIk = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        cVar.gqb = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.l(getView(), R.color.cp_bg_line_d);
            am.j(this.cIi, R.color.cp_cont_b);
            a(this.cIk, this.eAf.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.ev(z);
        }
    }
}
