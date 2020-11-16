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
    private AudienceStickerContainerView hsE;
    private List<AlaLiveStickerInfo> hsF;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void aD(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.hsE == null) {
                this.hsE = new AudienceStickerContainerView(this.mTbPageContext.getPageActivity());
            }
            if (this.hsE.getParent() != null) {
                ((ViewGroup) this.hsE.getParent()).removeView(this.hsE);
            }
            viewGroup.addView(this.hsE, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void cC(List<AlaLiveStickerInfo> list) {
        boolean z;
        boolean z2 = true;
        if (this.hsE.getWidth() > 0 && this.hsE.getHeight() > 0) {
            if (this.hsF != null && list != null) {
                if (this.hsF.size() != list.size()) {
                    this.hsF = list;
                } else {
                    int size = list.size();
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            if (this.hsF.get(i).equals(list.get(i))) {
                                i++;
                            } else {
                                this.hsF = list;
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
            } else if (this.hsF != null && list == null) {
                this.hsF = list;
            } else if (this.hsF != null || list == null) {
                z2 = false;
            } else {
                this.hsF = list;
            }
            if (z2) {
                this.hsE.removeAllViews();
                if (this.hsF != null && this.hsF.size() > 0) {
                    for (AlaLiveStickerInfo alaLiveStickerInfo : this.hsF) {
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
                        a.this.hsE.b(alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }

    public void cgE() {
        this.hsE.setVisibility(8);
    }

    public void cgF() {
        this.hsE.setVisibility(0);
    }
}
