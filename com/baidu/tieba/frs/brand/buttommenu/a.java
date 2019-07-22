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
    private ForumData cui;
    private ImageView fAK;
    private BottomMenuView fAL;
    private List<BottomMenu> fAM;
    private int fAN;
    private int fAO;
    private TbPageContext<?> mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.fAK = (ImageView) view.findViewById(R.id.normal_write_icon);
        this.fAL = (BottomMenuView) view.findViewById(R.id.bottom_menu_view);
        this.fAL.setOnMenuItemClickListener(this);
        this.bou = l.g(tbPageContext.getPageActivity(), R.dimen.tbds160);
        this.fAN = l.g(tbPageContext.getPageActivity(), R.dimen.tbds44);
        this.fAO = l.g(tbPageContext.getPageActivity(), R.dimen.ds4);
    }

    public void a(List<BottomMenu> list, ForumData forumData) {
        this.fAM = list;
        this.cui = forumData;
        boolean z = v.Z(list) > 0;
        kt(z);
        if (z) {
            this.fAL.setVisibility(0);
            this.fAL.a(list, this.mPageContext);
            return;
        }
        this.fAL.setVisibility(8);
    }

    private void kt(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fAK.getLayoutParams();
        if (z) {
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.addRule(14, 0);
            layoutParams.bottomMargin = this.bou;
            layoutParams.rightMargin = this.fAN;
            return;
        }
        layoutParams.addRule(11, 0);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = this.fAO;
        layoutParams.rightMargin = 0;
    }

    public void ku(boolean z) {
        this.fAL.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.fAL.getVisibility() == 0) {
            this.fAL.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && v.Z(bottomMenu.submenu) == 0) {
            bb.ajC().c(this.mPageContext, new String[]{bottomMenu.url});
            TiebaStatic.log(new an("c13117").bT("fid", this.cui != null ? this.cui.getId() : "").bT(ImageViewerConfig.FORUM_NAME, this.cui != null ? this.cui.getName() : "").l("uid", currentAccountId).bT("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new an("c13118").l("uid", currentAccountId));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            bb.ajC().c(this.mPageContext, new String[]{subBottomMenu.url});
            TiebaStatic.log(new an("c13117").bT("fid", this.cui != null ? this.cui.getId() : "").bT(ImageViewerConfig.FORUM_NAME, this.cui != null ? this.cui.getName() : "").l("uid", TbadkCoreApplication.getCurrentAccountId()).bT("obj_param1", subBottomMenu.name));
        }
    }
}
