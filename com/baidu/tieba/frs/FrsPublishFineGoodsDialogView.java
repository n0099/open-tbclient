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
    private TextView bsJ;
    private TextView hAG;
    private TextView idK;
    private LocalBannerLayout idL;
    com.baidu.tbadk.core.flow.a.d idM;
    private Context mContext;
    private LinearLayout mRootView;

    public FrsPublishFineGoodsDialogView(Context context) {
        super(context);
        this.idM = new com.baidu.tbadk.core.flow.a.d() { // from class: com.baidu.tieba.frs.FrsPublishFineGoodsDialogView.1
            @Override // com.baidu.tbadk.core.flow.a.d
            public void e(int i, String str) {
            }

            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tbadk.core.flow.a.a aVar) {
                FrsPublishFineGoodsDialogView.this.xL(i);
            }
        };
        this.mContext = context;
        initUI(context);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.idK.setOnClickListener(onClickListener);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_publish_major_fine_goods_dialog, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
        this.bsJ = (TextView) this.mRootView.findViewById(R.id.frs_shop_guide_title);
        this.hAG = (TextView) this.mRootView.findViewById(R.id.frs_shop_guide_content);
        this.idL = (LocalBannerLayout) this.mRootView.findViewById(R.id.banner_layout);
        this.idK = (TextView) this.mRootView.findViewById(R.id.to_next_tv);
        this.idK.setText(R.string.forum_broadcast_major_history_known);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide1)));
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide2)));
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide3)));
        this.idL.setData(arrayList);
        this.idL.setOnCoverViewCallback(this.idM);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.bsJ, R.color.cp_cont_b);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.hAG, R.color.cp_cont_d);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.idK, R.color.cp_link_tip_a);
        com.baidu.tbadk.core.util.e.a.bkL().oq(0).or(R.color.cp_bg_line_k).Z(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30)).Y(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30)).X(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32)).W(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32)).bb(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xL(int i) {
        if (i == 0 || i == 3) {
            this.bsJ.setText(getResources().getString(R.string.frs_goods_dialog_first_title));
            this.hAG.setText(getResources().getString(R.string.frs_goods_dialog_first_content));
        } else if (i == 1) {
            this.bsJ.setText(getResources().getString(R.string.frs_goods_dialog_second_title));
            this.hAG.setText(getResources().getString(R.string.frs_goods_dialog_second_content));
        } else if (i == 2) {
            this.bsJ.setText(getResources().getString(R.string.frs_goods_dialog_third_title));
            this.hAG.setText(getResources().getString(R.string.frs_goods_dialog_third_content));
        }
    }
}
