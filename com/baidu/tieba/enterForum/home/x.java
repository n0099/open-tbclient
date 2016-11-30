package com.baidu.tieba.enterForum.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends CustomMessageListener {
    final /* synthetic */ l bKe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(l lVar, int i) {
        super(i);
        this.bKe = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        com.baidu.tieba.enterForum.c.c cVar3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001398) {
            cVar = this.bKe.bJN;
            if (cVar.Zi() != null) {
                cVar2 = this.bKe.bJN;
                com.baidu.tieba.enterForum.b.i Yy = cVar2.Zi().Yy();
                if (Yy == null || Yy.YJ() == null || Yy.YJ().size() == 0) {
                    cVar3 = this.bKe.bJN;
                    Yy = cVar3.Zi().Yx();
                }
                bf bfVar = (Yy == null || Yy.YJ() == null || Yy.YJ().size() == 0) ? null : Yy.YJ().get(0);
                if (bfVar != null) {
                    String pR = bfVar.pR();
                    String link = bfVar.getLink();
                    if (!StringUtils.isNull(pR) && !StringUtils.isNull(link)) {
                        View inflate = LayoutInflater.from(this.bKe.aWd.getBaseContext()).inflate(r.h.customer_enterforum_banner, (ViewGroup) null, true);
                        ImageView imageView = (ImageView) inflate.findViewById(r.g.bc_banner_cancel);
                        TbImageView tbImageView = (TbImageView) inflate.findViewById(r.g.bc_banner);
                        com.baidu.tieba.recapp.g.a(bfVar.pI(), (TbImageView) inflate.findViewById(r.g.bc_advert), bfVar.rp(), com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getContext(), r.e.ds26));
                        at.c(imageView, r.f.icon_close_interstitial);
                        imageView.setOnClickListener(new y(this, inflate));
                        tbImageView.c(pR, 10, false);
                        tbImageView.setOnClickListener(new z(this, link));
                        this.bKe.bJM.ab(inflate);
                        this.bKe.bJQ = true;
                    }
                }
            }
        }
    }
}
