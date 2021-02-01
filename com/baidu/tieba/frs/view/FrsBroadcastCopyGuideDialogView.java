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
    private TextView bMg;
    private TextView iGY;
    private ImageView jQw;
    private TextView jjS;
    private Context mContext;
    private LinearLayout mRootView;

    public FrsBroadcastCopyGuideDialogView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jjS.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_broadcast_major_copy_guide_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
        this.bMg = (TextView) this.mRootView.findViewById(R.id.frs_broadcast_guide_title);
        this.iGY = (TextView) this.mRootView.findViewById(R.id.frs_broadcast_guide_content);
        this.jQw = (ImageView) this.mRootView.findViewById(R.id.guide_iv);
        this.jjS = (TextView) this.mRootView.findViewById(R.id.to_next_tv);
        this.bMg.setText(R.string.forum_broadcast_copy_guide_title);
        this.iGY.setText(R.string.forum_broadcast_copy_guide_hint);
        this.jjS.setText(R.string.comment_tab_dialog_botton_text);
        ap.setViewTextColor(this.bMg, R.color.CAM_X0105);
        ap.setViewTextColor(this.iGY, R.color.CAM_X0107);
        ap.setViewTextColor(this.jjS, R.color.CAM_X0302);
        ap.setImageResource(this.jQw, R.drawable.pic_frs_guide_copylink);
        com.baidu.tbadk.core.util.f.a.btv().oO(0).oP(R.color.CAM_X0211).aj(l.getDimens(this.mContext, R.dimen.tbds30)).ai(l.getDimens(this.mContext, R.dimen.tbds30)).ah(l.getDimens(this.mContext, R.dimen.tbds32)).ag(l.getDimens(this.mContext, R.dimen.tbds32)).bv(this.mRootView);
    }
}
