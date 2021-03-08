package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.PkModule;
/* loaded from: classes7.dex */
public class i implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId kwZ = BdUniqueId.gen();
    public String kwi;
    public String kwj;
    public int kwk;
    public String kxa;
    public long kxb;
    public int kxc;
    public String kxd;
    public long kxe;
    public int kxf;
    public int kxg;
    public int kxh;
    public long kxi;
    public long kxj;
    public long pkId;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return kwZ;
    }

    public void a(PkModule pkModule) {
        int i;
        if (pkModule != null) {
            this.kwi = pkModule.module_name;
            this.kwj = pkModule.ques_desc;
            this.kxa = pkModule.pk_1.pk_desc;
            this.kxb = pkModule.pk_1.pk_num.longValue();
            this.kxc = pkModule.pk_1.pk_index.intValue();
            this.kxd = pkModule.pk_2.pk_desc;
            this.kxe = pkModule.pk_2.pk_num.longValue();
            this.kxf = pkModule.pk_2.pk_index.intValue();
            if (pkModule.pk_1.has_clicked.intValue() == 1) {
                i = 1;
            } else {
                i = pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
            }
            this.kwk = i;
            this.kxg = pkModule.pk_type.intValue();
            this.kxh = pkModule.user_pk_index.intValue();
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.kxi = this.kwk == 1 ? this.kxb - 1 : this.kxb;
            this.kxj = this.kwk == 2 ? this.kxe - 1 : this.kxe;
        }
    }
}
