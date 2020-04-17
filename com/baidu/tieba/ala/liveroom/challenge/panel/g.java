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
    private List<com.baidu.live.challenge.d> fAI = new ArrayList();
    private h.a fAJ;
    private Context mContext;

    public g(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.fAI.clear();
            this.fAI.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bM(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.fAI.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void but() {
        if (!ListUtils.isEmpty(this.fAI)) {
            this.fAI.clear();
            notifyDataSetChanged();
        }
    }

    public void a(h.a aVar) {
        this.fAJ = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fAI.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.fAI.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void e(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.fAI) {
                if (dVar.equals(dVar2)) {
                    dVar2.apm = dVar.apm;
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
            aVar.fAM = (HeadImageView) view.findViewById(a.g.ala_challenge_user_header);
            aVar.fAM.setIsRound(true);
            aVar.fAM.setAutoChangeStyle(false);
            aVar.cAX = (TextView) view.findViewById(a.g.ala_challenge_user_name);
            aVar.fAN = (TextView) view.findViewById(a.g.ala_challenge_user_status);
            aVar.fbj = (TextView) view.findViewById(a.g.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.fAI.get(i);
        aVar.fAM.startLoad(dVar.avatar, 12, false);
        aVar.cAX.setText(Html.fromHtml(dVar.userName));
        aVar.fbj.setText(this.mContext.getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.apm) {
            aVar.fAN.setEnabled(true);
            aVar.fAN.setBackgroundResource(a.f.sdk_red_border_bg);
            aVar.fAN.setText(this.mContext.getString(a.i.ala_challenge_invite));
            aVar.fAN.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            aVar.fAN.setBackgroundDrawable(null);
            aVar.fAN.setText(this.mContext.getString(a.i.ala_live_challenging));
            aVar.fAN.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
        }
        aVar.fAN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.apm && g.this.fAJ != null) {
                    g.this.fAJ.g(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes3.dex */
    private static class a {
        public TextView cAX;
        public HeadImageView fAM;
        public TextView fAN;
        public TextView fbj;

        private a() {
        }
    }
}
