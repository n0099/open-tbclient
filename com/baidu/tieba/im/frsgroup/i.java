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
    public TextView aRZ;
    private String bbG;
    private String bbH;
    public TbImageView eDB;
    public TextView mButton;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.eDB = (TbImageView) view.findViewById(d.g.net_refresh_image);
        this.aRZ = (TextView) view.findViewById(d.g.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(d.g.net_refresh_title);
        this.mButton = (TextView) view.findViewById(d.g.net_refresh_button);
        this.mButton.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        aj.e(this.aRZ, d.C0141d.cp_cont_d, 1);
        aj.e(this.mTitleView, d.C0141d.cp_cont_b, 1);
        aj.e(this.mButton, d.C0141d.cp_cont_g, 1);
        aj.s(this.mButton, d.f.btn_appdownload);
        this.aRZ.setText(str);
        this.mTitleView.setText(str2);
        this.mButton.setText(str3);
        ib(0);
        qa(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.eDB.setImageBitmap(aj.fQ(d.f.pic_emotion08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.eDB.setImageBitmap(aj.fQ(d.f.no_data_image));
        } else {
            d(imgType);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.eDB.startLoad(this.bbH, 29, false);
            } else {
                this.eDB.startLoad(this.bbG, 29, false);
            }
        }
    }

    public void ib(int i) {
        ViewGroup.LayoutParams layoutParams = this.eDB.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.eDB.setLayoutParams(marginLayoutParams);
        }
    }

    public void qa(int i) {
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
                    this.bbG = com.baidu.tbadk.util.b.OU().hf("pic_emotion03.png");
                    this.bbH = com.baidu.tbadk.util.b.OU().hf("pic_emotion03_1.png");
                    return;
                case NODATA:
                    this.bbG = com.baidu.tbadk.util.b.OU().hf("pic_emotion05.png");
                    this.bbH = com.baidu.tbadk.util.b.OU().hf("pic_emotion05_1.png");
                    return;
                case FINDBAR:
                    this.bbG = com.baidu.tbadk.util.b.OU().hf("pic_emotion01.png");
                    this.bbH = com.baidu.tbadk.util.b.OU().hf("pic_emotion01_1.png");
                    return;
                case EMOTION:
                    this.bbG = com.baidu.tbadk.util.b.OU().hf("pic_emotion02.png");
                    this.bbH = com.baidu.tbadk.util.b.OU().hf("pic_emotion02_1.png");
                    return;
                case GIFT:
                    this.bbG = com.baidu.tbadk.util.b.OU().hf("pic_emotion07.png");
                    this.bbH = com.baidu.tbadk.util.b.OU().hf("pic_emotion07_1.png");
                    return;
                case SINGALL:
                    this.bbG = com.baidu.tbadk.util.b.OU().hf("pic_emotion06.png");
                    this.bbH = com.baidu.tbadk.util.b.OU().hf("pic_emotion06_1.png");
                    return;
                case WEBVIEW:
                    this.bbG = com.baidu.tbadk.util.b.OU().hf("pic_emotion08.png");
                    this.bbH = com.baidu.tbadk.util.b.OU().hf("pic_emotion08_1.png");
                    return;
                default:
                    return;
            }
        }
    }
}
