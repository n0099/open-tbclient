package com.baidu.tieba.frs.gamesubpb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
/* loaded from: classes9.dex */
public class b {
    private a.InterfaceC0616a hCF;
    private SpannableTextView hDw;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.game_sub_comment_view, (ViewGroup) null);
        this.hDw = (SpannableTextView) this.mRootView.findViewById(R.id.sub_comment_tv);
        am.setViewTextColor(this.hDw, (int) R.color.cp_cont_f);
    }

    public void f(final d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.hDw.f(dVar);
            this.hDw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hCF != null) {
                        b.this.hCF.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0616a interfaceC0616a) {
        this.hCF = interfaceC0616a;
        this.hDw.setClickListener(interfaceC0616a);
    }

    /* loaded from: classes9.dex */
    public static class a extends aa.a {
        private b hDy;

        public a(b bVar) {
            super(bVar.getRootView());
            this.hDy = bVar;
        }

        public void f(d dVar) {
            this.hDy.f(dVar);
        }
    }
}
