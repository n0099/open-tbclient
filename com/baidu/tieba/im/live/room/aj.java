package com.baidu.tieba.im.live.room;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ah a;
    private final /* synthetic */ TbImageView b;
    private final /* synthetic */ View c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar, TbImageView tbImageView, View view) {
        this.a = ahVar;
        this.b = tbImageView;
        this.c = view;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && str.equals(this.b.getTag())) {
            this.c.setVisibility(0);
            this.b.setTag(null);
            this.b.f();
            aVar.a(this.b);
        }
    }
}
