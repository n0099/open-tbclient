package com.baidu.tieba.card.divider;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.a<b> {
    private View caf;
    private int fLF;
    private int fLG;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fLF = R.color.cp_bg_line_c;
        this.fLG = UtilHelper.getDimenPixelSize(R.dimen.tbds16);
        getView().setOnClickListener(this);
        this.caf = getView().findViewById(R.id.card_divider);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(this.caf, this.fLF);
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
            this.caf.setVisibility(0);
            this.fLF = bVar.fLF;
            this.fLG = bVar.fLG;
            bud();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bud() {
        ViewGroup.LayoutParams layoutParams = this.caf.getLayoutParams();
        if (layoutParams != null && layoutParams.height != this.fLG) {
            layoutParams.height = this.fLG;
            this.caf.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
