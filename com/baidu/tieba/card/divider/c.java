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
    private View cem;
    private int fOd;
    private int fOe;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fOd = R.color.cp_bg_line_c;
        this.fOe = UtilHelper.getDimenPixelSize(R.dimen.tbds16);
        getView().setOnClickListener(this);
        this.cem = getView().findViewById(R.id.card_divider);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(this.cem, this.fOd);
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
            this.cem.setVisibility(0);
            this.fOd = bVar.fOd;
            this.fOe = bVar.fOe;
            bvJ();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bvJ() {
        ViewGroup.LayoutParams layoutParams = this.cem.getLayoutParams();
        if (layoutParams != null && layoutParams.height != this.fOe) {
            layoutParams.height = this.fOe;
            this.cem.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
