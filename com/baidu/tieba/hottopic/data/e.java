package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import tbclient.Hottopic.PkModule;
/* loaded from: classes.dex */
public class e implements u {
    public static final BdUniqueId bDT = BdUniqueId.gen();
    public long bDC;
    public long bDD;
    public String bDU;
    public long bDV;
    public int bDW;
    public String bDX;
    public long bDY;
    public int bDZ;
    public String bDw;
    public String bDx;
    public int bDz;
    public int bEa;
    public int bEb;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bDT;
    }

    public void a(PkModule pkModule) {
        int i = 1;
        if (pkModule != null) {
            this.bDw = pkModule.module_name;
            this.bDx = pkModule.ques_desc;
            this.bDU = pkModule.pk_1.pk_desc;
            this.bDV = pkModule.pk_1.pk_num.longValue();
            this.bDW = pkModule.pk_1.pk_index.intValue();
            this.bDX = pkModule.pk_2.pk_desc;
            this.bDY = pkModule.pk_2.pk_num.longValue();
            this.bDZ = pkModule.pk_2.pk_index.intValue();
            if (pkModule.pk_1.has_clicked.intValue() != 1) {
                i = pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
            }
            this.bDz = i;
            this.bEa = pkModule.pk_type.intValue();
            this.bEb = pkModule.user_pk_index.intValue();
            this.bDC = pkModule.pk_id.longValue();
            this.bDD = pkModule.user_pk_id.longValue();
        }
    }
}
