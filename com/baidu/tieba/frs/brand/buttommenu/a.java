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
    private ForumData bbg;
    private ImageView dRM;
    private BottomMenuView dRN;
    private List<BottomMenu> dRO;
    private int dRP;
    private int mMarginBottom;
    private int mMarginRight;
    private TbPageContext<?> mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.dRM = (ImageView) view.findViewById(e.g.normal_write_icon);
        this.dRN = (BottomMenuView) view.findViewById(e.g.bottom_menu_view);
        this.dRN.setOnMenuItemClickListener(this);
        this.mMarginBottom = l.h(tbPageContext.getPageActivity(), e.C0210e.tbds160);
        this.mMarginRight = l.h(tbPageContext.getPageActivity(), e.C0210e.tbds44);
        this.dRP = l.h(tbPageContext.getPageActivity(), e.C0210e.ds4);
    }

    public void a(List<BottomMenu> list, ForumData forumData) {
        this.dRO = list;
        this.bbg = forumData;
        boolean z = v.H(list) > 0;
        hc(z);
        if (z) {
            this.dRN.setVisibility(0);
            this.dRN.a(list, this.mPageContext);
            return;
        }
        this.dRN.setVisibility(8);
    }

    private void hc(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dRM.getLayoutParams();
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
        layoutParams.bottomMargin = this.dRP;
        layoutParams.rightMargin = 0;
    }

    public void hd(boolean z) {
        this.dRN.setVisibility(z ? 0 : 8);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dRN.getVisibility() == 0) {
            this.dRN.d(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && v.H(bottomMenu.submenu) == 0) {
            ay.Es().c(this.mPageContext, new String[]{bottomMenu.url});
            TiebaStatic.log(new am("c13117").aB(ImageViewerConfig.FORUM_ID, this.bbg != null ? this.bbg.getId() : "").aB(ImageViewerConfig.FORUM_NAME, this.bbg != null ? this.bbg.getName() : "").i("uid", currentAccountId).aB("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new am("c13118").i("uid", currentAccountId));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            ay.Es().c(this.mPageContext, new String[]{subBottomMenu.url});
            TiebaStatic.log(new am("c13117").aB(ImageViewerConfig.FORUM_ID, this.bbg != null ? this.bbg.getId() : "").aB(ImageViewerConfig.FORUM_NAME, this.bbg != null ? this.bbg.getName() : "").i("uid", TbadkCoreApplication.getCurrentAccountId()).aB("obj_param1", subBottomMenu.name));
        }
    }
}
