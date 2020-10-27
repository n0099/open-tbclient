package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.PkModule;
/* loaded from: classes21.dex */
public class i implements q {
    public static final BdUniqueId jJH = BdUniqueId.gen();
    public String jIR;
    public String jIS;
    public int jIT;
    public String jJI;
    public long jJJ;
    public int jJK;
    public String jJL;
    public long jJM;
    public int jJN;
    public int jJO;
    public int jJP;
    public long jJQ;
    public long jJR;
    public long pkId;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jJH;
    }

    public void a(PkModule pkModule) {
        int i;
        if (pkModule != null) {
            this.jIR = pkModule.module_name;
            this.jIS = pkModule.ques_desc;
            this.jJI = pkModule.pk_1.pk_desc;
            this.jJJ = pkModule.pk_1.pk_num.longValue();
            this.jJK = pkModule.pk_1.pk_index.intValue();
            this.jJL = pkModule.pk_2.pk_desc;
            this.jJM = pkModule.pk_2.pk_num.longValue();
            this.jJN = pkModule.pk_2.pk_index.intValue();
            if (pkModule.pk_1.has_clicked.intValue() == 1) {
                i = 1;
            } else {
                i = pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
            }
            this.jIT = i;
            this.jJO = pkModule.pk_type.intValue();
            this.jJP = pkModule.user_pk_index.intValue();
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jJQ = this.jIT == 1 ? this.jJJ - 1 : this.jJJ;
            this.jJR = this.jIT == 2 ? this.jJM - 1 : this.jJM;
        }
    }
}
