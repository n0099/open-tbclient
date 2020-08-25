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
    private TextView dDw;
    private TextView iyG;
    private View iyH;
    private FrsMoveAreaChooseView iyI;
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
        this.dDw = (TextView) findViewById(R.id.frs_move_area_cancel);
        this.iyG = (TextView) findViewById(R.id.frs_move_area_move);
        this.iyH = findViewById(R.id.frs_move_area_top_line);
        this.dDw.setOnClickListener(this);
        this.iyG.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public boolean cuH() {
        return this.iyI != null && this.iyI.getVisibility() == 0;
    }

    public void cuI() {
        if (this.iyI.getParent() != null) {
            ((ViewGroup) this.iyI.getParent()).removeView(this.iyI);
            this.iyI = null;
        }
    }

    public void setMoveNumber(int i) {
        String string = getContext().getString(R.string.frs_move_area_move);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.iyG.setText(string);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof String) {
            cuI();
        } else if (view == this.dDw) {
            this.iyI = null;
            com.baidu.tieba.frs.a.ckL().reset();
        } else if (view == this.iyG) {
            if (this.mPageContext == null || this.iyI != null || y.isEmpty(com.baidu.tieba.frs.a.ckL().ckP())) {
                if (this.iyI == null && getContext() != null) {
                    new BdTopToast(getContext()).wS(false).Sp(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_choose_empty)).aE((ViewGroup) getParent());
                    return;
                }
                return;
            }
            this.iyI = new FrsMoveAreaChooseView(this.mPageContext);
            this.iyI.setOnClickListener(this);
            ((ViewGroup) getParent()).addView(this.iyI, -1, -1);
        } else if (this.iyI != null && view == this.iyI) {
            cuI();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, Integer.valueOf(i == 0 ? 0 : 1)));
        super.setVisibility(i);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.dDw, R.color.cp_cont_b);
        ap.setBackgroundResource(this.dDw, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.iyG, R.color.cp_link_tip_a);
        ap.setBackgroundResource(this.iyG, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setBackgroundColor(this.iyH, R.color.cp_bg_line_c);
    }
}
