package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.horizonalList.widget.e {
    public BarImageView cyC;
    public TextView cyD;
    public EntelechyUserLikeButton cyF;
    private com.baidu.tieba.card.data.e efr;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.cyC = null;
        this.cyD = null;
        this.cyF = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.e)) {
            this.efr = (com.baidu.tieba.card.data.e) cVar;
            this.cyC.setTag(this.efr.forumAvatar);
            this.cyC.setTag(d.g.tag_forum_name, this.efr.forumName);
            this.cyC.startLoad(this.efr.forumAvatar, 15, false);
            this.cyD.setText(ap.getFixedText(this.efr.forumName, 4, true) + getView().getContext().getResources().getString(d.j.forum));
            this.cyD.setTag(d.g.tag_forum_name, this.efr.forumName);
            this.cyF.setTag(d.g.tag_forum_id, Long.valueOf(this.efr.forumId));
            this.cyF.setTag(d.g.tag_forum_name, this.efr.forumName);
            getView().setTag(d.g.tag_forum_id, Long.valueOf(this.efr.forumId));
            getView().setTag(d.g.tag_forum_name, this.efr.forumName);
            a(this.cyF, this.efr.isLiked);
            this.cyC.setOnClickListener(this.ccC);
            this.cyF.setOnClickListener(this.ccC);
            this.cyD.setOnClickListener(this.ccC);
            getView().setOnClickListener(this.ccC);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bv(View view) {
        c cVar = new c(view);
        cVar.cyC = (BarImageView) view.findViewById(d.g.forum_avatar);
        cVar.cyC.setGifIconSupport(false);
        cVar.cyD = (TextView) view.findViewById(d.g.m_forum_name_textview);
        cVar.cyF = (EntelechyUserLikeButton) view.findViewById(d.g.forum_add_love);
        cVar.fSy = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.l(getView(), d.C0277d.cp_bg_line_d);
            al.j(this.cyD, d.C0277d.cp_cont_b);
            a(this.cyF, this.efr.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(d.g.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.dU(z);
        }
    }
}
