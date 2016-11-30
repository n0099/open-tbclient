package com.baidu.tieba.frs.e;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.HashMap;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class k extends s {
    private final CustomMessageListener cgC;
    private final com.baidu.adp.framework.listener.a cgD;

    public k(FrsActivity frsActivity) {
        super(frsActivity);
        this.cgC = new l(this, CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS);
        this.cgD = new m(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.cgD.ci().setSelfListener(true);
        this.cgD.ch().setSelfListener(true);
        this.bZY.registerListener(this.cgD);
        this.bZY.registerListener(this.cgC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            this.bZY.showToast(str);
            return;
        }
        com.baidu.tieba.tbadkCore.p acr = this.bZY.acr();
        if (acr != null && getMyPostResIdl != null && this.bRW != null && this.bSh != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            al alVar = new al();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(getMyPostResIdl.data.thread_info.author);
            a(metaData, getMyPostResIdl.data.user_info, getMyPostResIdl.data.thread_info.twzhibo_info);
            metaData.setPortrait(TbadkCoreApplication.getCurrentPortrait());
            String userId = metaData.getUserId();
            if (userId != null && !userId.equals("0")) {
                hashMap.put(metaData.getUserId(), metaData);
            }
            alVar.setUserMap(hashMap);
            alVar.a(getMyPostResIdl.data.thread_info);
            this.bSh.a(alVar);
            ArrayList<v> a = this.cgL.a(false, true, acr.getThreadList(), null);
            if (a != null) {
                acr.aD(a);
                acr.bkY();
                this.bRW.a(a, acr);
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
                    str = this.bZY.getPageContext().getResources().getString(r.j.fans_default_name);
                }
                metaData.setFansNickName(str);
            }
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        if (this.bSh != null) {
            if (this.bSh.agx() == 2 || this.bSh.agx() == 3 || this.bSh.agx() == 7) {
                int agq = this.bSh.agq();
                if (bx.adE().hY(1) == null) {
                    agq = 0;
                }
                if (agq == 0 && postWriteCallBackData != null) {
                    long c = com.baidu.adp.lib.h.b.c(postWriteCallBackData.getPostId(), 0L);
                    long c2 = com.baidu.adp.lib.h.b.c(postWriteCallBackData.getThreadId(), 0L);
                    long c3 = com.baidu.adp.lib.h.b.c(this.bZY.getForumId(), 0L);
                    if (c != 0 && c2 != 0 && c3 != 0) {
                        com.baidu.adp.lib.h.h.eG().postDelayed(new n(this, c2, c, c3), 1000L);
                    }
                }
            }
        }
    }
}
