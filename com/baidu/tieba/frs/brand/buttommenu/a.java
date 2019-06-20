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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.brand.buttommenu.BottomMenuView;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes4.dex */
public class a implements BottomMenuView.a {
    private int bnH;
    private ForumData csV;
    private ImageView fvO;
    private BottomMenuView fvP;
    private List<BottomMenu> fvQ;
    private int fvR;
    private int fvS;
    private TbPageContext<?> mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.fvO = (ImageView) view.findViewById(R.id.normal_write_icon);
        this.fvP = (BottomMenuView) view.findViewById(R.id.bottom_menu_view);
        this.fvP.setOnMenuItemClickListener(this);
        this.bnH = l.g(tbPageContext.getPageActivity(), R.dimen.tbds160);
        this.fvR = l.g(tbPageContext.getPageActivity(), R.dimen.tbds44);
        this.fvS = l.g(tbPageContext.getPageActivity(), R.dimen.ds4);
    }

    public void a(List<BottomMenu> list, ForumData forumData) {
        this.fvQ = list;
        this.csV = forumData;
        boolean z = v.Z(list) > 0;
        kj(z);
        if (z) {
            this.fvP.setVisibility(0);
            this.fvP.a(list, this.mPageContext);
            return;
        }
        this.fvP.setVisibility(8);
    }

    private void kj(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fvO.getLayoutParams();
        if (z) {
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.addRule(14, 0);
            layoutParams.bottomMargin = this.bnH;
            layoutParams.rightMargin = this.fvR;
            return;
        }
        layoutParams.addRule(11, 0);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = this.fvS;
        layoutParams.rightMargin = 0;
    }

    public void kk(boolean z) {
        this.fvP.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.fvP.getVisibility() == 0) {
            this.fvP.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && v.Z(bottomMenu.submenu) == 0) {
            ba.aiz().c(this.mPageContext, new String[]{bottomMenu.url});
            TiebaStatic.log(new am("c13117").bT("fid", this.csV != null ? this.csV.getId() : "").bT(ImageViewerConfig.FORUM_NAME, this.csV != null ? this.csV.getName() : "").l("uid", currentAccountId).bT("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new am("c13118").l("uid", currentAccountId));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            ba.aiz().c(this.mPageContext, new String[]{subBottomMenu.url});
            TiebaStatic.log(new am("c13117").bT("fid", this.csV != null ? this.csV.getId() : "").bT(ImageViewerConfig.FORUM_NAME, this.csV != null ? this.csV.getName() : "").l("uid", TbadkCoreApplication.getCurrentAccountId()).bT("obj_param1", subBottomMenu.name));
        }
    }
}
