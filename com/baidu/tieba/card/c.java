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
    public EntelechyUserLikeButton elA;
    public BarImageView elx;
    public TextView ely;
    private com.baidu.tieba.card.data.g gna;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.elx = null;
        this.ely = null;
        this.elA = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.g)) {
            this.gna = (com.baidu.tieba.card.data.g) cVar;
            this.elx.setTag(this.gna.forumAvatar);
            this.elx.setTag(R.id.tag_forum_name, this.gna.forumName);
            this.elx.startLoad(this.gna.forumAvatar, 15, false);
            this.ely.setText(aq.getFixedText(this.gna.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.ely.setTag(R.id.tag_forum_name, this.gna.forumName);
            this.elA.setTag(R.id.tag_forum_id, Long.valueOf(this.gna.forumId));
            this.elA.setTag(R.id.tag_forum_name, this.gna.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.gna.forumId));
            getView().setTag(R.id.tag_forum_name, this.gna.forumName);
            a(this.elA, this.gna.isLiked);
            this.elx.setOnClickListener(this.dRK);
            this.elA.setOnClickListener(this.dRK);
            this.ely.setOnClickListener(this.dRK);
            getView().setOnClickListener(this.dRK);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bI(View view) {
        c cVar = new c(view);
        cVar.elx = (BarImageView) view.findViewById(R.id.forum_avatar);
        cVar.elx.setGifIconSupport(false);
        cVar.ely = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cVar.elA = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        cVar.hVq = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(this.ely, (int) R.color.cp_cont_b);
            a(this.elA, this.gna.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.gT(z);
        }
    }
}
