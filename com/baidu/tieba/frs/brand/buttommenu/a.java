package com.baidu.tieba.frs.brand.buttommenu;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.brand.buttommenu.BottomMenuView;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes16.dex */
public class a implements BottomMenuView.a {
    private ForumData eMU;
    private ImageView ibj;
    private BottomMenuView ibk;
    private List<BottomMenu> ibl;
    private int ibm;
    private int mMarginBottom;
    private int mMarginRight;
    private TbPageContext<?> mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.ibj = (ImageView) view.findViewById(R.id.normal_write_icon);
        this.ibk = (BottomMenuView) view.findViewById(R.id.bottom_menu_view);
        this.ibk.setOnMenuItemClickListener(this);
        this.mMarginBottom = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds160);
        this.mMarginRight = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds44);
        this.ibm = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds4);
    }

    public void a(List<BottomMenu> list, ForumData forumData) {
        this.ibl = list;
        this.eMU = forumData;
        boolean z = y.getCount(list) > 0;
        oH(z);
        if (z) {
            this.ibk.setVisibility(0);
            this.ibk.a(list, this.mPageContext);
            return;
        }
        this.ibk.setVisibility(8);
    }

    private void oH(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ibj.getLayoutParams();
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
        layoutParams.bottomMargin = this.ibm;
        layoutParams.rightMargin = 0;
    }

    public void oI(boolean z) {
        this.ibk.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.ibk.getVisibility() == 0) {
            this.ibk.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && y.getCount(bottomMenu.submenu) == 0) {
            be.bju().b(this.mPageContext, new String[]{bottomMenu.url});
            TiebaStatic.log(new aq("c13117").dD("fid", this.eMU != null ? this.eMU.getId() : "").dD("fname", this.eMU != null ? this.eMU.getName() : "").u("uid", currentAccountId).dD("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new aq("c13118").u("uid", currentAccountId));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            be.bju().b(this.mPageContext, new String[]{subBottomMenu.url});
            TiebaStatic.log(new aq("c13117").dD("fid", this.eMU != null ? this.eMU.getId() : "").dD("fname", this.eMU != null ? this.eMU.getName() : "").u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("obj_param1", subBottomMenu.name));
        }
    }
}
