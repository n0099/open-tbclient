package com.baidu.tieba.im.frsgroup;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f1703a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.f1703a = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MembersActivity membersActivity;
        membersActivity = this.f1703a.f1702a;
        membersActivity.finish();
    }
}
