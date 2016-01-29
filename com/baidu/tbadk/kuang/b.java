package com.baidu.tbadk.kuang;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.plugin.api.HostInvokeCallback;
import com.baidu.searchbox.plugin.api.PluginInvokeException;
import com.baidu.searchbox.plugin.api.PluginInvoker;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AccountData;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public class b {
    public static int axH = 0;
    private static String wJ = "";
    private static String mUserId = "";
    private static String TU = "";
    private static com.baidu.tbadk.coreExtra.view.j axI = null;

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
        axI = new com.baidu.tbadk.coreExtra.view.j(tbPageContext);
        axI.a(new c());
        axI.b(new d());
        axI.AT();
        axI.h(accountData);
        axI.AP();
    }

    public static void bv(boolean z) {
        a("getUserId", new Class[0], new Object[0], new h(new g(new f(new e(z)))));
    }

    public static void c(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.adp.lib.h.h.hr().postDelayed(new i(customResponsedMessage), axH);
    }

    public static void El() {
        a("login", new Class[0], new Object[0], new j());
    }
}
