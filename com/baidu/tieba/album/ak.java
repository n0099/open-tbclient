package com.baidu.tieba.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements al {
    final /* synthetic */ ah aiK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ah ahVar) {
        this.aiK = ahVar;
    }

    @Override // com.baidu.tieba.album.al
    public void hL() {
    }

    @Override // com.baidu.tieba.album.al
    public void a(List<ImageFileInfo> list, String str) {
        AlbumActivity albumActivity;
        TextView textView;
        if (list == null || list.size() == 0) {
            albumActivity = this.aiK.ahq;
            albumActivity.dK(0);
            this.aiK.aiG = false;
            return;
        }
        this.aiK.aiG = true;
        this.aiK.Wx = list;
        this.aiK.setData(list);
        if (!TextUtils.isEmpty(str)) {
            textView = this.aiK.JM;
            textView.setText(str);
        }
    }
}
