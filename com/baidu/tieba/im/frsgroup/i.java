package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class i extends q.a {
    public TextView alu;
    private String avx;
    private String avy;
    public TbImageView esv;
    public TextView esw;
    public TextView mTitleView;

    public i(View view, View.OnClickListener onClickListener) {
        super(view);
        this.esv = (TbImageView) view.findViewById(f.g.net_refresh_image);
        this.alu = (TextView) view.findViewById(f.g.net_refresh_desc);
        this.mTitleView = (TextView) view.findViewById(f.g.net_refresh_title);
        this.esw = (TextView) view.findViewById(f.g.net_refresh_button);
        this.esw.setOnClickListener(onClickListener);
    }

    public void a(NoDataViewFactory.ImgType imgType, String str, String str2, String str3) {
        am.c(this.alu, f.d.cp_cont_d, 1);
        am.c(this.mTitleView, f.d.cp_cont_b, 1);
        am.c(this.esw, f.d.cp_cont_g, 1);
        am.i(this.esw, f.C0146f.btn_appdownload);
        this.alu.setText(str);
        this.mTitleView.setText(str2);
        this.esw.setText(str3);
        fg(0);
        oe(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), f.e.ds30));
        if (imgType == NoDataViewFactory.ImgType.WEBVIEW) {
            this.esv.setImageBitmap(am.cV(f.C0146f.pic_emotion08));
        } else if (imgType == NoDataViewFactory.ImgType.NODATA) {
            this.esv.setImageBitmap(am.cV(f.C0146f.no_data_image));
        } else {
            d(imgType);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.esv.startLoad(this.avy, 29, false);
            } else {
                this.esv.startLoad(this.avx, 29, false);
            }
        }
    }

    public void fg(int i) {
        ViewGroup.LayoutParams layoutParams = this.esv.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.esv.setLayoutParams(marginLayoutParams);
        }
    }

    public void oe(int i) {
        ViewGroup.LayoutParams layoutParams = this.esw.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            this.esw.setLayoutParams(marginLayoutParams);
        }
    }

    public void d(NoDataViewFactory.ImgType imgType) {
        if (imgType != null) {
            switch (imgType) {
                case CREATE:
                    this.avx = com.baidu.tbadk.util.b.Lh().ht("pic_emotion03.png");
                    this.avy = com.baidu.tbadk.util.b.Lh().ht("pic_emotion03_1.png");
                    return;
                case NODATA:
                    this.avx = com.baidu.tbadk.util.b.Lh().ht("pic_emotion05.png");
                    this.avy = com.baidu.tbadk.util.b.Lh().ht("pic_emotion05_1.png");
                    return;
                case FINDBAR:
                    this.avx = com.baidu.tbadk.util.b.Lh().ht("pic_emotion01.png");
                    this.avy = com.baidu.tbadk.util.b.Lh().ht("pic_emotion01_1.png");
                    return;
                case EMOTION:
                    this.avx = com.baidu.tbadk.util.b.Lh().ht("pic_emotion02.png");
                    this.avy = com.baidu.tbadk.util.b.Lh().ht("pic_emotion02_1.png");
                    return;
                case GIFT:
                    this.avx = com.baidu.tbadk.util.b.Lh().ht("pic_emotion07.png");
                    this.avy = com.baidu.tbadk.util.b.Lh().ht("pic_emotion07_1.png");
                    return;
                case SINGALL:
                    this.avx = com.baidu.tbadk.util.b.Lh().ht("pic_emotion06.png");
                    this.avy = com.baidu.tbadk.util.b.Lh().ht("pic_emotion06_1.png");
                    return;
                case WEBVIEW:
                    this.avx = com.baidu.tbadk.util.b.Lh().ht("pic_emotion08.png");
                    this.avy = com.baidu.tbadk.util.b.Lh().ht("pic_emotion08_1.png");
                    return;
                default:
                    return;
            }
        }
    }
}
