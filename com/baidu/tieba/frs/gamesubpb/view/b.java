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
    private a.InterfaceC0189a dON;
    private SpannableTextView dPE;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.game_sub_comment_view, (ViewGroup) null);
        this.dPE = (SpannableTextView) this.mRootView.findViewById(e.g.sub_comment_tv);
        al.h(this.dPE, e.d.cp_cont_f);
    }

    public void f(final d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.dPE.f(dVar);
            this.dPE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.dON != null) {
                        b.this.dON.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0189a interfaceC0189a) {
        this.dON = interfaceC0189a;
        this.dPE.setClickListener(interfaceC0189a);
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        private b dPG;

        public a(b bVar) {
            super(bVar.getRootView());
            this.dPG = bVar;
        }

        public void f(d dVar) {
            this.dPG.f(dVar);
        }
    }
}
