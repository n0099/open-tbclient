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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<com.baidu.tieba.ala.data.a> efl;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.efl == null) {
            this.efl = new ArrayList<>();
        } else {
            this.efl.clear();
        }
        this.efl.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.efl);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.efl == null || i < 0 || i >= this.efl.size()) {
            return null;
        }
        return this.efl.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0411a c0411a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_history_list_item_view, (ViewGroup) null);
            C0411a c0411a2 = new C0411a(view);
            view.setTag(c0411a2);
            c0411a = c0411a2;
        } else {
            c0411a = (C0411a) view.getTag();
        }
        com.baidu.tieba.ala.data.a aVar = (com.baidu.tieba.ala.data.a) getItem(i);
        if (aVar != null) {
            c0411a.a(aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    protected class C0411a {
        private LinearLayout efm;
        private HeadImageView efn;
        private TextView efo;
        private RelativeLayout efp;
        private TextView efq;
        private ImageView efr;
        private TextView efs;
        private LinearLayout eft;
        private HeadImageView efu;
        private TextView efv;

        public C0411a(View view) {
            this.efm = (LinearLayout) view.findViewById(a.g.item_challenge_history_left);
            this.efn = (HeadImageView) view.findViewById(a.g.img_challenge_history_left);
            this.efo = (TextView) view.findViewById(a.g.text_challenge_history_left);
            this.efp = (RelativeLayout) view.findViewById(a.g.challenge_center_layout);
            this.efq = (TextView) view.findViewById(a.g.pk_history_anchor_score);
            this.efr = (ImageView) view.findViewById(a.g.pk_history_icon);
            this.efs = (TextView) view.findViewById(a.g.pk_history_rival_score);
            this.eft = (LinearLayout) view.findViewById(a.g.item_challenge_history_right);
            this.efu = (HeadImageView) view.findViewById(a.g.img_challenge_history_right);
            this.efv = (TextView) view.findViewById(a.g.text_challenge_history_right);
            this.efn.setIsRound(true);
            this.efn.setAutoChangeStyle(false);
            this.efu.setIsRound(true);
            this.efu.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.efn.startLoad(aVar.euM.portrait, 12, false);
                String name_show = aVar.euM.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.efo.setText(name_show);
                this.efu.startLoad(aVar.euN.portrait, 12, false);
                String name_show2 = aVar.euN.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.efv.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.euL.euR);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.euL.euS);
                this.efq.setText(numberUniformFormatExtra);
                this.efs.setText(numberUniformFormatExtra2);
            }
        }
    }
}
