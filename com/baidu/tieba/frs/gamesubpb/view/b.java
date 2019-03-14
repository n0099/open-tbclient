package com.baidu.tieba.frs.gamesubpb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gamesubpb.a;
/* loaded from: classes4.dex */
public class b {
    private a.InterfaceC0293a fns;
    private SpannableTextView foj;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.game_sub_comment_view, (ViewGroup) null);
        this.foj = (SpannableTextView) this.mRootView.findViewById(d.g.sub_comment_tv);
        al.j(this.foj, d.C0277d.cp_cont_f);
    }

    public void f(final com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.foj.f(dVar);
            this.foj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.fns != null) {
                        b.this.fns.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0293a interfaceC0293a) {
        this.fns = interfaceC0293a;
        this.foj.setClickListener(interfaceC0293a);
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        private b fol;

        public a(b bVar) {
            super(bVar.getRootView());
            this.fol = bVar;
        }

        public void f(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
            this.fol.f(dVar);
        }
    }
}
