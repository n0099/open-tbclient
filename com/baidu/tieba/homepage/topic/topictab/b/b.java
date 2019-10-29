package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes4.dex */
public class b {
    public int from;
    public a gpl;
    public a gpm;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.gpl = new a();
            this.gpl.gpn = pkModule.agree.pk_num.longValue();
            this.gpl.gpo = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.gpl.gpp = pkModule.agree.last_username;
            this.gpl.gpq = pkModule.agree.pk_icon;
            this.gpl.gpr = pkModule.agree.has_clicked.longValue() == 1;
            this.gpl.gps = pkModule.agree.pk_index.longValue();
            this.gpl.gpt = pkModule.agree.pk_icon_after;
            this.gpm = new a();
            this.gpm.gpn = pkModule.disagree.pk_num.longValue();
            this.gpm.gpo = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.gpm.gpp = pkModule.disagree.last_username;
            this.gpm.gpq = pkModule.disagree.pk_icon;
            this.gpm.gpr = pkModule.disagree.has_clicked.longValue() == 1;
            this.gpm.gps = pkModule.disagree.pk_index.longValue();
            this.gpm.gpt = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.gpl = new a();
            this.gpl.gpn = pkModule.agree.pk_num.longValue();
            this.gpl.gpo = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.gpl.gpp = pkModule.agree.last_username;
            this.gpl.gpq = pkModule.agree.pk_icon;
            this.gpl.gpr = pkModule.agree.has_clicked.longValue() == 1;
            this.gpl.gps = pkModule.agree.pk_index.longValue();
            this.gpl.gpt = pkModule.agree.pk_icon_after;
            this.gpm = new a();
            this.gpm.gpn = pkModule.disagree.pk_num.longValue();
            this.gpm.gpo = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.gpm.gpp = pkModule.disagree.last_username;
            this.gpm.gpq = pkModule.disagree.pk_icon;
            this.gpm.gpr = pkModule.disagree.has_clicked.longValue() == 1;
            this.gpm.gps = pkModule.disagree.pk_index.longValue();
            this.gpm.gpt = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.gpl = new a();
            this.gpl.gpn = pkModule.agree.pk_num.longValue();
            this.gpl.gpo = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.gpl.gpp = pkModule.agree.last_username;
            this.gpl.gpq = pkModule.agree.pk_icon;
            this.gpl.gpr = pkModule.agree.has_clicked.longValue() == 1;
            this.gpl.gps = pkModule.agree.pk_index.longValue();
            this.gpl.gpt = pkModule.agree.pk_icon_after;
            this.gpm = new a();
            this.gpm.gpn = pkModule.disagree.pk_num.longValue();
            this.gpm.gpo = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.gpm.gpp = pkModule.disagree.last_username;
            this.gpm.gpq = pkModule.disagree.pk_icon;
            this.gpm.gpr = pkModule.disagree.has_clicked.longValue() == 1;
            this.gpm.gps = pkModule.disagree.pk_index.longValue();
            this.gpm.gpt = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public long gpn;
        public String gpo;
        public String gpp;
        public String gpq;
        public boolean gpr;
        public long gps;
        public String gpt;

        public a() {
        }
    }
}
