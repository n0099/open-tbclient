package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.HashMap;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class l extends w {
    private final CustomMessageListener bYi;
    private final com.baidu.adp.framework.listener.a bYj;

    public l(FrsActivity frsActivity) {
        super(frsActivity);
        this.bYi = new m(this, CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS);
        this.bYj = new n(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.bYj.getSocketMessageListener().setSelfListener(true);
        this.bYj.getHttpMessageListener().setSelfListener(true);
        this.bST.registerListener(this.bYj);
        this.bST.registerListener(this.bYi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            this.bST.showToast(str);
            return;
        }
        com.baidu.tieba.tbadkCore.n Zr = this.bST.Zr();
        if (Zr != null && getMyPostResIdl != null && this.bMD != null && this.bMO != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            am amVar = new am();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(getMyPostResIdl.data.thread_info.author);
            a(metaData, getMyPostResIdl.data.user_info, getMyPostResIdl.data.thread_info.twzhibo_info);
            metaData.setPortrait(TbadkCoreApplication.getCurrentPortrait());
            String userId = metaData.getUserId();
            if (userId != null && !userId.equals("0")) {
                hashMap.put(metaData.getUserId(), metaData);
            }
            amVar.setUserMap(hashMap);
            amVar.a(getMyPostResIdl.data.thread_info);
            amVar.bX(3);
            this.bMO.a(amVar);
            ArrayList<com.baidu.adp.widget.ListView.v> a = this.bYv.a(false, true, Zr.getThreadList(), null);
            if (a != null) {
                Zr.ax(a);
                Zr.bhd();
                this.bMD.a(a, Zr);
                this.bMD.hS(0);
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
                    str = this.bST.getPageContext().getResources().getString(w.l.fans_default_name);
                }
                metaData.setFansNickName(str);
            }
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        if (this.bMO != null) {
            if (this.bMO.acR() == 2 || this.bMO.acR() == 3 || this.bMO.acR() == 7) {
                int acJ = this.bMO.acJ();
                if (bw.aaB().hU(1) == null) {
                    acJ = 0;
                }
                if (acJ == 0 && postWriteCallBackData != null) {
                    long c = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
                    long c2 = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
                    long c3 = com.baidu.adp.lib.g.b.c(this.bST.getForumId(), 0L);
                    if (c != 0 && c2 != 0 && c3 != 0) {
                        com.baidu.adp.lib.g.h.fR().postDelayed(new o(this, c2, c, c3), 1000L);
                    }
                }
            }
        }
    }
}
