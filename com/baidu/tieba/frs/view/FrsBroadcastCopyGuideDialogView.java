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
/* loaded from: classes2.dex */
public class FrsBroadcastCopyGuideDialogView extends LinearLayout {
    private TextView bNi;
    private TextView iFV;
    private ImageView jOf;
    private TextView jiT;
    private Context mContext;
    private LinearLayout mRootView;

    public FrsBroadcastCopyGuideDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jiT.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_broadcast_major_copy_guide_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
        this.bNi = (TextView) this.mRootView.findViewById(R.id.frs_broadcast_guide_title);
        this.iFV = (TextView) this.mRootView.findViewById(R.id.frs_broadcast_guide_content);
        this.jOf = (ImageView) this.mRootView.findViewById(R.id.guide_iv);
        this.jiT = (TextView) this.mRootView.findViewById(R.id.to_next_tv);
        this.bNi.setText(R.string.forum_broadcast_copy_guide_title);
        this.iFV.setText(R.string.forum_broadcast_copy_guide_hint);
        this.jiT.setText(R.string.comment_tab_dialog_botton_text);
        ao.setViewTextColor(this.bNi, R.color.CAM_X0105);
        ao.setViewTextColor(this.iFV, R.color.CAM_X0107);
        ao.setViewTextColor(this.jiT, R.color.CAM_X0302);
        ao.setImageResource(this.jOf, R.drawable.pic_frs_guide_copylink);
        com.baidu.tbadk.core.util.f.a.bwV().qq(0).qr(R.color.CAM_X0211).ai(l.getDimens(this.mContext, R.dimen.tbds30)).ah(l.getDimens(this.mContext, R.dimen.tbds30)).ag(l.getDimens(this.mContext, R.dimen.tbds32)).af(l.getDimens(this.mContext, R.dimen.tbds32)).bz(this.mRootView);
    }
}
