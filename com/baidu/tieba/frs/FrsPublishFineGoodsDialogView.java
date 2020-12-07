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
    private TextView bIt;
    private TextView iWE;
    private LocalBannerLayout iWF;
    com.baidu.tbadk.core.flow.a.d iWG;
    private TextView itG;
    private Context mContext;
    private LinearLayout mRootView;

    public FrsPublishFineGoodsDialogView(Context context) {
        super(context);
        this.iWG = new com.baidu.tbadk.core.flow.a.d() { // from class: com.baidu.tieba.frs.FrsPublishFineGoodsDialogView.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void e(int i, String str) {
            }

            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tbadk.core.flow.a.a aVar) {
                FrsPublishFineGoodsDialogView.this.Aa(i);
            }
        };
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.iWE.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_publish_major_fine_goods_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
        this.bIt = (TextView) this.mRootView.findViewById(R.id.frs_shop_guide_title);
        this.itG = (TextView) this.mRootView.findViewById(R.id.frs_shop_guide_content);
        this.iWF = (LocalBannerLayout) this.mRootView.findViewById(R.id.banner_layout);
        this.iWE = (TextView) this.mRootView.findViewById(R.id.to_next_tv);
        this.iWE.setText(R.string.forum_broadcast_major_history_known);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide1)));
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide2)));
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide3)));
        this.iWF.setData(arrayList);
        this.iWF.setOnCoverViewCallback(this.iWG);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.bIt, R.color.CAM_X0105);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.itG, R.color.CAM_X0109);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.iWE, R.color.CAM_X0302);
        com.baidu.tbadk.core.util.e.a.buz().qf(0).qg(R.color.CAM_X0211).ag(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30)).af(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30)).ae(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32)).ad(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32)).bq(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aa(int i) {
        if (i == 0 || i == 3) {
            this.bIt.setText(getResources().getString(R.string.frs_goods_dialog_first_title));
            this.itG.setText(getResources().getString(R.string.frs_goods_dialog_first_content));
        } else if (i == 1) {
            this.bIt.setText(getResources().getString(R.string.frs_goods_dialog_second_title));
            this.itG.setText(getResources().getString(R.string.frs_goods_dialog_second_content));
        } else if (i == 2) {
            this.bIt.setText(getResources().getString(R.string.frs_goods_dialog_third_title));
            this.itG.setText(getResources().getString(R.string.frs_goods_dialog_third_content));
        }
    }
}
