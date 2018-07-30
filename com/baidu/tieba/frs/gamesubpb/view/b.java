package com.baidu.tieba.frs.gamesubpb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gamesubpb.a;
/* loaded from: classes3.dex */
public class b {
    private SpannableTextView dAY;
    private a.InterfaceC0155a dAh;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.game_sub_comment_view, (ViewGroup) null);
        this.dAY = (SpannableTextView) this.mRootView.findViewById(d.g.sub_comment_tv);
        am.h(this.dAY, d.C0140d.cp_cont_f);
    }

    public void f(final com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.dAY.f(dVar);
            this.dAY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.dAh != null) {
                        b.this.dAh.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0155a interfaceC0155a) {
        this.dAh = interfaceC0155a;
        this.dAY.setClickListener(interfaceC0155a);
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        private b dBa;

        public a(b bVar) {
            super(bVar.getRootView());
            this.dBa = bVar;
        }

        public void f(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
            this.dBa.f(dVar);
        }
    }
}
