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
    private ForumData dZc;
    private ImageView hfr;
    private BottomMenuView hfs;
    private List<BottomMenu> hft;
    private int hfu;
    private int mMarginBottom;
    private int mMarginRight;
    private TbPageContext<?> mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.hfr = (ImageView) view.findViewById(R.id.normal_write_icon);
        this.hfs = (BottomMenuView) view.findViewById(R.id.bottom_menu_view);
        this.hfs.setOnMenuItemClickListener(this);
        this.mMarginBottom = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds160);
        this.mMarginRight = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds44);
        this.hfu = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds4);
    }

    public void a(List<BottomMenu> list, ForumData forumData) {
        this.hft = list;
        this.dZc = forumData;
        boolean z = v.getCount(list) > 0;
        mS(z);
        if (z) {
            this.hfs.setVisibility(0);
            this.hfs.a(list, this.mPageContext);
            return;
        }
        this.hfs.setVisibility(8);
    }

    private void mS(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hfr.getLayoutParams();
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
        layoutParams.bottomMargin = this.hfu;
        layoutParams.rightMargin = 0;
    }

    public void mT(boolean z) {
        this.hfs.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.hfs.getVisibility() == 0) {
            this.hfs.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && v.getCount(bottomMenu.submenu) == 0) {
            ba.aOV().b(this.mPageContext, new String[]{bottomMenu.url});
            TiebaStatic.log(new an("c13117").cI("fid", this.dZc != null ? this.dZc.getId() : "").cI("fname", this.dZc != null ? this.dZc.getName() : "").t("uid", currentAccountId).cI("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new an("c13118").t("uid", currentAccountId));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            ba.aOV().b(this.mPageContext, new String[]{subBottomMenu.url});
            TiebaStatic.log(new an("c13117").cI("fid", this.dZc != null ? this.dZc.getId() : "").cI("fname", this.dZc != null ? this.dZc.getName() : "").t("uid", TbadkCoreApplication.getCurrentAccountId()).cI("obj_param1", subBottomMenu.name));
        }
    }
}
