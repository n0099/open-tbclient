package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.PkModule;
/* loaded from: classes20.dex */
public class i implements q {
    public static final BdUniqueId jQp = BdUniqueId.gen();
    public String jPA;
    public int jPB;
    public String jPz;
    public String jQq;
    public long jQr;
    public int jQs;
    public String jQt;
    public long jQu;
    public int jQv;
    public int jQw;
    public int jQx;
    public long jQy;
    public long jQz;
    public long pkId;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jQp;
    }

    public void a(PkModule pkModule) {
        int i;
        if (pkModule != null) {
            this.jPz = pkModule.module_name;
            this.jPA = pkModule.ques_desc;
            this.jQq = pkModule.pk_1.pk_desc;
            this.jQr = pkModule.pk_1.pk_num.longValue();
            this.jQs = pkModule.pk_1.pk_index.intValue();
            this.jQt = pkModule.pk_2.pk_desc;
            this.jQu = pkModule.pk_2.pk_num.longValue();
            this.jQv = pkModule.pk_2.pk_index.intValue();
            if (pkModule.pk_1.has_clicked.intValue() == 1) {
                i = 1;
            } else {
                i = pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
            }
            this.jPB = i;
            this.jQw = pkModule.pk_type.intValue();
            this.jQx = pkModule.user_pk_index.intValue();
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jQy = this.jPB == 1 ? this.jQr - 1 : this.jQr;
            this.jQz = this.jPB == 2 ? this.jQu - 1 : this.jQu;
        }
    }
}
