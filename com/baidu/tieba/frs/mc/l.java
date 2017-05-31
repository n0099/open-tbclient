package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.bq;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.HashMap;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class l extends w {
    private final CustomMessageListener ceD;
    private final com.baidu.adp.framework.listener.a ceE;

    public l(com.baidu.tieba.frs.r rVar) {
        super(rVar);
        this.ceD = new m(this, CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS);
        this.ceE = new n(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.ceE.getSocketMessageListener().setSelfListener(true);
        this.ceE.getHttpMessageListener().setSelfListener(true);
        this.bTw.registerListener(this.ceE);
        this.bTw.registerListener(this.ceD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            this.bTw.showToast(str);
            return;
        }
        com.baidu.tieba.tbadkCore.n aau = this.bTw.aau();
        if (aau != null && getMyPostResIdl != null && this.bUa != null && this.bUj != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ao aoVar = new ao();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(getMyPostResIdl.data.thread_info.author);
            a(metaData, getMyPostResIdl.data.user_info, getMyPostResIdl.data.thread_info.twzhibo_info);
            metaData.setPortrait(TbadkCoreApplication.getCurrentPortrait());
            String userId = metaData.getUserId();
            if (userId != null && !userId.equals("0")) {
                hashMap.put(metaData.getUserId(), metaData);
            }
            aoVar.setUserMap(hashMap);
            aoVar.a(getMyPostResIdl.data.thread_info);
            aoVar.bW(3);
            this.bUj.a(aoVar);
            ArrayList<com.baidu.adp.widget.ListView.v> a = this.ceQ.a(false, true, aau.getThreadList(), null);
            if (a != null) {
                aau.ay(a);
                aau.bha();
                this.bUa.a(a, aau);
                this.bUa.im(0);
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
                    str = this.bTw.getPageContext().getResources().getString(w.l.fans_default_name);
                }
                metaData.setFansNickName(str);
            }
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        if (this.bUj != null) {
            if (this.bUj.ada() == 2 || this.bUj.ada() == 3 || this.bUj.ada() == 7) {
                int acS = this.bUj.acS();
                if (bq.abd().io(1) == null) {
                    acS = 0;
                }
                if (acS == 0 && postWriteCallBackData != null) {
                    long c = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
                    long c2 = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
                    long c3 = com.baidu.adp.lib.g.b.c(this.bTw.getForumId(), 0L);
                    if (c != 0 && c2 != 0 && c3 != 0) {
                        com.baidu.adp.lib.g.h.fS().postDelayed(new o(this, c2, c, c3), 1000L);
                    }
                }
            }
        }
    }
}
