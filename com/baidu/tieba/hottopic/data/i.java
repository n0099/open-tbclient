package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.PkModule;
/* loaded from: classes15.dex */
public class i implements q {
    public static final BdUniqueId iKy = BdUniqueId.gen();
    public String iJI;
    public String iJJ;
    public int iJK;
    public long iKA;
    public int iKB;
    public String iKC;
    public long iKD;
    public int iKE;
    public int iKF;
    public int iKG;
    public long iKH;
    public long iKI;
    public String iKz;
    public long pkId;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iKy;
    }

    public void a(PkModule pkModule) {
        int i;
        if (pkModule != null) {
            this.iJI = pkModule.module_name;
            this.iJJ = pkModule.ques_desc;
            this.iKz = pkModule.pk_1.pk_desc;
            this.iKA = pkModule.pk_1.pk_num.longValue();
            this.iKB = pkModule.pk_1.pk_index.intValue();
            this.iKC = pkModule.pk_2.pk_desc;
            this.iKD = pkModule.pk_2.pk_num.longValue();
            this.iKE = pkModule.pk_2.pk_index.intValue();
            if (pkModule.pk_1.has_clicked.intValue() == 1) {
                i = 1;
            } else {
                i = pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
            }
            this.iJK = i;
            this.iKF = pkModule.pk_type.intValue();
            this.iKG = pkModule.user_pk_index.intValue();
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.iKH = this.iJK == 1 ? this.iKA - 1 : this.iKA;
            this.iKI = this.iJK == 2 ? this.iKD - 1 : this.iKD;
        }
    }
}
