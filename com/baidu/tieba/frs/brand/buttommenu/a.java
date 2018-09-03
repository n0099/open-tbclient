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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.brand.buttommenu.BottomMenuView;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes2.dex */
public class a implements BottomMenuView.a {
    private ForumData aOm;
    private int biP;
    private ImageView dsk;
    private BottomMenuView dsl;
    private List<BottomMenu> dsm;
    private int dsn;
    private int dso;
    private TbPageContext<?> mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.dsk = (ImageView) view.findViewById(f.g.normal_write_icon);
        this.dsl = (BottomMenuView) view.findViewById(f.g.bottom_menu_view);
        this.dsl.setOnMenuItemClickListener(this);
        this.biP = l.f(tbPageContext.getPageActivity(), f.e.tbds160);
        this.dsn = l.f(tbPageContext.getPageActivity(), f.e.tbds44);
        this.dso = l.f(tbPageContext.getPageActivity(), f.e.ds4);
    }

    public void a(List<BottomMenu> list, ForumData forumData) {
        this.dsm = list;
        this.aOm = forumData;
        boolean z = w.y(list) > 0;
        fW(z);
        if (z) {
            this.dsl.setVisibility(0);
            this.dsl.a(list, this.mPageContext);
            return;
        }
        this.dsl.setVisibility(8);
    }

    private void fW(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dsk.getLayoutParams();
        if (z) {
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.addRule(14, 0);
            layoutParams.bottomMargin = this.biP;
            layoutParams.rightMargin = this.dsn;
            return;
        }
        layoutParams.addRule(11, 0);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = this.dso;
        layoutParams.rightMargin = 0;
    }

    public void fX(boolean z) {
        this.dsl.setVisibility(z ? 0 : 8);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dsl.getVisibility() == 0) {
            this.dsl.d(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && w.y(bottomMenu.submenu) == 0) {
            az.zI().c(this.mPageContext, new String[]{bottomMenu.url});
            TiebaStatic.log(new an("c13117").ae(ImageViewerConfig.FORUM_ID, this.aOm != null ? this.aOm.getId() : "").ae(ImageViewerConfig.FORUM_NAME, this.aOm != null ? this.aOm.getName() : "").f("uid", currentAccountId).ae("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new an("c13118").f("uid", currentAccountId));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            az.zI().c(this.mPageContext, new String[]{subBottomMenu.url});
            TiebaStatic.log(new an("c13117").ae(ImageViewerConfig.FORUM_ID, this.aOm != null ? this.aOm.getId() : "").ae(ImageViewerConfig.FORUM_NAME, this.aOm != null ? this.aOm.getName() : "").f("uid", TbadkCoreApplication.getCurrentAccountId()).ae("obj_param1", subBottomMenu.name));
        }
    }
}
