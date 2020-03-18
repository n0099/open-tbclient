package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes9.dex */
public class b {
    public int from;
    public a hjn;
    public a hjo;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.hjn = new a();
            this.hjn.hjp = pkModule.agree.pk_num.longValue();
            this.hjn.hjq = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.hjn.hjr = pkModule.agree.last_username;
            this.hjn.hjs = pkModule.agree.pk_icon;
            this.hjn.hjt = pkModule.agree.has_clicked.longValue() == 1;
            this.hjn.hju = pkModule.agree.pk_index.longValue();
            this.hjn.hjv = pkModule.agree.pk_icon_after;
            this.hjo = new a();
            this.hjo.hjp = pkModule.disagree.pk_num.longValue();
            this.hjo.hjq = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.hjo.hjr = pkModule.disagree.last_username;
            this.hjo.hjs = pkModule.disagree.pk_icon;
            this.hjo.hjt = pkModule.disagree.has_clicked.longValue() == 1;
            this.hjo.hju = pkModule.disagree.pk_index.longValue();
            this.hjo.hjv = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.hjn = new a();
            this.hjn.hjp = pkModule.agree.pk_num.longValue();
            this.hjn.hjq = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.hjn.hjr = pkModule.agree.last_username;
            this.hjn.hjs = pkModule.agree.pk_icon;
            this.hjn.hjt = pkModule.agree.has_clicked.longValue() == 1;
            this.hjn.hju = pkModule.agree.pk_index.longValue();
            this.hjn.hjv = pkModule.agree.pk_icon_after;
            this.hjo = new a();
            this.hjo.hjp = pkModule.disagree.pk_num.longValue();
            this.hjo.hjq = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.hjo.hjr = pkModule.disagree.last_username;
            this.hjo.hjs = pkModule.disagree.pk_icon;
            this.hjo.hjt = pkModule.disagree.has_clicked.longValue() == 1;
            this.hjo.hju = pkModule.disagree.pk_index.longValue();
            this.hjo.hjv = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.hjn = new a();
            this.hjn.hjp = pkModule.agree.pk_num.longValue();
            this.hjn.hjq = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.hjn.hjr = pkModule.agree.last_username;
            this.hjn.hjs = pkModule.agree.pk_icon;
            this.hjn.hjt = pkModule.agree.has_clicked.longValue() == 1;
            this.hjn.hju = pkModule.agree.pk_index.longValue();
            this.hjn.hjv = pkModule.agree.pk_icon_after;
            this.hjo = new a();
            this.hjo.hjp = pkModule.disagree.pk_num.longValue();
            this.hjo.hjq = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.hjo.hjr = pkModule.disagree.last_username;
            this.hjo.hjs = pkModule.disagree.pk_icon;
            this.hjo.hjt = pkModule.disagree.has_clicked.longValue() == 1;
            this.hjo.hju = pkModule.disagree.pk_index.longValue();
            this.hjo.hjv = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes9.dex */
    public class a {
        public long hjp;
        public String hjq;
        public String hjr;
        public String hjs;
        public boolean hjt;
        public long hju;
        public String hjv;

        public a() {
        }
    }
}
