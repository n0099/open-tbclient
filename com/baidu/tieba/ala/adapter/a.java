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
    private ArrayList<com.baidu.tieba.ala.data.a> ejo;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.ejo == null) {
            this.ejo = new ArrayList<>();
        } else {
            this.ejo.clear();
        }
        this.ejo.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.ejo);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ejo == null || i < 0 || i >= this.ejo.size()) {
            return null;
        }
        return this.ejo.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0422a c0422a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_history_list_item_view, (ViewGroup) null);
            C0422a c0422a2 = new C0422a(view);
            view.setTag(c0422a2);
            c0422a = c0422a2;
        } else {
            c0422a = (C0422a) view.getTag();
        }
        com.baidu.tieba.ala.data.a aVar = (com.baidu.tieba.ala.data.a) getItem(i);
        if (aVar != null) {
            c0422a.a(aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    protected class C0422a {
        private LinearLayout ejp;
        private HeadImageView ejq;
        private TextView ejr;
        private RelativeLayout ejs;
        private TextView ejt;
        private ImageView eju;
        private TextView ejv;
        private LinearLayout ejw;
        private HeadImageView ejx;
        private TextView ejy;

        public C0422a(View view) {
            this.ejp = (LinearLayout) view.findViewById(a.g.item_challenge_history_left);
            this.ejq = (HeadImageView) view.findViewById(a.g.img_challenge_history_left);
            this.ejr = (TextView) view.findViewById(a.g.text_challenge_history_left);
            this.ejs = (RelativeLayout) view.findViewById(a.g.challenge_center_layout);
            this.ejt = (TextView) view.findViewById(a.g.pk_history_anchor_score);
            this.eju = (ImageView) view.findViewById(a.g.pk_history_icon);
            this.ejv = (TextView) view.findViewById(a.g.pk_history_rival_score);
            this.ejw = (LinearLayout) view.findViewById(a.g.item_challenge_history_right);
            this.ejx = (HeadImageView) view.findViewById(a.g.img_challenge_history_right);
            this.ejy = (TextView) view.findViewById(a.g.text_challenge_history_right);
            this.ejq.setIsRound(true);
            this.ejq.setAutoChangeStyle(false);
            this.ejx.setIsRound(true);
            this.ejx.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.ejq.startLoad(aVar.eyY.portrait, 12, false);
                String name_show = aVar.eyY.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.ejr.setText(name_show);
                this.ejx.startLoad(aVar.eyZ.portrait, 12, false);
                String name_show2 = aVar.eyZ.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.ejy.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.eyX.ezd);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.eyX.eze);
                this.ejt.setText(numberUniformFormatExtra);
                this.ejv.setText(numberUniformFormatExtra2);
            }
        }
    }
}
