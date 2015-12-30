package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import tbclient.Hottopic.PkModule;
/* loaded from: classes.dex */
public class e implements u {
    public static final BdUniqueId bHw = BdUniqueId.gen();
    public String bHA;
    public long bHB;
    public int bHC;
    public int bHD;
    public int bHE;
    public String bHa;
    public String bHb;
    public int bHd;
    public long bHg;
    public long bHh;
    public String bHx;
    public long bHy;
    public int bHz;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bHw;
    }

    public void a(PkModule pkModule) {
        int i = 1;
        if (pkModule != null) {
            this.bHa = pkModule.module_name;
            this.bHb = pkModule.ques_desc;
            this.bHx = pkModule.pk_1.pk_desc;
            this.bHy = pkModule.pk_1.pk_num.longValue();
            this.bHz = pkModule.pk_1.pk_index.intValue();
            this.bHA = pkModule.pk_2.pk_desc;
            this.bHB = pkModule.pk_2.pk_num.longValue();
            this.bHC = pkModule.pk_2.pk_index.intValue();
            if (pkModule.pk_1.has_clicked.intValue() != 1) {
                i = pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
            }
            this.bHd = i;
            this.bHD = pkModule.pk_type.intValue();
            this.bHE = pkModule.user_pk_index.intValue();
            this.bHg = pkModule.pk_id.longValue();
            this.bHh = pkModule.user_pk_id.longValue();
        }
    }
}
