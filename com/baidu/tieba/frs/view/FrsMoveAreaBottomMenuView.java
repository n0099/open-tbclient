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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import java.util.Locale;
/* loaded from: classes9.dex */
public class FrsMoveAreaBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private TextView dnB;
    private TextView ieB;
    private View ieC;
    private FrsMoveAreaChooseView ieD;
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
        this.dnB = (TextView) findViewById(R.id.frs_move_area_cancel);
        this.ieB = (TextView) findViewById(R.id.frs_move_area_move);
        this.ieC = findViewById(R.id.frs_move_area_top_line);
        this.dnB.setOnClickListener(this);
        this.ieB.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public boolean cgE() {
        return this.ieD != null && this.ieD.getVisibility() == 0;
    }

    public void cgF() {
        if (this.ieD.getParent() != null) {
            ((ViewGroup) this.ieD.getParent()).removeView(this.ieD);
            this.ieD = null;
        }
    }

    public void setMoveNumber(int i) {
        String string = getContext().getString(R.string.frs_move_area_move);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.ieB.setText(string);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof String) {
            cgF();
        } else if (view == this.dnB) {
            this.ieD = null;
            com.baidu.tieba.frs.a.bWW().reset();
        } else if (view == this.ieB) {
            if (this.mPageContext == null || this.ieD != null || w.isEmpty(com.baidu.tieba.frs.a.bWW().bXa())) {
                if (this.ieD == null && getContext() != null) {
                    new BdTopToast(getContext()).vz(false).OJ(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_choose_empty)).aE((ViewGroup) getParent());
                    return;
                }
                return;
            }
            this.ieD = new FrsMoveAreaChooseView(this.mPageContext);
            this.ieD.setOnClickListener(this);
            ((ViewGroup) getParent()).addView(this.ieD, -1, -1);
        } else if (this.ieD != null && view == this.ieD) {
            cgF();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, Integer.valueOf(i == 0 ? 0 : 1)));
        super.setVisibility(i);
    }

    public void onChangeSkinType() {
        an.setBackgroundColor(this, R.color.cp_bg_line_d);
        an.setViewTextColor(this.dnB, (int) R.color.cp_cont_b);
        an.setBackgroundResource(this.dnB, R.drawable.bg_bottom_up_list_dialog_item);
        an.setViewTextColor(this.ieB, (int) R.color.cp_link_tip_a);
        an.setBackgroundResource(this.ieB, R.drawable.bg_bottom_up_list_dialog_item);
        an.setBackgroundColor(this.ieC, R.color.cp_bg_line_c);
    }
}
