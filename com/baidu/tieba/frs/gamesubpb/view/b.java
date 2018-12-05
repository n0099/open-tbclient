package com.baidu.tieba.frs.gamesubpb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
/* loaded from: classes3.dex */
public class b {
    private a.InterfaceC0225a dWs;
    private SpannableTextView dXj;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.game_sub_comment_view, (ViewGroup) null);
        this.dXj = (SpannableTextView) this.mRootView.findViewById(e.g.sub_comment_tv);
        al.h(this.dXj, e.d.cp_cont_f);
    }

    public void f(final d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.dXj.f(dVar);
            this.dXj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.dWs != null) {
                        b.this.dWs.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0225a interfaceC0225a) {
        this.dWs = interfaceC0225a;
        this.dXj.setClickListener(interfaceC0225a);
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        private b dXl;

        public a(b bVar) {
            super(bVar.getRootView());
            this.dXl = bVar;
        }

        public void f(d dVar) {
            this.dXl.f(dVar);
        }
    }
}
