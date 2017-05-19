package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.bp;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.HashMap;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class l extends w {
    private final CustomMessageListener bYr;
    private final com.baidu.adp.framework.listener.a bYs;

    public l(com.baidu.tieba.frs.r rVar) {
        super(rVar);
        this.bYr = new m(this, CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS);
        this.bYs = new n(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.bYs.getSocketMessageListener().setSelfListener(true);
        this.bYs.getHttpMessageListener().setSelfListener(true);
        this.bNK.registerListener(this.bYs);
        this.bNK.registerListener(this.bYr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            this.bNK.showToast(str);
            return;
        }
        com.baidu.tieba.tbadkCore.n Zq = this.bNK.Zq();
        if (Zq != null && getMyPostResIdl != null && this.bOn != null && this.bOw != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            an anVar = new an();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(getMyPostResIdl.data.thread_info.author);
            a(metaData, getMyPostResIdl.data.user_info, getMyPostResIdl.data.thread_info.twzhibo_info);
            metaData.setPortrait(TbadkCoreApplication.getCurrentPortrait());
            String userId = metaData.getUserId();
            if (userId != null && !userId.equals("0")) {
                hashMap.put(metaData.getUserId(), metaData);
            }
            anVar.setUserMap(hashMap);
            anVar.a(getMyPostResIdl.data.thread_info);
            anVar.bV(3);
            this.bOw.a(anVar);
            ArrayList<com.baidu.adp.widget.ListView.v> a = this.bYE.a(false, true, Zq.getThreadList(), null);
            if (a != null) {
                Zq.ay(a);
                Zq.bfE();
                this.bOn.a(a, Zq);
                this.bOn.hO(0);
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0008: IGET  (r1v0 java.lang.Long A[REMOVE]) = (r4v0 tbclient.GetMyPost.User_Info) tbclient.GetMyPost.User_Info.id java.lang.Long)] */
    private void a(MetaData metaData, User_Info user_Info, ZhiBoInfoTW zhiBoInfoTW) {
        if (user_Info != null) {
            metaData.setUserId(new StringBuilder().append(user_Info.id).toString());
            metaData.setGender(user_Info.gender.intValue());
            metaData.setType(user_Info.type.intValue());
            metaData.setUserName(user_Info.name);
            metaData.setName_show(user_Info.name_show);
            metaData.setPortrait(user_Info.portrait);
            metaData.setGodInfo(user_Info.god_data);
            metaData.getGodUserData().parserProtobuf(user_Info.god_data);
            metaData.setFansNum(user_Info.fans_num.intValue());
            if (zhiBoInfoTW != null && zhiBoInfoTW.user != null) {
                String str = zhiBoInfoTW.user.fans_nickname;
                if (StringUtils.isNull(str)) {
                    str = this.bNK.getPageContext().getResources().getString(w.l.fans_default_name);
                }
                metaData.setFansNickName(str);
            }
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        if (this.bOw != null) {
            if (this.bOw.abW() == 2 || this.bOw.abW() == 3 || this.bOw.abW() == 7) {
                int abO = this.bOw.abO();
                if (bp.aab().hQ(1) == null) {
                    abO = 0;
                }
                if (abO == 0 && postWriteCallBackData != null) {
                    long c = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
                    long c2 = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
                    long c3 = com.baidu.adp.lib.g.b.c(this.bNK.getForumId(), 0L);
                    if (c != 0 && c2 != 0 && c3 != 0) {
                        com.baidu.adp.lib.g.h.fS().postDelayed(new o(this, c2, c, c3), 1000L);
                    }
                }
            }
        }
    }
}
