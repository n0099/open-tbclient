package com.baidu.tieba.enterForum.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends CustomMessageListener {
    final /* synthetic */ i bbw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(i iVar, int i) {
        super(i);
        this.bbw = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        com.baidu.tieba.enterForum.c.c cVar3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001398) {
            cVar = this.bbw.bbc;
            if (cVar.Od() != null) {
                cVar2 = this.bbw.bbc;
                com.baidu.tieba.enterForum.b.h Nw = cVar2.Od().Nw();
                if (Nw == null) {
                    cVar3 = this.bbw.bbc;
                    Nw = cVar3.Od().Nv();
                }
                an anVar = (Nw == null || Nw.NG() == null || Nw.NG().size() == 0) ? null : Nw.NG().get(0);
                if (anVar != null) {
                    String sW = anVar.sW();
                    String link = anVar.getLink();
                    if (!StringUtils.isNull(sW) && !StringUtils.isNull(link)) {
                        View inflate = LayoutInflater.from(this.bbw.aNm.getBaseContext()).inflate(t.h.customer_enterforum_banner, (ViewGroup) null, true);
                        ImageView imageView = (ImageView) inflate.findViewById(t.g.bc_banner_cancel);
                        TbImageView tbImageView = (TbImageView) inflate.findViewById(t.g.bc_banner);
                        at.c(imageView, t.f.icon_close_interstitial);
                        imageView.setOnClickListener(new y(this, inflate));
                        tbImageView.c(sW, 10, false);
                        tbImageView.setOnClickListener(new z(this, link));
                        this.bbw.bbb.W(inflate);
                        this.bbw.bbf = true;
                    }
                }
            }
        }
    }
}
