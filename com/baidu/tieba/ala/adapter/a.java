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
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.u.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ArrayList<com.baidu.tieba.ala.data.a> eJE;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.eJE == null) {
            this.eJE = new ArrayList<>();
        } else {
            this.eJE.clear();
        }
        this.eJE.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.eJE);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eJE == null || i < 0 || i >= this.eJE.size()) {
            return null;
        }
        return this.eJE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0451a c0451a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_history_list_item_view, (ViewGroup) null);
            C0451a c0451a2 = new C0451a(view);
            view.setTag(c0451a2);
            c0451a = c0451a2;
        } else {
            c0451a = (C0451a) view.getTag();
        }
        com.baidu.tieba.ala.data.a aVar = (com.baidu.tieba.ala.data.a) getItem(i);
        if (aVar != null) {
            c0451a.a(aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    protected class C0451a {
        private LinearLayout eJF;
        private HeadImageView eJG;
        private TextView eJH;
        private RelativeLayout eJI;
        private TextView eJJ;
        private ImageView eJK;
        private TextView eJL;
        private LinearLayout eJM;
        private HeadImageView eJN;
        private TextView eJO;

        public C0451a(View view) {
            this.eJF = (LinearLayout) view.findViewById(a.g.item_challenge_history_left);
            this.eJG = (HeadImageView) view.findViewById(a.g.img_challenge_history_left);
            this.eJH = (TextView) view.findViewById(a.g.text_challenge_history_left);
            this.eJI = (RelativeLayout) view.findViewById(a.g.challenge_center_layout);
            this.eJJ = (TextView) view.findViewById(a.g.pk_history_anchor_score);
            this.eJK = (ImageView) view.findViewById(a.g.pk_history_icon);
            this.eJL = (TextView) view.findViewById(a.g.pk_history_rival_score);
            this.eJM = (LinearLayout) view.findViewById(a.g.item_challenge_history_right);
            this.eJN = (HeadImageView) view.findViewById(a.g.img_challenge_history_right);
            this.eJO = (TextView) view.findViewById(a.g.text_challenge_history_right);
            this.eJG.setIsRound(true);
            this.eJG.setAutoChangeStyle(false);
            this.eJN.setIsRound(true);
            this.eJN.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.eJG.startLoad(aVar.fec.portrait, 12, false);
                String name_show = aVar.fec.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.eJH.setText(name_show);
                this.eJN.startLoad(aVar.fed.portrait, 12, false);
                String name_show2 = aVar.fed.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.eJO.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.feb.feh);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.feb.fei);
                this.eJJ.setText(numberUniformFormatExtra);
                this.eJL.setText(numberUniformFormatExtra2);
            }
        }
    }
}
