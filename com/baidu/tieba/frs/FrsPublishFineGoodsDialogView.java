package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class FrsPublishFineGoodsDialogView extends LinearLayout {
    private TextView bpx;
    private TextView hWA;
    private LocalBannerLayout hWB;
    com.baidu.tbadk.core.flow.a.d hWC;
    private TextView htv;
    private Context mContext;
    private LinearLayout mRootView;

    public FrsPublishFineGoodsDialogView(Context context) {
        super(context);
        this.hWC = new com.baidu.tbadk.core.flow.a.d() { // from class: com.baidu.tieba.frs.FrsPublishFineGoodsDialogView.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void e(int i, String str) {
            }

            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tbadk.core.flow.a.a aVar) {
                FrsPublishFineGoodsDialogView.this.xm(i);
            }
        };
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.hWA.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_publish_major_fine_goods_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
        this.bpx = (TextView) this.mRootView.findViewById(R.id.frs_shop_guide_title);
        this.htv = (TextView) this.mRootView.findViewById(R.id.frs_shop_guide_content);
        this.hWB = (LocalBannerLayout) this.mRootView.findViewById(R.id.banner_layout);
        this.hWA = (TextView) this.mRootView.findViewById(R.id.to_next_tv);
        this.hWA.setText(R.string.forum_broadcast_major_history_known);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide1)));
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide2)));
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide3)));
        this.hWB.setData(arrayList);
        this.hWB.setOnCoverViewCallback(this.hWC);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.bpx, R.color.cp_cont_b);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.htv, R.color.cp_cont_d);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.hWA, R.color.cp_link_tip_a);
        com.baidu.tbadk.core.util.e.a.bjQ().oe(0).of(R.color.cp_bg_line_k).Z(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30)).Y(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30)).X(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32)).W(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32)).aZ(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xm(int i) {
        if (i == 0 || i == 3) {
            this.bpx.setText(getResources().getString(R.string.frs_goods_dialog_first_title));
            this.htv.setText(getResources().getString(R.string.frs_goods_dialog_first_content));
        } else if (i == 1) {
            this.bpx.setText(getResources().getString(R.string.frs_goods_dialog_second_title));
            this.htv.setText(getResources().getString(R.string.frs_goods_dialog_second_content));
        } else if (i == 2) {
            this.bpx.setText(getResources().getString(R.string.frs_goods_dialog_third_title));
            this.htv.setText(getResources().getString(R.string.frs_goods_dialog_third_content));
        }
    }
}
