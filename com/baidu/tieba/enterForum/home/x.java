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
    final /* synthetic */ l bHl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(l lVar, int i) {
        super(i);
        this.bHl = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        EnterForumModel enterForumModel;
        EnterForumModel enterForumModel2;
        EnterForumModel enterForumModel3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001391) {
            enterForumModel = this.bHl.bGT;
            if (enterForumModel.Xl() != null) {
                enterForumModel2 = this.bHl.bGT;
                com.baidu.tieba.enterForum.b.i WB = enterForumModel2.Xl().WB();
                if (WB == null || WB.WM() == null || WB.WM().size() == 0) {
                    enterForumModel3 = this.bHl.bGT;
                    WB = enterForumModel3.Xl().WA();
                }
                bd bdVar = (WB == null || WB.WM() == null || WB.WM().size() == 0) ? null : WB.WM().get(0);
                if (bdVar != null) {
                    String qB = bdVar.qB();
                    String link = bdVar.getLink();
                    if (!StringUtils.isNull(qB) && !StringUtils.isNull(link)) {
                        View inflate = LayoutInflater.from(this.bHl.aXw.getBaseContext()).inflate(w.j.customer_enterforum_banner, (ViewGroup) null, true);
                        ImageView imageView = (ImageView) inflate.findViewById(w.h.bc_banner_cancel);
                        TbImageView tbImageView = (TbImageView) inflate.findViewById(w.h.bc_banner);
                        com.baidu.tieba.recapp.y.a(bdVar.qs(), (TbImageView) inflate.findViewById(w.h.bc_advert), bdVar.rN(), com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getContext(), w.f.ds26));
                        aq.c(imageView, w.g.icon_close_interstitial);
                        imageView.setOnClickListener(new y(this, inflate));
                        tbImageView.c(qB, 10, false);
                        tbImageView.setOnClickListener(new z(this, link));
                        this.bHl.bGS.ae(inflate);
                        this.bHl.bGW = true;
                    }
                }
            }
        }
    }
}
