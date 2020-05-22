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
    private List<com.baidu.live.challenge.d> fOQ = new ArrayList();
    private h.a fOR;
    private Context mContext;

    public g(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.fOQ.clear();
            this.fOQ.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bJ(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.fOQ.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bAq() {
        if (!ListUtils.isEmpty(this.fOQ)) {
            this.fOQ.clear();
            notifyDataSetChanged();
        }
    }

    public void a(h.a aVar) {
        this.fOR = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fOQ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.fOQ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void e(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.fOQ) {
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
            aVar.fOU = (HeadImageView) view.findViewById(a.g.ala_challenge_user_header);
            aVar.fOU.setIsRound(true);
            aVar.fOU.setAutoChangeStyle(false);
            aVar.dXU = (TextView) view.findViewById(a.g.ala_challenge_user_name);
            aVar.fOV = (TextView) view.findViewById(a.g.ala_challenge_user_status);
            aVar.foQ = (TextView) view.findViewById(a.g.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.fOQ.get(i);
        aVar.fOU.startLoad(dVar.avatar, 12, false);
        aVar.dXU.setText(Html.fromHtml(dVar.userName));
        aVar.foQ.setText(this.mContext.getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.aum) {
            aVar.fOV.setEnabled(true);
            aVar.fOV.setBackgroundResource(a.f.sdk_red_border_bg);
            aVar.fOV.setText(this.mContext.getString(a.i.ala_challenge_invite));
            aVar.fOV.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            aVar.fOV.setBackgroundDrawable(null);
            aVar.fOV.setText(this.mContext.getString(a.i.ala_live_challenging));
            aVar.fOV.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
        }
        aVar.fOV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.aum && g.this.fOR != null) {
                    g.this.fOR.g(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes3.dex */
    private static class a {
        public TextView dXU;
        public HeadImageView fOU;
        public TextView fOV;
        public TextView foQ;

        private a() {
        }
    }
}
