package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.horizonalList.widget.n {
    public BarImageView aSM;
    public TextView aSN;
    public TextView aSO;
    private com.baidu.tieba.card.a.e aSP;
    private int mSkinType;

    public i(View view) {
        super(view);
        this.aSM = null;
        this.aSN = null;
        this.aSO = null;
        this.mSkinType = 3;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void a(com.baidu.tieba.horizonalList.widget.l lVar) {
        if (lVar != null && (lVar instanceof com.baidu.tieba.card.a.e)) {
            this.aSP = (com.baidu.tieba.card.a.e) lVar;
            this.aSM.setTag(this.aSP.forumAvatar);
            this.aSM.setTag(u.g.tag_forum_name, this.aSP.forumName);
            this.aSM.c(this.aSP.forumAvatar, 15, false);
            this.aSN.setText(String.valueOf(com.baidu.tbadk.core.util.ba.getFixedText(this.aSP.forumName, 4, true)) + getView().getContext().getResources().getString(u.j.forum));
            this.aSN.setTag(u.g.tag_forum_name, this.aSP.forumName);
            this.aSO.setTag(u.g.tag_forum_id, Long.valueOf(this.aSP.forumId));
            this.aSO.setTag(u.g.tag_forum_name, this.aSP.forumName);
            getView().setTag(u.g.tag_forum_id, Long.valueOf(this.aSP.forumId));
            getView().setTag(u.g.tag_forum_name, this.aSP.forumName);
            b(this.aSO, this.aSP.isLiked);
            this.aSM.setOnClickListener(this.akQ);
            this.aSO.setOnClickListener(this.akQ);
            this.aSN.setOnClickListener(this.akQ);
            getView().setOnClickListener(this.akQ);
        }
        onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public com.baidu.tieba.horizonalList.widget.n T(View view) {
        i iVar = new i(view);
        iVar.aSM = (BarImageView) view.findViewById(u.g.forum_avatar);
        iVar.aSM.setGifIconSupport(false);
        iVar.aSN = (TextView) view.findViewById(u.g.m_forum_name_textview);
        iVar.aSO = (TextView) view.findViewById(u.g.forum_add_love);
        iVar.cAB = 16908308;
        return iVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.l(getView(), u.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.j((View) this.aSN, u.d.cp_cont_b);
            b(this.aSO, this.aSP.isLiked);
        }
        this.mSkinType = i;
    }

    private void b(TextView textView, boolean z) {
        textView.setTag(u.g.forum_follow, Boolean.valueOf(z));
        if (z) {
            textView.setEnabled(false);
            com.baidu.tbadk.core.util.av.c(textView, u.d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.m10getInst().getString(u.j.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        com.baidu.tbadk.core.util.av.c(textView, u.d.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.m10getInst().getString(u.j.forum_list_attention_tv));
        com.baidu.tbadk.core.util.av.k(textView, u.f.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(u.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds18), 0, TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds10), 0);
    }
}
