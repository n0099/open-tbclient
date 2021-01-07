package com.baidu.tieba.frs.broadcast;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.view.ScreenTopToast;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    private TbPageContext context;
    private String forumId;
    private String forumName;
    private HttpMessageListener jhe = new HttpMessageListener(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS) { // from class: com.baidu.tieba.frs.broadcast.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof ForumManagerRightsResMsg) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                boolean z = b.bvr().getBoolean("key_forum_broadcast_no_tip_again", false);
                int i = forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount;
                if (!z) {
                    a.this.showDialog(i);
                } else if (a.this.type == 1) {
                    a.this.context.showToast(R.string.top_success);
                } else if (a.this.type == 2) {
                    a.this.context.showToast(R.string.set_good_success);
                }
            }
        }
    };
    private String threadId;
    private int type;

    public a(TbPageContext tbPageContext) {
        this.context = tbPageContext;
        registerTask();
        tbPageContext.registerListener(this.jhe);
    }

    public void e(int i, String str, String str2, String str3) {
        this.type = i;
        this.forumId = str;
        this.forumName = str2;
        this.threadId = str3;
        KO(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(final int i) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.context.getPageActivity());
        aVar.jK(true);
        aVar.pc(R.color.CAM_X0105);
        if (this.type == 1) {
            aVar.oZ(R.string.top_success);
        } else if (this.type == 2) {
            aVar.oZ(R.string.set_good_success);
        }
        aVar.Bo(String.format(this.context.getString(R.string.forum_broadcast_intro), Integer.valueOf(i)));
        aVar.pd(1);
        aVar.a(this.context.getString(R.string.send_forum_broadcast), new a.b() { // from class: com.baidu.tieba.frs.broadcast.a.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                b.bvr().putBoolean("key_forum_broadcast_no_tip_again", aVar.btW());
                aVar.dismiss();
                if (i == 0) {
                    new ScreenTopToast(a.this.context.getPageActivity()).Vb(a.this.context.getPageActivity().getString(R.string.frs_forum_bawu_send_broadcast_none_tip)).Vd(a.this.context.getString(R.string.frs_recommend_fail_tip_btn)).an(new View.OnClickListener() { // from class: com.baidu.tieba.frs.broadcast.a.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", a.this.forumId);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.context.getPageActivity(), "ForumGradePage", hashMap)));
                        }
                    }).aR((ViewGroup) a.this.context.getPageActivity().findViewById(R.id.frs));
                    return;
                }
                o oVar = new o(a.this.context.getPageActivity());
                if (a.this.type == 1) {
                    oVar.ao(a.this.forumId, a.this.forumName, "3");
                } else if (a.this.type == 2) {
                    oVar.ao(a.this.forumId, a.this.forumName, "4");
                } else {
                    oVar.ao(a.this.forumId, a.this.forumName, "0");
                }
                oVar.BO(a.this.threadId);
                oVar.start();
            }
        });
        aVar.b(this.context.getString(R.string.next_time), new a.b() { // from class: com.baidu.tieba.frs.broadcast.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                b.bvr().putBoolean("key_call_fans_no_tip_again", false);
                aVar.dismiss();
            }
        });
        aVar.b(this.context).btY();
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS, TbConfig.SERVER_ADDRESS + "c/f/forum/getForumMangerRights");
        tbHttpMessageTask.setResponsedClass(ForumManagerRightsResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private void KO(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam("forum_id", str);
        this.context.sendMessage(httpMessage);
    }
}
