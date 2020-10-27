package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPublishFineGoodsDialogView extends LinearLayout {
    private TextView byL;
    private TextView iFd;
    private LocalBannerLayout iFe;
    com.baidu.tbadk.core.flow.a.d iFf;
    private TextView ibY;
    private Context mContext;
    private LinearLayout mRootView;

    public FrsPublishFineGoodsDialogView(Context context) {
        super(context);
        this.iFf = new com.baidu.tbadk.core.flow.a.d() { // from class: com.baidu.tieba.frs.FrsPublishFineGoodsDialogView.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void e(int i, String str) {
            }

            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tbadk.core.flow.a.a aVar) {
                FrsPublishFineGoodsDialogView.this.yK(i);
            }
        };
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.iFd.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_publish_major_fine_goods_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
        this.byL = (TextView) this.mRootView.findViewById(R.id.frs_shop_guide_title);
        this.ibY = (TextView) this.mRootView.findViewById(R.id.frs_shop_guide_content);
        this.iFe = (LocalBannerLayout) this.mRootView.findViewById(R.id.banner_layout);
        this.iFd = (TextView) this.mRootView.findViewById(R.id.to_next_tv);
        this.iFd.setText(R.string.forum_broadcast_major_history_known);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide1)));
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide2)));
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide3)));
        this.iFe.setData(arrayList);
        this.iFe.setOnCoverViewCallback(this.iFf);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.byL, R.color.cp_cont_b);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.ibY, R.color.cp_cont_d);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.iFd, R.color.cp_link_tip_a);
        com.baidu.tbadk.core.util.e.a.bpo().oZ(0).pa(R.color.cp_bg_line_k).ad(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30)).ac(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30)).ab(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32)).aa(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32)).bg(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yK(int i) {
        if (i == 0 || i == 3) {
            this.byL.setText(getResources().getString(R.string.frs_goods_dialog_first_title));
            this.ibY.setText(getResources().getString(R.string.frs_goods_dialog_first_content));
        } else if (i == 1) {
            this.byL.setText(getResources().getString(R.string.frs_goods_dialog_second_title));
            this.ibY.setText(getResources().getString(R.string.frs_goods_dialog_second_content));
        } else if (i == 2) {
            this.byL.setText(getResources().getString(R.string.frs_goods_dialog_third_title));
            this.ibY.setText(getResources().getString(R.string.frs_goods_dialog_third_content));
        }
    }
}
