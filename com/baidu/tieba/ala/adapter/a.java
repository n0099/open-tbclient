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
    private ArrayList<com.baidu.tieba.ala.data.a> ejS;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.ejS == null) {
            this.ejS = new ArrayList<>();
        } else {
            this.ejS.clear();
        }
        this.ejS.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.ejS);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ejS == null || i < 0 || i >= this.ejS.size()) {
            return null;
        }
        return this.ejS.get(i);
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
        private LinearLayout ejT;
        private HeadImageView ejU;
        private TextView ejV;
        private RelativeLayout ejW;
        private TextView ejX;
        private ImageView ejY;
        private TextView ejZ;
        private LinearLayout eka;
        private HeadImageView ekb;
        private TextView ekc;

        public C0422a(View view) {
            this.ejT = (LinearLayout) view.findViewById(a.g.item_challenge_history_left);
            this.ejU = (HeadImageView) view.findViewById(a.g.img_challenge_history_left);
            this.ejV = (TextView) view.findViewById(a.g.text_challenge_history_left);
            this.ejW = (RelativeLayout) view.findViewById(a.g.challenge_center_layout);
            this.ejX = (TextView) view.findViewById(a.g.pk_history_anchor_score);
            this.ejY = (ImageView) view.findViewById(a.g.pk_history_icon);
            this.ejZ = (TextView) view.findViewById(a.g.pk_history_rival_score);
            this.eka = (LinearLayout) view.findViewById(a.g.item_challenge_history_right);
            this.ekb = (HeadImageView) view.findViewById(a.g.img_challenge_history_right);
            this.ekc = (TextView) view.findViewById(a.g.text_challenge_history_right);
            this.ejU.setIsRound(true);
            this.ejU.setAutoChangeStyle(false);
            this.ekb.setIsRound(true);
            this.ekb.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.ejU.startLoad(aVar.ezI.portrait, 12, false);
                String name_show = aVar.ezI.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.ejV.setText(name_show);
                this.ekb.startLoad(aVar.ezJ.portrait, 12, false);
                String name_show2 = aVar.ezJ.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.ekc.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.ezH.ezN);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.ezH.ezO);
                this.ejX.setText(numberUniformFormatExtra);
                this.ejZ.setText(numberUniformFormatExtra2);
            }
        }
    }
}
