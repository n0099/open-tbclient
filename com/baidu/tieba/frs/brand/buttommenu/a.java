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
    private ForumData aWV;
    private ImageView dHQ;
    private BottomMenuView dHR;
    private List<BottomMenu> dHS;
    private int dHT;
    private int mMarginBottom;
    private int mMarginRight;
    private TbPageContext<?> mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.dHQ = (ImageView) view.findViewById(e.g.normal_write_icon);
        this.dHR = (BottomMenuView) view.findViewById(e.g.bottom_menu_view);
        this.dHR.setOnMenuItemClickListener(this);
        this.mMarginBottom = l.h(tbPageContext.getPageActivity(), e.C0200e.tbds160);
        this.mMarginRight = l.h(tbPageContext.getPageActivity(), e.C0200e.tbds44);
        this.dHT = l.h(tbPageContext.getPageActivity(), e.C0200e.ds4);
    }

    public void a(List<BottomMenu> list, ForumData forumData) {
        this.dHS = list;
        this.aWV = forumData;
        boolean z = v.H(list) > 0;
        gV(z);
        if (z) {
            this.dHR.setVisibility(0);
            this.dHR.a(list, this.mPageContext);
            return;
        }
        this.dHR.setVisibility(8);
    }

    private void gV(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dHQ.getLayoutParams();
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
        layoutParams.bottomMargin = this.dHT;
        layoutParams.rightMargin = 0;
    }

    public void gW(boolean z) {
        this.dHR.setVisibility(z ? 0 : 8);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dHR.getVisibility() == 0) {
            this.dHR.d(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && v.H(bottomMenu.submenu) == 0) {
            ay.Db().c(this.mPageContext, new String[]{bottomMenu.url});
            TiebaStatic.log(new am("c13117").ax(ImageViewerConfig.FORUM_ID, this.aWV != null ? this.aWV.getId() : "").ax(ImageViewerConfig.FORUM_NAME, this.aWV != null ? this.aWV.getName() : "").h("uid", currentAccountId).ax("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new am("c13118").h("uid", currentAccountId));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            ay.Db().c(this.mPageContext, new String[]{subBottomMenu.url});
            TiebaStatic.log(new am("c13117").ax(ImageViewerConfig.FORUM_ID, this.aWV != null ? this.aWV.getId() : "").ax(ImageViewerConfig.FORUM_NAME, this.aWV != null ? this.aWV.getName() : "").h("uid", TbadkCoreApplication.getCurrentAccountId()).ax("obj_param1", subBottomMenu.name));
        }
    }
}
