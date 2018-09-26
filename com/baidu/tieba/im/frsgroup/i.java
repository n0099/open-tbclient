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
    public TextView anZ;
    private String ayJ;
    private String ayK;
    public TbImageView ezP;
    public TextView ezQ;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.ezP = (TbImageView) view.findViewById(e.g.net_refresh_image);
        this.anZ = (TextView) view.findViewById(e.g.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(e.g.net_refresh_title);
        this.ezQ = (TextView) view.findViewById(e.g.net_refresh_button);
        this.ezQ.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        al.c(this.anZ, e.d.cp_cont_d, 1);
        al.c(this.mTitleView, e.d.cp_cont_b, 1);
        al.c(this.ezQ, e.d.cp_cont_g, 1);
        al.i(this.ezQ, e.f.btn_appdownload);
        this.anZ.setText(str);
        this.mTitleView.setText(str2);
        this.ezQ.setText(str3);
        fs(0);
        oI(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.ezP.setImageBitmap(al.de(e.f.pic_emotion08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.ezP.setImageBitmap(al.de(e.f.no_data_image));
        } else {
            d(imgType);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.ezP.startLoad(this.ayK, 29, false);
            } else {
                this.ezP.startLoad(this.ayJ, 29, false);
            }
        }
    }

    public void fs(int i) {
        ViewGroup.LayoutParams layoutParams = this.ezP.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.ezP.setLayoutParams(marginLayoutParams);
        }
    }

    public void oI(int i) {
        ViewGroup.LayoutParams layoutParams = this.ezQ.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.ezQ.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.ayJ = com.baidu.tbadk.util.c.My().hQ("pic_emotion03.png");
                    this.ayK = com.baidu.tbadk.util.c.My().hQ("pic_emotion03_1.png");
                    return;
                case NODATA:
                    this.ayJ = com.baidu.tbadk.util.c.My().hQ("pic_emotion05.png");
                    this.ayK = com.baidu.tbadk.util.c.My().hQ("pic_emotion05_1.png");
                    return;
                case FINDBAR:
                    this.ayJ = com.baidu.tbadk.util.c.My().hQ("pic_emotion01.png");
                    this.ayK = com.baidu.tbadk.util.c.My().hQ("pic_emotion01_1.png");
                    return;
                case EMOTION:
                    this.ayJ = com.baidu.tbadk.util.c.My().hQ("pic_emotion02.png");
                    this.ayK = com.baidu.tbadk.util.c.My().hQ("pic_emotion02_1.png");
                    return;
                case GIFT:
                    this.ayJ = com.baidu.tbadk.util.c.My().hQ("pic_emotion07.png");
                    this.ayK = com.baidu.tbadk.util.c.My().hQ("pic_emotion07_1.png");
                    return;
                case SINGALL:
                    this.ayJ = com.baidu.tbadk.util.c.My().hQ("pic_emotion06.png");
                    this.ayK = com.baidu.tbadk.util.c.My().hQ("pic_emotion06_1.png");
                    return;
                case WEBVIEW:
                    this.ayJ = com.baidu.tbadk.util.c.My().hQ("pic_emotion08.png");
                    this.ayK = com.baidu.tbadk.util.c.My().hQ("pic_emotion08_1.png");
                    return;
                default:
                    return;
            }
        }
    }
}
