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
/* loaded from: classes10.dex */
public class a {
    private AudienceStickerContainerView hJF;
    private List<AlaLiveStickerInfo> hJG;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void aP(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.hJF == null) {
                this.hJF = new AudienceStickerContainerView(this.mTbPageContext.getPageActivity());
            }
            if (this.hJF.getParent() != null) {
                ((ViewGroup) this.hJF.getParent()).removeView(this.hJF);
            }
            viewGroup.addView(this.hJF, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void cN(List<AlaLiveStickerInfo> list) {
        boolean z;
        boolean z2 = true;
        if (this.hJF.getWidth() > 0 && this.hJF.getHeight() > 0) {
            if (this.hJG != null && list != null) {
                if (this.hJG.size() != list.size()) {
                    this.hJG = list;
                } else {
                    int size = list.size();
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            if (this.hJG.get(i).equals(list.get(i))) {
                                i++;
                            } else {
                                this.hJG = list;
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
            } else if (this.hJG != null && list == null) {
                this.hJG = list;
            } else if (this.hJG != null || list == null) {
                z2 = false;
            } else {
                this.hJG = list;
            }
            if (z2) {
                this.hJF.removeAllViews();
                if (this.hJG != null && this.hJG.size() > 0) {
                    for (AlaLiveStickerInfo alaLiveStickerInfo : this.hJG) {
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
                        a.this.hJF.b(alaLiveStickerInfo);
                    }
                }
            }, null);
        }
    }

    public void cjw() {
        this.hJF.setVisibility(8);
    }

    public void cjx() {
        this.hJF.setVisibility(0);
    }
}
