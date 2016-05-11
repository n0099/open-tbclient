package com.baidu.tieba.frs.entelechy.a;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.adp.lib.f.c<TbImageView> {
    final /* synthetic */ i boW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.boW = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: vw */
    public TbImageView dE() {
        BaseActivity baseActivity;
        baseActivity = this.boW.boS;
        TbImageView tbImageView = new TbImageView(baseActivity.getActivity());
        tbImageView.setDrawBorder(true);
        tbImageView.setBorderColor(at.getColor(t.d.black_alpha10));
        tbImageView.setBorderWidth(TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds1));
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
