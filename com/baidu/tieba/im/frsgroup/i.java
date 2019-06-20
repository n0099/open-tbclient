package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.EmotionButton;
/* loaded from: classes5.dex */
public class i extends v.a {
    public TextView bNn;
    private int bYA;
    public TbImageView gAx;
    public EmotionButton gAy;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.gAx = (TbImageView) view.findViewById(R.id.net_refresh_image);
        this.bNn = (TextView) view.findViewById(R.id.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(R.id.net_refresh_title);
        this.gAy = (EmotionButton) view.findViewById(R.id.net_refresh_button);
        this.gAy.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        al.f(this.bNn, R.color.cp_cont_d, 1);
        al.f(this.mTitleView, R.color.cp_cont_j, 1);
        this.bNn.setText(str);
        this.mTitleView.setText(str2);
        this.gAy.setText(str3);
        kE(0);
        uU(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.gAx.setImageBitmap(al.m19if(R.drawable.new_pic_emotion_08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.gAx.setImageBitmap(al.m19if(R.drawable.new_pic_emotion_05));
        } else {
            d(imgType);
            this.gAx.setImageBitmap(al.m19if(this.bYA));
        }
    }

    public void kE(int i) {
        ViewGroup.LayoutParams layoutParams = this.gAx.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.gAx.setLayoutParams(marginLayoutParams);
        }
    }

    public void uU(int i) {
        ViewGroup.LayoutParams layoutParams = this.gAy.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.gAy.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.bYA = R.drawable.new_pic_emotion_03;
                    return;
                case NODATA:
                    this.bYA = R.drawable.new_pic_emotion_05;
                    return;
                case FINDBAR:
                    this.bYA = R.drawable.new_pic_emotion_01;
                    return;
                case EMOTION:
                    this.bYA = R.drawable.new_pic_emotion_02;
                    return;
                case GIFT:
                    this.bYA = R.drawable.new_pic_emotion_07;
                    return;
                case SINGALL:
                    this.bYA = R.drawable.new_pic_emotion_06;
                    return;
                case WEBVIEW:
                    this.bYA = R.drawable.new_pic_emotion_08;
                    return;
                default:
                    return;
            }
        }
    }
}
