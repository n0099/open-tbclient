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
    private String aHJ;
    private String aHK;
    public TextView axf;
    public TbImageView eSy;
    public TextView eSz;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.eSy = (TbImageView) view.findViewById(e.g.net_refresh_image);
        this.axf = (TextView) view.findViewById(e.g.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(e.g.net_refresh_title);
        this.eSz = (TextView) view.findViewById(e.g.net_refresh_button);
        this.eSz.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        al.c(this.axf, e.d.cp_cont_d, 1);
        al.c(this.mTitleView, e.d.cp_cont_b, 1);
        al.c(this.eSz, e.d.cp_cont_g, 1);
        al.i(this.eSz, e.f.btn_appdownload);
        this.axf.setText(str);
        this.mTitleView.setText(str2);
        this.eSz.setText(str3);
        ge(0);
        qg(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.eSy.setImageBitmap(al.dQ(e.f.pic_emotion08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.eSy.setImageBitmap(al.dQ(e.f.no_data_image));
        } else {
            d(imgType);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.eSy.startLoad(this.aHK, 29, false);
            } else {
                this.eSy.startLoad(this.aHJ, 29, false);
            }
        }
    }

    public void ge(int i) {
        ViewGroup.LayoutParams layoutParams = this.eSy.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.eSy.setLayoutParams(marginLayoutParams);
        }
    }

    public void qg(int i) {
        ViewGroup.LayoutParams layoutParams = this.eSz.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.eSz.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.aHJ = com.baidu.tbadk.util.c.PN().iz("pic_emotion03.png");
                    this.aHK = com.baidu.tbadk.util.c.PN().iz("pic_emotion03_1.png");
                    return;
                case NODATA:
                    this.aHJ = com.baidu.tbadk.util.c.PN().iz("pic_emotion05.png");
                    this.aHK = com.baidu.tbadk.util.c.PN().iz("pic_emotion05_1.png");
                    return;
                case FINDBAR:
                    this.aHJ = com.baidu.tbadk.util.c.PN().iz("pic_emotion01.png");
                    this.aHK = com.baidu.tbadk.util.c.PN().iz("pic_emotion01_1.png");
                    return;
                case EMOTION:
                    this.aHJ = com.baidu.tbadk.util.c.PN().iz("pic_emotion02.png");
                    this.aHK = com.baidu.tbadk.util.c.PN().iz("pic_emotion02_1.png");
                    return;
                case GIFT:
                    this.aHJ = com.baidu.tbadk.util.c.PN().iz("pic_emotion07.png");
                    this.aHK = com.baidu.tbadk.util.c.PN().iz("pic_emotion07_1.png");
                    return;
                case SINGALL:
                    this.aHJ = com.baidu.tbadk.util.c.PN().iz("pic_emotion06.png");
                    this.aHK = com.baidu.tbadk.util.c.PN().iz("pic_emotion06_1.png");
                    return;
                case WEBVIEW:
                    this.aHJ = com.baidu.tbadk.util.c.PN().iz("pic_emotion08.png");
                    this.aHK = com.baidu.tbadk.util.c.PN().iz("pic_emotion08_1.png");
                    return;
                default:
                    return;
            }
        }
    }
}
