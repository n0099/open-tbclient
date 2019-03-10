package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes4.dex */
public class b {
    public a fPS;
    public a fPT;
    public int from;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.fPS = new a();
            this.fPS.fPU = pkModule.agree.pk_num.longValue();
            this.fPS.fPV = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(d.j.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.fPS.fPW = pkModule.agree.last_username;
            this.fPS.fPX = pkModule.agree.pk_icon;
            this.fPS.fPY = pkModule.agree.has_clicked.longValue() == 1;
            this.fPS.fPZ = pkModule.agree.pk_index.longValue();
            this.fPS.fQa = pkModule.agree.pk_icon_after;
            this.fPT = new a();
            this.fPT.fPU = pkModule.disagree.pk_num.longValue();
            this.fPT.fPV = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(d.j.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.fPT.fPW = pkModule.disagree.last_username;
            this.fPT.fPX = pkModule.disagree.pk_icon;
            this.fPT.fPY = pkModule.disagree.has_clicked.longValue() == 1;
            this.fPT.fPZ = pkModule.disagree.pk_index.longValue();
            this.fPT.fQa = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.fPS = new a();
            this.fPS.fPU = pkModule.agree.pk_num.longValue();
            this.fPS.fPV = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(d.j.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.fPS.fPW = pkModule.agree.last_username;
            this.fPS.fPX = pkModule.agree.pk_icon;
            this.fPS.fPY = pkModule.agree.has_clicked.longValue() == 1;
            this.fPS.fPZ = pkModule.agree.pk_index.longValue();
            this.fPS.fQa = pkModule.agree.pk_icon_after;
            this.fPT = new a();
            this.fPT.fPU = pkModule.disagree.pk_num.longValue();
            this.fPT.fPV = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(d.j.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.fPT.fPW = pkModule.disagree.last_username;
            this.fPT.fPX = pkModule.disagree.pk_icon;
            this.fPT.fPY = pkModule.disagree.has_clicked.longValue() == 1;
            this.fPT.fPZ = pkModule.disagree.pk_index.longValue();
            this.fPT.fQa = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public long fPU;
        public String fPV;
        public String fPW;
        public String fPX;
        public boolean fPY;
        public long fPZ;
        public String fQa;

        public a() {
        }
    }
}
