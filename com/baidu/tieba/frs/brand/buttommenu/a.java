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
    private int bhy;
    private ForumData ckJ;
    private ImageView ffN;
    private BottomMenuView ffO;
    private List<BottomMenu> ffP;
    private int ffQ;
    private int ffR;
    private TbPageContext<?> mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.ffN = (ImageView) view.findViewById(d.g.normal_write_icon);
        this.ffO = (BottomMenuView) view.findViewById(d.g.bottom_menu_view);
        this.ffO.setOnMenuItemClickListener(this);
        this.bhy = l.h(tbPageContext.getPageActivity(), d.e.tbds160);
        this.ffQ = l.h(tbPageContext.getPageActivity(), d.e.tbds44);
        this.ffR = l.h(tbPageContext.getPageActivity(), d.e.ds4);
    }

    public void a(List<BottomMenu> list, ForumData forumData) {
        this.ffP = list;
        this.ckJ = forumData;
        boolean z = v.S(list) > 0;
        jz(z);
        if (z) {
            this.ffO.setVisibility(0);
            this.ffO.a(list, this.mPageContext);
            return;
        }
        this.ffO.setVisibility(8);
    }

    private void jz(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ffN.getLayoutParams();
        if (z) {
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.addRule(14, 0);
            layoutParams.bottomMargin = this.bhy;
            layoutParams.rightMargin = this.ffQ;
            return;
        }
        layoutParams.addRule(11, 0);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = this.ffR;
        layoutParams.rightMargin = 0;
    }

    public void jA(boolean z) {
        this.ffO.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.ffO.getVisibility() == 0) {
            this.ffO.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && v.S(bottomMenu.submenu) == 0) {
            ba.adD().c(this.mPageContext, new String[]{bottomMenu.url});
            TiebaStatic.log(new am("c13117").bJ(ImageViewerConfig.FORUM_ID, this.ckJ != null ? this.ckJ.getId() : "").bJ(ImageViewerConfig.FORUM_NAME, this.ckJ != null ? this.ckJ.getName() : "").k("uid", currentAccountId).bJ("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new am("c13118").k("uid", currentAccountId));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            ba.adD().c(this.mPageContext, new String[]{subBottomMenu.url});
            TiebaStatic.log(new am("c13117").bJ(ImageViewerConfig.FORUM_ID, this.ckJ != null ? this.ckJ.getId() : "").bJ(ImageViewerConfig.FORUM_NAME, this.ckJ != null ? this.ckJ.getName() : "").k("uid", TbadkCoreApplication.getCurrentAccountId()).bJ("obj_param1", subBottomMenu.name));
        }
    }
}
