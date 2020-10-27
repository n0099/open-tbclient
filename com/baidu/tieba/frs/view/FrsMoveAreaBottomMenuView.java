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
    private TextView dZY;
    private TextView jhu;
    private View jhv;
    private FrsMoveAreaChooseView jhw;
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
        this.dZY = (TextView) findViewById(R.id.frs_move_area_cancel);
        this.jhu = (TextView) findViewById(R.id.frs_move_area_move);
        this.jhv = findViewById(R.id.frs_move_area_top_line);
        this.dZY.setOnClickListener(this);
        this.jhu.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public boolean cEF() {
        return this.jhw != null && this.jhw.getVisibility() == 0;
    }

    public void cEG() {
        if (this.jhw.getParent() != null) {
            ((ViewGroup) this.jhw.getParent()).removeView(this.jhw);
            this.jhw = null;
        }
    }

    public void setMoveNumber(int i) {
        String string = getContext().getString(R.string.frs_move_area_move);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.jhu.setText(string);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof String) {
            cEG();
        } else if (view == this.dZY) {
            this.jhw = null;
            com.baidu.tieba.frs.a.cuE().reset();
        } else if (view == this.jhu) {
            if (this.mPageContext == null || this.jhw != null || y.isEmpty(com.baidu.tieba.frs.a.cuE().cuI())) {
                if (this.jhw == null && getContext() != null) {
                    new BdTopToast(getContext()).yb(false).Uc(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_choose_empty)).aH((ViewGroup) getParent());
                    return;
                }
                return;
            }
            this.jhw = new FrsMoveAreaChooseView(this.mPageContext);
            this.jhw.setOnClickListener(this);
            ((ViewGroup) getParent()).addView(this.jhw, -1, -1);
        } else if (this.jhw != null && view == this.jhw) {
            cEG();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, Integer.valueOf(i == 0 ? 0 : 1)));
        super.setVisibility(i);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.dZY, R.color.cp_cont_b);
        ap.setBackgroundResource(this.dZY, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.jhu, R.color.cp_link_tip_a);
        ap.setBackgroundResource(this.jhu, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setBackgroundColor(this.jhv, R.color.cp_bg_line_c);
    }
}
