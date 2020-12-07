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
    private ArrayList<com.baidu.tieba.ala.data.a> giC;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.giC == null) {
            this.giC = new ArrayList<>();
        } else {
            this.giC.clear();
        }
        this.giC.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.giC);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.giC == null || i < 0 || i >= this.giC.size()) {
            return null;
        }
        return this.giC.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0635a c0635a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_history_list_item_view, (ViewGroup) null);
            C0635a c0635a2 = new C0635a(view);
            view.setTag(c0635a2);
            c0635a = c0635a2;
        } else {
            c0635a = (C0635a) view.getTag();
        }
        com.baidu.tieba.ala.data.a aVar = (com.baidu.tieba.ala.data.a) getItem(i);
        if (aVar != null) {
            c0635a.a(aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    protected class C0635a {
        private LinearLayout giD;
        private HeadImageView giE;
        private TextView giF;
        private RelativeLayout giG;
        private TextView giH;
        private ImageView giI;
        private TextView giJ;
        private LinearLayout giK;
        private HeadImageView giL;
        private TextView giM;

        public C0635a(View view) {
            this.giD = (LinearLayout) view.findViewById(a.f.item_challenge_history_left);
            this.giE = (HeadImageView) view.findViewById(a.f.img_challenge_history_left);
            this.giF = (TextView) view.findViewById(a.f.text_challenge_history_left);
            this.giG = (RelativeLayout) view.findViewById(a.f.challenge_center_layout);
            this.giH = (TextView) view.findViewById(a.f.pk_history_anchor_score);
            this.giI = (ImageView) view.findViewById(a.f.pk_history_icon);
            this.giJ = (TextView) view.findViewById(a.f.pk_history_rival_score);
            this.giK = (LinearLayout) view.findViewById(a.f.item_challenge_history_right);
            this.giL = (HeadImageView) view.findViewById(a.f.img_challenge_history_right);
            this.giM = (TextView) view.findViewById(a.f.text_challenge_history_right);
            this.giE.setIsRound(true);
            this.giE.setAutoChangeStyle(false);
            this.giL.setIsRound(true);
            this.giL.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.giE.startLoad(aVar.gIb.portrait, 12, false);
                String name_show = aVar.gIb.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.giF.setText(name_show);
                this.giL.startLoad(aVar.gIc.portrait, 12, false);
                String name_show2 = aVar.gIc.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.giM.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.gIa.gIg);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.gIa.gIh);
                this.giH.setText(numberUniformFormatExtra);
                this.giJ.setText(numberUniformFormatExtra2);
            }
        }
    }
}
