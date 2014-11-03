package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ AbsMsgImageActivity aNO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.aNO = absMsgImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        Intent intent = new Intent();
        i = this.aNO.mIndex;
        intent.putExtra(ImageViewerConfig.INDEX, i);
        this.aNO.setResult(-1, intent);
        this.aNO.finish();
    }
}
