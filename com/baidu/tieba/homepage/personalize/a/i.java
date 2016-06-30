package com.baidu.tieba.homepage.personalize.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.adp.lib.f.c<TbImageView> {
    final /* synthetic */ f crq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.crq = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: vz */
    public TbImageView dF() {
        TbPageContext tbPageContext;
        tbPageContext = this.crq.Ea;
        TbImageView tbImageView = new TbImageView(tbPageContext.getPageActivity());
        tbImageView.setDrawBorder(true);
        tbImageView.setBorderColor(av.getColor(u.d.common_color_10043));
        tbImageView.setBorderWidth(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds1));
        return tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void l(TbImageView tbImageView) {
        tbImageView.setOnClickListener(null);
        tbImageView.setForegroundColor(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public TbImageView m(TbImageView tbImageView) {
        return tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public TbImageView n(TbImageView tbImageView) {
        tbImageView.setOnClickListener(null);
        tbImageView.setForegroundColor(0);
        return tbImageView;
    }
}
