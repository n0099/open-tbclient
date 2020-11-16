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
    private ArrayList<com.baidu.tieba.ala.data.a> gar;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.gar == null) {
            this.gar = new ArrayList<>();
        } else {
            this.gar.clear();
        }
        this.gar.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.gar);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.gar == null || i < 0 || i >= this.gar.size()) {
            return null;
        }
        return this.gar.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0623a c0623a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_history_list_item_view, (ViewGroup) null);
            C0623a c0623a2 = new C0623a(view);
            view.setTag(c0623a2);
            c0623a = c0623a2;
        } else {
            c0623a = (C0623a) view.getTag();
        }
        com.baidu.tieba.ala.data.a aVar = (com.baidu.tieba.ala.data.a) getItem(i);
        if (aVar != null) {
            c0623a.a(aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    protected class C0623a {
        private HeadImageView gaA;
        private TextView gaB;
        private LinearLayout gas;
        private HeadImageView gat;
        private TextView gau;
        private RelativeLayout gav;
        private TextView gaw;
        private ImageView gax;
        private TextView gay;
        private LinearLayout gaz;

        public C0623a(View view) {
            this.gas = (LinearLayout) view.findViewById(a.f.item_challenge_history_left);
            this.gat = (HeadImageView) view.findViewById(a.f.img_challenge_history_left);
            this.gau = (TextView) view.findViewById(a.f.text_challenge_history_left);
            this.gav = (RelativeLayout) view.findViewById(a.f.challenge_center_layout);
            this.gaw = (TextView) view.findViewById(a.f.pk_history_anchor_score);
            this.gax = (ImageView) view.findViewById(a.f.pk_history_icon);
            this.gay = (TextView) view.findViewById(a.f.pk_history_rival_score);
            this.gaz = (LinearLayout) view.findViewById(a.f.item_challenge_history_right);
            this.gaA = (HeadImageView) view.findViewById(a.f.img_challenge_history_right);
            this.gaB = (TextView) view.findViewById(a.f.text_challenge_history_right);
            this.gat.setIsRound(true);
            this.gat.setAutoChangeStyle(false);
            this.gaA.setIsRound(true);
            this.gaA.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.gat.startLoad(aVar.gzf.portrait, 12, false);
                String name_show = aVar.gzf.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.gau.setText(name_show);
                this.gaA.startLoad(aVar.gzg.portrait, 12, false);
                String name_show2 = aVar.gzg.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.gaB.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.gze.gzk);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.gze.gzl);
                this.gaw.setText(numberUniformFormatExtra);
                this.gay.setText(numberUniformFormatExtra2);
            }
        }
    }
}
