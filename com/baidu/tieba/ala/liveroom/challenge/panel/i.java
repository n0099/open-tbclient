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
    private List<com.baidu.live.challenge.d> gUk = new ArrayList();
    private j.a gVY;
    private Context mContext;

    public i(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.gUk.clear();
            this.gUk.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void cq(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.gUk.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bXW() {
        if (!ListUtils.isEmpty(this.gUk)) {
            this.gUk.clear();
            notifyDataSetChanged();
        }
    }

    public void a(j.a aVar) {
        this.gVY = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gUk.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.gUk.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void i(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.gUk) {
                if (dVar.equals(dVar2)) {
                    dVar2.aGu = dVar.aGu;
                    dVar2.aGt = dVar.aGt;
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
            aVar.gWb = (HeadImageView) view.findViewById(a.g.ala_challenge_user_header);
            aVar.gWb.setIsRound(true);
            aVar.gWb.setAutoChangeStyle(false);
            aVar.eqE = (TextView) view.findViewById(a.g.ala_challenge_user_name);
            aVar.gWc = (TextView) view.findViewById(a.g.ala_challenge_user_status);
            aVar.gqz = (TextView) view.findViewById(a.g.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.gUk.get(i);
        aVar.gWb.startLoad(dVar.avatar, 12, false);
        aVar.eqE.setText(Html.fromHtml(dVar.userName));
        aVar.gqz.setText(this.mContext.getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.aGu && dVar.aGt != 1) {
            aVar.gWc.setEnabled(true);
            aVar.gWc.setBackgroundResource(a.f.sdk_red_border_bg);
            aVar.gWc.setText(this.mContext.getString(a.i.ala_challenge_invite));
            aVar.gWc.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i));
        } else if (dVar.aGt == 1) {
            aVar.gWc.setEnabled(false);
            aVar.gWc.setBackgroundDrawable(null);
            aVar.gWc.setText(this.mContext.getString(a.i.ala_live_pking));
            aVar.gWc.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
        } else {
            aVar.gWc.setBackgroundDrawable(null);
            aVar.gWc.setText(this.mContext.getString(a.i.ala_live_challenging));
            aVar.gWc.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
        }
        aVar.gWc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.aGu && i.this.gVY != null) {
                    i.this.gVY.f(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes4.dex */
    private static class a {
        public TextView eqE;
        public HeadImageView gWb;
        public TextView gWc;
        public TextView gqz;

        private a() {
        }
    }
}
