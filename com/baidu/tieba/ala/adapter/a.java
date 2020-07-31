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
    private ArrayList<com.baidu.tieba.ala.data.a> flH;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.flH == null) {
            this.flH = new ArrayList<>();
        } else {
            this.flH.clear();
        }
        this.flH.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.flH);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.flH == null || i < 0 || i >= this.flH.size()) {
            return null;
        }
        return this.flH.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0538a c0538a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_history_list_item_view, (ViewGroup) null);
            C0538a c0538a2 = new C0538a(view);
            view.setTag(c0538a2);
            c0538a = c0538a2;
        } else {
            c0538a = (C0538a) view.getTag();
        }
        com.baidu.tieba.ala.data.a aVar = (com.baidu.tieba.ala.data.a) getItem(i);
        if (aVar != null) {
            c0538a.a(aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    protected class C0538a {
        private LinearLayout flI;
        private HeadImageView flJ;
        private TextView flK;
        private RelativeLayout flL;
        private TextView flM;
        private ImageView flN;
        private TextView flO;
        private LinearLayout flP;
        private HeadImageView flQ;
        private TextView flR;

        public C0538a(View view) {
            this.flI = (LinearLayout) view.findViewById(a.g.item_challenge_history_left);
            this.flJ = (HeadImageView) view.findViewById(a.g.img_challenge_history_left);
            this.flK = (TextView) view.findViewById(a.g.text_challenge_history_left);
            this.flL = (RelativeLayout) view.findViewById(a.g.challenge_center_layout);
            this.flM = (TextView) view.findViewById(a.g.pk_history_anchor_score);
            this.flN = (ImageView) view.findViewById(a.g.pk_history_icon);
            this.flO = (TextView) view.findViewById(a.g.pk_history_rival_score);
            this.flP = (LinearLayout) view.findViewById(a.g.item_challenge_history_right);
            this.flQ = (HeadImageView) view.findViewById(a.g.img_challenge_history_right);
            this.flR = (TextView) view.findViewById(a.g.text_challenge_history_right);
            this.flJ.setIsRound(true);
            this.flJ.setAutoChangeStyle(false);
            this.flQ.setIsRound(true);
            this.flQ.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.flJ.startLoad(aVar.fIB.portrait, 12, false);
                String name_show = aVar.fIB.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.flK.setText(name_show);
                this.flQ.startLoad(aVar.fIC.portrait, 12, false);
                String name_show2 = aVar.fIC.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.flR.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.fIA.fIG);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.fIA.fIH);
                this.flM.setText(numberUniformFormatExtra);
                this.flO.setText(numberUniformFormatExtra2);
            }
        }
    }
}
