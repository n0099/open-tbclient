package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<c> {
    private View abt;
    private View dVH;
    private View dVI;
    private TextView dVJ;
    private String dVK;
    private c dVL;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.abt = getView();
        this.dVJ = (TextView) this.abt.findViewById(d.g.read_progress_bar_time);
        this.dVH = this.abt.findViewById(d.g.divider_line_under_homepage_read_progress);
        this.dVI = this.abt.findViewById(d.g.divider_line_under_homepage_read_time);
        this.dVK = this.mPageContext.getResources().getString(d.k.read_here);
        this.abt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aia() != null) {
                    a.this.aia().a(view, a.this.dVL);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.h(this.dVJ, d.C0142d.cp_link_tip_a);
            am.i(this.abt, d.f.addresslist_item_bg);
            am.j(this.dVH, d.C0142d.cp_bg_line_c);
            am.j(this.dVI, d.C0142d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_read_progress_bar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.dVL = cVar;
            this.dVJ.setText(ap.x(cVar.dVQ) + this.dVK);
            if (cVar.showBottomDivider) {
                this.dVI.setVisibility(0);
            } else {
                this.dVI.setVisibility(8);
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
