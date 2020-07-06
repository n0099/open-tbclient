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
/* loaded from: classes3.dex */
public class a {
    private AudienceStickerContainerView grw;
    private List<AlaLiveStickerInfo> grx;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void aB(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.grw == null) {
                this.grw = new AudienceStickerContainerView(this.mTbPageContext.getPageActivity());
            }
            if (this.grw.getParent() != null) {
                ((ViewGroup) this.grw.getParent()).removeView(this.grw);
            }
            viewGroup.addView(this.grw, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bW(List<AlaLiveStickerInfo> list) {
        boolean z;
        boolean z2 = true;
        if (this.grw.getWidth() > 0 && this.grw.getHeight() > 0) {
            if (this.grx != null && list != null) {
                if (this.grx.size() != list.size()) {
                    this.grx = list;
                } else {
                    int size = list.size();
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            if (this.grx.get(i).equals(list.get(i))) {
                                i++;
                            } else {
                                this.grx = list;
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
            } else if (this.grx != null && list == null) {
                this.grx = list;
            } else if (this.grx != null || list == null) {
                z2 = false;
            } else {
                this.grx = list;
            }
            if (z2) {
                this.grw.removeAllViews();
                if (this.grx != null && this.grx.size() > 0) {
                    for (AlaLiveStickerInfo alaLiveStickerInfo : this.grx) {
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
                        a.this.grw.b(alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }

    public void bJs() {
        this.grw.setVisibility(8);
    }

    public void bJt() {
        this.grw.setVisibility(0);
    }
}
