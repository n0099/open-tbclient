package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.liveroom.challenge.panel.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class g extends BaseAdapter {
    private List<com.baidu.live.challenge.d> fPb = new ArrayList();
    private h.a fPc;
    private Context mContext;

    public g(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.fPb.clear();
            this.fPb.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bJ(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.fPb.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bAs() {
        if (!ListUtils.isEmpty(this.fPb)) {
            this.fPb.clear();
            notifyDataSetChanged();
        }
    }

    public void a(h.a aVar) {
        this.fPc = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fPb.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.fPb.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void e(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.fPb) {
                if (dVar.equals(dVar2)) {
                    dVar2.aum = dVar.aum;
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
            aVar.fPf = (HeadImageView) view.findViewById(a.g.ala_challenge_user_header);
            aVar.fPf.setIsRound(true);
            aVar.fPf.setAutoChangeStyle(false);
            aVar.dXU = (TextView) view.findViewById(a.g.ala_challenge_user_name);
            aVar.fPg = (TextView) view.findViewById(a.g.ala_challenge_user_status);
            aVar.fpb = (TextView) view.findViewById(a.g.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.fPb.get(i);
        aVar.fPf.startLoad(dVar.avatar, 12, false);
        aVar.dXU.setText(Html.fromHtml(dVar.userName));
        aVar.fpb.setText(this.mContext.getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.aum) {
            aVar.fPg.setEnabled(true);
            aVar.fPg.setBackgroundResource(a.f.sdk_red_border_bg);
            aVar.fPg.setText(this.mContext.getString(a.i.ala_challenge_invite));
            aVar.fPg.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            aVar.fPg.setBackgroundDrawable(null);
            aVar.fPg.setText(this.mContext.getString(a.i.ala_live_challenging));
            aVar.fPg.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
        }
        aVar.fPg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.aum && g.this.fPc != null) {
                    g.this.fPc.g(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes3.dex */
    private static class a {
        public TextView dXU;
        public HeadImageView fPf;
        public TextView fPg;
        public TextView fpb;

        private a() {
        }
    }
}
