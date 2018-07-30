package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class i extends q.a {
    public TextView alv;
    private String avA;
    private String avz;
    public TextView esA;
    public TbImageView esz;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.esz = (TbImageView) view.findViewById(d.g.net_refresh_image);
        this.alv = (TextView) view.findViewById(d.g.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(d.g.net_refresh_title);
        this.esA = (TextView) view.findViewById(d.g.net_refresh_button);
        this.esA.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        am.c(this.alv, d.C0140d.cp_cont_d, 1);
        am.c(this.mTitleView, d.C0140d.cp_cont_b, 1);
        am.c(this.esA, d.C0140d.cp_cont_g, 1);
        am.i(this.esA, d.f.btn_appdownload);
        this.alv.setText(str);
        this.mTitleView.setText(str2);
        this.esA.setText(str3);
        fh(0);
        oe(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.esz.setImageBitmap(am.cV(d.f.pic_emotion08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.esz.setImageBitmap(am.cV(d.f.no_data_image));
        } else {
            d(imgType);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.esz.startLoad(this.avA, 29, false);
            } else {
                this.esz.startLoad(this.avz, 29, false);
            }
        }
    }

    public void fh(int i) {
        ViewGroup.LayoutParams layoutParams = this.esz.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.esz.setLayoutParams(marginLayoutParams);
        }
    }

    public void oe(int i) {
        ViewGroup.LayoutParams layoutParams = this.esA.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.esA.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.avz = com.baidu.tbadk.util.b.Ld().ht("pic_emotion03.png");
                    this.avA = com.baidu.tbadk.util.b.Ld().ht("pic_emotion03_1.png");
                    return;
                case NODATA:
                    this.avz = com.baidu.tbadk.util.b.Ld().ht("pic_emotion05.png");
                    this.avA = com.baidu.tbadk.util.b.Ld().ht("pic_emotion05_1.png");
                    return;
                case FINDBAR:
                    this.avz = com.baidu.tbadk.util.b.Ld().ht("pic_emotion01.png");
                    this.avA = com.baidu.tbadk.util.b.Ld().ht("pic_emotion01_1.png");
                    return;
                case EMOTION:
                    this.avz = com.baidu.tbadk.util.b.Ld().ht("pic_emotion02.png");
                    this.avA = com.baidu.tbadk.util.b.Ld().ht("pic_emotion02_1.png");
                    return;
                case GIFT:
                    this.avz = com.baidu.tbadk.util.b.Ld().ht("pic_emotion07.png");
                    this.avA = com.baidu.tbadk.util.b.Ld().ht("pic_emotion07_1.png");
                    return;
                case SINGALL:
                    this.avz = com.baidu.tbadk.util.b.Ld().ht("pic_emotion06.png");
                    this.avA = com.baidu.tbadk.util.b.Ld().ht("pic_emotion06_1.png");
                    return;
                case WEBVIEW:
                    this.avz = com.baidu.tbadk.util.b.Ld().ht("pic_emotion08.png");
                    this.avA = com.baidu.tbadk.util.b.Ld().ht("pic_emotion08_1.png");
                    return;
                default:
                    return;
            }
        }
    }
}
