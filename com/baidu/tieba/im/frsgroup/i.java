package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class i extends r.a {
    public TextView aSb;
    private String bbI;
    private String bbJ;
    public TbImageView eDR;
    public TextView mButton;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.eDR = (TbImageView) view.findViewById(d.g.net_refresh_image);
        this.aSb = (TextView) view.findViewById(d.g.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(d.g.net_refresh_title);
        this.mButton = (TextView) view.findViewById(d.g.net_refresh_button);
        this.mButton.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        aj.e(this.aSb, d.C0141d.cp_cont_d, 1);
        aj.e(this.mTitleView, d.C0141d.cp_cont_b, 1);
        aj.e(this.mButton, d.C0141d.cp_cont_g, 1);
        aj.s(this.mButton, d.f.btn_appdownload);
        this.aSb.setText(str);
        this.mTitleView.setText(str2);
        this.mButton.setText(str3);
        ib(0);
        qb(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.eDR.setImageBitmap(aj.fQ(d.f.pic_emotion08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.eDR.setImageBitmap(aj.fQ(d.f.no_data_image));
        } else {
            d(imgType);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.eDR.startLoad(this.bbJ, 29, false);
            } else {
                this.eDR.startLoad(this.bbI, 29, false);
            }
        }
    }

    public void ib(int i) {
        ViewGroup.LayoutParams layoutParams = this.eDR.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.eDR.setLayoutParams(marginLayoutParams);
        }
    }

    public void qb(int i) {
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
                    this.bbI = com.baidu.tbadk.util.b.OV().hf("pic_emotion03.png");
                    this.bbJ = com.baidu.tbadk.util.b.OV().hf("pic_emotion03_1.png");
                    return;
                case NODATA:
                    this.bbI = com.baidu.tbadk.util.b.OV().hf("pic_emotion05.png");
                    this.bbJ = com.baidu.tbadk.util.b.OV().hf("pic_emotion05_1.png");
                    return;
                case FINDBAR:
                    this.bbI = com.baidu.tbadk.util.b.OV().hf("pic_emotion01.png");
                    this.bbJ = com.baidu.tbadk.util.b.OV().hf("pic_emotion01_1.png");
                    return;
                case EMOTION:
                    this.bbI = com.baidu.tbadk.util.b.OV().hf("pic_emotion02.png");
                    this.bbJ = com.baidu.tbadk.util.b.OV().hf("pic_emotion02_1.png");
                    return;
                case GIFT:
                    this.bbI = com.baidu.tbadk.util.b.OV().hf("pic_emotion07.png");
                    this.bbJ = com.baidu.tbadk.util.b.OV().hf("pic_emotion07_1.png");
                    return;
                case SINGALL:
                    this.bbI = com.baidu.tbadk.util.b.OV().hf("pic_emotion06.png");
                    this.bbJ = com.baidu.tbadk.util.b.OV().hf("pic_emotion06_1.png");
                    return;
                case WEBVIEW:
                    this.bbI = com.baidu.tbadk.util.b.OV().hf("pic_emotion08.png");
                    this.bbJ = com.baidu.tbadk.util.b.OV().hf("pic_emotion08_1.png");
                    return;
                default:
                    return;
            }
        }
    }
}
