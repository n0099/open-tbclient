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
    private AudienceStickerContainerView gwS;
    private List<AlaLiveStickerInfo> gwT;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void aC(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.gwS == null) {
                this.gwS = new AudienceStickerContainerView(this.mTbPageContext.getPageActivity());
            }
            if (this.gwS.getParent() != null) {
                ((ViewGroup) this.gwS.getParent()).removeView(this.gwS);
            }
            viewGroup.addView(this.gwS, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void ca(List<AlaLiveStickerInfo> list) {
        boolean z;
        boolean z2 = true;
        if (this.gwS.getWidth() > 0 && this.gwS.getHeight() > 0) {
            if (this.gwT != null && list != null) {
                if (this.gwT.size() != list.size()) {
                    this.gwT = list;
                } else {
                    int size = list.size();
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            if (this.gwT.get(i).equals(list.get(i))) {
                                i++;
                            } else {
                                this.gwT = list;
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
            } else if (this.gwT != null && list == null) {
                this.gwT = list;
            } else if (this.gwT != null || list == null) {
                z2 = false;
            } else {
                this.gwT = list;
            }
            if (z2) {
                this.gwS.removeAllViews();
                if (this.gwT != null && this.gwT.size() > 0) {
                    for (AlaLiveStickerInfo alaLiveStickerInfo : this.gwT) {
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
                        a.this.gwS.b(alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }

    public void bMy() {
        this.gwS.setVisibility(8);
    }

    public void bMz() {
        this.gwS.setVisibility(0);
    }
}
