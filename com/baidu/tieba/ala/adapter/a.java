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
    private ArrayList<com.baidu.tieba.ala.data.a> giE;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.giE == null) {
            this.giE = new ArrayList<>();
        } else {
            this.giE.clear();
        }
        this.giE.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.giE);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.giE == null || i < 0 || i >= this.giE.size()) {
            return null;
        }
        return this.giE.get(i);
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
        private LinearLayout giF;
        private HeadImageView giG;
        private TextView giH;
        private RelativeLayout giI;
        private TextView giJ;
        private ImageView giK;
        private TextView giL;
        private LinearLayout giM;
        private HeadImageView giN;
        private TextView giO;

        public C0635a(View view) {
            this.giF = (LinearLayout) view.findViewById(a.f.item_challenge_history_left);
            this.giG = (HeadImageView) view.findViewById(a.f.img_challenge_history_left);
            this.giH = (TextView) view.findViewById(a.f.text_challenge_history_left);
            this.giI = (RelativeLayout) view.findViewById(a.f.challenge_center_layout);
            this.giJ = (TextView) view.findViewById(a.f.pk_history_anchor_score);
            this.giK = (ImageView) view.findViewById(a.f.pk_history_icon);
            this.giL = (TextView) view.findViewById(a.f.pk_history_rival_score);
            this.giM = (LinearLayout) view.findViewById(a.f.item_challenge_history_right);
            this.giN = (HeadImageView) view.findViewById(a.f.img_challenge_history_right);
            this.giO = (TextView) view.findViewById(a.f.text_challenge_history_right);
            this.giG.setIsRound(true);
            this.giG.setAutoChangeStyle(false);
            this.giN.setIsRound(true);
            this.giN.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.giG.startLoad(aVar.gId.portrait, 12, false);
                String name_show = aVar.gId.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.giH.setText(name_show);
                this.giN.startLoad(aVar.gIe.portrait, 12, false);
                String name_show2 = aVar.gIe.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.giO.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.gIc.gIi);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.gIc.gIj);
                this.giJ.setText(numberUniformFormatExtra);
                this.giL.setText(numberUniformFormatExtra2);
            }
        }
    }
}
