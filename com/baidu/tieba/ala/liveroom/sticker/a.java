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
    private AudienceStickerContainerView hOd;
    private List<AlaLiveStickerInfo> hOe;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void aP(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.hOd == null) {
                this.hOd = new AudienceStickerContainerView(this.mTbPageContext.getPageActivity());
            }
            if (this.hOd.getParent() != null) {
                ((ViewGroup) this.hOd.getParent()).removeView(this.hOd);
            }
            viewGroup.addView(this.hOd, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void cI(List<AlaLiveStickerInfo> list) {
        boolean z;
        boolean z2 = true;
        if (this.hOd.getWidth() > 0 && this.hOd.getHeight() > 0) {
            if (this.hOe != null && list != null) {
                if (this.hOe.size() != list.size()) {
                    this.hOe = list;
                } else {
                    int size = list.size();
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            if (this.hOe.get(i).equals(list.get(i))) {
                                i++;
                            } else {
                                this.hOe = list;
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
            } else if (this.hOe != null && list == null) {
                this.hOe = list;
            } else if (this.hOe != null || list == null) {
                z2 = false;
            } else {
                this.hOe = list;
            }
            if (z2) {
                this.hOd.removeAllViews();
                if (this.hOe != null && this.hOe.size() > 0) {
                    for (AlaLiveStickerInfo alaLiveStickerInfo : this.hOe) {
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
                        a.this.hOd.b(alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }

    public void ckv() {
        this.hOd.setVisibility(8);
    }

    public void ckw() {
        this.hOd.setVisibility(0);
    }
}
