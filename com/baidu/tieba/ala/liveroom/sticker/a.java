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
/* loaded from: classes4.dex */
public class a {
    private AudienceStickerContainerView gMm;
    private List<AlaLiveStickerInfo> gMn;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void aC(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.gMm == null) {
                this.gMm = new AudienceStickerContainerView(this.mTbPageContext.getPageActivity());
            }
            if (this.gMm.getParent() != null) {
                ((ViewGroup) this.gMm.getParent()).removeView(this.gMm);
            }
            viewGroup.addView(this.gMm, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void ch(List<AlaLiveStickerInfo> list) {
        boolean z;
        boolean z2 = true;
        if (this.gMm.getWidth() > 0 && this.gMm.getHeight() > 0) {
            if (this.gMn != null && list != null) {
                if (this.gMn.size() != list.size()) {
                    this.gMn = list;
                } else {
                    int size = list.size();
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            if (this.gMn.get(i).equals(list.get(i))) {
                                i++;
                            } else {
                                this.gMn = list;
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
            } else if (this.gMn != null && list == null) {
                this.gMn = list;
            } else if (this.gMn != null || list == null) {
                z2 = false;
            } else {
                this.gMn = list;
            }
            if (z2) {
                this.gMm.removeAllViews();
                if (this.gMn != null && this.gMn.size() > 0) {
                    for (AlaLiveStickerInfo alaLiveStickerInfo : this.gMn) {
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
                        a.this.gMm.b(alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }

    public void bYe() {
        this.gMm.setVisibility(8);
    }

    public void bYf() {
        this.gMm.setVisibility(0);
    }
}
