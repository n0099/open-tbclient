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
    public TextView bOo;
    private int bZC;
    public TbImageView gGH;
    public EmotionButton gGI;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.gGH = (TbImageView) view.findViewById(R.id.net_refresh_image);
        this.bOo = (TextView) view.findViewById(R.id.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(R.id.net_refresh_title);
        this.gGI = (EmotionButton) view.findViewById(R.id.net_refresh_button);
        this.gGI.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        am.f(this.bOo, R.color.cp_cont_d, 1);
        am.f(this.mTitleView, R.color.cp_cont_j, 1);
        this.bOo.setText(str);
        this.mTitleView.setText(str2);
        this.gGI.setText(str3);
        kK(0);
        vv(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.gGH.setImageBitmap(am.il(R.drawable.new_pic_emotion_08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.gGH.setImageBitmap(am.il(R.drawable.new_pic_emotion_05));
        } else {
            d(imgType);
            this.gGH.setImageBitmap(am.il(this.bZC));
        }
    }

    public void kK(int i) {
        ViewGroup.LayoutParams layoutParams = this.gGH.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.gGH.setLayoutParams(marginLayoutParams);
        }
    }

    public void vv(int i) {
        ViewGroup.LayoutParams layoutParams = this.gGI.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.gGI.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.bZC = R.drawable.new_pic_emotion_03;
                    return;
                case NODATA:
                    this.bZC = R.drawable.new_pic_emotion_05;
                    return;
                case FINDBAR:
                    this.bZC = R.drawable.new_pic_emotion_01;
                    return;
                case EMOTION:
                    this.bZC = R.drawable.new_pic_emotion_02;
                    return;
                case GIFT:
                    this.bZC = R.drawable.new_pic_emotion_07;
                    return;
                case SINGALL:
                    this.bZC = R.drawable.new_pic_emotion_06;
                    return;
                case WEBVIEW:
                    this.bZC = R.drawable.new_pic_emotion_08;
                    return;
                default:
                    return;
            }
        }
    }
}
