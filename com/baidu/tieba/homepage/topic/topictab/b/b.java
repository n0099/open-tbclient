package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes22.dex */
public class b {
    public int from;
    public a jZe;
    public a jZf;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jZe = new a();
            this.jZe.jZg = pkModule.agree.pk_num.longValue();
            this.jZe.jZh = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.jZe.jZi = pkModule.agree.last_username;
            this.jZe.jZj = pkModule.agree.pk_icon;
            this.jZe.jZk = pkModule.agree.has_clicked.longValue() == 1;
            this.jZe.jZl = pkModule.agree.pk_index.longValue();
            this.jZe.jZm = pkModule.agree.pk_icon_after;
            this.jZf = new a();
            this.jZf.jZg = pkModule.disagree.pk_num.longValue();
            this.jZf.jZh = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.jZf.jZi = pkModule.disagree.last_username;
            this.jZf.jZj = pkModule.disagree.pk_icon;
            this.jZf.jZk = pkModule.disagree.has_clicked.longValue() == 1;
            this.jZf.jZl = pkModule.disagree.pk_index.longValue();
            this.jZf.jZm = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jZe = new a();
            this.jZe.jZg = pkModule.agree.pk_num.longValue();
            this.jZe.jZh = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.jZe.jZi = pkModule.agree.last_username;
            this.jZe.jZj = pkModule.agree.pk_icon;
            this.jZe.jZk = pkModule.agree.has_clicked.longValue() == 1;
            this.jZe.jZl = pkModule.agree.pk_index.longValue();
            this.jZe.jZm = pkModule.agree.pk_icon_after;
            this.jZf = new a();
            this.jZf.jZg = pkModule.disagree.pk_num.longValue();
            this.jZf.jZh = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.jZf.jZi = pkModule.disagree.last_username;
            this.jZf.jZj = pkModule.disagree.pk_icon;
            this.jZf.jZk = pkModule.disagree.has_clicked.longValue() == 1;
            this.jZf.jZl = pkModule.disagree.pk_index.longValue();
            this.jZf.jZm = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jZe = new a();
            this.jZe.jZg = pkModule.agree.pk_num.longValue();
            this.jZe.jZh = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.jZe.jZi = pkModule.agree.last_username;
            this.jZe.jZj = pkModule.agree.pk_icon;
            this.jZe.jZk = pkModule.agree.has_clicked.longValue() == 1;
            this.jZe.jZl = pkModule.agree.pk_index.longValue();
            this.jZe.jZm = pkModule.agree.pk_icon_after;
            this.jZf = new a();
            this.jZf.jZg = pkModule.disagree.pk_num.longValue();
            this.jZf.jZh = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.jZf.jZi = pkModule.disagree.last_username;
            this.jZf.jZj = pkModule.disagree.pk_icon;
            this.jZf.jZk = pkModule.disagree.has_clicked.longValue() == 1;
            this.jZf.jZl = pkModule.disagree.pk_index.longValue();
            this.jZf.jZm = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes22.dex */
    public class a {
        public long jZg;
        public String jZh;
        public String jZi;
        public String jZj;
        public boolean jZk;
        public long jZl;
        public String jZm;

        public a() {
        }
    }
}
