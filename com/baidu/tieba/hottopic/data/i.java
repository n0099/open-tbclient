package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.PkModule;
/* loaded from: classes20.dex */
public class i implements q {
    public static final BdUniqueId jik = BdUniqueId.gen();
    public String jht;
    public String jhu;
    public int jhv;
    public String jil;
    public long jim;
    public int jin;
    public String jio;
    public long jip;
    public int jiq;
    public int jir;
    public int jis;
    public long jit;
    public long jiu;
    public long pkId;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jik;
    }

    public void a(PkModule pkModule) {
        int i;
        if (pkModule != null) {
            this.jht = pkModule.module_name;
            this.jhu = pkModule.ques_desc;
            this.jil = pkModule.pk_1.pk_desc;
            this.jim = pkModule.pk_1.pk_num.longValue();
            this.jin = pkModule.pk_1.pk_index.intValue();
            this.jio = pkModule.pk_2.pk_desc;
            this.jip = pkModule.pk_2.pk_num.longValue();
            this.jiq = pkModule.pk_2.pk_index.intValue();
            if (pkModule.pk_1.has_clicked.intValue() == 1) {
                i = 1;
            } else {
                i = pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
            }
            this.jhv = i;
            this.jir = pkModule.pk_type.intValue();
            this.jis = pkModule.user_pk_index.intValue();
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jit = this.jhv == 1 ? this.jim - 1 : this.jim;
            this.jiu = this.jhv == 2 ? this.jip - 1 : this.jip;
        }
    }
}
