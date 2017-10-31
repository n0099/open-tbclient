package com.baidu.tieba.frs;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.loadmore.LoadMoreHttpResponseMessage;
import com.baidu.tieba.frs.loadmore.LoadMoreResponseSocketMessage;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import java.net.URLDecoder;
import tbclient.FrsPage.FrsPageResIdl;
/* loaded from: classes.dex */
public class FrsActivityStatic {
    public static boolean cwZ = true;
    public static boolean cxa = true;
    public static String forumName = "";
    public static final CustomMessageListener cxb = new CustomMessageListener(CmdConfigCustom.MSG_NEW) { // from class: com.baidu.tieba.frs.FrsActivityStatic.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewMsgArriveResponsedMessage) && customResponsedMessage.getCmd() == 2012111) {
                int intValue = ((NewMsgArriveResponsedMessage) customResponsedMessage).getData().intValue();
                if (intValue == 1 || intValue == 4 || intValue == 3 || intValue == 2) {
                    FrsActivityStatic.cxa = true;
                    FrsActivityStatic.cwZ = true;
                    return;
                }
                FrsActivityStatic.cxa = false;
                FrsActivityStatic.cwZ = false;
            }
        }
    };
    private static final CustomMessageListener cxc = new CustomMessageListener(CmdConfigCustom.MSG_READ) { // from class: com.baidu.tieba.frs.FrsActivityStatic.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                int g = com.baidu.adp.lib.g.b.g(customResponsedMessage.getData().toString(), 1);
                if (g == 1 || g == 0) {
                    FrsActivityStatic.cxa = false;
                    FrsActivityStatic.cwZ = false;
                }
            }
        }
    };

    static {
        TbadkCoreApplication.getInst().RegisterIntent(FrsActivityConfig.class, FrsActivity.class);
        aiH();
        aiC();
        aiD();
        aiE();
        aiF();
        aiG();
        LocationModel.bvf();
        aiI();
        MessageManager.getInstance().registerListener(cxb);
        MessageManager.getInstance().registerListener(cxc);
        aiJ();
    }

    private static void aiC() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_START_NORMAL, new CustomMessageTask.CustomRunnable<FrsActivityConfig>() { // from class: com.baidu.tieba.frs.FrsActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<FrsActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(FrsActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aiD() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_REFRESH, new CustomMessageTask.CustomRunnable<FrsActivityConfig>() { // from class: com.baidu.tieba.frs.FrsActivityStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<FrsActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(FrsActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aiE() {
        com.baidu.tbadk.core.util.av.vI().a(new av.a() { // from class: com.baidu.tieba.frs.FrsActivityStatic.3
            @Override // com.baidu.tbadk.core.util.av.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                String substring;
                boolean z;
                boolean z2;
                String str;
                String str2 = null;
                boolean z3 = false;
                if (strArr == null || strArr[0] == null || tbPageContext == null || tbPageContext.getPageActivity() == null) {
                    return 3;
                }
                String lowerCase = strArr[0].toLowerCase();
                String str3 = strArr.length > 1 ? strArr[1] : null;
                if (lowerCase.startsWith("http://tieba.baidu.com/f?") || lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                    if (lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                        substring = lowerCase.substring("http://tieba.baidu.com/f?".length());
                    } else {
                        substring = lowerCase.startsWith("http://tieba.baidu.com/f?") ? lowerCase.substring("http://tieba.baidu.com/f?".length()) : null;
                    }
                    if (substring != null) {
                        String[] split = substring.split("&");
                        int i = 0;
                        while (true) {
                            if (i >= split.length) {
                                z = false;
                                str = null;
                                break;
                            } else if (split[i] == null || !split[i].startsWith("kw=")) {
                                i++;
                            } else {
                                str = split[i].substring(3);
                                z = true;
                                break;
                            }
                        }
                        if (!TextUtils.isEmpty(str)) {
                            str2 = URLDecoder.decode(str);
                        }
                    } else {
                        z = false;
                    }
                    boolean z4 = z;
                    z2 = false;
                    z3 = z4;
                } else if (lowerCase.startsWith("frs:")) {
                    str2 = lowerCase.substring(4);
                    z2 = false;
                    z3 = true;
                } else if (lowerCase.startsWith("com.baidu.tieba://?tname=")) {
                    str2 = lowerCase.substring("com.baidu.tieba://?tname=".length());
                    z2 = true;
                } else if (!lowerCase.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) || !lowerCase.contains("kw=")) {
                    return 3;
                } else {
                    str2 = com.baidu.tbadk.util.z.ar(lowerCase, "kw=");
                    if (!TextUtils.isEmpty(str2)) {
                        tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(str2, str3)));
                        return 0;
                    }
                    z2 = false;
                }
                if (!TextUtils.isEmpty(str2)) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(str2, str3)));
                    return 1;
                } else if (z2 && !TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.g.f.f(TbadkCoreApplication.getInst(), com.baidu.tieba.frs.f.i.ac(TbadkCoreApplication.getInst(), str2));
                    com.baidu.tieba.frs.f.h.aL(2, 2);
                    return 1;
                } else if (z3) {
                    tbPageContext.showToast(d.j.page_not_found);
                    return 1;
                } else {
                    return 3;
                }
            }
        });
    }

    private static void aiF() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_KV_CACHE_SUCC) { // from class: com.baidu.tieba.frs.FrsActivityStatic.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001012) {
                    com.baidu.tieba.frs.smartsort.d.anZ().aoa();
                    com.baidu.tieba.frs.smartsort.a.anS().anU();
                    if (r.bja().biU() != null) {
                        r.bja().biU().biL();
                    }
                    if (r.bja().biV() != null) {
                        r.bja().biV().biM();
                    }
                }
            }
        });
    }

    private static void aiG() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE) { // from class: com.baidu.tieba.frs.FrsActivityStatic.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getCmd() == 2016501 && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    com.baidu.tieba.frs.smartsort.d.anZ().aob();
                }
            }
        });
    }

    public static void aiH() {
        com.baidu.tbadk.ala.b.nu().a(1, new com.baidu.tbadk.ala.d() { // from class: com.baidu.tieba.frs.FrsActivityStatic.8
            @Override // com.baidu.tbadk.ala.d
            public View aw(Context context) {
                TextView av = com.baidu.tbadk.ala.c.av(context);
                if (av != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    com.baidu.tbadk.core.util.aj.i(av, d.C0080d.cp_link_tip_a);
                    layoutParams.setMargins(com.baidu.adp.lib.util.l.f(context, d.e.ds8), 0, com.baidu.adp.lib.util.l.f(context, d.e.ds8), 0);
                    layoutParams.gravity = 16;
                    av.setLayoutParams(layoutParams);
                }
                return av;
            }
        });
    }

    public static void aiI() {
        com.baidu.tieba.tbadkCore.a.a.a(301001, FRSPageSocketResponsedMessage.class, false, false).setPriority(4);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.aE(TbConfig.FRS_ADDRESS, 301001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
        tbHttpMessageTask.setIsImm(true);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.frs.FrsActivityStatic.9
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.util.aa.a(com.baidu.tieba.tbadkCore.g.WIRE, FrsPageResIdl.class);
                return null;
            }
        };
        bdAsyncTask.setSelfExecute(true);
        bdAsyncTask.setPriority(4);
        bdAsyncTask.execute(new Void[0]);
    }

    private static void aiJ() {
        com.baidu.tieba.tbadkCore.a.a.c(301002, LoadMoreResponseSocketMessage.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_LOAD_MORE_CMD, com.baidu.tieba.tbadkCore.a.a.aE(FrsLoadMoreModel.LOAD_MORE_URL, 301002));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(LoadMoreHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
