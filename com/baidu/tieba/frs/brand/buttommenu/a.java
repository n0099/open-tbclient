package com.baidu.tieba.frs.brand.buttommenu;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.brand.buttommenu.BottomMenuView;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes16.dex */
public class a implements BottomMenuView.a {
    private ForumData eCv;
    private ImageView hNc;
    private BottomMenuView hNd;
    private List<BottomMenu> hNe;
    private int hNf;
    private int mMarginBottom;
    private int mMarginRight;
    private TbPageContext<?> mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.hNc = (ImageView) view.findViewById(R.id.normal_write_icon);
        this.hNd = (BottomMenuView) view.findViewById(R.id.bottom_menu_view);
        this.hNd.setOnMenuItemClickListener(this);
        this.mMarginBottom = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds160);
        this.mMarginRight = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds44);
        this.hNf = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds4);
    }

    public void a(List<BottomMenu> list, ForumData forumData) {
        this.hNe = list;
        this.eCv = forumData;
        boolean z = x.getCount(list) > 0;
        od(z);
        if (z) {
            this.hNd.setVisibility(0);
            this.hNd.a(list, this.mPageContext);
            return;
        }
        this.hNd.setVisibility(8);
    }

    private void od(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hNc.getLayoutParams();
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
        layoutParams.bottomMargin = this.hNf;
        layoutParams.rightMargin = 0;
    }

    public void oe(boolean z) {
        this.hNd.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.hNd.getVisibility() == 0) {
            this.hNd.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.MenuItemView menuItemView, BottomMenu bottomMenu) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (bottomMenu != null && x.getCount(bottomMenu.submenu) == 0) {
            bd.baV().b(this.mPageContext, new String[]{bottomMenu.url});
            TiebaStatic.log(new ap("c13117").dn("fid", this.eCv != null ? this.eCv.getId() : "").dn("fname", this.eCv != null ? this.eCv.getName() : "").t("uid", currentAccountId).dn("obj_param1", bottomMenu.name));
            return;
        }
        TiebaStatic.log(new ap("c13118").t("uid", currentAccountId));
    }

    @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.a
    public void a(BottomMenuView.SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu) {
        if (subBottomMenu != null) {
            bd.baV().b(this.mPageContext, new String[]{subBottomMenu.url});
            TiebaStatic.log(new ap("c13117").dn("fid", this.eCv != null ? this.eCv.getId() : "").dn("fname", this.eCv != null ? this.eCv.getName() : "").t("uid", TbadkCoreApplication.getCurrentAccountId()).dn("obj_param1", subBottomMenu.name));
        }
    }
}
