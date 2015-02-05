package com.baidu.tieba.album;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
import java.util.Map;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.imageManager.d {
    private final /* synthetic */ int FS;
    final /* synthetic */ h apZ;
    private final /* synthetic */ ViewGroup aqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, ViewGroup viewGroup, int i) {
        this.apZ = hVar;
        this.aqa = viewGroup;
        this.FS = i;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        Map map;
        TbImageView tbImageView = (TbImageView) this.aqa.findViewWithTag(str);
        if (tbImageView != null && aVar != null) {
            tbImageView.invalidate();
            map = this.apZ.apY;
            map.put(Integer.valueOf(this.FS), true);
        } else if (tbImageView != null) {
            tbImageView.setDefaultResource(com.baidu.tieba.v.pic_baidu_logo_photo);
            tbImageView.invalidate();
        }
    }
}
