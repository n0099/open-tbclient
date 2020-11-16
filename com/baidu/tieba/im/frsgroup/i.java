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
/* loaded from: classes22.dex */
public class i extends af.a {
    public TBSpecificationBtn ajU;
    private int eTe;
    public TbImageView kgk;
    public TextView mDescView;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.kgk = (TbImageView) view.findViewById(R.id.net_refresh_image);
        this.mDescView = (TextView) view.findViewById(R.id.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(R.id.net_refresh_title);
        this.ajU = (TBSpecificationBtn) view.findViewById(R.id.net_refresh_button);
        this.ajU.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        ap.setViewTextColor(this.mDescView, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0107, 1);
        this.mDescView.setText(str);
        this.mTitleView.setText(str2);
        this.ajU.setText(str3);
        setLayoutMargin(0);
        Dt(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.kgk.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.kgk.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else {
            d(imgType);
            this.kgk.setImageBitmap(ap.getBitmap565Quality(this.eTe));
        }
    }

    public void setLayoutMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.kgk.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.kgk.setLayoutParams(marginLayoutParams);
        }
    }

    public void Dt(int i) {
        ViewGroup.LayoutParams layoutParams = this.ajU.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.ajU.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.eTe = R.drawable.new_pic_emotion_03;
                    return;
                case NODATA:
                    this.eTe = R.drawable.new_pic_emotion_05;
                    return;
                case FINDBAR:
                    this.eTe = R.drawable.new_pic_emotion_01;
                    return;
                case EMOTION:
                    this.eTe = R.drawable.new_pic_emotion_02;
                    return;
                case GIFT:
                    this.eTe = R.drawable.new_pic_emotion_07;
                    return;
                case SINGALL:
                    this.eTe = R.drawable.new_pic_emotion_06;
                    return;
                case WEBVIEW:
                    this.eTe = R.drawable.new_pic_emotion_08;
                    return;
                default:
                    return;
            }
        }
    }
}
