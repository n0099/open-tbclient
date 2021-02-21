package com.baidu.tieba.card.divider;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.b<b> {
    private int dividerHeight;
    private View gfy;
    private int iBZ;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iBZ = R.color.CAM_X0204;
        this.dividerHeight = UtilHelper.getDimenPixelSize(R.dimen.tbds16);
        getView().setOnClickListener(this);
        this.gfy = getView().findViewById(R.id.card_divider);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this.gfy, this.iBZ);
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
            this.gfy.setVisibility(0);
            this.iBZ = bVar.iBZ;
            this.dividerHeight = bVar.dividerHeight;
            cth();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cth() {
        ViewGroup.LayoutParams layoutParams = this.gfy.getLayoutParams();
        if (layoutParams != null && layoutParams.height != this.dividerHeight) {
            layoutParams.height = this.dividerHeight;
            this.gfy.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
