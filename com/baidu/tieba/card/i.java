package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.horizonalList.widget.n {
    public BarImageView aOv;
    public TextView aOw;
    public TextView aOx;
    private com.baidu.tieba.card.a.e aOy;
    private int mSkinType;

    public i(View view) {
        super(view);
        this.aOv = null;
        this.aOw = null;
        this.aOx = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void a(com.baidu.tieba.horizonalList.widget.l lVar) {
        if (lVar != null && (lVar instanceof com.baidu.tieba.card.a.e)) {
            this.aOy = (com.baidu.tieba.card.a.e) lVar;
            this.aOv.setTag(this.aOy.forumAvatar);
            this.aOv.setTag(t.g.tag_forum_name, this.aOy.forumName);
            this.aOv.c(this.aOy.forumAvatar, 15, false);
            this.aOw.setText(String.valueOf(com.baidu.tbadk.core.util.ay.getFixedText(this.aOy.forumName, 4, true)) + getView().getContext().getResources().getString(t.j.forum));
            this.aOw.setTag(t.g.tag_forum_name, this.aOy.forumName);
            this.aOx.setTag(t.g.tag_forum_id, Long.valueOf(this.aOy.forumId));
            this.aOx.setTag(t.g.tag_forum_name, this.aOy.forumName);
            getView().setTag(t.g.tag_forum_id, Long.valueOf(this.aOy.forumId));
            getView().setTag(t.g.tag_forum_name, this.aOy.forumName);
            b(this.aOx, this.aOy.isLiked);
            this.aOv.setOnClickListener(this.ajv);
            this.aOx.setOnClickListener(this.ajv);
            this.aOw.setOnClickListener(this.ajv);
            getView().setOnClickListener(this.ajv);
        }
        onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public com.baidu.tieba.horizonalList.widget.n S(View view) {
        i iVar = new i(view);
        iVar.aOv = (BarImageView) view.findViewById(t.g.forum_avatar);
        iVar.aOv.setGifIconSupport(false);
        iVar.aOw = (TextView) view.findViewById(t.g.m_forum_name_textview);
        iVar.aOx = (TextView) view.findViewById(t.g.forum_add_love);
        iVar.bTM = 16908308;
        return iVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.l(getView(), t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.j((View) this.aOw, t.d.cp_cont_b);
            b(this.aOx, this.aOy.isLiked);
        }
        this.mSkinType = i;
    }

    private void b(TextView textView, boolean z) {
        textView.setTag(t.g.forum_follow, Boolean.valueOf(z));
        if (z) {
            textView.setEnabled(false);
            com.baidu.tbadk.core.util.at.c(textView, t.d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.m11getInst().getString(t.j.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        com.baidu.tbadk.core.util.at.c(textView, t.d.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.m11getInst().getString(t.j.forum_list_attention_tv));
        com.baidu.tbadk.core.util.at.k(textView, t.f.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds18), 0, TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds10), 0);
    }
}
