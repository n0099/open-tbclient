package com.baidu.tieba.frs.gamesubpb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
/* loaded from: classes9.dex */
public class b {
    private a.InterfaceC0545a hnL;
    private SpannableTextView hoC;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.game_sub_comment_view, (ViewGroup) null);
        this.hoC = (SpannableTextView) this.mRootView.findViewById(R.id.sub_comment_tv);
        am.setViewTextColor(this.hoC, (int) R.color.cp_cont_f);
    }

    public void f(final d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.hoC.f(dVar);
            this.hoC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hnL != null) {
                        b.this.hnL.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0545a interfaceC0545a) {
        this.hnL = interfaceC0545a;
        this.hoC.setClickListener(interfaceC0545a);
    }

    /* loaded from: classes9.dex */
    public static class a extends y.a {
        private b hoE;

        public a(b bVar) {
            super(bVar.getRootView());
            this.hoE = bVar;
        }

        public void f(d dVar) {
            this.hoE.f(dVar);
        }
    }
}
