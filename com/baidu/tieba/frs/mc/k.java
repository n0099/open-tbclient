package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bu;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.HashMap;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class k extends u {
    private final CustomMessageListener bZI;
    private final com.baidu.adp.framework.listener.a bZJ;

    public k(FrsActivity frsActivity) {
        super(frsActivity);
        this.bZI = new l(this, CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS);
        this.bZJ = new m(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.bZJ.getSocketMessageListener().setSelfListener(true);
        this.bZJ.getHttpMessageListener().setSelfListener(true);
        this.bTf.registerListener(this.bZJ);
        this.bTf.registerListener(this.bZI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            this.bTf.showToast(str);
            return;
        }
        com.baidu.tieba.tbadkCore.n YV = this.bTf.YV();
        if (YV != null && getMyPostResIdl != null && this.bMN != null && this.bMY != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
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
            anVar.bU(3);
            this.bMY.a(anVar);
            ArrayList<com.baidu.adp.widget.ListView.v> a = this.bZU.a(false, true, YV.getThreadList(), null);
            if (a != null) {
                YV.ax(a);
                YV.bgq();
                this.bMN.a(a, YV);
                this.bMN.hP(0);
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
                    str = this.bTf.getPageContext().getResources().getString(w.l.fans_default_name);
                }
                metaData.setFansNickName(str);
            }
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        if (this.bMY != null) {
            if (this.bMY.acX() == 2 || this.bMY.acX() == 3 || this.bMY.acX() == 7) {
                int acP = this.bMY.acP();
                if (bu.aad().hR(1) == null) {
                    acP = 0;
                }
                if (acP == 0 && postWriteCallBackData != null) {
                    long c = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
                    long c2 = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
                    long c3 = com.baidu.adp.lib.g.b.c(this.bTf.getForumId(), 0L);
                    if (c != 0 && c2 != 0 && c3 != 0) {
                        com.baidu.adp.lib.g.h.fM().postDelayed(new n(this, c2, c, c3), 1000L);
                    }
                }
            }
        }
    }
}
