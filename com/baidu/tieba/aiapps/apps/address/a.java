package com.baidu.tieba.aiapps.apps.address;

import android.content.Context;
import android.content.Intent;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppChooseAddressIoc;
/* loaded from: classes4.dex */
public class a implements IAiAppChooseAddressIoc {
    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppChooseAddressIoc
    public Intent getActivityIntent(Context context) {
        return new Intent(context, DeliveryListActivity.class);
    }
}
