package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes4.dex */
public class b {
    public int from;
    public a gou;
    public a gov;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.gou = new a();
            this.gou.gow = pkModule.agree.pk_num.longValue();
            this.gou.gox = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.gou.goy = pkModule.agree.last_username;
            this.gou.goz = pkModule.agree.pk_icon;
            this.gou.goA = pkModule.agree.has_clicked.longValue() == 1;
            this.gou.goB = pkModule.agree.pk_index.longValue();
            this.gou.goC = pkModule.agree.pk_icon_after;
            this.gov = new a();
            this.gov.gow = pkModule.disagree.pk_num.longValue();
            this.gov.gox = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.gov.goy = pkModule.disagree.last_username;
            this.gov.goz = pkModule.disagree.pk_icon;
            this.gov.goA = pkModule.disagree.has_clicked.longValue() == 1;
            this.gov.goB = pkModule.disagree.pk_index.longValue();
            this.gov.goC = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.gou = new a();
            this.gou.gow = pkModule.agree.pk_num.longValue();
            this.gou.gox = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.gou.goy = pkModule.agree.last_username;
            this.gou.goz = pkModule.agree.pk_icon;
            this.gou.goA = pkModule.agree.has_clicked.longValue() == 1;
            this.gou.goB = pkModule.agree.pk_index.longValue();
            this.gou.goC = pkModule.agree.pk_icon_after;
            this.gov = new a();
            this.gov.gow = pkModule.disagree.pk_num.longValue();
            this.gov.gox = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.gov.goy = pkModule.disagree.last_username;
            this.gov.goz = pkModule.disagree.pk_icon;
            this.gov.goA = pkModule.disagree.has_clicked.longValue() == 1;
            this.gov.goB = pkModule.disagree.pk_index.longValue();
            this.gov.goC = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.gou = new a();
            this.gou.gow = pkModule.agree.pk_num.longValue();
            this.gou.gox = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.gou.goy = pkModule.agree.last_username;
            this.gou.goz = pkModule.agree.pk_icon;
            this.gou.goA = pkModule.agree.has_clicked.longValue() == 1;
            this.gou.goB = pkModule.agree.pk_index.longValue();
            this.gou.goC = pkModule.agree.pk_icon_after;
            this.gov = new a();
            this.gov.gow = pkModule.disagree.pk_num.longValue();
            this.gov.gox = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.gov.goy = pkModule.disagree.last_username;
            this.gov.goz = pkModule.disagree.pk_icon;
            this.gov.goA = pkModule.disagree.has_clicked.longValue() == 1;
            this.gov.goB = pkModule.disagree.pk_index.longValue();
            this.gov.goC = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public boolean goA;
        public long goB;
        public String goC;
        public long gow;
        public String gox;
        public String goy;
        public String goz;

        public a() {
        }
    }
}
