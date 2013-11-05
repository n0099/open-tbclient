package com.baidu.tieba.im.groupUpdates;

import android.widget.CompoundButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1630a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.f1630a = fVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        UpdatesActivity updatesActivity;
        UpdatesItemData updatesItemData;
        updatesActivity = this.f1630a.l;
        updatesItemData = this.f1630a.m;
        updatesActivity.a(compoundButton, z, updatesItemData);
    }
}
