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
    private TextView euo;
    private TextView jOi;
    private View jOj;
    private FrsMoveAreaChooseView jOk;
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
        this.euo = (TextView) findViewById(R.id.frs_move_area_cancel);
        this.jOi = (TextView) findViewById(R.id.frs_move_area_move);
        this.jOj = findViewById(R.id.frs_move_area_top_line);
        this.euo.setOnClickListener(this);
        this.jOi.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public boolean cPe() {
        return this.jOk != null && this.jOk.getVisibility() == 0;
    }

    public void cPf() {
        if (this.jOk.getParent() != null) {
            ((ViewGroup) this.jOk.getParent()).removeView(this.jOk);
            this.jOk = null;
        }
    }

    public void setMoveNumber(int i) {
        String string = getContext().getString(R.string.frs_move_area_move);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.jOi.setText(string);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof String) {
            cPf();
        } else if (view == this.euo) {
            this.jOk = null;
            com.baidu.tieba.frs.a.cDQ().reset();
        } else if (view == this.jOi) {
            if (this.mPageContext == null || this.jOk != null || x.isEmpty(com.baidu.tieba.frs.a.cDQ().cDU())) {
                if (this.jOk == null && getContext() != null) {
                    new BdTopToast(getContext()).yW(false).UY(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_choose_empty)).aR((ViewGroup) getParent());
                    return;
                }
                return;
            }
            this.jOk = new FrsMoveAreaChooseView(this.mPageContext);
            this.jOk.setOnClickListener(this);
            ((ViewGroup) getParent()).addView(this.jOk, -1, -1);
        } else if (this.jOk != null && view == this.jOk) {
            cPf();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, Integer.valueOf(i == 0 ? 0 : 1)));
        super.setVisibility(i);
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this, R.color.CAM_X0201);
        ao.setViewTextColor(this.euo, R.color.CAM_X0105);
        ao.setBackgroundResource(this.euo, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setViewTextColor(this.jOi, R.color.CAM_X0302);
        ao.setBackgroundResource(this.jOi, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setBackgroundColor(this.jOj, R.color.CAM_X0204);
    }
}
