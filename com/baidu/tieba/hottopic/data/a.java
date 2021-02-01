package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes8.dex */
public class a implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId ktR = BdUniqueId.gen();
    public String ktS;
    public String ktT;
    public int ktU;
    public String ktV;
    public String ktW;
    public int ktX;
    public long pkId;
    public long totalNum;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return ktR;
    }

    public void a(CommonInteraction commonInteraction) {
        if (commonInteraction != null) {
            this.ktS = commonInteraction.module_name;
            this.ktT = commonInteraction.ques_desc;
            this.totalNum = commonInteraction.total_num.longValue();
            this.ktU = commonInteraction.has_clicked.intValue();
            this.ktV = commonInteraction.before_click_pic;
            this.ktW = commonInteraction.after_click_pic;
            this.pkId = commonInteraction.pk_id.longValue();
            this.userPkId = commonInteraction.user_pk_id.longValue();
        }
    }
}
