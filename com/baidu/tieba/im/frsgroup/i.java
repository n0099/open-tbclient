package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class i extends ad.a {
    private int ebv;
    public TbImageView iSm;
    public TBSpecificationBtn iSn;
    public TextView mDescView;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.iSm = (TbImageView) view.findViewById(R.id.net_refresh_image);
        this.mDescView = (TextView) view.findViewById(R.id.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(R.id.net_refresh_title);
        this.iSn = (TBSpecificationBtn) view.findViewById(R.id.net_refresh_button);
        this.iSn.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        an.setViewTextColor(this.mDescView, R.color.cp_cont_d, 1);
        an.setViewTextColor(this.mTitleView, R.color.cp_cont_j, 1);
        this.mDescView.setText(str);
        this.mTitleView.setText(str2);
        this.iSn.setText(str3);
        setLayoutMargin(0);
        yr(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.iSm.setImageBitmap(an.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.iSm.setImageBitmap(an.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else {
            d(imgType);
            this.iSm.setImageBitmap(an.getBitmap565Quality(this.ebv));
        }
    }

    public void setLayoutMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.iSm.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.iSm.setLayoutParams(marginLayoutParams);
        }
    }

    public void yr(int i) {
        ViewGroup.LayoutParams layoutParams = this.iSn.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.iSn.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.ebv = R.drawable.new_pic_emotion_03;
                    return;
                case NODATA:
                    this.ebv = R.drawable.new_pic_emotion_05;
                    return;
                case FINDBAR:
                    this.ebv = R.drawable.new_pic_emotion_01;
                    return;
                case EMOTION:
                    this.ebv = R.drawable.new_pic_emotion_02;
                    return;
                case GIFT:
                    this.ebv = R.drawable.new_pic_emotion_07;
                    return;
                case SINGALL:
                    this.ebv = R.drawable.new_pic_emotion_06;
                    return;
                case WEBVIEW:
                    this.ebv = R.drawable.new_pic_emotion_08;
                    return;
                default:
                    return;
            }
        }
    }
}
