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
    private List<com.baidu.live.challenge.d> eVI = new ArrayList();
    private h.a eVJ;
    private Context mContext;

    public g(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.eVI.clear();
            this.eVI.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bD(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.eVI.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bkS() {
        if (!ListUtils.isEmpty(this.eVI)) {
            this.eVI.clear();
            notifyDataSetChanged();
        }
    }

    public void a(h.a aVar) {
        this.eVJ = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eVI.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.eVI.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void e(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.eVI) {
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
            aVar.eVM = (HeadImageView) view.findViewById(a.g.ala_challenge_user_header);
            aVar.eVM.setIsRound(true);
            aVar.eVM.setAutoChangeStyle(false);
            aVar.cbJ = (TextView) view.findViewById(a.g.ala_challenge_user_name);
            aVar.eVN = (TextView) view.findViewById(a.g.ala_challenge_user_status);
            aVar.eww = (TextView) view.findViewById(a.g.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.eVI.get(i);
        aVar.eVM.startLoad(dVar.avatar, 12, false);
        aVar.cbJ.setText(Html.fromHtml(dVar.userName));
        aVar.eww.setText(this.mContext.getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.Xa) {
            aVar.eVN.setEnabled(true);
            aVar.eVN.setBackgroundResource(a.f.sdk_red_border_bg);
            aVar.eVN.setText(this.mContext.getString(a.i.ala_challenge_invite));
            aVar.eVN.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            aVar.eVN.setBackgroundDrawable(null);
            aVar.eVN.setText(this.mContext.getString(a.i.ala_live_challenging));
            aVar.eVN.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
        }
        aVar.eVN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.Xa && g.this.eVJ != null) {
                    g.this.eVJ.g(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes3.dex */
    private static class a {
        public TextView cbJ;
        public HeadImageView eVM;
        public TextView eVN;
        public TextView eww;

        private a() {
        }
    }
}
