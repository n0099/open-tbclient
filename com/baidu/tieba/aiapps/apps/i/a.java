package com.baidu.tieba.aiapps.apps.i;

import android.annotation.TargetApi;
import android.content.Context;
import android.location.Address;
import android.net.http.Headers;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.d.a;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLocationIoc;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.location.LocationResult;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.recommend.model.AiAppsLocationInfo;
import rx.d;
import rx.j;
/* loaded from: classes4.dex */
public class a implements IAiAppLocationIoc {
    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLocationIoc
    @TargetApi(23)
    @Nullable
    public d<AiAppsLocationInfo> getLocationInfo(Context context) {
        if (context == null) {
            return null;
        }
        return d.create(new d.a<AiAppsLocationInfo>() { // from class: com.baidu.tieba.aiapps.apps.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(final j<? super AiAppsLocationInfo> jVar) {
                a.this.requestLocation("bd09ll", true, true, new IAiAppLocationIoc.LocationListener() { // from class: com.baidu.tieba.aiapps.apps.i.a.1.1
                    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLocationIoc.LocationListener
                    public void onSuccess(LocationResult locationResult) {
                        AiAppsLocationInfo aiAppsLocationInfo = new AiAppsLocationInfo();
                        aiAppsLocationInfo.coordType = "bd09ll";
                        aiAppsLocationInfo.latitude = locationResult.latitude;
                        aiAppsLocationInfo.longitude = locationResult.longitude;
                        jVar.onNext(aiAppsLocationInfo);
                        jVar.onCompleted();
                    }

                    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLocationIoc.LocationListener
                    public void onFailed(int i) {
                        jVar.onError(new Throwable());
                    }
                });
            }
        });
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLocationIoc
    public void preInitLocation() {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLocationIoc
    public void requestLocation(final String str, boolean z, boolean z2, final IAiAppLocationIoc.LocationListener locationListener) {
        if (locationListener != null) {
            com.baidu.adp.lib.d.a.iX().a(!z, z2, new a.InterfaceC0017a() { // from class: com.baidu.tieba.aiapps.apps.i.a.2
                @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
                public void b(int i, String str2, Address address) {
                    if ("bd09ll".equals(str)) {
                        locationListener.onSuccess(a.this.a(str, address));
                        return;
                    }
                    CustomMessageTask customMessageTask = (CustomMessageTask) MessageManager.getInstance().findTask(2921363);
                    if (customMessageTask == null) {
                        locationListener.onFailed(-1);
                        return;
                    }
                    try {
                        CustomMessageTask.CustomRunnable<?> runnable = customMessageTask.getRunnable();
                        Bundle bundle = new Bundle();
                        bundle.putString("coorType", str);
                        bundle.putParcelable(Headers.LOCATION, address);
                        CustomResponsedMessage<?> run = runnable.run(new CustomMessage<>(2921363, bundle));
                        if (run == null) {
                            locationListener.onFailed(-1);
                        } else {
                            locationListener.onSuccess(a.this.a(str, (Address) run.getData()));
                        }
                    } catch (Exception e) {
                        locationListener.onFailed(-1);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LocationResult a(String str, Address address) {
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
        return new LocationResult(str, address.getLongitude(), address.getLatitude(), f, 0.0d, d, address.getCountryName(), address.getCountryCode(), address.getLocality(), str2, str3, "", str4, str5);
    }
}
