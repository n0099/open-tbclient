package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.PkModule;
/* loaded from: classes8.dex */
public class i implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId krh = BdUniqueId.gen();
    public String kqq;
    public String kqr;
    public int kqs;
    public String kri;
    public long krj;
    public int krk;
    public String krl;
    public long krm;
    public int krn;
    public int kro;
    public int krp;
    public long krq;
    public long krr;
    public long pkId;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return krh;
    }

    public void a(PkModule pkModule) {
        int i;
        if (pkModule != null) {
            this.kqq = pkModule.module_name;
            this.kqr = pkModule.ques_desc;
            this.kri = pkModule.pk_1.pk_desc;
            this.krj = pkModule.pk_1.pk_num.longValue();
            this.krk = pkModule.pk_1.pk_index.intValue();
            this.krl = pkModule.pk_2.pk_desc;
            this.krm = pkModule.pk_2.pk_num.longValue();
            this.krn = pkModule.pk_2.pk_index.intValue();
            if (pkModule.pk_1.has_clicked.intValue() == 1) {
                i = 1;
            } else {
                i = pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
            }
            this.kqs = i;
            this.kro = pkModule.pk_type.intValue();
            this.krp = pkModule.user_pk_index.intValue();
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.krq = this.kqs == 1 ? this.krj - 1 : this.krj;
            this.krr = this.kqs == 2 ? this.krm - 1 : this.krm;
        }
    }
}
