package com.baidu.tieba.homepage.concern.message;

import android.text.TextUtils;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.AdExtParam;
import d.a.j0.z0.c;
import d.a.j0.z0.w;
import d.a.k0.a1.b.d;
import d.a.k0.s2.i0.b;
import tbclient.Userlike.DataReq;
import tbclient.Userlike.UserlikeReqIdl;
/* loaded from: classes4.dex */
public class ConcernPageRequestMessage extends NetMessage {
    public c adInfo;
    public String pageTag;

    public ConcernPageRequestMessage() {
        super(CmdConfigHttp.CMD_CONCERN_PAGE, 309474);
    }

    private String buildAdParam() {
        boolean isEmpty = TextUtils.isEmpty(this.pageTag);
        int e2 = isEmpty ? 0 : b.f().e("CONCERN");
        String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
        String str = "";
        String d2 = isEmpty ? "" : b.f().d("CONCERN");
        c cVar = this.adInfo;
        if (cVar != null && !isEmpty) {
            str = cVar.f50908b;
        }
        AdExtParam.a b2 = AdExtParam.a.b();
        b2.g(e2);
        b2.d(cuidGalaxy2);
        b2.e(str);
        b2.c(d2);
        return b2.a();
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.page_tag = this.pageTag;
            if (d.J()) {
                if (!d.C()) {
                    builder.page_tag = d.x();
                } else {
                    builder.page_tag = d.w();
                }
            }
            builder.last_req_unix = Long.valueOf(d.a.j0.r.d0.b.j().l(d.a.j0.r.d0.b.n("concern_data_res_request_time"), 0L));
            int i2 = 1;
            builder.follow_type = Integer.valueOf(d.a.j0.b.d.h() ? d.a.j0.r.d0.b.j().k("key_home_concern_all_status", 0) : 1);
            if (z) {
                w.a(builder, true);
            }
            if (!TextUtils.isEmpty(this.pageTag)) {
                i2 = 2;
            }
            builder.load_type = Integer.valueOf(i2);
            builder.ad_ext_params = buildAdParam();
            UserlikeReqIdl.Builder builder2 = new UserlikeReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getPageTag() {
        return this.pageTag;
    }

    public void setAdInfo(c cVar) {
        this.adInfo = cVar;
    }

    public void setPageTag(String str) {
        this.pageTag = str;
    }
}
