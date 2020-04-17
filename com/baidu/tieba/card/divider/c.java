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
    private View cDw;
    private int gtF;
    private int gtG;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gtF = R.color.cp_bg_line_c;
        this.gtG = UtilHelper.getDimenPixelSize(R.dimen.tbds16);
        getView().setOnClickListener(this);
        this.cDw = getView().findViewById(R.id.card_divider);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(this.cDw, this.gtF);
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
            this.cDw.setVisibility(0);
            this.gtF = bVar.gtF;
            this.gtG = bVar.gtG;
            bFA();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bFA() {
        ViewGroup.LayoutParams layoutParams = this.cDw.getLayoutParams();
        if (layoutParams != null && layoutParams.height != this.gtG) {
            layoutParams.height = this.gtG;
            this.cDw.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
