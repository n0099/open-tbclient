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
    private List<com.baidu.live.challenge.d> hqV = new ArrayList();
    private j.a hsJ;
    private Context mContext;

    public i(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.hqV.clear();
            this.hqV.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void cJ(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.hqV.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void ccM() {
        if (!ListUtils.isEmpty(this.hqV)) {
            this.hqV.clear();
            notifyDataSetChanged();
        }
    }

    public void a(j.a aVar) {
        this.hsJ = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hqV.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.hqV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void i(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.hqV) {
                if (dVar.equals(dVar2)) {
                    dVar2.aDQ = dVar.aDQ;
                    dVar2.aDP = dVar.aDP;
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
            aVar.hsM = (HeadImageView) view.findViewById(a.f.ala_challenge_user_header);
            aVar.hsM.setIsRound(true);
            aVar.hsM.setAutoChangeStyle(false);
            aVar.eGI = (TextView) view.findViewById(a.f.ala_challenge_user_name);
            aVar.hsN = (TextView) view.findViewById(a.f.ala_challenge_user_status);
            aVar.gLK = (TextView) view.findViewById(a.f.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.hqV.get(i);
        aVar.hsM.startLoad(dVar.avatar, 12, false);
        aVar.eGI.setText(Html.fromHtml(dVar.userName));
        aVar.gLK.setText(this.mContext.getString(a.h.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.aDQ && dVar.aDP != 1) {
            aVar.hsN.setEnabled(true);
            aVar.hsN.setBackgroundResource(a.e.sdk_red_border_bg);
            aVar.hsN.setText(this.mContext.getString(a.h.ala_challenge_invite));
            aVar.hsN.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (dVar.aDP == 1) {
            aVar.hsN.setEnabled(false);
            aVar.hsN.setBackgroundDrawable(null);
            aVar.hsN.setText(this.mContext.getString(a.h.ala_live_pking));
            aVar.hsN.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_i_alpha50));
        } else {
            aVar.hsN.setBackgroundDrawable(null);
            aVar.hsN.setText(this.mContext.getString(a.h.ala_live_challenging));
            aVar.hsN.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_i_alpha50));
        }
        aVar.hsN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.aDQ && i.this.hsJ != null) {
                    i.this.hsJ.f(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes10.dex */
    private static class a {
        public TextView eGI;
        public TextView gLK;
        public HeadImageView hsM;
        public TextView hsN;

        private a() {
        }
    }
}
