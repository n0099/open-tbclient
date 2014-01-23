package com.baidu.tieba;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi extends BdAsyncTask<Location, Void, Address> {
    final /* synthetic */ TiebaApplication a;

    private bi(TiebaApplication tiebaApplication) {
        this.a = tiebaApplication;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bi(TiebaApplication tiebaApplication, ay ayVar) {
        this(tiebaApplication);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Address a(Location... locationArr) {
        List<Address> list;
        Geocoder geocoder = new Geocoder(TiebaApplication.h(), Locale.getDefault());
        if (locationArr == null || locationArr.length < 1) {
            return null;
        }
        Location location = locationArr[0];
        try {
            list = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
        } catch (IOException e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "ReverseGeocodingTask_doInBackground", e.toString());
            list = null;
        } catch (IllegalArgumentException e2) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "ReverseGeocodingTask_doInBackground", e2.toString());
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

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        cancel(true);
        this.a.F = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Address address) {
        super.a((bi) address);
        if (address != null) {
            this.a.aN();
            this.a.a(0, "", address);
            this.a.E = address;
        }
        this.a.F = null;
    }
}
