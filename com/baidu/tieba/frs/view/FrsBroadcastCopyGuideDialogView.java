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
/* loaded from: classes21.dex */
public class FrsBroadcastCopyGuideDialogView extends LinearLayout {
    private TextView bsJ;
    private TextView hAG;
    private ImageView iGh;
    private TextView idK;
    private Context mContext;
    private LinearLayout mRootView;

    public FrsBroadcastCopyGuideDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.idK.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_broadcast_major_copy_guide_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
        this.bsJ = (TextView) this.mRootView.findViewById(R.id.frs_broadcast_guide_title);
        this.hAG = (TextView) this.mRootView.findViewById(R.id.frs_broadcast_guide_content);
        this.iGh = (ImageView) this.mRootView.findViewById(R.id.guide_iv);
        this.idK = (TextView) this.mRootView.findViewById(R.id.to_next_tv);
        this.bsJ.setText(R.string.forum_broadcast_copy_guide_title);
        this.hAG.setText(R.string.forum_broadcast_copy_guide_hint);
        this.idK.setText(R.string.comment_tab_dialog_botton_text);
        ap.setViewTextColor(this.bsJ, R.color.cp_cont_b);
        ap.setViewTextColor(this.hAG, R.color.cp_cont_j);
        ap.setViewTextColor(this.idK, R.color.cp_link_tip_a);
        ap.setImageResource(this.iGh, R.drawable.pic_frs_guide_copylink);
        com.baidu.tbadk.core.util.e.a.bkL().oq(0).or(R.color.cp_bg_line_k).Z(l.getDimens(this.mContext, R.dimen.tbds30)).Y(l.getDimens(this.mContext, R.dimen.tbds30)).X(l.getDimens(this.mContext, R.dimen.tbds32)).W(l.getDimens(this.mContext, R.dimen.tbds32)).bb(this.mRootView);
    }
}
