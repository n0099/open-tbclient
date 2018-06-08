package com.baidu.tieba.frs.gamesubpb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gamesubpb.a;
/* loaded from: classes3.dex */
public class b {
    private a.InterfaceC0155a dum;
    private SpannableTextView dvd;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.game_sub_comment_view, (ViewGroup) null);
        this.dvd = (SpannableTextView) this.mRootView.findViewById(d.g.sub_comment_tv);
        al.h(this.dvd, d.C0141d.cp_cont_f);
    }

    public void f(final com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.dvd.f(dVar);
            this.dvd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.dum != null) {
                        b.this.dum.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0155a interfaceC0155a) {
        this.dum = interfaceC0155a;
        this.dvd.setClickListener(interfaceC0155a);
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        private b dvf;

        public a(b bVar) {
            super(bVar.getRootView());
            this.dvf = bVar;
        }

        public void f(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
            this.dvf.f(dVar);
        }
    }
}
