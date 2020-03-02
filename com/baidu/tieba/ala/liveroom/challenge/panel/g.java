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
    private List<com.baidu.live.challenge.d> eVJ = new ArrayList();
    private h.a eVK;
    private Context mContext;

    public g(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.eVJ.clear();
            this.eVJ.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bD(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.eVJ.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bkU() {
        if (!ListUtils.isEmpty(this.eVJ)) {
            this.eVJ.clear();
            notifyDataSetChanged();
        }
    }

    public void a(h.a aVar) {
        this.eVK = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eVJ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.eVJ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void e(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.eVJ) {
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
            aVar.eVN = (HeadImageView) view.findViewById(a.g.ala_challenge_user_header);
            aVar.eVN.setIsRound(true);
            aVar.eVN.setAutoChangeStyle(false);
            aVar.cbK = (TextView) view.findViewById(a.g.ala_challenge_user_name);
            aVar.eVO = (TextView) view.findViewById(a.g.ala_challenge_user_status);
            aVar.ewx = (TextView) view.findViewById(a.g.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.eVJ.get(i);
        aVar.eVN.startLoad(dVar.avatar, 12, false);
        aVar.cbK.setText(Html.fromHtml(dVar.userName));
        aVar.ewx.setText(this.mContext.getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.Xa) {
            aVar.eVO.setEnabled(true);
            aVar.eVO.setBackgroundResource(a.f.sdk_red_border_bg);
            aVar.eVO.setText(this.mContext.getString(a.i.ala_challenge_invite));
            aVar.eVO.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            aVar.eVO.setBackgroundDrawable(null);
            aVar.eVO.setText(this.mContext.getString(a.i.ala_live_challenging));
            aVar.eVO.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
        }
        aVar.eVO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.Xa && g.this.eVK != null) {
                    g.this.eVK.g(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes3.dex */
    private static class a {
        public TextView cbK;
        public HeadImageView eVN;
        public TextView eVO;
        public TextView ewx;

        private a() {
        }
    }
}
