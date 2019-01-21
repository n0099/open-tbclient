package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class i extends q.a {
    private String aIm;
    private String aIn;
    public TextView axI;
    public TbImageView eTm;
    public TextView eTn;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.eTm = (TbImageView) view.findViewById(e.g.net_refresh_image);
        this.axI = (TextView) view.findViewById(e.g.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(e.g.net_refresh_title);
        this.eTn = (TextView) view.findViewById(e.g.net_refresh_button);
        this.eTn.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        al.c(this.axI, e.d.cp_cont_d, 1);
        al.c(this.mTitleView, e.d.cp_cont_b, 1);
        al.c(this.eTn, e.d.cp_cont_g, 1);
        al.i(this.eTn, e.f.btn_appdownload);
        this.axI.setText(str);
        this.mTitleView.setText(str2);
        this.eTn.setText(str3);
        ge(0);
        qh(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.eTm.setImageBitmap(al.dQ(e.f.pic_emotion08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.eTm.setImageBitmap(al.dQ(e.f.no_data_image));
        } else {
            d(imgType);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.eTm.startLoad(this.aIn, 29, false);
            } else {
                this.eTm.startLoad(this.aIm, 29, false);
            }
        }
    }

    public void ge(int i) {
        ViewGroup.LayoutParams layoutParams = this.eTm.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.eTm.setLayoutParams(marginLayoutParams);
        }
    }

    public void qh(int i) {
        ViewGroup.LayoutParams layoutParams = this.eTn.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.eTn.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion03.png");
                    this.aIn = com.baidu.tbadk.util.c.Qf().iN("pic_emotion03_1.png");
                    return;
                case NODATA:
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion05.png");
                    this.aIn = com.baidu.tbadk.util.c.Qf().iN("pic_emotion05_1.png");
                    return;
                case FINDBAR:
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion01.png");
                    this.aIn = com.baidu.tbadk.util.c.Qf().iN("pic_emotion01_1.png");
                    return;
                case EMOTION:
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion02.png");
                    this.aIn = com.baidu.tbadk.util.c.Qf().iN("pic_emotion02_1.png");
                    return;
                case GIFT:
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion07.png");
                    this.aIn = com.baidu.tbadk.util.c.Qf().iN("pic_emotion07_1.png");
                    return;
                case SINGALL:
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion06.png");
                    this.aIn = com.baidu.tbadk.util.c.Qf().iN("pic_emotion06_1.png");
                    return;
                case WEBVIEW:
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion08.png");
                    this.aIn = com.baidu.tbadk.util.c.Qf().iN("pic_emotion08_1.png");
                    return;
                default:
                    return;
            }
        }
    }
}
