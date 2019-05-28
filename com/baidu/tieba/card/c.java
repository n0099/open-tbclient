package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.horizonalList.widget.e {
    public BarImageView cGM;
    public TextView cGN;
    public EntelechyUserLikeButton cGP;
    private com.baidu.tieba.card.data.e evg;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.cGM = null;
        this.cGN = null;
        this.cGP = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.e)) {
            this.evg = (com.baidu.tieba.card.data.e) cVar;
            this.cGM.setTag(this.evg.forumAvatar);
            this.cGM.setTag(R.id.tag_forum_name, this.evg.forumName);
            this.cGM.startLoad(this.evg.forumAvatar, 15, false);
            this.cGN.setText(ap.getFixedText(this.evg.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.cGN.setTag(R.id.tag_forum_name, this.evg.forumName);
            this.cGP.setTag(R.id.tag_forum_id, Long.valueOf(this.evg.forumId));
            this.cGP.setTag(R.id.tag_forum_name, this.evg.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.evg.forumId));
            getView().setTag(R.id.tag_forum_name, this.evg.forumName);
            a(this.cGP, this.evg.isLiked);
            this.cGM.setOnClickListener(this.ckH);
            this.cGP.setOnClickListener(this.ckH);
            this.cGN.setOnClickListener(this.ckH);
            getView().setOnClickListener(this.ckH);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bC(View view) {
        c cVar = new c(view);
        cVar.cGM = (BarImageView) view.findViewById(R.id.forum_avatar);
        cVar.cGM.setGifIconSupport(false);
        cVar.cGN = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cVar.cGP = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        cVar.gjM = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.l(getView(), R.color.cp_bg_line_d);
            al.j(this.cGN, R.color.cp_cont_b);
            a(this.cGP, this.evg.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.er(z);
        }
    }
}
