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
/* loaded from: classes2.dex */
public class FrsMoveAreaBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private TextView etj;
    private TextView jSw;
    private View jSx;
    private FrsMoveAreaChooseView jSy;
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
        this.etj = (TextView) findViewById(R.id.frs_move_area_cancel);
        this.jSw = (TextView) findViewById(R.id.frs_move_area_move);
        this.jSx = findViewById(R.id.frs_move_area_top_line);
        this.etj.setOnClickListener(this);
        this.jSw.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public boolean cNp() {
        return this.jSy != null && this.jSy.getVisibility() == 0;
    }

    public void cNq() {
        if (this.jSy.getParent() != null) {
            ((ViewGroup) this.jSy.getParent()).removeView(this.jSy);
            this.jSy = null;
        }
    }

    public void setMoveNumber(int i) {
        String string = getContext().getString(R.string.frs_move_area_move);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.jSw.setText(string);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof String) {
            cNq();
        } else if (view == this.etj) {
            this.jSy = null;
            com.baidu.tieba.frs.a.cBx().reset();
        } else if (view == this.jSw) {
            if (this.mPageContext == null || this.jSy != null || y.isEmpty(com.baidu.tieba.frs.a.cBx().cBB())) {
                if (this.jSy == null && getContext() != null) {
                    new BdTopToast(getContext()).zm(false).Vg(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_choose_empty)).aR((ViewGroup) getParent());
                    return;
                }
                return;
            }
            this.jSy = new FrsMoveAreaChooseView(this.mPageContext);
            this.jSy.setOnClickListener(this);
            ((ViewGroup) getParent()).addView(this.jSy, -1, -1);
        } else if (this.jSy != null && view == this.jSy) {
            cNq();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, Integer.valueOf(i == 0 ? 0 : 1)));
        super.setVisibility(i);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setViewTextColor(this.etj, R.color.CAM_X0105);
        ap.setBackgroundResource(this.etj, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.jSw, R.color.CAM_X0302);
        ap.setBackgroundResource(this.jSw, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setBackgroundColor(this.jSx, R.color.CAM_X0204);
    }
}
