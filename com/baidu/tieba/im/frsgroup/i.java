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
    public TextView bOU;
    private int caB;
    public TbImageView gJr;
    public EmotionButton gJs;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.gJr = (TbImageView) view.findViewById(R.id.net_refresh_image);
        this.bOU = (TextView) view.findViewById(R.id.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(R.id.net_refresh_title);
        this.gJs = (EmotionButton) view.findViewById(R.id.net_refresh_button);
        this.gJs.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        am.f(this.bOU, R.color.cp_cont_d, 1);
        am.f(this.mTitleView, R.color.cp_cont_j, 1);
        this.bOU.setText(str);
        this.mTitleView.setText(str2);
        this.gJs.setText(str3);
        kO(0);
        vB(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.gJr.setImageBitmap(am.il(R.drawable.new_pic_emotion_08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.gJr.setImageBitmap(am.il(R.drawable.new_pic_emotion_05));
        } else {
            d(imgType);
            this.gJr.setImageBitmap(am.il(this.caB));
        }
    }

    public void kO(int i) {
        ViewGroup.LayoutParams layoutParams = this.gJr.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.gJr.setLayoutParams(marginLayoutParams);
        }
    }

    public void vB(int i) {
        ViewGroup.LayoutParams layoutParams = this.gJs.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.gJs.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.caB = R.drawable.new_pic_emotion_03;
                    return;
                case NODATA:
                    this.caB = R.drawable.new_pic_emotion_05;
                    return;
                case FINDBAR:
                    this.caB = R.drawable.new_pic_emotion_01;
                    return;
                case EMOTION:
                    this.caB = R.drawable.new_pic_emotion_02;
                    return;
                case GIFT:
                    this.caB = R.drawable.new_pic_emotion_07;
                    return;
                case SINGALL:
                    this.caB = R.drawable.new_pic_emotion_06;
                    return;
                case WEBVIEW:
                    this.caB = R.drawable.new_pic_emotion_08;
                    return;
                default:
                    return;
            }
        }
    }
}
