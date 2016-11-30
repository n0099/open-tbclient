package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.horizonalList.widget.n {
    public BarImageView bbH;
    public TextView bbI;
    public EntelechyUserLikeButton bbJ;
    private com.baidu.tieba.card.data.e bbK;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.bbH = null;
        this.bbI = null;
        this.bbJ = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void a(com.baidu.tieba.horizonalList.widget.l lVar) {
        if (lVar != null && (lVar instanceof com.baidu.tieba.card.data.e)) {
            this.bbK = (com.baidu.tieba.card.data.e) lVar;
            this.bbH.setTag(this.bbK.forumAvatar);
            this.bbH.setTag(r.g.tag_forum_name, this.bbK.forumName);
            this.bbH.c(this.bbK.forumAvatar, 15, false);
            this.bbI.setText(String.valueOf(com.baidu.tbadk.core.util.ax.getFixedText(this.bbK.forumName, 4, true)) + getView().getContext().getResources().getString(r.j.forum));
            this.bbI.setTag(r.g.tag_forum_name, this.bbK.forumName);
            this.bbJ.setTag(r.g.tag_forum_id, Long.valueOf(this.bbK.forumId));
            this.bbJ.setTag(r.g.tag_forum_name, this.bbK.forumName);
            getView().setTag(r.g.tag_forum_id, Long.valueOf(this.bbK.forumId));
            getView().setTag(r.g.tag_forum_name, this.bbK.forumName);
            a(this.bbJ, this.bbK.isLiked);
            this.bbH.setOnClickListener(this.aoz);
            this.bbJ.setOnClickListener(this.aoz);
            this.bbI.setOnClickListener(this.aoz);
            getView().setOnClickListener(this.aoz);
        }
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public com.baidu.tieba.horizonalList.widget.n T(View view) {
        c cVar = new c(view);
        cVar.bbH = (BarImageView) view.findViewById(r.g.forum_avatar);
        cVar.bbH.setGifIconSupport(false);
        cVar.bbI = (TextView) view.findViewById(r.g.m_forum_name_textview);
        cVar.bbJ = (EntelechyUserLikeButton) view.findViewById(r.g.forum_add_love);
        cVar.cSn = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.l(getView(), r.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.j((View) this.bbI, r.d.cp_cont_b);
            a(this.bbJ, this.bbK.isLiked);
        }
        this.mSkinType = i;
    }

    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(r.g.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.aO(z);
        }
    }
}
