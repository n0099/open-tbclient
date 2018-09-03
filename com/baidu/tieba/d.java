package com.baidu.tieba;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.c;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class d {
    private static final long bhR = 30 * ap.aqR;
    private c bhS;
    private Handler mHandler;

    private d() {
        this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.tieba.d.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == 1) {
                    if (d.this.bhS != null && !w.z(d.this.bhS.Pc())) {
                        c.a aVar = d.this.bhS.Pc().get(0);
                        if (!StringUtils.isNull(aVar.threadId)) {
                            Intent intent = new Intent(TbadkCoreApplication.getInst(), DealIntentService.class);
                            intent.putExtra("class", 1);
                            intent.putExtra("id", d.this.bhS.Pc().get(0).threadId);
                            intent.putExtra("key_start_from", 7);
                            intent.putExtra(PbActivityConfig.KEY_IS_FROM_LOCAL_PUSH, true);
                            NotificationHelper.showNotification(TbadkCoreApplication.getInst(), f.g.notification, aVar.title, aVar.bhQ, aVar.bhQ, PendingIntent.getService(TbadkCoreApplication.getInst(), 0, intent, 134217728), false);
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("local_push_expire", ap.aqT + UtilHelper.getTodayZeroTime());
                            TiebaStatic.log(new an("c13264"));
                        }
                        d.this.bhS = null;
                    }
                    return true;
                }
                return false;
            }
        });
        MessageManager.getInstance().registerListener(new HttpMessageListener(CmdConfigHttp.CMD_GET_LOCAL_PUSH_DATA) { // from class: com.baidu.tieba.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LocalPushRespMsg) {
                    d.this.bhS = ((LocalPushRespMsg) httpResponsedMessage).getData();
                    an anVar = new an("c13263");
                    if (d.this.bhS == null || w.z(d.this.bhS.Pc())) {
                        anVar.r("obj_locate", 0);
                    } else {
                        anVar.r("obj_locate", 1);
                    }
                    TiebaStatic.log(anVar);
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001011) { // from class: com.baidu.tieba.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                        if (d.this.bhS != null && !w.z(d.this.bhS.Pc())) {
                            d.this.mHandler.sendEmptyMessageDelayed(1, d.bhR);
                            return;
                        }
                        return;
                    }
                    d.this.mHandler.removeMessages(1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Pd() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_LOCAL_PUSH_DATA));
    }

    public static d Pe() {
        return a.bhU;
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static d bhU = new d();
    }
}
