package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.PkModule;
/* loaded from: classes8.dex */
public class i implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId kuJ = BdUniqueId.gen();
    public String ktS;
    public String ktT;
    public int ktU;
    public String kuK;
    public long kuL;
    public int kuM;
    public String kuN;
    public long kuO;
    public int kuP;
    public int kuQ;
    public int kuR;
    public long kuS;
    public long kuT;
    public long pkId;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return kuJ;
    }

    public void a(PkModule pkModule) {
        int i;
        if (pkModule != null) {
            this.ktS = pkModule.module_name;
            this.ktT = pkModule.ques_desc;
            this.kuK = pkModule.pk_1.pk_desc;
            this.kuL = pkModule.pk_1.pk_num.longValue();
            this.kuM = pkModule.pk_1.pk_index.intValue();
            this.kuN = pkModule.pk_2.pk_desc;
            this.kuO = pkModule.pk_2.pk_num.longValue();
            this.kuP = pkModule.pk_2.pk_index.intValue();
            if (pkModule.pk_1.has_clicked.intValue() == 1) {
                i = 1;
            } else {
                i = pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
            }
            this.ktU = i;
            this.kuQ = pkModule.pk_type.intValue();
            this.kuR = pkModule.user_pk_index.intValue();
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.kuS = this.ktU == 1 ? this.kuL - 1 : this.kuL;
            this.kuT = this.ktU == 2 ? this.kuO - 1 : this.kuO;
        }
    }
}
