package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.horizonalList.widget.e {
    public BarImageView cIo;
    public TextView cIp;
    public EntelechyUserLikeButton cIr;
    private com.baidu.tieba.card.data.e eAm;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.cIo = null;
        this.cIp = null;
        this.cIr = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.e)) {
            this.eAm = (com.baidu.tieba.card.data.e) cVar;
            this.cIo.setTag(this.eAm.forumAvatar);
            this.cIo.setTag(R.id.tag_forum_name, this.eAm.forumName);
            this.cIo.startLoad(this.eAm.forumAvatar, 15, false);
            this.cIp.setText(aq.getFixedText(this.eAm.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.cIp.setTag(R.id.tag_forum_name, this.eAm.forumName);
            this.cIr.setTag(R.id.tag_forum_id, Long.valueOf(this.eAm.forumId));
            this.cIr.setTag(R.id.tag_forum_name, this.eAm.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.eAm.forumId));
            getView().setTag(R.id.tag_forum_name, this.eAm.forumName);
            a(this.cIr, this.eAm.isLiked);
            this.cIo.setOnClickListener(this.cmb);
            this.cIr.setOnClickListener(this.cmb);
            this.cIp.setOnClickListener(this.cmb);
            getView().setOnClickListener(this.cmb);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bE(View view) {
        c cVar = new c(view);
        cVar.cIo = (BarImageView) view.findViewById(R.id.forum_avatar);
        cVar.cIo.setGifIconSupport(false);
        cVar.cIp = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cVar.cIr = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        cVar.gqT = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.l(getView(), R.color.cp_bg_line_d);
            am.j(this.cIp, R.color.cp_cont_b);
            a(this.cIr, this.eAm.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.ev(z);
        }
    }
}
