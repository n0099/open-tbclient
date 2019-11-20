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
    public BarImageView cSt;
    public TextView cSu;
    public EntelechyUserLikeButton cSw;
    private com.baidu.tieba.card.data.e eJM;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.cSt = null;
        this.cSu = null;
        this.cSw = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.e)) {
            this.eJM = (com.baidu.tieba.card.data.e) cVar;
            this.cSt.setTag(this.eJM.forumAvatar);
            this.cSt.setTag(R.id.tag_forum_name, this.eJM.forumName);
            this.cSt.startLoad(this.eJM.forumAvatar, 15, false);
            this.cSu.setText(aq.getFixedText(this.eJM.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.cSu.setTag(R.id.tag_forum_name, this.eJM.forumName);
            this.cSw.setTag(R.id.tag_forum_id, Long.valueOf(this.eJM.forumId));
            this.cSw.setTag(R.id.tag_forum_name, this.eJM.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.eJM.forumId));
            getView().setTag(R.id.tag_forum_name, this.eJM.forumName);
            a(this.cSw, this.eJM.isLiked);
            this.cSt.setOnClickListener(this.cze);
            this.cSw.setOnClickListener(this.cze);
            this.cSu.setOnClickListener(this.cze);
            getView().setOnClickListener(this.cze);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bB(View view) {
        c cVar = new c(view);
        cVar.cSt = (BarImageView) view.findViewById(R.id.forum_avatar);
        cVar.cSt.setGifIconSupport(false);
        cVar.cSu = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cVar.cSw = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        cVar.gqg = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(this.cSu, (int) R.color.cp_cont_b);
            a(this.cSw, this.eJM.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.ew(z);
        }
    }
}
