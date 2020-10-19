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
/* loaded from: classes22.dex */
public class FrsMoveAreaBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private TextView dRC;
    private TextView iUY;
    private View iUZ;
    private FrsMoveAreaChooseView iVa;
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
        this.dRC = (TextView) findViewById(R.id.frs_move_area_cancel);
        this.iUY = (TextView) findViewById(R.id.frs_move_area_move);
        this.iUZ = findViewById(R.id.frs_move_area_top_line);
        this.dRC.setOnClickListener(this);
        this.iUY.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public boolean cBy() {
        return this.iVa != null && this.iVa.getVisibility() == 0;
    }

    public void cBz() {
        if (this.iVa.getParent() != null) {
            ((ViewGroup) this.iVa.getParent()).removeView(this.iVa);
            this.iVa = null;
        }
    }

    public void setMoveNumber(int i) {
        String string = getContext().getString(R.string.frs_move_area_move);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.iUY.setText(string);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof String) {
            cBz();
        } else if (view == this.dRC) {
            this.iVa = null;
            com.baidu.tieba.frs.a.crx().reset();
        } else if (view == this.iUY) {
            if (this.mPageContext == null || this.iVa != null || y.isEmpty(com.baidu.tieba.frs.a.crx().crB())) {
                if (this.iVa == null && getContext() != null) {
                    new BdTopToast(getContext()).xK(false).TD(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_choose_empty)).aH((ViewGroup) getParent());
                    return;
                }
                return;
            }
            this.iVa = new FrsMoveAreaChooseView(this.mPageContext);
            this.iVa.setOnClickListener(this);
            ((ViewGroup) getParent()).addView(this.iVa, -1, -1);
        } else if (this.iVa != null && view == this.iVa) {
            cBz();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, Integer.valueOf(i == 0 ? 0 : 1)));
        super.setVisibility(i);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.dRC, R.color.cp_cont_b);
        ap.setBackgroundResource(this.dRC, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.iUY, R.color.cp_link_tip_a);
        ap.setBackgroundResource(this.iUY, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setBackgroundColor(this.iUZ, R.color.cp_bg_line_c);
    }
}
