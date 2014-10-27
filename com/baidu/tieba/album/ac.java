package com.baidu.tieba.album;

import android.view.ViewGroup;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class ac implements com.baidu.tbadk.imageManager.d {
    private final /* synthetic */ ViewGroup ahK;
    final /* synthetic */ ab ait;
    private final /* synthetic */ af aiu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar, ViewGroup viewGroup, af afVar) {
        this.ait = abVar;
        this.ahK = viewGroup;
        this.aiu = afVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.ahK.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        } else {
            this.aiu.aiy = false;
        }
    }
}
