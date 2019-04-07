package com.baidu.tieba.aiapps.apps.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.swan.apps.u.b.c;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class h implements com.baidu.swan.apps.u.b.c {
    private static String cRn = " swan/1.6";
    private final List<com.baidu.swan.apps.a.c> cRo = new LinkedList();
    private String cRp = null;

    public h() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.aiapps.apps.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean isNULL = StringUtils.isNULL(h.this.bl(TbadkCoreApplication.getInst()));
                synchronized (h.this.cRo) {
                    for (com.baidu.swan.apps.a.c cVar : h.this.cRo) {
                        cVar.aL(isNULL);
                    }
                }
            }
        });
    }

    public String bl(Context context) {
        return TbadkCoreApplication.getInst().isMainProcess(true) ? a.bl(context) : a.dE(context);
    }

    @Override // com.baidu.swan.apps.u.b.c
    public void a(Activity activity, Bundle bundle, com.baidu.swan.apps.a.a aVar) {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            a.b(activity, AlbumActivityConfig.FROM_AIAPPS, aVar);
        } else {
            a.a(activity, aVar);
        }
    }

    @Override // com.baidu.swan.apps.u.b.c
    public boolean bH(Context context) {
        return TbadkCoreApplication.getInst().isMainProcess(true) ? a.bk(context) : a.dF(context);
    }

    @Override // com.baidu.swan.apps.u.b.c
    public String bI(Context context) {
        return TbadkCoreApplication.getInst().isMainProcess(true) ? a.bl(context) : a.dE(context);
    }

    @Override // com.baidu.swan.apps.u.b.c
    public String bJ(@NonNull Context context) {
        return TbadkCoreApplication.getInst().getCuid();
    }

    @Override // com.baidu.swan.apps.u.b.c
    public void a(com.baidu.swan.apps.a.c cVar) {
        if (cVar != null) {
            synchronized (this.cRo) {
                if (!this.cRo.contains(cVar)) {
                    this.cRo.add(cVar);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.u.b.c
    public void a(String str, c.a aVar) {
        a.a(str, aVar);
    }
}
