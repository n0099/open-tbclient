package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes16.dex */
public class b {
    public int from;
    public a iUH;
    public a iUI;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.iUH = new a();
            this.iUH.iUJ = pkModule.agree.pk_num.longValue();
            this.iUH.iUK = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.iUH.iUL = pkModule.agree.last_username;
            this.iUH.iUM = pkModule.agree.pk_icon;
            this.iUH.iUN = pkModule.agree.has_clicked.longValue() == 1;
            this.iUH.iUO = pkModule.agree.pk_index.longValue();
            this.iUH.iUP = pkModule.agree.pk_icon_after;
            this.iUI = new a();
            this.iUI.iUJ = pkModule.disagree.pk_num.longValue();
            this.iUI.iUK = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.iUI.iUL = pkModule.disagree.last_username;
            this.iUI.iUM = pkModule.disagree.pk_icon;
            this.iUI.iUN = pkModule.disagree.has_clicked.longValue() == 1;
            this.iUI.iUO = pkModule.disagree.pk_index.longValue();
            this.iUI.iUP = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.iUH = new a();
            this.iUH.iUJ = pkModule.agree.pk_num.longValue();
            this.iUH.iUK = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.iUH.iUL = pkModule.agree.last_username;
            this.iUH.iUM = pkModule.agree.pk_icon;
            this.iUH.iUN = pkModule.agree.has_clicked.longValue() == 1;
            this.iUH.iUO = pkModule.agree.pk_index.longValue();
            this.iUH.iUP = pkModule.agree.pk_icon_after;
            this.iUI = new a();
            this.iUI.iUJ = pkModule.disagree.pk_num.longValue();
            this.iUI.iUK = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.iUI.iUL = pkModule.disagree.last_username;
            this.iUI.iUM = pkModule.disagree.pk_icon;
            this.iUI.iUN = pkModule.disagree.has_clicked.longValue() == 1;
            this.iUI.iUO = pkModule.disagree.pk_index.longValue();
            this.iUI.iUP = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.iUH = new a();
            this.iUH.iUJ = pkModule.agree.pk_num.longValue();
            this.iUH.iUK = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.iUH.iUL = pkModule.agree.last_username;
            this.iUH.iUM = pkModule.agree.pk_icon;
            this.iUH.iUN = pkModule.agree.has_clicked.longValue() == 1;
            this.iUH.iUO = pkModule.agree.pk_index.longValue();
            this.iUH.iUP = pkModule.agree.pk_icon_after;
            this.iUI = new a();
            this.iUI.iUJ = pkModule.disagree.pk_num.longValue();
            this.iUI.iUK = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.iUI.iUL = pkModule.disagree.last_username;
            this.iUI.iUM = pkModule.disagree.pk_icon;
            this.iUI.iUN = pkModule.disagree.has_clicked.longValue() == 1;
            this.iUI.iUO = pkModule.disagree.pk_index.longValue();
            this.iUI.iUP = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes16.dex */
    public class a {
        public long iUJ;
        public String iUK;
        public String iUL;
        public String iUM;
        public boolean iUN;
        public long iUO;
        public String iUP;

        public a() {
        }
    }
}
