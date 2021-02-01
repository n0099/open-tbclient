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
    private TextView bMg;
    private TextView iGY;
    private TextView jjS;
    private LocalBannerLayout jjT;
    com.baidu.tbadk.core.flow.a.d jjU;
    private Context mContext;
    private LinearLayout mRootView;

    public FrsPublishFineGoodsDialogView(Context context) {
        super(context);
        this.jjU = new com.baidu.tbadk.core.flow.a.d() { // from class: com.baidu.tieba.frs.FrsPublishFineGoodsDialogView.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void f(int i, String str) {
            }

            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tbadk.core.flow.a.a aVar) {
                FrsPublishFineGoodsDialogView.this.yQ(i);
            }
        };
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.jjS.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_publish_major_fine_goods_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
        this.bMg = (TextView) this.mRootView.findViewById(R.id.frs_shop_guide_title);
        this.iGY = (TextView) this.mRootView.findViewById(R.id.frs_shop_guide_content);
        this.jjT = (LocalBannerLayout) this.mRootView.findViewById(R.id.banner_layout);
        this.jjS = (TextView) this.mRootView.findViewById(R.id.to_next_tv);
        this.jjS.setText(R.string.forum_broadcast_major_history_known);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide1)));
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide2)));
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide3)));
        this.jjT.setData(arrayList);
        this.jjT.setOnCoverViewCallback(this.jjU);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.bMg, R.color.CAM_X0105);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.iGY, R.color.CAM_X0109);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.jjS, R.color.CAM_X0302);
        com.baidu.tbadk.core.util.f.a.btv().oO(0).oP(R.color.CAM_X0211).aj(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30)).ai(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30)).ah(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32)).ag(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32)).bv(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yQ(int i) {
        if (i == 0 || i == 3) {
            this.bMg.setText(getResources().getString(R.string.frs_goods_dialog_first_title));
            this.iGY.setText(getResources().getString(R.string.frs_goods_dialog_first_content));
        } else if (i == 1) {
            this.bMg.setText(getResources().getString(R.string.frs_goods_dialog_second_title));
            this.iGY.setText(getResources().getString(R.string.frs_goods_dialog_second_content));
        } else if (i == 2) {
            this.bMg.setText(getResources().getString(R.string.frs_goods_dialog_third_title));
            this.iGY.setText(getResources().getString(R.string.frs_goods_dialog_third_content));
        }
    }
}
