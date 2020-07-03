package com.baidu.tieba.frs.brand.buttommenu;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.brand.buttommenu.BottomMenuView;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes9.dex */
public class a implements BottomMenuView.a {
    private ForumData ewc;
    private ImageView hHg;
    private BottomMenuView hHh;
    private List<BottomMenu> hHi;
    private int hHj;
    private int mMarginBottom;
    private int mMarginRight;
    private TbPageContext<?> mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.hHg = (ImageView) view.findViewById(R.id.normal_write_icon);
        this.hHh = (BottomMenuView) view.findViewById(R.id.bottom_menu_view);
        this.hHh.setOnMenuItemClickListener(this);
        this.mMarginBottom = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds160);
        this.mMarginRight = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds44);
        this.hHj = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds4);
    }

    public void a(List<BottomMenu> list, ForumData forumData) {
        this.hHi = list;
        this.ewc = forumData;
        boolean z = w.getCount(list) > 0;
        ny(z);
        if (z) {
            this.hHh.setVisibility(0);
            this.hHh.a(list, this.mPageContext);
            return;
        }
        this.hHh.setVisibility(8);
    }

    private void ny(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hHg.getLayoutParams();
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
        layoutParams.bottomMargin = this.hHj;
        layoutParams.rightMargin = 0;
    }

    public void nz(boolean z) {
        this.hHh.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.hHh.getVisibility() == 0) {
            this.hHh.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && w.getCount(bottomMenu.submenu) == 0) {
            bc.aWU().b(this.mPageContext, new String[]{bottomMenu.url});
            TiebaStatic.log(new ao("c13117").dk("fid", this.ewc != null ? this.ewc.getId() : "").dk("fname", this.ewc != null ? this.ewc.getName() : "").s("uid", currentAccountId).dk("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new ao("c13118").s("uid", currentAccountId));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            bc.aWU().b(this.mPageContext, new String[]{subBottomMenu.url});
            TiebaStatic.log(new ao("c13117").dk("fid", this.ewc != null ? this.ewc.getId() : "").dk("fname", this.ewc != null ? this.ewc.getName() : "").s("uid", TbadkCoreApplication.getCurrentAccountId()).dk("obj_param1", subBottomMenu.name));
        }
    }
}
