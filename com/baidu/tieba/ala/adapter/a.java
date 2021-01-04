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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private ArrayList<com.baidu.tieba.ala.data.a> gtb;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.gtb == null) {
            this.gtb = new ArrayList<>();
        } else {
            this.gtb.clear();
        }
        this.gtb.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.gtb);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.gtb == null || i < 0 || i >= this.gtb.size()) {
            return null;
        }
        return this.gtb.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0626a c0626a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_history_list_item_view, (ViewGroup) null);
            C0626a c0626a2 = new C0626a(view);
            view.setTag(c0626a2);
            c0626a = c0626a2;
        } else {
            c0626a = (C0626a) view.getTag();
        }
        com.baidu.tieba.ala.data.a aVar = (com.baidu.tieba.ala.data.a) getItem(i);
        if (aVar != null) {
            c0626a.a(aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    protected class C0626a {
        private LinearLayout gtc;
        private HeadImageView gtd;
        private TextView gte;
        private RelativeLayout gtf;
        private TextView gtg;
        private ImageView gth;
        private TextView gti;
        private LinearLayout gtj;
        private HeadImageView gtk;
        private TextView gtl;

        public C0626a(View view) {
            this.gtc = (LinearLayout) view.findViewById(a.f.item_challenge_history_left);
            this.gtd = (HeadImageView) view.findViewById(a.f.img_challenge_history_left);
            this.gte = (TextView) view.findViewById(a.f.text_challenge_history_left);
            this.gtf = (RelativeLayout) view.findViewById(a.f.challenge_center_layout);
            this.gtg = (TextView) view.findViewById(a.f.pk_history_anchor_score);
            this.gth = (ImageView) view.findViewById(a.f.pk_history_icon);
            this.gti = (TextView) view.findViewById(a.f.pk_history_rival_score);
            this.gtj = (LinearLayout) view.findViewById(a.f.item_challenge_history_right);
            this.gtk = (HeadImageView) view.findViewById(a.f.img_challenge_history_right);
            this.gtl = (TextView) view.findViewById(a.f.text_challenge_history_right);
            this.gtd.setIsRound(true);
            this.gtd.setAutoChangeStyle(false);
            this.gtk.setIsRound(true);
            this.gtk.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.gtd.startLoad(aVar.gTP.portrait, 12, false);
                String name_show = aVar.gTP.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.gte.setText(name_show);
                this.gtk.startLoad(aVar.gTQ.portrait, 12, false);
                String name_show2 = aVar.gTQ.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.gtl.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.gTO.gTU);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.gTO.gTV);
                this.gtg.setText(numberUniformFormatExtra);
                this.gti.setText(numberUniformFormatExtra2);
            }
        }
    }
}
