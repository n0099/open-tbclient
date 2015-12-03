package com.baidu.tieba.homepage.listview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.homepage.fragment.data.e;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class c<T extends com.baidu.tieba.homepage.fragment.data.e> extends x.a implements g<T> {
    protected RelativeLayout byE;
    protected TextView byF;
    protected TextView byG;
    protected TextView byH;
    public View byI;
    public View byJ;
    public View byK;
    public View byL;
    public ViewGroup byM;
    protected T byN;
    protected int mSkinType;
    protected TbPageContext<?> pageContext;

    public c(TbPageContext<?> tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.byE = null;
        this.byF = null;
        this.byG = null;
        this.byH = null;
        this.byI = null;
        this.byJ = null;
        this.byK = null;
        this.byL = null;
        this.byM = null;
        this.byN = null;
        this.pageContext = tbPageContext;
        this.byE = (RelativeLayout) view.findViewById(n.f.item_shell_top_area);
        this.byF = (TextView) view.findViewById(n.f.item_theme_title);
        this.byM = (ViewGroup) view.findViewById(n.f.item_right_box);
        this.byG = (TextView) view.findViewById(n.f.item_right_textview);
        this.byH = (TextView) view.findViewById(n.f.item_more_textview);
        this.byI = view.findViewById(n.f.divider_line_top);
        this.byJ = view.findViewById(n.f.divider_line_middle);
        this.byK = view.findViewById(n.f.divider_line_bottom);
        this.byL = view.findViewById(n.f.card_divider_view);
        TX();
    }

    private void TX() {
        as.b(this.byF, n.c.cp_cont_f, 1);
        as.b(this.byH, n.c.cp_link_tip_c, 1);
        as.j(this.byI, n.c.cp_bg_line_c);
        as.j(this.byJ, n.c.cp_bg_line_c);
        as.i((View) this.byG, n.e.icon_more_tab);
        as.i((View) this.byH, n.e.topic_name_selector);
        as.i(this.byM, n.e.topic_name_selector);
        as.j(this.byK, n.c.cp_bg_line_c);
        as.j(this.byL, n.c.cp_bg_line_c);
    }

    public void cZ(int i) {
        if (this.mSkinType != i) {
            TX();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.homepage.listview.g
    /* renamed from: c */
    public void D(T t) {
        if (t != null) {
            this.byN = t;
            this.byF.setText(t.getTitle());
            this.byM.setOnClickListener(new e(this, new d(this, t.getMid())));
            if (StringUtils.isNull(t.TR()) || StringUtils.isNull(t.TS())) {
                this.byH.setVisibility(8);
                this.byK.setVisibility(8);
                return;
            }
            this.byH.setVisibility(0);
            this.byK.setVisibility(0);
            this.byH.setText(t.TR().trim());
            this.byH.setOnClickListener(new f(this, t, t.TS()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(c.b bVar) {
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.pageContext.getPageActivity());
        cVar.bQ(n.i.operation);
        cVar.a(new CharSequence[]{TbadkCoreApplication.m411getInst().getString(n.i.sticky_card)}, bVar);
        cVar.d(this.pageContext);
        cVar.tz();
    }

    @Override // com.baidu.tieba.homepage.listview.g
    public View TY() {
        return getView();
    }
}
