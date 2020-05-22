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
    public BarImageView eAc;
    public TextView eAd;
    public EntelechyUserLikeButton eAf;
    private com.baidu.tieba.card.data.g gBU;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.eAc = null;
        this.eAd = null;
        this.eAf = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.g)) {
            this.gBU = (com.baidu.tieba.card.data.g) cVar;
            this.eAc.setTag(this.gBU.forumAvatar);
            this.eAc.setTag(R.id.tag_forum_name, this.gBU.forumName);
            this.eAc.startLoad(this.gBU.forumAvatar, 15, false);
            this.eAd.setText(aq.getFixedText(this.gBU.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.eAd.setTag(R.id.tag_forum_name, this.gBU.forumName);
            this.eAf.setTag(R.id.tag_forum_id, Long.valueOf(this.gBU.forumId));
            this.eAf.setTag(R.id.tag_forum_name, this.gBU.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.gBU.forumId));
            getView().setTag(R.id.tag_forum_name, this.gBU.forumName);
            a(this.eAf, this.gBU.isLiked);
            this.eAc.setOnClickListener(this.ege);
            this.eAf.setOnClickListener(this.ege);
            this.eAd.setOnClickListener(this.ege);
            getView().setOnClickListener(this.ege);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bH(View view) {
        d dVar = new d(view);
        dVar.eAc = (BarImageView) view.findViewById(R.id.forum_avatar);
        dVar.eAc.setGifIconSupport(false);
        dVar.eAd = (TextView) view.findViewById(R.id.m_forum_name_textview);
        dVar.eAf = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        dVar.ikb = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(this.eAd, (int) R.color.cp_cont_b);
            a(this.eAf, this.gBU.isLiked);
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
