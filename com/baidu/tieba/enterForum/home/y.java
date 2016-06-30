package com.baidu.tieba.enterForum.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends CustomMessageListener {
    final /* synthetic */ k btA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(k kVar, int i) {
        super(i);
        this.btA = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        com.baidu.tieba.enterForum.c.c cVar3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001398) {
            cVar = this.btA.bth;
            if (cVar.Su() != null) {
                cVar2 = this.btA.bth;
                com.baidu.tieba.enterForum.b.i RK = cVar2.Su().RK();
                if (RK == null) {
                    cVar3 = this.btA.bth;
                    RK = cVar3.Su().RJ();
                }
                au auVar = (RK == null || RK.RU() == null || RK.RU().size() == 0) ? null : RK.RU().get(0);
                if (auVar != null) {
                    String qp = auVar.qp();
                    String link = auVar.getLink();
                    if (!StringUtils.isNull(qp) && !StringUtils.isNull(link)) {
                        View inflate = LayoutInflater.from(this.btA.aMU.getBaseContext()).inflate(u.h.customer_enterforum_banner, (ViewGroup) null, true);
                        ImageView imageView = (ImageView) inflate.findViewById(u.g.bc_banner_cancel);
                        TbImageView tbImageView = (TbImageView) inflate.findViewById(u.g.bc_banner);
                        av.c(imageView, u.f.icon_close_interstitial);
                        imageView.setOnClickListener(new z(this, inflate));
                        tbImageView.c(qp, 10, false);
                        tbImageView.setOnClickListener(new aa(this, link));
                        this.btA.btg.aa(inflate);
                        this.btA.btk = true;
                    }
                }
            }
        }
    }
}
