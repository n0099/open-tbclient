package com.baidu.tieba.enterForum.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends CustomMessageListener {
    final /* synthetic */ k bvO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(k kVar, int i) {
        super(i);
        this.bvO = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        com.baidu.tieba.enterForum.c.c cVar3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001398) {
            cVar = this.bvO.bvw;
            if (cVar.Tc() != null) {
                cVar2 = this.bvO.bvw;
                com.baidu.tieba.enterForum.b.i Sr = cVar2.Tc().Sr();
                if (Sr == null) {
                    cVar3 = this.bvO.bvw;
                    Sr = cVar3.Tc().Sq();
                }
                az azVar = (Sr == null || Sr.SC() == null || Sr.SC().size() == 0) ? null : Sr.SC().get(0);
                if (azVar != null) {
                    String pY = azVar.pY();
                    String link = azVar.getLink();
                    if (!StringUtils.isNull(pY) && !StringUtils.isNull(link)) {
                        View inflate = LayoutInflater.from(this.bvO.aNO.getBaseContext()).inflate(u.h.customer_enterforum_banner, (ViewGroup) null, true);
                        ImageView imageView = (ImageView) inflate.findViewById(u.g.bc_banner_cancel);
                        TbImageView tbImageView = (TbImageView) inflate.findViewById(u.g.bc_banner);
                        av.c(imageView, u.f.icon_close_interstitial);
                        imageView.setOnClickListener(new z(this, inflate));
                        tbImageView.c(pY, 10, false);
                        tbImageView.setOnClickListener(new aa(this, link));
                        this.bvO.bvv.aa(inflate);
                        this.bvO.bvz = true;
                    }
                }
            }
        }
    }
}
