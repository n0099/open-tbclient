package com.baidu.tieba.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tieba.img.ImageFileInfo;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements ak {
    final /* synthetic */ ag a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ag agVar) {
        this.a = agVar;
    }

    @Override // com.baidu.tieba.album.ak
    public void a() {
    }

    @Override // com.baidu.tieba.album.ak
    public void a(List<ImageFileInfo> list, String str) {
        AlbumActivity albumActivity;
        TextView textView;
        if (list == null || list.size() == 0) {
            albumActivity = this.a.b;
            albumActivity.d(0);
            this.a.o = false;
            return;
        }
        this.a.o = true;
        this.a.n = list;
        this.a.a(list);
        if (!TextUtils.isEmpty(str)) {
            textView = this.a.h;
            textView.setText(str);
        }
    }
}
