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
    public BarImageView cJf;
    public TextView cJg;
    public EntelechyUserLikeButton cJi;
    private com.baidu.tieba.card.data.e eBV;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.cJf = null;
        this.cJg = null;
        this.cJi = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.e)) {
            this.eBV = (com.baidu.tieba.card.data.e) cVar;
            this.cJf.setTag(this.eBV.forumAvatar);
            this.cJf.setTag(R.id.tag_forum_name, this.eBV.forumName);
            this.cJf.startLoad(this.eBV.forumAvatar, 15, false);
            this.cJg.setText(aq.getFixedText(this.eBV.forumName, 4, true) + getView().getContext().getResources().getString(R.string.forum));
            this.cJg.setTag(R.id.tag_forum_name, this.eBV.forumName);
            this.cJi.setTag(R.id.tag_forum_id, Long.valueOf(this.eBV.forumId));
            this.cJi.setTag(R.id.tag_forum_name, this.eBV.forumName);
            getView().setTag(R.id.tag_forum_id, Long.valueOf(this.eBV.forumId));
            getView().setTag(R.id.tag_forum_name, this.eBV.forumName);
            a(this.cJi, this.eBV.isLiked);
            this.cJf.setOnClickListener(this.cmX);
            this.cJi.setOnClickListener(this.cmX);
            this.cJg.setOnClickListener(this.cmX);
            getView().setOnClickListener(this.cmX);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bE(View view) {
        c cVar = new c(view);
        cVar.cJf = (BarImageView) view.findViewById(R.id.forum_avatar);
        cVar.cJf.setGifIconSupport(false);
        cVar.cJg = (TextView) view.findViewById(R.id.m_forum_name_textview);
        cVar.cJi = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        cVar.gsK = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.l(getView(), R.color.cp_bg_line_d);
            am.j(this.cJg, R.color.cp_cont_b);
            a(this.cJi, this.eBV.isLiked);
        }
        this.mSkinType = i;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.ey(z);
        }
    }
}
