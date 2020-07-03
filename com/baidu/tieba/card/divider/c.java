package com.baidu.tieba.card.divider;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class c extends com.baidu.tieba.card.b<b> {
    private View eVD;
    private int gVH;
    private int gVI;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gVH = R.color.cp_bg_line_c;
        this.gVI = UtilHelper.getDimenPixelSize(R.dimen.tbds16);
        getView().setOnClickListener(this);
        this.eVD = getView().findViewById(R.id.card_divider);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundColor(this.eVD, this.gVH);
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
            this.eVD.setVisibility(0);
            this.gVH = bVar.gVH;
            this.gVI = bVar.gVI;
            bPf();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bPf() {
        ViewGroup.LayoutParams layoutParams = this.eVD.getLayoutParams();
        if (layoutParams != null && layoutParams.height != this.gVI) {
            layoutParams.height = this.gVI;
            this.eVD.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
