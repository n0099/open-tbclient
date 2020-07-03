package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.PkModule;
/* loaded from: classes8.dex */
public class i implements q {
    public static final BdUniqueId iEu = BdUniqueId.gen();
    public String iDE;
    public String iDF;
    public int iDG;
    public int iEA;
    public int iEB;
    public int iEC;
    public long iED;
    public long iEE;
    public String iEv;
    public long iEw;
    public int iEx;
    public String iEy;
    public long iEz;
    public long pkId;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iEu;
    }

    public void a(PkModule pkModule) {
        int i;
        if (pkModule != null) {
            this.iDE = pkModule.module_name;
            this.iDF = pkModule.ques_desc;
            this.iEv = pkModule.pk_1.pk_desc;
            this.iEw = pkModule.pk_1.pk_num.longValue();
            this.iEx = pkModule.pk_1.pk_index.intValue();
            this.iEy = pkModule.pk_2.pk_desc;
            this.iEz = pkModule.pk_2.pk_num.longValue();
            this.iEA = pkModule.pk_2.pk_index.intValue();
            if (pkModule.pk_1.has_clicked.intValue() == 1) {
                i = 1;
            } else {
                i = pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
            }
            this.iDG = i;
            this.iEB = pkModule.pk_type.intValue();
            this.iEC = pkModule.user_pk_index.intValue();
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.iED = this.iDG == 1 ? this.iEw - 1 : this.iEw;
            this.iEE = this.iDG == 2 ? this.iEz - 1 : this.iEz;
        }
    }
}
