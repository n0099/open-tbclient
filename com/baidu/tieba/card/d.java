package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.horizonalList.widget.e {
    public BarImageView bbq;
    public TextView bbr;
    public EntelechyUserLikeButton bbt;
    private com.baidu.tieba.card.data.e cwx;
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
            this.cwx = (com.baidu.tieba.card.data.e) cVar;
            this.bbq.setTag(this.cwx.forumAvatar);
            this.bbq.setTag(f.g.tag_forum_name, this.cwx.forumName);
            this.bbq.startLoad(this.cwx.forumAvatar, 15, false);
            this.bbr.setText(ap.getFixedText(this.cwx.forumName, 4, true) + getView().getContext().getResources().getString(f.j.forum));
            this.bbr.setTag(f.g.tag_forum_name, this.cwx.forumName);
            this.bbt.setTag(f.g.tag_forum_id, Long.valueOf(this.cwx.forumId));
            this.bbt.setTag(f.g.tag_forum_name, this.cwx.forumName);
            getView().setTag(f.g.tag_forum_id, Long.valueOf(this.cwx.forumId));
            getView().setTag(f.g.tag_forum_name, this.cwx.forumName);
            a(this.bbt, this.cwx.isLiked);
            this.bbq.setOnClickListener(this.aGT);
            this.bbt.setOnClickListener(this.aGT);
            this.bbr.setOnClickListener(this.aGT);
            getView().setOnClickListener(this.aGT);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ai(View view) {
        d dVar = new d(view);
        dVar.bbq = (BarImageView) view.findViewById(f.g.forum_avatar);
        dVar.bbq.setGifIconSupport(false);
        dVar.bbr = (TextView) view.findViewById(f.g.m_forum_name_textview);
        dVar.bbt = (EntelechyUserLikeButton) view.findViewById(f.g.forum_add_love);
        dVar.eby = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.j(getView(), f.d.cp_bg_line_d);
            am.h(this.bbr, f.d.cp_cont_b);
            a(this.bbt, this.cwx.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(f.g.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.aW(z);
        }
    }
}
