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
    private String aEi;
    private String aEj;
    public TextView atE;
    public TbImageView eIS;
    public TextView eIT;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.eIS = (TbImageView) view.findViewById(e.g.net_refresh_image);
        this.atE = (TextView) view.findViewById(e.g.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(e.g.net_refresh_title);
        this.eIT = (TextView) view.findViewById(e.g.net_refresh_button);
        this.eIT.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        al.c(this.atE, e.d.cp_cont_d, 1);
        al.c(this.mTitleView, e.d.cp_cont_b, 1);
        al.c(this.eIT, e.d.cp_cont_g, 1);
        al.i(this.eIT, e.f.btn_appdownload);
        this.atE.setText(str);
        this.mTitleView.setText(str2);
        this.eIT.setText(str3);
        fP(0);
        pz(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.eIS.setImageBitmap(al.dC(e.f.pic_emotion08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.eIS.setImageBitmap(al.dC(e.f.no_data_image));
        } else {
            d(imgType);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.eIS.startLoad(this.aEj, 29, false);
            } else {
                this.eIS.startLoad(this.aEi, 29, false);
            }
        }
    }

    public void fP(int i) {
        ViewGroup.LayoutParams layoutParams = this.eIS.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.eIS.setLayoutParams(marginLayoutParams);
        }
    }

    public void pz(int i) {
        ViewGroup.LayoutParams layoutParams = this.eIT.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.eIT.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.aEi = com.baidu.tbadk.util.c.OF().ig("pic_emotion03.png");
                    this.aEj = com.baidu.tbadk.util.c.OF().ig("pic_emotion03_1.png");
                    return;
                case NODATA:
                    this.aEi = com.baidu.tbadk.util.c.OF().ig("pic_emotion05.png");
                    this.aEj = com.baidu.tbadk.util.c.OF().ig("pic_emotion05_1.png");
                    return;
                case FINDBAR:
                    this.aEi = com.baidu.tbadk.util.c.OF().ig("pic_emotion01.png");
                    this.aEj = com.baidu.tbadk.util.c.OF().ig("pic_emotion01_1.png");
                    return;
                case EMOTION:
                    this.aEi = com.baidu.tbadk.util.c.OF().ig("pic_emotion02.png");
                    this.aEj = com.baidu.tbadk.util.c.OF().ig("pic_emotion02_1.png");
                    return;
                case GIFT:
                    this.aEi = com.baidu.tbadk.util.c.OF().ig("pic_emotion07.png");
                    this.aEj = com.baidu.tbadk.util.c.OF().ig("pic_emotion07_1.png");
                    return;
                case SINGALL:
                    this.aEi = com.baidu.tbadk.util.c.OF().ig("pic_emotion06.png");
                    this.aEj = com.baidu.tbadk.util.c.OF().ig("pic_emotion06_1.png");
                    return;
                case WEBVIEW:
                    this.aEi = com.baidu.tbadk.util.c.OF().ig("pic_emotion08.png");
                    this.aEj = com.baidu.tbadk.util.c.OF().ig("pic_emotion08_1.png");
                    return;
                default:
                    return;
            }
        }
    }
}
