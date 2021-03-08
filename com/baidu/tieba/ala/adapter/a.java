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
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private ArrayList<com.baidu.tieba.ala.data.a> gta;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.gta == null) {
            this.gta = new ArrayList<>();
        } else {
            this.gta.clear();
        }
        this.gta.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.gta);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.gta == null || i < 0 || i >= this.gta.size()) {
            return null;
        }
        return this.gta.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0615a c0615a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_history_list_item_view, (ViewGroup) null);
            C0615a c0615a2 = new C0615a(view);
            view.setTag(c0615a2);
            c0615a = c0615a2;
        } else {
            c0615a = (C0615a) view.getTag();
        }
        com.baidu.tieba.ala.data.a aVar = (com.baidu.tieba.ala.data.a) getItem(i);
        if (aVar != null) {
            c0615a.a(aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    protected class C0615a {
        private LinearLayout gtb;
        private HeadImageView gtc;
        private TextView gtd;
        private RelativeLayout gte;
        private TextView gtf;
        private ImageView gtg;
        private TextView gth;
        private LinearLayout gti;
        private HeadImageView gtj;
        private TextView gtk;

        public C0615a(View view) {
            this.gtb = (LinearLayout) view.findViewById(a.f.item_challenge_history_left);
            this.gtc = (HeadImageView) view.findViewById(a.f.img_challenge_history_left);
            this.gtd = (TextView) view.findViewById(a.f.text_challenge_history_left);
            this.gte = (RelativeLayout) view.findViewById(a.f.challenge_center_layout);
            this.gtf = (TextView) view.findViewById(a.f.pk_history_anchor_score);
            this.gtg = (ImageView) view.findViewById(a.f.pk_history_icon);
            this.gth = (TextView) view.findViewById(a.f.pk_history_rival_score);
            this.gti = (LinearLayout) view.findViewById(a.f.item_challenge_history_right);
            this.gtj = (HeadImageView) view.findViewById(a.f.img_challenge_history_right);
            this.gtk = (TextView) view.findViewById(a.f.text_challenge_history_right);
            this.gtc.setIsRound(true);
            this.gtc.setAutoChangeStyle(false);
            this.gtj.setIsRound(true);
            this.gtj.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.gtc.startLoad(aVar.gTP.portrait, 12, false);
                String name_show = aVar.gTP.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.gtd.setText(name_show);
                this.gtj.startLoad(aVar.gTQ.portrait, 12, false);
                String name_show2 = aVar.gTQ.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.gtk.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.gTO.gTU);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.gTO.gTV);
                this.gtf.setText(numberUniformFormatExtra);
                this.gth.setText(numberUniformFormatExtra2);
            }
        }
    }
}
