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
    public ViewGroup jSX;
    public List<View> jSY;
    public List<View> jSZ;
    public a.C0743a jTL;
    public ImageView jTa;
    public ImageView jTb;
    public TextView jTc;
    public TextView jTd;
    public FrameLayout jTe;
    public Button jTf;
    public ImageView jTu;
    public CardView jTv;
    public TextView jTw;
    public View jTx;
    public View jTy;

    public FunAdNativeHolder(View view) {
        super(view);
        am(view);
    }

    private void am(View view) {
        this.jSX = (ViewGroup) view;
        this.jTc = (TextView) view.findViewById(R.id.fun_ad_name);
        this.jTd = (TextView) view.findViewById(R.id.fun_card_title);
        this.jTe = (FrameLayout) view.findViewById(R.id.fun_card_content);
        this.jTf = (Button) view.findViewById(R.id.fun_ad_button);
        this.jTu = (ImageView) view.findViewById(R.id.fun_ad_feedback);
        this.jTx = view.findViewById(R.id.divider_with_reply_title);
        this.jTw = (TextView) view.findViewById(R.id.fun_ad_lable);
        this.jTv = (CardView) view.findViewById(R.id.media_bg);
        this.jTy = view.findViewById(R.id.media_mask);
        this.jSY = new ArrayList(6);
        this.jSY.add(this.jSX);
        this.jSY.add(this.jTv);
        this.jSY.add(this.jTe);
        this.jSY.add(this.jTf);
        this.jSY.add(this.jTy);
        this.jSY.add((RelativeLayout) view.findViewById(R.id.fun_card_layout));
        this.jSZ = new ArrayList(1);
        this.jSZ.add(this.jTf);
    }

    public void b(n nVar) {
        if (this.jTL == null) {
            this.jTL = new a.C0743a();
            this.jTL.eUi = nVar;
            this.jTL.jSX = this.jSX;
            this.jTL.jSY = this.jSY;
            this.jTL.jSZ = this.jSZ;
            this.jTL.jTa = this.jTa;
            this.jTL.jTb = this.jTb;
            this.jTL.jTc = this.jTc;
            this.jTL.jTd = this.jTd;
            this.jTL.jTe = this.jTe;
            this.jTL.jTf = this.jTf;
        }
    }
}
