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
    private ArrayList<com.baidu.tieba.ala.data.a> ejp;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.ejp == null) {
            this.ejp = new ArrayList<>();
        } else {
            this.ejp.clear();
        }
        this.ejp.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.ejp);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ejp == null || i < 0 || i >= this.ejp.size()) {
            return null;
        }
        return this.ejp.get(i);
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
        private LinearLayout ejq;
        private HeadImageView ejr;
        private TextView ejs;
        private RelativeLayout ejt;
        private TextView eju;
        private ImageView ejv;
        private TextView ejw;
        private LinearLayout ejx;
        private HeadImageView ejy;
        private TextView ejz;

        public C0422a(View view) {
            this.ejq = (LinearLayout) view.findViewById(a.g.item_challenge_history_left);
            this.ejr = (HeadImageView) view.findViewById(a.g.img_challenge_history_left);
            this.ejs = (TextView) view.findViewById(a.g.text_challenge_history_left);
            this.ejt = (RelativeLayout) view.findViewById(a.g.challenge_center_layout);
            this.eju = (TextView) view.findViewById(a.g.pk_history_anchor_score);
            this.ejv = (ImageView) view.findViewById(a.g.pk_history_icon);
            this.ejw = (TextView) view.findViewById(a.g.pk_history_rival_score);
            this.ejx = (LinearLayout) view.findViewById(a.g.item_challenge_history_right);
            this.ejy = (HeadImageView) view.findViewById(a.g.img_challenge_history_right);
            this.ejz = (TextView) view.findViewById(a.g.text_challenge_history_right);
            this.ejr.setIsRound(true);
            this.ejr.setAutoChangeStyle(false);
            this.ejy.setIsRound(true);
            this.ejy.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.ejr.startLoad(aVar.eyZ.portrait, 12, false);
                String name_show = aVar.eyZ.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.ejs.setText(name_show);
                this.ejy.startLoad(aVar.eza.portrait, 12, false);
                String name_show2 = aVar.eza.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.ejz.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.eyY.eze);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.eyY.ezf);
                this.eju.setText(numberUniformFormatExtra);
                this.ejw.setText(numberUniformFormatExtra2);
            }
        }
    }
}
