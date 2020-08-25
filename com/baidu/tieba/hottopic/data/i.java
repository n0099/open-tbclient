package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.PkModule;
/* loaded from: classes15.dex */
public class i implements q {
    public static final BdUniqueId iZy = BdUniqueId.gen();
    public String iYI;
    public String iYJ;
    public int iYK;
    public long iZA;
    public int iZB;
    public String iZC;
    public long iZD;
    public int iZE;
    public int iZF;
    public int iZG;
    public long iZH;
    public long iZI;
    public String iZz;
    public long pkId;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iZy;
    }

    public void a(PkModule pkModule) {
        int i;
        if (pkModule != null) {
            this.iYI = pkModule.module_name;
            this.iYJ = pkModule.ques_desc;
            this.iZz = pkModule.pk_1.pk_desc;
            this.iZA = pkModule.pk_1.pk_num.longValue();
            this.iZB = pkModule.pk_1.pk_index.intValue();
            this.iZC = pkModule.pk_2.pk_desc;
            this.iZD = pkModule.pk_2.pk_num.longValue();
            this.iZE = pkModule.pk_2.pk_index.intValue();
            if (pkModule.pk_1.has_clicked.intValue() == 1) {
                i = 1;
            } else {
                i = pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
            }
            this.iYK = i;
            this.iZF = pkModule.pk_type.intValue();
            this.iZG = pkModule.user_pk_index.intValue();
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.iZH = this.iYK == 1 ? this.iZA - 1 : this.iZA;
            this.iZI = this.iYK == 2 ? this.iZD - 1 : this.iZD;
        }
    }
}
