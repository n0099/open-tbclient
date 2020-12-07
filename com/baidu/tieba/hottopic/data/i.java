package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.PkModule;
/* loaded from: classes21.dex */
public class i implements q {
    public static final BdUniqueId kdS = BdUniqueId.gen();
    public String kdT;
    public long kdU;
    public int kdV;
    public String kdW;
    public long kdX;
    public int kdY;
    public int kdZ;
    public String kdc;
    public String kdd;
    public int kde;
    public int kea;
    public long keb;
    public long kec;
    public long pkId;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kdS;
    }

    public void a(PkModule pkModule) {
        int i;
        if (pkModule != null) {
            this.kdc = pkModule.module_name;
            this.kdd = pkModule.ques_desc;
            this.kdT = pkModule.pk_1.pk_desc;
            this.kdU = pkModule.pk_1.pk_num.longValue();
            this.kdV = pkModule.pk_1.pk_index.intValue();
            this.kdW = pkModule.pk_2.pk_desc;
            this.kdX = pkModule.pk_2.pk_num.longValue();
            this.kdY = pkModule.pk_2.pk_index.intValue();
            if (pkModule.pk_1.has_clicked.intValue() == 1) {
                i = 1;
            } else {
                i = pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
            }
            this.kde = i;
            this.kdZ = pkModule.pk_type.intValue();
            this.kea = pkModule.user_pk_index.intValue();
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.keb = this.kde == 1 ? this.kdU - 1 : this.kdU;
            this.kec = this.kde == 2 ? this.kdX - 1 : this.kdX;
        }
    }
}
