package com.baidu.tbadk.coreExtra.act;

import android.graphics.Bitmap;
import android.view.View;
import com.baidu.tbadk.widget.EditHeadsImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements View.OnClickListener {
    final /* synthetic */ EditHeadActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        EditHeadsImageView editHeadsImageView;
        int i2;
        boolean a;
        int i3;
        String str = "tieba_head_image";
        i = this.a.i;
        if (i != 0) {
            str = "tieba_group_image";
        }
        editHeadsImageView = this.a.g;
        i2 = this.a.i;
        Bitmap a2 = editHeadsImageView.a(i2 == 0);
        if (a2 == null) {
            return;
        }
        a = this.a.a(str, a2);
        if (a) {
            i3 = this.a.i;
            if (i3 == 0) {
                EditHeadActivity.o(this.a);
                return;
            }
            com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(com.baidu.tbadk.core.util.w.c("tieba_group_image"), "head");
            aVar.c();
            aVar.a(new e(this));
            aVar.a();
            this.a.showLoadingDialog(this.a.getString(com.baidu.tbadk.l.uploading));
        }
    }
}
