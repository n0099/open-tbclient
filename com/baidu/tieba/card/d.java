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
    public BarImageView cSv;
    public TextView cSw;
    public EntelechyUserLikeButton cSx;
    private com.baidu.tieba.card.data.e cSy;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.cSv = null;
        this.cSw = null;
        this.cSx = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar != null && (dVar instanceof com.baidu.tieba.card.data.e)) {
            this.cSy = (com.baidu.tieba.card.data.e) dVar;
            this.cSv.setTag(this.cSy.forumAvatar);
            this.cSv.setTag(d.g.tag_forum_name, this.cSy.forumName);
            this.cSv.startLoad(this.cSy.forumAvatar, 15, false);
            this.cSw.setText(am.getFixedText(this.cSy.forumName, 4, true) + getView().getContext().getResources().getString(d.j.forum));
            this.cSw.setTag(d.g.tag_forum_name, this.cSy.forumName);
            this.cSx.setTag(d.g.tag_forum_id, Long.valueOf(this.cSy.forumId));
            this.cSx.setTag(d.g.tag_forum_name, this.cSy.forumName);
            getView().setTag(d.g.tag_forum_id, Long.valueOf(this.cSy.forumId));
            getView().setTag(d.g.tag_forum_name, this.cSy.forumName);
            a(this.cSx, this.cSy.isLiked);
            this.cSv.setOnClickListener(this.bjG);
            this.cSx.setOnClickListener(this.bjG);
            this.cSw.setOnClickListener(this.bjG);
            getView().setOnClickListener(this.bjG);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f bA(View view) {
        d dVar = new d(view);
        dVar.cSv = (BarImageView) view.findViewById(d.g.forum_avatar);
        dVar.cSv.setGifIconSupport(false);
        dVar.cSw = (TextView) view.findViewById(d.g.m_forum_name_textview);
        dVar.cSx = (EntelechyUserLikeButton) view.findViewById(d.g.forum_add_love);
        dVar.eiq = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.t(getView(), d.C0107d.cp_bg_line_d);
            aj.r(this.cSw, d.C0107d.cp_cont_b);
            a(this.cSx, this.cSy.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(d.g.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.bt(z);
        }
    }
}
