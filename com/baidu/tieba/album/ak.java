package com.baidu.tieba.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements al {
    final /* synthetic */ ah aqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ah ahVar) {
        this.aqf = ahVar;
    }

    @Override // com.baidu.tieba.album.al
    public void jH() {
    }

    @Override // com.baidu.tieba.album.al
    public void a(List<ImageFileInfo> list, String str) {
        AlbumActivity albumActivity;
        TextView textView;
        if (list == null || list.size() == 0) {
            albumActivity = this.aqf.aoO;
            albumActivity.ee(0);
            this.aqf.aqb = false;
            return;
        }
        this.aqf.aqb = true;
        this.aqf.mList = list;
        this.aqf.setData(list);
        if (!TextUtils.isEmpty(str)) {
            textView = this.aqf.mTitle;
            textView.setText(str);
        }
    }
}
