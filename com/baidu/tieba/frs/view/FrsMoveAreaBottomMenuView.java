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
    private TextView jBG;
    private View jBH;
    private FrsMoveAreaChooseView jBI;
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
        this.jBG = (TextView) findViewById(R.id.frs_move_area_move);
        this.jBH = findViewById(R.id.frs_move_area_top_line);
        this.elj.setOnClickListener(this);
        this.jBG.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public boolean cMb() {
        return this.jBI != null && this.jBI.getVisibility() == 0;
    }

    public void cMc() {
        if (this.jBI.getParent() != null) {
            ((ViewGroup) this.jBI.getParent()).removeView(this.jBI);
            this.jBI = null;
        }
    }

    public void setMoveNumber(int i) {
        String string = getContext().getString(R.string.frs_move_area_move);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.jBG.setText(string);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof String) {
            cMc();
        } else if (view == this.elj) {
            this.jBI = null;
            com.baidu.tieba.frs.a.cAX().reset();
        } else if (view == this.jBG) {
            if (this.mPageContext == null || this.jBI != null || y.isEmpty(com.baidu.tieba.frs.a.cAX().cBb())) {
                if (this.jBI == null && getContext() != null) {
                    new BdTopToast(getContext()).yW(false).Vt(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_choose_empty)).aF((ViewGroup) getParent());
                    return;
                }
                return;
            }
            this.jBI = new FrsMoveAreaChooseView(this.mPageContext);
            this.jBI.setOnClickListener(this);
            ((ViewGroup) getParent()).addView(this.jBI, -1, -1);
        } else if (this.jBI != null && view == this.jBI) {
            cMc();
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
        ap.setViewTextColor(this.jBG, R.color.CAM_X0302);
        ap.setBackgroundResource(this.jBG, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setBackgroundColor(this.jBH, R.color.CAM_X0204);
    }
}
