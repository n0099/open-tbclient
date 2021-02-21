package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tbadk.util.v;
import tbclient.Personalized.DataReq;
import tbclient.Personalized.PersonalizedReqIdl;
/* loaded from: classes2.dex */
public class RecPersonalizeRequest extends NetMessage {
    public static final int LOAD_TYPE_LOAD_MORE = 2;
    public static final int LOAD_TYPE_UPDATE = 1;
    private String adFloorInfo;
    private int loadType;
    private int needForumlist;
    private int pn;
    private int preAdThreadCount;
    private int requestTime;
    private String sourceFrom;
    private int suggestCount;
    private int threadCount;

    public RecPersonalizeRequest() {
        super(1003070, CmdConfigSocket.CMD_RECOMMEND_PERSONALIZED);
        this.requestTime = 0;
        this.sourceFrom = "";
        this.adFloorInfo = "";
    }

    public void setLoadType(int i) {
        this.loadType = i;
    }

    public int getLoadType() {
        return this.loadType;
    }

    public void setThreadCount(int i) {
        if (i > 0) {
            this.threadCount = i;
        } else {
            this.threadCount = 0;
        }
    }

    public void setRequestTime(int i) {
        this.requestTime = i;
    }

    public void setPreAdThreadCount(int i) {
        this.preAdThreadCount = i;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public void setSuggestCount(int i) {
        this.suggestCount = i;
    }

    public void setNeedForumlist(int i) {
        if (i != 1) {
            this.needForumlist = 0;
        } else {
            this.needForumlist = i;
        }
    }

    public void setSourceFrom(String str) {
        this.sourceFrom = str;
    }

    public int getNeedForumlist() {
        return this.needForumlist;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        v.a(builder, true, false, true);
        builder.need_tags = 0;
        builder.load_type = Integer.valueOf(this.loadType);
        builder.page_thread_count = Integer.valueOf(this.threadCount);
        builder.pre_ad_thread_count = Integer.valueOf(this.preAdThreadCount);
        builder.pn = Integer.valueOf(this.pn);
        builder.sug_count = Integer.valueOf(this.suggestCount);
        builder.tag_code = 0;
        builder.scr_w = Integer.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst()));
        builder.scr_h = Integer.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst()));
        builder.scr_dip = Double.valueOf(l.getEquipmentDensity(TbadkCoreApplication.getInst()));
        builder.q_type = Integer.valueOf(av.bsS().bsT() ? 2 : 1);
        builder.need_forumlist = Integer.valueOf(this.needForumlist);
        builder.new_net_type = Integer.valueOf(com.baidu.adp.lib.util.j.netType());
        builder.new_install = Integer.valueOf(TbadkCoreApplication.getInst().checkNewUser() ? 1 : 0);
        builder.request_times = Integer.valueOf(this.requestTime);
        builder.invoke_source = this.sourceFrom;
        builder.ad_context_list = com.baidu.tieba.recapp.report.b.dEt().RR("NEWINDEX");
        builder.app_pos = com.baidu.tieba.recapp.c.a.dEm().dEr();
        if (TbSingleton.getInstance().getPbToHomeUpdateData() != null) {
            be pbToHomeUpdateData = TbSingleton.getInstance().getPbToHomeUpdateData();
            builder.from_tid = Long.valueOf(com.baidu.adp.lib.f.b.toLong(pbToHomeUpdateData.tid, 0L));
            builder.query_eqid = pbToHomeUpdateData.eOP;
            builder.first_dir = pbToHomeUpdateData.firstDir;
            builder.second_dir = pbToHomeUpdateData.secondDir;
            TbSingleton.getInstance().setPbToHomeUpdateData(null);
        }
        builder.ad_ext_params = AdExtParam.a.bEU().DH(this.adFloorInfo).bEV();
        PersonalizedReqIdl.Builder builder2 = new PersonalizedReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setAdFloorInfo(String str) {
        this.adFloorInfo = str;
    }
}
