package com.baidu.tieba.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ ab apP;
    private final /* synthetic */ af apQ;
    private final /* synthetic */ ImageFileInfo apR;
    private final /* synthetic */ p apS;
    private final /* synthetic */ ag apT;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar, af afVar, p pVar, ImageFileInfo imageFileInfo, int i, ag agVar) {
        this.apP = abVar;
        this.apQ = afVar;
        this.apS = pVar;
        this.apR = imageFileInfo;
        this.val$position = i;
        this.apT = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        aa aaVar2;
        AlbumActivity albumActivity;
        aaVar = this.apP.apO;
        if (aaVar != null && this.apQ.apU) {
            boolean isAdded = this.apS.isAdded(this.apR);
            aaVar2 = this.apP.apO;
            if (aaVar2.onClick(this.val$position, this.apR, !isAdded)) {
                if (!isAdded) {
                    ax.i(this.apT.apW, com.baidu.tieba.v.btn_choose_photo_s);
                    albumActivity = this.apP.aoO;
                    this.apT.apW.startAnimation(AnimationUtils.loadAnimation(albumActivity.getPageContext().getPageActivity(), com.baidu.tieba.q.album_choose_icon));
                    return;
                }
                ax.i(this.apT.apW, com.baidu.tieba.v.btn_choose_photo_n);
            }
        }
    }
}
