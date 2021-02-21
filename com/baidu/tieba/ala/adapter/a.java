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
    private ArrayList<com.baidu.tieba.ala.data.a> grr;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.grr == null) {
            this.grr = new ArrayList<>();
        } else {
            this.grr.clear();
        }
        this.grr.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.grr);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.grr == null || i < 0 || i >= this.grr.size()) {
            return null;
        }
        return this.grr.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0609a c0609a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_history_list_item_view, (ViewGroup) null);
            C0609a c0609a2 = new C0609a(view);
            view.setTag(c0609a2);
            c0609a = c0609a2;
        } else {
            c0609a = (C0609a) view.getTag();
        }
        com.baidu.tieba.ala.data.a aVar = (com.baidu.tieba.ala.data.a) getItem(i);
        if (aVar != null) {
            c0609a.a(aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    protected class C0609a {
        private HeadImageView grA;
        private TextView grB;
        private LinearLayout grs;
        private HeadImageView grt;
        private TextView gru;
        private RelativeLayout grv;
        private TextView grw;
        private ImageView grx;
        private TextView gry;
        private LinearLayout grz;

        public C0609a(View view) {
            this.grs = (LinearLayout) view.findViewById(a.f.item_challenge_history_left);
            this.grt = (HeadImageView) view.findViewById(a.f.img_challenge_history_left);
            this.gru = (TextView) view.findViewById(a.f.text_challenge_history_left);
            this.grv = (RelativeLayout) view.findViewById(a.f.challenge_center_layout);
            this.grw = (TextView) view.findViewById(a.f.pk_history_anchor_score);
            this.grx = (ImageView) view.findViewById(a.f.pk_history_icon);
            this.gry = (TextView) view.findViewById(a.f.pk_history_rival_score);
            this.grz = (LinearLayout) view.findViewById(a.f.item_challenge_history_right);
            this.grA = (HeadImageView) view.findViewById(a.f.img_challenge_history_right);
            this.grB = (TextView) view.findViewById(a.f.text_challenge_history_right);
            this.grt.setIsRound(true);
            this.grt.setAutoChangeStyle(false);
            this.grA.setIsRound(true);
            this.grA.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.grt.startLoad(aVar.gSg.portrait, 12, false);
                String name_show = aVar.gSg.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.gru.setText(name_show);
                this.grA.startLoad(aVar.gSh.portrait, 12, false);
                String name_show2 = aVar.gSh.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.grB.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.gSf.gSl);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.gSf.gSm);
                this.grw.setText(numberUniformFormatExtra);
                this.gry.setText(numberUniformFormatExtra2);
            }
        }
    }
}
