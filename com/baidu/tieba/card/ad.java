package com.baidu.tieba.card;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements Runnable {
    final /* synthetic */ z aQe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(z zVar) {
        this.aQe = zVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.card.a.n nVar;
        com.baidu.tieba.card.a.n nVar2;
        com.baidu.tieba.card.a.n nVar3;
        TextureVideoView textureVideoView;
        boolean Ka;
        com.baidu.tieba.card.a.n nVar4;
        TextureVideoView textureVideoView2;
        boolean z;
        TextureVideoView textureVideoView3;
        com.baidu.tieba.play.a aVar;
        com.baidu.tieba.play.a aVar2;
        com.baidu.tieba.card.a.n nVar5;
        com.baidu.tieba.card.a.n nVar6;
        com.baidu.tieba.card.a.n nVar7;
        TextureVideoView textureVideoView4;
        nVar = this.aQe.aPR;
        if (nVar != null) {
            nVar2 = this.aQe.aPR;
            if (nVar2.aRZ != null) {
                nVar3 = this.aQe.aPR;
                if (nVar3.aRZ.rb() != null) {
                    textureVideoView = this.aQe.aPL;
                    if (textureVideoView == null || com.baidu.tbadk.core.view.at.vE().vH() > 0) {
                        return;
                    }
                    Ka = this.aQe.Ka();
                    if (Ka && com.baidu.tbadk.core.view.at.vE().vI() && TbadkCoreApplication.m11getInst().getVideoAutoPlay() == 0) {
                        nVar4 = this.aQe.aPR;
                        String str = nVar4.aRZ.rb().video_url;
                        textureVideoView2 = this.aQe.aPL;
                        if (textureVideoView2.isPlaying() && str != null) {
                            textureVideoView4 = this.aQe.aPL;
                            if (str.equals(textureVideoView4.getVideoPath())) {
                                z = true;
                                if (StringUtils.isNull(str) && !z && com.baidu.tbadk.core.view.at.vE().vH() == 0) {
                                    this.aQe.e(true, 2);
                                    textureVideoView3 = this.aQe.aPL;
                                    textureVideoView3.setVideoPath(str);
                                    aVar = this.aQe.aPY;
                                    if (aVar != null) {
                                        aVar2 = this.aQe.aPY;
                                        nVar5 = this.aQe.aPR;
                                        String str2 = nVar5.aRZ.rb().video_md5;
                                        nVar6 = this.aQe.aPR;
                                        String tid = nVar6.aRZ.getTid();
                                        nVar7 = this.aQe.aPR;
                                        aVar2.A(str2, tid, new StringBuilder(String.valueOf(nVar7.aRZ.getFid())).toString());
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                        z = false;
                        if (StringUtils.isNull(str)) {
                        }
                    }
                }
            }
        }
    }
}
