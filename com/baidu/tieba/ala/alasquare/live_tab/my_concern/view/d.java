package com.baidu.tieba.ala.alasquare.live_tab.my_concern.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.b.k;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.b<k> {
    private View bPy;
    private c gAu;
    private c gAv;
    private LinearLayout gAw;
    private ViewGroup rootView;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gAu = new c(tbPageContext);
        this.gAv = new c(tbPageContext);
        this.rootView = (ViewGroup) getView();
        this.gAw = (LinearLayout) this.rootView.findViewById(R.id.id_tab_live_sub_row);
        this.bPy = this.rootView.findViewById(R.id.id_tab_live_sub_line_divider);
        View view = new View(getContext());
        this.gAw.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.gAw.addView(this.gAu.getView());
        this.gAw.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.gAw.addView(this.gAv.getView());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        this.gAu.onChangeSkinType(tbPageContext, i);
        this.gAv.onChangeSkinType(tbPageContext, i);
        ao.setBackgroundResource(this.bPy, R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(k kVar) {
        if (kVar != null) {
            this.gAu.b(kVar.gyo);
            this.gAv.b(kVar.gyp);
            if (kVar.gyq) {
                this.bPy.setVisibility(0);
            } else {
                this.bPy.setVisibility(8);
            }
        }
    }

    public void a(i iVar) {
        this.gAu.a(iVar);
        this.gAv.a(iVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
