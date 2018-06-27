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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.brand.buttommenu.BottomMenuView;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes2.dex */
public class a implements BottomMenuView.a {
    private ForumData aOq;
    private int bic;
    private ImageView dpA;
    private BottomMenuView dpB;
    private List<BottomMenu> dpC;
    private int dpD;
    private int dpE;
    private TbPageContext<?> mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.dpA = (ImageView) view.findViewById(d.g.normal_write_icon);
        this.dpB = (BottomMenuView) view.findViewById(d.g.bottom_menu_view);
        this.dpB.setOnMenuItemClickListener(this);
        this.bic = l.e(tbPageContext.getPageActivity(), d.e.tbds160);
        this.dpD = l.e(tbPageContext.getPageActivity(), d.e.tbds44);
        this.dpE = l.e(tbPageContext.getPageActivity(), d.e.ds4);
    }

    public void a(List<BottomMenu> list, ForumData forumData) {
        this.dpC = list;
        this.aOq = forumData;
        boolean z = w.z(list) > 0;
        fU(z);
        if (z) {
            this.dpB.setVisibility(0);
            this.dpB.a(list, this.mPageContext);
            return;
        }
        this.dpB.setVisibility(8);
    }

    private void fU(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dpA.getLayoutParams();
        if (z) {
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.addRule(14, 0);
            layoutParams.bottomMargin = this.bic;
            layoutParams.rightMargin = this.dpD;
            return;
        }
        layoutParams.addRule(11, 0);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = this.dpE;
        layoutParams.rightMargin = 0;
    }

    public void fV(boolean z) {
        this.dpB.setVisibility(z ? 0 : 8);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dpB.getVisibility() == 0) {
            this.dpB.d(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && w.z(bottomMenu.submenu) == 0) {
            az.zV().c(this.mPageContext, new String[]{bottomMenu.url});
            TiebaStatic.log(new an("c13117").ah(ImageViewerConfig.FORUM_ID, this.aOq != null ? this.aOq.getId() : "").ah(ImageViewerConfig.FORUM_NAME, this.aOq != null ? this.aOq.getName() : "").f("uid", currentAccountId).ah("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new an("c13118").f("uid", currentAccountId));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            az.zV().c(this.mPageContext, new String[]{subBottomMenu.url});
            TiebaStatic.log(new an("c13117").ah(ImageViewerConfig.FORUM_ID, this.aOq != null ? this.aOq.getId() : "").ah(ImageViewerConfig.FORUM_NAME, this.aOq != null ? this.aOq.getName() : "").f("uid", TbadkCoreApplication.getCurrentAccountId()).ah("obj_param1", subBottomMenu.name));
        }
    }
}
