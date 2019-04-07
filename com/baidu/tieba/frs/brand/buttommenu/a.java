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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.brand.buttommenu.BottomMenuView;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes4.dex */
public class a implements BottomMenuView.a {
    private int bhB;
    private ForumData ckL;
    private ImageView ffA;
    private BottomMenuView ffB;
    private List<BottomMenu> ffC;
    private int ffD;
    private int ffE;
    private TbPageContext<?> mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.ffA = (ImageView) view.findViewById(d.g.normal_write_icon);
        this.ffB = (BottomMenuView) view.findViewById(d.g.bottom_menu_view);
        this.ffB.setOnMenuItemClickListener(this);
        this.bhB = l.h(tbPageContext.getPageActivity(), d.e.tbds160);
        this.ffD = l.h(tbPageContext.getPageActivity(), d.e.tbds44);
        this.ffE = l.h(tbPageContext.getPageActivity(), d.e.ds4);
    }

    public void a(List<BottomMenu> list, ForumData forumData) {
        this.ffC = list;
        this.ckL = forumData;
        boolean z = v.S(list) > 0;
        jz(z);
        if (z) {
            this.ffB.setVisibility(0);
            this.ffB.a(list, this.mPageContext);
            return;
        }
        this.ffB.setVisibility(8);
    }

    private void jz(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ffA.getLayoutParams();
        if (z) {
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.addRule(14, 0);
            layoutParams.bottomMargin = this.bhB;
            layoutParams.rightMargin = this.ffD;
            return;
        }
        layoutParams.addRule(11, 0);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = this.ffE;
        layoutParams.rightMargin = 0;
    }

    public void jA(boolean z) {
        this.ffB.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.ffB.getVisibility() == 0) {
            this.ffB.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && v.S(bottomMenu.submenu) == 0) {
            ba.adA().c(this.mPageContext, new String[]{bottomMenu.url});
            TiebaStatic.log(new am("c13117").bJ(ImageViewerConfig.FORUM_ID, this.ckL != null ? this.ckL.getId() : "").bJ(ImageViewerConfig.FORUM_NAME, this.ckL != null ? this.ckL.getName() : "").k("uid", currentAccountId).bJ("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new am("c13118").k("uid", currentAccountId));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            ba.adA().c(this.mPageContext, new String[]{subBottomMenu.url});
            TiebaStatic.log(new am("c13117").bJ(ImageViewerConfig.FORUM_ID, this.ckL != null ? this.ckL.getId() : "").bJ(ImageViewerConfig.FORUM_NAME, this.ckL != null ? this.ckL.getName() : "").k("uid", TbadkCoreApplication.getCurrentAccountId()).bJ("obj_param1", subBottomMenu.name));
        }
    }
}
