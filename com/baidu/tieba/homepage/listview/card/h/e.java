package com.baidu.tieba.homepage.listview.card.h;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.homepage.listview.card.h.b;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.homepage.listview.c<b> {
    public TextView bBI;
    public ArrayList<c> bBJ;
    private b bBK;
    public ViewGroup bBp;
    public TbImageView bBq;
    public ViewGroup bzs;

    public e(View view, TbPageContext<?> tbPageContext) {
        super(tbPageContext, view);
        this.bzs = null;
        this.bBp = null;
        this.bBq = null;
        this.bBI = null;
        this.bBJ = null;
        A(view);
    }

    private void A(View view) {
        if (view != null) {
            this.bzs = (ViewGroup) view.findViewById(n.f.card_hot_root);
            this.bBp = (ViewGroup) view.findViewById(n.f.card_hot_live_banner);
            this.bBq = (TbImageView) view.findViewById(n.f.banner_pic);
            this.bBq.setBorderWidth(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds1));
            this.bBI = (TextView) view.findViewById(n.f.banner_title_text);
            this.bBJ = new ArrayList<>();
            TX();
        }
    }

    private void TX() {
        as.i(this.bBp, n.e.topic_name_selector);
        as.b(this.bBI, n.c.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.homepage.listview.c
    public void cZ(int i) {
        if (this.mSkinType != i) {
            TX();
            if (this.bBK != null) {
                this.bBI.setText(f(this.bBK.bBw.title));
            }
            if (this.bBJ != null) {
                Iterator<c> it = this.bBJ.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null) {
                        next.cZ(i);
                    }
                }
            }
        }
        super.cZ(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.homepage.listview.c
    /* renamed from: a */
    public void c(b bVar) {
        if (bVar != null) {
            this.bBK = bVar;
            super.D(bVar);
            if (bVar.bBw != null) {
                this.bBq.d(bVar.bBw.picUrl, 10, false);
                this.bBp.setOnClickListener(new f(this, bVar));
                this.bBI.setText(f(bVar.bBw.title));
            }
            com.baidu.tieba.homepage.fragment.a.b.a(this.pageContext.getPageActivity(), this.bzs, bVar.bBx, b.C0065b.class, this.bBJ, c.class);
        }
    }

    private SpannableStringBuilder f(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(this.pageContext.getPageActivity(), as.cE(n.e.icon_zhibo), 1), 0, 1, 33);
        return spannableStringBuilder;
    }
}
