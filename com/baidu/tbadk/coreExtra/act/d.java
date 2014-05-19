package com.baidu.tbadk.coreExtra.act;

import android.graphics.Bitmap;
import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.widget.EditHeadsImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ EditHeadActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        EditHeadsImageView editHeadsImageView;
        int i2;
        boolean a;
        int i3;
        String str = TbConfig.PERSON_HEAD_FILE;
        i = this.a.i;
        if (i != 0) {
            str = TbConfig.GROUP_HEAD_FILE;
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
                this.a.d();
                return;
            }
            com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(com.baidu.tbadk.core.util.x.c(TbConfig.GROUP_HEAD_FILE), "head");
            aVar.d();
            aVar.a((com.baidu.tbadk.img.d) new e(this));
            aVar.a();
            this.a.showLoadingDialog(this.a.getString(com.baidu.tieba.u.uploading));
        }
    }
}
