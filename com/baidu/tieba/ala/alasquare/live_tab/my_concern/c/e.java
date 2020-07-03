package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.k> {
    private View dQh;
    private d fqi;
    private d fqj;
    private LinearLayout fqk;
    private ViewGroup rootView;

    public e(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.fqi = new d(tbPageContext);
        this.fqj = new d(tbPageContext);
        this.rootView = (ViewGroup) getView();
        this.fqk = (LinearLayout) this.rootView.findViewById(R.id.id_tab_live_sub_row);
        this.dQh = this.rootView.findViewById(R.id.id_tab_live_sub_line_divider);
        View view = new View(getContext());
        this.fqk.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.fqk.addView(this.fqi.getView());
        this.fqk.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.fqk.addView(this.fqj.getView());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        an.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        this.fqi.onChangeSkinType(tbPageContext, i);
        this.fqj.onChangeSkinType(tbPageContext, i);
        an.setBackgroundResource(this.dQh, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.k kVar) {
        if (kVar != null) {
            this.fqi.b(kVar.foi);
            this.fqj.b(kVar.foj);
            if (kVar.fok) {
                this.dQh.setVisibility(0);
            } else {
                this.dQh.setVisibility(8);
            }
        }
    }

    public void a(o oVar) {
        this.fqi.a(oVar);
        this.fqj.a(oVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
