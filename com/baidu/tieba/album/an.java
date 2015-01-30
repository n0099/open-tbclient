package com.baidu.tieba.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements aq {
    final /* synthetic */ ah ari;
    private final /* synthetic */ String arj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ah ahVar, String str) {
        this.ari = ahVar;
        this.arj = str;
    }

    @Override // com.baidu.tieba.album.aq
    public void jG() {
    }

    @Override // com.baidu.tieba.album.aq
    public void a(List<a> list, List<ImageFileInfo> list2, String str) {
        TextView textView;
        boolean z;
        AlbumActivity albumActivity;
        TextView textView2;
        n nVar;
        n nVar2;
        if (!this.arj.equals("-1")) {
            textView = this.ari.mTitleText;
            textView.setText(str);
            this.ari.BZ();
            z = false;
        } else {
            a aVar = new a();
            aVar.eT("-1");
            albumActivity = this.ari.apM;
            String string = albumActivity.getPageContext().getString(com.baidu.tieba.z.write_album_all);
            aVar.setName(string);
            aVar.eU(String.valueOf(list2.size()));
            if (list2.size() > 0) {
                aVar.d(list2.get(0));
            }
            list.add(0, aVar);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setAlbumnId("-2");
            list2.add(0, imageFileInfo);
            textView2 = this.ari.mTitleText;
            textView2.setText(string);
            nVar = this.ari.apH;
            nVar.E(list);
            nVar2 = this.ari.apH;
            nVar2.F(list2);
            z = true;
        }
        this.ari.setData(list2, z);
    }
}
