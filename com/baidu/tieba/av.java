package com.baidu.tieba;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.be;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends BdAsyncTask<Location, Void, Address> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaApplication f1072a;

    private av(TiebaApplication tiebaApplication) {
        this.f1072a = tiebaApplication;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ av(TiebaApplication tiebaApplication, aq aqVar) {
        this(tiebaApplication);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Address a(Location... locationArr) {
        List<Address> list;
        Geocoder geocoder = new Geocoder(TiebaApplication.g(), Locale.getDefault());
        if (locationArr == null || locationArr.length < 1) {
            return null;
        }
        Location location = locationArr[0];
        try {
            list = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
        } catch (IOException e) {
            be.b(getClass().getName(), "ReverseGeocodingTask_doInBackground", e.toString());
            list = null;
        } catch (IllegalArgumentException e2) {
            be.b(getClass().getName(), "ReverseGeocodingTask_doInBackground", e2.toString());
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
        this.f1072a.E = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Address address) {
        super.a((av) address);
        if (address != null) {
            this.f1072a.aO();
            this.f1072a.a(0, "", address);
            this.f1072a.D = address;
        }
        this.f1072a.E = null;
    }
}
