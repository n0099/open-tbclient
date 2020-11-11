package com.baidu.tieba.frs.gamesubpb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
/* loaded from: classes22.dex */
public class b {
    private SpannableTextView iZT;
    private a.InterfaceC0730a iZc;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.game_sub_comment_view, (ViewGroup) null);
        this.iZT = (SpannableTextView) this.mRootView.findViewById(R.id.sub_comment_tv);
        ap.setViewTextColor(this.iZT, (int) R.color.cp_cont_f);
    }

    public void f(final d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.iZT.f(dVar);
            this.iZT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.iZc != null) {
                        b.this.iZc.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0730a interfaceC0730a) {
        this.iZc = interfaceC0730a;
        this.iZT.setClickListener(interfaceC0730a);
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        private b iZV;

        public a(b bVar) {
            super(bVar.getRootView());
            this.iZV = bVar;
        }

        public void f(d dVar) {
            this.iZV.f(dVar);
        }
    }
}
