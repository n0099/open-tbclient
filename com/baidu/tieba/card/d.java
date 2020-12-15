package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class d extends com.baidu.tieba.horizonalList.widget.e {
    public BarImageView fLs;
    public TextView fLt;
    public EntelechyUserLikeButton fLv;
    private com.baidu.tieba.card.data.g ihn;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.fLs = null;
        this.fLt = null;
        this.fLv = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.g)) {
            this.ihn = (com.baidu.tieba.card.data.g) cVar;
            this.fLs.setTag(this.ihn.forumAvatar);
            this.fLs.setTag(R.id.tag_forum_name, this.ihn.forumName);
            this.fLs.startLoad(this.ihn.forumAvatar, 15, false);
            this.fLt.setText(au.getFixedText(this.ihn.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.fLt.setTag(R.id.tag_forum_name, this.ihn.forumName);
            this.fLv.setTag(R.id.tag_forum_id, Long.valueOf(this.ihn.forumId));
            this.fLv.setTag(R.id.tag_forum_name, this.ihn.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.ihn.forumId));
            getView().setTag(R.id.tag_forum_name, this.ihn.forumName);
            a(this.fLv, this.ihn.isLiked);
            this.fLs.setOnClickListener(this.foP);
            this.fLv.setOnClickListener(this.foP);
            this.fLt.setOnClickListener(this.foP);
            getView().setOnClickListener(this.foP);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e cA(View view) {
        d dVar = new d(view);
        dVar.fLs = (BarImageView) view.findViewById(R.id.forum_avatar);
        dVar.fLs.setGifIconSupport(false);
        dVar.fLt = (TextView) view.findViewById(R.id.m_forum_name_textview);
        dVar.fLv = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        dVar.kbr = 16908308;
        return dVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(getView(), R.color.CAM_X0201);
            ap.setViewTextColor(this.fLt, R.color.CAM_X0105);
            a(this.fLv, this.ihn.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.aP(z);
        }
    }
}
