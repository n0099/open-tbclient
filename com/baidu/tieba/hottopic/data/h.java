package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import tbclient.Hottopic.PkModule;
/* loaded from: classes.dex */
public class h implements u {
    public static final BdUniqueId bLi = BdUniqueId.gen();
    public String bKA;
    public String bKB;
    public int bKD;
    public long bKG;
    public long bKH;
    public String bLj;
    public long bLk;
    public int bLl;
    public String bLm;
    public long bLn;
    public int bLo;
    public int bLp;
    public int bLq;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bLi;
    }

    public void a(PkModule pkModule) {
        int i = 1;
        if (pkModule != null) {
            this.bKA = pkModule.module_name;
            this.bKB = pkModule.ques_desc;
            this.bLj = pkModule.pk_1.pk_desc;
            this.bLk = pkModule.pk_1.pk_num.longValue();
            this.bLl = pkModule.pk_1.pk_index.intValue();
            this.bLm = pkModule.pk_2.pk_desc;
            this.bLn = pkModule.pk_2.pk_num.longValue();
            this.bLo = pkModule.pk_2.pk_index.intValue();
            if (pkModule.pk_1.has_clicked.intValue() != 1) {
                i = pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
            }
            this.bKD = i;
            this.bLp = pkModule.pk_type.intValue();
            this.bLq = pkModule.user_pk_index.intValue();
            this.bKG = pkModule.pk_id.longValue();
            this.bKH = pkModule.user_pk_id.longValue();
        }
    }
}
