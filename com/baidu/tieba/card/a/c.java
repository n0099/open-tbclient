package com.baidu.tieba.card.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.card.x;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class c extends b implements aj {
    private String aPM;
    private int aPN;
    private String aPO;
    private String mSource;

    public void setWeight(String str) {
        this.aPM = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void fc(int i) {
        this.aPN = i;
    }

    public void gL(String str) {
        this.aPO = str;
    }

    public int Is() {
        return this.aPN;
    }

    public String It() {
        return String.valueOf(this.mSource) + ContentProviderProxy.PROVIDER_FRAGMENT_SEPARATOR + this.aPN + ContentProviderProxy.PROVIDER_FRAGMENT_SEPARATOR + this.aPO;
    }

    public String getWeight() {
        return this.aPM;
    }

    public String getSource() {
        return this.mSource;
    }

    public String Iu() {
        return this.aPO;
    }

    public z Iv() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public av gM(String str) {
        z Iv = Iv();
        if (Iv == null) {
            return null;
        }
        return new av(str).aa(ImageViewerConfig.FORUM_ID, String.valueOf(Iv.ss())).aa("tid", String.valueOf(Iv.getTid())).aa("obj_param1", getWeight()).aa("obj_source", getSource()).r("obj_locate", Is()).aa("obj_param3", x.Im()).r("obj_type", Iw());
    }

    private int Iw() {
        boolean z;
        z Iv = Iv();
        if (Iv == null) {
            return 0;
        }
        boolean z2 = (StringUtils.isNull(Iv.sy()) && StringUtils.isNull(Iv.getTitle())) ? false : true;
        ArrayList<MediaData> medias = Iv.getMedias();
        if (medias != null) {
            Iterator<MediaData> it = medias.iterator();
            while (it.hasNext()) {
                MediaData next = it.next();
                if (next != null && (next.getType() == 3 || next.getType() == 5)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        return z2 ? z ? 3 : 1 : z ? 2 : 0;
    }

    @Override // com.baidu.tbadk.core.util.aj
    public ArrayList<ai> getImages() {
        z Iv = Iv();
        if (Iv != null) {
            return Iv.getImages();
        }
        return null;
    }
}
