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
    public BarImageView els;
    public TextView elt;
    public EntelechyUserLikeButton elv;
    private com.baidu.tieba.card.data.g gmU;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.els = null;
        this.elt = null;
        this.elv = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.g)) {
            this.gmU = (com.baidu.tieba.card.data.g) cVar;
            this.els.setTag(this.gmU.forumAvatar);
            this.els.setTag(R.id.tag_forum_name, this.gmU.forumName);
            this.els.startLoad(this.gmU.forumAvatar, 15, false);
            this.elt.setText(aq.getFixedText(this.gmU.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.elt.setTag(R.id.tag_forum_name, this.gmU.forumName);
            this.elv.setTag(R.id.tag_forum_id, Long.valueOf(this.gmU.forumId));
            this.elv.setTag(R.id.tag_forum_name, this.gmU.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.gmU.forumId));
            getView().setTag(R.id.tag_forum_name, this.gmU.forumName);
            a(this.elv, this.gmU.isLiked);
            this.els.setOnClickListener(this.dRF);
            this.elv.setOnClickListener(this.dRF);
            this.elt.setOnClickListener(this.dRF);
            getView().setOnClickListener(this.dRF);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bI(View view) {
        c cVar = new c(view);
        cVar.els = (BarImageView) view.findViewById(R.id.forum_avatar);
        cVar.els.setGifIconSupport(false);
        cVar.elt = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cVar.elv = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        cVar.hVk = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(this.elt, (int) R.color.cp_cont_b);
            a(this.elv, this.gmU.isLiked);
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
