package com.baidu.tieba.card.divider;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class c extends com.baidu.tieba.card.b<b> {
    private View eLg;
    private int gIw;
    private int gIx;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gIw = R.color.cp_bg_line_c;
        this.gIx = UtilHelper.getDimenPixelSize(R.dimen.tbds16);
        getView().setOnClickListener(this);
        this.eLg = getView().findViewById(R.id.card_divider);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(this.eLg, this.gIw);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_divider_line;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(b bVar) {
        if (bVar != null) {
            this.eLg.setVisibility(0);
            this.gIw = bVar.gIw;
            this.gIx = bVar.gIx;
            bLT();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bLT() {
        ViewGroup.LayoutParams layoutParams = this.eLg.getLayoutParams();
        if (layoutParams != null && layoutParams.height != this.gIx) {
            layoutParams.height = this.gIx;
            this.eLg.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
