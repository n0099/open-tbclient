package com.baidu.tieba.im.live.room;

import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        if (aVar != null && str != null) {
            headImageView = this.a.c;
            if (str.equals(headImageView.getTag())) {
                headImageView2 = this.a.c;
                aVar.a(headImageView2);
            }
        }
    }
}
