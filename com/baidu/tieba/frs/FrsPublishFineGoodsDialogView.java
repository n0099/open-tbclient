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
    private TextView bNG;
    private TextView iIV;
    private TextView jlP;
    private LocalBannerLayout jlQ;
    com.baidu.tbadk.core.flow.a.d jlR;
    private Context mContext;
    private LinearLayout mRootView;

    public FrsPublishFineGoodsDialogView(Context context) {
        super(context);
        this.jlR = new com.baidu.tbadk.core.flow.a.d() { // from class: com.baidu.tieba.frs.FrsPublishFineGoodsDialogView.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void f(int i, String str) {
            }

            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tbadk.core.flow.a.a aVar) {
                FrsPublishFineGoodsDialogView.this.yR(i);
            }
        };
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jlP.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_publish_major_fine_goods_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
        this.bNG = (TextView) this.mRootView.findViewById(R.id.frs_shop_guide_title);
        this.iIV = (TextView) this.mRootView.findViewById(R.id.frs_shop_guide_content);
        this.jlQ = (LocalBannerLayout) this.mRootView.findViewById(R.id.banner_layout);
        this.jlP = (TextView) this.mRootView.findViewById(R.id.to_next_tv);
        this.jlP.setText(R.string.forum_broadcast_major_history_known);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide1)));
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide2)));
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide3)));
        this.jlQ.setData(arrayList);
        this.jlQ.setOnCoverViewCallback(this.jlR);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.bNG, R.color.CAM_X0105);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.iIV, R.color.CAM_X0109);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.jlP, R.color.CAM_X0302);
        com.baidu.tbadk.core.util.f.a.bty().oP(0).oQ(R.color.CAM_X0211).an(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30)).am(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30)).al(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32)).ak(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32)).bv(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yR(int i) {
        if (i == 0 || i == 3) {
            this.bNG.setText(getResources().getString(R.string.frs_goods_dialog_first_title));
            this.iIV.setText(getResources().getString(R.string.frs_goods_dialog_first_content));
        } else if (i == 1) {
            this.bNG.setText(getResources().getString(R.string.frs_goods_dialog_second_title));
            this.iIV.setText(getResources().getString(R.string.frs_goods_dialog_second_content));
        } else if (i == 2) {
            this.bNG.setText(getResources().getString(R.string.frs_goods_dialog_third_title));
            this.iIV.setText(getResources().getString(R.string.frs_goods_dialog_third_content));
        }
    }
}
