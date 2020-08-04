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
    private ImageView hNe;
    private BottomMenuView hNf;
    private List<BottomMenu> hNg;
    private int hNh;
    private int mMarginBottom;
    private int mMarginRight;
    private TbPageContext<?> mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.hNe = (ImageView) view.findViewById(R.id.normal_write_icon);
        this.hNf = (BottomMenuView) view.findViewById(R.id.bottom_menu_view);
        this.hNf.setOnMenuItemClickListener(this);
        this.mMarginBottom = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds160);
        this.mMarginRight = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds44);
        this.hNh = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds4);
    }

    public void a(List<BottomMenu> list, ForumData forumData) {
        this.hNg = list;
        this.eCv = forumData;
        boolean z = x.getCount(list) > 0;
        od(z);
        if (z) {
            this.hNf.setVisibility(0);
            this.hNf.a(list, this.mPageContext);
            return;
        }
        this.hNf.setVisibility(8);
    }

    private void od(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hNe.getLayoutParams();
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
        layoutParams.bottomMargin = this.hNh;
        layoutParams.rightMargin = 0;
    }

    public void oe(boolean z) {
        this.hNf.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.hNf.getVisibility() == 0) {
            this.hNf.onChangeSkinType(tbPageContext, i);
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
