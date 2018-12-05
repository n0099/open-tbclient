package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.a<c> {
    private View amM;
    private View exa;
    private View exb;
    private TextView exc;
    private String exd;
    private c exe;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.amM = getView();
        this.exc = (TextView) this.amM.findViewById(e.g.read_progress_bar_time);
        this.exa = this.amM.findViewById(e.g.divider_line_under_homepage_read_progress);
        this.exb = this.amM.findViewById(e.g.divider_line_under_homepage_read_time);
        this.exd = this.mPageContext.getResources().getString(e.j.read_here);
        this.amM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.apc() != null) {
                    a.this.apc().a(view, a.this.exe);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.h(this.exc, e.d.cp_link_tip_a);
            al.i(this.amM, e.f.addresslist_item_bg);
            al.j(this.exa, e.d.cp_bg_line_c);
            al.j(this.exb, e.d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_read_progress_bar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.exe = cVar;
            this.exc.setText(ao.N(cVar.mTimeStamp) + this.exd);
            if (cVar.showBottomDivider) {
                this.exb.setVisibility(0);
            } else {
                this.exb.setVisibility(8);
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
