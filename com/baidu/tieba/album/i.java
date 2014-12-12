package com.baidu.tieba.album;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
import java.util.Map;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ h apd;
    private final /* synthetic */ ViewGroup ape;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, ViewGroup viewGroup, int i) {
        this.apd = hVar;
        this.ape = viewGroup;
        this.val$position = i;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        Map map;
        TbImageView tbImageView = (TbImageView) this.ape.findViewWithTag(str);
        if (tbImageView != null && aVar != null) {
            tbImageView.invalidate();
            map = this.apd.apc;
            map.put(Integer.valueOf(this.val$position), true);
        } else if (tbImageView != null) {
            tbImageView.setDefaultResource(com.baidu.tieba.v.pic_baidu_logo_photo);
            tbImageView.invalidate();
        }
    }
}
