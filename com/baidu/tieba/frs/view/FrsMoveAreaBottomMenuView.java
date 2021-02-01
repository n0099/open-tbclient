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
    private TextView erH;
    private View jQA;
    private FrsMoveAreaChooseView jQB;
    private TextView jQz;
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
        this.erH = (TextView) findViewById(R.id.frs_move_area_cancel);
        this.jQz = (TextView) findViewById(R.id.frs_move_area_move);
        this.jQA = findViewById(R.id.frs_move_area_top_line);
        this.erH.setOnClickListener(this);
        this.jQz.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public boolean cNc() {
        return this.jQB != null && this.jQB.getVisibility() == 0;
    }

    public void cNd() {
        if (this.jQB.getParent() != null) {
            ((ViewGroup) this.jQB.getParent()).removeView(this.jQB);
            this.jQB = null;
        }
    }

    public void setMoveNumber(int i) {
        String string = getContext().getString(R.string.frs_move_area_move);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.jQz.setText(string);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof String) {
            cNd();
        } else if (view == this.erH) {
            this.jQB = null;
            com.baidu.tieba.frs.a.cBk().reset();
        } else if (view == this.jQz) {
            if (this.mPageContext == null || this.jQB != null || y.isEmpty(com.baidu.tieba.frs.a.cBk().cBo())) {
                if (this.jQB == null && getContext() != null) {
                    new BdTopToast(getContext()).zn(false).UN(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_choose_empty)).aR((ViewGroup) getParent());
                    return;
                }
                return;
            }
            this.jQB = new FrsMoveAreaChooseView(this.mPageContext);
            this.jQB.setOnClickListener(this);
            ((ViewGroup) getParent()).addView(this.jQB, -1, -1);
        } else if (this.jQB != null && view == this.jQB) {
            cNd();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, Integer.valueOf(i == 0 ? 0 : 1)));
        super.setVisibility(i);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setViewTextColor(this.erH, R.color.CAM_X0105);
        ap.setBackgroundResource(this.erH, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.jQz, R.color.CAM_X0302);
        ap.setBackgroundResource(this.jQz, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setBackgroundColor(this.jQA, R.color.CAM_X0204);
    }
}
