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
/* loaded from: classes14.dex */
public class FunAdNativeHolder extends TypeAdapter.ViewHolder {
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
    public a.C0741a jMs;

    public FunAdNativeHolder(View view) {
        super(view);
        ap(view);
    }

    private void ap(View view) {
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
        this.jLK = new ArrayList(6);
        this.jLK.add(this.jLJ);
        this.jLK.add(this.jMf);
        this.jLK.add(this.jLQ);
        this.jLK.add(this.jLR);
        this.jLK.add(this.jMi);
        this.jLK.add((RelativeLayout) view.findViewById(R.id.fun_card_layout));
        this.jLL = new ArrayList(1);
        this.jLL.add(this.jLR);
    }

    public void b(n nVar) {
        if (this.jMs == null) {
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
        }
    }
}
