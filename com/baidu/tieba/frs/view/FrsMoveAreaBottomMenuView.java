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
    private TextView efP;
    private TextView jnt;
    private View jnu;
    private FrsMoveAreaChooseView jnv;
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
        this.efP = (TextView) findViewById(R.id.frs_move_area_cancel);
        this.jnt = (TextView) findViewById(R.id.frs_move_area_move);
        this.jnu = findViewById(R.id.frs_move_area_top_line);
        this.efP.setOnClickListener(this);
        this.jnt.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public boolean cHg() {
        return this.jnv != null && this.jnv.getVisibility() == 0;
    }

    public void cHh() {
        if (this.jnv.getParent() != null) {
            ((ViewGroup) this.jnv.getParent()).removeView(this.jnv);
            this.jnv = null;
        }
    }

    public void setMoveNumber(int i) {
        String string = getContext().getString(R.string.frs_move_area_move);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.jnt.setText(string);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof String) {
            cHh();
        } else if (view == this.efP) {
            this.jnv = null;
            com.baidu.tieba.frs.a.cxf().reset();
        } else if (view == this.jnt) {
            if (this.mPageContext == null || this.jnv != null || y.isEmpty(com.baidu.tieba.frs.a.cxf().cxj())) {
                if (this.jnv == null && getContext() != null) {
                    new BdTopToast(getContext()).yk(false).Ut(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_choose_empty)).aJ((ViewGroup) getParent());
                    return;
                }
                return;
            }
            this.jnv = new FrsMoveAreaChooseView(this.mPageContext);
            this.jnv.setOnClickListener(this);
            ((ViewGroup) getParent()).addView(this.jnv, -1, -1);
        } else if (this.jnv != null && view == this.jnv) {
            cHh();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, Integer.valueOf(i == 0 ? 0 : 1)));
        super.setVisibility(i);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.efP, R.color.cp_cont_b);
        ap.setBackgroundResource(this.efP, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.jnt, R.color.cp_link_tip_a);
        ap.setBackgroundResource(this.jnt, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setBackgroundColor(this.jnu, R.color.cp_bg_line_c);
    }
}
