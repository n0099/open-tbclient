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
    private ArrayList<com.baidu.tieba.ala.data.a> eJJ;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.eJJ == null) {
            this.eJJ = new ArrayList<>();
        } else {
            this.eJJ.clear();
        }
        this.eJJ.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.eJJ);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eJJ == null || i < 0 || i >= this.eJJ.size()) {
            return null;
        }
        return this.eJJ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0472a c0472a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_history_list_item_view, (ViewGroup) null);
            C0472a c0472a2 = new C0472a(view);
            view.setTag(c0472a2);
            c0472a = c0472a2;
        } else {
            c0472a = (C0472a) view.getTag();
        }
        com.baidu.tieba.ala.data.a aVar = (com.baidu.tieba.ala.data.a) getItem(i);
        if (aVar != null) {
            c0472a.a(aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    protected class C0472a {
        private LinearLayout eJK;
        private HeadImageView eJL;
        private TextView eJM;
        private RelativeLayout eJN;
        private TextView eJO;
        private ImageView eJP;
        private TextView eJQ;
        private LinearLayout eJR;
        private HeadImageView eJS;
        private TextView eJT;

        public C0472a(View view) {
            this.eJK = (LinearLayout) view.findViewById(a.g.item_challenge_history_left);
            this.eJL = (HeadImageView) view.findViewById(a.g.img_challenge_history_left);
            this.eJM = (TextView) view.findViewById(a.g.text_challenge_history_left);
            this.eJN = (RelativeLayout) view.findViewById(a.g.challenge_center_layout);
            this.eJO = (TextView) view.findViewById(a.g.pk_history_anchor_score);
            this.eJP = (ImageView) view.findViewById(a.g.pk_history_icon);
            this.eJQ = (TextView) view.findViewById(a.g.pk_history_rival_score);
            this.eJR = (LinearLayout) view.findViewById(a.g.item_challenge_history_right);
            this.eJS = (HeadImageView) view.findViewById(a.g.img_challenge_history_right);
            this.eJT = (TextView) view.findViewById(a.g.text_challenge_history_right);
            this.eJL.setIsRound(true);
            this.eJL.setAutoChangeStyle(false);
            this.eJS.setIsRound(true);
            this.eJS.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.eJL.startLoad(aVar.feh.portrait, 12, false);
                String name_show = aVar.feh.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.eJM.setText(name_show);
                this.eJS.startLoad(aVar.fei.portrait, 12, false);
                String name_show2 = aVar.fei.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.eJT.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.feg.fem);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.feg.fen);
                this.eJO.setText(numberUniformFormatExtra);
                this.eJQ.setText(numberUniformFormatExtra2);
            }
        }
    }
}
