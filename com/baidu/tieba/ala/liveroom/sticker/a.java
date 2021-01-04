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
    private AudienceStickerContainerView hOl;
    private List<AlaLiveStickerInfo> hOm;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void aP(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.hOl == null) {
                this.hOl = new AudienceStickerContainerView(this.mTbPageContext.getPageActivity());
            }
            if (this.hOl.getParent() != null) {
                ((ViewGroup) this.hOl.getParent()).removeView(this.hOl);
            }
            viewGroup.addView(this.hOl, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void cN(List<AlaLiveStickerInfo> list) {
        boolean z;
        boolean z2 = true;
        if (this.hOl.getWidth() > 0 && this.hOl.getHeight() > 0) {
            if (this.hOm != null && list != null) {
                if (this.hOm.size() != list.size()) {
                    this.hOm = list;
                } else {
                    int size = list.size();
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            if (this.hOm.get(i).equals(list.get(i))) {
                                i++;
                            } else {
                                this.hOm = list;
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
            } else if (this.hOm != null && list == null) {
                this.hOm = list;
            } else if (this.hOm != null || list == null) {
                z2 = false;
            } else {
                this.hOm = list;
            }
            if (z2) {
                this.hOl.removeAllViews();
                if (this.hOm != null && this.hOm.size() > 0) {
                    for (AlaLiveStickerInfo alaLiveStickerInfo : this.hOm) {
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
                        a.this.hOl.b(alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }

    public void cnn() {
        this.hOl.setVisibility(8);
    }

    public void cno() {
        this.hOl.setVisibility(0);
    }
}
