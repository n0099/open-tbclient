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
    private List<com.baidu.live.challenge.d> hvf = new ArrayList();
    private j.a hwT;
    private Context mContext;

    public i(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.hvf.clear();
            this.hvf.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void cE(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.hvf.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void cdH() {
        if (!ListUtils.isEmpty(this.hvf)) {
            this.hvf.clear();
            notifyDataSetChanged();
        }
    }

    public void a(j.a aVar) {
        this.hwT = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hvf.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.hvf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void i(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.hvf) {
                if (dVar.equals(dVar2)) {
                    dVar2.aFD = dVar.aFD;
                    dVar2.aFC = dVar.aFC;
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
            aVar.hwW = (HeadImageView) view.findViewById(a.f.ala_challenge_user_header);
            aVar.hwW.setIsRound(true);
            aVar.hwW.setAutoChangeStyle(false);
            aVar.eIO = (TextView) view.findViewById(a.f.ala_challenge_user_name);
            aVar.hwX = (TextView) view.findViewById(a.f.ala_challenge_user_status);
            aVar.gOq = (TextView) view.findViewById(a.f.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.hvf.get(i);
        aVar.hwW.startLoad(dVar.avatar, 12, false);
        aVar.eIO.setText(Html.fromHtml(dVar.userName));
        aVar.gOq.setText(this.mContext.getString(a.h.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.aFD && dVar.aFC != 1) {
            aVar.hwX.setEnabled(true);
            aVar.hwX.setBackgroundResource(a.e.sdk_red_border_bg);
            aVar.hwX.setText(this.mContext.getString(a.h.ala_challenge_invite));
            aVar.hwX.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_i));
        } else if (dVar.aFC == 1) {
            aVar.hwX.setEnabled(false);
            aVar.hwX.setBackgroundDrawable(null);
            aVar.hwX.setText(this.mContext.getString(a.h.ala_live_pking));
            aVar.hwX.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_i_alpha50));
        } else {
            aVar.hwX.setBackgroundDrawable(null);
            aVar.hwX.setText(this.mContext.getString(a.h.ala_live_challenging));
            aVar.hwX.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_i_alpha50));
        }
        aVar.hwX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.aFD && i.this.hwT != null) {
                    i.this.hwT.f(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes11.dex */
    private static class a {
        public TextView eIO;
        public TextView gOq;
        public HeadImageView hwW;
        public TextView hwX;

        private a() {
        }
    }
}
