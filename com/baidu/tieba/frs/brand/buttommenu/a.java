package com.baidu.tieba.frs.brand.buttommenu;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.brand.buttommenu.BottomMenuView;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes7.dex */
public class a implements BottomMenuView.a {
    private ForumData duJ;
    private ImageView gth;
    private BottomMenuView gti;
    private List<BottomMenu> gtj;
    private int gtk;
    private int mMarginBottom;
    private int mMarginRight;
    private TbPageContext<?> mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.gth = (ImageView) view.findViewById(R.id.normal_write_icon);
        this.gti = (BottomMenuView) view.findViewById(R.id.bottom_menu_view);
        this.gti.setOnMenuItemClickListener(this);
        this.mMarginBottom = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds160);
        this.mMarginRight = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds44);
        this.gtk = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds4);
    }

    public void a(List<BottomMenu> list, ForumData forumData) {
        this.gtj = list;
        this.duJ = forumData;
        boolean z = v.getCount(list) > 0;
        lG(z);
        if (z) {
            this.gti.setVisibility(0);
            this.gti.a(list, this.mPageContext);
            return;
        }
        this.gti.setVisibility(8);
    }

    private void lG(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gth.getLayoutParams();
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
        layoutParams.bottomMargin = this.gtk;
        layoutParams.rightMargin = 0;
    }

    public void lH(boolean z) {
        this.gti.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gti.getVisibility() == 0) {
            this.gti.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && v.getCount(bottomMenu.submenu) == 0) {
            ba.aEt().b(this.mPageContext, new String[]{bottomMenu.url});
            TiebaStatic.log(new an("c13117").cp("fid", this.duJ != null ? this.duJ.getId() : "").cp("fname", this.duJ != null ? this.duJ.getName() : "").s("uid", currentAccountId).cp("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new an("c13118").s("uid", currentAccountId));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            ba.aEt().b(this.mPageContext, new String[]{subBottomMenu.url});
            TiebaStatic.log(new an("c13117").cp("fid", this.duJ != null ? this.duJ.getId() : "").cp("fname", this.duJ != null ? this.duJ.getName() : "").s("uid", TbadkCoreApplication.getCurrentAccountId()).cp("obj_param1", subBottomMenu.name));
        }
    }
}
