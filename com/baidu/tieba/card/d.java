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
    public BarImageView cVL;
    public TextView cVM;
    public EntelechyUserLikeButton cVN;
    private com.baidu.tieba.card.data.e cVO;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.cVL = null;
        this.cVM = null;
        this.cVN = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar != null && (dVar instanceof com.baidu.tieba.card.data.e)) {
            this.cVO = (com.baidu.tieba.card.data.e) dVar;
            this.cVL.setTag(this.cVO.forumAvatar);
            this.cVL.setTag(d.g.tag_forum_name, this.cVO.forumName);
            this.cVL.startLoad(this.cVO.forumAvatar, 15, false);
            this.cVM.setText(am.getFixedText(this.cVO.forumName, 4, true) + getView().getContext().getResources().getString(d.j.forum));
            this.cVM.setTag(d.g.tag_forum_name, this.cVO.forumName);
            this.cVN.setTag(d.g.tag_forum_id, Long.valueOf(this.cVO.forumId));
            this.cVN.setTag(d.g.tag_forum_name, this.cVO.forumName);
            getView().setTag(d.g.tag_forum_id, Long.valueOf(this.cVO.forumId));
            getView().setTag(d.g.tag_forum_name, this.cVO.forumName);
            a(this.cVN, this.cVO.isLiked);
            this.cVL.setOnClickListener(this.bmd);
            this.cVN.setOnClickListener(this.bmd);
            this.cVM.setOnClickListener(this.bmd);
            getView().setOnClickListener(this.bmd);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f bz(View view) {
        d dVar = new d(view);
        dVar.cVL = (BarImageView) view.findViewById(d.g.forum_avatar);
        dVar.cVL.setGifIconSupport(false);
        dVar.cVM = (TextView) view.findViewById(d.g.m_forum_name_textview);
        dVar.cVN = (EntelechyUserLikeButton) view.findViewById(d.g.forum_add_love);
        dVar.emV = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.t(getView(), d.C0140d.cp_bg_line_d);
            aj.r(this.cVM, d.C0140d.cp_cont_b);
            a(this.cVN, this.cVO.isLiked);
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
