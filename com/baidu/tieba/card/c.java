package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.horizonalList.widget.n {
    public BarImageView baN;
    public TextView baO;
    public EntelechyUserLikeButton baP;
    private com.baidu.tieba.card.data.e baQ;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.baN = null;
        this.baO = null;
        this.baP = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void a(com.baidu.tieba.horizonalList.widget.l lVar) {
        if (lVar != null && (lVar instanceof com.baidu.tieba.card.data.e)) {
            this.baQ = (com.baidu.tieba.card.data.e) lVar;
            this.baN.setTag(this.baQ.forumAvatar);
            this.baN.setTag(r.g.tag_forum_name, this.baQ.forumName);
            this.baN.c(this.baQ.forumAvatar, 15, false);
            this.baO.setText(String.valueOf(com.baidu.tbadk.core.util.av.getFixedText(this.baQ.forumName, 4, true)) + getView().getContext().getResources().getString(r.j.forum));
            this.baO.setTag(r.g.tag_forum_name, this.baQ.forumName);
            this.baP.setTag(r.g.tag_forum_id, Long.valueOf(this.baQ.forumId));
            this.baP.setTag(r.g.tag_forum_name, this.baQ.forumName);
            getView().setTag(r.g.tag_forum_id, Long.valueOf(this.baQ.forumId));
            getView().setTag(r.g.tag_forum_name, this.baQ.forumName);
            a(this.baP, this.baQ.isLiked);
            this.baN.setOnClickListener(this.aob);
            this.baP.setOnClickListener(this.aob);
            this.baO.setOnClickListener(this.aob);
            getView().setOnClickListener(this.aob);
        }
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public com.baidu.tieba.horizonalList.widget.n T(View view) {
        c cVar = new c(view);
        cVar.baN = (BarImageView) view.findViewById(r.g.forum_avatar);
        cVar.baN.setGifIconSupport(false);
        cVar.baO = (TextView) view.findViewById(r.g.m_forum_name_textview);
        cVar.baP = (EntelechyUserLikeButton) view.findViewById(r.g.forum_add_love);
        cVar.cxu = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ar.l(getView(), r.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.ar.j((View) this.baO, r.d.cp_cont_b);
            a(this.baP, this.baQ.isLiked);
        }
        this.mSkinType = i;
    }

    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(r.g.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.aP(z);
        }
    }
}
