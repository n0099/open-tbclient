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
    private AudienceStickerContainerView hCi;
    private List<AlaLiveStickerInfo> hCj;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void aD(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.hCi == null) {
                this.hCi = new AudienceStickerContainerView(this.mTbPageContext.getPageActivity());
            }
            if (this.hCi.getParent() != null) {
                ((ViewGroup) this.hCi.getParent()).removeView(this.hCi);
            }
            viewGroup.addView(this.hCi, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void cG(List<AlaLiveStickerInfo> list) {
        boolean z;
        boolean z2 = true;
        if (this.hCi.getWidth() > 0 && this.hCi.getHeight() > 0) {
            if (this.hCj != null && list != null) {
                if (this.hCj.size() != list.size()) {
                    this.hCj = list;
                } else {
                    int size = list.size();
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            if (this.hCj.get(i).equals(list.get(i))) {
                                i++;
                            } else {
                                this.hCj = list;
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
            } else if (this.hCj != null && list == null) {
                this.hCj = list;
            } else if (this.hCj != null || list == null) {
                z2 = false;
            } else {
                this.hCj = list;
            }
            if (z2) {
                this.hCi.removeAllViews();
                if (this.hCj != null && this.hCj.size() > 0) {
                    for (AlaLiveStickerInfo alaLiveStickerInfo : this.hCj) {
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
                        a.this.hCi.b(alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }

    public void cky() {
        this.hCi.setVisibility(8);
    }

    public void ckz() {
        this.hCi.setVisibility(0);
    }
}
