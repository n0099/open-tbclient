package com.baidu.tieba.frs.brand.buttommenu;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.brand.buttommenu.BottomMenuView;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes22.dex */
public class a implements BottomMenuView.a {
    private ForumData fxa;
    private ImageView jbq;
    private BottomMenuView jbr;
    private List<BottomMenu> jbs;
    private int jbt;
    private int mMarginBottom;
    private int mMarginRight;
    private TbPageContext<?> mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.jbq = (ImageView) view.findViewById(R.id.normal_write_icon);
        this.jbr = (BottomMenuView) view.findViewById(R.id.bottom_menu_view);
        this.jbr.setOnMenuItemClickListener(this);
        this.mMarginBottom = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds160);
        this.mMarginRight = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds44);
        this.jbt = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds4);
    }

    public void a(List<BottomMenu> list, ForumData forumData) {
        this.jbs = list;
        this.fxa = forumData;
        boolean z = y.getCount(list) > 0;
        qv(z);
        if (z) {
            this.jbr.setVisibility(0);
            this.jbr.a(list, this.mPageContext);
            return;
        }
        this.jbr.setVisibility(8);
    }

    private void qv(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jbq.getLayoutParams();
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
        layoutParams.bottomMargin = this.jbt;
        layoutParams.rightMargin = 0;
    }

    public void qw(boolean z) {
        this.jbr.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.jbr.getVisibility() == 0) {
            this.jbr.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && y.getCount(bottomMenu.submenu) == 0) {
            bf.bua().b(this.mPageContext, new String[]{bottomMenu.url});
            TiebaStatic.log(new ar("c13117").dY("fid", this.fxa != null ? this.fxa.getId() : "").dY("fname", this.fxa != null ? this.fxa.getName() : "").w("uid", currentAccountId).dY("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new ar("c13118").w("uid", currentAccountId));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            bf.bua().b(this.mPageContext, new String[]{subBottomMenu.url});
            TiebaStatic.log(new ar("c13117").dY("fid", this.fxa != null ? this.fxa.getId() : "").dY("fname", this.fxa != null ? this.fxa.getName() : "").w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("obj_param1", subBottomMenu.name));
        }
    }
}
