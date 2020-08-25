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
/* loaded from: classes16.dex */
public class b {
    private a.InterfaceC0685a ikI;
    private SpannableTextView ilz;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.game_sub_comment_view, (ViewGroup) null);
        this.ilz = (SpannableTextView) this.mRootView.findViewById(R.id.sub_comment_tv);
        ap.setViewTextColor(this.ilz, (int) R.color.cp_cont_f);
    }

    public void f(final d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.ilz.f(dVar);
            this.ilz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.ikI != null) {
                        b.this.ikI.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0685a interfaceC0685a) {
        this.ikI = interfaceC0685a;
        this.ilz.setClickListener(interfaceC0685a);
    }

    /* loaded from: classes16.dex */
    public static class a extends af.a {
        private b ilB;

        public a(b bVar) {
            super(bVar.getRootView());
            this.ilB = bVar;
        }

        public void f(d dVar) {
            this.ilB.f(dVar);
        }
    }
}
