package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.horizonalList.widget.p {
    public BarImageView aEd;
    public TextView aEe;
    public TextView aEg;
    private com.baidu.tieba.card.a.e aNx;

    public c(View view) {
        super(view);
        this.aEd = null;
        this.aEe = null;
        this.aEg = null;
    }

    @Override // com.baidu.tieba.horizonalList.widget.p
    public void a(com.baidu.tieba.horizonalList.widget.n nVar) {
        if (nVar != null && (nVar instanceof com.baidu.tieba.card.a.e)) {
            this.aNx = (com.baidu.tieba.card.a.e) nVar;
            this.aEd.setTag(this.aNx.forumAvatar);
            this.aEd.setTag(n.g.tag_forum_name, this.aNx.forumName);
            this.aEd.d(this.aNx.forumAvatar, 15, false);
            this.aEe.setText(String.valueOf(ax.getFixedText(this.aNx.forumName, 4, true)) + getView().getContext().getResources().getString(n.j.forum));
            this.aEe.setTag(n.g.tag_forum_name, this.aNx.forumName);
            this.aEg.setTag(n.g.tag_forum_id, Long.valueOf(this.aNx.forumId));
            this.aEg.setTag(n.g.tag_forum_name, this.aNx.forumName);
            getView().setTag(n.g.tag_forum_id, Long.valueOf(this.aNx.forumId));
            getView().setTag(n.g.tag_forum_name, this.aNx.forumName);
            a(this.aEg, this.aNx.isLiked);
            this.aEd.setOnClickListener(this.amx);
            this.aEg.setOnClickListener(this.amx);
            this.aEe.setOnClickListener(this.amx);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.p
    public com.baidu.tieba.horizonalList.widget.p y(View view) {
        c cVar = new c(view);
        cVar.aEd = (BarImageView) view.findViewById(n.g.forum_avatar);
        cVar.aEd.setGifIconSupport(false);
        cVar.aEe = (TextView) view.findViewById(n.g.m_forum_name_textview);
        cVar.aEg = (TextView) view.findViewById(n.g.forum_add_love);
        cVar.bFE = 16908308;
        return cVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.p
    public void onChangeSkinType(int i) {
        as.h((View) this.aEe, n.d.cp_cont_b);
        a(this.aEg, this.aNx.isLiked);
    }

    private void a(TextView textView, boolean z) {
        textView.setTag(n.g.forum_follow, Boolean.valueOf(z));
        if (z) {
            textView.setEnabled(false);
            as.b(textView, n.d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.m411getInst().getString(n.j.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        as.b(textView, n.d.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.m411getInst().getString(n.j.forum_list_attention_tv));
        as.i((View) textView, n.f.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds18), 0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds10), 0);
    }
}
