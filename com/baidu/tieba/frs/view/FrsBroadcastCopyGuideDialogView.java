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
    private TextView bwx;
    private TextView hPB;
    private ImageView iUX;
    private TextView isH;
    private Context mContext;
    private LinearLayout mRootView;

    public FrsBroadcastCopyGuideDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.isH.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_broadcast_major_copy_guide_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
        this.bwx = (TextView) this.mRootView.findViewById(R.id.frs_broadcast_guide_title);
        this.hPB = (TextView) this.mRootView.findViewById(R.id.frs_broadcast_guide_content);
        this.iUX = (ImageView) this.mRootView.findViewById(R.id.guide_iv);
        this.isH = (TextView) this.mRootView.findViewById(R.id.to_next_tv);
        this.bwx.setText(R.string.forum_broadcast_copy_guide_title);
        this.hPB.setText(R.string.forum_broadcast_copy_guide_hint);
        this.isH.setText(R.string.comment_tab_dialog_botton_text);
        ap.setViewTextColor(this.bwx, R.color.cp_cont_b);
        ap.setViewTextColor(this.hPB, R.color.cp_cont_j);
        ap.setViewTextColor(this.isH, R.color.cp_link_tip_a);
        ap.setImageResource(this.iUX, R.drawable.pic_frs_guide_copylink);
        com.baidu.tbadk.core.util.e.a.bnv().oO(0).oP(R.color.cp_bg_line_k).ab(l.getDimens(this.mContext, R.dimen.tbds30)).aa(l.getDimens(this.mContext, R.dimen.tbds30)).Z(l.getDimens(this.mContext, R.dimen.tbds32)).Y(l.getDimens(this.mContext, R.dimen.tbds32)).bf(this.mRootView);
    }
}
