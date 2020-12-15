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
    private TextView bIt;
    private TextView iWG;
    private TextView itI;
    private ImageView jBF;
    private Context mContext;
    private LinearLayout mRootView;

    public FrsBroadcastCopyGuideDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.iWG.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_broadcast_major_copy_guide_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
        this.bIt = (TextView) this.mRootView.findViewById(R.id.frs_broadcast_guide_title);
        this.itI = (TextView) this.mRootView.findViewById(R.id.frs_broadcast_guide_content);
        this.jBF = (ImageView) this.mRootView.findViewById(R.id.guide_iv);
        this.iWG = (TextView) this.mRootView.findViewById(R.id.to_next_tv);
        this.bIt.setText(R.string.forum_broadcast_copy_guide_title);
        this.itI.setText(R.string.forum_broadcast_copy_guide_hint);
        this.iWG.setText(R.string.comment_tab_dialog_botton_text);
        ap.setViewTextColor(this.bIt, R.color.CAM_X0105);
        ap.setViewTextColor(this.itI, R.color.CAM_X0107);
        ap.setViewTextColor(this.iWG, R.color.CAM_X0302);
        ap.setImageResource(this.jBF, R.drawable.pic_frs_guide_copylink);
        com.baidu.tbadk.core.util.e.a.buz().qf(0).qg(R.color.CAM_X0211).ag(l.getDimens(this.mContext, R.dimen.tbds30)).af(l.getDimens(this.mContext, R.dimen.tbds30)).ae(l.getDimens(this.mContext, R.dimen.tbds32)).ad(l.getDimens(this.mContext, R.dimen.tbds32)).bq(this.mRootView);
    }
}
