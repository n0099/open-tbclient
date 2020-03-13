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
    private ArrayList<com.baidu.tieba.ala.data.a> ejC;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.ejC == null) {
            this.ejC = new ArrayList<>();
        } else {
            this.ejC.clear();
        }
        this.ejC.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.ejC);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ejC == null || i < 0 || i >= this.ejC.size()) {
            return null;
        }
        return this.ejC.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0422a c0422a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_history_list_item_view, (ViewGroup) null);
            C0422a c0422a2 = new C0422a(view);
            view.setTag(c0422a2);
            c0422a = c0422a2;
        } else {
            c0422a = (C0422a) view.getTag();
        }
        com.baidu.tieba.ala.data.a aVar = (com.baidu.tieba.ala.data.a) getItem(i);
        if (aVar != null) {
            c0422a.a(aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    protected class C0422a {
        private LinearLayout ejD;
        private HeadImageView ejE;
        private TextView ejF;
        private RelativeLayout ejG;
        private TextView ejH;
        private ImageView ejI;
        private TextView ejJ;
        private LinearLayout ejK;
        private HeadImageView ejL;
        private TextView ejM;

        public C0422a(View view) {
            this.ejD = (LinearLayout) view.findViewById(a.g.item_challenge_history_left);
            this.ejE = (HeadImageView) view.findViewById(a.g.img_challenge_history_left);
            this.ejF = (TextView) view.findViewById(a.g.text_challenge_history_left);
            this.ejG = (RelativeLayout) view.findViewById(a.g.challenge_center_layout);
            this.ejH = (TextView) view.findViewById(a.g.pk_history_anchor_score);
            this.ejI = (ImageView) view.findViewById(a.g.pk_history_icon);
            this.ejJ = (TextView) view.findViewById(a.g.pk_history_rival_score);
            this.ejK = (LinearLayout) view.findViewById(a.g.item_challenge_history_right);
            this.ejL = (HeadImageView) view.findViewById(a.g.img_challenge_history_right);
            this.ejM = (TextView) view.findViewById(a.g.text_challenge_history_right);
            this.ejE.setIsRound(true);
            this.ejE.setAutoChangeStyle(false);
            this.ejL.setIsRound(true);
            this.ejL.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.ejE.startLoad(aVar.ezm.portrait, 12, false);
                String name_show = aVar.ezm.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.ejF.setText(name_show);
                this.ejL.startLoad(aVar.ezn.portrait, 12, false);
                String name_show2 = aVar.ezn.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.ejM.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.ezl.ezr);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.ezl.ezs);
                this.ejH.setText(numberUniformFormatExtra);
                this.ejJ.setText(numberUniformFormatExtra2);
            }
        }
    }
}
