package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes8.dex */
public class a implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId kuf = BdUniqueId.gen();
    public String kug;
    public String kuh;
    public int kui;
    public String kuj;
    public String kuk;
    public int kul;
    public long pkId;
    public long totalNum;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return kuf;
    }

    public void a(CommonInteraction commonInteraction) {
        if (commonInteraction != null) {
            this.kug = commonInteraction.module_name;
            this.kuh = commonInteraction.ques_desc;
            this.totalNum = commonInteraction.total_num.longValue();
            this.kui = commonInteraction.has_clicked.intValue();
            this.kuj = commonInteraction.before_click_pic;
            this.kuk = commonInteraction.after_click_pic;
            this.pkId = commonInteraction.pk_id.longValue();
            this.userPkId = commonInteraction.user_pk_id.longValue();
        }
    }
}
