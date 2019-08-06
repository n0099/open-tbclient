package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.EmotionButton;
/* loaded from: classes5.dex */
public class i extends v.a {
    public TextView bOt;
    private int bZI;
    public EmotionButton gHA;
    public TbImageView gHz;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.gHz = (TbImageView) view.findViewById(R.id.net_refresh_image);
        this.bOt = (TextView) view.findViewById(R.id.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(R.id.net_refresh_title);
        this.gHA = (EmotionButton) view.findViewById(R.id.net_refresh_button);
        this.gHA.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        am.f(this.bOt, R.color.cp_cont_d, 1);
        am.f(this.mTitleView, R.color.cp_cont_j, 1);
        this.bOt.setText(str);
        this.mTitleView.setText(str2);
        this.gHA.setText(str3);
        kL(0);
        vx(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.gHz.setImageBitmap(am.il(R.drawable.new_pic_emotion_08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.gHz.setImageBitmap(am.il(R.drawable.new_pic_emotion_05));
        } else {
            d(imgType);
            this.gHz.setImageBitmap(am.il(this.bZI));
        }
    }

    public void kL(int i) {
        ViewGroup.LayoutParams layoutParams = this.gHz.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.gHz.setLayoutParams(marginLayoutParams);
        }
    }

    public void vx(int i) {
        ViewGroup.LayoutParams layoutParams = this.gHA.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.gHA.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.bZI = R.drawable.new_pic_emotion_03;
                    return;
                case NODATA:
                    this.bZI = R.drawable.new_pic_emotion_05;
                    return;
                case FINDBAR:
                    this.bZI = R.drawable.new_pic_emotion_01;
                    return;
                case EMOTION:
                    this.bZI = R.drawable.new_pic_emotion_02;
                    return;
                case GIFT:
                    this.bZI = R.drawable.new_pic_emotion_07;
                    return;
                case SINGALL:
                    this.bZI = R.drawable.new_pic_emotion_06;
                    return;
                case WEBVIEW:
                    this.bZI = R.drawable.new_pic_emotion_08;
                    return;
                default:
                    return;
            }
        }
    }
}
