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
    private ArrayList<com.baidu.tieba.ala.data.a> fUT;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.fUT == null) {
            this.fUT = new ArrayList<>();
        } else {
            this.fUT.clear();
        }
        this.fUT.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.fUT);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fUT == null || i < 0 || i >= this.fUT.size()) {
            return null;
        }
        return this.fUT.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0611a c0611a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_history_list_item_view, (ViewGroup) null);
            C0611a c0611a2 = new C0611a(view);
            view.setTag(c0611a2);
            c0611a = c0611a2;
        } else {
            c0611a = (C0611a) view.getTag();
        }
        com.baidu.tieba.ala.data.a aVar = (com.baidu.tieba.ala.data.a) getItem(i);
        if (aVar != null) {
            c0611a.a(aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    protected class C0611a {
        private LinearLayout fUU;
        private HeadImageView fUV;
        private TextView fUW;
        private RelativeLayout fUX;
        private TextView fUY;
        private ImageView fUZ;
        private TextView fVa;
        private LinearLayout fVb;
        private HeadImageView fVc;
        private TextView fVd;

        public C0611a(View view) {
            this.fUU = (LinearLayout) view.findViewById(a.g.item_challenge_history_left);
            this.fUV = (HeadImageView) view.findViewById(a.g.img_challenge_history_left);
            this.fUW = (TextView) view.findViewById(a.g.text_challenge_history_left);
            this.fUX = (RelativeLayout) view.findViewById(a.g.challenge_center_layout);
            this.fUY = (TextView) view.findViewById(a.g.pk_history_anchor_score);
            this.fUZ = (ImageView) view.findViewById(a.g.pk_history_icon);
            this.fVa = (TextView) view.findViewById(a.g.pk_history_rival_score);
            this.fVb = (LinearLayout) view.findViewById(a.g.item_challenge_history_right);
            this.fVc = (HeadImageView) view.findViewById(a.g.img_challenge_history_right);
            this.fVd = (TextView) view.findViewById(a.g.text_challenge_history_right);
            this.fUV.setIsRound(true);
            this.fUV.setAutoChangeStyle(false);
            this.fVc.setIsRound(true);
            this.fVc.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.fUV.startLoad(aVar.gtK.portrait, 12, false);
                String name_show = aVar.gtK.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.fUW.setText(name_show);
                this.fVc.startLoad(aVar.gtL.portrait, 12, false);
                String name_show2 = aVar.gtL.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.fVd.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.gtJ.gtP);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.gtJ.gtQ);
                this.fUY.setText(numberUniformFormatExtra);
                this.fVa.setText(numberUniformFormatExtra2);
            }
        }
    }
}
