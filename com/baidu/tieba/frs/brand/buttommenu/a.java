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
/* loaded from: classes2.dex */
public class a implements BottomMenuView.a {
    private ForumData aRE;
    private int boz;
    private ImageView dyA;
    private BottomMenuView dyB;
    private List<BottomMenu> dyC;
    private int dyD;
    private int dyE;
    private TbPageContext<?> mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.dyA = (ImageView) view.findViewById(e.g.normal_write_icon);
        this.dyB = (BottomMenuView) view.findViewById(e.g.bottom_menu_view);
        this.dyB.setOnMenuItemClickListener(this);
        this.boz = l.h(tbPageContext.getPageActivity(), e.C0141e.tbds160);
        this.dyD = l.h(tbPageContext.getPageActivity(), e.C0141e.tbds44);
        this.dyE = l.h(tbPageContext.getPageActivity(), e.C0141e.ds4);
    }

    public void a(List<BottomMenu> list, ForumData forumData) {
        this.dyC = list;
        this.aRE = forumData;
        boolean z = v.y(list) > 0;
        gt(z);
        if (z) {
            this.dyB.setVisibility(0);
            this.dyB.a(list, this.mPageContext);
            return;
        }
        this.dyB.setVisibility(8);
    }

    private void gt(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dyA.getLayoutParams();
        if (z) {
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.addRule(14, 0);
            layoutParams.bottomMargin = this.boz;
            layoutParams.rightMargin = this.dyD;
            return;
        }
        layoutParams.addRule(11, 0);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = this.dyE;
        layoutParams.rightMargin = 0;
    }

    public void gu(boolean z) {
        this.dyB.setVisibility(z ? 0 : 8);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dyB.getVisibility() == 0) {
            this.dyB.d(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && v.y(bottomMenu.submenu) == 0) {
            ay.AN().c(this.mPageContext, new String[]{bottomMenu.url});
            TiebaStatic.log(new am("c13117").al(ImageViewerConfig.FORUM_ID, this.aRE != null ? this.aRE.getId() : "").al(ImageViewerConfig.FORUM_NAME, this.aRE != null ? this.aRE.getName() : "").g("uid", currentAccountId).al("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new am("c13118").g("uid", currentAccountId));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            ay.AN().c(this.mPageContext, new String[]{subBottomMenu.url});
            TiebaStatic.log(new am("c13117").al(ImageViewerConfig.FORUM_ID, this.aRE != null ? this.aRE.getId() : "").al(ImageViewerConfig.FORUM_NAME, this.aRE != null ? this.aRE.getName() : "").g("uid", TbadkCoreApplication.getCurrentAccountId()).al("obj_param1", subBottomMenu.name));
        }
    }
}
