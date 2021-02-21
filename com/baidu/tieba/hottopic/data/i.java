package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.PkModule;
/* loaded from: classes8.dex */
public class i implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId kuX = BdUniqueId.gen();
    public String kuY;
    public long kuZ;
    public String kug;
    public String kuh;
    public int kui;
    public int kva;
    public String kvb;
    public long kvc;
    public int kvd;
    public int kve;
    public int kvf;
    public long kvg;
    public long kvh;
    public long pkId;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return kuX;
    }

    public void a(PkModule pkModule) {
        int i;
        if (pkModule != null) {
            this.kug = pkModule.module_name;
            this.kuh = pkModule.ques_desc;
            this.kuY = pkModule.pk_1.pk_desc;
            this.kuZ = pkModule.pk_1.pk_num.longValue();
            this.kva = pkModule.pk_1.pk_index.intValue();
            this.kvb = pkModule.pk_2.pk_desc;
            this.kvc = pkModule.pk_2.pk_num.longValue();
            this.kvd = pkModule.pk_2.pk_index.intValue();
            if (pkModule.pk_1.has_clicked.intValue() == 1) {
                i = 1;
            } else {
                i = pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
            }
            this.kui = i;
            this.kve = pkModule.pk_type.intValue();
            this.kvf = pkModule.user_pk_index.intValue();
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.kvg = this.kui == 1 ? this.kuZ - 1 : this.kuZ;
            this.kvh = this.kui == 2 ? this.kvc - 1 : this.kvc;
        }
    }
}
