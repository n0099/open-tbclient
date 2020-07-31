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
    private List<com.baidu.live.challenge.d> gex = new ArrayList();
    private j.a ggg;
    private Context mContext;

    public i(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.gex.clear();
            this.gex.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bX(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.gex.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bGE() {
        if (!ListUtils.isEmpty(this.gex)) {
            this.gex.clear();
            notifyDataSetChanged();
        }
    }

    public void a(j.a aVar) {
        this.ggg = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gex.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.gex.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void i(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.gex) {
                if (dVar.equals(dVar2)) {
                    dVar2.axu = dVar.axu;
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
            aVar.ggj = (HeadImageView) view.findViewById(a.g.ala_challenge_user_header);
            aVar.ggj.setIsRound(true);
            aVar.ggj.setAutoChangeStyle(false);
            aVar.dKI = (TextView) view.findViewById(a.g.ala_challenge_user_name);
            aVar.ggk = (TextView) view.findViewById(a.g.ala_challenge_user_status);
            aVar.fFx = (TextView) view.findViewById(a.g.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.gex.get(i);
        aVar.ggj.startLoad(dVar.avatar, 12, false);
        aVar.dKI.setText(Html.fromHtml(dVar.userName));
        aVar.fFx.setText(this.mContext.getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.axu) {
            aVar.ggk.setEnabled(true);
            aVar.ggk.setBackgroundResource(a.f.sdk_red_border_bg);
            aVar.ggk.setText(this.mContext.getString(a.i.ala_challenge_invite));
            aVar.ggk.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            aVar.ggk.setBackgroundDrawable(null);
            aVar.ggk.setText(this.mContext.getString(a.i.ala_live_challenging));
            aVar.ggk.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
        }
        aVar.ggk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.axu && i.this.ggg != null) {
                    i.this.ggg.f(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes4.dex */
    private static class a {
        public TextView dKI;
        public TextView fFx;
        public HeadImageView ggj;
        public TextView ggk;

        private a() {
        }
    }
}
