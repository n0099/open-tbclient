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
    public TBSpecificationBtn akU;
    private int faz;
    public TbImageView ktK;
    public TextView mDescView;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.ktK = (TbImageView) view.findViewById(R.id.net_refresh_image);
        this.mDescView = (TextView) view.findViewById(R.id.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(R.id.net_refresh_title);
        this.akU = (TBSpecificationBtn) view.findViewById(R.id.net_refresh_button);
        this.akU.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        ap.setViewTextColor(this.mDescView, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0107, 1);
        this.mDescView.setText(str);
        this.mTitleView.setText(str2);
        this.akU.setText(str3);
        setLayoutMargin(0);
        Ei(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.ktK.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.ktK.setImageBitmap(ap.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else {
            d(imgType);
            this.ktK.setImageBitmap(ap.getBitmap565Quality(this.faz));
        }
    }

    public void setLayoutMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.ktK.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.ktK.setLayoutParams(marginLayoutParams);
        }
    }

    public void Ei(int i) {
        ViewGroup.LayoutParams layoutParams = this.akU.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.akU.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.faz = R.drawable.new_pic_emotion_03;
                    return;
                case NODATA:
                    this.faz = R.drawable.new_pic_emotion_05;
                    return;
                case FINDBAR:
                    this.faz = R.drawable.new_pic_emotion_01;
                    return;
                case EMOTION:
                    this.faz = R.drawable.new_pic_emotion_02;
                    return;
                case GIFT:
                    this.faz = R.drawable.new_pic_emotion_07;
                    return;
                case SINGALL:
                    this.faz = R.drawable.new_pic_emotion_06;
                    return;
                case WEBVIEW:
                    this.faz = R.drawable.new_pic_emotion_08;
                    return;
                default:
                    return;
            }
        }
    }
}
