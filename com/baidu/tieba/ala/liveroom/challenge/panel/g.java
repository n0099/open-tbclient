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
    private List<com.baidu.live.challenge.d> ebp = new ArrayList();
    private h.a ebq;
    private Context mContext;

    public g(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.ebp.clear();
            this.ebp.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bE(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.ebp.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void aQN() {
        if (!ListUtils.isEmpty(this.ebp)) {
            this.ebp.clear();
            notifyDataSetChanged();
        }
    }

    public void a(h.a aVar) {
        this.ebq = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ebp.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.ebp.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void e(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.ebp) {
                if (dVar.equals(dVar2)) {
                    dVar2.OG = dVar.OG;
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
            aVar.ebt = (HeadImageView) view.findViewById(a.g.ala_challenge_user_header);
            aVar.ebt.setIsRound(true);
            aVar.ebt.setAutoChangeStyle(false);
            aVar.csn = (TextView) view.findViewById(a.g.ala_challenge_user_name);
            aVar.ebu = (TextView) view.findViewById(a.g.ala_challenge_user_status);
            aVar.dFO = (TextView) view.findViewById(a.g.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.ebp.get(i);
        aVar.ebt.startLoad(dVar.avatar, 12, false);
        aVar.csn.setText(dVar.userName);
        aVar.dFO.setText(this.mContext.getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.OG) {
            aVar.ebu.setEnabled(true);
            aVar.ebu.setBackgroundResource(a.f.sdk_red_border_bg);
            aVar.ebu.setText(this.mContext.getString(a.i.ala_challenge_invite));
            aVar.ebu.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            aVar.ebu.setBackgroundDrawable(null);
            aVar.ebu.setText(this.mContext.getString(a.i.ala_live_challenging));
            aVar.ebu.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
        }
        aVar.ebu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.OG && g.this.ebq != null) {
                    g.this.ebq.g(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes6.dex */
    private static class a {
        public TextView csn;
        public TextView dFO;
        public HeadImageView ebt;
        public TextView ebu;

        private a() {
        }
    }
}
