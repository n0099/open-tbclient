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
    private List<com.baidu.tieba.aiapps.apps.address.c.b> cRO = new ArrayList();
    private b cRP;
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
        this.cRP = bVar;
    }

    public void ay(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        this.cRO = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cRO.size();
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
        final com.baidu.tieba.aiapps.apps.address.c.b bVar = this.cRO.get(i);
        c0263a.bUa.setText(bVar.userName);
        c0263a.cRR.setText(bVar.cSr);
        c0263a.cRS.setText(bVar.ayy());
        c0263a.cRT.setVisibility(bVar.cSx ? 0 : 8);
        c0263a.cRU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cRP != null) {
                    a.this.cRP.b(bVar, "update");
                }
            }
        });
        c0263a.cRU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.2
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
                if (a.this.cRP != null) {
                    a.this.cRP.lH(i);
                }
            }
        });
        c0263a.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (a.this.cRP != null) {
                    a.this.cRP.lI(i);
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
            c0263a.bUa.setTextColor(color);
            c0263a.cRR.setTextColor(color);
            c0263a.cRS.setTextColor(color2);
            c0263a.cRT.setTextColor(color);
            Drawable drawable = AppRuntime.getAppContext().getResources().getDrawable(d.f.delivery_default_used);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            c0263a.cRT.setCompoundDrawables(drawable, null, null, null);
            c0263a.cRU.setTextColor(color);
            Drawable drawable2 = AppRuntime.getAppContext().getResources().getDrawable(d.f.delivery_edit);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            c0263a.cRU.setCompoundDrawables(drawable2, null, null, null);
            c0263a.cRV.setBackgroundColor(color3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0263a extends RecyclerView.ViewHolder {
        private TextView bUa;
        private TextView cRR;
        private TextView cRS;
        private TextView cRT;
        private TextView cRU;
        private View cRV;
        private View cRW;

        public C0263a(View view) {
            super(view);
            this.cRW = view;
            this.bUa = (TextView) view.findViewById(d.g.addr_user_name);
            this.cRR = (TextView) view.findViewById(d.g.addr_tel_number);
            this.cRS = (TextView) view.findViewById(d.g.addr_detail_region);
            this.cRV = view.findViewById(d.g.addr_divided_line);
            this.cRT = (TextView) view.findViewById(d.g.addr_current_used);
            this.cRU = (TextView) view.findViewById(d.g.addr_edit);
        }
    }
}
