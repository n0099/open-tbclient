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
    private int boS;
    private ForumData cvm;
    private ImageView fDl;
    private BottomMenuView fDm;
    private List<BottomMenu> fDn;
    private int fDo;
    private int fDp;
    private TbPageContext<?> mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.fDl = (ImageView) view.findViewById(R.id.normal_write_icon);
        this.fDm = (BottomMenuView) view.findViewById(R.id.bottom_menu_view);
        this.fDm.setOnMenuItemClickListener(this);
        this.boS = l.g(tbPageContext.getPageActivity(), R.dimen.tbds160);
        this.fDo = l.g(tbPageContext.getPageActivity(), R.dimen.tbds44);
        this.fDp = l.g(tbPageContext.getPageActivity(), R.dimen.ds4);
    }

    public void a(List<BottomMenu> list, ForumData forumData) {
        this.fDn = list;
        this.cvm = forumData;
        boolean z = v.Z(list) > 0;
        kw(z);
        if (z) {
            this.fDm.setVisibility(0);
            this.fDm.a(list, this.mPageContext);
            return;
        }
        this.fDm.setVisibility(8);
    }

    private void kw(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fDl.getLayoutParams();
        if (z) {
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.addRule(14, 0);
            layoutParams.bottomMargin = this.boS;
            layoutParams.rightMargin = this.fDo;
            return;
        }
        layoutParams.addRule(11, 0);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = this.fDp;
        layoutParams.rightMargin = 0;
    }

    public void kx(boolean z) {
        this.fDm.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.fDm.getVisibility() == 0) {
            this.fDm.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && v.Z(bottomMenu.submenu) == 0) {
            ba.ajK().c(this.mPageContext, new String[]{bottomMenu.url});
            TiebaStatic.log(new an("c13117").bT("fid", this.cvm != null ? this.cvm.getId() : "").bT(ImageViewerConfig.FORUM_NAME, this.cvm != null ? this.cvm.getName() : "").n("uid", currentAccountId).bT("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new an("c13118").n("uid", currentAccountId));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            ba.ajK().c(this.mPageContext, new String[]{subBottomMenu.url});
            TiebaStatic.log(new an("c13117").bT("fid", this.cvm != null ? this.cvm.getId() : "").bT(ImageViewerConfig.FORUM_NAME, this.cvm != null ? this.cvm.getName() : "").n("uid", TbadkCoreApplication.getCurrentAccountId()).bT("obj_param1", subBottomMenu.name));
        }
    }
}
