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
    public TextView alV;
    private String avT;
    private String avU;
    public TbImageView eoH;
    public TextView eoI;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.eoH = (TbImageView) view.findViewById(d.g.net_refresh_image);
        this.alV = (TextView) view.findViewById(d.g.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(d.g.net_refresh_title);
        this.eoI = (TextView) view.findViewById(d.g.net_refresh_button);
        this.eoI.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        am.c(this.alV, d.C0142d.cp_cont_d, 1);
        am.c(this.mTitleView, d.C0142d.cp_cont_b, 1);
        am.c(this.eoI, d.C0142d.cp_cont_g, 1);
        am.i(this.eoI, d.f.btn_appdownload);
        this.alV.setText(str);
        this.mTitleView.setText(str2);
        this.eoI.setText(str3);
        fg(0);
        nQ(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.eoH.setImageBitmap(am.cT(d.f.pic_emotion08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.eoH.setImageBitmap(am.cT(d.f.no_data_image));
        } else {
            d(imgType);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.eoH.startLoad(this.avU, 29, false);
            } else {
                this.eoH.startLoad(this.avT, 29, false);
            }
        }
    }

    public void fg(int i) {
        ViewGroup.LayoutParams layoutParams = this.eoH.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.eoH.setLayoutParams(marginLayoutParams);
        }
    }

    public void nQ(int i) {
        ViewGroup.LayoutParams layoutParams = this.eoI.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.eoI.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.avT = com.baidu.tbadk.util.b.Li().hw("pic_emotion03.png");
                    this.avU = com.baidu.tbadk.util.b.Li().hw("pic_emotion03_1.png");
                    return;
                case NODATA:
                    this.avT = com.baidu.tbadk.util.b.Li().hw("pic_emotion05.png");
                    this.avU = com.baidu.tbadk.util.b.Li().hw("pic_emotion05_1.png");
                    return;
                case FINDBAR:
                    this.avT = com.baidu.tbadk.util.b.Li().hw("pic_emotion01.png");
                    this.avU = com.baidu.tbadk.util.b.Li().hw("pic_emotion01_1.png");
                    return;
                case EMOTION:
                    this.avT = com.baidu.tbadk.util.b.Li().hw("pic_emotion02.png");
                    this.avU = com.baidu.tbadk.util.b.Li().hw("pic_emotion02_1.png");
                    return;
                case GIFT:
                    this.avT = com.baidu.tbadk.util.b.Li().hw("pic_emotion07.png");
                    this.avU = com.baidu.tbadk.util.b.Li().hw("pic_emotion07_1.png");
                    return;
                case SINGALL:
                    this.avT = com.baidu.tbadk.util.b.Li().hw("pic_emotion06.png");
                    this.avU = com.baidu.tbadk.util.b.Li().hw("pic_emotion06_1.png");
                    return;
                case WEBVIEW:
                    this.avT = com.baidu.tbadk.util.b.Li().hw("pic_emotion08.png");
                    this.avU = com.baidu.tbadk.util.b.Li().hw("pic_emotion08_1.png");
                    return;
                default:
                    return;
            }
        }
    }
}
