package com.baidu.tieba.enterForum.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends CustomMessageListener {
    final /* synthetic */ l bHc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(l lVar, int i) {
        super(i);
        this.bHc = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        com.baidu.tieba.enterForum.c.c cVar3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001398) {
            cVar = this.bHc.bGK;
            if (cVar.XN() != null) {
                cVar2 = this.bHc.bGK;
                com.baidu.tieba.enterForum.b.i Xd = cVar2.XN().Xd();
                if (Xd == null) {
                    cVar3 = this.bHc.bGK;
                    Xd = cVar3.XN().Xc();
                }
                bb bbVar = (Xd == null || Xd.Xo() == null || Xd.Xo().size() == 0) ? null : Xd.Xo().get(0);
                if (bbVar != null) {
                    String rc = bbVar.rc();
                    String link = bbVar.getLink();
                    if (!StringUtils.isNull(rc) && !StringUtils.isNull(link)) {
                        View inflate = LayoutInflater.from(this.bHc.aTi.getBaseContext()).inflate(t.h.customer_enterforum_banner, (ViewGroup) null, true);
                        ImageView imageView = (ImageView) inflate.findViewById(t.g.bc_banner_cancel);
                        TbImageView tbImageView = (TbImageView) inflate.findViewById(t.g.bc_banner);
                        av.c(imageView, t.f.icon_close_interstitial);
                        imageView.setOnClickListener(new aa(this, inflate));
                        tbImageView.c(rc, 10, false);
                        tbImageView.setOnClickListener(new ab(this, link));
                        this.bHc.bGJ.aa(inflate);
                        this.bHc.bGN = true;
                    }
                }
            }
        }
    }
}
