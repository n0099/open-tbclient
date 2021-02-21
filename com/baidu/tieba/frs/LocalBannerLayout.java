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
    private com.baidu.tbadk.core.flow.a.d<h> ajC;
    private com.baidu.tbadk.core.flow.a.d<h> ajD;
    private CoverFlowLocalView<h> jli;
    private List<h> mData;

    public LocalBannerLayout(Context context) {
        this(context, null);
    }

    public LocalBannerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LocalBannerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajD = new com.baidu.tbadk.core.flow.a.d<h>() { // from class: com.baidu.tieba.frs.LocalBannerLayout.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void f(int i2, String str) {
                if (i2 >= 0 && LocalBannerLayout.this.mData != null && i2 <= LocalBannerLayout.this.mData.size() + 1 && LocalBannerLayout.this.ajC != null) {
                    LocalBannerLayout.this.ajC.f(i2, str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i2, h hVar) {
                if (i2 >= 0 && LocalBannerLayout.this.mData != null && i2 <= LocalBannerLayout.this.mData.size() + 1 && LocalBannerLayout.this.ajC != null) {
                    LocalBannerLayout.this.ajC.a(i2, hVar);
                }
            }
        };
        init();
    }

    private void init() {
        this.jli = new CoverFlowLocalView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.frs.LocalBannerLayout.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.e tt() {
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
            public com.baidu.tbadk.core.flow.a.c tu() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.op(R.drawable.icon_mask_goods_select8);
                cVar.oq(R.drawable.icon_mask_goods_unselect8);
                cVar.setGravity(81);
                cVar.or(R.dimen.tbds36);
                cVar.setSpacing(R.dimen.tbds20);
                return cVar;
            }
        };
        this.jli.setIndicatorNoOffet(false);
        this.jli.setDisableParentEvent(false);
        this.jli.setCoverFlowFactory(bVar);
        this.jli.setIndicatorVisible(0);
        this.jli.setIsAutoPlayDragging(false);
        this.jli.setAutoPlay(false);
        this.jli.setCallback(this.ajD);
        addView(this.jli);
    }

    public void setData(List<h> list) {
        this.mData = list;
        this.jli.setData(list);
    }

    public void setOnCoverViewCallback(com.baidu.tbadk.core.flow.a.d<h> dVar) {
        this.ajC = dVar;
    }
}
