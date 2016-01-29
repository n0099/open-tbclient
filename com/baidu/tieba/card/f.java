package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.horizonalList.widget.o {
    public BarImageView aET;
    public TextView aEU;
    public TextView aEW;
    private com.baidu.tieba.card.a.f aOY;

    public f(View view) {
        super(view);
        this.aET = null;
        this.aEU = null;
        this.aEW = null;
    }

    @Override // com.baidu.tieba.horizonalList.widget.o
    public void a(com.baidu.tieba.horizonalList.widget.m mVar) {
        if (mVar != null && (mVar instanceof com.baidu.tieba.card.a.f)) {
            this.aOY = (com.baidu.tieba.card.a.f) mVar;
            this.aET.setTag(this.aOY.forumAvatar);
            this.aET.setTag(t.g.tag_forum_name, this.aOY.forumName);
            this.aET.d(this.aOY.forumAvatar, 15, false);
            this.aEU.setText(String.valueOf(com.baidu.tbadk.core.util.aw.getFixedText(this.aOY.forumName, 4, true)) + getView().getContext().getResources().getString(t.j.forum));
            this.aEU.setTag(t.g.tag_forum_name, this.aOY.forumName);
            this.aEW.setTag(t.g.tag_forum_id, Long.valueOf(this.aOY.forumId));
            this.aEW.setTag(t.g.tag_forum_name, this.aOY.forumName);
            getView().setTag(t.g.tag_forum_id, Long.valueOf(this.aOY.forumId));
            getView().setTag(t.g.tag_forum_name, this.aOY.forumName);
            a(this.aEW, this.aOY.isLiked);
            this.aET.setOnClickListener(this.anq);
            this.aEW.setOnClickListener(this.anq);
            this.aEU.setOnClickListener(this.anq);
            getView().setOnClickListener(this.anq);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.o
    public com.baidu.tieba.horizonalList.widget.o M(View view) {
        f fVar = new f(view);
        fVar.aET = (BarImageView) view.findViewById(t.g.forum_avatar);
        fVar.aET.setGifIconSupport(false);
        fVar.aEU = (TextView) view.findViewById(t.g.m_forum_name_textview);
        fVar.aEW = (TextView) view.findViewById(t.g.forum_add_love);
        fVar.bIO = 16908308;
        return fVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.o
    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.util.ar.l(getView(), t.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.ar.j((View) this.aEU, t.d.cp_cont_b);
        a(this.aEW, this.aOY.isLiked);
    }

    private void a(TextView textView, boolean z) {
        textView.setTag(t.g.forum_follow, Boolean.valueOf(z));
        if (z) {
            textView.setEnabled(false);
            com.baidu.tbadk.core.util.ar.b(textView, t.d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.m411getInst().getString(t.j.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        com.baidu.tbadk.core.util.ar.b(textView, t.d.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.m411getInst().getString(t.j.forum_list_attention_tv));
        com.baidu.tbadk.core.util.ar.k(textView, t.f.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ar.getDrawable(t.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds18), 0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds10), 0);
    }
}
