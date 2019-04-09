package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.view.EmotionButton;
/* loaded from: classes5.dex */
public class i extends v.a {
    public TextView bFM;
    private int bQI;
    public TbImageView gjh;
    public EmotionButton gji;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.gjh = (TbImageView) view.findViewById(d.g.net_refresh_image);
        this.bFM = (TextView) view.findViewById(d.g.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(d.g.net_refresh_title);
        this.gji = (EmotionButton) view.findViewById(d.g.net_refresh_button);
        this.gji.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        al.d(this.bFM, d.C0277d.cp_cont_d, 1);
        al.d(this.mTitleView, d.C0277d.cp_cont_j, 1);
        this.bFM.setText(str);
        this.mTitleView.setText(str2);
        this.gji.setText(str3);
        jQ(0);
        tN(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.gjh.setImageBitmap(al.hr(d.f.new_pic_emotion_08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.gjh.setImageBitmap(al.hr(d.f.new_pic_emotion_05));
        } else {
            d(imgType);
            this.gjh.setImageBitmap(al.hr(this.bQI));
        }
    }

    public void jQ(int i) {
        ViewGroup.LayoutParams layoutParams = this.gjh.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.gjh.setLayoutParams(marginLayoutParams);
        }
    }

    public void tN(int i) {
        ViewGroup.LayoutParams layoutParams = this.gji.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.gji.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.bQI = d.f.new_pic_emotion_03;
                    return;
                case NODATA:
                    this.bQI = d.f.new_pic_emotion_05;
                    return;
                case FINDBAR:
                    this.bQI = d.f.new_pic_emotion_01;
                    return;
                case EMOTION:
                    this.bQI = d.f.new_pic_emotion_02;
                    return;
                case GIFT:
                    this.bQI = d.f.new_pic_emotion_07;
                    return;
                case SINGALL:
                    this.bQI = d.f.new_pic_emotion_06;
                    return;
                case WEBVIEW:
                    this.bQI = d.f.new_pic_emotion_08;
                    return;
                default:
                    return;
            }
        }
    }
}
