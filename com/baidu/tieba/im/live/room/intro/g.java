package com.baidu.tieba.im.live.room.intro;

import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.a = eVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        if (aVar != null && str != null) {
            headImageView = this.a.g;
            if (str.equals(headImageView.getTag())) {
                headImageView2 = this.a.g;
                aVar.a(headImageView2);
            }
        }
    }
}
