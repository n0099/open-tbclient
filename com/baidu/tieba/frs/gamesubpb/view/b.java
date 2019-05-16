package com.baidu.tieba.frs.gamesubpb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
/* loaded from: classes4.dex */
public class b {
    private a.InterfaceC0311a fDz;
    private SpannableTextView fEq;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.game_sub_comment_view, (ViewGroup) null);
        this.fEq = (SpannableTextView) this.mRootView.findViewById(R.id.sub_comment_tv);
        al.j(this.fEq, R.color.cp_cont_f);
    }

    public void f(final d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.fEq.f(dVar);
            this.fEq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.fDz != null) {
                        b.this.fDz.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0311a interfaceC0311a) {
        this.fDz = interfaceC0311a;
        this.fEq.setClickListener(interfaceC0311a);
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        private b fEs;

        public a(b bVar) {
            super(bVar.getRootView());
            this.fEs = bVar;
        }

        public void f(d dVar) {
            this.fEs.f(dVar);
        }
    }
}
