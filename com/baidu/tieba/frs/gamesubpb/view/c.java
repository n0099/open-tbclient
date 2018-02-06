package com.baidu.tieba.frs.gamesubpb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gamesubpb.a;
/* loaded from: classes3.dex */
public class c {
    private a.InterfaceC0155a dPN;
    private SpannableTextView dQE;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public c(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.game_sub_comment_view, (ViewGroup) null);
        this.dQE = (SpannableTextView) this.mRootView.findViewById(d.g.sub_comment_tv);
        aj.r(this.dQE, d.C0140d.cp_cont_f);
    }

    public void f(final com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.dQE.f(dVar);
            this.dQE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.dPN != null) {
                        c.this.dPN.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0155a interfaceC0155a) {
        this.dPN = interfaceC0155a;
        this.dQE.setClickListener(interfaceC0155a);
    }

    /* loaded from: classes3.dex */
    public static class a extends r.a {
        private c dQG;

        public a(c cVar) {
            super(cVar.getRootView());
            this.dQG = cVar;
        }

        public void f(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
            this.dQG.f(dVar);
        }
    }
}
