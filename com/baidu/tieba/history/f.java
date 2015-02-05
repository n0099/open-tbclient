package com.baidu.tieba.history;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.Date;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.mvc.j.a<com.baidu.tbadk.b.b, com.baidu.tbadk.mvc.e.c> {
    private View Ta;
    private TextView aPe;
    private TextView aPf;
    private TextView aPg;
    private View mRootView;

    public f(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.aPe = (TextView) view.findViewById(w.title);
        this.aPf = (TextView) view.findViewById(w.content);
        this.aPg = (TextView) view.findViewById(w.time);
        this.Ta = view.findViewById(w.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.d
    /* renamed from: a */
    public void y(com.baidu.tbadk.b.b bVar) {
        super.y(bVar);
        if (bVar != null) {
            if (this.aPe != null && bVar.ll() != null) {
                this.aPe.setText(bVar.ll());
            }
            if (this.aPf != null && bVar.getForumName() != null) {
                this.aPf.setText(bVar.getForumName());
            }
            if (this.aPg != null) {
                String f = bf.f(new Date(bVar.getTime()));
                if (f == null) {
                    f = "";
                }
                this.aPg.setText(f);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        bc.i(this.mRootView, v.list_item_selector);
        bc.i(this.Ta, t.cp_bg_line_b);
        bc.b(this.aPe, t.cp_cont_b, 1);
        bc.b(this.aPf, t.cp_cont_d, 1);
        bc.b(this.aPg, t.cp_cont_d, 1);
        return true;
    }
}
