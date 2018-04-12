package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class i extends q.a {
    public TextView adx;
    private String anc;
    private String and;
    public TbImageView dYv;
    public TextView mButton;
    public TextView mTitleView;

    public i(View view2, View.OnClickListener onClickListener) {
        super(view2);
        this.dYv = (TbImageView) view2.findViewById(d.g.net_refresh_image);
        this.adx = (TextView) view2.findViewById(d.g.net_refresh_desc);
        this.mTitleView = (TextView) view2.findViewById(d.g.net_refresh_title);
        this.mButton = (TextView) view2.findViewById(d.g.net_refresh_button);
        this.mButton.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        ak.c(this.adx, d.C0126d.cp_cont_d, 1);
        ak.c(this.mTitleView, d.C0126d.cp_cont_b, 1);
        ak.c(this.mButton, d.C0126d.cp_cont_g, 1);
        ak.i(this.mButton, d.f.btn_appdownload);
        this.adx.setText(str);
        this.mTitleView.setText(str2);
        this.mButton.setText(str3);
        fb(0);
        nz(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.dYv.setImageBitmap(ak.cQ(d.f.pic_emotion08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.dYv.setImageBitmap(ak.cQ(d.f.no_data_image));
        } else {
            d(imgType);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.dYv.startLoad(this.and, 29, false);
            } else {
                this.dYv.startLoad(this.anc, 29, false);
            }
        }
    }

    public void fb(int i) {
        ViewGroup.LayoutParams layoutParams = this.dYv.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.dYv.setLayoutParams(marginLayoutParams);
        }
    }

    public void nz(int i) {
        ViewGroup.LayoutParams layoutParams = this.mButton.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.mButton.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.anc = com.baidu.tbadk.util.b.Hy().gX("pic_emotion03.png");
                    this.and = com.baidu.tbadk.util.b.Hy().gX("pic_emotion03_1.png");
                    return;
                case NODATA:
                    this.anc = com.baidu.tbadk.util.b.Hy().gX("pic_emotion05.png");
                    this.and = com.baidu.tbadk.util.b.Hy().gX("pic_emotion05_1.png");
                    return;
                case FINDBAR:
                    this.anc = com.baidu.tbadk.util.b.Hy().gX("pic_emotion01.png");
                    this.and = com.baidu.tbadk.util.b.Hy().gX("pic_emotion01_1.png");
                    return;
                case EMOTION:
                    this.anc = com.baidu.tbadk.util.b.Hy().gX("pic_emotion02.png");
                    this.and = com.baidu.tbadk.util.b.Hy().gX("pic_emotion02_1.png");
                    return;
                case GIFT:
                    this.anc = com.baidu.tbadk.util.b.Hy().gX("pic_emotion07.png");
                    this.and = com.baidu.tbadk.util.b.Hy().gX("pic_emotion07_1.png");
                    return;
                case SINGALL:
                    this.anc = com.baidu.tbadk.util.b.Hy().gX("pic_emotion06.png");
                    this.and = com.baidu.tbadk.util.b.Hy().gX("pic_emotion06_1.png");
                    return;
                case WEBVIEW:
                    this.anc = com.baidu.tbadk.util.b.Hy().gX("pic_emotion08.png");
                    this.and = com.baidu.tbadk.util.b.Hy().gX("pic_emotion08_1.png");
                    return;
                default:
                    return;
            }
        }
    }
}
