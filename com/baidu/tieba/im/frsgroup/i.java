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
    public TextView bFL;
    private int bQH;
    public TbImageView gjg;
    public EmotionButton gjh;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.gjg = (TbImageView) view.findViewById(d.g.net_refresh_image);
        this.bFL = (TextView) view.findViewById(d.g.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(d.g.net_refresh_title);
        this.gjh = (EmotionButton) view.findViewById(d.g.net_refresh_button);
        this.gjh.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        al.d(this.bFL, d.C0277d.cp_cont_d, 1);
        al.d(this.mTitleView, d.C0277d.cp_cont_j, 1);
        this.bFL.setText(str);
        this.mTitleView.setText(str2);
        this.gjh.setText(str3);
        jQ(0);
        tN(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.gjg.setImageBitmap(al.hr(d.f.new_pic_emotion_08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.gjg.setImageBitmap(al.hr(d.f.new_pic_emotion_05));
        } else {
            d(imgType);
            this.gjg.setImageBitmap(al.hr(this.bQH));
        }
    }

    public void jQ(int i) {
        ViewGroup.LayoutParams layoutParams = this.gjg.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.gjg.setLayoutParams(marginLayoutParams);
        }
    }

    public void tN(int i) {
        ViewGroup.LayoutParams layoutParams = this.gjh.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.gjh.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.bQH = d.f.new_pic_emotion_03;
                    return;
                case NODATA:
                    this.bQH = d.f.new_pic_emotion_05;
                    return;
                case FINDBAR:
                    this.bQH = d.f.new_pic_emotion_01;
                    return;
                case EMOTION:
                    this.bQH = d.f.new_pic_emotion_02;
                    return;
                case GIFT:
                    this.bQH = d.f.new_pic_emotion_07;
                    return;
                case SINGALL:
                    this.bQH = d.f.new_pic_emotion_06;
                    return;
                case WEBVIEW:
                    this.bQH = d.f.new_pic_emotion_08;
                    return;
                default:
                    return;
            }
        }
    }
}
