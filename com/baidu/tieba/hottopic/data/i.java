package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.PkModule;
/* loaded from: classes21.dex */
public class i implements q {
    public static final BdUniqueId jxi = BdUniqueId.gen();
    public String jws;
    public String jwt;
    public int jwu;
    public String jxj;
    public long jxk;
    public int jxl;
    public String jxm;
    public long jxn;
    public int jxo;
    public int jxp;
    public int jxq;
    public long jxr;
    public long jxs;
    public long pkId;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jxi;
    }

    public void a(PkModule pkModule) {
        int i;
        if (pkModule != null) {
            this.jws = pkModule.module_name;
            this.jwt = pkModule.ques_desc;
            this.jxj = pkModule.pk_1.pk_desc;
            this.jxk = pkModule.pk_1.pk_num.longValue();
            this.jxl = pkModule.pk_1.pk_index.intValue();
            this.jxm = pkModule.pk_2.pk_desc;
            this.jxn = pkModule.pk_2.pk_num.longValue();
            this.jxo = pkModule.pk_2.pk_index.intValue();
            if (pkModule.pk_1.has_clicked.intValue() == 1) {
                i = 1;
            } else {
                i = pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
            }
            this.jwu = i;
            this.jxp = pkModule.pk_type.intValue();
            this.jxq = pkModule.user_pk_index.intValue();
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jxr = this.jwu == 1 ? this.jxk - 1 : this.jxk;
            this.jxs = this.jwu == 2 ? this.jxn - 1 : this.jxn;
        }
    }
}
