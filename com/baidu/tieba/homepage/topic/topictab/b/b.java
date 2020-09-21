package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes21.dex */
public class b {
    public int from;
    public a jdt;
    public a jdu;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jdt = new a();
            this.jdt.jdv = pkModule.agree.pk_num.longValue();
            this.jdt.jdw = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.jdt.jdx = pkModule.agree.last_username;
            this.jdt.jdy = pkModule.agree.pk_icon;
            this.jdt.jdz = pkModule.agree.has_clicked.longValue() == 1;
            this.jdt.jdA = pkModule.agree.pk_index.longValue();
            this.jdt.jdB = pkModule.agree.pk_icon_after;
            this.jdu = new a();
            this.jdu.jdv = pkModule.disagree.pk_num.longValue();
            this.jdu.jdw = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.jdu.jdx = pkModule.disagree.last_username;
            this.jdu.jdy = pkModule.disagree.pk_icon;
            this.jdu.jdz = pkModule.disagree.has_clicked.longValue() == 1;
            this.jdu.jdA = pkModule.disagree.pk_index.longValue();
            this.jdu.jdB = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jdt = new a();
            this.jdt.jdv = pkModule.agree.pk_num.longValue();
            this.jdt.jdw = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.jdt.jdx = pkModule.agree.last_username;
            this.jdt.jdy = pkModule.agree.pk_icon;
            this.jdt.jdz = pkModule.agree.has_clicked.longValue() == 1;
            this.jdt.jdA = pkModule.agree.pk_index.longValue();
            this.jdt.jdB = pkModule.agree.pk_icon_after;
            this.jdu = new a();
            this.jdu.jdv = pkModule.disagree.pk_num.longValue();
            this.jdu.jdw = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.jdu.jdx = pkModule.disagree.last_username;
            this.jdu.jdy = pkModule.disagree.pk_icon;
            this.jdu.jdz = pkModule.disagree.has_clicked.longValue() == 1;
            this.jdu.jdA = pkModule.disagree.pk_index.longValue();
            this.jdu.jdB = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jdt = new a();
            this.jdt.jdv = pkModule.agree.pk_num.longValue();
            this.jdt.jdw = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.jdt.jdx = pkModule.agree.last_username;
            this.jdt.jdy = pkModule.agree.pk_icon;
            this.jdt.jdz = pkModule.agree.has_clicked.longValue() == 1;
            this.jdt.jdA = pkModule.agree.pk_index.longValue();
            this.jdt.jdB = pkModule.agree.pk_icon_after;
            this.jdu = new a();
            this.jdu.jdv = pkModule.disagree.pk_num.longValue();
            this.jdu.jdw = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.jdu.jdx = pkModule.disagree.last_username;
            this.jdu.jdy = pkModule.disagree.pk_icon;
            this.jdu.jdz = pkModule.disagree.has_clicked.longValue() == 1;
            this.jdu.jdA = pkModule.disagree.pk_index.longValue();
            this.jdu.jdB = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes21.dex */
    public class a {
        public long jdA;
        public String jdB;
        public long jdv;
        public String jdw;
        public String jdx;
        public String jdy;
        public boolean jdz;

        public a() {
        }
    }
}
