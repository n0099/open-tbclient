package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes22.dex */
public class b {
    public int from;
    public a jss;
    public a jst;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jss = new a();
            this.jss.jsu = pkModule.agree.pk_num.longValue();
            this.jss.jsv = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.jss.jsw = pkModule.agree.last_username;
            this.jss.jsx = pkModule.agree.pk_icon;
            this.jss.jsy = pkModule.agree.has_clicked.longValue() == 1;
            this.jss.jsz = pkModule.agree.pk_index.longValue();
            this.jss.jsA = pkModule.agree.pk_icon_after;
            this.jst = new a();
            this.jst.jsu = pkModule.disagree.pk_num.longValue();
            this.jst.jsv = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.jst.jsw = pkModule.disagree.last_username;
            this.jst.jsx = pkModule.disagree.pk_icon;
            this.jst.jsy = pkModule.disagree.has_clicked.longValue() == 1;
            this.jst.jsz = pkModule.disagree.pk_index.longValue();
            this.jst.jsA = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jss = new a();
            this.jss.jsu = pkModule.agree.pk_num.longValue();
            this.jss.jsv = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.jss.jsw = pkModule.agree.last_username;
            this.jss.jsx = pkModule.agree.pk_icon;
            this.jss.jsy = pkModule.agree.has_clicked.longValue() == 1;
            this.jss.jsz = pkModule.agree.pk_index.longValue();
            this.jss.jsA = pkModule.agree.pk_icon_after;
            this.jst = new a();
            this.jst.jsu = pkModule.disagree.pk_num.longValue();
            this.jst.jsv = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.jst.jsw = pkModule.disagree.last_username;
            this.jst.jsx = pkModule.disagree.pk_icon;
            this.jst.jsy = pkModule.disagree.has_clicked.longValue() == 1;
            this.jst.jsz = pkModule.disagree.pk_index.longValue();
            this.jst.jsA = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jss = new a();
            this.jss.jsu = pkModule.agree.pk_num.longValue();
            this.jss.jsv = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.jss.jsw = pkModule.agree.last_username;
            this.jss.jsx = pkModule.agree.pk_icon;
            this.jss.jsy = pkModule.agree.has_clicked.longValue() == 1;
            this.jss.jsz = pkModule.agree.pk_index.longValue();
            this.jss.jsA = pkModule.agree.pk_icon_after;
            this.jst = new a();
            this.jst.jsu = pkModule.disagree.pk_num.longValue();
            this.jst.jsv = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.jst.jsw = pkModule.disagree.last_username;
            this.jst.jsx = pkModule.disagree.pk_icon;
            this.jst.jsy = pkModule.disagree.has_clicked.longValue() == 1;
            this.jst.jsz = pkModule.disagree.pk_index.longValue();
            this.jst.jsA = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes22.dex */
    public class a {
        public String jsA;
        public long jsu;
        public String jsv;
        public String jsw;
        public String jsx;
        public boolean jsy;
        public long jsz;

        public a() {
        }
    }
}
