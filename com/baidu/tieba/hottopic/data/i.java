package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.PkModule;
/* loaded from: classes21.dex */
public class i implements q {
    public static final BdUniqueId jPF = BdUniqueId.gen();
    public String jOP;
    public String jOQ;
    public int jOR;
    public String jPG;
    public long jPH;
    public int jPI;
    public String jPJ;
    public long jPK;
    public int jPL;
    public int jPM;
    public int jPN;
    public long jPO;
    public long jPP;
    public long pkId;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jPF;
    }

    public void a(PkModule pkModule) {
        int i;
        if (pkModule != null) {
            this.jOP = pkModule.module_name;
            this.jOQ = pkModule.ques_desc;
            this.jPG = pkModule.pk_1.pk_desc;
            this.jPH = pkModule.pk_1.pk_num.longValue();
            this.jPI = pkModule.pk_1.pk_index.intValue();
            this.jPJ = pkModule.pk_2.pk_desc;
            this.jPK = pkModule.pk_2.pk_num.longValue();
            this.jPL = pkModule.pk_2.pk_index.intValue();
            if (pkModule.pk_1.has_clicked.intValue() == 1) {
                i = 1;
            } else {
                i = pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
            }
            this.jOR = i;
            this.jPM = pkModule.pk_type.intValue();
            this.jPN = pkModule.user_pk_index.intValue();
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jPO = this.jOR == 1 ? this.jPH - 1 : this.jPH;
            this.jPP = this.jOR == 2 ? this.jPK - 1 : this.jPK;
        }
    }
}
