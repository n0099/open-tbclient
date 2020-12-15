package com.baidu.tieba.card.divider;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class c extends com.baidu.tieba.card.b<b> {
    private int dividerHeight;
    private View fYf;
    private int ioo;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ioo = R.color.CAM_X0204;
        this.dividerHeight = UtilHelper.getDimenPixelSize(R.dimen.tbds16);
        getView().setOnClickListener(this);
        this.fYf = getView().findViewById(R.id.card_divider);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this.fYf, this.ioo);
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
            this.fYf.setVisibility(0);
            this.ioo = bVar.ioo;
            this.dividerHeight = bVar.dividerHeight;
            csM();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void csM() {
        ViewGroup.LayoutParams layoutParams = this.fYf.getLayoutParams();
        if (layoutParams != null && layoutParams.height != this.dividerHeight) {
            layoutParams.height = this.dividerHeight;
            this.fYf.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
