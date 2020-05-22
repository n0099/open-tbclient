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
    private ArrayList<com.baidu.tieba.ala.data.a> eWg;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.eWg == null) {
            this.eWg = new ArrayList<>();
        } else {
            this.eWg.clear();
        }
        this.eWg.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.eWg);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eWg == null || i < 0 || i >= this.eWg.size()) {
            return null;
        }
        return this.eWg.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0519a c0519a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_history_list_item_view, (ViewGroup) null);
            C0519a c0519a2 = new C0519a(view);
            view.setTag(c0519a2);
            c0519a = c0519a2;
        } else {
            c0519a = (C0519a) view.getTag();
        }
        com.baidu.tieba.ala.data.a aVar = (com.baidu.tieba.ala.data.a) getItem(i);
        if (aVar != null) {
            c0519a.a(aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    protected class C0519a {
        private LinearLayout eWh;
        private HeadImageView eWi;
        private TextView eWj;
        private RelativeLayout eWk;
        private TextView eWl;
        private ImageView eWm;
        private TextView eWn;
        private LinearLayout eWo;
        private HeadImageView eWp;
        private TextView eWq;

        public C0519a(View view) {
            this.eWh = (LinearLayout) view.findViewById(a.g.item_challenge_history_left);
            this.eWi = (HeadImageView) view.findViewById(a.g.img_challenge_history_left);
            this.eWj = (TextView) view.findViewById(a.g.text_challenge_history_left);
            this.eWk = (RelativeLayout) view.findViewById(a.g.challenge_center_layout);
            this.eWl = (TextView) view.findViewById(a.g.pk_history_anchor_score);
            this.eWm = (ImageView) view.findViewById(a.g.pk_history_icon);
            this.eWn = (TextView) view.findViewById(a.g.pk_history_rival_score);
            this.eWo = (LinearLayout) view.findViewById(a.g.item_challenge_history_right);
            this.eWp = (HeadImageView) view.findViewById(a.g.img_challenge_history_right);
            this.eWq = (TextView) view.findViewById(a.g.text_challenge_history_right);
            this.eWi.setIsRound(true);
            this.eWi.setAutoChangeStyle(false);
            this.eWp.setIsRound(true);
            this.eWp.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.eWi.startLoad(aVar.frM.portrait, 12, false);
                String name_show = aVar.frM.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.eWj.setText(name_show);
                this.eWp.startLoad(aVar.frN.portrait, 12, false);
                String name_show2 = aVar.frN.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.eWq.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.frL.frR);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.frL.frS);
                this.eWl.setText(numberUniformFormatExtra);
                this.eWn.setText(numberUniformFormatExtra2);
            }
        }
    }
}
