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
    private a.InterfaceC0566a hnR;
    private SpannableTextView hoI;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.game_sub_comment_view, (ViewGroup) null);
        this.hoI = (SpannableTextView) this.mRootView.findViewById(R.id.sub_comment_tv);
        am.setViewTextColor(this.hoI, (int) R.color.cp_cont_f);
    }

    public void f(final d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.hoI.f(dVar);
            this.hoI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hnR != null) {
                        b.this.hnR.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0566a interfaceC0566a) {
        this.hnR = interfaceC0566a;
        this.hoI.setClickListener(interfaceC0566a);
    }

    /* loaded from: classes9.dex */
    public static class a extends y.a {
        private b hoK;

        public a(b bVar) {
            super(bVar.getRootView());
            this.hoK = bVar;
        }

        public void f(d dVar) {
            this.hoK.f(dVar);
        }
    }
}
