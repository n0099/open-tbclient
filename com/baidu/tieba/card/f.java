package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.horizonalList.widget.n {
    public BarImageView aGo;
    public TextView aGp;
    public TextView aGr;
    private com.baidu.tieba.card.a.f aRO;
    private int mSkinType;

    public f(View view) {
        super(view);
        this.aGo = null;
        this.aGp = null;
        this.aGr = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void a(com.baidu.tieba.horizonalList.widget.l lVar) {
        if (lVar != null && (lVar instanceof com.baidu.tieba.card.a.f)) {
            this.aRO = (com.baidu.tieba.card.a.f) lVar;
            this.aGo.setTag(this.aRO.forumAvatar);
            this.aGo.setTag(t.g.tag_forum_name, this.aRO.forumName);
            this.aGo.c(this.aRO.forumAvatar, 15, false);
            this.aGp.setText(String.valueOf(com.baidu.tbadk.core.util.ay.getFixedText(this.aRO.forumName, 4, true)) + getView().getContext().getResources().getString(t.j.forum));
            this.aGp.setTag(t.g.tag_forum_name, this.aRO.forumName);
            this.aGr.setTag(t.g.tag_forum_id, Long.valueOf(this.aRO.forumId));
            this.aGr.setTag(t.g.tag_forum_name, this.aRO.forumName);
            getView().setTag(t.g.tag_forum_id, Long.valueOf(this.aRO.forumId));
            getView().setTag(t.g.tag_forum_name, this.aRO.forumName);
            a(this.aGr, this.aRO.isLiked);
            this.aGo.setOnClickListener(this.anH);
            this.aGr.setOnClickListener(this.anH);
            this.aGp.setOnClickListener(this.anH);
            getView().setOnClickListener(this.anH);
        }
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public com.baidu.tieba.horizonalList.widget.n Q(View view) {
        f fVar = new f(view);
        fVar.aGo = (BarImageView) view.findViewById(t.g.forum_avatar);
        fVar.aGo.setGifIconSupport(false);
        fVar.aGp = (TextView) view.findViewById(t.g.m_forum_name_textview);
        fVar.aGr = (TextView) view.findViewById(t.g.forum_add_love);
        fVar.bTk = 16908308;
        return fVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.l(getView(), t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.j((View) this.aGp, t.d.cp_cont_b);
            a(this.aGr, this.aRO.isLiked);
        }
        this.mSkinType = i;
    }

    private void a(TextView textView, boolean z) {
        textView.setTag(t.g.forum_follow, Boolean.valueOf(z));
        if (z) {
            textView.setEnabled(false);
            com.baidu.tbadk.core.util.at.b(textView, t.d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.m411getInst().getString(t.j.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        com.baidu.tbadk.core.util.at.b(textView, t.d.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.m411getInst().getString(t.j.forum_list_attention_tv));
        com.baidu.tbadk.core.util.at.k(textView, t.f.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds18), 0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds10), 0);
    }
}
