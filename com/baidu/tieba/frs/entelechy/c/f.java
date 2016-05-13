package com.baidu.tieba.frs.entelechy.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ a bpG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.bpG = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ax axVar;
        ax axVar2;
        TextureVideoView textureVideoView;
        boolean Ka;
        ax axVar3;
        TextureVideoView textureVideoView2;
        boolean z;
        TextureVideoView textureVideoView3;
        com.baidu.tieba.play.a aVar;
        com.baidu.tieba.play.a aVar2;
        ax axVar4;
        ax axVar5;
        ax axVar6;
        TextureVideoView textureVideoView4;
        axVar = this.bpG.aab;
        if (axVar != null) {
            axVar2 = this.bpG.aab;
            if (axVar2.rb() != null) {
                textureVideoView = this.bpG.aPL;
                if (textureVideoView == null || com.baidu.tbadk.core.view.at.vE().vH() > 0) {
                    return;
                }
                Ka = this.bpG.Ka();
                if (Ka && com.baidu.tbadk.core.view.at.vE().vI() && TbadkCoreApplication.m11getInst().getVideoAutoPlay() == 0) {
                    axVar3 = this.bpG.aab;
                    String str = axVar3.rb().video_url;
                    textureVideoView2 = this.bpG.aPL;
                    if (textureVideoView2.isPlaying() && str != null) {
                        textureVideoView4 = this.bpG.aPL;
                        if (str.equals(textureVideoView4.getVideoPath())) {
                            z = true;
                            if (StringUtils.isNull(str) && !z && com.baidu.tbadk.core.view.at.vE().vH() == 0) {
                                this.bpG.e(true, 2);
                                textureVideoView3 = this.bpG.aPL;
                                textureVideoView3.setVideoPath(str);
                                aVar = this.bpG.aPY;
                                if (aVar != null) {
                                    aVar2 = this.bpG.aPY;
                                    axVar4 = this.bpG.aab;
                                    String str2 = axVar4.rb().video_md5;
                                    axVar5 = this.bpG.aab;
                                    String tid = axVar5.getTid();
                                    axVar6 = this.bpG.aab;
                                    aVar2.A(str2, tid, new StringBuilder(String.valueOf(axVar6.getFid())).toString());
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
