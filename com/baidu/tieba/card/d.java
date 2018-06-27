package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.horizonalList.widget.e {
    public BarImageView bbj;
    public TextView bbk;
    public EntelechyUserLikeButton bbm;
    private com.baidu.tieba.card.data.e ctX;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.bbj = null;
        this.bbk = null;
        this.bbm = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.e)) {
            this.ctX = (com.baidu.tieba.card.data.e) cVar;
            this.bbj.setTag(this.ctX.forumAvatar);
            this.bbj.setTag(d.g.tag_forum_name, this.ctX.forumName);
            this.bbj.startLoad(this.ctX.forumAvatar, 15, false);
            this.bbk.setText(ap.getFixedText(this.ctX.forumName, 4, true) + getView().getContext().getResources().getString(d.k.forum));
            this.bbk.setTag(d.g.tag_forum_name, this.ctX.forumName);
            this.bbm.setTag(d.g.tag_forum_id, Long.valueOf(this.ctX.forumId));
            this.bbm.setTag(d.g.tag_forum_name, this.ctX.forumName);
            getView().setTag(d.g.tag_forum_id, Long.valueOf(this.ctX.forumId));
            getView().setTag(d.g.tag_forum_name, this.ctX.forumName);
            a(this.bbm, this.ctX.isLiked);
            this.bbj.setOnClickListener(this.aGU);
            this.bbm.setOnClickListener(this.aGU);
            this.bbk.setOnClickListener(this.aGU);
            getView().setOnClickListener(this.aGU);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e af(View view) {
        d dVar = new d(view);
        dVar.bbj = (BarImageView) view.findViewById(d.g.forum_avatar);
        dVar.bbj.setGifIconSupport(false);
        dVar.bbk = (TextView) view.findViewById(d.g.m_forum_name_textview);
        dVar.bbm = (EntelechyUserLikeButton) view.findViewById(d.g.forum_add_love);
        dVar.dXJ = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.j(getView(), d.C0142d.cp_bg_line_d);
            am.h(this.bbk, d.C0142d.cp_cont_b);
            a(this.bbm, this.ctX.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(d.g.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.aX(z);
        }
    }
}
