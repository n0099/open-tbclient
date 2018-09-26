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
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.horizonalList.widget.e {
    public BarImageView beJ;
    public TextView beK;
    public EntelechyUserLikeButton beM;
    private com.baidu.tieba.card.data.e cCn;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.beJ = null;
        this.beK = null;
        this.beM = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.e)) {
            this.cCn = (com.baidu.tieba.card.data.e) cVar;
            this.beJ.setTag(this.cCn.forumAvatar);
            this.beJ.setTag(e.g.tag_forum_name, this.cCn.forumName);
            this.beJ.startLoad(this.cCn.forumAvatar, 15, false);
            this.beK.setText(ao.getFixedText(this.cCn.forumName, 4, true) + getView().getContext().getResources().getString(e.j.forum));
            this.beK.setTag(e.g.tag_forum_name, this.cCn.forumName);
            this.beM.setTag(e.g.tag_forum_id, Long.valueOf(this.cCn.forumId));
            this.beM.setTag(e.g.tag_forum_name, this.cCn.forumName);
            getView().setTag(e.g.tag_forum_id, Long.valueOf(this.cCn.forumId));
            getView().setTag(e.g.tag_forum_name, this.cCn.forumName);
            a(this.beM, this.cCn.isLiked);
            this.beJ.setOnClickListener(this.aKh);
            this.beM.setOnClickListener(this.aKh);
            this.beK.setOnClickListener(this.aKh);
            getView().setOnClickListener(this.aKh);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e aw(View view) {
        d dVar = new d(view);
        dVar.beJ = (BarImageView) view.findViewById(e.g.forum_avatar);
        dVar.beJ.setGifIconSupport(false);
        dVar.beK = (TextView) view.findViewById(e.g.m_forum_name_textview);
        dVar.beM = (EntelechyUserLikeButton) view.findViewById(e.g.forum_add_love);
        dVar.eiT = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.j(getView(), e.d.cp_bg_line_d);
            al.h(this.beK, e.d.cp_cont_b);
            a(this.beM, this.cCn.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(e.g.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.bi(z);
        }
    }
}
