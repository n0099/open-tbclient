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
    private List<com.baidu.live.challenge.d> gIv = new ArrayList();
    private j.a gKj;
    private Context mContext;

    public i(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.gIv.clear();
            this.gIv.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void cg(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.gIv.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bUX() {
        if (!ListUtils.isEmpty(this.gIv)) {
            this.gIv.clear();
            notifyDataSetChanged();
        }
    }

    public void a(j.a aVar) {
        this.gKj = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gIv.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.gIv.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void i(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.gIv) {
                if (dVar.equals(dVar2)) {
                    dVar2.aGm = dVar.aGm;
                    dVar2.aGl = dVar.aGl;
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
            aVar.gKm = (HeadImageView) view.findViewById(a.g.ala_challenge_user_header);
            aVar.gKm.setIsRound(true);
            aVar.gKm.setAutoChangeStyle(false);
            aVar.eig = (TextView) view.findViewById(a.g.ala_challenge_user_name);
            aVar.gKn = (TextView) view.findViewById(a.g.ala_challenge_user_status);
            aVar.ggw = (TextView) view.findViewById(a.g.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.gIv.get(i);
        aVar.gKm.startLoad(dVar.avatar, 12, false);
        aVar.eig.setText(Html.fromHtml(dVar.userName));
        aVar.ggw.setText(this.mContext.getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.aGm && dVar.aGl != 1) {
            aVar.gKn.setEnabled(true);
            aVar.gKn.setBackgroundResource(a.f.sdk_red_border_bg);
            aVar.gKn.setText(this.mContext.getString(a.i.ala_challenge_invite));
            aVar.gKn.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (dVar.aGl == 1) {
            aVar.gKn.setEnabled(false);
            aVar.gKn.setBackgroundDrawable(null);
            aVar.gKn.setText(this.mContext.getString(a.i.ala_live_pking));
            aVar.gKn.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
        } else {
            aVar.gKn.setBackgroundDrawable(null);
            aVar.gKn.setText(this.mContext.getString(a.i.ala_live_challenging));
            aVar.gKn.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
        }
        aVar.gKn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.aGm && i.this.gKj != null) {
                    i.this.gKj.f(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes4.dex */
    private static class a {
        public TextView eig;
        public HeadImageView gKm;
        public TextView gKn;
        public TextView ggw;

        private a() {
        }
    }
}
