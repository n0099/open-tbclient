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
public class d extends com.baidu.tieba.horizonalList.widget.e {
    public BarImageView eAn;
    public TextView eAo;
    public EntelechyUserLikeButton eAq;
    private com.baidu.tieba.card.data.g gCf;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.eAn = null;
        this.eAo = null;
        this.eAq = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.g)) {
            this.gCf = (com.baidu.tieba.card.data.g) cVar;
            this.eAn.setTag(this.gCf.forumAvatar);
            this.eAn.setTag(R.id.tag_forum_name, this.gCf.forumName);
            this.eAn.startLoad(this.gCf.forumAvatar, 15, false);
            this.eAo.setText(aq.getFixedText(this.gCf.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.eAo.setTag(R.id.tag_forum_name, this.gCf.forumName);
            this.eAq.setTag(R.id.tag_forum_id, Long.valueOf(this.gCf.forumId));
            this.eAq.setTag(R.id.tag_forum_name, this.gCf.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.gCf.forumId));
            getView().setTag(R.id.tag_forum_name, this.gCf.forumName);
            a(this.eAq, this.gCf.isLiked);
            this.eAn.setOnClickListener(this.ege);
            this.eAq.setOnClickListener(this.ege);
            this.eAo.setOnClickListener(this.ege);
            getView().setOnClickListener(this.ege);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bH(View view) {
        d dVar = new d(view);
        dVar.eAn = (BarImageView) view.findViewById(R.id.forum_avatar);
        dVar.eAn.setGifIconSupport(false);
        dVar.eAo = (TextView) view.findViewById(R.id.m_forum_name_textview);
        dVar.eAq = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        dVar.ikO = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(this.eAo, (int) R.color.cp_cont_b);
            a(this.eAq, this.gCf.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.hr(z);
        }
    }
}
