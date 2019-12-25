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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<com.baidu.tieba.ala.data.a> efd;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.efd == null) {
            this.efd = new ArrayList<>();
        } else {
            this.efd.clear();
        }
        this.efd.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.efd);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.efd == null || i < 0 || i >= this.efd.size()) {
            return null;
        }
        return this.efd.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0409a c0409a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_history_list_item_view, (ViewGroup) null);
            C0409a c0409a2 = new C0409a(view);
            view.setTag(c0409a2);
            c0409a = c0409a2;
        } else {
            c0409a = (C0409a) view.getTag();
        }
        com.baidu.tieba.ala.data.a aVar = (com.baidu.tieba.ala.data.a) getItem(i);
        if (aVar != null) {
            c0409a.a(aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    protected class C0409a {
        private LinearLayout efe;
        private HeadImageView eff;
        private TextView efg;
        private RelativeLayout efh;
        private TextView efi;
        private ImageView efj;
        private TextView efk;
        private LinearLayout efl;
        private HeadImageView efm;
        private TextView efn;

        public C0409a(View view) {
            this.efe = (LinearLayout) view.findViewById(a.g.item_challenge_history_left);
            this.eff = (HeadImageView) view.findViewById(a.g.img_challenge_history_left);
            this.efg = (TextView) view.findViewById(a.g.text_challenge_history_left);
            this.efh = (RelativeLayout) view.findViewById(a.g.challenge_center_layout);
            this.efi = (TextView) view.findViewById(a.g.pk_history_anchor_score);
            this.efj = (ImageView) view.findViewById(a.g.pk_history_icon);
            this.efk = (TextView) view.findViewById(a.g.pk_history_rival_score);
            this.efl = (LinearLayout) view.findViewById(a.g.item_challenge_history_right);
            this.efm = (HeadImageView) view.findViewById(a.g.img_challenge_history_right);
            this.efn = (TextView) view.findViewById(a.g.text_challenge_history_right);
            this.eff.setIsRound(true);
            this.eff.setAutoChangeStyle(false);
            this.efm.setIsRound(true);
            this.efm.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.eff.startLoad(aVar.etB.portrait, 12, false);
                String name_show = aVar.etB.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.efg.setText(name_show);
                this.efm.startLoad(aVar.etC.portrait, 12, false);
                String name_show2 = aVar.etC.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.efn.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.etA.etG);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.etA.etH);
                this.efi.setText(numberUniformFormatExtra);
                this.efk.setText(numberUniformFormatExtra2);
            }
        }
    }
}
