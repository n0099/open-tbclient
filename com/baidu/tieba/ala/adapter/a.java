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
    private ArrayList<com.baidu.tieba.ala.data.a> eWr;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.eWr == null) {
            this.eWr = new ArrayList<>();
        } else {
            this.eWr.clear();
        }
        this.eWr.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.eWr);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eWr == null || i < 0 || i >= this.eWr.size()) {
            return null;
        }
        return this.eWr.get(i);
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
        private HeadImageView eWA;
        private TextView eWB;
        private LinearLayout eWs;
        private HeadImageView eWt;
        private TextView eWu;
        private RelativeLayout eWv;
        private TextView eWw;
        private ImageView eWx;
        private TextView eWy;
        private LinearLayout eWz;

        public C0519a(View view) {
            this.eWs = (LinearLayout) view.findViewById(a.g.item_challenge_history_left);
            this.eWt = (HeadImageView) view.findViewById(a.g.img_challenge_history_left);
            this.eWu = (TextView) view.findViewById(a.g.text_challenge_history_left);
            this.eWv = (RelativeLayout) view.findViewById(a.g.challenge_center_layout);
            this.eWw = (TextView) view.findViewById(a.g.pk_history_anchor_score);
            this.eWx = (ImageView) view.findViewById(a.g.pk_history_icon);
            this.eWy = (TextView) view.findViewById(a.g.pk_history_rival_score);
            this.eWz = (LinearLayout) view.findViewById(a.g.item_challenge_history_right);
            this.eWA = (HeadImageView) view.findViewById(a.g.img_challenge_history_right);
            this.eWB = (TextView) view.findViewById(a.g.text_challenge_history_right);
            this.eWt.setIsRound(true);
            this.eWt.setAutoChangeStyle(false);
            this.eWA.setIsRound(true);
            this.eWA.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.eWt.startLoad(aVar.frX.portrait, 12, false);
                String name_show = aVar.frX.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.eWu.setText(name_show);
                this.eWA.startLoad(aVar.frY.portrait, 12, false);
                String name_show2 = aVar.frY.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.eWB.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.frW.fsc);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.frW.fsd);
                this.eWw.setText(numberUniformFormatExtra);
                this.eWy.setText(numberUniformFormatExtra2);
            }
        }
    }
}
