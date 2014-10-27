package com.baidu.tieba.album;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
import java.util.Map;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.imageManager.d {
    private final /* synthetic */ int BF;
    final /* synthetic */ h ahF;
    private final /* synthetic */ ViewGroup ahG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, ViewGroup viewGroup, int i) {
        this.ahF = hVar;
        this.ahG = viewGroup;
        this.BF = i;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        Map map;
        TbImageView tbImageView = (TbImageView) this.ahG.findViewWithTag(str);
        if (tbImageView != null && aVar != null) {
            tbImageView.invalidate();
            map = this.ahF.ahE;
            map.put(Integer.valueOf(this.BF), true);
        } else if (tbImageView != null) {
            tbImageView.setDefaultResource(com.baidu.tieba.u.pic_baidu_logo_photo);
            tbImageView.invalidate();
        }
    }
}
