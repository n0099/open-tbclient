package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes9.dex */
public class b {
    public int from;
    public a hSW;
    public a hSX;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.hSW = new a();
            this.hSW.hSY = pkModule.agree.pk_num.longValue();
            this.hSW.hSZ = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.hSW.hTa = pkModule.agree.last_username;
            this.hSW.hTb = pkModule.agree.pk_icon;
            this.hSW.hTc = pkModule.agree.has_clicked.longValue() == 1;
            this.hSW.hTd = pkModule.agree.pk_index.longValue();
            this.hSW.hTe = pkModule.agree.pk_icon_after;
            this.hSX = new a();
            this.hSX.hSY = pkModule.disagree.pk_num.longValue();
            this.hSX.hSZ = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.hSX.hTa = pkModule.disagree.last_username;
            this.hSX.hTb = pkModule.disagree.pk_icon;
            this.hSX.hTc = pkModule.disagree.has_clicked.longValue() == 1;
            this.hSX.hTd = pkModule.disagree.pk_index.longValue();
            this.hSX.hTe = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.hSW = new a();
            this.hSW.hSY = pkModule.agree.pk_num.longValue();
            this.hSW.hSZ = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.hSW.hTa = pkModule.agree.last_username;
            this.hSW.hTb = pkModule.agree.pk_icon;
            this.hSW.hTc = pkModule.agree.has_clicked.longValue() == 1;
            this.hSW.hTd = pkModule.agree.pk_index.longValue();
            this.hSW.hTe = pkModule.agree.pk_icon_after;
            this.hSX = new a();
            this.hSX.hSY = pkModule.disagree.pk_num.longValue();
            this.hSX.hSZ = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.hSX.hTa = pkModule.disagree.last_username;
            this.hSX.hTb = pkModule.disagree.pk_icon;
            this.hSX.hTc = pkModule.disagree.has_clicked.longValue() == 1;
            this.hSX.hTd = pkModule.disagree.pk_index.longValue();
            this.hSX.hTe = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.hSW = new a();
            this.hSW.hSY = pkModule.agree.pk_num.longValue();
            this.hSW.hSZ = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.hSW.hTa = pkModule.agree.last_username;
            this.hSW.hTb = pkModule.agree.pk_icon;
            this.hSW.hTc = pkModule.agree.has_clicked.longValue() == 1;
            this.hSW.hTd = pkModule.agree.pk_index.longValue();
            this.hSW.hTe = pkModule.agree.pk_icon_after;
            this.hSX = new a();
            this.hSX.hSY = pkModule.disagree.pk_num.longValue();
            this.hSX.hSZ = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.hSX.hTa = pkModule.disagree.last_username;
            this.hSX.hTb = pkModule.disagree.pk_icon;
            this.hSX.hTc = pkModule.disagree.has_clicked.longValue() == 1;
            this.hSX.hTd = pkModule.disagree.pk_index.longValue();
            this.hSX.hTe = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes9.dex */
    public class a {
        public long hSY;
        public String hSZ;
        public String hTa;
        public String hTb;
        public boolean hTc;
        public long hTd;
        public String hTe;

        public a() {
        }
    }
}
