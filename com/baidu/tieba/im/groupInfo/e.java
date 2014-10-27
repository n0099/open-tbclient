package com.baidu.tieba.im.groupInfo;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ GroupImageActivity bah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(GroupImageActivity groupImageActivity) {
        this.bah = groupImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        Intent intent = new Intent();
        i = this.bah.mIndex;
        intent.putExtra(ImageViewerConfig.INDEX, i);
        this.bah.setResult(-1, intent);
        this.bah.finish();
    }
}
