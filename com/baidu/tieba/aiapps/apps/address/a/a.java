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
public class a extends RecyclerView.Adapter<C0263a> {
    private List<com.baidu.tieba.aiapps.apps.address.c.b> cRP = new ArrayList();
    private b cRQ;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface b {
        void b(com.baidu.tieba.aiapps.apps.address.c.b bVar, String str);

        void lH(int i);

        void lI(int i);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void setDeliveryChooseListener(b bVar) {
        this.cRQ = bVar;
    }

    public void ay(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        this.cRP = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cRP.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: i */
    public C0263a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.delivery_choose_item_layout, viewGroup, false);
        a(new C0263a(inflate));
        return new C0263a(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0263a c0263a, final int i) {
        final com.baidu.tieba.aiapps.apps.address.c.b bVar = this.cRP.get(i);
        c0263a.bUb.setText(bVar.userName);
        c0263a.cRS.setText(bVar.cSs);
        c0263a.cRT.setText(bVar.ayy());
        c0263a.cRU.setVisibility(bVar.cSy ? 0 : 8);
        c0263a.cRV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cRQ != null) {
                    a.this.cRQ.b(bVar, "update");
                }
            }
        });
        c0263a.cRV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.2
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
        c0263a.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cRQ != null) {
                    a.this.cRQ.lH(i);
                }
            }
        });
        c0263a.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (a.this.cRQ != null) {
                    a.this.cRQ.lI(i);
                    return false;
                }
                return false;
            }
        });
    }

    public void a(C0263a c0263a) {
        if (com.baidu.swan.apps.u.a.CR().Dq()) {
            int color = AppRuntime.getAppContext().getResources().getColor(d.C0277d.delivery_txt_color_1);
            int color2 = AppRuntime.getAppContext().getResources().getColor(d.C0277d.delivery_txt_color_2);
            int color3 = AppRuntime.getAppContext().getResources().getColor(d.C0277d.delivery_txt_color_3);
            c0263a.itemView.setBackgroundResource(d.f.delivery_list_item_background_selector);
            c0263a.bUb.setTextColor(color);
            c0263a.cRS.setTextColor(color);
            c0263a.cRT.setTextColor(color2);
            c0263a.cRU.setTextColor(color);
            Drawable drawable = AppRuntime.getAppContext().getResources().getDrawable(d.f.delivery_default_used);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            c0263a.cRU.setCompoundDrawables(drawable, null, null, null);
            c0263a.cRV.setTextColor(color);
            Drawable drawable2 = AppRuntime.getAppContext().getResources().getDrawable(d.f.delivery_edit);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            c0263a.cRV.setCompoundDrawables(drawable2, null, null, null);
            c0263a.cRW.setBackgroundColor(color3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0263a extends RecyclerView.ViewHolder {
        private TextView bUb;
        private TextView cRS;
        private TextView cRT;
        private TextView cRU;
        private TextView cRV;
        private View cRW;
        private View cRX;

        public C0263a(View view) {
            super(view);
            this.cRX = view;
            this.bUb = (TextView) view.findViewById(d.g.addr_user_name);
            this.cRS = (TextView) view.findViewById(d.g.addr_tel_number);
            this.cRT = (TextView) view.findViewById(d.g.addr_detail_region);
            this.cRW = view.findViewById(d.g.addr_divided_line);
            this.cRU = (TextView) view.findViewById(d.g.addr_current_used);
            this.cRV = (TextView) view.findViewById(d.g.addr_edit);
        }
    }
}
