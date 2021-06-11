package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import d.a.n0.r0.a;
import java.util.Locale;
/* loaded from: classes4.dex */
public class FrsMoveAreaBottomMenuView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f15905e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15906f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15907g;

    /* renamed from: h  reason: collision with root package name */
    public View f15908h;

    /* renamed from: i  reason: collision with root package name */
    public FrsMoveAreaChooseView f15909i;

    public FrsMoveAreaBottomMenuView(Context context) {
        this(context, null);
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_move_area_bottom_menu_layout, this);
        this.f15906f = (TextView) findViewById(R.id.frs_move_area_cancel);
        this.f15907g = (TextView) findViewById(R.id.frs_move_area_move);
        this.f15908h = findViewById(R.id.frs_move_area_top_line);
        this.f15906f.setOnClickListener(this);
        this.f15907g.setOnClickListener(this);
        c();
        setClickable(true);
    }

    public boolean b() {
        FrsMoveAreaChooseView frsMoveAreaChooseView = this.f15909i;
        return frsMoveAreaChooseView != null && frsMoveAreaChooseView.getVisibility() == 0;
    }

    public void c() {
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f15906f, R.color.CAM_X0105);
        SkinManager.setBackgroundResource(this.f15906f, R.drawable.bg_bottom_up_list_dialog_item);
        SkinManager.setViewTextColor(this.f15907g, R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.f15907g, R.drawable.bg_bottom_up_list_dialog_item);
        SkinManager.setBackgroundColor(this.f15908h, R.color.CAM_X0204);
    }

    public void d() {
        if (this.f15909i.getParent() != null) {
            ((ViewGroup) this.f15909i.getParent()).removeView(this.f15909i);
            this.f15909i = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof String) {
            d();
        } else if (view == this.f15906f) {
            this.f15909i = null;
            a.h().n();
        } else if (view == this.f15907g) {
            if (this.f15905e != null && this.f15909i == null && !ListUtils.isEmpty(a.h().i())) {
                FrsMoveAreaChooseView frsMoveAreaChooseView = new FrsMoveAreaChooseView(this.f15905e);
                this.f15909i = frsMoveAreaChooseView;
                frsMoveAreaChooseView.setOnClickListener(this);
                ((ViewGroup) getParent()).addView(this.f15909i, -1, -1);
            } else if (this.f15909i != null || getContext() == null) {
            } else {
                BdTopToast bdTopToast = new BdTopToast(getContext());
                bdTopToast.i(false);
                bdTopToast.h(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_choose_empty));
                bdTopToast.j((ViewGroup) getParent());
            }
        } else {
            FrsMoveAreaChooseView frsMoveAreaChooseView2 = this.f15909i;
            if (frsMoveAreaChooseView2 == null || view != frsMoveAreaChooseView2) {
                return;
            }
            d();
        }
    }

    public void setMoveNumber(int i2) {
        String string = getContext().getString(R.string.frs_move_area_move);
        if (i2 > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i2));
        }
        this.f15907g.setText(string);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.f15905e = tbPageContext;
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, Integer.valueOf(i2 == 0 ? 0 : 1)));
        super.setVisibility(i2);
    }

    public FrsMoveAreaBottomMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsMoveAreaBottomMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
