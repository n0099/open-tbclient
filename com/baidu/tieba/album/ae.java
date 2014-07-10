package com.baidu.tieba.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ ab a;
    private final /* synthetic */ af b;
    private final /* synthetic */ p c;
    private final /* synthetic */ ImageFileInfo d;
    private final /* synthetic */ int e;
    private final /* synthetic */ int f;
    private final /* synthetic */ ag g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar, af afVar, p pVar, ImageFileInfo imageFileInfo, int i, int i2, ag agVar) {
        this.a = abVar;
        this.b = afVar;
        this.c = pVar;
        this.d = imageFileInfo;
        this.e = i;
        this.f = i2;
        this.g = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        aa aaVar2;
        AlbumActivity albumActivity;
        aaVar = this.a.f;
        if (aaVar != null && this.b.a) {
            boolean c = this.c.c(this.d);
            aaVar2 = this.a.f;
            if (aaVar2.onClick(this.e, this.d, !c)) {
                if (!c) {
                    if (this.f == 1) {
                        this.g.b.setBackgroundResource(com.baidu.tieba.u.btn_choose_photo_s_1);
                    } else {
                        this.g.b.setBackgroundResource(com.baidu.tieba.u.btn_choose_photo_s);
                    }
                    albumActivity = this.a.b;
                    this.g.b.startAnimation(AnimationUtils.loadAnimation(albumActivity, com.baidu.tieba.p.album_choose_icon));
                } else if (this.f == 1) {
                    this.g.b.setBackgroundResource(com.baidu.tieba.u.btn_choose_photo_n_1);
                } else {
                    this.g.b.setBackgroundResource(com.baidu.tieba.u.btn_choose_photo_n);
                }
            }
        }
    }
}
