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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.brand.buttommenu.BottomMenuView;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes2.dex */
public class a implements BottomMenuView.a {
    private ForumData aOp;
    private int biJ;
    private ImageView dsn;
    private BottomMenuView dso;
    private List<BottomMenu> dsp;
    private int dsq;
    private int dsr;
    private TbPageContext<?> mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.dsn = (ImageView) view.findViewById(d.g.normal_write_icon);
        this.dso = (BottomMenuView) view.findViewById(d.g.bottom_menu_view);
        this.dso.setOnMenuItemClickListener(this);
        this.biJ = l.f(tbPageContext.getPageActivity(), d.e.tbds160);
        this.dsq = l.f(tbPageContext.getPageActivity(), d.e.tbds44);
        this.dsr = l.f(tbPageContext.getPageActivity(), d.e.ds4);
    }

    public void a(List<BottomMenu> list, ForumData forumData) {
        this.dsp = list;
        this.aOp = forumData;
        boolean z = w.y(list) > 0;
        fW(z);
        if (z) {
            this.dso.setVisibility(0);
            this.dso.a(list, this.mPageContext);
            return;
        }
        this.dso.setVisibility(8);
    }

    private void fW(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dsn.getLayoutParams();
        if (z) {
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.addRule(14, 0);
            layoutParams.bottomMargin = this.biJ;
            layoutParams.rightMargin = this.dsq;
            return;
        }
        layoutParams.addRule(11, 0);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = this.dsr;
        layoutParams.rightMargin = 0;
    }

    public void fX(boolean z) {
        this.dso.setVisibility(z ? 0 : 8);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dso.getVisibility() == 0) {
            this.dso.d(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && w.y(bottomMenu.submenu) == 0) {
            ay.zK().c(this.mPageContext, new String[]{bottomMenu.url});
            TiebaStatic.log(new an("c13117").af(ImageViewerConfig.FORUM_ID, this.aOp != null ? this.aOp.getId() : "").af(ImageViewerConfig.FORUM_NAME, this.aOp != null ? this.aOp.getName() : "").f("uid", currentAccountId).af("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new an("c13118").f("uid", currentAccountId));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            ay.zK().c(this.mPageContext, new String[]{subBottomMenu.url});
            TiebaStatic.log(new an("c13117").af(ImageViewerConfig.FORUM_ID, this.aOp != null ? this.aOp.getId() : "").af(ImageViewerConfig.FORUM_NAME, this.aOp != null ? this.aOp.getName() : "").f("uid", TbadkCoreApplication.getCurrentAccountId()).af("obj_param1", subBottomMenu.name));
        }
    }
}
