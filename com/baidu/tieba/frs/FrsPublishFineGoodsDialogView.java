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
    private TextView bDl;
    private TextView iLN;
    private LocalBannerLayout iLO;
    com.baidu.tbadk.core.flow.a.d iLP;
    private TextView iiN;
    private Context mContext;
    private LinearLayout mRootView;

    public FrsPublishFineGoodsDialogView(Context context) {
        super(context);
        this.iLP = new com.baidu.tbadk.core.flow.a.d() { // from class: com.baidu.tieba.frs.FrsPublishFineGoodsDialogView.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void e(int i, String str) {
            }

            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tbadk.core.flow.a.a aVar) {
                FrsPublishFineGoodsDialogView.this.zv(i);
            }
        };
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.iLN.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_publish_major_fine_goods_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
        this.bDl = (TextView) this.mRootView.findViewById(R.id.frs_shop_guide_title);
        this.iiN = (TextView) this.mRootView.findViewById(R.id.frs_shop_guide_content);
        this.iLO = (LocalBannerLayout) this.mRootView.findViewById(R.id.banner_layout);
        this.iLN = (TextView) this.mRootView.findViewById(R.id.to_next_tv);
        this.iLN.setText(R.string.forum_broadcast_major_history_known);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide1)));
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide2)));
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide3)));
        this.iLO.setData(arrayList);
        this.iLO.setOnCoverViewCallback(this.iLP);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.bDl, R.color.CAM_X0105);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.iiN, R.color.CAM_X0109);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.iLN, R.color.CAM_X0302);
        com.baidu.tbadk.core.util.e.a.brc().pF(0).pG(R.color.CAM_X0211).ag(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30)).af(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30)).ae(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32)).ad(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32)).bn(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zv(int i) {
        if (i == 0 || i == 3) {
            this.bDl.setText(getResources().getString(R.string.frs_goods_dialog_first_title));
            this.iiN.setText(getResources().getString(R.string.frs_goods_dialog_first_content));
        } else if (i == 1) {
            this.bDl.setText(getResources().getString(R.string.frs_goods_dialog_second_title));
            this.iiN.setText(getResources().getString(R.string.frs_goods_dialog_second_content));
        } else if (i == 2) {
            this.bDl.setText(getResources().getString(R.string.frs_goods_dialog_third_title));
            this.iiN.setText(getResources().getString(R.string.frs_goods_dialog_third_content));
        }
    }
}
