package com.baidu.tieba.history;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.Date;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.mvc.j.a<com.baidu.tbadk.b.b, com.baidu.tbadk.mvc.e.c> {
    private TextView aNW;
    private TextView aNX;
    private TextView aNY;
    private View mLine;
    private View mRootView;

    public f(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mRootView = view;
        this.aNW = (TextView) view.findViewById(w.title);
        this.aNX = (TextView) view.findViewById(w.content);
        this.aNY = (TextView) view.findViewById(w.time);
        this.mLine = view.findViewById(w.line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.d
    /* renamed from: a */
    public void y(com.baidu.tbadk.b.b bVar) {
        super.y(bVar);
        if (bVar != null) {
            if (this.aNW != null && bVar.ls() != null) {
                this.aNW.setText(bVar.ls());
            }
            if (this.aNX != null && bVar.getForumName() != null) {
                this.aNX.setText(bVar.getForumName());
            }
            if (this.aNY != null) {
                String f = ba.f(new Date(bVar.getTime()));
                if (f == null) {
                    f = "";
                }
                this.aNY.setText(f);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        ax.i(this.mRootView, v.list_item_selector);
        ax.i(this.mLine, t.cp_bg_line_b);
        ax.b(this.aNW, t.cp_cont_b, 1);
        ax.b(this.aNX, t.cp_cont_d, 1);
        ax.b(this.aNY, t.cp_cont_d, 1);
        return true;
    }
}
