package com.baidu.tieba.album;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
import com.slidingmenu.lib.R;
import java.util.Map;
/* loaded from: classes.dex */
final class i implements com.baidu.tbadk.imageManager.d {
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
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        Map map;
        TbImageView tbImageView = (TbImageView) this.b.findViewWithTag(str);
        if (tbImageView != null && bVar != null) {
            tbImageView.invalidate();
            map = this.a.f;
            map.put(Integer.valueOf(this.c), true);
        } else if (tbImageView != null) {
            tbImageView.setDefaultResource(R.drawable.pic_baidu_logo_photo);
            tbImageView.setNightDefaultResource(R.drawable.pic_baidu_logo_photo);
            tbImageView.invalidate();
        }
    }
}
