package com.baidu.tieba.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.baidu.tieba.img.ImageFileInfo;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ aa a;
    private final /* synthetic */ ae b;
    private final /* synthetic */ p c;
    private final /* synthetic */ ImageFileInfo d;
    private final /* synthetic */ int e;
    private final /* synthetic */ int f;
    private final /* synthetic */ af g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(aa aaVar, ae aeVar, p pVar, ImageFileInfo imageFileInfo, int i, int i2, af afVar) {
        this.a = aaVar;
        this.b = aeVar;
        this.c = pVar;
        this.d = imageFileInfo;
        this.e = i;
        this.f = i2;
        this.g = afVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        AlbumActivity albumActivity;
        zVar = this.a.f;
        if (zVar != null && this.b.a) {
            boolean c = this.c.c(this.d);
            zVar2 = this.a.f;
            if (zVar2.onClick(this.e, this.d, !c)) {
                if (!c) {
                    if (this.f == 1) {
                        this.g.b.setBackgroundResource(R.drawable.btn_choose_photo_s_1);
                    } else {
                        this.g.b.setBackgroundResource(R.drawable.btn_choose_photo_s);
                    }
                    albumActivity = this.a.b;
                    this.g.b.startAnimation(AnimationUtils.loadAnimation(albumActivity, R.anim.album_choose_icon));
                } else if (this.f == 1) {
                    this.g.b.setBackgroundResource(R.drawable.btn_choose_photo_n_1);
                } else {
                    this.g.b.setBackgroundResource(R.drawable.btn_choose_photo_n);
                }
            }
        }
    }
}
