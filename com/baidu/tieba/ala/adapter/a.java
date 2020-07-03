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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ArrayList<com.baidu.tieba.ala.data.a> fgC;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.fgC == null) {
            this.fgC = new ArrayList<>();
        } else {
            this.fgC.clear();
        }
        this.fgC.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.fgC);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fgC == null || i < 0 || i >= this.fgC.size()) {
            return null;
        }
        return this.fgC.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0527a c0527a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_history_list_item_view, (ViewGroup) null);
            C0527a c0527a2 = new C0527a(view);
            view.setTag(c0527a2);
            c0527a = c0527a2;
        } else {
            c0527a = (C0527a) view.getTag();
        }
        com.baidu.tieba.ala.data.a aVar = (com.baidu.tieba.ala.data.a) getItem(i);
        if (aVar != null) {
            c0527a.a(aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    protected class C0527a {
        private LinearLayout fgD;
        private HeadImageView fgE;
        private TextView fgF;
        private RelativeLayout fgG;
        private TextView fgH;
        private ImageView fgI;
        private TextView fgJ;
        private LinearLayout fgK;
        private HeadImageView fgL;
        private TextView fgM;

        public C0527a(View view) {
            this.fgD = (LinearLayout) view.findViewById(a.g.item_challenge_history_left);
            this.fgE = (HeadImageView) view.findViewById(a.g.img_challenge_history_left);
            this.fgF = (TextView) view.findViewById(a.g.text_challenge_history_left);
            this.fgG = (RelativeLayout) view.findViewById(a.g.challenge_center_layout);
            this.fgH = (TextView) view.findViewById(a.g.pk_history_anchor_score);
            this.fgI = (ImageView) view.findViewById(a.g.pk_history_icon);
            this.fgJ = (TextView) view.findViewById(a.g.pk_history_rival_score);
            this.fgK = (LinearLayout) view.findViewById(a.g.item_challenge_history_right);
            this.fgL = (HeadImageView) view.findViewById(a.g.img_challenge_history_right);
            this.fgM = (TextView) view.findViewById(a.g.text_challenge_history_right);
            this.fgE.setIsRound(true);
            this.fgE.setAutoChangeStyle(false);
            this.fgL.setIsRound(true);
            this.fgL.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.fgE.startLoad(aVar.fDi.portrait, 12, false);
                String name_show = aVar.fDi.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.fgF.setText(name_show);
                this.fgL.startLoad(aVar.fDj.portrait, 12, false);
                String name_show2 = aVar.fDj.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.fgM.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.fDh.fDn);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.fDh.fDo);
                this.fgH.setText(numberUniformFormatExtra);
                this.fgJ.setText(numberUniformFormatExtra2);
            }
        }
    }
}
