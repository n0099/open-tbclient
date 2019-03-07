package com.baidu.tieba.aiapps.apps.address.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends RecyclerView.Adapter<C0224a> {
    private List<com.baidu.tieba.aiapps.apps.address.c.b> cRQ = new ArrayList();
    private b cRR;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface b {
        void b(com.baidu.tieba.aiapps.apps.address.c.b bVar, String str);

        void lI(int i);

        void lJ(int i);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void setDeliveryChooseListener(b bVar) {
        this.cRR = bVar;
    }

    public void ay(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        this.cRQ = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cRQ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: i */
    public C0224a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.delivery_choose_item_layout, viewGroup, false);
        a(new C0224a(inflate));
        return new C0224a(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0224a c0224a, final int i) {
        final com.baidu.tieba.aiapps.apps.address.c.b bVar = this.cRQ.get(i);
        c0224a.bTX.setText(bVar.userName);
        c0224a.cRT.setText(bVar.cSt);
        c0224a.cRU.setText(bVar.ayB());
        c0224a.cRV.setVisibility(bVar.cSz ? 0 : 8);
        c0224a.cRW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cRR != null) {
                    a.this.cRR.b(bVar, "update");
                }
            }
        });
        c0224a.cRW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    view.setAlpha(0.3f);
                    return false;
                } else if (action == 1 || action == 3) {
                    view.setAlpha(1.0f);
                    return false;
                } else {
                    return false;
                }
            }
        });
        c0224a.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cRR != null) {
                    a.this.cRR.lI(i);
                }
            }
        });
        c0224a.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (a.this.cRR != null) {
                    a.this.cRR.lJ(i);
                    return false;
                }
                return false;
            }
        });
    }

    public void a(C0224a c0224a) {
        if (com.baidu.swan.apps.u.a.CT().Ds()) {
            int color = AppRuntime.getAppContext().getResources().getColor(d.C0236d.delivery_txt_color_1);
            int color2 = AppRuntime.getAppContext().getResources().getColor(d.C0236d.delivery_txt_color_2);
            int color3 = AppRuntime.getAppContext().getResources().getColor(d.C0236d.delivery_txt_color_3);
            c0224a.itemView.setBackgroundResource(d.f.delivery_list_item_background_selector);
            c0224a.bTX.setTextColor(color);
            c0224a.cRT.setTextColor(color);
            c0224a.cRU.setTextColor(color2);
            c0224a.cRV.setTextColor(color);
            Drawable drawable = AppRuntime.getAppContext().getResources().getDrawable(d.f.delivery_default_used);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            c0224a.cRV.setCompoundDrawables(drawable, null, null, null);
            c0224a.cRW.setTextColor(color);
            Drawable drawable2 = AppRuntime.getAppContext().getResources().getDrawable(d.f.delivery_edit);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            c0224a.cRW.setCompoundDrawables(drawable2, null, null, null);
            c0224a.cRX.setBackgroundColor(color3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0224a extends RecyclerView.ViewHolder {
        private TextView bTX;
        private TextView cRT;
        private TextView cRU;
        private TextView cRV;
        private TextView cRW;
        private View cRX;
        private View cRY;

        public C0224a(View view) {
            super(view);
            this.cRY = view;
            this.bTX = (TextView) view.findViewById(d.g.addr_user_name);
            this.cRT = (TextView) view.findViewById(d.g.addr_tel_number);
            this.cRU = (TextView) view.findViewById(d.g.addr_detail_region);
            this.cRX = view.findViewById(d.g.addr_divided_line);
            this.cRV = (TextView) view.findViewById(d.g.addr_current_used);
            this.cRW = (TextView) view.findViewById(d.g.addr_edit);
        }
    }
}
