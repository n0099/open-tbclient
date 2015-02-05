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
        i = this.this$0.Pj;
        if (i != 0) {
            str = TbConfig.GROUP_HEAD_FILE;
        }
        editHeadsImageView = this.this$0.Pi;
        i2 = this.this$0.Pj;
        Bitmap bb = editHeadsImageView.bb(i2 == 0);
        if (bb == null) {
            return;
        }
        b = this.this$0.b(str, bb);
        if (b) {
            i3 = this.this$0.Pj;
            if (i3 == 0) {
                this.this$0.re();
                return;
            }
            com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(com.baidu.tbadk.core.util.s.cd(TbConfig.GROUP_HEAD_FILE), "head");
            aVar.wd();
            aVar.a(new e(this));
            aVar.wb();
            this.this$0.showLoadingDialog(this.this$0.getPageContext().getString(com.baidu.tieba.z.uploading));
        }
    }
}
