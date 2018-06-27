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
    private a.InterfaceC0157a dxv;
    private SpannableTextView dym;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.game_sub_comment_view, (ViewGroup) null);
        this.dym = (SpannableTextView) this.mRootView.findViewById(d.g.sub_comment_tv);
        am.h(this.dym, d.C0142d.cp_cont_f);
    }

    public void f(final com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.dym.f(dVar);
            this.dym.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.dxv != null) {
                        b.this.dxv.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0157a interfaceC0157a) {
        this.dxv = interfaceC0157a;
        this.dym.setClickListener(interfaceC0157a);
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        private b dyo;

        public a(b bVar) {
            super(bVar.getRootView());
            this.dyo = bVar;
        }

        public void f(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
            this.dyo.f(dVar);
        }
    }
}
