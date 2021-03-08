package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class FrsBroadcastCopyGuideDialogView extends LinearLayout {
    private TextView bNG;
    private TextView iIV;
    private ImageView jSt;
    private TextView jlP;
    private Context mContext;
    private LinearLayout mRootView;

    public FrsBroadcastCopyGuideDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jlP.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_broadcast_major_copy_guide_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
        this.bNG = (TextView) this.mRootView.findViewById(R.id.frs_broadcast_guide_title);
        this.iIV = (TextView) this.mRootView.findViewById(R.id.frs_broadcast_guide_content);
        this.jSt = (ImageView) this.mRootView.findViewById(R.id.guide_iv);
        this.jlP = (TextView) this.mRootView.findViewById(R.id.to_next_tv);
        this.bNG.setText(R.string.forum_broadcast_copy_guide_title);
        this.iIV.setText(R.string.forum_broadcast_copy_guide_hint);
        this.jlP.setText(R.string.comment_tab_dialog_botton_text);
        ap.setViewTextColor(this.bNG, R.color.CAM_X0105);
        ap.setViewTextColor(this.iIV, R.color.CAM_X0107);
        ap.setViewTextColor(this.jlP, R.color.CAM_X0302);
        ap.setImageResource(this.jSt, R.drawable.pic_frs_guide_copylink);
        com.baidu.tbadk.core.util.f.a.bty().oP(0).oQ(R.color.CAM_X0211).an(l.getDimens(this.mContext, R.dimen.tbds30)).am(l.getDimens(this.mContext, R.dimen.tbds30)).al(l.getDimens(this.mContext, R.dimen.tbds32)).ak(l.getDimens(this.mContext, R.dimen.tbds32)).bv(this.mRootView);
    }
}
