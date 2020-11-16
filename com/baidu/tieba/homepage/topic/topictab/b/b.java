package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes21.dex */
public class b {
    public int from;
    public a jLB;
    public a jLC;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jLB = new a();
            this.jLB.jLD = pkModule.agree.pk_num.longValue();
            this.jLB.jLE = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.jLB.jLF = pkModule.agree.last_username;
            this.jLB.jLG = pkModule.agree.pk_icon;
            this.jLB.jLH = pkModule.agree.has_clicked.longValue() == 1;
            this.jLB.jLI = pkModule.agree.pk_index.longValue();
            this.jLB.jLJ = pkModule.agree.pk_icon_after;
            this.jLC = new a();
            this.jLC.jLD = pkModule.disagree.pk_num.longValue();
            this.jLC.jLE = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.jLC.jLF = pkModule.disagree.last_username;
            this.jLC.jLG = pkModule.disagree.pk_icon;
            this.jLC.jLH = pkModule.disagree.has_clicked.longValue() == 1;
            this.jLC.jLI = pkModule.disagree.pk_index.longValue();
            this.jLC.jLJ = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jLB = new a();
            this.jLB.jLD = pkModule.agree.pk_num.longValue();
            this.jLB.jLE = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.jLB.jLF = pkModule.agree.last_username;
            this.jLB.jLG = pkModule.agree.pk_icon;
            this.jLB.jLH = pkModule.agree.has_clicked.longValue() == 1;
            this.jLB.jLI = pkModule.agree.pk_index.longValue();
            this.jLB.jLJ = pkModule.agree.pk_icon_after;
            this.jLC = new a();
            this.jLC.jLD = pkModule.disagree.pk_num.longValue();
            this.jLC.jLE = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.jLC.jLF = pkModule.disagree.last_username;
            this.jLC.jLG = pkModule.disagree.pk_icon;
            this.jLC.jLH = pkModule.disagree.has_clicked.longValue() == 1;
            this.jLC.jLI = pkModule.disagree.pk_index.longValue();
            this.jLC.jLJ = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jLB = new a();
            this.jLB.jLD = pkModule.agree.pk_num.longValue();
            this.jLB.jLE = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.jLB.jLF = pkModule.agree.last_username;
            this.jLB.jLG = pkModule.agree.pk_icon;
            this.jLB.jLH = pkModule.agree.has_clicked.longValue() == 1;
            this.jLB.jLI = pkModule.agree.pk_index.longValue();
            this.jLB.jLJ = pkModule.agree.pk_icon_after;
            this.jLC = new a();
            this.jLC.jLD = pkModule.disagree.pk_num.longValue();
            this.jLC.jLE = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.jLC.jLF = pkModule.disagree.last_username;
            this.jLC.jLG = pkModule.disagree.pk_icon;
            this.jLC.jLH = pkModule.disagree.has_clicked.longValue() == 1;
            this.jLC.jLI = pkModule.disagree.pk_index.longValue();
            this.jLC.jLJ = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes21.dex */
    public class a {
        public long jLD;
        public String jLE;
        public String jLF;
        public String jLG;
        public boolean jLH;
        public long jLI;
        public String jLJ;

        public a() {
        }
    }
}
