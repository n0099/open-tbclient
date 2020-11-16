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
/* loaded from: classes21.dex */
public class FrsMoveAreaBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private TextView eei;
    private TextView joc;
    private View jod;
    private FrsMoveAreaChooseView joe;
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
        this.eei = (TextView) findViewById(R.id.frs_move_area_cancel);
        this.joc = (TextView) findViewById(R.id.frs_move_area_move);
        this.jod = findViewById(R.id.frs_move_area_top_line);
        this.eei.setOnClickListener(this);
        this.joc.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public boolean cGL() {
        return this.joe != null && this.joe.getVisibility() == 0;
    }

    public void cGM() {
        if (this.joe.getParent() != null) {
            ((ViewGroup) this.joe.getParent()).removeView(this.joe);
            this.joe = null;
        }
    }

    public void setMoveNumber(int i) {
        String string = getContext().getString(R.string.frs_move_area_move);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.joc.setText(string);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof String) {
            cGM();
        } else if (view == this.eei) {
            this.joe = null;
            com.baidu.tieba.frs.a.cwH().reset();
        } else if (view == this.joc) {
            if (this.mPageContext == null || this.joe != null || y.isEmpty(com.baidu.tieba.frs.a.cwH().cwL())) {
                if (this.joe == null && getContext() != null) {
                    new BdTopToast(getContext()).yr(false).Ue(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_choose_empty)).aF((ViewGroup) getParent());
                    return;
                }
                return;
            }
            this.joe = new FrsMoveAreaChooseView(this.mPageContext);
            this.joe.setOnClickListener(this);
            ((ViewGroup) getParent()).addView(this.joe, -1, -1);
        } else if (this.joe != null && view == this.joe) {
            cGM();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, Integer.valueOf(i == 0 ? 0 : 1)));
        super.setVisibility(i);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setViewTextColor(this.eei, R.color.CAM_X0105);
        ap.setBackgroundResource(this.eei, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.joc, R.color.CAM_X0302);
        ap.setBackgroundResource(this.joc, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setBackgroundColor(this.jod, R.color.CAM_X0204);
    }
}
