package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.u;
/* loaded from: classes2.dex */
public class ReadProgressViewHolder extends TypeAdapter.ViewHolder {
    private static final int M_H_X002 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
    private static final int M_H_X003 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
    private static final int M_H_X005 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
    public Context mContext;
    public View mRoot;
    public TextView mTipView;

    public ReadProgressViewHolder(View view, Context context) {
        super(view);
        this.mRoot = view;
        this.mTipView = (TextView) view.findViewById(R.id.view_frs_read_progress);
        this.mTipView.setPadding(0, M_H_X005, 0, M_H_X005 - M_H_X003);
        this.mContext = context;
    }

    public void a(u uVar) {
        if (uVar != null) {
            this.mTipView.setText(R.string.read_here);
            bup();
        }
    }

    public void bup() {
        ap.setViewTextColor(this.mTipView, R.color.CAM_X0304);
        Drawable a2 = WebPManager.a(R.drawable.icon_pure_card_refresh16, ap.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL);
        a2.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds42), UtilHelper.getDimenPixelSize(R.dimen.tbds42));
        this.mTipView.setCompoundDrawables(a2, null, null, null);
    }
}
