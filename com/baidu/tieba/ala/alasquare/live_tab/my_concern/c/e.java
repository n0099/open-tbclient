package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.k> {
    private View eOv;
    private d gub;
    private d guc;
    private LinearLayout gud;
    private ViewGroup rootView;

    public e(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gub = new d(tbPageContext);
        this.guc = new d(tbPageContext);
        this.rootView = (ViewGroup) getView();
        this.gud = (LinearLayout) this.rootView.findViewById(R.id.id_tab_live_sub_row);
        this.eOv = this.rootView.findViewById(R.id.id_tab_live_sub_line_divider);
        View view = new View(getContext());
        this.gud.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.gud.addView(this.gub.getView());
        this.gud.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.gud.addView(this.guc.getView());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        this.gub.onChangeSkinType(tbPageContext, i);
        this.guc.onChangeSkinType(tbPageContext, i);
        ap.setBackgroundResource(this.eOv, R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.k kVar) {
        if (kVar != null) {
            this.gub.b(kVar.grW);
            this.guc.b(kVar.grX);
            if (kVar.grY) {
                this.eOv.setVisibility(0);
            } else {
                this.eOv.setVisibility(8);
            }
        }
    }

    public void a(o oVar) {
        this.gub.a(oVar);
        this.guc.a(oVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
