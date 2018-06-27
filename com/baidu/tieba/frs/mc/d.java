package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.d;
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
/* loaded from: classes2.dex */
public class d extends h {
    private final com.baidu.adp.framework.listener.a cGd;
    private final CustomMessageListener dBp;
    private final CustomMessageListener dBq;
    private final CustomMessageListener dBr;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.dBp = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    d.this.e((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.dBq = new CustomMessageListener(2921031) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.dAK.atZ() != null) {
                        l atZ = d.this.dAK.atZ();
                        atZ.Y(atZ.mD(str));
                        d.this.djA.a(atZ.getThreadList(), atZ);
                        if (com.baidu.tieba.tbadkCore.c.bvo() != null) {
                            com.baidu.tieba.tbadkCore.c.bvo().U(d.this.dAK.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.dBr = new CustomMessageListener(2921316) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.dAK != null && d.this.djA != null && d.this.djM != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.dAK.atZ() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.gPu == 4) {
                        l atZ = d.this.dAK.atZ();
                        bc mD = atZ.mD(str);
                        atZ.Y(mD);
                        List<com.baidu.adp.widget.ListView.h> bwJ = atZ.bwJ();
                        if (bwJ == null) {
                            bwJ = new ArrayList<>();
                        }
                        bwJ.add(0, mD);
                        d.this.djA.a(atZ.getThreadList(), atZ);
                        d.this.djM.h(atZ);
                    }
                    if (TextUtils.equals(d.this.dAK.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.c.bvo().U(d.this.dAK.getForumName(), false);
                    }
                }
            }
        };
        this.cGd = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.frs.mc.d.4
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String errorString;
                String errorString2;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                        errorString2 = d.this.dAK.getResources().getString(d.k.neterror);
                    } else {
                        errorString2 = getMyPostHttpResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData());
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                        errorString = d.this.dAK.getResources().getString(d.k.neterror);
                    } else {
                        errorString = getMyPostSocketResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData());
                }
            }
        };
        this.cGd.getSocketMessageListener().setSelfListener(true);
        this.cGd.getHttpMessageListener().setSelfListener(true);
        this.dBq.setSelfListener(false);
        this.dAK.registerListener(this.dBq);
        this.dAK.registerListener(this.cGd);
        this.dAK.registerListener(this.dBp);
        this.dAK.registerListener(this.dBr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        ArrayList<com.baidu.adp.widget.ListView.h> a;
        if (i != 0) {
            this.dAK.showToast(str);
            return;
        }
        l atZ = this.dAK.atZ();
        if (atZ != null && atZ.baT() != null && getMyPostResIdl != null && this.djA != null && this.djL != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            aj ajVar = new aj();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            builder.cheak_repeat = 1;
            builder.fname = atZ.baT().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.g.b.c(atZ.baT().getId(), 0L));
            ajVar.a(builder.build(true));
            ajVar.bY(3);
            this.djL.a(ajVar);
            if (this.djL.azj()) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                arrayList.add(ajVar);
                a = this.dBJ.a(false, true, arrayList, null, true);
            } else {
                a = this.dBJ.a(false, true, atZ.getThreadList(), null, true);
            }
            if (a != null) {
                atZ.az(a);
                atZ.bwu();
                this.djA.a(a, atZ);
                this.djA.ks(0);
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
        if (this.djL != null) {
            if (this.djL.azf() == 2 || this.djL.azf() == 3 || this.djL.azf() == 7) {
                int ayX = this.djL.ayX();
                if (y.avd().ku(1) == null) {
                    ayX = 0;
                }
                if (ayX == 0 && postWriteCallBackData != null) {
                    final long c = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
                    final long c2 = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
                    final long c3 = com.baidu.adp.lib.g.b.c(this.dAK.getForumId(), 0L);
                    if (c != 0 && c2 != 0 && c3 != 0) {
                        com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
                                int aj = com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (ar.zF().zH()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setParams(c2, c, c3, ah, aj, f, i);
                                d.this.dAK.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
