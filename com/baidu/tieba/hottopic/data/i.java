package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.PkModule;
/* loaded from: classes7.dex */
public class i implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId kmC = BdUniqueId.gen();
    public String klL;
    public String klM;
    public int klN;
    public String kmD;
    public long kmE;
    public int kmF;
    public String kmG;
    public long kmH;
    public int kmI;
    public int kmJ;
    public int kmK;
    public long kmL;
    public long kmM;
    public long pkId;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return kmC;
    }

    public void a(PkModule pkModule) {
        int i;
        if (pkModule != null) {
            this.klL = pkModule.module_name;
            this.klM = pkModule.ques_desc;
            this.kmD = pkModule.pk_1.pk_desc;
            this.kmE = pkModule.pk_1.pk_num.longValue();
            this.kmF = pkModule.pk_1.pk_index.intValue();
            this.kmG = pkModule.pk_2.pk_desc;
            this.kmH = pkModule.pk_2.pk_num.longValue();
            this.kmI = pkModule.pk_2.pk_index.intValue();
            if (pkModule.pk_1.has_clicked.intValue() == 1) {
                i = 1;
            } else {
                i = pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
            }
            this.klN = i;
            this.kmJ = pkModule.pk_type.intValue();
            this.kmK = pkModule.user_pk_index.intValue();
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.kmL = this.klN == 1 ? this.kmE - 1 : this.kmE;
            this.kmM = this.klN == 2 ? this.kmH - 1 : this.kmH;
        }
    }
}
