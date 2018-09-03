package com.baidu.tieba.frs.gamesubpb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
/* loaded from: classes3.dex */
public class b {
    private SpannableTextView dAV;
    private a.InterfaceC0155a dAe;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(f.h.game_sub_comment_view, (ViewGroup) null);
        this.dAV = (SpannableTextView) this.mRootView.findViewById(f.g.sub_comment_tv);
        am.h(this.dAV, f.d.cp_cont_f);
    }

    public void f(final d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.dAV.f(dVar);
            this.dAV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.dAe != null) {
                        b.this.dAe.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0155a interfaceC0155a) {
        this.dAe = interfaceC0155a;
        this.dAV.setClickListener(interfaceC0155a);
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        private b dAX;

        public a(b bVar) {
            super(bVar.getRootView());
            this.dAX = bVar;
        }

        public void f(d dVar) {
            this.dAX.f(dVar);
        }
    }
}
