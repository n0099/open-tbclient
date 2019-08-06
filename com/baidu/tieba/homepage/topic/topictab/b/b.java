package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes4.dex */
public class b {
    public int from;
    public a gnV;
    public a gnW;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.gnV = new a();
            this.gnV.gnX = pkModule.agree.pk_num.longValue();
            this.gnV.gnY = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.gnV.gnZ = pkModule.agree.last_username;
            this.gnV.goa = pkModule.agree.pk_icon;
            this.gnV.gob = pkModule.agree.has_clicked.longValue() == 1;
            this.gnV.goc = pkModule.agree.pk_index.longValue();
            this.gnV.god = pkModule.agree.pk_icon_after;
            this.gnW = new a();
            this.gnW.gnX = pkModule.disagree.pk_num.longValue();
            this.gnW.gnY = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.gnW.gnZ = pkModule.disagree.last_username;
            this.gnW.goa = pkModule.disagree.pk_icon;
            this.gnW.gob = pkModule.disagree.has_clicked.longValue() == 1;
            this.gnW.goc = pkModule.disagree.pk_index.longValue();
            this.gnW.god = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.gnV = new a();
            this.gnV.gnX = pkModule.agree.pk_num.longValue();
            this.gnV.gnY = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.gnV.gnZ = pkModule.agree.last_username;
            this.gnV.goa = pkModule.agree.pk_icon;
            this.gnV.gob = pkModule.agree.has_clicked.longValue() == 1;
            this.gnV.goc = pkModule.agree.pk_index.longValue();
            this.gnV.god = pkModule.agree.pk_icon_after;
            this.gnW = new a();
            this.gnW.gnX = pkModule.disagree.pk_num.longValue();
            this.gnW.gnY = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.gnW.gnZ = pkModule.disagree.last_username;
            this.gnW.goa = pkModule.disagree.pk_icon;
            this.gnW.gob = pkModule.disagree.has_clicked.longValue() == 1;
            this.gnW.goc = pkModule.disagree.pk_index.longValue();
            this.gnW.god = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.gnV = new a();
            this.gnV.gnX = pkModule.agree.pk_num.longValue();
            this.gnV.gnY = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.gnV.gnZ = pkModule.agree.last_username;
            this.gnV.goa = pkModule.agree.pk_icon;
            this.gnV.gob = pkModule.agree.has_clicked.longValue() == 1;
            this.gnV.goc = pkModule.agree.pk_index.longValue();
            this.gnV.god = pkModule.agree.pk_icon_after;
            this.gnW = new a();
            this.gnW.gnX = pkModule.disagree.pk_num.longValue();
            this.gnW.gnY = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.gnW.gnZ = pkModule.disagree.last_username;
            this.gnW.goa = pkModule.disagree.pk_icon;
            this.gnW.gob = pkModule.disagree.has_clicked.longValue() == 1;
            this.gnW.goc = pkModule.disagree.pk_index.longValue();
            this.gnW.god = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public long gnX;
        public String gnY;
        public String gnZ;
        public String goa;
        public boolean gob;
        public long goc;
        public String god;

        public a() {
        }
    }
}
