package com.baidu.tieba.im.friend;

import android.view.ViewGroup;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ String a;
    final /* synthetic */ r b;
    final /* synthetic */ o c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, String str, r rVar) {
        this.c = oVar;
        this.a = str;
        this.b = rVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        HeadImageView headImageView;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        try {
            viewGroup = this.c.f;
            if (viewGroup != null) {
                viewGroup2 = this.c.f;
                headImageView = (HeadImageView) viewGroup2.findViewWithTag(this.a);
            } else {
                headImageView = this.b.b;
            }
        } catch (Exception e) {
            headImageView = this.b.b;
        }
        if (eVar != null) {
            headImageView.setImageBitmap(eVar.f());
        } else {
            headImageView.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.photo));
        }
        headImageView.invalidate();
    }
}
