package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.tieba.ala.liveroom.challenge.panel.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g extends BaseAdapter {
    private List<com.baidu.live.challenge.d> eQu = new ArrayList();
    private h.a eQv;
    private Context mContext;

    public g(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.eQu.clear();
            this.eQu.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bD(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.eQu.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bip() {
        if (!ListUtils.isEmpty(this.eQu)) {
            this.eQu.clear();
            notifyDataSetChanged();
        }
    }

    public void a(h.a aVar) {
        this.eQv = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eQu.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.eQu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void e(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.eQu) {
                if (dVar.equals(dVar2)) {
                    dVar2.Ve = dVar.Ve;
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
            aVar.eQy = (HeadImageView) view.findViewById(a.g.ala_challenge_user_header);
            aVar.eQy.setIsRound(true);
            aVar.eQy.setAutoChangeStyle(false);
            aVar.bXt = (TextView) view.findViewById(a.g.ala_challenge_user_name);
            aVar.eQz = (TextView) view.findViewById(a.g.ala_challenge_user_status);
            aVar.era = (TextView) view.findViewById(a.g.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.eQu.get(i);
        aVar.eQy.startLoad(dVar.avatar, 12, false);
        aVar.bXt.setText(dVar.userName);
        aVar.era.setText(this.mContext.getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.Ve) {
            aVar.eQz.setEnabled(true);
            aVar.eQz.setBackgroundResource(a.f.sdk_red_border_bg);
            aVar.eQz.setText(this.mContext.getString(a.i.ala_challenge_invite));
            aVar.eQz.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            aVar.eQz.setBackgroundDrawable(null);
            aVar.eQz.setText(this.mContext.getString(a.i.ala_live_challenging));
            aVar.eQz.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
        }
        aVar.eQz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.Ve && g.this.eQv != null) {
                    g.this.eQv.g(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes2.dex */
    private static class a {
        public TextView bXt;
        public HeadImageView eQy;
        public TextView eQz;
        public TextView era;

        private a() {
        }
    }
}
