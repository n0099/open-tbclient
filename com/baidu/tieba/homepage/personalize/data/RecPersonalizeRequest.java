package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.util.AdExtParam;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import d.b.h0.r.q.e1;
import d.b.h0.z0.w;
import d.b.i0.r2.a0.a;
import d.b.i0.r2.b0.b;
import tbclient.Personalized.DataReq;
import tbclient.Personalized.PersonalizedReqIdl;
/* loaded from: classes4.dex */
public class RecPersonalizeRequest extends NetMessage {
    public static final int LOAD_TYPE_LOAD_MORE = 2;
    public static final int LOAD_TYPE_UPDATE = 1;
    public String adFloorInfo;
    public int loadType;
    public int needForumlist;
    public int pn;
    public int preAdThreadCount;
    public int requestTime;
    public String sourceFrom;
    public int suggestCount;
    public int threadCount;

    public RecPersonalizeRequest() {
        super(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
        this.requestTime = 0;
        this.sourceFrom = "";
        this.adFloorInfo = "";
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        w.c(builder, true, false, true);
        builder.need_tags = 0;
        builder.load_type = Integer.valueOf(this.loadType);
        builder.page_thread_count = Integer.valueOf(this.threadCount);
        builder.pre_ad_thread_count = Integer.valueOf(this.preAdThreadCount);
        builder.pn = Integer.valueOf(this.pn);
        builder.sug_count = Integer.valueOf(this.suggestCount);
        builder.tag_code = 0;
        builder.scr_w = Integer.valueOf(l.k(TbadkCoreApplication.getInst()));
        builder.scr_h = Integer.valueOf(l.i(TbadkCoreApplication.getInst()));
        builder.scr_dip = Double.valueOf(l.h(TbadkCoreApplication.getInst()));
        builder.q_type = Integer.valueOf(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1);
        builder.need_forumlist = Integer.valueOf(this.needForumlist);
        builder.new_net_type = Integer.valueOf(j.I());
        builder.new_install = Integer.valueOf(TbadkCoreApplication.getInst().checkNewUser() ? 1 : 0);
        builder.request_times = Integer.valueOf(this.requestTime);
        builder.invoke_source = this.sourceFrom;
        builder.ad_context_list = b.f().d("NEWINDEX");
        builder.app_pos = a.e().c();
        if (TbSingleton.getInstance().getPbToHomeUpdateData() != null) {
            e1 pbToHomeUpdateData = TbSingleton.getInstance().getPbToHomeUpdateData();
            builder.from_tid = Long.valueOf(d.b.b.e.m.b.f(pbToHomeUpdateData.f50770a, 0L));
            builder.query_eqid = pbToHomeUpdateData.f50771b;
            builder.first_dir = pbToHomeUpdateData.f50772c;
            builder.second_dir = pbToHomeUpdateData.f50773d;
            TbSingleton.getInstance().setPbToHomeUpdateData(null);
        }
        AdExtParam.a b2 = AdExtParam.a.b();
        b2.e(this.adFloorInfo);
        builder.ad_ext_params = b2.a();
        PersonalizedReqIdl.Builder builder2 = new PersonalizedReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getLoadType() {
        return this.loadType;
    }

    public int getNeedForumlist() {
        return this.needForumlist;
    }

    public void setAdFloorInfo(String str) {
        this.adFloorInfo = str;
    }

    public void setLoadType(int i) {
        this.loadType = i;
    }

    public void setNeedForumlist(int i) {
        if (i != 1) {
            this.needForumlist = 0;
        } else {
            this.needForumlist = i;
        }
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public void setPreAdThreadCount(int i) {
        this.preAdThreadCount = i;
    }

    public void setRequestTime(int i) {
        this.requestTime = i;
    }

    public void setSourceFrom(String str) {
        this.sourceFrom = str;
    }

    public void setSuggestCount(int i) {
        this.suggestCount = i;
    }

    public void setThreadCount(int i) {
        if (i > 0) {
            this.threadCount = i;
        } else {
            this.threadCount = 0;
        }
    }
}
