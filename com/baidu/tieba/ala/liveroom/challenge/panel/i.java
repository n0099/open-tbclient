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
/* loaded from: classes7.dex */
public class i extends BaseAdapter {
    private List<com.baidu.live.challenge.d> gqJ = new ArrayList();
    private j.a gss;
    private Context mContext;

    public i(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.gqJ.clear();
            this.gqJ.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bY(List<com.baidu.live.challenge.d> list) {
        if (list != null && !ListUtils.isEmpty(list)) {
            this.gqJ.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void bQk() {
        if (!ListUtils.isEmpty(this.gqJ)) {
            this.gqJ.clear();
            notifyDataSetChanged();
        }
    }

    public void a(j.a aVar) {
        this.gss = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gqJ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.gqJ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void i(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            for (com.baidu.live.challenge.d dVar2 : this.gqJ) {
                if (dVar.equals(dVar2)) {
                    dVar2.aCy = dVar.aCy;
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
            aVar.gsv = (HeadImageView) view.findViewById(a.g.ala_challenge_user_header);
            aVar.gsv.setIsRound(true);
            aVar.gsv.setAutoChangeStyle(false);
            aVar.dTU = (TextView) view.findViewById(a.g.ala_challenge_user_name);
            aVar.gsw = (TextView) view.findViewById(a.g.ala_challenge_user_status);
            aVar.fQS = (TextView) view.findViewById(a.g.ala_challenge_user_charm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.live.challenge.d dVar = this.gqJ.get(i);
        aVar.gsv.startLoad(dVar.avatar, 12, false);
        aVar.dTU.setText(Html.fromHtml(dVar.userName));
        aVar.fQS.setText(this.mContext.getString(a.i.sdk_charm_name, String.valueOf(dVar.charmCount)));
        if (dVar.aCy) {
            aVar.gsw.setEnabled(true);
            aVar.gsw.setBackgroundResource(a.f.sdk_red_border_bg);
            aVar.gsw.setText(this.mContext.getString(a.i.ala_challenge_invite));
            aVar.gsw.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i));
        } else {
            aVar.gsw.setBackgroundDrawable(null);
            aVar.gsw.setText(this.mContext.getString(a.i.ala_live_challenging));
            aVar.gsw.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
        }
        aVar.gsw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dVar.aCy && i.this.gss != null) {
                    i.this.gss.f(dVar);
                    view2.setEnabled(false);
                }
            }
        });
        return view;
    }

    /* loaded from: classes7.dex */
    private static class a {
        public TextView dTU;
        public TextView fQS;
        public HeadImageView gsv;
        public TextView gsw;

        private a() {
        }
    }
}
