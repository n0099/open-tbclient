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
    private AudienceStickerContainerView gIV;
    private List<AlaLiveStickerInfo> gIW;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void aB(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.gIV == null) {
                this.gIV = new AudienceStickerContainerView(this.mTbPageContext.getPageActivity());
            }
            if (this.gIV.getParent() != null) {
                ((ViewGroup) this.gIV.getParent()).removeView(this.gIV);
            }
            viewGroup.addView(this.gIV, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void cc(List<AlaLiveStickerInfo> list) {
        boolean z;
        boolean z2 = true;
        if (this.gIV.getWidth() > 0 && this.gIV.getHeight() > 0) {
            if (this.gIW != null && list != null) {
                if (this.gIW.size() != list.size()) {
                    this.gIW = list;
                } else {
                    int size = list.size();
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            if (this.gIW.get(i).equals(list.get(i))) {
                                i++;
                            } else {
                                this.gIW = list;
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
            } else if (this.gIW != null && list == null) {
                this.gIW = list;
            } else if (this.gIW != null || list == null) {
                z2 = false;
            } else {
                this.gIW = list;
            }
            if (z2) {
                this.gIV.removeAllViews();
                if (this.gIW != null && this.gIW.size() > 0) {
                    for (AlaLiveStickerInfo alaLiveStickerInfo : this.gIW) {
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
                        a.this.gIV.b(alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }

    public void bWw() {
        this.gIV.setVisibility(8);
    }

    public void bWx() {
        this.gIV.setVisibility(0);
    }
}
