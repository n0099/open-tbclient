package com.baidu.tieba.card.divider;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class c extends com.baidu.tieba.card.a<b> {
    private View bZT;
    private int fIv;
    private int fIw;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fIv = R.color.cp_bg_line_c;
        this.fIw = UtilHelper.getDimenPixelSize(R.dimen.tbds16);
        getView().setOnClickListener(this);
        this.bZT = getView().findViewById(R.id.card_divider);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(this.bZT, this.fIv);
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
            this.bZT.setVisibility(0);
            this.fIv = bVar.fIv;
            this.fIw = bVar.fIw;
            btb();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void btb() {
        ViewGroup.LayoutParams layoutParams = this.bZT.getLayoutParams();
        if (layoutParams != null && layoutParams.height != this.fIw) {
            layoutParams.height = this.fIw;
            this.bZT.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
