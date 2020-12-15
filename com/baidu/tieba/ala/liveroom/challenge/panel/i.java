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
    private List<com.baidu.live.challenge.d> hjG = new ArrayList();
    private j.a hlu;
    private Context mContext;

    public i(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.hjG.clear();
            this.hjG.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void cC(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.hjG.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void cdN() {
        if (!ListUtils.isEmpty(this.hjG)) {
            this.hjG.clear();
            notifyDataSetChanged();
        }
    }

    public void a(j.a aVar) {
        this.hlu = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hjG.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.hjG.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void i(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.hjG) {
                if (dVar.equals(dVar2)) {
                    dVar2.aIh = dVar.aIh;
                    dVar2.aIg = dVar.aIg;
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
            aVar.hlx = (HeadImageView) view.findViewById(a.f.ala_challenge_user_header);
            aVar.hlx.setIsRound(true);
            aVar.hlx.setAutoChangeStyle(false);
            aVar.eBQ = (TextView) view.findViewById(a.f.ala_challenge_user_name);
            aVar.hly = (TextView) view.findViewById(a.f.ala_challenge_user_status);
            aVar.gEF = (TextView) view.findViewById(a.f.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.hjG.get(i);
        aVar.hlx.startLoad(dVar.avatar, 12, false);
        aVar.eBQ.setText(Html.fromHtml(dVar.userName));
        aVar.gEF.setText(this.mContext.getString(a.h.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.aIh && dVar.aIg != 1) {
            aVar.hly.setEnabled(true);
            aVar.hly.setBackgroundResource(a.e.sdk_red_border_bg);
            aVar.hly.setText(this.mContext.getString(a.h.ala_challenge_invite));
            aVar.hly.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (dVar.aIg == 1) {
            aVar.hly.setEnabled(false);
            aVar.hly.setBackgroundDrawable(null);
            aVar.hly.setText(this.mContext.getString(a.h.ala_live_pking));
            aVar.hly.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_i_alpha50));
        } else {
            aVar.hly.setBackgroundDrawable(null);
            aVar.hly.setText(this.mContext.getString(a.h.ala_live_challenging));
            aVar.hly.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_i_alpha50));
        }
        aVar.hly.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.aIh && i.this.hlu != null) {
                    i.this.hlu.f(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes4.dex */
    private static class a {
        public TextView eBQ;
        public TextView gEF;
        public HeadImageView hlx;
        public TextView hly;

        private a() {
        }
    }
}
