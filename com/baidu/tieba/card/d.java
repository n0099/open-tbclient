package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class d extends com.baidu.tieba.horizonalList.widget.e {
    public BarImageView eJC;
    public TextView eJD;
    public EntelechyUserLikeButton eJF;
    private com.baidu.tieba.card.data.g gOV;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.eJC = null;
        this.eJD = null;
        this.eJF = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.g)) {
            this.gOV = (com.baidu.tieba.card.data.g) cVar;
            this.eJC.setTag(this.gOV.forumAvatar);
            this.eJC.setTag(R.id.tag_forum_name, this.gOV.forumName);
            this.eJC.startLoad(this.gOV.forumAvatar, 15, false);
            this.eJD.setText(ar.getFixedText(this.gOV.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.eJD.setTag(R.id.tag_forum_name, this.gOV.forumName);
            this.eJF.setTag(R.id.tag_forum_id, Long.valueOf(this.gOV.forumId));
            this.eJF.setTag(R.id.tag_forum_name, this.gOV.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.gOV.forumId));
            getView().setTag(R.id.tag_forum_name, this.gOV.forumName);
            a(this.eJF, this.gOV.isLiked);
            this.eJC.setOnClickListener(this.eoP);
            this.eJF.setOnClickListener(this.eoP);
            this.eJD.setOnClickListener(this.eoP);
            getView().setOnClickListener(this.eoP);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bL(View view) {
        d dVar = new d(view);
        dVar.eJC = (BarImageView) view.findViewById(R.id.forum_avatar);
        dVar.eJC.setGifIconSupport(false);
        dVar.eJD = (TextView) view.findViewById(R.id.m_forum_name_textview);
        dVar.eJF = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        dVar.iBQ = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            an.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            an.setViewTextColor(this.eJD, (int) R.color.cp_cont_b);
            a(this.eJF, this.gOV.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.hA(z);
        }
    }
}
