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
    private a.InterfaceC0140a djU;
    private SpannableTextView dkL;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.game_sub_comment_view, (ViewGroup) null);
        this.dkL = (SpannableTextView) this.mRootView.findViewById(d.g.sub_comment_tv);
        ak.h(this.dkL, d.C0126d.cp_cont_f);
    }

    public void f(final com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.dkL.f(dVar);
            this.dkL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.djU != null) {
                        b.this.djU.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0140a interfaceC0140a) {
        this.djU = interfaceC0140a;
        this.dkL.setClickListener(interfaceC0140a);
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        private b dkN;

        public a(b bVar) {
            super(bVar.getRootView());
            this.dkN = bVar;
        }

        public void f(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
            this.dkN.f(dVar);
        }
    }
}
