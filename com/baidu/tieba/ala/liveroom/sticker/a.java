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
/* loaded from: classes7.dex */
public class a {
    private AudienceStickerContainerView gIR;
    private List<AlaLiveStickerInfo> gIS;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void aB(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.gIR == null) {
                this.gIR = new AudienceStickerContainerView(this.mTbPageContext.getPageActivity());
            }
            if (this.gIR.getParent() != null) {
                ((ViewGroup) this.gIR.getParent()).removeView(this.gIR);
            }
            viewGroup.addView(this.gIR, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void cc(List<AlaLiveStickerInfo> list) {
        boolean z;
        boolean z2 = true;
        if (this.gIR.getWidth() > 0 && this.gIR.getHeight() > 0) {
            if (this.gIS != null && list != null) {
                if (this.gIS.size() != list.size()) {
                    this.gIS = list;
                } else {
                    int size = list.size();
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            if (this.gIS.get(i).equals(list.get(i))) {
                                i++;
                            } else {
                                this.gIS = list;
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
            } else if (this.gIS != null && list == null) {
                this.gIS = list;
            } else if (this.gIS != null || list == null) {
                z2 = false;
            } else {
                this.gIS = list;
            }
            if (z2) {
                this.gIR.removeAllViews();
                if (this.gIS != null && this.gIS.size() > 0) {
                    for (AlaLiveStickerInfo alaLiveStickerInfo : this.gIS) {
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
                        a.this.gIR.b(alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }

    public void bWv() {
        this.gIR.setVisibility(8);
    }

    public void bWw() {
        this.gIR.setVisibility(0);
    }
}
