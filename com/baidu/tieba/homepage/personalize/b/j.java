package com.baidu.tieba.homepage.personalize.b;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.adp.lib.e.c<TbImageView> {
    final /* synthetic */ g cxU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.cxU = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: xs */
    public TbImageView fK() {
        TbPageContext tbPageContext;
        tbPageContext = this.cxU.ajT;
        TbImageView tbImageView = new TbImageView(tbPageContext.getPageActivity());
        tbImageView.setDrawBorder(true);
        tbImageView.setBorderColor(aq.getColor(w.e.common_color_10043));
        tbImageView.setBorderWidth(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1));
        return tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: a */
    public void o(TbImageView tbImageView) {
        tbImageView.setOnClickListener(null);
        tbImageView.setForegroundColor(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public TbImageView p(TbImageView tbImageView) {
        return tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public TbImageView q(TbImageView tbImageView) {
        tbImageView.setOnClickListener(null);
        tbImageView.setForegroundColor(0);
        return tbImageView;
    }
}
