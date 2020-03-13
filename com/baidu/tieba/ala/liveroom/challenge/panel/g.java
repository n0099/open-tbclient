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
    private List<com.baidu.live.challenge.d> eVW = new ArrayList();
    private h.a eVX;
    private Context mContext;

    public g(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.eVW.clear();
            this.eVW.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bD(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.eVW.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bkV() {
        if (!ListUtils.isEmpty(this.eVW)) {
            this.eVW.clear();
            notifyDataSetChanged();
        }
    }

    public void a(h.a aVar) {
        this.eVX = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eVW.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.eVW.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void e(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.eVW) {
                if (dVar.equals(dVar2)) {
                    dVar2.Xa = dVar.Xa;
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
            aVar.eWa = (HeadImageView) view.findViewById(a.g.ala_challenge_user_header);
            aVar.eWa.setIsRound(true);
            aVar.eWa.setAutoChangeStyle(false);
            aVar.cbL = (TextView) view.findViewById(a.g.ala_challenge_user_name);
            aVar.eWb = (TextView) view.findViewById(a.g.ala_challenge_user_status);
            aVar.ewK = (TextView) view.findViewById(a.g.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.eVW.get(i);
        aVar.eWa.startLoad(dVar.avatar, 12, false);
        aVar.cbL.setText(Html.fromHtml(dVar.userName));
        aVar.ewK.setText(this.mContext.getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.Xa) {
            aVar.eWb.setEnabled(true);
            aVar.eWb.setBackgroundResource(a.f.sdk_red_border_bg);
            aVar.eWb.setText(this.mContext.getString(a.i.ala_challenge_invite));
            aVar.eWb.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            aVar.eWb.setBackgroundDrawable(null);
            aVar.eWb.setText(this.mContext.getString(a.i.ala_live_challenging));
            aVar.eWb.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
        }
        aVar.eWb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.Xa && g.this.eVX != null) {
                    g.this.eVX.g(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes3.dex */
    private static class a {
        public TextView cbL;
        public HeadImageView eWa;
        public TextView eWb;
        public TextView ewK;

        private a() {
        }
    }
}
