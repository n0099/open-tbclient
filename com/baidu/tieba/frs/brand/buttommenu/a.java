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
/* loaded from: classes22.dex */
public class a implements BottomMenuView.a {
    private ForumData fkv;
    private ImageView iJN;
    private BottomMenuView iJO;
    private List<BottomMenu> iJP;
    private int iJQ;
    private int mMarginBottom;
    private int mMarginRight;
    private TbPageContext<?> mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.iJN = (ImageView) view.findViewById(R.id.normal_write_icon);
        this.iJO = (BottomMenuView) view.findViewById(R.id.bottom_menu_view);
        this.iJO.setOnMenuItemClickListener(this);
        this.mMarginBottom = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds160);
        this.mMarginRight = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds44);
        this.iJQ = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds4);
    }

    public void a(List<BottomMenu> list, ForumData forumData) {
        this.iJP = list;
        this.fkv = forumData;
        boolean z = y.getCount(list) > 0;
        pM(z);
        if (z) {
            this.iJO.setVisibility(0);
            this.iJO.a(list, this.mPageContext);
            return;
        }
        this.iJO.setVisibility(8);
    }

    private void pM(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iJN.getLayoutParams();
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
        layoutParams.bottomMargin = this.iJQ;
        layoutParams.rightMargin = 0;
    }

    public void pN(boolean z) {
        this.iJO.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.iJO.getVisibility() == 0) {
            this.iJO.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && y.getCount(bottomMenu.submenu) == 0) {
            be.boR().b(this.mPageContext, new String[]{bottomMenu.url});
            TiebaStatic.log(new aq("c13117").dR("fid", this.fkv != null ? this.fkv.getId() : "").dR("fname", this.fkv != null ? this.fkv.getName() : "").w("uid", currentAccountId).dR("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new aq("c13118").w("uid", currentAccountId));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            be.boR().b(this.mPageContext, new String[]{subBottomMenu.url});
            TiebaStatic.log(new aq("c13117").dR("fid", this.fkv != null ? this.fkv.getId() : "").dR("fname", this.fkv != null ? this.fkv.getName() : "").w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("obj_param1", subBottomMenu.name));
        }
    }
}
