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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.brand.buttommenu.BottomMenuView;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes4.dex */
public class a implements BottomMenuView.a {
    private int bou;
    private ForumData cup;
    private List<BottomMenu> fBA;
    private int fBB;
    private int fBC;
    private ImageView fBy;
    private BottomMenuView fBz;
    private TbPageContext<?> mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.fBy = (ImageView) view.findViewById(R.id.normal_write_icon);
        this.fBz = (BottomMenuView) view.findViewById(R.id.bottom_menu_view);
        this.fBz.setOnMenuItemClickListener(this);
        this.bou = l.g(tbPageContext.getPageActivity(), R.dimen.tbds160);
        this.fBB = l.g(tbPageContext.getPageActivity(), R.dimen.tbds44);
        this.fBC = l.g(tbPageContext.getPageActivity(), R.dimen.ds4);
    }

    public void a(List<BottomMenu> list, ForumData forumData) {
        this.fBA = list;
        this.cup = forumData;
        boolean z = v.Z(list) > 0;
        kt(z);
        if (z) {
            this.fBz.setVisibility(0);
            this.fBz.a(list, this.mPageContext);
            return;
        }
        this.fBz.setVisibility(8);
    }

    private void kt(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fBy.getLayoutParams();
        if (z) {
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.addRule(14, 0);
            layoutParams.bottomMargin = this.bou;
            layoutParams.rightMargin = this.fBB;
            return;
        }
        layoutParams.addRule(11, 0);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = this.fBC;
        layoutParams.rightMargin = 0;
    }

    public void ku(boolean z) {
        this.fBz.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.fBz.getVisibility() == 0) {
            this.fBz.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && v.Z(bottomMenu.submenu) == 0) {
            bb.ajE().c(this.mPageContext, new String[]{bottomMenu.url});
            TiebaStatic.log(new an("c13117").bT("fid", this.cup != null ? this.cup.getId() : "").bT(ImageViewerConfig.FORUM_NAME, this.cup != null ? this.cup.getName() : "").l("uid", currentAccountId).bT("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new an("c13118").l("uid", currentAccountId));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            bb.ajE().c(this.mPageContext, new String[]{subBottomMenu.url});
            TiebaStatic.log(new an("c13117").bT("fid", this.cup != null ? this.cup.getId() : "").bT(ImageViewerConfig.FORUM_NAME, this.cup != null ? this.cup.getName() : "").l("uid", TbadkCoreApplication.getCurrentAccountId()).bT("obj_param1", subBottomMenu.name));
        }
    }
}
