package com.baidu.tieba.enterForum.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends CustomMessageListener {
    final /* synthetic */ l bxV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(l lVar, int i) {
        super(i);
        this.bxV = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        EnterForumModel enterForumModel;
        EnterForumModel enterForumModel2;
        EnterForumModel enterForumModel3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001391) {
            enterForumModel = this.bxV.bxD;
            if (enterForumModel.UO() != null) {
                enterForumModel2 = this.bxV.bxD;
                com.baidu.tieba.enterForum.b.i Ue = enterForumModel2.UO().Ue();
                if (Ue == null || Ue.Up() == null || Ue.Up().size() == 0) {
                    enterForumModel3 = this.bxV.bxD;
                    Ue = enterForumModel3.UO().Ud();
                }
                bc bcVar = (Ue == null || Ue.Up() == null || Ue.Up().size() == 0) ? null : Ue.Up().get(0);
                if (bcVar != null) {
                    String pL = bcVar.pL();
                    String link = bcVar.getLink();
                    if (!StringUtils.isNull(pL) && !StringUtils.isNull(link)) {
                        View inflate = LayoutInflater.from(this.bxV.aQU.getBaseContext()).inflate(r.j.customer_enterforum_banner, (ViewGroup) null, true);
                        ImageView imageView = (ImageView) inflate.findViewById(r.h.bc_banner_cancel);
                        TbImageView tbImageView = (TbImageView) inflate.findViewById(r.h.bc_banner);
                        com.baidu.tieba.recapp.r.a(bcVar.pC(), (TbImageView) inflate.findViewById(r.h.bc_advert), bcVar.qW(), com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getContext(), r.f.ds26));
                        ap.c(imageView, r.g.icon_close_interstitial);
                        imageView.setOnClickListener(new y(this, inflate));
                        tbImageView.c(pL, 10, false);
                        tbImageView.setOnClickListener(new z(this, link));
                        this.bxV.bxC.ag(inflate);
                        this.bxV.bxG = true;
                    }
                }
            }
        }
    }
}
