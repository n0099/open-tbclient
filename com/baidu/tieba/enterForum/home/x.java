package com.baidu.tieba.enterForum.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends CustomMessageListener {
    final /* synthetic */ i aWN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(i iVar, int i) {
        super(i);
        this.aWN = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        com.baidu.tieba.enterForum.c.c cVar3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001398) {
            cVar = this.aWN.aWt;
            if (cVar.Mp() != null) {
                cVar2 = this.aWN.aWt;
                com.baidu.tieba.enterForum.b.h LI = cVar2.Mp().LI();
                if (LI == null) {
                    cVar3 = this.aWN.aWt;
                    LI = cVar3.Mp().LH();
                }
                com.baidu.tbadk.core.data.ac acVar = (LI == null || LI.LS() == null || LI.LS().size() == 0) ? null : LI.LS().get(0);
                if (acVar != null) {
                    String sV = acVar.sV();
                    String link = acVar.getLink();
                    if (!StringUtils.isNull(sV) && !StringUtils.isNull(link)) {
                        View inflate = LayoutInflater.from(this.aWN.aKq.getBaseContext()).inflate(t.h.customer_enterforum_banner, (ViewGroup) null, true);
                        ImageView imageView = (ImageView) inflate.findViewById(t.g.bc_banner_cancel);
                        TbImageView tbImageView = (TbImageView) inflate.findViewById(t.g.bc_banner);
                        ar.c(imageView, t.f.icon_close_interstitial);
                        imageView.setOnClickListener(new y(this, inflate));
                        tbImageView.d(sV, 10, false);
                        tbImageView.setOnClickListener(new z(this, link));
                        this.aWN.aWs.S(inflate);
                        this.aWN.aWw = true;
                    }
                }
            }
        }
    }
}
