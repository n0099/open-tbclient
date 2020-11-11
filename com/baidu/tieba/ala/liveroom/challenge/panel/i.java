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
    private List<com.baidu.live.challenge.d> hao = new ArrayList();
    private j.a hcc;
    private Context mContext;

    public i(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.hao.clear();
            this.hao.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void cy(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.hao.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void cay() {
        if (!ListUtils.isEmpty(this.hao)) {
            this.hao.clear();
            notifyDataSetChanged();
        }
    }

    public void a(j.a aVar) {
        this.hcc = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hao.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.hao.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void i(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.hao) {
                if (dVar.equals(dVar2)) {
                    dVar2.aHk = dVar.aHk;
                    dVar2.aHj = dVar.aHj;
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
            aVar.hcf = (HeadImageView) view.findViewById(a.f.ala_challenge_user_header);
            aVar.hcf.setIsRound(true);
            aVar.hcf.setAutoChangeStyle(false);
            aVar.ewx = (TextView) view.findViewById(a.f.ala_challenge_user_name);
            aVar.hcg = (TextView) view.findViewById(a.f.ala_challenge_user_status);
            aVar.gwn = (TextView) view.findViewById(a.f.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.hao.get(i);
        aVar.hcf.startLoad(dVar.avatar, 12, false);
        aVar.ewx.setText(Html.fromHtml(dVar.userName));
        aVar.gwn.setText(this.mContext.getString(a.h.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.aHk && dVar.aHj != 1) {
            aVar.hcg.setEnabled(true);
            aVar.hcg.setBackgroundResource(a.e.sdk_red_border_bg);
            aVar.hcg.setText(this.mContext.getString(a.h.ala_challenge_invite));
            aVar.hcg.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (dVar.aHj == 1) {
            aVar.hcg.setEnabled(false);
            aVar.hcg.setBackgroundDrawable(null);
            aVar.hcg.setText(this.mContext.getString(a.h.ala_live_pking));
            aVar.hcg.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_i_alpha50));
        } else {
            aVar.hcg.setBackgroundDrawable(null);
            aVar.hcg.setText(this.mContext.getString(a.h.ala_live_challenging));
            aVar.hcg.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_i_alpha50));
        }
        aVar.hcg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.aHk && i.this.hcc != null) {
                    i.this.hcc.f(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes4.dex */
    private static class a {
        public TextView ewx;
        public TextView gwn;
        public HeadImageView hcf;
        public TextView hcg;

        private a() {
        }
    }
}
