package com.baidu.tieba.frs.gamesubpb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
/* loaded from: classes16.dex */
public class b {
    private a.InterfaceC0634a hWz;
    private SpannableTextView hXq;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.game_sub_comment_view, (ViewGroup) null);
        this.hXq = (SpannableTextView) this.mRootView.findViewById(R.id.sub_comment_tv);
        ao.setViewTextColor(this.hXq, R.color.cp_cont_f);
    }

    public void f(final d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.hXq.f(dVar);
            this.hXq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hWz != null) {
                        b.this.hWz.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0634a interfaceC0634a) {
        this.hWz = interfaceC0634a;
        this.hXq.setClickListener(interfaceC0634a);
    }

    /* loaded from: classes16.dex */
    public static class a extends ad.a {
        private b hXs;

        public a(b bVar) {
            super(bVar.getRootView());
            this.hXs = bVar;
        }

        public void f(d dVar) {
            this.hXs.f(dVar);
        }
    }
}
