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
    private ArrayList<com.baidu.tieba.ala.data.a> fAt;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.fAt == null) {
            this.fAt = new ArrayList<>();
        } else {
            this.fAt.clear();
        }
        this.fAt.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.fAt);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fAt == null || i < 0 || i >= this.fAt.size()) {
            return null;
        }
        return this.fAt.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0580a c0580a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_history_list_item_view, (ViewGroup) null);
            C0580a c0580a2 = new C0580a(view);
            view.setTag(c0580a2);
            c0580a = c0580a2;
        } else {
            c0580a = (C0580a) view.getTag();
        }
        com.baidu.tieba.ala.data.a aVar = (com.baidu.tieba.ala.data.a) getItem(i);
        if (aVar != null) {
            c0580a.a(aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    protected class C0580a {
        private TextView fAA;
        private LinearLayout fAB;
        private HeadImageView fAC;
        private TextView fAD;
        private LinearLayout fAu;
        private HeadImageView fAv;
        private TextView fAw;
        private RelativeLayout fAx;
        private TextView fAy;
        private ImageView fAz;

        public C0580a(View view) {
            this.fAu = (LinearLayout) view.findViewById(a.g.item_challenge_history_left);
            this.fAv = (HeadImageView) view.findViewById(a.g.img_challenge_history_left);
            this.fAw = (TextView) view.findViewById(a.g.text_challenge_history_left);
            this.fAx = (RelativeLayout) view.findViewById(a.g.challenge_center_layout);
            this.fAy = (TextView) view.findViewById(a.g.pk_history_anchor_score);
            this.fAz = (ImageView) view.findViewById(a.g.pk_history_icon);
            this.fAA = (TextView) view.findViewById(a.g.pk_history_rival_score);
            this.fAB = (LinearLayout) view.findViewById(a.g.item_challenge_history_right);
            this.fAC = (HeadImageView) view.findViewById(a.g.img_challenge_history_right);
            this.fAD = (TextView) view.findViewById(a.g.text_challenge_history_right);
            this.fAv.setIsRound(true);
            this.fAv.setAutoChangeStyle(false);
            this.fAC.setIsRound(true);
            this.fAC.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.fAv.startLoad(aVar.fXl.portrait, 12, false);
                String name_show = aVar.fXl.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.fAw.setText(name_show);
                this.fAC.startLoad(aVar.fXm.portrait, 12, false);
                String name_show2 = aVar.fXm.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.fAD.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.fXk.fXq);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.fXk.fXr);
                this.fAy.setText(numberUniformFormatExtra);
                this.fAA.setText(numberUniformFormatExtra2);
            }
        }
    }
}
