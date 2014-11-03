package com.baidu.tieba.album;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
import java.util.Map;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.imageManager.d {
    private final /* synthetic */ int BG;
    final /* synthetic */ h ahO;
    private final /* synthetic */ ViewGroup ahP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, ViewGroup viewGroup, int i) {
        this.ahO = hVar;
        this.ahP = viewGroup;
        this.BG = i;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        Map map;
        TbImageView tbImageView = (TbImageView) this.ahP.findViewWithTag(str);
        if (tbImageView != null && aVar != null) {
            tbImageView.invalidate();
            map = this.ahO.ahN;
            map.put(Integer.valueOf(this.BG), true);
        } else if (tbImageView != null) {
            tbImageView.setDefaultResource(com.baidu.tieba.u.pic_baidu_logo_photo);
            tbImageView.invalidate();
        }
    }
}
