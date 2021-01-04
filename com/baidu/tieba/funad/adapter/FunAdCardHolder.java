package com.baidu.tieba.funad.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.funad.view.FunAdAgreeView;
import com.baidu.tieba.h.a;
import com.baidu.tieba.tbadkCore.data.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class FunAdCardHolder extends TypeAdapter.ViewHolder {
    public Context context;
    public ImageView jQJ;
    public CardView jQK;
    public TextView jQL;
    public View jQM;
    public View jQN;
    public TextView jQO;
    public TextView jQP;
    public FunAdAgreeView jQQ;
    public ImageView jQR;
    public TextView jQS;
    public ImageView jQT;
    public TextView jQU;
    public ViewGroup jQV;
    public ViewGroup jQW;
    public a.C0749a jQX;
    public ViewGroup jQp;
    public List<View> jQq;
    public List<View> jQr;
    public ImageView jQs;
    public ImageView jQt;
    public TextView jQu;
    public TextView jQv;
    public FrameLayout jQw;
    public Button jQx;

    public FunAdCardHolder(View view) {
        super(view);
        ap(view);
    }

    private void ap(View view) {
        this.context = view.getContext();
        this.jQp = (ViewGroup) view;
        this.jQu = (TextView) view.findViewById(R.id.fun_ad_name);
        this.jQv = (TextView) view.findViewById(R.id.fun_card_title);
        this.jQw = (FrameLayout) view.findViewById(R.id.fun_card_content);
        this.jQx = (Button) view.findViewById(R.id.fun_ad_button);
        this.jQJ = (ImageView) view.findViewById(R.id.fun_ad_feedback);
        this.jQM = view.findViewById(R.id.divider_with_reply_title);
        this.jQL = (TextView) view.findViewById(R.id.fun_ad_lable);
        this.jQK = (CardView) view.findViewById(R.id.media_bg);
        this.jQN = view.findViewById(R.id.media_mask);
        this.jQs = (ImageView) view.findViewById(R.id.top_ad_logo);
        this.jQP = (TextView) view.findViewById(R.id.top_ad_name);
        this.jQO = (TextView) view.findViewById(R.id.top_ad_justnow);
        this.jQQ = (FunAdAgreeView) view.findViewById(R.id.ad_agree_view);
        this.jQT = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.jQU = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.jQR = (ImageView) view.findViewById(R.id.share_num_img);
        this.jQS = (TextView) view.findViewById(R.id.share_num);
        this.jQV = (ViewGroup) view.findViewById(R.id.layout_card_top);
        this.jQW = (ViewGroup) view.findViewById(R.id.layout_card);
        this.jQq = new ArrayList();
        this.jQq.add(this.jQV);
        this.jQq.add(this.jQw);
        this.jQq.add(this.jQx);
        this.jQq.add(this.jQW);
        this.jQr = new ArrayList(1);
        this.jQr.add(this.jQx);
        cPu();
    }

    public void cPt() {
        if (this.jQw != null) {
            this.jQw.removeAllViews();
        }
    }

    public a.C0749a a(n nVar) {
        if (nVar == null) {
            return null;
        }
        this.jQX = new a.C0749a();
        this.jQX.eWF = nVar;
        this.jQX.jQp = this.jQp;
        this.jQX.jQq = this.jQq;
        this.jQX.jQr = this.jQr;
        this.jQX.jQs = this.jQs;
        this.jQX.jQt = this.jQt;
        this.jQX.jQu = this.jQu;
        this.jQX.jQv = this.jQv;
        this.jQX.jQw = this.jQw;
        this.jQX.jQx = this.jQx;
        return this.jQX;
    }

    public void cPu() {
        a(0, -1, 0, 1.0f, true, true);
    }

    private void a(int i, int i2, int i3, float f, boolean z, boolean z2) {
        D(z, z2);
    }

    private void D(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jQQ.getLayoutParams();
        int i = layoutParams.width;
        float f = layoutParams.weight;
        if (z) {
            float f2 = z2 ? 1.0f : 2.0f;
            if (f != f2 || i != 0) {
                layoutParams.width = 0;
                layoutParams.weight = f2;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                this.jQQ.setLayoutParams(layoutParams);
            }
        } else if (f != 0.0f || i != -2) {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
            layoutParams.leftMargin = l.getDimens(this.context, R.dimen.tbds50);
            layoutParams.rightMargin = 0;
            this.jQQ.setLayoutParams(layoutParams);
        }
    }
}
