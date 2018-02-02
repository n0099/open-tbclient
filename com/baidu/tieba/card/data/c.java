package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class c extends b implements ae {
    private String cXa;
    private int cXb;
    private String cXc;
    private String cXd;
    private String cXf;
    private String mSource;
    public String tid;
    public int cXe = 0;
    public SparseArray<String> aLY = null;

    public void setWeight(String str) {
        this.cXa = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void lH(int i) {
        this.cXb = i;
    }

    public void ko(String str) {
        this.cXc = str;
    }

    public int akS() {
        return this.cXb;
    }

    public String akT() {
        return this.mSource + "#" + this.cXb + "#" + this.cXc;
    }

    public String getWeight() {
        return this.cXa;
    }

    public String getSource() {
        return this.mSource;
    }

    public String akU() {
        return this.cXc;
    }

    public String akV() {
        return this.cXd;
    }

    public void kp(String str) {
        this.cXd = str;
    }

    public bd VM() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void setExtra(String str) {
        this.cXf = str;
    }

    public String getExtra() {
        return this.cXf;
    }

    public ak kq(String str) {
        return t(str, false);
    }

    public ak t(String str, boolean z) {
        bd VM = VM();
        if (VM == null) {
            return null;
        }
        ak aa = new ak(str).aa(ImageViewerConfig.FORUM_ID, String.valueOf(VM.getFid())).aa("tid", String.valueOf(VM.getTid())).aa("obj_id", getExtra()).aa("obj_param1", getWeight()).s("obj_param2", 1).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).s("obj_locate", akS()).aa("uid", TbadkCoreApplication.getCurrentAccount()).aa("obj_param3", com.baidu.tieba.card.k.akx());
        if (!z) {
            aa.s("obj_type", akW());
        } else {
            if (VM.aPa > 0) {
                aa.s("midpageflag", 1);
            } else {
                aa.s("midpageflag", 0);
            }
            aa.aa("ab_tag", akU());
        }
        if (VM.Ah() != null && VM.Ah().bvM() != null && VM.Ah().bvM().QD() != null && VM.Ah().bvM().QD().size() > 0) {
            aa.s("obj_to", VM.Ah().gZh ? 2 : 1);
        }
        return aa;
    }

    public ak W(String str, int i) {
        bd VM = VM();
        if (VM == null) {
            return null;
        }
        ak aa = new ak(str).aa(ImageViewerConfig.FORUM_ID, String.valueOf(VM.getFid())).aa("tid", String.valueOf(VM.getTid())).s("obj_id", I(VM)).s("obj_param2", 1).aa("obj_param1", getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).s("obj_locate", akS()).aa("obj_name", akU()).aa("uid", TbadkCoreApplication.getCurrentAccount()).aa("obj_param3", com.baidu.tieba.card.k.akx());
        if (i == 0) {
            aa.s("obj_type", akW());
        } else {
            aa.s("obj_type", i);
        }
        aa.aa("obj_id", getExtra());
        return aa;
    }

    private int akW() {
        int i;
        int i2 = 0;
        bd VM = VM();
        if (VM == null) {
            return 0;
        }
        ArrayList<MediaData> ze = VM.ze();
        if (ze == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = ze.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                MediaData next = it.next();
                if (next != null && next.getType() == 3) {
                    i++;
                }
                i2 = i;
            }
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        bd VM = VM();
        if (VM != null) {
            return VM.getImages();
        }
        return null;
    }

    private int I(bd bdVar) {
        if (bdVar.zV() == null || bdVar.zV().channelId <= 0) {
            return 0;
        }
        return (int) bdVar.zV().channelId;
    }
}
