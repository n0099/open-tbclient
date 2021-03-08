package com.baidu.tieba.barselect.view;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class a extends AlertDialog {
    private View ivt;
    private String mTitle;
    private TextView mTitleView;

    public a(Context context) {
        super(context);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
            window.setContentView(R.layout.id_card_dialog);
            this.ivt = window.findViewById(R.id.toast_container);
            this.mTitleView = (TextView) window.findViewById(R.id.toast_tv);
            if (!StringUtils.isNull(this.mTitle)) {
                this.mTitleView.setText(this.mTitle);
            }
            uw(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void uw(int i) {
        ap.e(this.ivt, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5), R.color.cp_cont_b_alpha80, R.color.cp_cont_b_alpha80, i);
    }
}
