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
    public TextView bFJ;
    private int bQF;
    public TbImageView gjt;
    public EmotionButton gju;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.gjt = (TbImageView) view.findViewById(d.g.net_refresh_image);
        this.bFJ = (TextView) view.findViewById(d.g.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(d.g.net_refresh_title);
        this.gju = (EmotionButton) view.findViewById(d.g.net_refresh_button);
        this.gju.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        al.d(this.bFJ, d.C0277d.cp_cont_d, 1);
        al.d(this.mTitleView, d.C0277d.cp_cont_j, 1);
        this.bFJ.setText(str);
        this.mTitleView.setText(str2);
        this.gju.setText(str3);
        jR(0);
        tR(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.gjt.setImageBitmap(al.hs(d.f.new_pic_emotion_08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.gjt.setImageBitmap(al.hs(d.f.new_pic_emotion_05));
        } else {
            d(imgType);
            this.gjt.setImageBitmap(al.hs(this.bQF));
        }
    }

    public void jR(int i) {
        ViewGroup.LayoutParams layoutParams = this.gjt.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.gjt.setLayoutParams(marginLayoutParams);
        }
    }

    public void tR(int i) {
        ViewGroup.LayoutParams layoutParams = this.gju.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.gju.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.bQF = d.f.new_pic_emotion_03;
                    return;
                case NODATA:
                    this.bQF = d.f.new_pic_emotion_05;
                    return;
                case FINDBAR:
                    this.bQF = d.f.new_pic_emotion_01;
                    return;
                case EMOTION:
                    this.bQF = d.f.new_pic_emotion_02;
                    return;
                case GIFT:
                    this.bQF = d.f.new_pic_emotion_07;
                    return;
                case SINGALL:
                    this.bQF = d.f.new_pic_emotion_06;
                    return;
                case WEBVIEW:
                    this.bQF = d.f.new_pic_emotion_08;
                    return;
                default:
                    return;
            }
        }
    }
}
