package com.baidu.tieba.frs.gamesubpb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
/* loaded from: classes7.dex */
public class b {
    private SpannableTextView gBU;
    private a.InterfaceC0501a gBd;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.game_sub_comment_view, (ViewGroup) null);
        this.gBU = (SpannableTextView) this.mRootView.findViewById(R.id.sub_comment_tv);
        am.setViewTextColor(this.gBU, (int) R.color.cp_cont_f);
    }

    public void f(final d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.gBU.f(dVar);
            this.gBU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.gBd != null) {
                        b.this.gBd.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0501a interfaceC0501a) {
        this.gBd = interfaceC0501a;
        this.gBU.setClickListener(interfaceC0501a);
    }

    /* loaded from: classes7.dex */
    public static class a extends v.a {
        private b gBW;

        public a(b bVar) {
            super(bVar.getRootView());
            this.gBW = bVar;
        }

        public void f(d dVar) {
            this.gBW.f(dVar);
        }
    }
}
