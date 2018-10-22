package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.horizonalList.widget.e {
    public BarImageView bjb;
    public TextView bjc;
    public EntelechyUserLikeButton bje;
    private com.baidu.tieba.card.data.e cKI;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.bjb = null;
        this.bjc = null;
        this.bje = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.e)) {
            this.cKI = (com.baidu.tieba.card.data.e) cVar;
            this.bjb.setTag(this.cKI.forumAvatar);
            this.bjb.setTag(e.g.tag_forum_name, this.cKI.forumName);
            this.bjb.startLoad(this.cKI.forumAvatar, 15, false);
            this.bjc.setText(ao.getFixedText(this.cKI.forumName, 4, true) + getView().getContext().getResources().getString(e.j.forum));
            this.bjc.setTag(e.g.tag_forum_name, this.cKI.forumName);
            this.bje.setTag(e.g.tag_forum_id, Long.valueOf(this.cKI.forumId));
            this.bje.setTag(e.g.tag_forum_name, this.cKI.forumName);
            getView().setTag(e.g.tag_forum_id, Long.valueOf(this.cKI.forumId));
            getView().setTag(e.g.tag_forum_name, this.cKI.forumName);
            a(this.bje, this.cKI.isLiked);
            this.bjb.setOnClickListener(this.aOJ);
            this.bje.setOnClickListener(this.aOJ);
            this.bjc.setOnClickListener(this.aOJ);
            getView().setOnClickListener(this.aOJ);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e aw(View view) {
        d dVar = new d(view);
        dVar.bjb = (BarImageView) view.findViewById(e.g.forum_avatar);
        dVar.bjb.setGifIconSupport(false);
        dVar.bjc = (TextView) view.findViewById(e.g.m_forum_name_textview);
        dVar.bje = (EntelechyUserLikeButton) view.findViewById(e.g.forum_add_love);
        dVar.eqL = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.j(getView(), e.d.cp_bg_line_d);
            al.h(this.bjc, e.d.cp_cont_b);
            a(this.bje, this.cKI.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(e.g.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.bs(z);
        }
    }
}
