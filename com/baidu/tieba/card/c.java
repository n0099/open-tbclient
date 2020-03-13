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
    public BarImageView dLl;
    public TextView dLm;
    public EntelechyUserLikeButton dLo;
    private com.baidu.tieba.card.data.g fHG;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.dLl = null;
        this.dLm = null;
        this.dLo = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.g)) {
            this.fHG = (com.baidu.tieba.card.data.g) cVar;
            this.dLl.setTag(this.fHG.forumAvatar);
            this.dLl.setTag(R.id.tag_forum_name, this.fHG.forumName);
            this.dLl.startLoad(this.fHG.forumAvatar, 15, false);
            this.dLm.setText(aq.getFixedText(this.fHG.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.dLm.setTag(R.id.tag_forum_name, this.fHG.forumName);
            this.dLo.setTag(R.id.tag_forum_id, Long.valueOf(this.fHG.forumId));
            this.dLo.setTag(R.id.tag_forum_name, this.fHG.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.fHG.forumId));
            getView().setTag(R.id.tag_forum_name, this.fHG.forumName);
            a(this.dLo, this.fHG.isLiked);
            this.dLl.setOnClickListener(this.drw);
            this.dLo.setOnClickListener(this.drw);
            this.dLm.setOnClickListener(this.drw);
            getView().setOnClickListener(this.drw);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bD(View view) {
        c cVar = new c(view);
        cVar.dLl = (BarImageView) view.findViewById(R.id.forum_avatar);
        cVar.dLl.setGifIconSupport(false);
        cVar.dLm = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cVar.dLo = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        cVar.hkb = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(this.dLm, (int) R.color.cp_cont_b);
            a(this.dLo, this.fHG.isLiked);
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
