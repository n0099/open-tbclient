package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.horizonalList.widget.e {
    public BarImageView ban;
    public TextView bao;
    public EntelechyUserLikeButton baq;
    private com.baidu.tieba.card.data.e cvR;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.ban = null;
        this.bao = null;
        this.baq = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.e)) {
            this.cvR = (com.baidu.tieba.card.data.e) cVar;
            this.ban.setTag(this.cvR.forumAvatar);
            this.ban.setTag(d.g.tag_forum_name, this.cvR.forumName);
            this.ban.startLoad(this.cvR.forumAvatar, 15, false);
            this.bao.setText(ao.getFixedText(this.cvR.forumName, 4, true) + getView().getContext().getResources().getString(d.k.forum));
            this.bao.setTag(d.g.tag_forum_name, this.cvR.forumName);
            this.baq.setTag(d.g.tag_forum_id, Long.valueOf(this.cvR.forumId));
            this.baq.setTag(d.g.tag_forum_name, this.cvR.forumName);
            getView().setTag(d.g.tag_forum_id, Long.valueOf(this.cvR.forumId));
            getView().setTag(d.g.tag_forum_name, this.cvR.forumName);
            a(this.baq, this.cvR.isLiked);
            this.ban.setOnClickListener(this.aGc);
            this.baq.setOnClickListener(this.aGc);
            this.bao.setOnClickListener(this.aGc);
            getView().setOnClickListener(this.aGc);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ad(View view) {
        d dVar = new d(view);
        dVar.ban = (BarImageView) view.findViewById(d.g.forum_avatar);
        dVar.ban.setGifIconSupport(false);
        dVar.bao = (TextView) view.findViewById(d.g.m_forum_name_textview);
        dVar.baq = (EntelechyUserLikeButton) view.findViewById(d.g.forum_add_love);
        dVar.dTP = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.j(getView(), d.C0141d.cp_bg_line_d);
            al.h(this.bao, d.C0141d.cp_cont_b);
            a(this.baq, this.cvR.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(d.g.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.aU(z);
        }
    }
}
