package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class i extends af.a {
    public TBSpecificationBtn ajR;
    private int eOn;
    public TbImageView jZC;
    public TextView mDescView;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.jZC = (TbImageView) view.findViewById(R.id.net_refresh_image);
        this.mDescView = (TextView) view.findViewById(R.id.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(R.id.net_refresh_title);
        this.ajR = (TBSpecificationBtn) view.findViewById(R.id.net_refresh_button);
        this.ajR.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        ap.setViewTextColor(this.mDescView, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_j, 1);
        this.mDescView.setText(str);
        this.mTitleView.setText(str2);
        this.ajR.setText(str3);
        setLayoutMargin(0);
        CI(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.jZC.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.jZC.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else {
            d(imgType);
            this.jZC.setImageBitmap(ap.getBitmap565Quality(this.eOn));
        }
    }

    public void setLayoutMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.jZC.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.jZC.setLayoutParams(marginLayoutParams);
        }
    }

    public void CI(int i) {
        ViewGroup.LayoutParams layoutParams = this.ajR.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.ajR.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.eOn = R.drawable.new_pic_emotion_03;
                    return;
                case NODATA:
                    this.eOn = R.drawable.new_pic_emotion_05;
                    return;
                case FINDBAR:
                    this.eOn = R.drawable.new_pic_emotion_01;
                    return;
                case EMOTION:
                    this.eOn = R.drawable.new_pic_emotion_02;
                    return;
                case GIFT:
                    this.eOn = R.drawable.new_pic_emotion_07;
                    return;
                case SINGALL:
                    this.eOn = R.drawable.new_pic_emotion_06;
                    return;
                case WEBVIEW:
                    this.eOn = R.drawable.new_pic_emotion_08;
                    return;
                default:
                    return;
            }
        }
    }
}
