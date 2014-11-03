package com.baidu.tieba.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    private final /* synthetic */ int BG;
    final /* synthetic */ ab aiC;
    private final /* synthetic */ af aiD;
    private final /* synthetic */ ImageFileInfo aiE;
    private final /* synthetic */ p aiF;
    private final /* synthetic */ ag aiG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar, af afVar, p pVar, ImageFileInfo imageFileInfo, int i, ag agVar) {
        this.aiC = abVar;
        this.aiD = afVar;
        this.aiF = pVar;
        this.aiE = imageFileInfo;
        this.BG = i;
        this.aiG = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        aa aaVar2;
        AlbumActivity albumActivity;
        aaVar = this.aiC.aiB;
        if (aaVar != null && this.aiD.aiH) {
            boolean isAdded = this.aiF.isAdded(this.aiE);
            aaVar2 = this.aiC.aiB;
            if (aaVar2.onClick(this.BG, this.aiE, !isAdded)) {
                if (!isAdded) {
                    aw.h(this.aiG.aiJ, com.baidu.tieba.u.btn_choose_photo_s);
                    albumActivity = this.aiC.ahz;
                    this.aiG.aiJ.startAnimation(AnimationUtils.loadAnimation(albumActivity, com.baidu.tieba.p.album_choose_icon));
                    return;
                }
                aw.h(this.aiG.aiJ, com.baidu.tieba.u.btn_choose_photo_n);
            }
        }
    }
}
