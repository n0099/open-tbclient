package com.baidu.tieba.aiapps.apps.abtest;

import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntimeInit;
import com.baidu.searchbox.ng.ai.apps.scheme.SchemeContext;
import com.baidu.searchbox.ng.ai.apps.scheme.SchemeIocImpl;
import com.baidu.searchbox.unitedscheme.SchemeRuntimeInit;
import com.baidu.tieba.aiapps.apps.q.f;
import com.baidu.ubc.o;
/* loaded from: classes4.dex */
public class b {
    public static void Wg() {
        AiAppsRuntimeInit.setAiAppConfigImpl(new com.baidu.tieba.aiapps.apps.d.a());
        AiAppsRuntimeInit.setAiAppsSocialShareImpl(new com.baidu.tieba.aiapps.apps.share.b());
        AiAppsRuntimeInit.setAiAppAbTestImpl(new a());
        AiAppsRuntimeInit.setAiAppAccountImpl(new com.baidu.tieba.aiapps.apps.a.a());
        AiAppsRuntimeInit.setAiAppChooseAddressImpl(new com.baidu.tieba.aiapps.apps.address.a());
        AiAppsRuntimeInit.setAiAppChooseInvoiceImpl(new com.baidu.tieba.aiapps.apps.invoice.a());
        AiAppsRuntimeInit.setAiAppScanCodeImpl(new com.baidu.tieba.aiapps.apps.c.a());
        AiAppsRuntimeInit.setAiAppFeedbackImpl(new com.baidu.tieba.aiapps.apps.f.a());
        AiAppsRuntimeInit.setAiAppDownloadImpl(new com.baidu.tieba.aiapps.apps.k.a());
        AiAppsRuntimeInit.setAiAppMapImpl(new com.baidu.tieba.aiapps.apps.j.a());
        AiAppsRuntimeInit.setAiAppVideoImpl(new com.baidu.tieba.aiapps.apps.media.video.a());
        AiAppsRuntimeInit.setAiAppLiveImpl(new com.baidu.tieba.aiapps.apps.media.b.a());
        AiAppsRuntimeInit.setAiAppImageImpl(new com.baidu.tieba.aiapps.apps.media.a.a());
        AiAppsRuntimeInit.setAiAppTTSImpl(new com.baidu.tieba.aiapps.apps.p.a());
        AiAppsRuntimeInit.setAiAppPaymentImpl(new com.baidu.tieba.aiapps.apps.l.a());
        AiAppsRuntimeInit.setAiAppPluginImpl(new com.baidu.tieba.aiapps.apps.m.a());
        AiAppsRuntimeInit.setAiAppIMImpl(new com.baidu.tieba.aiapps.apps.h.a());
        AiAppsRuntimeInit.setAiAppLocationImpl(new com.baidu.tieba.aiapps.apps.i.a());
        AiAppsRuntimeInit.setAiAppHistoryImpl(new com.baidu.tieba.aiapps.apps.g.a());
        AiAppsRuntimeInit.setAiAppNightModeImpl(new com.baidu.tieba.aiapps.apps.o.a());
        AiAppsRuntimeInit.setAiAppsBlinkAbTestImpl(new c());
        AiAppsRuntimeInit.setAiAppExtendSchemeImpl(new com.baidu.tieba.aiapps.apps.n.a());
        AiAppsRuntimeInit.setAiAppDebugImpl(new com.baidu.tieba.aiapps.apps.e.a());
        SchemeRuntimeInit.setSchemeContextImpl(new SchemeContext());
        SchemeRuntimeInit.setSchemeImpl(new SchemeIocImpl());
        com.baidu.b.a.g.b.a(new com.baidu.tieba.aiapps.apps.b.a());
        o.a(new f());
    }
}
