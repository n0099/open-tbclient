package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class i extends ad.a {
    private int ehH;
    public TbImageView jaw;
    public TBSpecificationBtn jax;
    public TextView mDescView;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.jaw = (TbImageView) view.findViewById(R.id.net_refresh_image);
        this.mDescView = (TextView) view.findViewById(R.id.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(R.id.net_refresh_title);
        this.jax = (TBSpecificationBtn) view.findViewById(R.id.net_refresh_button);
        this.jax.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        ao.setViewTextColor(this.mDescView, R.color.cp_cont_d, 1);
        ao.setViewTextColor(this.mTitleView, R.color.cp_cont_j, 1);
        this.mDescView.setText(str);
        this.mTitleView.setText(str2);
        this.jax.setText(str3);
        setLayoutMargin(0);
        yP(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.jaw.setImageBitmap(ao.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.jaw.setImageBitmap(ao.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else {
            d(imgType);
            this.jaw.setImageBitmap(ao.getBitmap565Quality(this.ehH));
        }
    }

    public void setLayoutMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.jaw.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.jaw.setLayoutParams(marginLayoutParams);
        }
    }

    public void yP(int i) {
        ViewGroup.LayoutParams layoutParams = this.jax.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.jax.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.ehH = R.drawable.new_pic_emotion_03;
                    return;
                case NODATA:
                    this.ehH = R.drawable.new_pic_emotion_05;
                    return;
                case FINDBAR:
                    this.ehH = R.drawable.new_pic_emotion_01;
                    return;
                case EMOTION:
                    this.ehH = R.drawable.new_pic_emotion_02;
                    return;
                case GIFT:
                    this.ehH = R.drawable.new_pic_emotion_07;
                    return;
                case SINGALL:
                    this.ehH = R.drawable.new_pic_emotion_06;
                    return;
                case WEBVIEW:
                    this.ehH = R.drawable.new_pic_emotion_08;
                    return;
                default:
                    return;
            }
        }
    }
}
