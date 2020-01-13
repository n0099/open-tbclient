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
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.horizonalList.widget.e {
    public BarImageView dGS;
    public TextView dGT;
    public EntelechyUserLikeButton dGV;
    private com.baidu.tieba.card.data.g fEU;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.dGS = null;
        this.dGT = null;
        this.dGV = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.g)) {
            this.fEU = (com.baidu.tieba.card.data.g) cVar;
            this.dGS.setTag(this.fEU.forumAvatar);
            this.dGS.setTag(R.id.tag_forum_name, this.fEU.forumName);
            this.dGS.startLoad(this.fEU.forumAvatar, 15, false);
            this.dGT.setText(aq.getFixedText(this.fEU.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.dGT.setTag(R.id.tag_forum_name, this.fEU.forumName);
            this.dGV.setTag(R.id.tag_forum_id, Long.valueOf(this.fEU.forumId));
            this.dGV.setTag(R.id.tag_forum_name, this.fEU.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.fEU.forumId));
            getView().setTag(R.id.tag_forum_name, this.fEU.forumName);
            a(this.dGV, this.fEU.isLiked);
            this.dGS.setOnClickListener(this.dmY);
            this.dGV.setOnClickListener(this.dmY);
            this.dGT.setOnClickListener(this.dmY);
            getView().setOnClickListener(this.dmY);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bD(View view) {
        c cVar = new c(view);
        cVar.dGS = (BarImageView) view.findViewById(R.id.forum_avatar);
        cVar.dGS.setGifIconSupport(false);
        cVar.dGT = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cVar.dGV = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        cVar.hhM = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(this.dGT, (int) R.color.cp_cont_b);
            a(this.dGV, this.fEU.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.fN(z);
        }
    }
}
