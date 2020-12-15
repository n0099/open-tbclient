package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.PkModule;
/* loaded from: classes21.dex */
public class i implements q {
    public static final BdUniqueId kdU = BdUniqueId.gen();
    public String kdV;
    public long kdW;
    public int kdX;
    public String kdY;
    public long kdZ;
    public String kde;
    public String kdf;
    public int kdg;
    public int kea;
    public int keb;
    public int kec;
    public long ked;
    public long kee;
    public long pkId;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kdU;
    }

    public void a(PkModule pkModule) {
        int i;
        if (pkModule != null) {
            this.kde = pkModule.module_name;
            this.kdf = pkModule.ques_desc;
            this.kdV = pkModule.pk_1.pk_desc;
            this.kdW = pkModule.pk_1.pk_num.longValue();
            this.kdX = pkModule.pk_1.pk_index.intValue();
            this.kdY = pkModule.pk_2.pk_desc;
            this.kdZ = pkModule.pk_2.pk_num.longValue();
            this.kea = pkModule.pk_2.pk_index.intValue();
            if (pkModule.pk_1.has_clicked.intValue() == 1) {
                i = 1;
            } else {
                i = pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
            }
            this.kdg = i;
            this.keb = pkModule.pk_type.intValue();
            this.kec = pkModule.user_pk_index.intValue();
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.ked = this.kdg == 1 ? this.kdW - 1 : this.kdW;
            this.kee = this.kdg == 2 ? this.kdZ - 1 : this.kdZ;
        }
    }
}
