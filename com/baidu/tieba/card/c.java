package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.horizonalList.widget.n {
    public TextView aYA;
    private com.baidu.tieba.card.data.e aYB;
    public BarImageView aYy;
    public TextView aYz;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.aYy = null;
        this.aYz = null;
        this.aYA = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void a(com.baidu.tieba.horizonalList.widget.l lVar) {
        if (lVar != null && (lVar instanceof com.baidu.tieba.card.data.e)) {
            this.aYB = (com.baidu.tieba.card.data.e) lVar;
            this.aYy.setTag(this.aYB.forumAvatar);
            this.aYy.setTag(r.g.tag_forum_name, this.aYB.forumName);
            this.aYy.c(this.aYB.forumAvatar, 15, false);
            this.aYz.setText(String.valueOf(com.baidu.tbadk.core.util.az.getFixedText(this.aYB.forumName, 4, true)) + getView().getContext().getResources().getString(r.j.forum));
            this.aYz.setTag(r.g.tag_forum_name, this.aYB.forumName);
            this.aYA.setTag(r.g.tag_forum_id, Long.valueOf(this.aYB.forumId));
            this.aYA.setTag(r.g.tag_forum_name, this.aYB.forumName);
            getView().setTag(r.g.tag_forum_id, Long.valueOf(this.aYB.forumId));
            getView().setTag(r.g.tag_forum_name, this.aYB.forumName);
            a(this.aYA, this.aYB.isLiked);
            this.aYy.setOnClickListener(this.anF);
            this.aYA.setOnClickListener(this.anF);
            this.aYz.setOnClickListener(this.anF);
            getView().setOnClickListener(this.anF);
        }
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public com.baidu.tieba.horizonalList.widget.n S(View view) {
        c cVar = new c(view);
        cVar.aYy = (BarImageView) view.findViewById(r.g.forum_avatar);
        cVar.aYy.setGifIconSupport(false);
        cVar.aYz = (TextView) view.findViewById(r.g.m_forum_name_textview);
        cVar.aYA = (TextView) view.findViewById(r.g.forum_add_love);
        cVar.cMX = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.l(getView(), r.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.j((View) this.aYz, r.d.cp_cont_b);
            a(this.aYA, this.aYB.isLiked);
        }
        this.mSkinType = i;
    }

    private void a(TextView textView, boolean z) {
        textView.setTag(r.g.forum_follow, Boolean.valueOf(z));
        if (z) {
            textView.setEnabled(false);
            com.baidu.tbadk.core.util.av.c(textView, r.d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.m9getInst().getString(r.j.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        com.baidu.tbadk.core.util.av.c(textView, r.d.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.m9getInst().getString(r.j.forum_list_attention_tv));
        com.baidu.tbadk.core.util.av.k(textView, r.f.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(r.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds10), 0);
    }
}
