package com.baidu.tieba.enterForum.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends CustomMessageListener {
    final /* synthetic */ k aXF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(k kVar, int i) {
        super(i);
        this.aXF = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        com.baidu.tieba.enterForum.c.c cVar3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001398) {
            cVar = this.aXF.aXl;
            if (cVar.MQ() != null) {
                cVar2 = this.aXF.aXl;
                com.baidu.tieba.enterForum.b.h Mf = cVar2.MQ().Mf();
                if (Mf == null) {
                    cVar3 = this.aXF.aXl;
                    Mf = cVar3.MQ().Me();
                }
                as asVar = (Mf == null || Mf.Mo() == null || Mf.Mo().size() == 0) ? null : Mf.Mo().get(0);
                if (asVar != null) {
                    String qv = asVar.qv();
                    String link = asVar.getLink();
                    if (!StringUtils.isNull(qv) && !StringUtils.isNull(link)) {
                        View inflate = LayoutInflater.from(this.aXF.aJw.getBaseContext()).inflate(t.h.customer_enterforum_banner, (ViewGroup) null, true);
                        ImageView imageView = (ImageView) inflate.findViewById(t.g.bc_banner_cancel);
                        TbImageView tbImageView = (TbImageView) inflate.findViewById(t.g.bc_banner);
                        at.c(imageView, t.f.icon_close_interstitial);
                        imageView.setOnClickListener(new aa(this, inflate));
                        tbImageView.c(qv, 10, false);
                        tbImageView.setOnClickListener(new ab(this, link));
                        this.aXF.aXk.Y(inflate);
                        this.aXF.aXo = true;
                    }
                }
            }
        }
    }
}
