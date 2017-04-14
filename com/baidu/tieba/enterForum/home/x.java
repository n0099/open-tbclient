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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends CustomMessageListener {
    final /* synthetic */ l bEU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(l lVar, int i) {
        super(i);
        this.bEU = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        EnterForumModel enterForumModel;
        EnterForumModel enterForumModel2;
        EnterForumModel enterForumModel3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001391) {
            enterForumModel = this.bEU.bEC;
            if (enterForumModel.Wk() != null) {
                enterForumModel2 = this.bEU.bEC;
                com.baidu.tieba.enterForum.b.i VA = enterForumModel2.Wk().VA();
                if (VA == null || VA.VL() == null || VA.VL().size() == 0) {
                    enterForumModel3 = this.bEU.bEC;
                    VA = enterForumModel3.Wk().Vz();
                }
                bd bdVar = (VA == null || VA.VL() == null || VA.VL().size() == 0) ? null : VA.VL().get(0);
                if (bdVar != null) {
                    String qB = bdVar.qB();
                    String link = bdVar.getLink();
                    if (!StringUtils.isNull(qB) && !StringUtils.isNull(link)) {
                        View inflate = LayoutInflater.from(this.bEU.aXt.getBaseContext()).inflate(w.j.customer_enterforum_banner, (ViewGroup) null, true);
                        ImageView imageView = (ImageView) inflate.findViewById(w.h.bc_banner_cancel);
                        TbImageView tbImageView = (TbImageView) inflate.findViewById(w.h.bc_banner);
                        com.baidu.tieba.recapp.y.a(bdVar.qs(), (TbImageView) inflate.findViewById(w.h.bc_advert), bdVar.rN(), com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getContext(), w.f.ds26));
                        aq.c(imageView, w.g.icon_close_interstitial);
                        imageView.setOnClickListener(new y(this, inflate));
                        tbImageView.c(qB, 10, false);
                        tbImageView.setOnClickListener(new z(this, link));
                        this.bEU.bEB.ae(inflate);
                        this.bEU.bEF = true;
                    }
                }
            }
        }
    }
}
