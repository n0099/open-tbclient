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
    private String aHI;
    private String aHJ;
    public TextView axe;
    public TbImageView ePH;
    public TextView ePI;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.ePH = (TbImageView) view.findViewById(e.g.net_refresh_image);
        this.axe = (TextView) view.findViewById(e.g.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(e.g.net_refresh_title);
        this.ePI = (TextView) view.findViewById(e.g.net_refresh_button);
        this.ePI.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        al.c(this.axe, e.d.cp_cont_d, 1);
        al.c(this.mTitleView, e.d.cp_cont_b, 1);
        al.c(this.ePI, e.d.cp_cont_g, 1);
        al.i(this.ePI, e.f.btn_appdownload);
        this.axe.setText(str);
        this.mTitleView.setText(str2);
        this.ePI.setText(str3);
        gd(0);
        pT(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.ePH.setImageBitmap(al.dQ(e.f.pic_emotion08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.ePH.setImageBitmap(al.dQ(e.f.no_data_image));
        } else {
            d(imgType);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.ePH.startLoad(this.aHJ, 29, false);
            } else {
                this.ePH.startLoad(this.aHI, 29, false);
            }
        }
    }

    public void gd(int i) {
        ViewGroup.LayoutParams layoutParams = this.ePH.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.ePH.setLayoutParams(marginLayoutParams);
        }
    }

    public void pT(int i) {
        ViewGroup.LayoutParams layoutParams = this.ePI.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.ePI.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.aHI = com.baidu.tbadk.util.c.PL().iy("pic_emotion03.png");
                    this.aHJ = com.baidu.tbadk.util.c.PL().iy("pic_emotion03_1.png");
                    return;
                case NODATA:
                    this.aHI = com.baidu.tbadk.util.c.PL().iy("pic_emotion05.png");
                    this.aHJ = com.baidu.tbadk.util.c.PL().iy("pic_emotion05_1.png");
                    return;
                case FINDBAR:
                    this.aHI = com.baidu.tbadk.util.c.PL().iy("pic_emotion01.png");
                    this.aHJ = com.baidu.tbadk.util.c.PL().iy("pic_emotion01_1.png");
                    return;
                case EMOTION:
                    this.aHI = com.baidu.tbadk.util.c.PL().iy("pic_emotion02.png");
                    this.aHJ = com.baidu.tbadk.util.c.PL().iy("pic_emotion02_1.png");
                    return;
                case GIFT:
                    this.aHI = com.baidu.tbadk.util.c.PL().iy("pic_emotion07.png");
                    this.aHJ = com.baidu.tbadk.util.c.PL().iy("pic_emotion07_1.png");
                    return;
                case SINGALL:
                    this.aHI = com.baidu.tbadk.util.c.PL().iy("pic_emotion06.png");
                    this.aHJ = com.baidu.tbadk.util.c.PL().iy("pic_emotion06_1.png");
                    return;
                case WEBVIEW:
                    this.aHI = com.baidu.tbadk.util.c.PL().iy("pic_emotion08.png");
                    this.aHJ = com.baidu.tbadk.util.c.PL().iy("pic_emotion08_1.png");
                    return;
                default:
                    return;
            }
        }
    }
}
