package com.baidu.tieba.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    private final /* synthetic */ int FS;
    final /* synthetic */ aa aqN;
    private final /* synthetic */ af aqO;
    private final /* synthetic */ ImageFileInfo aqP;
    private final /* synthetic */ n aqQ;
    private final /* synthetic */ ag aqR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(aa aaVar, af afVar, n nVar, ImageFileInfo imageFileInfo, int i, ag agVar) {
        this.aqN = aaVar;
        this.aqO = afVar;
        this.aqQ = nVar;
        this.aqP = imageFileInfo;
        this.FS = i;
        this.aqR = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        AlbumActivity albumActivity;
        zVar = this.aqN.aqM;
        if (zVar != null && this.aqO.aqS) {
            boolean isAdded = this.aqQ.isAdded(this.aqP);
            zVar2 = this.aqN.aqM;
            if (zVar2.onClick(this.FS, this.aqP, !isAdded)) {
                if (!isAdded) {
                    bc.i(this.aqR.aqU, com.baidu.tieba.v.chx_camera_pic_s);
                    albumActivity = this.aqN.apJ;
                    this.aqR.aqU.startAnimation(AnimationUtils.loadAnimation(albumActivity.getPageContext().getPageActivity(), com.baidu.tieba.q.album_choose_icon));
                    return;
                }
                bc.i(this.aqR.aqU, com.baidu.tieba.v.chx_camera_pic_n);
            }
        }
    }
}
