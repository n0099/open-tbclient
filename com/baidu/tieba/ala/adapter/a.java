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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private ArrayList<com.baidu.tieba.ala.data.a> grd;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.grd == null) {
            this.grd = new ArrayList<>();
        } else {
            this.grd.clear();
        }
        this.grd.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.grd);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.grd == null || i < 0 || i >= this.grd.size()) {
            return null;
        }
        return this.grd.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0608a c0608a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_history_list_item_view, (ViewGroup) null);
            C0608a c0608a2 = new C0608a(view);
            view.setTag(c0608a2);
            c0608a = c0608a2;
        } else {
            c0608a = (C0608a) view.getTag();
        }
        com.baidu.tieba.ala.data.a aVar = (com.baidu.tieba.ala.data.a) getItem(i);
        if (aVar != null) {
            c0608a.a(aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    protected class C0608a {
        private LinearLayout gre;
        private HeadImageView grf;
        private TextView grg;
        private RelativeLayout grh;
        private TextView gri;
        private ImageView grj;
        private TextView grk;
        private LinearLayout grl;
        private HeadImageView grm;
        private TextView grn;

        public C0608a(View view) {
            this.gre = (LinearLayout) view.findViewById(a.f.item_challenge_history_left);
            this.grf = (HeadImageView) view.findViewById(a.f.img_challenge_history_left);
            this.grg = (TextView) view.findViewById(a.f.text_challenge_history_left);
            this.grh = (RelativeLayout) view.findViewById(a.f.challenge_center_layout);
            this.gri = (TextView) view.findViewById(a.f.pk_history_anchor_score);
            this.grj = (ImageView) view.findViewById(a.f.pk_history_icon);
            this.grk = (TextView) view.findViewById(a.f.pk_history_rival_score);
            this.grl = (LinearLayout) view.findViewById(a.f.item_challenge_history_right);
            this.grm = (HeadImageView) view.findViewById(a.f.img_challenge_history_right);
            this.grn = (TextView) view.findViewById(a.f.text_challenge_history_right);
            this.grf.setIsRound(true);
            this.grf.setAutoChangeStyle(false);
            this.grm.setIsRound(true);
            this.grm.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.grf.startLoad(aVar.gRS.portrait, 12, false);
                String name_show = aVar.gRS.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.grg.setText(name_show);
                this.grm.startLoad(aVar.gRT.portrait, 12, false);
                String name_show2 = aVar.gRT.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.grn.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.gRR.gRX);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.gRR.gRY);
                this.gri.setText(numberUniformFormatExtra);
                this.grk.setText(numberUniformFormatExtra2);
            }
        }
    }
}
