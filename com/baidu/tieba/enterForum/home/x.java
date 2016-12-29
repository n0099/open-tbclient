package com.baidu.tieba.enterForum.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends CustomMessageListener {
    final /* synthetic */ l bqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(l lVar, int i) {
        super(i);
        this.bqi = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        com.baidu.tieba.enterForum.c.c cVar3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001391) {
            cVar = this.bqi.bpR;
            if (cVar.Tv() != null) {
                cVar2 = this.bqi.bpR;
                com.baidu.tieba.enterForum.b.i SJ = cVar2.Tv().SJ();
                if (SJ == null || SJ.SU() == null || SJ.SU().size() == 0) {
                    cVar3 = this.bqi.bpR;
                    SJ = cVar3.Tv().SI();
                }
                bb bbVar = (SJ == null || SJ.SU() == null || SJ.SU().size() == 0) ? null : SJ.SU().get(0);
                if (bbVar != null) {
                    String pS = bbVar.pS();
                    String link = bbVar.getLink();
                    if (!StringUtils.isNull(pS) && !StringUtils.isNull(link)) {
                        View inflate = LayoutInflater.from(this.bqi.aVu.getBaseContext()).inflate(r.h.customer_enterforum_banner, (ViewGroup) null, true);
                        ImageView imageView = (ImageView) inflate.findViewById(r.g.bc_banner_cancel);
                        TbImageView tbImageView = (TbImageView) inflate.findViewById(r.g.bc_banner);
                        com.baidu.tieba.recapp.l.a(bbVar.pJ(), (TbImageView) inflate.findViewById(r.g.bc_advert), bbVar.re(), com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getContext(), r.e.ds26));
                        ar.c(imageView, r.f.icon_close_interstitial);
                        imageView.setOnClickListener(new y(this, inflate));
                        tbImageView.c(pS, 10, false);
                        tbImageView.setOnClickListener(new z(this, link));
                        this.bqi.bpQ.ab(inflate);
                        this.bqi.bpU = true;
                    }
                }
            }
        }
    }
}
