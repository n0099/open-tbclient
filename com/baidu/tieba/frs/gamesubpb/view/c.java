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
    private a.InterfaceC0156a dPB;
    private SpannableTextView dQs;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public c(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.game_sub_comment_view, (ViewGroup) null);
        this.dQs = (SpannableTextView) this.mRootView.findViewById(d.g.sub_comment_tv);
        aj.r(this.dQs, d.C0141d.cp_cont_f);
    }

    public void f(final com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.dQs.f(dVar);
            this.dQs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.dPB != null) {
                        c.this.dPB.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0156a interfaceC0156a) {
        this.dPB = interfaceC0156a;
        this.dQs.setClickListener(interfaceC0156a);
    }

    /* loaded from: classes3.dex */
    public static class a extends r.a {
        private c dQu;

        public a(c cVar) {
            super(cVar.getRootView());
            this.dQu = cVar;
        }

        public void f(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
            this.dQu.f(dVar);
        }
    }
}
