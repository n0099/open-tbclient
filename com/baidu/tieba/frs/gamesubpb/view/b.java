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
    private a.InterfaceC0747a jnq;
    private SpannableTextView joh;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.game_sub_comment_view, (ViewGroup) null);
        this.joh = (SpannableTextView) this.mRootView.findViewById(R.id.sub_comment_tv);
        ap.setViewTextColor(this.joh, (int) R.color.CAM_X0106);
    }

    public void f(final d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.joh.f(dVar);
            this.joh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.jnq != null) {
                        b.this.jnq.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0747a interfaceC0747a) {
        this.jnq = interfaceC0747a;
        this.joh.setClickListener(interfaceC0747a);
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        private b joj;

        public a(b bVar) {
            super(bVar.getRootView());
            this.joj = bVar;
        }

        public void f(d dVar) {
            this.joj.f(dVar);
        }
    }
}
