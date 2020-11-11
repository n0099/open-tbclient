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
/* loaded from: classes22.dex */
public class FrsBroadcastCopyGuideDialogView extends LinearLayout {
    private TextView bEW;
    private TextView iLa;
    private TextView ihZ;
    private ImageView jns;
    private Context mContext;
    private LinearLayout mRootView;

    public FrsBroadcastCopyGuideDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.iLa.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_broadcast_major_copy_guide_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
        this.bEW = (TextView) this.mRootView.findViewById(R.id.frs_broadcast_guide_title);
        this.ihZ = (TextView) this.mRootView.findViewById(R.id.frs_broadcast_guide_content);
        this.jns = (ImageView) this.mRootView.findViewById(R.id.guide_iv);
        this.iLa = (TextView) this.mRootView.findViewById(R.id.to_next_tv);
        this.bEW.setText(R.string.forum_broadcast_copy_guide_title);
        this.ihZ.setText(R.string.forum_broadcast_copy_guide_hint);
        this.iLa.setText(R.string.comment_tab_dialog_botton_text);
        ap.setViewTextColor(this.bEW, R.color.cp_cont_b);
        ap.setViewTextColor(this.ihZ, R.color.cp_cont_j);
        ap.setViewTextColor(this.iLa, R.color.cp_link_tip_a);
        ap.setImageResource(this.jns, R.drawable.pic_frs_guide_copylink);
        com.baidu.tbadk.core.util.e.a.brO().pj(0).pk(R.color.cp_bg_line_k).af(l.getDimens(this.mContext, R.dimen.tbds30)).ae(l.getDimens(this.mContext, R.dimen.tbds30)).ad(l.getDimens(this.mContext, R.dimen.tbds32)).ac(l.getDimens(this.mContext, R.dimen.tbds32)).bk(this.mRootView);
    }
}
