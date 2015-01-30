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
    private View Td;
    private TextView aPf;
    private TextView aPg;
    private TextView aPh;
    private View mRootView;

    public f(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.aPf = (TextView) view.findViewById(w.title);
        this.aPg = (TextView) view.findViewById(w.content);
        this.aPh = (TextView) view.findViewById(w.time);
        this.Td = view.findViewById(w.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.d
    /* renamed from: a */
    public void y(com.baidu.tbadk.b.b bVar) {
        super.y(bVar);
        if (bVar != null) {
            if (this.aPf != null && bVar.ls() != null) {
                this.aPf.setText(bVar.ls());
            }
            if (this.aPg != null && bVar.getForumName() != null) {
                this.aPg.setText(bVar.getForumName());
            }
            if (this.aPh != null) {
                String f = bf.f(new Date(bVar.getTime()));
                if (f == null) {
                    f = "";
                }
                this.aPh.setText(f);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        bc.i(this.mRootView, v.list_item_selector);
        bc.i(this.Td, t.cp_bg_line_b);
        bc.b(this.aPf, t.cp_cont_b, 1);
        bc.b(this.aPg, t.cp_cont_d, 1);
        bc.b(this.aPh, t.cp_cont_d, 1);
        return true;
    }
}
