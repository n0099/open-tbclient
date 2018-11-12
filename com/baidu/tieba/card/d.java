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
    public BarImageView bjM;
    public TextView bjN;
    public EntelechyUserLikeButton bjP;
    private com.baidu.tieba.card.data.e cLO;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.bjM = null;
        this.bjN = null;
        this.bjP = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.e)) {
            this.cLO = (com.baidu.tieba.card.data.e) cVar;
            this.bjM.setTag(this.cLO.forumAvatar);
            this.bjM.setTag(e.g.tag_forum_name, this.cLO.forumName);
            this.bjM.startLoad(this.cLO.forumAvatar, 15, false);
            this.bjN.setText(ao.getFixedText(this.cLO.forumName, 4, true) + getView().getContext().getResources().getString(e.j.forum));
            this.bjN.setTag(e.g.tag_forum_name, this.cLO.forumName);
            this.bjP.setTag(e.g.tag_forum_id, Long.valueOf(this.cLO.forumId));
            this.bjP.setTag(e.g.tag_forum_name, this.cLO.forumName);
            getView().setTag(e.g.tag_forum_id, Long.valueOf(this.cLO.forumId));
            getView().setTag(e.g.tag_forum_name, this.cLO.forumName);
            a(this.bjP, this.cLO.isLiked);
            this.bjM.setOnClickListener(this.aPz);
            this.bjP.setOnClickListener(this.aPz);
            this.bjN.setOnClickListener(this.aPz);
            getView().setOnClickListener(this.aPz);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ay(View view) {
        d dVar = new d(view);
        dVar.bjM = (BarImageView) view.findViewById(e.g.forum_avatar);
        dVar.bjM.setGifIconSupport(false);
        dVar.bjN = (TextView) view.findViewById(e.g.m_forum_name_textview);
        dVar.bjP = (EntelechyUserLikeButton) view.findViewById(e.g.forum_add_love);
        dVar.esf = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.j(getView(), e.d.cp_bg_line_d);
            al.h(this.bjN, e.d.cp_cont_b);
            a(this.bjP, this.cLO.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(e.g.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.bJ(z);
        }
    }
}
