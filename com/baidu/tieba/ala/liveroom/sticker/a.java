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
    private AudienceStickerContainerView hCk;
    private List<AlaLiveStickerInfo> hCl;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void aD(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.hCk == null) {
                this.hCk = new AudienceStickerContainerView(this.mTbPageContext.getPageActivity());
            }
            if (this.hCk.getParent() != null) {
                ((ViewGroup) this.hCk.getParent()).removeView(this.hCk);
            }
            viewGroup.addView(this.hCk, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void cG(List<AlaLiveStickerInfo> list) {
        boolean z;
        boolean z2 = true;
        if (this.hCk.getWidth() > 0 && this.hCk.getHeight() > 0) {
            if (this.hCl != null && list != null) {
                if (this.hCl.size() != list.size()) {
                    this.hCl = list;
                } else {
                    int size = list.size();
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            if (this.hCl.get(i).equals(list.get(i))) {
                                i++;
                            } else {
                                this.hCl = list;
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
            } else if (this.hCl != null && list == null) {
                this.hCl = list;
            } else if (this.hCl != null || list == null) {
                z2 = false;
            } else {
                this.hCl = list;
            }
            if (z2) {
                this.hCk.removeAllViews();
                if (this.hCl != null && this.hCl.size() > 0) {
                    for (AlaLiveStickerInfo alaLiveStickerInfo : this.hCl) {
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
                        a.this.hCk.b(alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }

    public void ckz() {
        this.hCk.setVisibility(8);
    }

    public void ckA() {
        this.hCk.setVisibility(0);
    }
}
