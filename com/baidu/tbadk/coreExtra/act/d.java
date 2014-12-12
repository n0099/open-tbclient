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
        boolean b;
        int i3;
        String str = TbConfig.PERSON_HEAD_FILE;
        i = this.this$0.OI;
        if (i != 0) {
            str = TbConfig.GROUP_HEAD_FILE;
        }
        editHeadsImageView = this.this$0.OH;
        i2 = this.this$0.OI;
        Bitmap aZ = editHeadsImageView.aZ(i2 == 0);
        if (aZ == null) {
            return;
        }
        b = this.this$0.b(str, aZ);
        if (b) {
            i3 = this.this$0.OI;
            if (i3 == 0) {
                this.this$0.qZ();
                return;
            }
            com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(com.baidu.tbadk.core.util.s.ci(TbConfig.GROUP_HEAD_FILE), "head");
            aVar.vQ();
            aVar.a(new e(this));
            aVar.vO();
            this.this$0.showLoadingDialog(this.this$0.getPageContext().getString(com.baidu.tieba.z.uploading));
        }
    }
}
