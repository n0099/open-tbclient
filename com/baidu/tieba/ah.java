package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.FRSPageSocketResponsedMessage;
import com.baidu.tieba.frs.FrsPageHttpResponseMessage;
import com.baidu.tieba.mention.CheckPostResponseMessage;
import com.baidu.tieba.message.ResponseFriendFeedMessage;
import com.baidu.tieba.message.ResponseQueryCollectUpdateNumMessage;
import com.baidu.tieba.person.dy;
import com.baidu.tieba.person.dz;
import com.baidu.tieba.person.post.UserPostPageHttpResponseMessage;
import com.baidu.tieba.person.post.UserPostPageSocketResponsedMessage;
/* loaded from: classes.dex */
public class ah {
    public static void a() {
        b();
        d();
        c();
    }

    public static void b() {
        a(303005, ResponseQueryCollectUpdateNumMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_ME, true);
        a(301001, FRSPageSocketResponsedMessage.class, false, false);
        a(303002, UserPostPageSocketResponsedMessage.class, false, false);
        a(303003, ResponseFriendFeedMessage.class, false, false);
        a(303010, CheckPostResponseMessage.class, false);
    }

    private static void c() {
        a(2001172, com.baidu.tieba.message.a.a.class);
        a(2001186, dz.class);
        a(2001187, dy.class);
        a(2001190, com.baidu.tieba.pb.history.i.class);
        a(2001191, com.baidu.tieba.pb.history.j.class);
        a(2001194, com.baidu.tieba.mainentrance.d.class);
        a(2001195, com.baidu.tieba.mainentrance.c.class);
    }

    public static com.baidu.tbadk.task.a a(int i, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        try {
            com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(i, cls.newInstance());
            MessageManager.getInstance().registerTask(aVar);
            return aVar;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String a(String str, int i) {
        return String.valueOf(TbConfig.SERVER_ADDRESS) + str + "?cmd=" + i;
    }

    private static void d() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_HTTP_CMD, a("c/f/frs/page", 301001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.USER_POST_HTTP_CMD, a("c/u/feed/userpost", 303002));
        tbHttpMessageTask2.setIsNeedLogin(false);
        tbHttpMessageTask2.setIsNeedTbs(false);
        tbHttpMessageTask2.setIsNeedAddCommenParam(false);
        tbHttpMessageTask2.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask2.setResponsedClass(UserPostPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        TbHttpMessageTask tbHttpMessageTask3 = new TbHttpMessageTask(CmdConfigHttp.SET_PRIVATE_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SET_PRIVATE);
        tbHttpMessageTask3.setIsNeedLogin(true);
        tbHttpMessageTask3.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask3);
        TbHttpMessageTask tbHttpMessageTask4 = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavolike");
        tbHttpMessageTask4.setIsNeedLogin(true);
        tbHttpMessageTask4.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask4);
    }

    public static com.baidu.tbadk.task.b a(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        return a(i, cls, z, SocketMessageTask.DupLicateMode.NONE, true);
    }

    public static com.baidu.tbadk.task.b a(int i, Class<? extends SocketResponsedMessage> cls, boolean z, boolean z2) {
        return a(i, cls, z, SocketMessageTask.DupLicateMode.NONE, z2);
    }

    private static com.baidu.tbadk.task.b a(int i, Class<? extends SocketResponsedMessage> cls, boolean z, SocketMessageTask.DupLicateMode dupLicateMode, boolean z2) {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(i);
        bVar.a(cls);
        bVar.b(z);
        bVar.a(dupLicateMode);
        MessageManager.getInstance().unRegisterTask(i);
        MessageManager.getInstance().registerTask(bVar);
        bVar.setNeedEncrypt(z2);
        return bVar;
    }

    public static TbHttpMessageTask a(int i, int i2, String str, Class<? extends HttpResponsedMessage> cls, boolean z, boolean z2, boolean z3, boolean z4) {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(i2, a(str, i));
        tbHttpMessageTask.setIsNeedLogin(z);
        tbHttpMessageTask.setIsNeedTbs(z2);
        tbHttpMessageTask.setIsNeedAddCommenParam(z3);
        tbHttpMessageTask.setIsUseCurrentBDUSS(z4);
        tbHttpMessageTask.setResponsedClass(cls);
        MessageManager.getInstance().unRegisterTask(i2);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        return tbHttpMessageTask;
    }
}
