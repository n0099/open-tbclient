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
/* loaded from: classes9.dex */
public class a implements BottomMenuView.a {
    private ForumData dzd;
    private ImageView gvw;
    private BottomMenuView gvx;
    private List<BottomMenu> gvy;
    private int gvz;
    private int mMarginBottom;
    private int mMarginRight;
    private TbPageContext<?> mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.gvw = (ImageView) view.findViewById(R.id.normal_write_icon);
        this.gvx = (BottomMenuView) view.findViewById(R.id.bottom_menu_view);
        this.gvx.setOnMenuItemClickListener(this);
        this.mMarginBottom = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds160);
        this.mMarginRight = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds44);
        this.gvz = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds4);
    }

    public void a(List<BottomMenu> list, ForumData forumData) {
        this.gvy = list;
        this.dzd = forumData;
        boolean z = v.getCount(list) > 0;
        lJ(z);
        if (z) {
            this.gvx.setVisibility(0);
            this.gvx.a(list, this.mPageContext);
            return;
        }
        this.gvx.setVisibility(8);
    }

    private void lJ(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gvw.getLayoutParams();
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
        layoutParams.bottomMargin = this.gvz;
        layoutParams.rightMargin = 0;
    }

    public void lK(boolean z) {
        this.gvx.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gvx.getVisibility() == 0) {
            this.gvx.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && v.getCount(bottomMenu.submenu) == 0) {
            ba.aGG().b(this.mPageContext, new String[]{bottomMenu.url});
            TiebaStatic.log(new an("c13117").cy("fid", this.dzd != null ? this.dzd.getId() : "").cy("fname", this.dzd != null ? this.dzd.getName() : "").s("uid", currentAccountId).cy("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new an("c13118").s("uid", currentAccountId));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            ba.aGG().b(this.mPageContext, new String[]{subBottomMenu.url});
            TiebaStatic.log(new an("c13117").cy("fid", this.dzd != null ? this.dzd.getId() : "").cy("fname", this.dzd != null ? this.dzd.getName() : "").s("uid", TbadkCoreApplication.getCurrentAccountId()).cy("obj_param1", subBottomMenu.name));
        }
    }
}
