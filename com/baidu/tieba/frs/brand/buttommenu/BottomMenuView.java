package com.baidu.tieba.frs.brand.buttommenu;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes9.dex */
public class BottomMenuView extends LinearLayout {
    private View cDw;
    private a hfb;
    private LinearLayout hfc;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    /* loaded from: classes9.dex */
    public interface a {
        void a(MenuItemView menuItemView, BottomMenu bottomMenu);

        void a(SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu);
    }

    public BottomMenuView(Context context) {
        this(context, null);
    }

    public BottomMenuView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomMenuView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
    }

    public void setOnMenuItemClickListener(a aVar) {
        this.hfb = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!v.isEmpty(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.cDw = new View(getContext());
            this.cDw.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16)));
            this.cDw.setBackgroundResource(R.drawable.bottom_view_shadow);
            addView(this.cDw);
            this.hfc = new LinearLayout(getContext());
            this.hfc.setOrientation(0);
            this.hfc.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.hfc);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.hfb);
                this.hfc.addView(menuItemView);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.hfc != null) {
            this.mSkinType = i;
            int childCount = this.hfc.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.hfc.getChildAt(i2);
                if (childAt != null) {
                    if (childAt instanceof MenuItemView) {
                        ((MenuItemView) childAt).onChangeSkinType(tbPageContext, i);
                    } else {
                        am.setBackgroundColor(childAt, R.color.cp_bg_line_c);
                    }
                } else {
                    return;
                }
            }
            am.setBackgroundColor(this.cDw, R.color.cp_bg_line_c);
        }
    }

    /* loaded from: classes9.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        private a hfb;
        private int hfd;
        private ImageView hfe;
        private TextView hff;
        private BottomMenu hfg;
        private boolean hfh;
        private b hfi;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.hfd = R.drawable.icon_card_morelist_n;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.hfe = (ImageView) findViewById(R.id.item_image);
            this.hff = (TextView) findViewById(R.id.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.hfb = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.hfg = bottomMenu;
                this.hfh = v.getCount(bottomMenu.submenu) > 0;
                this.hff.setText(bottomMenu.name);
                onChangeSkinType(this.mPageContext, 0);
            }
        }

        public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.hfd);
            am.setViewTextColor(this.hff, (int) R.color.cp_cont_b);
            am.setBackgroundResource(this, R.drawable.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.hfd = i;
            if (this.hfh) {
                this.hfe.setVisibility(0);
                this.hfe.setImageResource(i);
                am.setImageResource(this.hfe, i);
                return;
            }
            this.hfe.setVisibility(8);
        }

        public e getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.hfh) {
                getSubMenuGenerator().a(this, this.hfg.submenu);
            }
            if (this.hfb != null) {
                this.hfb.a(this, this.hfg);
            }
        }

        private b getSubMenuGenerator() {
            if (this.hfi == null) {
                this.hfi = new b();
                this.hfi.setOnMenuItemClickListener(this.hfb);
            }
            return this.hfi;
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements View.OnClickListener {
        private a hfb;
        private RelativeLayout hfj;
        private final int[] mLocation = new int[2];
        private PopupWindow mPopupWindow;

        public void setOnMenuItemClickListener(a aVar) {
            this.hfb = aVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !v.isEmpty(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.hfj = new RelativeLayout(pageActivity);
                this.hfj.setBackgroundColor(am.getColor(R.color.cp_mask_b_alpha66));
                this.hfj.setOnClickListener(this);
                LinearLayout linearLayout = new LinearLayout(pageActivity);
                linearLayout.setOrientation(1);
                int size = list.size();
                int i = 0;
                while (i < size) {
                    SubMenuItemView subMenuItemView = new SubMenuItemView(pageActivity);
                    subMenuItemView.setSubMenuData(list.get(i), i, i == size + (-1));
                    subMenuItemView.setOnClickListener(this);
                    linearLayout.addView(subMenuItemView);
                    i++;
                }
                this.hfj.addView(linearLayout);
                menuItemView.getLocationInWindow(this.mLocation);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mLocation[0];
                this.mPopupWindow = new PopupWindow(this.hfj, -1, this.mLocation[1]);
                this.mPopupWindow.setOutsideTouchable(true);
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setClippingEnabled(false);
                this.mPopupWindow.setBackgroundDrawable(new ColorDrawable());
                this.mPopupWindow.setSoftInputMode(16);
                g.showPopupWindowAtLocation(this.mPopupWindow, menuItemView, 51, 0, 0);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view instanceof SubMenuItemView) {
                g.dismissPopupWindow(this.mPopupWindow);
                SubMenuItemView subMenuItemView = (SubMenuItemView) view;
                if (this.hfb != null) {
                    this.hfb.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.hfj) {
                g.dismissPopupWindow(this.mPopupWindow);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class SubMenuItemView extends LinearLayout {
        private View cXJ;
        private SubBottomMenu hfk;
        private TextView mTitleView;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(R.layout.bottom_submenu_item, this);
            setOrientation(1);
            this.mTitleView = (TextView) findViewById(R.id.item_text);
            this.cXJ = findViewById(R.id.divider_line);
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu != null) {
                this.hfk = subBottomMenu;
                this.mTitleView.setText(subBottomMenu.name);
                am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_f);
                am.setBackgroundResource(this, i == 0 ? R.drawable.bottom_menu_item_bg_corner_selector : R.drawable.bottom_menu_item_bg_selector);
                if (z) {
                    this.cXJ.setVisibility(8);
                    return;
                }
                this.cXJ.setVisibility(0);
                am.setBackgroundColor(this.cXJ, R.color.cp_bg_line_c);
            }
        }

        public SubBottomMenu getSubMenuData() {
            return this.hfk;
        }
    }
}
