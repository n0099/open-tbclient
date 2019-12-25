package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class i extends v.a {
    private int dbC;
    public TbImageView huC;
    public TBSpecificationBtn huD;
    public TextView mDescView;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.huC = (TbImageView) view.findViewById(R.id.net_refresh_image);
        this.mDescView = (TextView) view.findViewById(R.id.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(R.id.net_refresh_title);
        this.huD = (TBSpecificationBtn) view.findViewById(R.id.net_refresh_button);
        this.huD.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        am.setViewTextColor(this.mDescView, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.mTitleView, R.color.cp_cont_j, 1);
        this.mDescView.setText(str);
        this.mTitleView.setText(str2);
        this.huD.setText(str3);
        setLayoutMargin(0);
        wi(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.huC.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.huC.setImageBitmap(am.getBitmap565Quality(R.drawable.new_pic_emotion_05));
        } else {
            d(imgType);
            this.huC.setImageBitmap(am.getBitmap565Quality(this.dbC));
        }
    }

    public void setLayoutMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.huC.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.huC.setLayoutParams(marginLayoutParams);
        }
    }

    public void wi(int i) {
        ViewGroup.LayoutParams layoutParams = this.huD.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.huD.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.dbC = R.drawable.new_pic_emotion_03;
                    return;
                case NODATA:
                    this.dbC = R.drawable.new_pic_emotion_05;
                    return;
                case FINDBAR:
                    this.dbC = R.drawable.new_pic_emotion_01;
                    return;
                case EMOTION:
                    this.dbC = R.drawable.new_pic_emotion_02;
                    return;
                case GIFT:
                    this.dbC = R.drawable.new_pic_emotion_07;
                    return;
                case SINGALL:
                    this.dbC = R.drawable.new_pic_emotion_06;
                    return;
                case WEBVIEW:
                    this.dbC = R.drawable.new_pic_emotion_08;
                    return;
                default:
                    return;
            }
        }
    }
}
