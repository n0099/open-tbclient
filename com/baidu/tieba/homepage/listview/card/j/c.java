package com.baidu.tieba.homepage.listview.card.j;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.homepage.listview.card.c.d;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.homepage.listview.c<b> {
    private TbImageView bCa;
    private List<com.baidu.tieba.homepage.listview.a.c> bzY;
    private ViewGroup bzZ;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, View view) {
        super(tbPageContext, view);
        this.mPageContext = tbPageContext;
        this.bCa = (TbImageView) view.findViewById(n.f.home_page_vip_center_banner_view);
        this.bzZ = (ViewGroup) view.findViewById(n.f.home_page_vip_center_root_view);
        this.bzY = new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.homepage.listview.c
    /* renamed from: a */
    public void c(b bVar) {
        if (bVar != null) {
            super.D(bVar);
            if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(MembercenterActivityConfig.class)) {
                this.byH.setVisibility(0);
                this.byH.setText(bVar.TR());
            } else {
                this.byH.setVisibility(8);
            }
            this.byH.setOnClickListener(new d(this, bVar));
            this.bCa.d(bVar.bAU, 10, false);
            this.bCa.setOnClickListener(new e(this, bVar));
            ArrayList arrayList = new ArrayList();
            if (y.k(bVar.bBZ) != 0) {
                ArrayList arrayList2 = new ArrayList();
                for (d.a aVar : bVar.bBZ) {
                    if (aVar != null) {
                        com.baidu.tieba.homepage.listview.a.a aVar2 = new com.baidu.tieba.homepage.listview.a.a();
                        aVar2.byT = aVar.byT;
                        aVar2.bzW = aVar.bzW;
                        aVar2.bCd = new f(this, bVar, aVar);
                        arrayList2.add(aVar2);
                    }
                }
                com.baidu.tieba.homepage.listview.a.b bVar2 = new com.baidu.tieba.homepage.listview.a.b();
                bVar2.awS = arrayList2;
                bVar2.bCe = false;
                arrayList.add(bVar2);
            }
            com.baidu.tieba.homepage.fragment.a.b.a(this.mPageContext.getPageActivity(), this.bzZ, arrayList, com.baidu.tieba.homepage.listview.a.b.class, this.bzY, com.baidu.tieba.homepage.listview.a.c.class);
        }
    }

    @Override // com.baidu.tieba.homepage.listview.c
    public void cZ(int i) {
        com.baidu.tieba.homepage.listview.a.c cVar;
        if (this.mSkinType != i && (cVar = (com.baidu.tieba.homepage.listview.a.c) y.b(this.bzY, 0)) != null) {
            cVar.cZ(i);
        }
        super.cZ(i);
    }
}
