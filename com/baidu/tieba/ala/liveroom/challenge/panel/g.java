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
    private List<com.baidu.live.challenge.d> eWu = new ArrayList();
    private h.a eWv;
    private Context mContext;

    public g(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.eWu.clear();
            this.eWu.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bD(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.eWu.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bla() {
        if (!ListUtils.isEmpty(this.eWu)) {
            this.eWu.clear();
            notifyDataSetChanged();
        }
    }

    public void a(h.a aVar) {
        this.eWv = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eWu.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.eWu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void e(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.eWu) {
                if (dVar.equals(dVar2)) {
                    dVar2.Xk = dVar.Xk;
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
            aVar.eWy = (HeadImageView) view.findViewById(a.g.ala_challenge_user_header);
            aVar.eWy.setIsRound(true);
            aVar.eWy.setAutoChangeStyle(false);
            aVar.cbW = (TextView) view.findViewById(a.g.ala_challenge_user_name);
            aVar.eWz = (TextView) view.findViewById(a.g.ala_challenge_user_status);
            aVar.exg = (TextView) view.findViewById(a.g.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.eWu.get(i);
        aVar.eWy.startLoad(dVar.avatar, 12, false);
        aVar.cbW.setText(Html.fromHtml(dVar.userName));
        aVar.exg.setText(this.mContext.getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.Xk) {
            aVar.eWz.setEnabled(true);
            aVar.eWz.setBackgroundResource(a.f.sdk_red_border_bg);
            aVar.eWz.setText(this.mContext.getString(a.i.ala_challenge_invite));
            aVar.eWz.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            aVar.eWz.setBackgroundDrawable(null);
            aVar.eWz.setText(this.mContext.getString(a.i.ala_live_challenging));
            aVar.eWz.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
        }
        aVar.eWz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.Xk && g.this.eWv != null) {
                    g.this.eWv.g(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes3.dex */
    private static class a {
        public TextView cbW;
        public HeadImageView eWy;
        public TextView eWz;
        public TextView exg;

        private a() {
        }
    }
}
