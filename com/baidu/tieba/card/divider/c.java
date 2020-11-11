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
    private View fQl;
    private int icz;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.icz = R.color.cp_bg_line_c;
        this.dividerHeight = UtilHelper.getDimenPixelSize(R.dimen.tbds16);
        getView().setOnClickListener(this);
        this.fQl = getView().findViewById(R.id.card_divider);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this.fQl, this.icz);
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
            this.fQl.setVisibility(0);
            this.icz = bVar.icz;
            this.dividerHeight = bVar.dividerHeight;
            coX();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void coX() {
        ViewGroup.LayoutParams layoutParams = this.fQl.getLayoutParams();
        if (layoutParams != null && layoutParams.height != this.dividerHeight) {
            layoutParams.height = this.dividerHeight;
            this.fQl.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
