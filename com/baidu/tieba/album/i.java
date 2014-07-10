package com.baidu.tieba.album;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
import java.util.Map;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ h a;
    private final /* synthetic */ ViewGroup b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, ViewGroup viewGroup, int i) {
        this.a = hVar;
        this.b = viewGroup;
        this.c = i;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        Map map;
        TbImageView tbImageView = (TbImageView) this.b.findViewWithTag(str);
        if (tbImageView != null && aVar != null) {
            tbImageView.invalidate();
            map = this.a.f;
            map.put(Integer.valueOf(this.c), true);
        } else if (tbImageView != null) {
            tbImageView.setDefaultResource(com.baidu.tieba.u.pic_baidu_logo_photo);
            tbImageView.setNightDefaultResource(com.baidu.tieba.u.pic_baidu_logo_photo);
            tbImageView.invalidate();
        }
    }
}
