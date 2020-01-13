package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes7.dex */
public class b {
    public int from;
    public a hfy;
    public a hfz;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.hfy = new a();
            this.hfy.hfA = pkModule.agree.pk_num.longValue();
            this.hfy.hfB = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.hfy.hfC = pkModule.agree.last_username;
            this.hfy.hfD = pkModule.agree.pk_icon;
            this.hfy.hfE = pkModule.agree.has_clicked.longValue() == 1;
            this.hfy.hfF = pkModule.agree.pk_index.longValue();
            this.hfy.hfG = pkModule.agree.pk_icon_after;
            this.hfz = new a();
            this.hfz.hfA = pkModule.disagree.pk_num.longValue();
            this.hfz.hfB = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.hfz.hfC = pkModule.disagree.last_username;
            this.hfz.hfD = pkModule.disagree.pk_icon;
            this.hfz.hfE = pkModule.disagree.has_clicked.longValue() == 1;
            this.hfz.hfF = pkModule.disagree.pk_index.longValue();
            this.hfz.hfG = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.hfy = new a();
            this.hfy.hfA = pkModule.agree.pk_num.longValue();
            this.hfy.hfB = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.hfy.hfC = pkModule.agree.last_username;
            this.hfy.hfD = pkModule.agree.pk_icon;
            this.hfy.hfE = pkModule.agree.has_clicked.longValue() == 1;
            this.hfy.hfF = pkModule.agree.pk_index.longValue();
            this.hfy.hfG = pkModule.agree.pk_icon_after;
            this.hfz = new a();
            this.hfz.hfA = pkModule.disagree.pk_num.longValue();
            this.hfz.hfB = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.hfz.hfC = pkModule.disagree.last_username;
            this.hfz.hfD = pkModule.disagree.pk_icon;
            this.hfz.hfE = pkModule.disagree.has_clicked.longValue() == 1;
            this.hfz.hfF = pkModule.disagree.pk_index.longValue();
            this.hfz.hfG = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.hfy = new a();
            this.hfy.hfA = pkModule.agree.pk_num.longValue();
            this.hfy.hfB = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.hfy.hfC = pkModule.agree.last_username;
            this.hfy.hfD = pkModule.agree.pk_icon;
            this.hfy.hfE = pkModule.agree.has_clicked.longValue() == 1;
            this.hfy.hfF = pkModule.agree.pk_index.longValue();
            this.hfy.hfG = pkModule.agree.pk_icon_after;
            this.hfz = new a();
            this.hfz.hfA = pkModule.disagree.pk_num.longValue();
            this.hfz.hfB = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.hfz.hfC = pkModule.disagree.last_username;
            this.hfz.hfD = pkModule.disagree.pk_icon;
            this.hfz.hfE = pkModule.disagree.has_clicked.longValue() == 1;
            this.hfz.hfF = pkModule.disagree.pk_index.longValue();
            this.hfz.hfG = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes7.dex */
    public class a {
        public long hfA;
        public String hfB;
        public String hfC;
        public String hfD;
        public boolean hfE;
        public long hfF;
        public String hfG;

        public a() {
        }
    }
}
