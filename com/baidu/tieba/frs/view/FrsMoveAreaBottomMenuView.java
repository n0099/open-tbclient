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
    private TextView jQN;
    private View jQO;
    private FrsMoveAreaChooseView jQP;
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
        this.jQN = (TextView) findViewById(R.id.frs_move_area_move);
        this.jQO = findViewById(R.id.frs_move_area_top_line);
        this.erH.setOnClickListener(this);
        this.jQN.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public boolean cNj() {
        return this.jQP != null && this.jQP.getVisibility() == 0;
    }

    public void cNk() {
        if (this.jQP.getParent() != null) {
            ((ViewGroup) this.jQP.getParent()).removeView(this.jQP);
            this.jQP = null;
        }
    }

    public void setMoveNumber(int i) {
        String string = getContext().getString(R.string.frs_move_area_move);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.jQN.setText(string);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof String) {
            cNk();
        } else if (view == this.erH) {
            this.jQP = null;
            com.baidu.tieba.frs.a.cBr().reset();
        } else if (view == this.jQN) {
            if (this.mPageContext == null || this.jQP != null || y.isEmpty(com.baidu.tieba.frs.a.cBr().cBv())) {
                if (this.jQP == null && getContext() != null) {
                    new BdTopToast(getContext()).zn(false).UZ(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_choose_empty)).aR((ViewGroup) getParent());
                    return;
                }
                return;
            }
            this.jQP = new FrsMoveAreaChooseView(this.mPageContext);
            this.jQP.setOnClickListener(this);
            ((ViewGroup) getParent()).addView(this.jQP, -1, -1);
        } else if (this.jQP != null && view == this.jQP) {
            cNk();
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
        ap.setViewTextColor(this.jQN, R.color.CAM_X0302);
        ap.setBackgroundResource(this.jQN, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setBackgroundColor(this.jQO, R.color.CAM_X0204);
    }
}
