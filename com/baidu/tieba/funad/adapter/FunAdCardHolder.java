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
/* loaded from: classes14.dex */
public class FunAdCardHolder extends TypeAdapter.ViewHolder {
    public Context context;
    public ViewGroup jLJ;
    public List<View> jLK;
    public List<View> jLL;
    public ImageView jLM;
    public ImageView jLN;
    public TextView jLO;
    public TextView jLP;
    public FrameLayout jLQ;
    public Button jLR;
    public ImageView jMe;
    public CardView jMf;
    public TextView jMg;
    public View jMh;
    public View jMi;
    public TextView jMj;
    public TextView jMk;
    public FunAdAgreeView jMl;
    public ImageView jMm;
    public TextView jMn;
    public ImageView jMo;
    public TextView jMp;
    public ViewGroup jMq;
    public ViewGroup jMr;
    public a.C0741a jMs;

    public FunAdCardHolder(View view) {
        super(view);
        ap(view);
    }

    private void ap(View view) {
        this.context = view.getContext();
        this.jLJ = (ViewGroup) view;
        this.jLO = (TextView) view.findViewById(R.id.fun_ad_name);
        this.jLP = (TextView) view.findViewById(R.id.fun_card_title);
        this.jLQ = (FrameLayout) view.findViewById(R.id.fun_card_content);
        this.jLR = (Button) view.findViewById(R.id.fun_ad_button);
        this.jMe = (ImageView) view.findViewById(R.id.fun_ad_feedback);
        this.jMh = view.findViewById(R.id.divider_with_reply_title);
        this.jMg = (TextView) view.findViewById(R.id.fun_ad_lable);
        this.jMf = (CardView) view.findViewById(R.id.media_bg);
        this.jMi = view.findViewById(R.id.media_mask);
        this.jLM = (ImageView) view.findViewById(R.id.top_ad_logo);
        this.jMk = (TextView) view.findViewById(R.id.top_ad_name);
        this.jMj = (TextView) view.findViewById(R.id.top_ad_justnow);
        this.jMl = (FunAdAgreeView) view.findViewById(R.id.ad_agree_view);
        this.jMo = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.jMp = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.jMm = (ImageView) view.findViewById(R.id.share_num_img);
        this.jMn = (TextView) view.findViewById(R.id.share_num);
        this.jMq = (ViewGroup) view.findViewById(R.id.layout_card_top);
        this.jMr = (ViewGroup) view.findViewById(R.id.layout_card);
        this.jLK = new ArrayList();
        this.jLK.add(this.jMq);
        this.jLK.add(this.jLQ);
        this.jLK.add(this.jLR);
        this.jLK.add(this.jMr);
        this.jLL = new ArrayList(1);
        this.jLL.add(this.jLR);
        cLD();
    }

    public void cLC() {
        if (this.jLQ != null) {
            this.jLQ.removeAllViews();
        }
    }

    public a.C0741a a(n nVar) {
        if (nVar == null) {
            return null;
        }
        this.jMs = new a.C0741a();
        this.jMs.eRU = nVar;
        this.jMs.jLJ = this.jLJ;
        this.jMs.jLK = this.jLK;
        this.jMs.jLL = this.jLL;
        this.jMs.jLM = this.jLM;
        this.jMs.jLN = this.jLN;
        this.jMs.jLO = this.jLO;
        this.jMs.jLP = this.jLP;
        this.jMs.jLQ = this.jLQ;
        this.jMs.jLR = this.jLR;
        return this.jMs;
    }

    public void cLD() {
        a(0, -1, 0, 1.0f, true, true);
    }

    private void a(int i, int i2, int i3, float f, boolean z, boolean z2) {
        D(z, z2);
    }

    private void D(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jMl.getLayoutParams();
        int i = layoutParams.width;
        float f = layoutParams.weight;
        if (z) {
            float f2 = z2 ? 1.0f : 2.0f;
            if (f != f2 || i != 0) {
                layoutParams.width = 0;
                layoutParams.weight = f2;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                this.jMl.setLayoutParams(layoutParams);
            }
        } else if (f != 0.0f || i != -2) {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
            layoutParams.leftMargin = l.getDimens(this.context, R.dimen.tbds50);
            layoutParams.rightMargin = 0;
            this.jMl.setLayoutParams(layoutParams);
        }
    }
}
