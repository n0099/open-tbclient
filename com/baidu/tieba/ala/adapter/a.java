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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private ArrayList<com.baidu.tieba.ala.data.a> dub;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<com.baidu.tieba.ala.data.a> arrayList) {
        if (this.dub == null) {
            this.dub = new ArrayList<>();
        } else {
            this.dub.clear();
        }
        this.dub.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.dub);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dub == null || i < 0 || i >= this.dub.size()) {
            return null;
        }
        return this.dub.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0329a c0329a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_history_list_item_view, (ViewGroup) null);
            C0329a c0329a2 = new C0329a(view);
            view.setTag(c0329a2);
            c0329a = c0329a2;
        } else {
            c0329a = (C0329a) view.getTag();
        }
        com.baidu.tieba.ala.data.a aVar = (com.baidu.tieba.ala.data.a) getItem(i);
        if (aVar != null) {
            c0329a.a(aVar);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    protected class C0329a {
        private LinearLayout duc;
        private HeadImageView dud;
        private TextView due;
        private RelativeLayout duf;
        private TextView dug;
        private ImageView duh;
        private TextView dui;
        private LinearLayout duj;
        private HeadImageView duk;
        private TextView dul;

        public C0329a(View view) {
            this.duc = (LinearLayout) view.findViewById(a.g.item_challenge_history_left);
            this.dud = (HeadImageView) view.findViewById(a.g.img_challenge_history_left);
            this.due = (TextView) view.findViewById(a.g.text_challenge_history_left);
            this.duf = (RelativeLayout) view.findViewById(a.g.challenge_center_layout);
            this.dug = (TextView) view.findViewById(a.g.pk_history_anchor_score);
            this.duh = (ImageView) view.findViewById(a.g.pk_history_icon);
            this.dui = (TextView) view.findViewById(a.g.pk_history_rival_score);
            this.duj = (LinearLayout) view.findViewById(a.g.item_challenge_history_right);
            this.duk = (HeadImageView) view.findViewById(a.g.img_challenge_history_right);
            this.dul = (TextView) view.findViewById(a.g.text_challenge_history_right);
            this.dud.setIsRound(true);
            this.dud.setAutoChangeStyle(false);
            this.duk.setIsRound(true);
            this.duk.setAutoChangeStyle(false);
        }

        public void a(com.baidu.tieba.ala.data.a aVar) {
            if (aVar != null) {
                this.dud.startLoad(aVar.dFX.portrait, 12, false);
                String name_show = aVar.dFX.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show) > 8) {
                    name_show = TextHelper.subStringWithEmoji(name_show, 8) + StringHelper.STRING_MORE;
                }
                this.due.setText(name_show);
                this.duk.startLoad(aVar.dFY.portrait, 12, false);
                String name_show2 = aVar.dFY.getName_show();
                if (TextHelper.getTextLengthWithEmoji(name_show2) > 8) {
                    name_show2 = TextHelper.subStringWithEmoji(name_show2, 8) + StringHelper.STRING_MORE;
                }
                this.dul.setText(name_show2);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(aVar.dFW.dGc);
                String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(aVar.dFW.dGd);
                this.dug.setText(numberUniformFormatExtra);
                this.dui.setText(numberUniformFormatExtra2);
            }
        }
    }
}
