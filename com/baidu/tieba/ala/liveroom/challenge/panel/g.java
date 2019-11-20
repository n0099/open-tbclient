package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.tieba.ala.liveroom.challenge.panel.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class g extends BaseAdapter {
    private List<com.baidu.live.challenge.d> eay = new ArrayList();
    private h.a eaz;
    private Context mContext;

    public g(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.eay.clear();
            this.eay.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bE(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.eay.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void aQL() {
        if (!ListUtils.isEmpty(this.eay)) {
            this.eay.clear();
            notifyDataSetChanged();
        }
    }

    public void a(h.a aVar) {
        this.eaz = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eay.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.eay.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void e(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.eay) {
                if (dVar.equals(dVar2)) {
                    dVar2.Og = dVar.Og;
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_user_item_view_layout, (ViewGroup) null);
            aVar = new a();
            aVar.eaC = (HeadImageView) view.findViewById(a.g.ala_challenge_user_header);
            aVar.eaC.setIsRound(true);
            aVar.eaC.setAutoChangeStyle(false);
            aVar.crw = (TextView) view.findViewById(a.g.ala_challenge_user_name);
            aVar.eaD = (TextView) view.findViewById(a.g.ala_challenge_user_status);
            aVar.dEX = (TextView) view.findViewById(a.g.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.eay.get(i);
        aVar.eaC.startLoad(dVar.avatar, 12, false);
        aVar.crw.setText(dVar.userName);
        aVar.dEX.setText(this.mContext.getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.Og) {
            aVar.eaD.setEnabled(true);
            aVar.eaD.setBackgroundResource(a.f.sdk_red_border_bg);
            aVar.eaD.setText(this.mContext.getString(a.i.ala_challenge_invite));
            aVar.eaD.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            aVar.eaD.setBackgroundDrawable(null);
            aVar.eaD.setText(this.mContext.getString(a.i.ala_live_challenging));
            aVar.eaD.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
        }
        aVar.eaD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.Og && g.this.eaz != null) {
                    g.this.eaz.g(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes6.dex */
    private static class a {
        public TextView crw;
        public TextView dEX;
        public HeadImageView eaC;
        public TextView eaD;

        private a() {
        }
    }
}
