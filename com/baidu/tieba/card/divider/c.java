package com.baidu.tieba.card.divider;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class c extends com.baidu.tieba.card.a<b> {
    private View cDC;
    private int gtL;
    private int gtM;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gtL = R.color.cp_bg_line_c;
        this.gtM = UtilHelper.getDimenPixelSize(R.dimen.tbds16);
        getView().setOnClickListener(this);
        this.cDC = getView().findViewById(R.id.card_divider);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(this.cDC, this.gtL);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_divider_line;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(b bVar) {
        if (bVar != null) {
            this.cDC.setVisibility(0);
            this.gtL = bVar.gtL;
            this.gtM = bVar.gtM;
            bFy();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bFy() {
        ViewGroup.LayoutParams layoutParams = this.cDC.getLayoutParams();
        if (layoutParams != null && layoutParams.height != this.gtM) {
            layoutParams.height = this.gtM;
            this.cDC.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
