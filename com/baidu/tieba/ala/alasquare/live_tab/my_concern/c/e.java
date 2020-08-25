package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.k> {
    private View efZ;
    private d fGK;
    private d fGL;
    private LinearLayout fGM;
    private ViewGroup rootView;

    public e(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.fGK = new d(tbPageContext);
        this.fGL = new d(tbPageContext);
        this.rootView = (ViewGroup) getView();
        this.fGM = (LinearLayout) this.rootView.findViewById(R.id.id_tab_live_sub_row);
        this.efZ = this.rootView.findViewById(R.id.id_tab_live_sub_line_divider);
        View view = new View(getContext());
        this.fGM.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.fGM.addView(this.fGK.getView());
        this.fGM.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.fGM.addView(this.fGL.getView());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        this.fGK.onChangeSkinType(tbPageContext, i);
        this.fGL.onChangeSkinType(tbPageContext, i);
        ap.setBackgroundResource(this.efZ, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.k kVar) {
        if (kVar != null) {
            this.fGK.b(kVar.fEL);
            this.fGL.b(kVar.fEM);
            if (kVar.fEN) {
                this.efZ.setVisibility(0);
            } else {
                this.efZ.setVisibility(8);
            }
        }
    }

    public void a(o oVar) {
        this.fGK.a(oVar);
        this.fGL.a(oVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
