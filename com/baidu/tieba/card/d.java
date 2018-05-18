package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.horizonalList.widget.e {
    public BarImageView aSt;
    public TextView aSu;
    public EntelechyUserLikeButton aSw;
    private com.baidu.tieba.card.data.e cnm;
    private int mSkinType;

    public d(View view2) {
        super(view2);
        this.aSt = null;
        this.aSu = null;
        this.aSw = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.e)) {
            this.cnm = (com.baidu.tieba.card.data.e) cVar;
            this.aSt.setTag(this.cnm.forumAvatar);
            this.aSt.setTag(d.g.tag_forum_name, this.cnm.forumName);
            this.aSt.startLoad(this.cnm.forumAvatar, 15, false);
            this.aSu.setText(an.getFixedText(this.cnm.forumName, 4, true) + getView().getContext().getResources().getString(d.k.forum));
            this.aSu.setTag(d.g.tag_forum_name, this.cnm.forumName);
            this.aSw.setTag(d.g.tag_forum_id, Long.valueOf(this.cnm.forumId));
            this.aSw.setTag(d.g.tag_forum_name, this.cnm.forumName);
            getView().setTag(d.g.tag_forum_id, Long.valueOf(this.cnm.forumId));
            getView().setTag(d.g.tag_forum_name, this.cnm.forumName);
            a(this.aSw, this.cnm.isLiked);
            this.aSt.setOnClickListener(this.axH);
            this.aSw.setOnClickListener(this.axH);
            this.aSu.setOnClickListener(this.axH);
            getView().setOnClickListener(this.axH);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ad(View view2) {
        d dVar = new d(view2);
        dVar.aSt = (BarImageView) view2.findViewById(d.g.forum_avatar);
        dVar.aSt.setGifIconSupport(false);
        dVar.aSu = (TextView) view2.findViewById(d.g.m_forum_name_textview);
        dVar.aSw = (EntelechyUserLikeButton) view2.findViewById(d.g.forum_add_love);
        dVar.dIE = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.j(getView(), d.C0126d.cp_bg_line_d);
            ak.h(this.aSu, d.C0126d.cp_cont_b);
            a(this.aSw, this.cnm.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(d.g.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.aQ(z);
        }
    }
}
