package com.baidu.tieba.card.divider;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class c extends com.baidu.tieba.card.b<b> {
    private int dividerHeight;
    private View fmE;
    private int hoc;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hoc = R.color.cp_bg_line_c;
        this.dividerHeight = UtilHelper.getDimenPixelSize(R.dimen.tbds16);
        getView().setOnClickListener(this);
        this.fmE = getView().findViewById(R.id.card_divider);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this.fmE, this.hoc);
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
            this.fmE.setVisibility(0);
            this.hoc = bVar.hoc;
            this.dividerHeight = bVar.dividerHeight;
            ccD();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void ccD() {
        ViewGroup.LayoutParams layoutParams = this.fmE.getLayoutParams();
        if (layoutParams != null && layoutParams.height != this.dividerHeight) {
            layoutParams.height = this.dividerHeight;
            this.fmE.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
