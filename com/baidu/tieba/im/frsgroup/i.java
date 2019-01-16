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
    private String aIl;
    private String aIm;
    public TextView axH;
    public TbImageView eTl;
    public TextView eTm;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.eTl = (TbImageView) view.findViewById(e.g.net_refresh_image);
        this.axH = (TextView) view.findViewById(e.g.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(e.g.net_refresh_title);
        this.eTm = (TextView) view.findViewById(e.g.net_refresh_button);
        this.eTm.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        al.c(this.axH, e.d.cp_cont_d, 1);
        al.c(this.mTitleView, e.d.cp_cont_b, 1);
        al.c(this.eTm, e.d.cp_cont_g, 1);
        al.i(this.eTm, e.f.btn_appdownload);
        this.axH.setText(str);
        this.mTitleView.setText(str2);
        this.eTm.setText(str3);
        ge(0);
        qh(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.eTl.setImageBitmap(al.dQ(e.f.pic_emotion08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.eTl.setImageBitmap(al.dQ(e.f.no_data_image));
        } else {
            d(imgType);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.eTl.startLoad(this.aIm, 29, false);
            } else {
                this.eTl.startLoad(this.aIl, 29, false);
            }
        }
    }

    public void ge(int i) {
        ViewGroup.LayoutParams layoutParams = this.eTl.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.eTl.setLayoutParams(marginLayoutParams);
        }
    }

    public void qh(int i) {
        ViewGroup.LayoutParams layoutParams = this.eTm.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.eTm.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.aIl = com.baidu.tbadk.util.c.Qf().iN("pic_emotion03.png");
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion03_1.png");
                    return;
                case NODATA:
                    this.aIl = com.baidu.tbadk.util.c.Qf().iN("pic_emotion05.png");
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion05_1.png");
                    return;
                case FINDBAR:
                    this.aIl = com.baidu.tbadk.util.c.Qf().iN("pic_emotion01.png");
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion01_1.png");
                    return;
                case EMOTION:
                    this.aIl = com.baidu.tbadk.util.c.Qf().iN("pic_emotion02.png");
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion02_1.png");
                    return;
                case GIFT:
                    this.aIl = com.baidu.tbadk.util.c.Qf().iN("pic_emotion07.png");
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion07_1.png");
                    return;
                case SINGALL:
                    this.aIl = com.baidu.tbadk.util.c.Qf().iN("pic_emotion06.png");
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion06_1.png");
                    return;
                case WEBVIEW:
                    this.aIl = com.baidu.tbadk.util.c.Qf().iN("pic_emotion08.png");
                    this.aIm = com.baidu.tbadk.util.c.Qf().iN("pic_emotion08_1.png");
                    return;
                default:
                    return;
            }
        }
    }
}
