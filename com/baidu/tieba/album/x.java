package com.baidu.tieba.album;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ v apJ;
    private final /* synthetic */ ImageFileInfo apK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar, ImageFileInfo imageFileInfo) {
        this.apJ = vVar;
        this.apK = imageFileInfo;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        TbImageView a;
        if (aVar != null) {
            linearLayout = this.apJ.apC;
            int childCount = linearLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                linearLayout2 = this.apJ.apC;
                if (linearLayout2.getChildAt(i) != null) {
                    linearLayout3 = this.apJ.apC;
                    if (linearLayout3.getChildAt(i) instanceof FrameLayout) {
                        linearLayout4 = this.apJ.apC;
                        a = this.apJ.a((FrameLayout) linearLayout4.getChildAt(i));
                        if (a != null && a.getTag() != null && a.getTag().equals(this.apK.toCachedKey(false))) {
                            aVar.a(a);
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
