package com.baidu.tieba.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements al {
    final /* synthetic */ ah aiT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ah ahVar) {
        this.aiT = ahVar;
    }

    @Override // com.baidu.tieba.album.al
    public void hL() {
    }

    @Override // com.baidu.tieba.album.al
    public void a(List<ImageFileInfo> list, String str) {
        AlbumActivity albumActivity;
        TextView textView;
        if (list == null || list.size() == 0) {
            albumActivity = this.aiT.ahz;
            albumActivity.dK(0);
            this.aiT.aiP = false;
            return;
        }
        this.aiT.aiP = true;
        this.aiT.WB = list;
        this.aiT.setData(list);
        if (!TextUtils.isEmpty(str)) {
            textView = this.aiT.JN;
            textView.setText(str);
        }
    }
}
