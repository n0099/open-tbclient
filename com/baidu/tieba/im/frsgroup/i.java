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
    private String aDs;
    private String aDt;
    public TextView asR;
    public TbImageView eHA;
    public TextView eHB;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.eHA = (TbImageView) view.findViewById(e.g.net_refresh_image);
        this.asR = (TextView) view.findViewById(e.g.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(e.g.net_refresh_title);
        this.eHB = (TextView) view.findViewById(e.g.net_refresh_button);
        this.eHB.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        al.c(this.asR, e.d.cp_cont_d, 1);
        al.c(this.mTitleView, e.d.cp_cont_b, 1);
        al.c(this.eHB, e.d.cp_cont_g, 1);
        al.i(this.eHB, e.f.btn_appdownload);
        this.asR.setText(str);
        this.mTitleView.setText(str2);
        this.eHB.setText(str3);
        fB(0);
        pg(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.eHA.setImageBitmap(al.m17do(e.f.pic_emotion08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.eHA.setImageBitmap(al.m17do(e.f.no_data_image));
        } else {
            d(imgType);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.eHA.startLoad(this.aDt, 29, false);
            } else {
                this.eHA.startLoad(this.aDs, 29, false);
            }
        }
    }

    public void fB(int i) {
        ViewGroup.LayoutParams layoutParams = this.eHA.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.eHA.setLayoutParams(marginLayoutParams);
        }
    }

    public void pg(int i) {
        ViewGroup.LayoutParams layoutParams = this.eHB.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.eHB.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.aDs = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion03.png");
                    this.aDt = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion03_1.png");
                    return;
                case NODATA:
                    this.aDs = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion05.png");
                    this.aDt = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion05_1.png");
                    return;
                case FINDBAR:
                    this.aDs = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion01.png");
                    this.aDt = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion01_1.png");
                    return;
                case EMOTION:
                    this.aDs = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion02.png");
                    this.aDt = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion02_1.png");
                    return;
                case GIFT:
                    this.aDs = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion07.png");
                    this.aDt = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion07_1.png");
                    return;
                case SINGALL:
                    this.aDs = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion06.png");
                    this.aDt = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion06_1.png");
                    return;
                case WEBVIEW:
                    this.aDs = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion08.png");
                    this.aDt = com.baidu.tbadk.util.c.Ow().m18if("pic_emotion08_1.png");
                    return;
                default:
                    return;
            }
        }
    }
}
