package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes8.dex */
public class a implements q {
    public static final BdUniqueId iDD = BdUniqueId.gen();
    public String iDE;
    public String iDF;
    public int iDG;
    public String iDH;
    public String iDI;
    public int iDJ;
    public long pkId;
    public long totalNum;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iDD;
    }

    public void a(CommonInteraction commonInteraction) {
        if (commonInteraction != null) {
            this.iDE = commonInteraction.module_name;
            this.iDF = commonInteraction.ques_desc;
            this.totalNum = commonInteraction.total_num.longValue();
            this.iDG = commonInteraction.has_clicked.intValue();
            this.iDH = commonInteraction.before_click_pic;
            this.iDI = commonInteraction.after_click_pic;
            this.pkId = commonInteraction.pk_id.longValue();
            this.userPkId = commonInteraction.user_pk_id.longValue();
        }
    }
}
