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
    private AudienceStickerContainerView hmZ;
    private List<AlaLiveStickerInfo> hna;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void aF(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.hmZ == null) {
                this.hmZ = new AudienceStickerContainerView(this.mTbPageContext.getPageActivity());
            }
            if (this.hmZ.getParent() != null) {
                ((ViewGroup) this.hmZ.getParent()).removeView(this.hmZ);
            }
            viewGroup.addView(this.hmZ, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void cu(List<AlaLiveStickerInfo> list) {
        boolean z;
        boolean z2 = true;
        if (this.hmZ.getWidth() > 0 && this.hmZ.getHeight() > 0) {
            if (this.hna != null && list != null) {
                if (this.hna.size() != list.size()) {
                    this.hna = list;
                } else {
                    int size = list.size();
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            if (this.hna.get(i).equals(list.get(i))) {
                                i++;
                            } else {
                                this.hna = list;
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
            } else if (this.hna != null && list == null) {
                this.hna = list;
            } else if (this.hna != null || list == null) {
                z2 = false;
            } else {
                this.hna = list;
            }
            if (z2) {
                this.hmZ.removeAllViews();
                if (this.hna != null && this.hna.size() > 0) {
                    for (AlaLiveStickerInfo alaLiveStickerInfo : this.hna) {
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
                        a.this.hmZ.b(alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }

    public void ceI() {
        this.hmZ.setVisibility(8);
    }

    public void ceJ() {
        this.hmZ.setVisibility(0);
    }
}
