package com.baidu.tieba.frs.brand.buttommenu;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.brand.buttommenu.BottomMenuView;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes6.dex */
public class a implements BottomMenuView.a {
    private ForumData aWf;
    private ImageView dGB;
    private BottomMenuView dGC;
    private List<BottomMenu> dGD;
    private int dGE;
    private int mMarginBottom;
    private int mMarginRight;
    private TbPageContext<?> mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.dGB = (ImageView) view.findViewById(e.g.normal_write_icon);
        this.dGC = (BottomMenuView) view.findViewById(e.g.bottom_menu_view);
        this.dGC.setOnMenuItemClickListener(this);
        this.mMarginBottom = l.h(tbPageContext.getPageActivity(), e.C0175e.tbds160);
        this.mMarginRight = l.h(tbPageContext.getPageActivity(), e.C0175e.tbds44);
        this.dGE = l.h(tbPageContext.getPageActivity(), e.C0175e.ds4);
    }

    public void a(List<BottomMenu> list, ForumData forumData) {
        this.dGD = list;
        this.aWf = forumData;
        boolean z = v.I(list) > 0;
        gL(z);
        if (z) {
            this.dGC.setVisibility(0);
            this.dGC.a(list, this.mPageContext);
            return;
        }
        this.dGC.setVisibility(8);
    }

    private void gL(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dGB.getLayoutParams();
        if (z) {
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.addRule(14, 0);
            layoutParams.bottomMargin = this.mMarginBottom;
            layoutParams.rightMargin = this.mMarginRight;
            return;
        }
        layoutParams.addRule(11, 0);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = this.dGE;
        layoutParams.rightMargin = 0;
    }

    public void gM(boolean z) {
        this.dGC.setVisibility(z ? 0 : 8);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dGC.getVisibility() == 0) {
            this.dGC.d(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && v.I(bottomMenu.submenu) == 0) {
            ay.CU().c(this.mPageContext, new String[]{bottomMenu.url});
            TiebaStatic.log(new am("c13117").ax(ImageViewerConfig.FORUM_ID, this.aWf != null ? this.aWf.getId() : "").ax(ImageViewerConfig.FORUM_NAME, this.aWf != null ? this.aWf.getName() : "").h("uid", currentAccountId).ax("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new am("c13118").h("uid", currentAccountId));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            ay.CU().c(this.mPageContext, new String[]{subBottomMenu.url});
            TiebaStatic.log(new am("c13117").ax(ImageViewerConfig.FORUM_ID, this.aWf != null ? this.aWf.getId() : "").ax(ImageViewerConfig.FORUM_NAME, this.aWf != null ? this.aWf.getName() : "").h("uid", TbadkCoreApplication.getCurrentAccountId()).ax("obj_param1", subBottomMenu.name));
        }
    }
}
