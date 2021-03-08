package com.baidu.tieba.ala.alasquare.live_tab.my_concern.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.b.k;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.b<k> {
    private View bUO;
    private c gFb;
    private c gFc;
    private LinearLayout gFd;
    private ViewGroup rootView;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gFb = new c(tbPageContext);
        this.gFc = new c(tbPageContext);
        this.rootView = (ViewGroup) getView();
        this.gFd = (LinearLayout) this.rootView.findViewById(R.id.id_tab_live_sub_row);
        this.bUO = this.rootView.findViewById(R.id.id_tab_live_sub_line_divider);
        View view = new View(getContext());
        this.gFd.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.gFd.addView(this.gFb.getView());
        this.gFd.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.gFd.addView(this.gFc.getView());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        this.gFb.onChangeSkinType(tbPageContext, i);
        this.gFc.onChangeSkinType(tbPageContext, i);
        ap.setBackgroundResource(this.bUO, R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(k kVar) {
        if (kVar != null) {
            this.gFb.b(kVar.gCV);
            this.gFc.b(kVar.gCW);
            if (kVar.gCX) {
                this.bUO.setVisibility(0);
            } else {
                this.bUO.setVisibility(8);
            }
        }
    }

    public void a(i iVar) {
        this.gFb.a(iVar);
        this.gFc.a(iVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
