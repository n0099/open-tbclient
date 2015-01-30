package com.baidu.tieba.album;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
import java.util.Map;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.imageManager.d {
    private final /* synthetic */ int FV;
    final /* synthetic */ h aqc;
    private final /* synthetic */ ViewGroup aqd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, ViewGroup viewGroup, int i) {
        this.aqc = hVar;
        this.aqd = viewGroup;
        this.FV = i;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        Map map;
        TbImageView tbImageView = (TbImageView) this.aqd.findViewWithTag(str);
        if (tbImageView != null && aVar != null) {
            tbImageView.invalidate();
            map = this.aqc.aqb;
            map.put(Integer.valueOf(this.FV), true);
        } else if (tbImageView != null) {
            tbImageView.setDefaultResource(com.baidu.tieba.v.pic_baidu_logo_photo);
            tbImageView.invalidate();
        }
    }
}
