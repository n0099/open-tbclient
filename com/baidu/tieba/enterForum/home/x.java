package com.baidu.tieba.enterForum.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends CustomMessageListener {
    final /* synthetic */ l bHk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(l lVar, int i) {
        super(i);
        this.bHk = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        com.baidu.tieba.enterForum.c.c cVar3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001398) {
            cVar = this.bHk.bGT;
            if (cVar.Yg() != null) {
                cVar2 = this.bHk.bGT;
                com.baidu.tieba.enterForum.b.i Xw = cVar2.Yg().Xw();
                if (Xw == null || Xw.XH() == null || Xw.XH().size() == 0) {
                    cVar3 = this.bHk.bGT;
                    Xw = cVar3.Yg().Xv();
                }
                bd bdVar = (Xw == null || Xw.XH() == null || Xw.XH().size() == 0) ? null : Xw.XH().get(0);
                if (bdVar != null) {
                    String pO = bdVar.pO();
                    String link = bdVar.getLink();
                    if (!StringUtils.isNull(pO) && !StringUtils.isNull(link)) {
                        View inflate = LayoutInflater.from(this.bHk.aTS.getBaseContext()).inflate(r.h.customer_enterforum_banner, (ViewGroup) null, true);
                        ImageView imageView = (ImageView) inflate.findViewById(r.g.bc_banner_cancel);
                        TbImageView tbImageView = (TbImageView) inflate.findViewById(r.g.bc_banner);
                        com.baidu.tieba.recapp.g.a(bdVar.pF(), (TbImageView) inflate.findViewById(r.g.bc_advert), bdVar.rn(), com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getContext(), r.e.ds26));
                        av.c(imageView, r.f.icon_close_interstitial);
                        imageView.setOnClickListener(new y(this, inflate));
                        tbImageView.c(pO, 10, false);
                        tbImageView.setOnClickListener(new z(this, link));
                        this.bHk.bGS.aa(inflate);
                        this.bHk.bGW = true;
                    }
                }
            }
        }
    }
}
