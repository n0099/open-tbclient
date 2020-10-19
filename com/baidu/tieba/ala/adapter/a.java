package com.baidu.tieba.ala.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private ArrayList<com.baidu.tieba.ala.data.a> fMC;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.fMC == null) {
            this.fMC = new ArrayList<>();
        } else {
            this.fMC.clear();
        }
        this.fMC.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.fMC);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fMC == null || i < 0 || i >= this.fMC.size()) {
            return null;
        }
        return this.fMC.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0597a c0597a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_history_list_item_view, (ViewGroup) null);
            C0597a c0597a2 = new C0597a(view);
            view.setTag(c0597a2);
            c0597a = c0597a2;
        } else {
            c0597a = (C0597a) view.getTag();
        }
        com.baidu.tieba.ala.data.a aVar = (com.baidu.tieba.ala.data.a) getItem(i);
        if (aVar != null) {
            c0597a.a(aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    protected class C0597a {
        private LinearLayout fMD;
        private HeadImageView fME;
        private TextView fMF;
        private RelativeLayout fMG;
        private TextView fMH;
        private ImageView fMI;
        private TextView fMJ;
        private LinearLayout fMK;
        private HeadImageView fML;
        private TextView fMM;

        public C0597a(View view) {
            this.fMD = (LinearLayout) view.findViewById(a.g.item_challenge_history_left);
            this.fME = (HeadImageView) view.findViewById(a.g.img_challenge_history_left);
            this.fMF = (TextView) view.findViewById(a.g.text_challenge_history_left);
            this.fMG = (RelativeLayout) view.findViewById(a.g.challenge_center_layout);
            this.fMH = (TextView) view.findViewById(a.g.pk_history_anchor_score);
            this.fMI = (ImageView) view.findViewById(a.g.pk_history_icon);
            this.fMJ = (TextView) view.findViewById(a.g.pk_history_rival_score);
            this.fMK = (LinearLayout) view.findViewById(a.g.item_challenge_history_right);
            this.fML = (HeadImageView) view.findViewById(a.g.img_challenge_history_right);
            this.fMM = (TextView) view.findViewById(a.g.text_challenge_history_right);
            this.fME.setIsRound(true);
            this.fME.setAutoChangeStyle(false);
            this.fML.setIsRound(true);
            this.fML.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.fME.startLoad(aVar.gjE.portrait, 12, false);
                String name_show = aVar.gjE.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.fMF.setText(name_show);
                this.fML.startLoad(aVar.gjF.portrait, 12, false);
                String name_show2 = aVar.gjF.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.fMM.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.gjD.gjJ);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.gjD.gjK);
                this.fMH.setText(numberUniformFormatExtra);
                this.fMJ.setText(numberUniformFormatExtra2);
            }
        }
    }
}
