package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.horizonalList.widget.n {
    public BarImageView aXU;
    public TextView aXV;
    public TextView aXW;
    private com.baidu.tieba.card.data.e aXX;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.aXU = null;
        this.aXV = null;
        this.aXW = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void a(com.baidu.tieba.horizonalList.widget.l lVar) {
        if (lVar != null && (lVar instanceof com.baidu.tieba.card.data.e)) {
            this.aXX = (com.baidu.tieba.card.data.e) lVar;
            this.aXU.setTag(this.aXX.forumAvatar);
            this.aXU.setTag(t.g.tag_forum_name, this.aXX.forumName);
            this.aXU.c(this.aXX.forumAvatar, 15, false);
            this.aXV.setText(String.valueOf(com.baidu.tbadk.core.util.ba.getFixedText(this.aXX.forumName, 4, true)) + getView().getContext().getResources().getString(t.j.forum));
            this.aXV.setTag(t.g.tag_forum_name, this.aXX.forumName);
            this.aXW.setTag(t.g.tag_forum_id, Long.valueOf(this.aXX.forumId));
            this.aXW.setTag(t.g.tag_forum_name, this.aXX.forumName);
            getView().setTag(t.g.tag_forum_id, Long.valueOf(this.aXX.forumId));
            getView().setTag(t.g.tag_forum_name, this.aXX.forumName);
            a(this.aXW, this.aXX.isLiked);
            this.aXU.setOnClickListener(this.anX);
            this.aXW.setOnClickListener(this.anX);
            this.aXV.setOnClickListener(this.anX);
            getView().setOnClickListener(this.anX);
        }
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public com.baidu.tieba.horizonalList.widget.n S(View view) {
        c cVar = new c(view);
        cVar.aXU = (BarImageView) view.findViewById(t.g.forum_avatar);
        cVar.aXU.setGifIconSupport(false);
        cVar.aXV = (TextView) view.findViewById(t.g.m_forum_name_textview);
        cVar.aXW = (TextView) view.findViewById(t.g.forum_add_love);
        cVar.cMg = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.l(getView(), t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.j((View) this.aXV, t.d.cp_cont_b);
            a(this.aXW, this.aXX.isLiked);
        }
        this.mSkinType = i;
    }

    private void a(TextView textView, boolean z) {
        textView.setTag(t.g.forum_follow, Boolean.valueOf(z));
        if (z) {
            textView.setEnabled(false);
            com.baidu.tbadk.core.util.av.c(textView, t.d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.m9getInst().getString(t.j.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        com.baidu.tbadk.core.util.av.c(textView, t.d.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.m9getInst().getString(t.j.forum_list_attention_tv));
        com.baidu.tbadk.core.util.av.k(textView, t.f.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(t.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds10), 0);
    }
}
