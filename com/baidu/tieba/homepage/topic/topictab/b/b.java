package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes2.dex */
public class b {
    public int from;
    public a kqh;
    public a kqi;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.kqh = new a();
            this.kqh.kqj = pkModule.agree.pk_num.longValue();
            this.kqh.kqk = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.kqh.kql = pkModule.agree.last_username;
            this.kqh.kqm = pkModule.agree.pk_icon;
            this.kqh.kqn = pkModule.agree.has_clicked.longValue() == 1;
            this.kqh.kqo = pkModule.agree.pk_index.longValue();
            this.kqh.kqp = pkModule.agree.pk_icon_after;
            this.kqi = new a();
            this.kqi.kqj = pkModule.disagree.pk_num.longValue();
            this.kqi.kqk = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.kqi.kql = pkModule.disagree.last_username;
            this.kqi.kqm = pkModule.disagree.pk_icon;
            this.kqi.kqn = pkModule.disagree.has_clicked.longValue() == 1;
            this.kqi.kqo = pkModule.disagree.pk_index.longValue();
            this.kqi.kqp = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.kqh = new a();
            this.kqh.kqj = pkModule.agree.pk_num.longValue();
            this.kqh.kqk = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.kqh.kql = pkModule.agree.last_username;
            this.kqh.kqm = pkModule.agree.pk_icon;
            this.kqh.kqn = pkModule.agree.has_clicked.longValue() == 1;
            this.kqh.kqo = pkModule.agree.pk_index.longValue();
            this.kqh.kqp = pkModule.agree.pk_icon_after;
            this.kqi = new a();
            this.kqi.kqj = pkModule.disagree.pk_num.longValue();
            this.kqi.kqk = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.kqi.kql = pkModule.disagree.last_username;
            this.kqi.kqm = pkModule.disagree.pk_icon;
            this.kqi.kqn = pkModule.disagree.has_clicked.longValue() == 1;
            this.kqi.kqo = pkModule.disagree.pk_index.longValue();
            this.kqi.kqp = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.kqh = new a();
            this.kqh.kqj = pkModule.agree.pk_num.longValue();
            this.kqh.kqk = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.kqh.kql = pkModule.agree.last_username;
            this.kqh.kqm = pkModule.agree.pk_icon;
            this.kqh.kqn = pkModule.agree.has_clicked.longValue() == 1;
            this.kqh.kqo = pkModule.agree.pk_index.longValue();
            this.kqh.kqp = pkModule.agree.pk_icon_after;
            this.kqi = new a();
            this.kqi.kqj = pkModule.disagree.pk_num.longValue();
            this.kqi.kqk = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.kqi.kql = pkModule.disagree.last_username;
            this.kqi.kqm = pkModule.disagree.pk_icon;
            this.kqi.kqn = pkModule.disagree.has_clicked.longValue() == 1;
            this.kqi.kqo = pkModule.disagree.pk_index.longValue();
            this.kqi.kqp = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public long kqj;
        public String kqk;
        public String kql;
        public String kqm;
        public boolean kqn;
        public long kqo;
        public String kqp;

        public a() {
        }
    }
}
