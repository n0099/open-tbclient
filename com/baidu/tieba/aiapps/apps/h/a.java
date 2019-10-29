package com.baidu.tieba.aiapps.apps.h;

import android.location.Address;
import android.net.http.Headers;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.d.a;
import com.baidu.swan.apps.u.b.n;
/* loaded from: classes4.dex */
public class a implements n {
    @Override // com.baidu.swan.apps.u.b.n
    public void a(final String str, boolean z, boolean z2, final n.a aVar) {
        if (aVar != null) {
            com.baidu.adp.lib.d.a.fw().a(!z, z2, new a.InterfaceC0015a() { // from class: com.baidu.tieba.aiapps.apps.h.a.1
                @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
                public void onLocationGeted(int i, String str2, Address address) {
                    if ("bd09ll".equals(str)) {
                        aVar.a(a.this.a(str, address));
                        return;
                    }
                    CustomMessageTask customMessageTask = (CustomMessageTask) MessageManager.getInstance().findTask(2921363);
                    if (customMessageTask == null) {
                        aVar.dy(-1);
                        return;
                    }
                    try {
                        CustomMessageTask.CustomRunnable<?> runnable = customMessageTask.getRunnable();
                        Bundle bundle = new Bundle();
                        bundle.putString("coorType", str);
                        bundle.putParcelable(Headers.LOCATION, address);
                        CustomResponsedMessage<?> run = runnable.run(new CustomMessage<>(2921363, bundle));
                        if (run == null) {
                            aVar.dy(-1);
                        } else {
                            aVar.a(a.this.a(str, (Address) run.getData()));
                        }
                    } catch (Exception e) {
                        aVar.dy(-1);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.u.b.n
    public com.baidu.swan.apps.scheme.actions.e.b Ke() {
        return null;
    }

    @Override // com.baidu.swan.apps.u.b.n
    public void Kf() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.scheme.actions.e.b a(String str, Address address) {
        if (address == null) {
            return null;
        }
        Bundle extras = address.getExtras();
        float f = 0.0f;
        double d = 0.0d;
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (extras != null) {
            f = extras.getFloat("speed");
            d = extras.getDouble("altitude");
            str2 = extras.getString("cityCode");
            str3 = extras.getString("province");
            str4 = extras.getString("street");
            str5 = extras.getString("streetNumber");
        }
        return new com.baidu.swan.apps.scheme.actions.e.b(str, address.getLongitude(), address.getLatitude(), f, 0.0d, d, address.getCountryName(), address.getCountryCode(), address.getLocality(), str2, str3, "", str4, str5);
    }
}
