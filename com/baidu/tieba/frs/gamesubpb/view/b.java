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
/* loaded from: classes21.dex */
public class b {
    private a.InterfaceC0682a irQ;
    private SpannableTextView isH;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.game_sub_comment_view, (ViewGroup) null);
        this.isH = (SpannableTextView) this.mRootView.findViewById(R.id.sub_comment_tv);
        ap.setViewTextColor(this.isH, (int) R.color.cp_cont_f);
    }

    public void f(final d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.isH.f(dVar);
            this.isH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.irQ != null) {
                        b.this.irQ.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0682a interfaceC0682a) {
        this.irQ = interfaceC0682a;
        this.isH.setClickListener(interfaceC0682a);
    }

    /* loaded from: classes21.dex */
    public static class a extends af.a {
        private b isJ;

        public a(b bVar) {
            super(bVar.getRootView());
            this.isJ = bVar;
        }

        public void f(d dVar) {
            this.isJ.f(dVar);
        }
    }
}
