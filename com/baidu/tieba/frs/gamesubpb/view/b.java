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
/* loaded from: classes6.dex */
public class b {
    private a.InterfaceC0497a gxT;
    private SpannableTextView gyK;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.game_sub_comment_view, (ViewGroup) null);
        this.gyK = (SpannableTextView) this.mRootView.findViewById(R.id.sub_comment_tv);
        am.setViewTextColor(this.gyK, (int) R.color.cp_cont_f);
    }

    public void f(final d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.gyK.f(dVar);
            this.gyK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.gxT != null) {
                        b.this.gxT.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0497a interfaceC0497a) {
        this.gxT = interfaceC0497a;
        this.gyK.setClickListener(interfaceC0497a);
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        private b gyM;

        public a(b bVar) {
            super(bVar.getRootView());
            this.gyM = bVar;
        }

        public void f(d dVar) {
            this.gyM.f(dVar);
        }
    }
}
