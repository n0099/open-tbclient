package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes16.dex */
public class b {
    public int from;
    public a iUN;
    public a iUO;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.iUN = new a();
            this.iUN.iUP = pkModule.agree.pk_num.longValue();
            this.iUN.iUQ = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.iUN.iUR = pkModule.agree.last_username;
            this.iUN.iUS = pkModule.agree.pk_icon;
            this.iUN.iUT = pkModule.agree.has_clicked.longValue() == 1;
            this.iUN.iUU = pkModule.agree.pk_index.longValue();
            this.iUN.iUV = pkModule.agree.pk_icon_after;
            this.iUO = new a();
            this.iUO.iUP = pkModule.disagree.pk_num.longValue();
            this.iUO.iUQ = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.iUO.iUR = pkModule.disagree.last_username;
            this.iUO.iUS = pkModule.disagree.pk_icon;
            this.iUO.iUT = pkModule.disagree.has_clicked.longValue() == 1;
            this.iUO.iUU = pkModule.disagree.pk_index.longValue();
            this.iUO.iUV = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.iUN = new a();
            this.iUN.iUP = pkModule.agree.pk_num.longValue();
            this.iUN.iUQ = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.iUN.iUR = pkModule.agree.last_username;
            this.iUN.iUS = pkModule.agree.pk_icon;
            this.iUN.iUT = pkModule.agree.has_clicked.longValue() == 1;
            this.iUN.iUU = pkModule.agree.pk_index.longValue();
            this.iUN.iUV = pkModule.agree.pk_icon_after;
            this.iUO = new a();
            this.iUO.iUP = pkModule.disagree.pk_num.longValue();
            this.iUO.iUQ = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.iUO.iUR = pkModule.disagree.last_username;
            this.iUO.iUS = pkModule.disagree.pk_icon;
            this.iUO.iUT = pkModule.disagree.has_clicked.longValue() == 1;
            this.iUO.iUU = pkModule.disagree.pk_index.longValue();
            this.iUO.iUV = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.iUN = new a();
            this.iUN.iUP = pkModule.agree.pk_num.longValue();
            this.iUN.iUQ = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.iUN.iUR = pkModule.agree.last_username;
            this.iUN.iUS = pkModule.agree.pk_icon;
            this.iUN.iUT = pkModule.agree.has_clicked.longValue() == 1;
            this.iUN.iUU = pkModule.agree.pk_index.longValue();
            this.iUN.iUV = pkModule.agree.pk_icon_after;
            this.iUO = new a();
            this.iUO.iUP = pkModule.disagree.pk_num.longValue();
            this.iUO.iUQ = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.iUO.iUR = pkModule.disagree.last_username;
            this.iUO.iUS = pkModule.disagree.pk_icon;
            this.iUO.iUT = pkModule.disagree.has_clicked.longValue() == 1;
            this.iUO.iUU = pkModule.disagree.pk_index.longValue();
            this.iUO.iUV = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes16.dex */
    public class a {
        public long iUP;
        public String iUQ;
        public String iUR;
        public String iUS;
        public boolean iUT;
        public long iUU;
        public String iUV;

        public a() {
        }
    }
}
