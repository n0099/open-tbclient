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
import com.baidu.tbadk.core.util.at;
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
    public static boolean cjf = true;
    public static boolean cjg = true;
    public static String forumName = "";
    public static final CustomMessageListener cjh = new CustomMessageListener(CmdConfigCustom.MSG_NEW) { // from class: com.baidu.tieba.frs.FrsActivityStatic.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewMsgArriveResponsedMessage) && customResponsedMessage.getCmd() == 2012111) {
                int intValue = ((NewMsgArriveResponsedMessage) customResponsedMessage).getData().intValue();
                if (intValue == 1 || intValue == 4 || intValue == 3 || intValue == 2) {
                    FrsActivityStatic.cjg = true;
                    FrsActivityStatic.cjf = true;
                    return;
                }
                FrsActivityStatic.cjg = false;
                FrsActivityStatic.cjf = false;
            }
        }
    };
    private static final CustomMessageListener cji = new CustomMessageListener(CmdConfigCustom.MSG_READ) { // from class: com.baidu.tieba.frs.FrsActivityStatic.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                int g = com.baidu.adp.lib.g.b.g(customResponsedMessage.getData().toString(), 1);
                if (g == 1 || g == 0) {
                    FrsActivityStatic.cjg = false;
                    FrsActivityStatic.cjf = false;
                }
            }
        }
    };

    static {
        TbadkCoreApplication.getInst().RegisterIntent(FrsActivityConfig.class, FrsActivity.class);
        aff();
        afa();
        afb();
        afc();
        afd();
        afe();
        LocationModel.btR();
        afg();
        afi();
        MessageManager.getInstance().registerListener(cjh);
        MessageManager.getInstance().registerListener(cji);
        afh();
    }

    private static void afa() {
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

    private static void afb() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.ACTIVITY_REFRESH, new CustomMessageTask.CustomRunnable<FrsActivityConfig>() { // from class: com.baidu.tieba.frs.FrsActivityStatic.3
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

    private static void afc() {
        com.baidu.tbadk.core.util.at.wf().a(new at.a() { // from class: com.baidu.tieba.frs.FrsActivityStatic.4
            @Override // com.baidu.tbadk.core.util.at.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                boolean z;
                String substring;
                boolean z2;
                String str;
                String str2 = null;
                boolean z3 = false;
                if (strArr == null || strArr[0] == null || tbPageContext == null || tbPageContext.getPageActivity() == null) {
                    return 3;
                }
                String lowerCase = strArr[0].toLowerCase();
                String str3 = strArr.length > 1 ? strArr[1] : null;
                if (lowerCase != null && (lowerCase.startsWith("http://tieba.baidu.com/f?") || lowerCase.startsWith("http://tieba.baidu.com/f?"))) {
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
                                z2 = false;
                                str = null;
                                break;
                            } else if (split[i] == null || !split[i].startsWith("kw=")) {
                                i++;
                            } else {
                                str = split[i].substring(3);
                                z2 = true;
                                break;
                            }
                        }
                        if (!TextUtils.isEmpty(str)) {
                            str2 = URLDecoder.decode(str);
                        }
                    } else {
                        z2 = false;
                    }
                    boolean z4 = z2;
                    z = false;
                    z3 = z4;
                } else if (lowerCase.startsWith("frs:")) {
                    str2 = lowerCase.substring(4);
                    z = false;
                    z3 = true;
                } else if (lowerCase.startsWith("com.baidu.tieba://?tname=")) {
                    str2 = lowerCase.substring("com.baidu.tieba://?tname=".length());
                    z = true;
                } else if (!lowerCase.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) || !lowerCase.contains("kw=")) {
                    return 3;
                } else {
                    str2 = com.baidu.tbadk.util.y.aq(lowerCase, "kw=");
                    if (!TextUtils.isEmpty(str2) && tbPageContext != null) {
                        tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(str2, str3)));
                        return 0;
                    }
                    z = false;
                }
                if (!TextUtils.isEmpty(str2) && tbPageContext != null) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(str2, str3)));
                    return 1;
                } else if (z && !TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.g.f.h(TbadkCoreApplication.getInst(), com.baidu.tieba.frs.f.i.ah(TbadkCoreApplication.getInst(), str2));
                    com.baidu.tieba.frs.f.h.aC(2, 2);
                    return 1;
                } else if (z3) {
                    tbPageContext.showToast(d.l.page_not_found);
                    return 1;
                } else {
                    return 3;
                }
            }
        });
    }

    private static void afd() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_KV_CACHE_SUCC) { // from class: com.baidu.tieba.frs.FrsActivityStatic.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001012) {
                    com.baidu.tieba.frs.smartsort.d.ajB().ajC();
                    com.baidu.tieba.frs.smartsort.a.aju().ajw();
                    if (r.bil().bih() != null) {
                        r.bil().bih().bhY();
                    }
                    if (r.bil().bii() != null) {
                        r.bil().bii().bhZ();
                    }
                }
            }
        });
    }

    private static void afe() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_CLEAN_SMART_FRS_COOKIE) { // from class: com.baidu.tieba.frs.FrsActivityStatic.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getCmd() == 2016501 && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    com.baidu.tieba.frs.smartsort.d.ajB().ajD();
                }
            }
        });
    }

    public static void aff() {
        com.baidu.tbadk.ala.b.nC().a(1, new com.baidu.tbadk.ala.d() { // from class: com.baidu.tieba.frs.FrsActivityStatic.9
            @Override // com.baidu.tbadk.ala.d
            public View ar(Context context) {
                TextView aq = com.baidu.tbadk.ala.c.aq(context);
                if (aq != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    com.baidu.tbadk.core.util.ai.i(aq, d.e.cp_link_tip_a);
                    layoutParams.setMargins(com.baidu.adp.lib.util.k.g(context, d.f.ds8), 0, com.baidu.adp.lib.util.k.g(context, d.f.ds8), 0);
                    layoutParams.gravity = 16;
                    aq.setLayoutParams(layoutParams);
                }
                return aq;
            }
        });
    }

    public static void afg() {
        com.baidu.tieba.tbadkCore.a.a.a(301001, FRSPageSocketResponsedMessage.class, false, false).setPriority(4);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.az(TbConfig.FRS_ADDRESS, 301001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
        tbHttpMessageTask.setIsImm(true);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.frs.FrsActivityStatic.10
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.util.z.a(com.baidu.tieba.tbadkCore.g.WIRE, FrsPageResIdl.class);
                return null;
            }
        };
        bdAsyncTask.setSelfExecute(true);
        bdAsyncTask.setPriority(4);
        bdAsyncTask.execute(new Void[0]);
    }

    private static void afh() {
        com.baidu.tieba.tbadkCore.a.a.c(301002, LoadMoreResponseSocketMessage.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_LOAD_MORE_CMD, com.baidu.tieba.tbadkCore.a.a.az(FrsLoadMoreModel.LOAD_MORE_URL, 301002));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(LoadMoreHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void afi() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_GET_NEW_FRS_FRAGMENT) { // from class: com.baidu.tieba.frs.FrsActivityStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage)) {
                    ((CustomMessage) customResponsedMessage.getOrginalMessage()).setData(new f());
                }
            }
        });
    }
}
