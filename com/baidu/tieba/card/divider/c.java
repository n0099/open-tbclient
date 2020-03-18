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
    private View cey;
    private int fOY;
    private int fOZ;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fOY = R.color.cp_bg_line_c;
        this.fOZ = UtilHelper.getDimenPixelSize(R.dimen.tbds16);
        getView().setOnClickListener(this);
        this.cey = getView().findViewById(R.id.card_divider);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(this.cey, this.fOY);
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
            this.cey.setVisibility(0);
            this.fOY = bVar.fOY;
            this.fOZ = bVar.fOZ;
            bvP();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bvP() {
        ViewGroup.LayoutParams layoutParams = this.cey.getLayoutParams();
        if (layoutParams != null && layoutParams.height != this.fOZ) {
            layoutParams.height = this.fOZ;
            this.cey.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
