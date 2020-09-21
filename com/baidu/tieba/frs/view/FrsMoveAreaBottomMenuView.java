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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import java.util.Locale;
/* loaded from: classes21.dex */
public class FrsMoveAreaBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private TextView dFB;
    private TextView iGi;
    private View iGj;
    private FrsMoveAreaChooseView iGk;
    private TbPageContext mPageContext;

    public FrsMoveAreaBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMoveAreaBottomMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsMoveAreaBottomMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_move_area_bottom_menu_layout, this);
        this.dFB = (TextView) findViewById(R.id.frs_move_area_cancel);
        this.iGi = (TextView) findViewById(R.id.frs_move_area_move);
        this.iGj = findViewById(R.id.frs_move_area_top_line);
        this.dFB.setOnClickListener(this);
        this.iGi.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public boolean cyb() {
        return this.iGk != null && this.iGk.getVisibility() == 0;
    }

    public void cyc() {
        if (this.iGk.getParent() != null) {
            ((ViewGroup) this.iGk.getParent()).removeView(this.iGk);
            this.iGk = null;
        }
    }

    public void setMoveNumber(int i) {
        String string = getContext().getString(R.string.frs_move_area_move);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.iGi.setText(string);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof String) {
            cyc();
        } else if (view == this.dFB) {
            this.iGk = null;
            com.baidu.tieba.frs.a.cnZ().reset();
        } else if (view == this.iGi) {
            if (this.mPageContext == null || this.iGk != null || y.isEmpty(com.baidu.tieba.frs.a.cnZ().cod())) {
                if (this.iGk == null && getContext() != null) {
                    new BdTopToast(getContext()).xd(false).SP(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_choose_empty)).aF((ViewGroup) getParent());
                    return;
                }
                return;
            }
            this.iGk = new FrsMoveAreaChooseView(this.mPageContext);
            this.iGk.setOnClickListener(this);
            ((ViewGroup) getParent()).addView(this.iGk, -1, -1);
        } else if (this.iGk != null && view == this.iGk) {
            cyc();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, Integer.valueOf(i == 0 ? 0 : 1)));
        super.setVisibility(i);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.dFB, R.color.cp_cont_b);
        ap.setBackgroundResource(this.dFB, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.iGi, R.color.cp_link_tip_a);
        ap.setBackgroundResource(this.iGi, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setBackgroundColor(this.iGj, R.color.cp_bg_line_c);
    }
}
