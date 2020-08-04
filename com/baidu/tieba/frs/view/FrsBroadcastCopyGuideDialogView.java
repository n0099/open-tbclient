package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class FrsBroadcastCopyGuideDialogView extends LinearLayout {
    private TextView bjS;
    private TextView hgC;
    private ImageView ikB;
    private TextView ikC;
    private Context mContext;
    private LinearLayout mRootView;

    public FrsBroadcastCopyGuideDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.ikC.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_broadcast_major_copy_guide_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
        this.bjS = (TextView) this.mRootView.findViewById(R.id.frs_broadcast_guide_title);
        this.hgC = (TextView) this.mRootView.findViewById(R.id.frs_broadcast_guide_content);
        this.ikB = (ImageView) this.mRootView.findViewById(R.id.guide_iv);
        this.ikC = (TextView) this.mRootView.findViewById(R.id.to_next_tv);
        this.bjS.setText(R.string.forum_broadcast_copy_guide_title);
        this.hgC.setText(R.string.forum_broadcast_copy_guide_hint);
        this.ikC.setText(R.string.comment_tab_dialog_botton_text);
        ao.setViewTextColor(this.bjS, R.color.cp_cont_b);
        ao.setViewTextColor(this.hgC, R.color.cp_cont_j);
        ao.setViewTextColor(this.ikC, R.color.cp_link_tip_a);
        ao.setImageResource(this.ikB, R.drawable.pic_frs_guide_copylink);
        com.baidu.tbadk.core.util.e.a.bbr().ma(0).mb(R.color.cp_bg_line_k).U(l.getDimens(this.mContext, R.dimen.tbds30)).T(l.getDimens(this.mContext, R.dimen.tbds30)).S(l.getDimens(this.mContext, R.dimen.tbds32)).R(l.getDimens(this.mContext, R.dimen.tbds32)).aX(this.mRootView);
    }
}
