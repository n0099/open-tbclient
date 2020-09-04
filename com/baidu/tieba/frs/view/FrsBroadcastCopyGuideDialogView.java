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
/* loaded from: classes16.dex */
public class FrsBroadcastCopyGuideDialogView extends LinearLayout {
    private TextView bpA;
    private TextView hWG;
    private TextView htB;
    private ImageView iyL;
    private Context mContext;
    private LinearLayout mRootView;

    public FrsBroadcastCopyGuideDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.hWG.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_broadcast_major_copy_guide_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
        this.bpA = (TextView) this.mRootView.findViewById(R.id.frs_broadcast_guide_title);
        this.htB = (TextView) this.mRootView.findViewById(R.id.frs_broadcast_guide_content);
        this.iyL = (ImageView) this.mRootView.findViewById(R.id.guide_iv);
        this.hWG = (TextView) this.mRootView.findViewById(R.id.to_next_tv);
        this.bpA.setText(R.string.forum_broadcast_copy_guide_title);
        this.htB.setText(R.string.forum_broadcast_copy_guide_hint);
        this.hWG.setText(R.string.comment_tab_dialog_botton_text);
        ap.setViewTextColor(this.bpA, R.color.cp_cont_b);
        ap.setViewTextColor(this.htB, R.color.cp_cont_j);
        ap.setViewTextColor(this.hWG, R.color.cp_link_tip_a);
        ap.setImageResource(this.iyL, R.drawable.pic_frs_guide_copylink);
        com.baidu.tbadk.core.util.e.a.bjQ().oe(0).of(R.color.cp_bg_line_k).Z(l.getDimens(this.mContext, R.dimen.tbds30)).Y(l.getDimens(this.mContext, R.dimen.tbds30)).X(l.getDimens(this.mContext, R.dimen.tbds32)).W(l.getDimens(this.mContext, R.dimen.tbds32)).aZ(this.mRootView);
    }
}
