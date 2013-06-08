package com.baidu.tieba;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends com.baidu.adp.lib.a.a {
    final /* synthetic */ TiebaApplication a;

    private ap(TiebaApplication tiebaApplication) {
        this.a = tiebaApplication;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ap(TiebaApplication tiebaApplication, ap apVar) {
        this(tiebaApplication);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public Address a(Location... locationArr) {
        List<Address> list;
        Geocoder geocoder = new Geocoder(TiebaApplication.d(), Locale.getDefault());
        if (locationArr == null || locationArr.length < 1) {
            return null;
        }
        Location location = locationArr[0];
        try {
            list = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
        } catch (IOException e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "ReverseGeocodingTask_doInBackground", e.toString());
            list = null;
        } catch (IllegalArgumentException e2) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "ReverseGeocodingTask_doInBackground", e2.toString());
            list = null;
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        Address address = list.get(0);
        StringBuffer stringBuffer = new StringBuffer();
        if (address.getSubLocality() == null || address.getThoroughfare() == null) {
            stringBuffer.append(address.getLocality());
        }
        stringBuffer.append(address.getSubLocality());
        stringBuffer.append(address.getThoroughfare());
        address.setAddressLine(0, stringBuffer.toString());
        return address;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        cancel(true);
        this.a.G = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(Address address) {
        super.a((Object) address);
        if (address != null) {
            this.a.aK();
            this.a.a(0, "", address);
            this.a.F = address;
        }
        this.a.G = null;
    }
}
