package com.baidu.tieba.enterForum.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends CustomMessageListener {
    final /* synthetic */ l bFb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(l lVar, int i) {
        super(i);
        this.bFb = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        EnterForumModel enterForumModel;
        EnterForumModel enterForumModel2;
        EnterForumModel enterForumModel3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001391) {
            enterForumModel = this.bFb.bEJ;
            if (enterForumModel.VM() != null) {
                enterForumModel2 = this.bFb.bEJ;
                com.baidu.tieba.enterForum.b.i Vc = enterForumModel2.VM().Vc();
                if (Vc == null || Vc.Vn() == null || Vc.Vn().size() == 0) {
                    enterForumModel3 = this.bFb.bEJ;
                    Vc = enterForumModel3.VM().Vb();
                }
                be beVar = (Vc == null || Vc.Vn() == null || Vc.Vn().size() == 0) ? null : Vc.Vn().get(0);
                if (beVar != null) {
                    String qd = beVar.qd();
                    String link = beVar.getLink();
                    if (!StringUtils.isNull(qd) && !StringUtils.isNull(link)) {
                        View inflate = LayoutInflater.from(this.bFb.aXf.getBaseContext()).inflate(w.j.customer_enterforum_banner, (ViewGroup) null, true);
                        ImageView imageView = (ImageView) inflate.findViewById(w.h.bc_banner_cancel);
                        TbImageView tbImageView = (TbImageView) inflate.findViewById(w.h.bc_banner);
                        com.baidu.tieba.recapp.t.a(beVar.pU(), (TbImageView) inflate.findViewById(w.h.bc_advert), beVar.rp(), com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getContext(), w.f.ds26));
                        aq.c(imageView, w.g.icon_close_interstitial);
                        imageView.setOnClickListener(new y(this, inflate));
                        tbImageView.c(qd, 10, false);
                        tbImageView.setOnClickListener(new z(this, link));
                        this.bFb.bEI.ae(inflate);
                        this.bFb.bEM = true;
                    }
                }
            }
        }
    }
}
