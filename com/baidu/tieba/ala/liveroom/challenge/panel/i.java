package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.tieba.ala.liveroom.challenge.panel.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class i extends BaseAdapter {
    private List<com.baidu.live.challenge.d> hxc = new ArrayList();
    private j.a hyQ;
    private Context mContext;

    public i(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.hxc.clear();
            this.hxc.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void cE(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.hxc.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void cdU() {
        if (!ListUtils.isEmpty(this.hxc)) {
            this.hxc.clear();
            notifyDataSetChanged();
        }
    }

    public void a(j.a aVar) {
        this.hyQ = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hxc.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.hxc.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void i(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.hxc) {
                if (dVar.equals(dVar2)) {
                    dVar2.aHd = dVar.aHd;
                    dVar2.aHc = dVar.aHc;
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_user_item_view_layout, (ViewGroup) null);
            aVar = new a();
            aVar.hyT = (HeadImageView) view.findViewById(a.f.ala_challenge_user_header);
            aVar.hyT.setIsRound(true);
            aVar.hyT.setAutoChangeStyle(false);
            aVar.eKp = (TextView) view.findViewById(a.f.ala_challenge_user_name);
            aVar.hyU = (TextView) view.findViewById(a.f.ala_challenge_user_status);
            aVar.gQn = (TextView) view.findViewById(a.f.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.hxc.get(i);
        aVar.hyT.startLoad(dVar.avatar, 12, false);
        aVar.eKp.setText(Html.fromHtml(dVar.userName));
        aVar.gQn.setText(this.mContext.getString(a.h.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.aHd && dVar.aHc != 1) {
            aVar.hyU.setEnabled(true);
            aVar.hyU.setBackgroundResource(a.e.sdk_red_border_bg);
            aVar.hyU.setText(this.mContext.getString(a.h.ala_challenge_invite));
            aVar.hyU.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (dVar.aHc == 1) {
            aVar.hyU.setEnabled(false);
            aVar.hyU.setBackgroundDrawable(null);
            aVar.hyU.setText(this.mContext.getString(a.h.ala_live_pking));
            aVar.hyU.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_i_alpha50));
        } else {
            aVar.hyU.setBackgroundDrawable(null);
            aVar.hyU.setText(this.mContext.getString(a.h.ala_live_challenging));
            aVar.hyU.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_i_alpha50));
        }
        aVar.hyU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.aHd && i.this.hyQ != null) {
                    i.this.hyQ.f(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes10.dex */
    private static class a {
        public TextView eKp;
        public TextView gQn;
        public HeadImageView hyT;
        public TextView hyU;

        private a() {
        }
    }
}
