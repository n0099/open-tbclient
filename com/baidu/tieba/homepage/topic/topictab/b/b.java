package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes2.dex */
public class b {
    public int from;
    public a ksj;
    public a ksk;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.ksj = new a();
            this.ksj.ksl = pkModule.agree.pk_num.longValue();
            this.ksj.ksm = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.ksj.ksn = pkModule.agree.last_username;
            this.ksj.kso = pkModule.agree.pk_icon;
            this.ksj.ksp = pkModule.agree.has_clicked.longValue() == 1;
            this.ksj.ksq = pkModule.agree.pk_index.longValue();
            this.ksj.ksr = pkModule.agree.pk_icon_after;
            this.ksk = new a();
            this.ksk.ksl = pkModule.disagree.pk_num.longValue();
            this.ksk.ksm = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.ksk.ksn = pkModule.disagree.last_username;
            this.ksk.kso = pkModule.disagree.pk_icon;
            this.ksk.ksp = pkModule.disagree.has_clicked.longValue() == 1;
            this.ksk.ksq = pkModule.disagree.pk_index.longValue();
            this.ksk.ksr = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.ksj = new a();
            this.ksj.ksl = pkModule.agree.pk_num.longValue();
            this.ksj.ksm = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.ksj.ksn = pkModule.agree.last_username;
            this.ksj.kso = pkModule.agree.pk_icon;
            this.ksj.ksp = pkModule.agree.has_clicked.longValue() == 1;
            this.ksj.ksq = pkModule.agree.pk_index.longValue();
            this.ksj.ksr = pkModule.agree.pk_icon_after;
            this.ksk = new a();
            this.ksk.ksl = pkModule.disagree.pk_num.longValue();
            this.ksk.ksm = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.ksk.ksn = pkModule.disagree.last_username;
            this.ksk.kso = pkModule.disagree.pk_icon;
            this.ksk.ksp = pkModule.disagree.has_clicked.longValue() == 1;
            this.ksk.ksq = pkModule.disagree.pk_index.longValue();
            this.ksk.ksr = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.ksj = new a();
            this.ksj.ksl = pkModule.agree.pk_num.longValue();
            this.ksj.ksm = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.ksj.ksn = pkModule.agree.last_username;
            this.ksj.kso = pkModule.agree.pk_icon;
            this.ksj.ksp = pkModule.agree.has_clicked.longValue() == 1;
            this.ksj.ksq = pkModule.agree.pk_index.longValue();
            this.ksj.ksr = pkModule.agree.pk_icon_after;
            this.ksk = new a();
            this.ksk.ksl = pkModule.disagree.pk_num.longValue();
            this.ksk.ksm = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.ksk.ksn = pkModule.disagree.last_username;
            this.ksk.kso = pkModule.disagree.pk_icon;
            this.ksk.ksp = pkModule.disagree.has_clicked.longValue() == 1;
            this.ksk.ksq = pkModule.disagree.pk_index.longValue();
            this.ksk.ksr = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public long ksl;
        public String ksm;
        public String ksn;
        public String kso;
        public boolean ksp;
        public long ksq;
        public String ksr;

        public a() {
        }
    }
}
