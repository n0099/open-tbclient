package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes22.dex */
public class b {
    public int from;
    public a jES;
    public a jET;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jES = new a();
            this.jES.jEU = pkModule.agree.pk_num.longValue();
            this.jES.jEV = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.jES.jEW = pkModule.agree.last_username;
            this.jES.jEX = pkModule.agree.pk_icon;
            this.jES.jEY = pkModule.agree.has_clicked.longValue() == 1;
            this.jES.jEZ = pkModule.agree.pk_index.longValue();
            this.jES.jFa = pkModule.agree.pk_icon_after;
            this.jET = new a();
            this.jET.jEU = pkModule.disagree.pk_num.longValue();
            this.jET.jEV = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.jET.jEW = pkModule.disagree.last_username;
            this.jET.jEX = pkModule.disagree.pk_icon;
            this.jET.jEY = pkModule.disagree.has_clicked.longValue() == 1;
            this.jET.jEZ = pkModule.disagree.pk_index.longValue();
            this.jET.jFa = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jES = new a();
            this.jES.jEU = pkModule.agree.pk_num.longValue();
            this.jES.jEV = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.jES.jEW = pkModule.agree.last_username;
            this.jES.jEX = pkModule.agree.pk_icon;
            this.jES.jEY = pkModule.agree.has_clicked.longValue() == 1;
            this.jES.jEZ = pkModule.agree.pk_index.longValue();
            this.jES.jFa = pkModule.agree.pk_icon_after;
            this.jET = new a();
            this.jET.jEU = pkModule.disagree.pk_num.longValue();
            this.jET.jEV = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.jET.jEW = pkModule.disagree.last_username;
            this.jET.jEX = pkModule.disagree.pk_icon;
            this.jET.jEY = pkModule.disagree.has_clicked.longValue() == 1;
            this.jET.jEZ = pkModule.disagree.pk_index.longValue();
            this.jET.jFa = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jES = new a();
            this.jES.jEU = pkModule.agree.pk_num.longValue();
            this.jES.jEV = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.jES.jEW = pkModule.agree.last_username;
            this.jES.jEX = pkModule.agree.pk_icon;
            this.jES.jEY = pkModule.agree.has_clicked.longValue() == 1;
            this.jES.jEZ = pkModule.agree.pk_index.longValue();
            this.jES.jFa = pkModule.agree.pk_icon_after;
            this.jET = new a();
            this.jET.jEU = pkModule.disagree.pk_num.longValue();
            this.jET.jEV = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.jET.jEW = pkModule.disagree.last_username;
            this.jET.jEX = pkModule.disagree.pk_icon;
            this.jET.jEY = pkModule.disagree.has_clicked.longValue() == 1;
            this.jET.jEZ = pkModule.disagree.pk_index.longValue();
            this.jET.jFa = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes22.dex */
    public class a {
        public long jEU;
        public String jEV;
        public String jEW;
        public String jEX;
        public boolean jEY;
        public long jEZ;
        public String jFa;

        public a() {
        }
    }
}
