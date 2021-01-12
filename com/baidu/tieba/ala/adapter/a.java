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
    private ArrayList<com.baidu.tieba.ala.data.a> gou;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.gou == null) {
            this.gou = new ArrayList<>();
        } else {
            this.gou.clear();
        }
        this.gou.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.gou);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.gou == null || i < 0 || i >= this.gou.size()) {
            return null;
        }
        return this.gou.get(i);
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
    /* loaded from: classes10.dex */
    protected class C0609a {
        private ImageView goA;
        private TextView goB;
        private LinearLayout goC;
        private HeadImageView goD;
        private TextView goE;
        private LinearLayout gov;
        private HeadImageView gow;
        private TextView gox;
        private RelativeLayout goy;
        private TextView goz;

        public C0609a(View view) {
            this.gov = (LinearLayout) view.findViewById(a.f.item_challenge_history_left);
            this.gow = (HeadImageView) view.findViewById(a.f.img_challenge_history_left);
            this.gox = (TextView) view.findViewById(a.f.text_challenge_history_left);
            this.goy = (RelativeLayout) view.findViewById(a.f.challenge_center_layout);
            this.goz = (TextView) view.findViewById(a.f.pk_history_anchor_score);
            this.goA = (ImageView) view.findViewById(a.f.pk_history_icon);
            this.goB = (TextView) view.findViewById(a.f.pk_history_rival_score);
            this.goC = (LinearLayout) view.findViewById(a.f.item_challenge_history_right);
            this.goD = (HeadImageView) view.findViewById(a.f.img_challenge_history_right);
            this.goE = (TextView) view.findViewById(a.f.text_challenge_history_right);
            this.gow.setIsRound(true);
            this.gow.setAutoChangeStyle(false);
            this.goD.setIsRound(true);
            this.goD.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.gow.startLoad(aVar.gPj.portrait, 12, false);
                String name_show = aVar.gPj.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.gox.setText(name_show);
                this.goD.startLoad(aVar.gPk.portrait, 12, false);
                String name_show2 = aVar.gPk.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.goE.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.gPi.gPo);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.gPi.gPp);
                this.goz.setText(numberUniformFormatExtra);
                this.goB.setText(numberUniformFormatExtra2);
            }
        }
    }
}
