package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.horizonalList.widget.f {
    public TextView cVA;
    public EntelechyUserLikeButton cVB;
    private com.baidu.tieba.card.data.e cVC;
    public BarImageView cVz;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.cVz = null;
        this.cVA = null;
        this.cVB = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar != null && (dVar instanceof com.baidu.tieba.card.data.e)) {
            this.cVC = (com.baidu.tieba.card.data.e) dVar;
            this.cVz.setTag(this.cVC.forumAvatar);
            this.cVz.setTag(d.g.tag_forum_name, this.cVC.forumName);
            this.cVz.startLoad(this.cVC.forumAvatar, 15, false);
            this.cVA.setText(am.getFixedText(this.cVC.forumName, 4, true) + getView().getContext().getResources().getString(d.j.forum));
            this.cVA.setTag(d.g.tag_forum_name, this.cVC.forumName);
            this.cVB.setTag(d.g.tag_forum_id, Long.valueOf(this.cVC.forumId));
            this.cVB.setTag(d.g.tag_forum_name, this.cVC.forumName);
            getView().setTag(d.g.tag_forum_id, Long.valueOf(this.cVC.forumId));
            getView().setTag(d.g.tag_forum_name, this.cVC.forumName);
            a(this.cVB, this.cVC.isLiked);
            this.cVz.setOnClickListener(this.blQ);
            this.cVB.setOnClickListener(this.blQ);
            this.cVA.setOnClickListener(this.blQ);
            getView().setOnClickListener(this.blQ);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f bz(View view) {
        d dVar = new d(view);
        dVar.cVz = (BarImageView) view.findViewById(d.g.forum_avatar);
        dVar.cVz.setGifIconSupport(false);
        dVar.cVA = (TextView) view.findViewById(d.g.m_forum_name_textview);
        dVar.cVB = (EntelechyUserLikeButton) view.findViewById(d.g.forum_add_love);
        dVar.emJ = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.t(getView(), d.C0141d.cp_bg_line_d);
            aj.r(this.cVA, d.C0141d.cp_cont_b);
            a(this.cVB, this.cVC.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(d.g.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.bz(z);
        }
    }
}
