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
/* loaded from: classes4.dex */
public class i extends BaseAdapter {
    private List<com.baidu.live.challenge.d> gZV = new ArrayList();
    private j.a hbJ;
    private Context mContext;

    public i(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.gZV.clear();
            this.gZV.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void cy(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.gZV.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bZR() {
        if (!ListUtils.isEmpty(this.gZV)) {
            this.gZV.clear();
            notifyDataSetChanged();
        }
    }

    public void a(j.a aVar) {
        this.hbJ = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gZV.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.gZV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void i(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.gZV) {
                if (dVar.equals(dVar2)) {
                    dVar2.aFz = dVar.aFz;
                    dVar2.aFy = dVar.aFy;
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
            aVar.hbM = (HeadImageView) view.findViewById(a.f.ala_challenge_user_header);
            aVar.hbM.setIsRound(true);
            aVar.hbM.setAutoChangeStyle(false);
            aVar.euO = (TextView) view.findViewById(a.f.ala_challenge_user_name);
            aVar.hbN = (TextView) view.findViewById(a.f.ala_challenge_user_status);
            aVar.gvU = (TextView) view.findViewById(a.f.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.gZV.get(i);
        aVar.hbM.startLoad(dVar.avatar, 12, false);
        aVar.euO.setText(Html.fromHtml(dVar.userName));
        aVar.gvU.setText(this.mContext.getString(a.h.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.aFz && dVar.aFy != 1) {
            aVar.hbN.setEnabled(true);
            aVar.hbN.setBackgroundResource(a.e.sdk_red_border_bg);
            aVar.hbN.setText(this.mContext.getString(a.h.ala_challenge_invite));
            aVar.hbN.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (dVar.aFy == 1) {
            aVar.hbN.setEnabled(false);
            aVar.hbN.setBackgroundDrawable(null);
            aVar.hbN.setText(this.mContext.getString(a.h.ala_live_pking));
            aVar.hbN.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_i_alpha50));
        } else {
            aVar.hbN.setBackgroundDrawable(null);
            aVar.hbN.setText(this.mContext.getString(a.h.ala_live_challenging));
            aVar.hbN.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_i_alpha50));
        }
        aVar.hbN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.aFz && i.this.hbJ != null) {
                    i.this.hbJ.f(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes4.dex */
    private static class a {
        public TextView euO;
        public TextView gvU;
        public HeadImageView hbM;
        public TextView hbN;

        private a() {
        }
    }
}
