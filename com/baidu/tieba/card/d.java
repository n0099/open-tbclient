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
    public BarImageView bbq;
    public TextView bbr;
    public EntelechyUserLikeButton bbt;
    private com.baidu.tieba.card.data.e cwA;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.bbq = null;
        this.bbr = null;
        this.bbt = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.e)) {
            this.cwA = (com.baidu.tieba.card.data.e) cVar;
            this.bbq.setTag(this.cwA.forumAvatar);
            this.bbq.setTag(d.g.tag_forum_name, this.cwA.forumName);
            this.bbq.startLoad(this.cwA.forumAvatar, 15, false);
            this.bbr.setText(ap.getFixedText(this.cwA.forumName, 4, true) + getView().getContext().getResources().getString(d.j.forum));
            this.bbr.setTag(d.g.tag_forum_name, this.cwA.forumName);
            this.bbt.setTag(d.g.tag_forum_id, Long.valueOf(this.cwA.forumId));
            this.bbt.setTag(d.g.tag_forum_name, this.cwA.forumName);
            getView().setTag(d.g.tag_forum_id, Long.valueOf(this.cwA.forumId));
            getView().setTag(d.g.tag_forum_name, this.cwA.forumName);
            a(this.bbt, this.cwA.isLiked);
            this.bbq.setOnClickListener(this.aGU);
            this.bbt.setOnClickListener(this.aGU);
            this.bbr.setOnClickListener(this.aGU);
            getView().setOnClickListener(this.aGU);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ai(View view) {
        d dVar = new d(view);
        dVar.bbq = (BarImageView) view.findViewById(d.g.forum_avatar);
        dVar.bbq.setGifIconSupport(false);
        dVar.bbr = (TextView) view.findViewById(d.g.m_forum_name_textview);
        dVar.bbt = (EntelechyUserLikeButton) view.findViewById(d.g.forum_add_love);
        dVar.ebB = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.j(getView(), d.C0140d.cp_bg_line_d);
            am.h(this.bbr, d.C0140d.cp_cont_b);
            a(this.bbt, this.cwA.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(d.g.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.aV(z);
        }
    }
}
