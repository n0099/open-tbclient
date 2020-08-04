package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.PkModule;
/* loaded from: classes15.dex */
public class i implements q {
    public static final BdUniqueId iKA = BdUniqueId.gen();
    public String iJK;
    public String iJL;
    public int iJM;
    public String iKB;
    public long iKC;
    public int iKD;
    public String iKE;
    public long iKF;
    public int iKG;
    public int iKH;
    public int iKI;
    public long iKJ;
    public long iKK;
    public long pkId;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iKA;
    }

    public void a(PkModule pkModule) {
        int i;
        if (pkModule != null) {
            this.iJK = pkModule.module_name;
            this.iJL = pkModule.ques_desc;
            this.iKB = pkModule.pk_1.pk_desc;
            this.iKC = pkModule.pk_1.pk_num.longValue();
            this.iKD = pkModule.pk_1.pk_index.intValue();
            this.iKE = pkModule.pk_2.pk_desc;
            this.iKF = pkModule.pk_2.pk_num.longValue();
            this.iKG = pkModule.pk_2.pk_index.intValue();
            if (pkModule.pk_1.has_clicked.intValue() == 1) {
                i = 1;
            } else {
                i = pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
            }
            this.iJM = i;
            this.iKH = pkModule.pk_type.intValue();
            this.iKI = pkModule.user_pk_index.intValue();
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.iKJ = this.iJM == 1 ? this.iKC - 1 : this.iKC;
            this.iKK = this.iJM == 2 ? this.iKF - 1 : this.iKF;
        }
    }
}
