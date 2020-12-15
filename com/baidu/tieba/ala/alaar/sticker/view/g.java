package com.baidu.tieba.ala.alaar.sticker.view;

import android.view.View;
import com.baidu.live.adp.lib.resourceloader.BdResourceCallback;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import com.baidu.tieba.ala.alaar.sticker.model.PicStickerItem;
/* loaded from: classes4.dex */
public class g extends i {
    private TbImageView gnj;

    public g(View view) {
        this.mRootView = view;
        this.gnj = (TbImageView) this.mRootView.findViewById(a.f.sticker_img);
        this.gnp = (MaskStrokeView) this.mRootView.findViewById(a.f.sticker_bg);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.view.i
    public void d(final FuFaceItem fuFaceItem) {
        super.d(fuFaceItem);
        if (fuFaceItem != null && (fuFaceItem instanceof PicStickerItem)) {
            BdResourceLoader.getInstance().loadResource(((PicStickerItem) fuFaceItem).url, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.tieba.ala.alaar.sticker.view.g.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str, int i) {
                    super.onLoaded((AnonymousClass1) bdImage, str, i);
                    if (bdImage != null && bdImage.getRawBitmap() != null && str != null && str.equals(((PicStickerItem) fuFaceItem).url)) {
                        ((PicStickerItem) fuFaceItem).bitmap = bdImage.getRawBitmap();
                        g.this.gnj.setImageBitmap(bdImage.getRawBitmap());
                    }
                }
            }, null);
        }
    }
}
