package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes4.dex */
public class b {
    public int from;
    public a gnd;
    public a gne;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.gnd = new a();
            this.gnd.gnf = pkModule.agree.pk_num.longValue();
            this.gnd.gng = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.gnd.gnh = pkModule.agree.last_username;
            this.gnd.gni = pkModule.agree.pk_icon;
            this.gnd.gnj = pkModule.agree.has_clicked.longValue() == 1;
            this.gnd.gnk = pkModule.agree.pk_index.longValue();
            this.gnd.gnl = pkModule.agree.pk_icon_after;
            this.gne = new a();
            this.gne.gnf = pkModule.disagree.pk_num.longValue();
            this.gne.gng = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.gne.gnh = pkModule.disagree.last_username;
            this.gne.gni = pkModule.disagree.pk_icon;
            this.gne.gnj = pkModule.disagree.has_clicked.longValue() == 1;
            this.gne.gnk = pkModule.disagree.pk_index.longValue();
            this.gne.gnl = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.gnd = new a();
            this.gnd.gnf = pkModule.agree.pk_num.longValue();
            this.gnd.gng = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.gnd.gnh = pkModule.agree.last_username;
            this.gnd.gni = pkModule.agree.pk_icon;
            this.gnd.gnj = pkModule.agree.has_clicked.longValue() == 1;
            this.gnd.gnk = pkModule.agree.pk_index.longValue();
            this.gnd.gnl = pkModule.agree.pk_icon_after;
            this.gne = new a();
            this.gne.gnf = pkModule.disagree.pk_num.longValue();
            this.gne.gng = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.gne.gnh = pkModule.disagree.last_username;
            this.gne.gni = pkModule.disagree.pk_icon;
            this.gne.gnj = pkModule.disagree.has_clicked.longValue() == 1;
            this.gne.gnk = pkModule.disagree.pk_index.longValue();
            this.gne.gnl = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.gnd = new a();
            this.gnd.gnf = pkModule.agree.pk_num.longValue();
            this.gnd.gng = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.gnd.gnh = pkModule.agree.last_username;
            this.gnd.gni = pkModule.agree.pk_icon;
            this.gnd.gnj = pkModule.agree.has_clicked.longValue() == 1;
            this.gnd.gnk = pkModule.agree.pk_index.longValue();
            this.gnd.gnl = pkModule.agree.pk_icon_after;
            this.gne = new a();
            this.gne.gnf = pkModule.disagree.pk_num.longValue();
            this.gne.gng = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.gne.gnh = pkModule.disagree.last_username;
            this.gne.gni = pkModule.disagree.pk_icon;
            this.gne.gnj = pkModule.disagree.has_clicked.longValue() == 1;
            this.gne.gnk = pkModule.disagree.pk_index.longValue();
            this.gne.gnl = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public long gnf;
        public String gng;
        public String gnh;
        public String gni;
        public boolean gnj;
        public long gnk;
        public String gnl;

        public a() {
        }
    }
}
