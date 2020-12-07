package com.baidu.tieba.homepage.concern.message;

import android.text.TextUtils;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.homepage.concern.d;
import tbclient.Userlike.DataReq;
import tbclient.Userlike.UserlikeReqIdl;
/* loaded from: classes22.dex */
public class ConcernPageRequestMessage extends NetMessage {
    private String pageTag;

    public ConcernPageRequestMessage() {
        super(1003343, CmdConfigSocket.CMD_CONCERN_PAGE);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.page_tag = this.pageTag;
            if (d.cNJ()) {
                if (!d.cNN()) {
                    builder.page_tag = d.cNL();
                } else {
                    builder.page_tag = d.cNK();
                }
            }
            builder.last_req_unix = Long.valueOf(b.bsO().getLong(b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), 0L));
            builder.follow_type = Integer.valueOf(com.baidu.tbadk.a.d.bkz() ? b.bsO().getInt("key_home_concern_all_status", 0) : 1);
            if (z) {
                u.a(builder, true);
            }
            builder.load_type = Integer.valueOf(TextUtils.isEmpty(this.pageTag) ? 1 : 2);
            builder.ad_ext_params = buildAdParam();
            UserlikeReqIdl.Builder builder2 = new UserlikeReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }

    private String buildAdParam() {
        int So = com.baidu.tieba.recapp.report.b.dGe().So("tag_home_concern_tab");
        String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
        return AdExtParam.a.bFX().sS(So).EE(cuidGalaxy2).EF(com.baidu.tieba.recapp.report.b.dGe().Sm("tag_home_concern_tab")).bFY();
    }

    public String getPageTag() {
        return this.pageTag;
    }

    public void setPageTag(String str) {
        this.pageTag = str;
    }
}
