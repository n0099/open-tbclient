package com.baidu.tieba.album;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ u a;
    private final /* synthetic */ ImageFileInfo b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar, ImageFileInfo imageFileInfo) {
        this.a = uVar;
        this.b = imageFileInfo;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        TbImageView a;
        if (bVar != null) {
            linearLayout = this.a.i;
            int childCount = linearLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                linearLayout2 = this.a.i;
                if (linearLayout2.getChildAt(i) != null) {
                    linearLayout3 = this.a.i;
                    if (linearLayout3.getChildAt(i) instanceof FrameLayout) {
                        linearLayout4 = this.a.i;
                        a = this.a.a((FrameLayout) linearLayout4.getChildAt(i));
                        if (a != null && a.getTag() != null && a.getTag().equals(this.b.toCachedKey(false))) {
                            bVar.a(a);
                            return;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
    }
}
