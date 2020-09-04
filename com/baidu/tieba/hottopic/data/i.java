package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.PkModule;
/* loaded from: classes15.dex */
public class i implements q {
    public static final BdUniqueId iZE = BdUniqueId.gen();
    public String iYO;
    public String iYP;
    public int iYQ;
    public String iZF;
    public long iZG;
    public int iZH;
    public String iZI;
    public long iZJ;
    public int iZK;
    public int iZL;
    public int iZM;
    public long iZN;
    public long iZO;
    public long pkId;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iZE;
    }

    public void a(PkModule pkModule) {
        int i;
        if (pkModule != null) {
            this.iYO = pkModule.module_name;
            this.iYP = pkModule.ques_desc;
            this.iZF = pkModule.pk_1.pk_desc;
            this.iZG = pkModule.pk_1.pk_num.longValue();
            this.iZH = pkModule.pk_1.pk_index.intValue();
            this.iZI = pkModule.pk_2.pk_desc;
            this.iZJ = pkModule.pk_2.pk_num.longValue();
            this.iZK = pkModule.pk_2.pk_index.intValue();
            if (pkModule.pk_1.has_clicked.intValue() == 1) {
                i = 1;
            } else {
                i = pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
            }
            this.iYQ = i;
            this.iZL = pkModule.pk_type.intValue();
            this.iZM = pkModule.user_pk_index.intValue();
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.iZN = this.iYQ == 1 ? this.iZG - 1 : this.iZG;
            this.iZO = this.iYQ == 2 ? this.iZJ - 1 : this.iZJ;
        }
    }
}
