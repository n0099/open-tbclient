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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.brand.buttommenu.BottomMenuView;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes2.dex */
public class a implements BottomMenuView.a {
    private ForumData fGG;
    private ImageView jnE;
    private BottomMenuView jnF;
    private List<BottomMenu> jnG;
    private int jnH;
    private int mMarginBottom;
    private int mMarginRight;
    private TbPageContext<?> mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.jnE = (ImageView) view.findViewById(R.id.normal_write_icon);
        this.jnF = (BottomMenuView) view.findViewById(R.id.bottom_menu_view);
        this.jnF.setOnMenuItemClickListener(this);
        this.mMarginBottom = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds160);
        this.mMarginRight = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds44);
        this.jnH = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds4);
    }

    public void a(List<BottomMenu> list, ForumData forumData) {
        this.jnG = list;
        this.fGG = forumData;
        boolean z = x.getCount(list) > 0;
        qT(z);
        if (z) {
            this.jnF.setVisibility(0);
            this.jnF.a(list, this.mPageContext);
            return;
        }
        this.jnF.setVisibility(8);
    }

    private void qT(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jnE.getLayoutParams();
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
        layoutParams.bottomMargin = this.jnH;
        layoutParams.rightMargin = 0;
    }

    public void qU(boolean z) {
        this.jnF.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.jnF.getVisibility() == 0) {
            this.jnF.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && x.getCount(bottomMenu.submenu) == 0) {
            be.bwu().b(this.mPageContext, new String[]{bottomMenu.url});
            TiebaStatic.log(new aq("c13117").dX("fid", this.fGG != null ? this.fGG.getId() : "").dX("fname", this.fGG != null ? this.fGG.getName() : "").w("uid", currentAccountId).dX("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new aq("c13118").w("uid", currentAccountId));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            be.bwu().b(this.mPageContext, new String[]{subBottomMenu.url});
            TiebaStatic.log(new aq("c13117").dX("fid", this.fGG != null ? this.fGG.getId() : "").dX("fname", this.fGG != null ? this.fGG.getName() : "").w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("obj_param1", subBottomMenu.name));
        }
    }
}
