package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes6.dex */
public class d extends h {
    private final com.baidu.adp.framework.listener.a deH;
    private final CustomMessageListener eau;
    private final CustomMessageListener eav;
    private final CustomMessageListener eaw;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.eau = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    d.this.e((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.eav = new CustomMessageListener(2921031) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.dZP.aAZ() != null) {
                        l aAZ = d.this.dZP.aAZ();
                        aAZ.ab(aAZ.vv(str));
                        d.this.dId.a(aAZ.getThreadList(), aAZ);
                        if (com.baidu.tieba.tbadkCore.c.bBd() != null) {
                            com.baidu.tieba.tbadkCore.c.bBd().ad(d.this.dZP.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.eaw = new CustomMessageListener(2921316) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.dZP != null && d.this.dId != null && d.this.dIo != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.dZP.aAZ() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.hnJ == 4) {
                        l aAZ = d.this.dZP.aAZ();
                        bb vv = aAZ.vv(str);
                        aAZ.ab(vv);
                        List<com.baidu.adp.widget.ListView.h> bCA = aAZ.bCA();
                        if (bCA == null) {
                            bCA = new ArrayList<>();
                        }
                        bCA.add(0, vv);
                        d.this.dId.a(aAZ.getThreadList(), aAZ);
                        d.this.dIo.i(aAZ);
                    }
                    if (TextUtils.equals(d.this.dZP.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.c.bBd().ad(d.this.dZP.getForumName(), false);
                    }
                }
            }
        };
        this.deH = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.frs.mc.d.4
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String errorString;
                String errorString2;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                        errorString2 = d.this.dZP.getResources().getString(e.j.neterror);
                    } else {
                        errorString2 = getMyPostHttpResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData());
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                        errorString = d.this.dZP.getResources().getString(e.j.neterror);
                    } else {
                        errorString = getMyPostSocketResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData());
                }
            }
        };
        this.deH.getSocketMessageListener().setSelfListener(true);
        this.deH.getHttpMessageListener().setSelfListener(true);
        this.eav.setSelfListener(false);
        this.dZP.registerListener(this.eav);
        this.dZP.registerListener(this.deH);
        this.dZP.registerListener(this.eau);
        this.dZP.registerListener(this.eaw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        ArrayList<com.baidu.adp.widget.ListView.h> a;
        if (i != 0) {
            this.dZP.showToast(str);
            return;
        }
        l aAZ = this.dZP.aAZ();
        if (aAZ != null && aAZ.bgi() != null && getMyPostResIdl != null && this.dId != null && this.dIn != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ai aiVar = new ai();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            builder.cheak_repeat = 1;
            builder.fname = aAZ.bgi().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.g.b.d(aAZ.bgi().getId(), 0L));
            aiVar.a(builder.build(true));
            aiVar.setCurrentPage(3);
            this.dIn.a(aiVar);
            if (this.dIn.aGw()) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                arrayList.add(aiVar);
                a = this.eaO.a(false, true, arrayList, null, true);
            } else {
                a = this.eaO.a(false, true, aAZ.getThreadList(), null, true);
            }
            if (a != null) {
                aAZ.ax(a);
                aAZ.bCk();
                this.dId.a(a, aAZ);
                this.dId.mh(0);
            }
        }
    }

    private void a(User.Builder builder, User_Info user_Info) {
        if (user_Info != null) {
            builder.id = user_Info.id;
            builder.gender = user_Info.gender;
            builder.type = user_Info.type;
            builder.name = user_Info.name;
            builder.name_show = user_Info.name_show;
            builder.portrait = TbadkCoreApplication.getCurrentPortrait();
            builder.god_data = user_Info.god_data;
            builder.fans_num = user_Info.fans_num;
            builder.fans_nickname = user_Info.fans_nickname;
            builder.is_bawu = user_Info.is_bawu;
            builder.bawu_type = user_Info.bawu_type;
        }
    }

    public void e(PostWriteCallBackData postWriteCallBackData) {
        if (this.dIn != null) {
            boolean z = this.dIn.aFM() != null && this.dIn.aFM().bCl();
            int aGs = this.dIn.aGs();
            if (aGs == 2 || aGs == 3 || aGs == 7 || aGs == 8 || z) {
                if ((y.aCr().mn(1) != null ? this.dIn.aGk() : 0) == 0 && postWriteCallBackData != null) {
                    final long d = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getPostId(), 0L);
                    final long d2 = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getThreadId(), 0L);
                    final long d3 = com.baidu.adp.lib.g.b.d(this.dZP.getForumId(), 0L);
                    if (d != 0 && d2 != 0 && d3 != 0) {
                        com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
                                int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (aq.DR().DT()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setParams(d2, d, d3, aO, aQ, f, i);
                                d.this.dZP.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
