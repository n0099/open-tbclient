package com.baidu.tieba.frs.gamesubpb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
/* loaded from: classes9.dex */
public class b {
    private a.InterfaceC0624a hQA;
    private SpannableTextView hRr;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.game_sub_comment_view, (ViewGroup) null);
        this.hRr = (SpannableTextView) this.mRootView.findViewById(R.id.sub_comment_tv);
        an.setViewTextColor(this.hRr, (int) R.color.cp_cont_f);
    }

    public void f(final d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.hRr.f(dVar);
            this.hRr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hQA != null) {
                        b.this.hQA.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0624a interfaceC0624a) {
        this.hQA = interfaceC0624a;
        this.hRr.setClickListener(interfaceC0624a);
    }

    /* loaded from: classes9.dex */
    public static class a extends ad.a {
        private b hRt;

        public a(b bVar) {
            super(bVar.getRootView());
            this.hRt = bVar;
        }

        public void f(d dVar) {
            this.hRt.f(dVar);
        }
    }
}
