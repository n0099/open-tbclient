package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes4.dex */
public class b {
    public a fPR;
    public a fPS;
    public int from;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.fPR = new a();
            this.fPR.fPT = pkModule.agree.pk_num.longValue();
            this.fPR.fPU = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(d.j.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.fPR.fPV = pkModule.agree.last_username;
            this.fPR.fPW = pkModule.agree.pk_icon;
            this.fPR.fPX = pkModule.agree.has_clicked.longValue() == 1;
            this.fPR.fPY = pkModule.agree.pk_index.longValue();
            this.fPR.fPZ = pkModule.agree.pk_icon_after;
            this.fPS = new a();
            this.fPS.fPT = pkModule.disagree.pk_num.longValue();
            this.fPS.fPU = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(d.j.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.fPS.fPV = pkModule.disagree.last_username;
            this.fPS.fPW = pkModule.disagree.pk_icon;
            this.fPS.fPX = pkModule.disagree.has_clicked.longValue() == 1;
            this.fPS.fPY = pkModule.disagree.pk_index.longValue();
            this.fPS.fPZ = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.fPR = new a();
            this.fPR.fPT = pkModule.agree.pk_num.longValue();
            this.fPR.fPU = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(d.j.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.fPR.fPV = pkModule.agree.last_username;
            this.fPR.fPW = pkModule.agree.pk_icon;
            this.fPR.fPX = pkModule.agree.has_clicked.longValue() == 1;
            this.fPR.fPY = pkModule.agree.pk_index.longValue();
            this.fPR.fPZ = pkModule.agree.pk_icon_after;
            this.fPS = new a();
            this.fPS.fPT = pkModule.disagree.pk_num.longValue();
            this.fPS.fPU = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(d.j.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.fPS.fPV = pkModule.disagree.last_username;
            this.fPS.fPW = pkModule.disagree.pk_icon;
            this.fPS.fPX = pkModule.disagree.has_clicked.longValue() == 1;
            this.fPS.fPY = pkModule.disagree.pk_index.longValue();
            this.fPS.fPZ = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public long fPT;
        public String fPU;
        public String fPV;
        public String fPW;
        public boolean fPX;
        public long fPY;
        public String fPZ;

        public a() {
        }
    }
}
