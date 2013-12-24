package com.baidu.tieba.editortool;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.chat.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements AdapterView.OnItemClickListener {
    final /* synthetic */ FaceView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FaceView faceView) {
        this.a = faceView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        int i3;
        q qVar;
        q qVar2;
        h hVar;
        h hVar2;
        h hVar3;
        h hVar4;
        if (i % 27 != 0 || i == 0) {
            i2 = this.a.a;
            i3 = this.a.a;
            int i4 = ((((i2 - 1) * 28) + i) - i3) + 1;
            qVar = this.a.d;
            String a = qVar.a(i4);
            qVar2 = this.a.d;
            Bitmap b = qVar2.b(i4);
            if (a != null && b != null) {
                hVar = this.a.k;
                if (hVar != null) {
                    g gVar = new g(this.a);
                    gVar.a(a);
                    gVar.a(b);
                    hVar2 = this.a.k;
                    hVar2.a(20, gVar);
                    return;
                }
                return;
            }
            return;
        }
        g gVar2 = new g(this.a);
        hVar3 = this.a.k;
        if (hVar3 != null) {
            hVar4 = this.a.k;
            hVar4.a(21, gVar2);
        }
    }
}
