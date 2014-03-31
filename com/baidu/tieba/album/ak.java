package com.baidu.tieba.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ak implements al {
    final /* synthetic */ ah a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ah ahVar) {
        this.a = ahVar;
    }

    @Override // com.baidu.tieba.album.al
    public final void a(List<ImageFileInfo> list, String str) {
        AlbumActivity albumActivity;
        TextView textView;
        if (list == null || list.size() == 0) {
            albumActivity = this.a.a;
            albumActivity.e(0);
            this.a.n = false;
            return;
        }
        this.a.n = true;
        this.a.m = list;
        this.a.a(list);
        if (!TextUtils.isEmpty(str)) {
            textView = this.a.g;
            textView.setText(str);
        }
    }
}
