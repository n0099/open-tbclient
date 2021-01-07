package com.baidu.tieba.funad.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.h.a;
import com.baidu.tieba.tbadkCore.data.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class FunAdNativeHolder extends TypeAdapter.ViewHolder {
    public ImageView jQJ;
    public CardView jQK;
    public TextView jQL;
    public View jQM;
    public View jQN;
    public a.C0758a jQX;
    public ViewGroup jQp;
    public List<View> jQq;
    public List<View> jQr;
    public ImageView jQs;
    public ImageView jQt;
    public TextView jQu;
    public TextView jQv;
    public FrameLayout jQw;
    public Button jQx;

    public FunAdNativeHolder(View view) {
        super(view);
        ap(view);
    }

    private void ap(View view) {
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
        this.jQq = new ArrayList(6);
        this.jQq.add(this.jQp);
        this.jQq.add(this.jQK);
        this.jQq.add(this.jQw);
        this.jQq.add(this.jQx);
        this.jQq.add(this.jQN);
        this.jQq.add((RelativeLayout) view.findViewById(R.id.fun_card_layout));
        this.jQr = new ArrayList(1);
        this.jQr.add(this.jQx);
    }

    public void b(n nVar) {
        if (this.jQX == null) {
            this.jQX = new a.C0758a();
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
        }
    }
}
