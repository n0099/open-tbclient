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
    private List<com.baidu.live.challenge.d> fAN = new ArrayList();
    private h.a fAO;
    private Context mContext;

    public g(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.fAN.clear();
            this.fAN.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bM(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.fAN.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bur() {
        if (!ListUtils.isEmpty(this.fAN)) {
            this.fAN.clear();
            notifyDataSetChanged();
        }
    }

    public void a(h.a aVar) {
        this.fAO = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fAN.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.fAN.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void e(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.fAN) {
                if (dVar.equals(dVar2)) {
                    dVar2.apt = dVar.apt;
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
            aVar.fAR = (HeadImageView) view.findViewById(a.g.ala_challenge_user_header);
            aVar.fAR.setIsRound(true);
            aVar.fAR.setAutoChangeStyle(false);
            aVar.cBd = (TextView) view.findViewById(a.g.ala_challenge_user_name);
            aVar.fAS = (TextView) view.findViewById(a.g.ala_challenge_user_status);
            aVar.fbo = (TextView) view.findViewById(a.g.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.fAN.get(i);
        aVar.fAR.startLoad(dVar.avatar, 12, false);
        aVar.cBd.setText(Html.fromHtml(dVar.userName));
        aVar.fbo.setText(this.mContext.getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.apt) {
            aVar.fAS.setEnabled(true);
            aVar.fAS.setBackgroundResource(a.f.sdk_red_border_bg);
            aVar.fAS.setText(this.mContext.getString(a.i.ala_challenge_invite));
            aVar.fAS.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            aVar.fAS.setBackgroundDrawable(null);
            aVar.fAS.setText(this.mContext.getString(a.i.ala_live_challenging));
            aVar.fAS.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
        }
        aVar.fAS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.apt && g.this.fAO != null) {
                    g.this.fAO.g(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes3.dex */
    private static class a {
        public TextView cBd;
        public HeadImageView fAR;
        public TextView fAS;
        public TextView fbo;

        private a() {
        }
    }
}
