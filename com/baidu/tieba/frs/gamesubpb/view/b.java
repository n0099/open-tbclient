package com.baidu.tieba.frs.gamesubpb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gamesubpb.a;
/* loaded from: classes3.dex */
public class b {
    private a.InterfaceC0140a djR;
    private SpannableTextView dkI;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.game_sub_comment_view, (ViewGroup) null);
        this.dkI = (SpannableTextView) this.mRootView.findViewById(d.g.sub_comment_tv);
        ak.h(this.dkI, d.C0126d.cp_cont_f);
    }

    public void f(final com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.dkI.f(dVar);
            this.dkI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.djR != null) {
                        b.this.djR.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0140a interfaceC0140a) {
        this.djR = interfaceC0140a;
        this.dkI.setClickListener(interfaceC0140a);
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        private b dkK;

        public a(b bVar) {
            super(bVar.getRootView());
            this.dkK = bVar;
        }

        public void f(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
            this.dkK.f(dVar);
        }
    }
}
