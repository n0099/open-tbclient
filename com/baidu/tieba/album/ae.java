package com.baidu.tieba.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    private final /* synthetic */ int FV;
    final /* synthetic */ aa aqQ;
    private final /* synthetic */ af aqR;
    private final /* synthetic */ ImageFileInfo aqS;
    private final /* synthetic */ n aqT;
    private final /* synthetic */ ag aqU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(aa aaVar, af afVar, n nVar, ImageFileInfo imageFileInfo, int i, ag agVar) {
        this.aqQ = aaVar;
        this.aqR = afVar;
        this.aqT = nVar;
        this.aqS = imageFileInfo;
        this.FV = i;
        this.aqU = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        AlbumActivity albumActivity;
        zVar = this.aqQ.aqP;
        if (zVar != null && this.aqR.aqV) {
            boolean isAdded = this.aqT.isAdded(this.aqS);
            zVar2 = this.aqQ.aqP;
            if (zVar2.onClick(this.FV, this.aqS, !isAdded)) {
                if (!isAdded) {
                    bc.i(this.aqU.aqX, com.baidu.tieba.v.chx_camera_pic_s);
                    albumActivity = this.aqQ.apM;
                    this.aqU.aqX.startAnimation(AnimationUtils.loadAnimation(albumActivity.getPageContext().getPageActivity(), com.baidu.tieba.q.album_choose_icon));
                    return;
                }
                bc.i(this.aqU.aqX, com.baidu.tieba.v.chx_camera_pic_n);
            }
        }
    }
}
