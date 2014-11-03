package com.baidu.tbadk.coreExtra.act;

import android.graphics.Bitmap;
import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.widget.EditHeadsImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ EditHeadActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(EditHeadActivity editHeadActivity) {
        this.this$0 = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        EditHeadsImageView editHeadsImageView;
        int i2;
        boolean a;
        int i3;
        String str = TbConfig.PERSON_HEAD_FILE;
        i = this.this$0.JB;
        if (i != 0) {
            str = TbConfig.GROUP_HEAD_FILE;
        }
        editHeadsImageView = this.this$0.JA;
        i2 = this.this$0.JB;
        Bitmap aK = editHeadsImageView.aK(i2 == 0);
        if (aK == null) {
            return;
        }
        a = this.this$0.a(str, aK);
        if (a) {
            i3 = this.this$0.JB;
            if (i3 == 0) {
                this.this$0.nX();
                return;
            }
            com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(com.baidu.tbadk.core.util.s.bq(TbConfig.GROUP_HEAD_FILE), "head");
            aVar.sn();
            aVar.a(new e(this));
            aVar.sl();
            this.this$0.showLoadingDialog(this.this$0.getString(com.baidu.tieba.y.uploading));
        }
    }
}
