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
/* loaded from: classes4.dex */
public class a implements BottomMenuView.a {
    private int bGN;
    private ForumData cGF;
    private ImageView fBL;
    private BottomMenuView fBM;
    private List<BottomMenu> fBN;
    private int fBO;
    private int fBP;
    private TbPageContext<?> mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.fBL = (ImageView) view.findViewById(R.id.normal_write_icon);
        this.fBM = (BottomMenuView) view.findViewById(R.id.bottom_menu_view);
        this.fBM.setOnMenuItemClickListener(this);
        this.bGN = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds160);
        this.fBO = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds44);
        this.fBP = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds4);
    }

    public void a(List<BottomMenu> list, ForumData forumData) {
        this.fBN = list;
        this.cGF = forumData;
        boolean z = v.getCount(list) > 0;
        kj(z);
        if (z) {
            this.fBM.setVisibility(0);
            this.fBM.a(list, this.mPageContext);
            return;
        }
        this.fBM.setVisibility(8);
    }

    private void kj(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fBL.getLayoutParams();
        if (z) {
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.addRule(14, 0);
            layoutParams.bottomMargin = this.bGN;
            layoutParams.rightMargin = this.fBO;
            return;
        }
        layoutParams.addRule(11, 0);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = this.fBP;
        layoutParams.rightMargin = 0;
    }

    public void kk(boolean z) {
        this.fBM.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.fBM.getVisibility() == 0) {
            this.fBM.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && v.getCount(bottomMenu.submenu) == 0) {
            ba.amO().b(this.mPageContext, new String[]{bottomMenu.url});
            TiebaStatic.log(new an("c13117").bS("fid", this.cGF != null ? this.cGF.getId() : "").bS("fname", this.cGF != null ? this.cGF.getName() : "").p("uid", currentAccountId).bS("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new an("c13118").p("uid", currentAccountId));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            ba.amO().b(this.mPageContext, new String[]{subBottomMenu.url});
            TiebaStatic.log(new an("c13117").bS("fid", this.cGF != null ? this.cGF.getId() : "").bS("fname", this.cGF != null ? this.cGF.getName() : "").p("uid", TbadkCoreApplication.getCurrentAccountId()).bS("obj_param1", subBottomMenu.name));
        }
    }
}
