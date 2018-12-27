package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes6.dex */
public class l extends c implements com.baidu.tbadk.core.util.e.a {
    public static final BdUniqueId daZ = BdUniqueId.gen();
    public static final BdUniqueId dba = BdUniqueId.gen();
    public static String dbb = "";
    public static String dbc = "";
    public static String dbd = "";
    public static String dbe = "";
    public static String dbf = "";
    public static String dbg = "";
    public bb bMM;
    public boolean daY = false;
    public boolean dbh = true;
    public int sourceType = 0;

    public l(bb bbVar) {
        this.bMM = bbVar;
    }

    public static boolean S(bb bbVar) {
        return (bbVar == null || bbVar.zY() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.bMM == null) {
            return daZ;
        }
        if (this.bMM.zJ() || this.bMM.zK()) {
            return dba;
        }
        return daZ;
    }

    @Override // com.baidu.tieba.card.data.c
    public bb ZT() {
        if (this.bMM == null) {
            return this.bMM;
        }
        if (this.bMM.zv() == 5) {
            return this.bMM;
        }
        this.bMM.setResource(1);
        return this.bMM;
    }

    public am mN(String str) {
        am amVar = new am(str);
        if (this.bMM != null) {
            amVar.i(ImageViewerConfig.FORUM_ID, this.bMM.getFid());
            amVar.aA("tid", this.bMM.getTid());
            amVar.x("obj_type", 2);
            amVar.x("obj_param1", aqI() ? 2 : 1);
            if (this.bMM.zG() != null) {
                amVar.aA(VideoPlayActivityConfig.OBJ_ID, this.bMM.zG().getUserId());
            }
        }
        return amVar;
    }

    public am aqN() {
        am y = y(dbd, true);
        if (y != null && ZT() != null) {
            bb ZT = ZT();
            y.x("obj_name", ZT.AX() != null && (ZT.AX().bEl() != null || ZT.AX().Sj() != null) ? 1 : 0);
            if (ZT.zG() != null) {
                y.x("ab_type", ZT.zG().hadConcerned() ? 1 : 0);
            }
        }
        return y;
    }

    public am T(bb bbVar) {
        return (bbVar.AJ() == null || bbVar.AJ().channelId <= 0) ? y(dbe, true) : y(dbf, true);
    }

    public am aqP() {
        return y(dbc, true);
    }

    public am U(bb bbVar) {
        return (bbVar.AJ() == null || bbVar.AJ().channelId <= 0) ? y(dbb, true) : y(dbg, true);
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.bMM == null || this.bMM.zY() == null || this.bMM.zY().video_url == null) {
            return null;
        }
        return this.bMM.zY().video_url;
    }
}
