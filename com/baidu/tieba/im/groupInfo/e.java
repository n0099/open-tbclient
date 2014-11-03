package com.baidu.tieba.im.groupInfo;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ GroupImageActivity baw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(GroupImageActivity groupImageActivity) {
        this.baw = groupImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        Intent intent = new Intent();
        i = this.baw.mIndex;
        intent.putExtra(ImageViewerConfig.INDEX, i);
        this.baw.setResult(-1, intent);
        this.baw.finish();
    }
}
