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
import d.b.j0.q0.a;
import java.util.Locale;
/* loaded from: classes4.dex */
public class FrsMoveAreaBottomMenuView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f16398e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16399f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16400g;

    /* renamed from: h  reason: collision with root package name */
    public View f16401h;
    public FrsMoveAreaChooseView i;

    public FrsMoveAreaBottomMenuView(Context context) {
        this(context, null);
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_move_area_bottom_menu_layout, this);
        this.f16399f = (TextView) findViewById(R.id.frs_move_area_cancel);
        this.f16400g = (TextView) findViewById(R.id.frs_move_area_move);
        this.f16401h = findViewById(R.id.frs_move_area_top_line);
        this.f16399f.setOnClickListener(this);
        this.f16400g.setOnClickListener(this);
        c();
        setClickable(true);
    }

    public boolean b() {
        FrsMoveAreaChooseView frsMoveAreaChooseView = this.i;
        return frsMoveAreaChooseView != null && frsMoveAreaChooseView.getVisibility() == 0;
    }

    public void c() {
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f16399f, R.color.CAM_X0105);
        SkinManager.setBackgroundResource(this.f16399f, R.drawable.bg_bottom_up_list_dialog_item);
        SkinManager.setViewTextColor(this.f16400g, R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.f16400g, R.drawable.bg_bottom_up_list_dialog_item);
        SkinManager.setBackgroundColor(this.f16401h, R.color.CAM_X0204);
    }

    public void d() {
        if (this.i.getParent() != null) {
            ((ViewGroup) this.i.getParent()).removeView(this.i);
            this.i = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof String) {
            d();
        } else if (view == this.f16399f) {
            this.i = null;
            a.h().n();
        } else if (view == this.f16400g) {
            if (this.f16398e != null && this.i == null && !ListUtils.isEmpty(a.h().i())) {
                FrsMoveAreaChooseView frsMoveAreaChooseView = new FrsMoveAreaChooseView(this.f16398e);
                this.i = frsMoveAreaChooseView;
                frsMoveAreaChooseView.setOnClickListener(this);
                ((ViewGroup) getParent()).addView(this.i, -1, -1);
            } else if (this.i != null || getContext() == null) {
            } else {
                BdTopToast bdTopToast = new BdTopToast(getContext());
                bdTopToast.i(false);
                bdTopToast.h(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_choose_empty));
                bdTopToast.j((ViewGroup) getParent());
            }
        } else {
            FrsMoveAreaChooseView frsMoveAreaChooseView2 = this.i;
            if (frsMoveAreaChooseView2 == null || view != frsMoveAreaChooseView2) {
                return;
            }
            d();
        }
    }

    public void setMoveNumber(int i) {
        String string = getContext().getString(R.string.frs_move_area_move);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.f16400g.setText(string);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.f16398e = tbPageContext;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, Integer.valueOf(i == 0 ? 0 : 1)));
        super.setVisibility(i);
    }

    public FrsMoveAreaBottomMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsMoveAreaBottomMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
