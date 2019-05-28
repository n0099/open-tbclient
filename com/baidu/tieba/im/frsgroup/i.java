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
    public TextView bNm;
    private int bYz;
    public TbImageView gAv;
    public EmotionButton gAw;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.gAv = (TbImageView) view.findViewById(R.id.net_refresh_image);
        this.bNm = (TextView) view.findViewById(R.id.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(R.id.net_refresh_title);
        this.gAw = (EmotionButton) view.findViewById(R.id.net_refresh_button);
        this.gAw.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        al.f(this.bNm, R.color.cp_cont_d, 1);
        al.f(this.mTitleView, R.color.cp_cont_j, 1);
        this.bNm.setText(str);
        this.mTitleView.setText(str2);
        this.gAw.setText(str3);
        kE(0);
        uU(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.gAv.setImageBitmap(al.m19if(R.drawable.new_pic_emotion_08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.gAv.setImageBitmap(al.m19if(R.drawable.new_pic_emotion_05));
        } else {
            d(imgType);
            this.gAv.setImageBitmap(al.m19if(this.bYz));
        }
    }

    public void kE(int i) {
        ViewGroup.LayoutParams layoutParams = this.gAv.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.gAv.setLayoutParams(marginLayoutParams);
        }
    }

    public void uU(int i) {
        ViewGroup.LayoutParams layoutParams = this.gAw.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.gAw.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.bYz = R.drawable.new_pic_emotion_03;
                    return;
                case NODATA:
                    this.bYz = R.drawable.new_pic_emotion_05;
                    return;
                case FINDBAR:
                    this.bYz = R.drawable.new_pic_emotion_01;
                    return;
                case EMOTION:
                    this.bYz = R.drawable.new_pic_emotion_02;
                    return;
                case GIFT:
                    this.bYz = R.drawable.new_pic_emotion_07;
                    return;
                case SINGALL:
                    this.bYz = R.drawable.new_pic_emotion_06;
                    return;
                case WEBVIEW:
                    this.bYz = R.drawable.new_pic_emotion_08;
                    return;
                default:
                    return;
            }
        }
    }
}
