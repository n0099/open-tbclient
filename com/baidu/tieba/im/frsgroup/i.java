package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class i extends q.a {
    public TextView alv;
    private String avk;
    private String avl;
    public TbImageView ekM;
    public TextView mButton;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.ekM = (TbImageView) view.findViewById(d.g.net_refresh_image);
        this.alv = (TextView) view.findViewById(d.g.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(d.g.net_refresh_title);
        this.mButton = (TextView) view.findViewById(d.g.net_refresh_button);
        this.mButton.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        al.c(this.alv, d.C0141d.cp_cont_d, 1);
        al.c(this.mTitleView, d.C0141d.cp_cont_b, 1);
        al.c(this.mButton, d.C0141d.cp_cont_g, 1);
        al.i(this.mButton, d.f.btn_appdownload);
        this.alv.setText(str);
        this.mTitleView.setText(str2);
        this.mButton.setText(str3);
        ff(0);
        nJ(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.ekM.setImageBitmap(al.cS(d.f.pic_emotion08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.ekM.setImageBitmap(al.cS(d.f.no_data_image));
        } else {
            d(imgType);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.ekM.startLoad(this.avl, 29, false);
            } else {
                this.ekM.startLoad(this.avk, 29, false);
            }
        }
    }

    public void ff(int i) {
        ViewGroup.LayoutParams layoutParams = this.ekM.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.ekM.setLayoutParams(marginLayoutParams);
        }
    }

    public void nJ(int i) {
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
                    this.avk = com.baidu.tbadk.util.b.KQ().hs("pic_emotion03.png");
                    this.avl = com.baidu.tbadk.util.b.KQ().hs("pic_emotion03_1.png");
                    return;
                case NODATA:
                    this.avk = com.baidu.tbadk.util.b.KQ().hs("pic_emotion05.png");
                    this.avl = com.baidu.tbadk.util.b.KQ().hs("pic_emotion05_1.png");
                    return;
                case FINDBAR:
                    this.avk = com.baidu.tbadk.util.b.KQ().hs("pic_emotion01.png");
                    this.avl = com.baidu.tbadk.util.b.KQ().hs("pic_emotion01_1.png");
                    return;
                case EMOTION:
                    this.avk = com.baidu.tbadk.util.b.KQ().hs("pic_emotion02.png");
                    this.avl = com.baidu.tbadk.util.b.KQ().hs("pic_emotion02_1.png");
                    return;
                case GIFT:
                    this.avk = com.baidu.tbadk.util.b.KQ().hs("pic_emotion07.png");
                    this.avl = com.baidu.tbadk.util.b.KQ().hs("pic_emotion07_1.png");
                    return;
                case SINGALL:
                    this.avk = com.baidu.tbadk.util.b.KQ().hs("pic_emotion06.png");
                    this.avl = com.baidu.tbadk.util.b.KQ().hs("pic_emotion06_1.png");
                    return;
                case WEBVIEW:
                    this.avk = com.baidu.tbadk.util.b.KQ().hs("pic_emotion08.png");
                    this.avl = com.baidu.tbadk.util.b.KQ().hs("pic_emotion08_1.png");
                    return;
                default:
                    return;
            }
        }
    }
}
