package com.baidu.tieba.im.searchGroup;

import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1702a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f1702a = dVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        SearchGroupActivity searchGroupActivity;
        if (!z) {
            searchGroupActivity = this.f1702a.b;
            UtilHelper.a(searchGroupActivity, view);
        }
    }
}
