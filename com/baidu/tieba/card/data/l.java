package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class l extends c {
    public bd threadData;
    public static String cWQ = "";
    public static String cWR = "";
    public static String cWS = "";
    public static String cWT = "";
    public static String cWU = "";
    public static String cWV = "";
    public static String cWW = "";
    public static String cWX = "";
    public static String cWY = "";
    public static String cWZ = "";
    public static String cXa = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId cXb = BdUniqueId.gen();
    public static final BdUniqueId aMZ = BdUniqueId.gen();
    public static final BdUniqueId aNf = BdUniqueId.gen();
    public boolean cXc = false;
    public boolean isLinkThread = false;
    public boolean cXd = false;
    public boolean brt = true;

    public static boolean J(bd bdVar) {
        if (bdVar == null) {
            return false;
        }
        return bdVar.getType() == bd.aMY || bdVar.getType() == bd.aNa || bdVar.getType() == bd.aMZ || bdVar.getType() == bd.aNf;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.cXc) {
            return cXb;
        }
        if (this.isLinkThread) {
            return aMZ;
        }
        if (this.threadData.isShareThread) {
            return aNf;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd VK() {
        return this.threadData;
    }

    public boolean akV() {
        return (this.threadData == null || v.D(this.threadData.zh()) == 0) ? false : true;
    }

    public ak akW() {
        bd VK;
        if (this.cXc) {
            ak akVar = new ak("c11003");
            if (VK() != null && (VK = VK()) != null) {
                akVar.ab("tid", VK.getTid());
                if (VK.yS() != null) {
                    akVar.s("ab_type", VK.yS().hadConcerned() ? 1 : 0);
                }
            }
            return akVar;
        } else if (akV()) {
            ak ki = ki(cWV);
            if (ki != null && VK() != null) {
                bd VK2 = VK();
                ki.s("obj_name", VK2.Ag() != null && (VK2.Ag().bvK() != null || VK2.Ag().QJ() != null) ? 1 : 0);
                if (VK2.yS() != null) {
                    ki.s("ab_type", VK2.yS().hadConcerned() ? 1 : 0);
                }
            }
            return ki;
        } else {
            ak ki2 = ki(cWQ);
            if (ki2 != null) {
                ki2.ab("ab_tag", akP()).ab("ab_action", "show");
                if (VK() != null) {
                    bd VK3 = VK();
                    boolean z = (VK3.Ag() == null || (VK3.Ag().bvK() == null && VK3.Ag().QJ() == null)) ? false : true;
                    ki2.s("obj_name", z ? 1 : 0);
                    if (z && VK3.Ag().bvK() != null && VK3.Ag().bvK().QB() != null && VK3.Ag().bvK().QB().size() > 0) {
                        ki2.s("obj_to", VK3.Ag().gYN ? 2 : 1);
                    }
                    if (VK3.yS() != null) {
                        ki2.s("ab_type", VK3.yS().hadConcerned() ? 1 : 0);
                    }
                }
            }
            return ki2;
        }
    }

    public ak kk(String str) {
        ak akVar = new ak(str);
        if (akVar != null && this.threadData != null) {
            akVar.f(ImageViewerConfig.FORUM_ID, this.threadData.getFid());
            akVar.ab("tid", this.threadData.getTid());
            int i = 1;
            if (this.threadData.isLinkThread()) {
                i = 4;
            } else if (this.threadData.isShareThread) {
                i = 5;
            }
            akVar.s("obj_type", i);
            akVar.ab("obj_id", this.threadData.yS().getUserId());
        }
        return akVar;
    }

    public ak kl(String str) {
        ak ki = ki(str);
        if (ki != null) {
            ki.ab("ab_tag", akP()).ab("ab_action", "show");
            if (VK() != null) {
                bd VK = VK();
                boolean z = (VK.Ag() == null || (VK.Ag().bvK() == null && VK.Ag().QJ() == null)) ? false : true;
                ki.s("obj_name", z ? 1 : 0);
                if (z && VK.Ag().bvK() != null && VK.Ag().bvK().QB() != null && VK.Ag().bvK().QB().size() > 0) {
                    ki.s("obj_to", VK.Ag().gYN ? 2 : 1);
                }
            }
        }
        return ki;
    }

    public ak km(String str) {
        ak ki = ki(str);
        if (ki != null) {
            ki.ab("ab_tag", akP()).ab("ab_action", "click");
        }
        return ki;
    }

    public ak akX() {
        if (akV()) {
            return ki(cWW);
        }
        ak ki = ki(cWR);
        if (ki != null) {
            ki.ab("ab_tag", akP()).ab("ab_action", "click");
            return ki;
        }
        return ki;
    }

    public ak akY() {
        if (akV()) {
            return ki(cWX);
        }
        ak W = W(cWS, 0);
        if (W != null) {
            W.ab("ab_tag", akP()).ab("ab_action", "click");
            return W;
        }
        return W;
    }

    public ak akZ() {
        if (akV()) {
            return ki(cWY);
        }
        ak ki = ki(cWT);
        if (ki != null) {
            ki.ab("ab_tag", akP()).ab("ab_action", "click");
            return ki;
        }
        return ki;
    }

    public ak ala() {
        if (akV()) {
            return ki(cWZ);
        }
        ak ki = ki(cWU);
        if (ki != null) {
            ki.ab("ab_tag", akP()).ab("ab_action", "click");
            return ki;
        }
        return ki;
    }

    public ak alb() {
        return ki(cXa);
    }

    public ak kn(String str) {
        return ki(str);
    }

    public ak ko(String str) {
        ak ki = ki(str);
        if (this.threadData != null && this.threadData.yS() != null) {
            ki.s("ab_type", this.threadData.yS().hadConcerned() ? 1 : 0);
        }
        return ki;
    }

    public ak kp(String str) {
        return ki(str);
    }
}
