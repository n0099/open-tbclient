package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes22.dex */
public class b {
    public int from;
    public a jZg;
    public a jZh;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jZg = new a();
            this.jZg.jZi = pkModule.agree.pk_num.longValue();
            this.jZg.jZj = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.jZg.jZk = pkModule.agree.last_username;
            this.jZg.jZl = pkModule.agree.pk_icon;
            this.jZg.jZm = pkModule.agree.has_clicked.longValue() == 1;
            this.jZg.jZn = pkModule.agree.pk_index.longValue();
            this.jZg.jZo = pkModule.agree.pk_icon_after;
            this.jZh = new a();
            this.jZh.jZi = pkModule.disagree.pk_num.longValue();
            this.jZh.jZj = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.jZh.jZk = pkModule.disagree.last_username;
            this.jZh.jZl = pkModule.disagree.pk_icon;
            this.jZh.jZm = pkModule.disagree.has_clicked.longValue() == 1;
            this.jZh.jZn = pkModule.disagree.pk_index.longValue();
            this.jZh.jZo = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jZg = new a();
            this.jZg.jZi = pkModule.agree.pk_num.longValue();
            this.jZg.jZj = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.jZg.jZk = pkModule.agree.last_username;
            this.jZg.jZl = pkModule.agree.pk_icon;
            this.jZg.jZm = pkModule.agree.has_clicked.longValue() == 1;
            this.jZg.jZn = pkModule.agree.pk_index.longValue();
            this.jZg.jZo = pkModule.agree.pk_icon_after;
            this.jZh = new a();
            this.jZh.jZi = pkModule.disagree.pk_num.longValue();
            this.jZh.jZj = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.jZh.jZk = pkModule.disagree.last_username;
            this.jZh.jZl = pkModule.disagree.pk_icon;
            this.jZh.jZm = pkModule.disagree.has_clicked.longValue() == 1;
            this.jZh.jZn = pkModule.disagree.pk_index.longValue();
            this.jZh.jZo = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jZg = new a();
            this.jZg.jZi = pkModule.agree.pk_num.longValue();
            this.jZg.jZj = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.jZg.jZk = pkModule.agree.last_username;
            this.jZg.jZl = pkModule.agree.pk_icon;
            this.jZg.jZm = pkModule.agree.has_clicked.longValue() == 1;
            this.jZg.jZn = pkModule.agree.pk_index.longValue();
            this.jZg.jZo = pkModule.agree.pk_icon_after;
            this.jZh = new a();
            this.jZh.jZi = pkModule.disagree.pk_num.longValue();
            this.jZh.jZj = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.jZh.jZk = pkModule.disagree.last_username;
            this.jZh.jZl = pkModule.disagree.pk_icon;
            this.jZh.jZm = pkModule.disagree.has_clicked.longValue() == 1;
            this.jZh.jZn = pkModule.disagree.pk_index.longValue();
            this.jZh.jZo = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes22.dex */
    public class a {
        public long jZi;
        public String jZj;
        public String jZk;
        public String jZl;
        public boolean jZm;
        public long jZn;
        public String jZo;

        public a() {
        }
    }
}
