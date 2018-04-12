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
    public BarImageView aSs;
    public TextView aSt;
    public EntelechyUserLikeButton aSv;
    private com.baidu.tieba.card.data.e cmg;
    private int mSkinType;

    public d(View view2) {
        super(view2);
        this.aSs = null;
        this.aSt = null;
        this.aSv = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.e)) {
            this.cmg = (com.baidu.tieba.card.data.e) cVar;
            this.aSs.setTag(this.cmg.forumAvatar);
            this.aSs.setTag(d.g.tag_forum_name, this.cmg.forumName);
            this.aSs.startLoad(this.cmg.forumAvatar, 15, false);
            this.aSt.setText(an.getFixedText(this.cmg.forumName, 4, true) + getView().getContext().getResources().getString(d.k.forum));
            this.aSt.setTag(d.g.tag_forum_name, this.cmg.forumName);
            this.aSv.setTag(d.g.tag_forum_id, Long.valueOf(this.cmg.forumId));
            this.aSv.setTag(d.g.tag_forum_name, this.cmg.forumName);
            getView().setTag(d.g.tag_forum_id, Long.valueOf(this.cmg.forumId));
            getView().setTag(d.g.tag_forum_name, this.cmg.forumName);
            a(this.aSv, this.cmg.isLiked);
            this.aSs.setOnClickListener(this.axG);
            this.aSv.setOnClickListener(this.axG);
            this.aSt.setOnClickListener(this.axG);
            getView().setOnClickListener(this.axG);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ad(View view2) {
        d dVar = new d(view2);
        dVar.aSs = (BarImageView) view2.findViewById(d.g.forum_avatar);
        dVar.aSs.setGifIconSupport(false);
        dVar.aSt = (TextView) view2.findViewById(d.g.m_forum_name_textview);
        dVar.aSv = (EntelechyUserLikeButton) view2.findViewById(d.g.forum_add_love);
        dVar.dHB = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.j(getView(), d.C0126d.cp_bg_line_d);
            ak.h(this.aSt, d.C0126d.cp_cont_b);
            a(this.aSv, this.cmg.isLiked);
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
