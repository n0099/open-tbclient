package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.tieba.ala.liveroom.challenge.panel.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g extends BaseAdapter {
    private List<com.baidu.live.challenge.d> eRR = new ArrayList();
    private h.a eRS;
    private Context mContext;

    public g(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.eRR.clear();
            this.eRR.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bD(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.eRR.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bjd() {
        if (!ListUtils.isEmpty(this.eRR)) {
            this.eRR.clear();
            notifyDataSetChanged();
        }
    }

    public void a(h.a aVar) {
        this.eRS = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eRR.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.eRR.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void e(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.eRR) {
                if (dVar.equals(dVar2)) {
                    dVar2.Vu = dVar.Vu;
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
            aVar.eRV = (HeadImageView) view.findViewById(a.g.ala_challenge_user_header);
            aVar.eRV.setIsRound(true);
            aVar.eRV.setAutoChangeStyle(false);
            aVar.bXF = (TextView) view.findViewById(a.g.ala_challenge_user_name);
            aVar.eRW = (TextView) view.findViewById(a.g.ala_challenge_user_status);
            aVar.esm = (TextView) view.findViewById(a.g.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.eRR.get(i);
        aVar.eRV.startLoad(dVar.avatar, 12, false);
        aVar.bXF.setText(Html.fromHtml(dVar.userName));
        aVar.esm.setText(this.mContext.getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.Vu) {
            aVar.eRW.setEnabled(true);
            aVar.eRW.setBackgroundResource(a.f.sdk_red_border_bg);
            aVar.eRW.setText(this.mContext.getString(a.i.ala_challenge_invite));
            aVar.eRW.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            aVar.eRW.setBackgroundDrawable(null);
            aVar.eRW.setText(this.mContext.getString(a.i.ala_live_challenging));
            aVar.eRW.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
        }
        aVar.eRW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.Vu && g.this.eRS != null) {
                    g.this.eRS.g(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes2.dex */
    private static class a {
        public TextView bXF;
        public HeadImageView eRV;
        public TextView eRW;
        public TextView esm;

        private a() {
        }
    }
}
