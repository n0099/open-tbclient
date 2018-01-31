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
    public BarImageView cSQ;
    public TextView cSR;
    public EntelechyUserLikeButton cSS;
    private com.baidu.tieba.card.data.e cST;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.cSQ = null;
        this.cSR = null;
        this.cSS = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar != null && (dVar instanceof com.baidu.tieba.card.data.e)) {
            this.cST = (com.baidu.tieba.card.data.e) dVar;
            this.cSQ.setTag(this.cST.forumAvatar);
            this.cSQ.setTag(d.g.tag_forum_name, this.cST.forumName);
            this.cSQ.startLoad(this.cST.forumAvatar, 15, false);
            this.cSR.setText(am.getFixedText(this.cST.forumName, 4, true) + getView().getContext().getResources().getString(d.j.forum));
            this.cSR.setTag(d.g.tag_forum_name, this.cST.forumName);
            this.cSS.setTag(d.g.tag_forum_id, Long.valueOf(this.cST.forumId));
            this.cSS.setTag(d.g.tag_forum_name, this.cST.forumName);
            getView().setTag(d.g.tag_forum_id, Long.valueOf(this.cST.forumId));
            getView().setTag(d.g.tag_forum_name, this.cST.forumName);
            a(this.cSS, this.cST.isLiked);
            this.cSQ.setOnClickListener(this.bjO);
            this.cSS.setOnClickListener(this.bjO);
            this.cSR.setOnClickListener(this.bjO);
            getView().setOnClickListener(this.bjO);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f bA(View view) {
        d dVar = new d(view);
        dVar.cSQ = (BarImageView) view.findViewById(d.g.forum_avatar);
        dVar.cSQ.setGifIconSupport(false);
        dVar.cSR = (TextView) view.findViewById(d.g.m_forum_name_textview);
        dVar.cSS = (EntelechyUserLikeButton) view.findViewById(d.g.forum_add_love);
        dVar.eiL = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.t(getView(), d.C0108d.cp_bg_line_d);
            aj.r(this.cSR, d.C0108d.cp_cont_b);
            a(this.cSS, this.cST.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(d.g.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.bu(z);
        }
    }
}
