package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.horizonalList.widget.n {
    public BarImageView aRS;
    public TextView aRT;
    public TextView aRU;
    private com.baidu.tieba.card.a.e aRV;
    private int mSkinType;

    public i(View view) {
        super(view);
        this.aRS = null;
        this.aRT = null;
        this.aRU = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void a(com.baidu.tieba.horizonalList.widget.l lVar) {
        if (lVar != null && (lVar instanceof com.baidu.tieba.card.a.e)) {
            this.aRV = (com.baidu.tieba.card.a.e) lVar;
            this.aRS.setTag(this.aRV.forumAvatar);
            this.aRS.setTag(u.g.tag_forum_name, this.aRV.forumName);
            this.aRS.c(this.aRV.forumAvatar, 15, false);
            this.aRT.setText(String.valueOf(com.baidu.tbadk.core.util.ba.getFixedText(this.aRV.forumName, 4, true)) + getView().getContext().getResources().getString(u.j.forum));
            this.aRT.setTag(u.g.tag_forum_name, this.aRV.forumName);
            this.aRU.setTag(u.g.tag_forum_id, Long.valueOf(this.aRV.forumId));
            this.aRU.setTag(u.g.tag_forum_name, this.aRV.forumName);
            getView().setTag(u.g.tag_forum_id, Long.valueOf(this.aRV.forumId));
            getView().setTag(u.g.tag_forum_name, this.aRV.forumName);
            b(this.aRU, this.aRV.isLiked);
            this.aRS.setOnClickListener(this.akb);
            this.aRU.setOnClickListener(this.akb);
            this.aRT.setOnClickListener(this.akb);
            getView().setOnClickListener(this.akb);
        }
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public com.baidu.tieba.horizonalList.widget.n T(View view) {
        i iVar = new i(view);
        iVar.aRS = (BarImageView) view.findViewById(u.g.forum_avatar);
        iVar.aRS.setGifIconSupport(false);
        iVar.aRT = (TextView) view.findViewById(u.g.m_forum_name_textview);
        iVar.aRU = (TextView) view.findViewById(u.g.forum_add_love);
        iVar.cxM = 16908308;
        return iVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.l(getView(), u.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.j((View) this.aRT, u.d.cp_cont_b);
            b(this.aRU, this.aRV.isLiked);
        }
        this.mSkinType = i;
    }

    private void b(TextView textView, boolean z) {
        textView.setTag(u.g.forum_follow, Boolean.valueOf(z));
        if (z) {
            textView.setEnabled(false);
            com.baidu.tbadk.core.util.av.c(textView, u.d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.m9getInst().getString(u.j.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        com.baidu.tbadk.core.util.av.c(textView, u.d.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.m9getInst().getString(u.j.forum_list_attention_tv));
        com.baidu.tbadk.core.util.av.k(textView, u.f.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(u.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds10), 0);
    }
}
