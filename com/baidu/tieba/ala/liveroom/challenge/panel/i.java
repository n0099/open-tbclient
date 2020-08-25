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
/* loaded from: classes7.dex */
public class i extends BaseAdapter {
    private List<com.baidu.live.challenge.d> gqF = new ArrayList();
    private j.a gso;
    private Context mContext;

    public i(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.gqF.clear();
            this.gqF.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bY(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.gqF.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bQj() {
        if (!ListUtils.isEmpty(this.gqF)) {
            this.gqF.clear();
            notifyDataSetChanged();
        }
    }

    public void a(j.a aVar) {
        this.gso = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gqF.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.gqF.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void i(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.gqF) {
                if (dVar.equals(dVar2)) {
                    dVar2.aCw = dVar.aCw;
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
            aVar.gsr = (HeadImageView) view.findViewById(a.g.ala_challenge_user_header);
            aVar.gsr.setIsRound(true);
            aVar.gsr.setAutoChangeStyle(false);
            aVar.dTQ = (TextView) view.findViewById(a.g.ala_challenge_user_name);
            aVar.gss = (TextView) view.findViewById(a.g.ala_challenge_user_status);
            aVar.fQO = (TextView) view.findViewById(a.g.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.gqF.get(i);
        aVar.gsr.startLoad(dVar.avatar, 12, false);
        aVar.dTQ.setText(Html.fromHtml(dVar.userName));
        aVar.fQO.setText(this.mContext.getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.aCw) {
            aVar.gss.setEnabled(true);
            aVar.gss.setBackgroundResource(a.f.sdk_red_border_bg);
            aVar.gss.setText(this.mContext.getString(a.i.ala_challenge_invite));
            aVar.gss.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            aVar.gss.setBackgroundDrawable(null);
            aVar.gss.setText(this.mContext.getString(a.i.ala_live_challenging));
            aVar.gss.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
        }
        aVar.gss.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.aCw && i.this.gso != null) {
                    i.this.gso.f(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes7.dex */
    private static class a {
        public TextView dTQ;
        public TextView fQO;
        public HeadImageView gsr;
        public TextView gss;

        private a() {
        }
    }
}
