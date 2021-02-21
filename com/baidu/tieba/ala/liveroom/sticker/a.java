package com.baidu.tieba.ala.liveroom.sticker;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.resourceloader.BdResourceCallback;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.data.AlaLiveStickerInfo;
import com.baidu.live.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private AudienceStickerContainerView hOr;
    private List<AlaLiveStickerInfo> hOs;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void aP(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.hOr == null) {
                this.hOr = new AudienceStickerContainerView(this.mTbPageContext.getPageActivity());
            }
            if (this.hOr.getParent() != null) {
                ((ViewGroup) this.hOr.getParent()).removeView(this.hOr);
            }
            viewGroup.addView(this.hOr, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void cI(List<AlaLiveStickerInfo> list) {
        boolean z;
        boolean z2 = true;
        if (this.hOr.getWidth() > 0 && this.hOr.getHeight() > 0) {
            if (this.hOs != null && list != null) {
                if (this.hOs.size() != list.size()) {
                    this.hOs = list;
                } else {
                    int size = list.size();
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            if (this.hOs.get(i).equals(list.get(i))) {
                                i++;
                            } else {
                                this.hOs = list;
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    z2 = z;
                }
            } else if (this.hOs != null && list == null) {
                this.hOs = list;
            } else if (this.hOs != null || list == null) {
                z2 = false;
            } else {
                this.hOs = list;
            }
            if (z2) {
                this.hOr.removeAllViews();
                if (this.hOs != null && this.hOs.size() > 0) {
                    for (AlaLiveStickerInfo alaLiveStickerInfo : this.hOs) {
                        b(alaLiveStickerInfo);
                    }
                }
            }
        }
    }

    public void b(final AlaLiveStickerInfo alaLiveStickerInfo) {
        if (alaLiveStickerInfo != null && !TextUtils.isEmpty(alaLiveStickerInfo.link)) {
            final String str = alaLiveStickerInfo.link;
            BdResourceLoader.getInstance().loadResource(str, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.tieba.ala.liveroom.sticker.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str2, int i) {
                    super.onLoaded((AnonymousClass1) bdImage, str2, i);
                    if (bdImage != null && bdImage.getRawBitmap() != null && str2 != null && str2.equals(str)) {
                        alaLiveStickerInfo.bitmap = bdImage.getRawBitmap();
                        a.this.hOr.b(alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }

    public void ckC() {
        this.hOr.setVisibility(8);
    }

    public void ckD() {
        this.hOr.setVisibility(0);
    }
}
