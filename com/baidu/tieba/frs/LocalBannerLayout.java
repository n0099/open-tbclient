package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.flow.CoverFlowLocalView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class LocalBannerLayout extends RelativeLayout {
    private com.baidu.tbadk.core.flow.a.d<h> aiF;
    private com.baidu.tbadk.core.flow.a.d<h> aiG;
    private CoverFlowLocalView<h> ieM;
    private List<h> mData;

    public LocalBannerLayout(Context context) {
        this(context, null);
    }

    public LocalBannerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LocalBannerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiG = new com.baidu.tbadk.core.flow.a.d<h>() { // from class: com.baidu.tieba.frs.LocalBannerLayout.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void e(int i2, String str) {
                if (i2 >= 0 && LocalBannerLayout.this.mData != null && i2 <= LocalBannerLayout.this.mData.size() + 1 && LocalBannerLayout.this.aiF != null) {
                    LocalBannerLayout.this.aiF.e(i2, str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i2, h hVar) {
                if (i2 >= 0 && LocalBannerLayout.this.mData != null && i2 <= LocalBannerLayout.this.mData.size() + 1 && LocalBannerLayout.this.aiF != null) {
                    LocalBannerLayout.this.aiF.a(i2, hVar);
                }
            }
        };
        init();
    }

    private void init() {
        this.ieM = new CoverFlowLocalView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.frs.LocalBannerLayout.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.e uf() {
                com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
                eVar.setHeight(com.baidu.adp.lib.util.l.getDimens(LocalBannerLayout.this.getContext(), R.dimen.tbds690));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView V(Context context) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setPlaceHolder(2);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c ug() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.nT(R.drawable.icon_mask_goods_select8);
                cVar.nU(R.drawable.icon_mask_goods_unselect8);
                cVar.setGravity(81);
                cVar.nV(R.dimen.tbds36);
                cVar.setSpacing(R.dimen.tbds20);
                return cVar;
            }
        };
        this.ieM.setIndicatorNoOffet(false);
        this.ieM.setDisableParentEvent(false);
        this.ieM.setCoverFlowFactory(bVar);
        this.ieM.setIndicatorVisible(0);
        this.ieM.setIsAutoPlayDragging(false);
        this.ieM.setAutoPlay(false);
        this.ieM.setCallback(this.aiG);
        addView(this.ieM);
    }

    public void setData(List<h> list) {
        this.mData = list;
        this.ieM.setData(list);
    }

    public void setOnCoverViewCallback(com.baidu.tbadk.core.flow.a.d<h> dVar) {
        this.aiF = dVar;
    }
}
