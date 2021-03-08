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
/* loaded from: classes10.dex */
public class a {
    private AudienceStickerContainerView hQa;
    private List<AlaLiveStickerInfo> hQb;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void aP(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.hQa == null) {
                this.hQa = new AudienceStickerContainerView(this.mTbPageContext.getPageActivity());
            }
            if (this.hQa.getParent() != null) {
                ((ViewGroup) this.hQa.getParent()).removeView(this.hQa);
            }
            viewGroup.addView(this.hQa, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void cI(List<AlaLiveStickerInfo> list) {
        boolean z;
        boolean z2 = true;
        if (this.hQa.getWidth() > 0 && this.hQa.getHeight() > 0) {
            if (this.hQb != null && list != null) {
                if (this.hQb.size() != list.size()) {
                    this.hQb = list;
                } else {
                    int size = list.size();
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            if (this.hQb.get(i).equals(list.get(i))) {
                                i++;
                            } else {
                                this.hQb = list;
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
            } else if (this.hQb != null && list == null) {
                this.hQb = list;
            } else if (this.hQb != null || list == null) {
                z2 = false;
            } else {
                this.hQb = list;
            }
            if (z2) {
                this.hQa.removeAllViews();
                if (this.hQb != null && this.hQb.size() > 0) {
                    for (AlaLiveStickerInfo alaLiveStickerInfo : this.hQb) {
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
                        a.this.hQa.b(alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }

    public void ckI() {
        this.hQa.setVisibility(8);
    }

    public void ckJ() {
        this.hQa.setVisibility(0);
    }
}
