package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.w;
/* loaded from: classes21.dex */
public class e extends af.a {
    private static final int M_H_X002 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
    private static final int M_H_X003 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
    private static final int M_H_X005 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
    public Context mContext;
    public View mRoot;
    public TextView mTipView;

    public e(View view, Context context) {
        super(view);
        this.mRoot = view;
        this.mTipView = (TextView) view.findViewById(R.id.view_frs_read_progress);
        if (com.baidu.tbadk.a.d.bhw()) {
            this.mTipView.setPadding(0, M_H_X005 - M_H_X002, 0, M_H_X005);
        } else {
            this.mTipView.setPadding(0, M_H_X005, 0, M_H_X005 - M_H_X003);
        }
        this.mContext = context;
    }

    public void a(w wVar) {
        if (wVar != null) {
            this.mTipView.setText(R.string.read_here);
            brT();
        }
    }

    public void brT() {
        ap.setViewTextColor(this.mTipView, R.color.CAM_X0304);
        Drawable a2 = WebPManager.a(R.drawable.icon_pure_card_refresh16, ap.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL);
        a2.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds42), UtilHelper.getDimenPixelSize(R.dimen.tbds42));
        this.mTipView.setCompoundDrawables(a2, null, null, null);
    }
}
