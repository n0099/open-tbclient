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
/* loaded from: classes3.dex */
public class i extends BaseAdapter {
    private List<com.baidu.live.challenge.d> fZp = new ArrayList();
    private j.a gaY;
    private Context mContext;

    public i(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.fZp.clear();
            this.fZp.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bT(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.fZp.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bDs() {
        if (!ListUtils.isEmpty(this.fZp)) {
            this.fZp.clear();
            notifyDataSetChanged();
        }
    }

    public void a(j.a aVar) {
        this.gaY = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fZp.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.fZp.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void i(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.fZp) {
                if (dVar.equals(dVar2)) {
                    dVar2.awp = dVar.awp;
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
            aVar.gbb = (HeadImageView) view.findViewById(a.g.ala_challenge_user_header);
            aVar.gbb.setIsRound(true);
            aVar.gbb.setAutoChangeStyle(false);
            aVar.dEL = (TextView) view.findViewById(a.g.ala_challenge_user_name);
            aVar.gbc = (TextView) view.findViewById(a.g.ala_challenge_user_status);
            aVar.fAn = (TextView) view.findViewById(a.g.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.fZp.get(i);
        aVar.gbb.startLoad(dVar.avatar, 12, false);
        aVar.dEL.setText(Html.fromHtml(dVar.userName));
        aVar.fAn.setText(this.mContext.getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.awp) {
            aVar.gbc.setEnabled(true);
            aVar.gbc.setBackgroundResource(a.f.sdk_red_border_bg);
            aVar.gbc.setText(this.mContext.getString(a.i.ala_challenge_invite));
            aVar.gbc.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            aVar.gbc.setBackgroundDrawable(null);
            aVar.gbc.setText(this.mContext.getString(a.i.ala_live_challenging));
            aVar.gbc.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
        }
        aVar.gbc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.awp && i.this.gaY != null) {
                    i.this.gaY.f(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes3.dex */
    private static class a {
        public TextView dEL;
        public TextView fAn;
        public HeadImageView gbb;
        public TextView gbc;

        private a() {
        }
    }
}
