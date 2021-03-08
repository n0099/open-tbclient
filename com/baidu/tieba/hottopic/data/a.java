package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes7.dex */
public class a implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId kwh = BdUniqueId.gen();
    public String kwi;
    public String kwj;
    public int kwk;
    public String kwl;
    public String kwm;
    public int kwn;
    public long pkId;
    public long totalNum;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return kwh;
    }

    public void a(CommonInteraction commonInteraction) {
        if (commonInteraction != null) {
            this.kwi = commonInteraction.module_name;
            this.kwj = commonInteraction.ques_desc;
            this.totalNum = commonInteraction.total_num.longValue();
            this.kwk = commonInteraction.has_clicked.intValue();
            this.kwl = commonInteraction.before_click_pic;
            this.kwm = commonInteraction.after_click_pic;
            this.pkId = commonInteraction.pk_id.longValue();
            this.userPkId = commonInteraction.user_pk_id.longValue();
        }
    }
}
