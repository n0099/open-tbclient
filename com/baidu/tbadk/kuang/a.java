package com.baidu.tbadk.kuang;

import android.text.TextUtils;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.plugin.api.HostInvokeCallback;
import com.baidu.searchbox.plugin.api.PluginInvokeException;
import com.baidu.searchbox.plugin.api.PluginInvoker;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.b;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.d;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public class a {
    public static int aFQ = 0;
    private static String ws = "";
    private static String mUserId = "";
    private static String Tg = "";
    private static d aFR = null;

    public static void a(int i, String str, Class<?>[] clsArr, Object[] objArr, String str2, HostInvokeCallback hostInvokeCallback) {
        try {
            PluginInvoker.invokeHost(i, str, clsArr, objArr, TbConfig.MAIN_PACKAGE_NAME, hostInvokeCallback);
        } catch (PluginInvokeException e) {
            BdLog.e(e);
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            BdLog.e(e2);
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            BdLog.e(e3);
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            BdLog.e(e4);
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            BdLog.e(e5);
            e5.printStackTrace();
        }
    }

    public static void a(String str, Class<?>[] clsArr, Object[] objArr, HostInvokeCallback hostInvokeCallback) {
        a(2, str, clsArr, objArr, TbConfig.MAIN_PACKAGE_NAME, hostInvokeCallback);
    }

    public static void a(TbPageContext<?> tbPageContext, AccountData accountData) {
        aFR = new d(tbPageContext);
        aFR.a(new d.a() { // from class: com.baidu.tbadk.kuang.a.1
            @Override // com.baidu.tbadk.coreExtra.view.d.a
            public void j(AccountData accountData2) {
                b.b(accountData2);
                b.c(accountData2);
                TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData2, accountData2.getBDUSS(), accountData2.getTbs());
                TbadkCoreApplication.setCurrentAccount(accountData2, TbadkCoreApplication.getInst().getApp());
                a.c(new ReLoginFromKuangMessage(true));
            }
        });
        aFR.b(new d.a() { // from class: com.baidu.tbadk.kuang.a.2
            @Override // com.baidu.tbadk.coreExtra.view.d.a
            public void j(AccountData accountData2) {
                b.b(null);
                b.pd();
                TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp());
            }
        });
        aFR.AG();
        aFR.i(accountData);
        aFR.AC();
    }

    public static void bP(final boolean z) {
        final a.InterfaceC0044a interfaceC0044a = new a.InterfaceC0044a() { // from class: com.baidu.tbadk.kuang.a.3
            @Override // com.baidu.tbadk.core.a.a.InterfaceC0044a
            public void cp(String str) {
            }

            @Override // com.baidu.tbadk.core.a.a.InterfaceC0044a
            public void a(AccountData accountData) {
                if (TextUtils.isEmpty(accountData.getAccount())) {
                    if (z) {
                        if (i.Y(com.baidu.adp.base.a.ca().cb()) != null) {
                            a.a((TbPageContext) i.Y(com.baidu.adp.base.a.ca().cb()), accountData);
                            return;
                        }
                        return;
                    }
                    TbadkCoreApplication.getInst().setIsKuangLogin(true);
                    b.b(null);
                    TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp());
                    a.c(new ReLoginFromKuangMessage(false));
                    return;
                }
                b.b(accountData);
                b.c(accountData);
                TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
                TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.getInst().getApp());
                a.c(new ReLoginFromKuangMessage(true));
            }

            @Override // com.baidu.tbadk.core.a.a.InterfaceC0044a
            public void c(String str, int i, String str2) {
                l.showToast(TbadkCoreApplication.getInst().getApp(), str2);
                a.c(new ReLoginFromKuangMessage(false));
            }
        };
        final HostInvokeCallback hostInvokeCallback = new HostInvokeCallback() { // from class: com.baidu.tbadk.kuang.a.4
            @Override // com.baidu.searchbox.plugin.api.HostInvokeCallback
            public void onResult(int i, Object obj) {
                if (i == 0) {
                    String unused = a.Tg = (String) obj;
                    if (a.ws == null) {
                        a.Em();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
                    com.baidu.tieba.model.b.a(a.mUserId, a.ws, a.Tg, null, a.InterfaceC0044a.this);
                }
            }
        };
        final HostInvokeCallback hostInvokeCallback2 = new HostInvokeCallback() { // from class: com.baidu.tbadk.kuang.a.5
            @Override // com.baidu.searchbox.plugin.api.HostInvokeCallback
            public void onResult(int i, Object obj) {
                if (i == 0) {
                    String unused = a.ws = (String) obj;
                    a.a("getPToken", new Class[0], new Object[0], HostInvokeCallback.this);
                }
            }
        };
        a("getUserId", new Class[0], new Object[0], new HostInvokeCallback() { // from class: com.baidu.tbadk.kuang.a.6
            @Override // com.baidu.searchbox.plugin.api.HostInvokeCallback
            public void onResult(int i, Object obj) {
                if (i == 0) {
                    String unused = a.mUserId = (String) obj;
                    a.a("getBduss", new Class[0], new Object[0], HostInvokeCallback.this);
                }
            }
        });
    }

    public static void c(final CustomResponsedMessage<?> customResponsedMessage) {
        e.fP().postDelayed(new Runnable() { // from class: com.baidu.tbadk.kuang.a.7
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(CustomResponsedMessage.this);
            }
        }, aFQ);
    }

    public static void Em() {
        a("login", new Class[0], new Object[0], new HostInvokeCallback() { // from class: com.baidu.tbadk.kuang.a.8
            @Override // com.baidu.searchbox.plugin.api.HostInvokeCallback
            public void onResult(int i, Object obj) {
            }
        });
    }
}
