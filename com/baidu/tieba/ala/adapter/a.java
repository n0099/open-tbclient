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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private ArrayList<com.baidu.tieba.ala.data.a> fxh;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.fxh == null) {
            this.fxh = new ArrayList<>();
        } else {
            this.fxh.clear();
        }
        this.fxh.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.fxh);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fxh == null || i < 0 || i >= this.fxh.size()) {
            return null;
        }
        return this.fxh.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0584a c0584a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_history_list_item_view, (ViewGroup) null);
            C0584a c0584a2 = new C0584a(view);
            view.setTag(c0584a2);
            c0584a = c0584a2;
        } else {
            c0584a = (C0584a) view.getTag();
        }
        com.baidu.tieba.ala.data.a aVar = (com.baidu.tieba.ala.data.a) getItem(i);
        if (aVar != null) {
            c0584a.a(aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    protected class C0584a {
        private LinearLayout fxi;
        private HeadImageView fxj;
        private TextView fxk;
        private RelativeLayout fxl;
        private TextView fxm;
        private ImageView fxn;
        private TextView fxo;
        private LinearLayout fxp;
        private HeadImageView fxq;
        private TextView fxr;

        public C0584a(View view) {
            this.fxi = (LinearLayout) view.findViewById(a.g.item_challenge_history_left);
            this.fxj = (HeadImageView) view.findViewById(a.g.img_challenge_history_left);
            this.fxk = (TextView) view.findViewById(a.g.text_challenge_history_left);
            this.fxl = (RelativeLayout) view.findViewById(a.g.challenge_center_layout);
            this.fxm = (TextView) view.findViewById(a.g.pk_history_anchor_score);
            this.fxn = (ImageView) view.findViewById(a.g.pk_history_icon);
            this.fxo = (TextView) view.findViewById(a.g.pk_history_rival_score);
            this.fxp = (LinearLayout) view.findViewById(a.g.item_challenge_history_right);
            this.fxq = (HeadImageView) view.findViewById(a.g.img_challenge_history_right);
            this.fxr = (TextView) view.findViewById(a.g.text_challenge_history_right);
            this.fxj.setIsRound(true);
            this.fxj.setAutoChangeStyle(false);
            this.fxq.setIsRound(true);
            this.fxq.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.fxj.startLoad(aVar.fTW.portrait, 12, false);
                String name_show = aVar.fTW.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.fxk.setText(name_show);
                this.fxq.startLoad(aVar.fTX.portrait, 12, false);
                String name_show2 = aVar.fTX.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.fxr.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.fTV.fUb);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.fTV.fUc);
                this.fxm.setText(numberUniformFormatExtra);
                this.fxo.setText(numberUniformFormatExtra2);
            }
        }
    }
}
