package com.baidu.tieba.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    private final /* synthetic */ int BF;
    final /* synthetic */ ab ait;
    private final /* synthetic */ af aiu;
    private final /* synthetic */ ImageFileInfo aiv;
    private final /* synthetic */ p aiw;
    private final /* synthetic */ ag aix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar, af afVar, p pVar, ImageFileInfo imageFileInfo, int i, ag agVar) {
        this.ait = abVar;
        this.aiu = afVar;
        this.aiw = pVar;
        this.aiv = imageFileInfo;
        this.BF = i;
        this.aix = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        aa aaVar2;
        AlbumActivity albumActivity;
        aaVar = this.ait.ais;
        if (aaVar != null && this.aiu.aiy) {
            boolean isAdded = this.aiw.isAdded(this.aiv);
            aaVar2 = this.ait.ais;
            if (aaVar2.onClick(this.BF, this.aiv, !isAdded)) {
                if (!isAdded) {
                    aw.h(this.aix.aiA, com.baidu.tieba.u.btn_choose_photo_s);
                    albumActivity = this.ait.ahq;
                    this.aix.aiA.startAnimation(AnimationUtils.loadAnimation(albumActivity, com.baidu.tieba.p.album_choose_icon));
                    return;
                }
                aw.h(this.aix.aiA, com.baidu.tieba.u.btn_choose_photo_n);
            }
        }
    }
}
