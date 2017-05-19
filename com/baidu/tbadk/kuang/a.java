package com.baidu.tbadk.kuang;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.plugin.api.HostInvokeCallback;
import com.baidu.searchbox.plugin.api.PluginInvokeException;
import com.baidu.searchbox.plugin.api.PluginInvoker;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.j;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public class a {
    public static int aDz = 0;
    private static String mBduss = "";
    private static String mUserId = "";
    private static String Su = "";
    private static j aDA = null;

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
        aDA = new j(tbPageContext);
        aDA.a(new b());
        aDA.b(new c());
        aDA.AG();
        aDA.i(accountData);
        aDA.AC();
    }

    public static void bP(boolean z) {
        a("getUserId", new Class[0], new Object[0], new g(new f(new e(new d(z)))));
    }

    public static void c(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.adp.lib.g.h.fS().postDelayed(new h(customResponsedMessage), aDz);
    }

    public static void DV() {
        a("login", new Class[0], new Object[0], new i());
    }
}
