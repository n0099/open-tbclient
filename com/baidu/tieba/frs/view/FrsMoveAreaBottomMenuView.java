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
/* loaded from: classes16.dex */
public class FrsMoveAreaBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private TextView dDA;
    private TextView iyM;
    private View iyN;
    private FrsMoveAreaChooseView iyO;
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
        this.dDA = (TextView) findViewById(R.id.frs_move_area_cancel);
        this.iyM = (TextView) findViewById(R.id.frs_move_area_move);
        this.iyN = findViewById(R.id.frs_move_area_top_line);
        this.dDA.setOnClickListener(this);
        this.iyM.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public boolean cuI() {
        return this.iyO != null && this.iyO.getVisibility() == 0;
    }

    public void cuJ() {
        if (this.iyO.getParent() != null) {
            ((ViewGroup) this.iyO.getParent()).removeView(this.iyO);
            this.iyO = null;
        }
    }

    public void setMoveNumber(int i) {
        String string = getContext().getString(R.string.frs_move_area_move);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.iyM.setText(string);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof String) {
            cuJ();
        } else if (view == this.dDA) {
            this.iyO = null;
            com.baidu.tieba.frs.a.ckM().reset();
        } else if (view == this.iyM) {
            if (this.mPageContext == null || this.iyO != null || y.isEmpty(com.baidu.tieba.frs.a.ckM().ckQ())) {
                if (this.iyO == null && getContext() != null) {
                    new BdTopToast(getContext()).wU(false).Sp(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_choose_empty)).aE((ViewGroup) getParent());
                    return;
                }
                return;
            }
            this.iyO = new FrsMoveAreaChooseView(this.mPageContext);
            this.iyO.setOnClickListener(this);
            ((ViewGroup) getParent()).addView(this.iyO, -1, -1);
        } else if (this.iyO != null && view == this.iyO) {
            cuJ();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, Integer.valueOf(i == 0 ? 0 : 1)));
        super.setVisibility(i);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.dDA, R.color.cp_cont_b);
        ap.setBackgroundResource(this.dDA, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.iyM, R.color.cp_link_tip_a);
        ap.setBackgroundResource(this.iyM, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setBackgroundColor(this.iyN, R.color.cp_bg_line_c);
    }
}
