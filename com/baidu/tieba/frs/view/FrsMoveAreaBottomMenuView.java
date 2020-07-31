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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import java.util.Locale;
/* loaded from: classes16.dex */
public class FrsMoveAreaBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private TextView dtx;
    private TextView ikB;
    private View ikC;
    private FrsMoveAreaChooseView ikD;
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
        this.dtx = (TextView) findViewById(R.id.frs_move_area_cancel);
        this.ikB = (TextView) findViewById(R.id.frs_move_area_move);
        this.ikC = findViewById(R.id.frs_move_area_top_line);
        this.dtx.setOnClickListener(this);
        this.ikB.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public boolean ckd() {
        return this.ikD != null && this.ikD.getVisibility() == 0;
    }

    public void cke() {
        if (this.ikD.getParent() != null) {
            ((ViewGroup) this.ikD.getParent()).removeView(this.ikD);
            this.ikD = null;
        }
    }

    public void setMoveNumber(int i) {
        String string = getContext().getString(R.string.frs_move_area_move);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.ikB.setText(string);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof String) {
            cke();
        } else if (view == this.dtx) {
            this.ikD = null;
            com.baidu.tieba.frs.a.cap().reset();
        } else if (view == this.ikB) {
            if (this.mPageContext == null || this.ikD != null || x.isEmpty(com.baidu.tieba.frs.a.cap().cat())) {
                if (this.ikD == null && getContext() != null) {
                    new BdTopToast(getContext()).wd(false).Pr(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_choose_empty)).aF((ViewGroup) getParent());
                    return;
                }
                return;
            }
            this.ikD = new FrsMoveAreaChooseView(this.mPageContext);
            this.ikD.setOnClickListener(this);
            ((ViewGroup) getParent()).addView(this.ikD, -1, -1);
        } else if (this.ikD != null && view == this.ikD) {
            cke();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, Integer.valueOf(i == 0 ? 0 : 1)));
        super.setVisibility(i);
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.dtx, R.color.cp_cont_b);
        ao.setBackgroundResource(this.dtx, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setViewTextColor(this.ikB, R.color.cp_link_tip_a);
        ao.setBackgroundResource(this.ikB, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setBackgroundColor(this.ikC, R.color.cp_bg_line_c);
    }
}
