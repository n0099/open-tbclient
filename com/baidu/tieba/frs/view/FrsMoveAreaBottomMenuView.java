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
    private TextView elj;
    private TextView jBE;
    private View jBF;
    private FrsMoveAreaChooseView jBG;
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
        this.elj = (TextView) findViewById(R.id.frs_move_area_cancel);
        this.jBE = (TextView) findViewById(R.id.frs_move_area_move);
        this.jBF = findViewById(R.id.frs_move_area_top_line);
        this.elj.setOnClickListener(this);
        this.jBE.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public boolean cMa() {
        return this.jBG != null && this.jBG.getVisibility() == 0;
    }

    public void cMb() {
        if (this.jBG.getParent() != null) {
            ((ViewGroup) this.jBG.getParent()).removeView(this.jBG);
            this.jBG = null;
        }
    }

    public void setMoveNumber(int i) {
        String string = getContext().getString(R.string.frs_move_area_move);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.jBE.setText(string);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof String) {
            cMb();
        } else if (view == this.elj) {
            this.jBG = null;
            com.baidu.tieba.frs.a.cAW().reset();
        } else if (view == this.jBE) {
            if (this.mPageContext == null || this.jBG != null || y.isEmpty(com.baidu.tieba.frs.a.cAW().cBa())) {
                if (this.jBG == null && getContext() != null) {
                    new BdTopToast(getContext()).yW(false).Vt(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_choose_empty)).aF((ViewGroup) getParent());
                    return;
                }
                return;
            }
            this.jBG = new FrsMoveAreaChooseView(this.mPageContext);
            this.jBG.setOnClickListener(this);
            ((ViewGroup) getParent()).addView(this.jBG, -1, -1);
        } else if (this.jBG != null && view == this.jBG) {
            cMb();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, Integer.valueOf(i == 0 ? 0 : 1)));
        super.setVisibility(i);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setViewTextColor(this.elj, R.color.CAM_X0105);
        ap.setBackgroundResource(this.elj, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.jBE, R.color.CAM_X0302);
        ap.setBackgroundResource(this.jBE, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setBackgroundColor(this.jBF, R.color.CAM_X0204);
    }
}
