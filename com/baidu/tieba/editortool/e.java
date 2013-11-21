package com.baidu.tieba.editortool;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FaceView f1229a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FaceView faceView) {
        this.f1229a = faceView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        int i3;
        com.baidu.tieba.im.chat.m mVar;
        com.baidu.tieba.im.chat.m mVar2;
        h hVar;
        h hVar2;
        h hVar3;
        h hVar4;
        if (i % 27 != 0 || i == 0) {
            i2 = this.f1229a.f1223a;
            i3 = this.f1229a.f1223a;
            int i4 = ((((i2 - 1) * 28) + i) - i3) + 1;
            mVar = this.f1229a.d;
            String a2 = mVar.a(i4);
            mVar2 = this.f1229a.d;
            Bitmap b = mVar2.b(i4);
            if (a2 != null && b != null) {
                hVar = this.f1229a.k;
                if (hVar != null) {
                    g gVar = new g(this.f1229a);
                    gVar.a(a2);
                    gVar.a(b);
                    hVar2 = this.f1229a.k;
                    hVar2.a(20, gVar);
                    return;
                }
                return;
            }
            return;
        }
        g gVar2 = new g(this.f1229a);
        hVar3 = this.f1229a.k;
        if (hVar3 != null) {
            hVar4 = this.f1229a.k;
            hVar4.a(21, gVar2);
        }
    }
}
