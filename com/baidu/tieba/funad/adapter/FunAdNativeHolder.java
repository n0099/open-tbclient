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
/* loaded from: classes5.dex */
public class FunAdNativeHolder extends TypeAdapter.ViewHolder {
    public ViewGroup jSJ;
    public List<View> jSK;
    public List<View> jSL;
    public ImageView jSM;
    public ImageView jSN;
    public TextView jSO;
    public TextView jSP;
    public FrameLayout jSQ;
    public Button jSR;
    public ImageView jTg;
    public CardView jTh;
    public TextView jTi;
    public View jTj;
    public View jTk;
    public a.C0742a jTx;

    public FunAdNativeHolder(View view) {
        super(view);
        am(view);
    }

    private void am(View view) {
        this.jSJ = (ViewGroup) view;
        this.jSO = (TextView) view.findViewById(R.id.fun_ad_name);
        this.jSP = (TextView) view.findViewById(R.id.fun_card_title);
        this.jSQ = (FrameLayout) view.findViewById(R.id.fun_card_content);
        this.jSR = (Button) view.findViewById(R.id.fun_ad_button);
        this.jTg = (ImageView) view.findViewById(R.id.fun_ad_feedback);
        this.jTj = view.findViewById(R.id.divider_with_reply_title);
        this.jTi = (TextView) view.findViewById(R.id.fun_ad_lable);
        this.jTh = (CardView) view.findViewById(R.id.media_bg);
        this.jTk = view.findViewById(R.id.media_mask);
        this.jSK = new ArrayList(6);
        this.jSK.add(this.jSJ);
        this.jSK.add(this.jTh);
        this.jSK.add(this.jSQ);
        this.jSK.add(this.jSR);
        this.jSK.add(this.jTk);
        this.jSK.add((RelativeLayout) view.findViewById(R.id.fun_card_layout));
        this.jSL = new ArrayList(1);
        this.jSL.add(this.jSR);
    }

    public void b(n nVar) {
        if (this.jTx == null) {
            this.jTx = new a.C0742a();
            this.jTx.eUi = nVar;
            this.jTx.jSJ = this.jSJ;
            this.jTx.jSK = this.jSK;
            this.jTx.jSL = this.jSL;
            this.jTx.jSM = this.jSM;
            this.jTx.jSN = this.jSN;
            this.jTx.jSO = this.jSO;
            this.jTx.jSP = this.jSP;
            this.jTx.jSQ = this.jSQ;
            this.jTx.jSR = this.jSR;
        }
    }
}
