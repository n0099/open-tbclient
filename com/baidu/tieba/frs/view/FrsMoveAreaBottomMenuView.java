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
/* loaded from: classes2.dex */
public class FrsMoveAreaBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private TextView epA;
    private TextView jJC;
    private View jJD;
    private FrsMoveAreaChooseView jJE;
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
        this.epA = (TextView) findViewById(R.id.frs_move_area_cancel);
        this.jJC = (TextView) findViewById(R.id.frs_move_area_move);
        this.jJD = findViewById(R.id.frs_move_area_top_line);
        this.epA.setOnClickListener(this);
        this.jJC.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public boolean cLn() {
        return this.jJE != null && this.jJE.getVisibility() == 0;
    }

    public void cLo() {
        if (this.jJE.getParent() != null) {
            ((ViewGroup) this.jJE.getParent()).removeView(this.jJE);
            this.jJE = null;
        }
    }

    public void setMoveNumber(int i) {
        String string = getContext().getString(R.string.frs_move_area_move);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.jJC.setText(string);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof String) {
            cLo();
        } else if (view == this.epA) {
            this.jJE = null;
            com.baidu.tieba.frs.a.czZ().reset();
        } else if (view == this.jJC) {
            if (this.mPageContext == null || this.jJE != null || x.isEmpty(com.baidu.tieba.frs.a.czZ().cAd())) {
                if (this.jJE == null && getContext() != null) {
                    new BdTopToast(getContext()).yS(false).TQ(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_choose_empty)).aR((ViewGroup) getParent());
                    return;
                }
                return;
            }
            this.jJE = new FrsMoveAreaChooseView(this.mPageContext);
            this.jJE.setOnClickListener(this);
            ((ViewGroup) getParent()).addView(this.jJE, -1, -1);
        } else if (this.jJE != null && view == this.jJE) {
            cLo();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, Integer.valueOf(i == 0 ? 0 : 1)));
        super.setVisibility(i);
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this, R.color.CAM_X0201);
        ao.setViewTextColor(this.epA, R.color.CAM_X0105);
        ao.setBackgroundResource(this.epA, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setViewTextColor(this.jJC, R.color.CAM_X0302);
        ao.setBackgroundResource(this.jJC, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setBackgroundColor(this.jJD, R.color.CAM_X0204);
    }
}
