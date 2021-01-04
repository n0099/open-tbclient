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
/* loaded from: classes11.dex */
public class i extends BaseAdapter {
    private List<com.baidu.live.challenge.d> hvB = new ArrayList();
    private j.a hxp;
    private Context mContext;

    public i(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.hvB.clear();
            this.hvB.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void cJ(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.hvB.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void cgD() {
        if (!ListUtils.isEmpty(this.hvB)) {
            this.hvB.clear();
            notifyDataSetChanged();
        }
    }

    public void a(j.a aVar) {
        this.hxp = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hvB.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.hvB.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void i(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.hvB) {
                if (dVar.equals(dVar2)) {
                    dVar2.aID = dVar.aID;
                    dVar2.aIC = dVar.aIC;
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
            aVar.hxs = (HeadImageView) view.findViewById(a.f.ala_challenge_user_header);
            aVar.hxs.setIsRound(true);
            aVar.hxs.setAutoChangeStyle(false);
            aVar.eLt = (TextView) view.findViewById(a.f.ala_challenge_user_name);
            aVar.hxt = (TextView) view.findViewById(a.f.ala_challenge_user_status);
            aVar.gQq = (TextView) view.findViewById(a.f.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.hvB.get(i);
        aVar.hxs.startLoad(dVar.avatar, 12, false);
        aVar.eLt.setText(Html.fromHtml(dVar.userName));
        aVar.gQq.setText(this.mContext.getString(a.h.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.aID && dVar.aIC != 1) {
            aVar.hxt.setEnabled(true);
            aVar.hxt.setBackgroundResource(a.e.sdk_red_border_bg);
            aVar.hxt.setText(this.mContext.getString(a.h.ala_challenge_invite));
            aVar.hxt.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (dVar.aIC == 1) {
            aVar.hxt.setEnabled(false);
            aVar.hxt.setBackgroundDrawable(null);
            aVar.hxt.setText(this.mContext.getString(a.h.ala_live_pking));
            aVar.hxt.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_i_alpha50));
        } else {
            aVar.hxt.setBackgroundDrawable(null);
            aVar.hxt.setText(this.mContext.getString(a.h.ala_live_challenging));
            aVar.hxt.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_i_alpha50));
        }
        aVar.hxt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.aID && i.this.hxp != null) {
                    i.this.hxp.f(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes11.dex */
    private static class a {
        public TextView eLt;
        public TextView gQq;
        public HeadImageView hxs;
        public TextView hxt;

        private a() {
        }
    }
}
