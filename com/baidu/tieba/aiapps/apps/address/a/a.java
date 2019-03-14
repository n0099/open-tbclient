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
    private List<com.baidu.tieba.aiapps.apps.address.c.b> cRM = new ArrayList();
    private b cRN;
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
        this.cRN = bVar;
    }

    public void ay(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        this.cRM = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cRM.size();
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
        final com.baidu.tieba.aiapps.apps.address.c.b bVar = this.cRM.get(i);
        c0263a.bTY.setText(bVar.userName);
        c0263a.cRP.setText(bVar.cSp);
        c0263a.cRQ.setText(bVar.ayB());
        c0263a.cRR.setVisibility(bVar.cSv ? 0 : 8);
        c0263a.cRS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cRN != null) {
                    a.this.cRN.b(bVar, "update");
                }
            }
        });
        c0263a.cRS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.2
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
                if (a.this.cRN != null) {
                    a.this.cRN.lI(i);
                }
            }
        });
        c0263a.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (a.this.cRN != null) {
                    a.this.cRN.lJ(i);
                    return false;
                }
                return false;
            }
        });
    }

    public void a(C0263a c0263a) {
        if (com.baidu.swan.apps.u.a.CT().Ds()) {
            int color = AppRuntime.getAppContext().getResources().getColor(d.C0277d.delivery_txt_color_1);
            int color2 = AppRuntime.getAppContext().getResources().getColor(d.C0277d.delivery_txt_color_2);
            int color3 = AppRuntime.getAppContext().getResources().getColor(d.C0277d.delivery_txt_color_3);
            c0263a.itemView.setBackgroundResource(d.f.delivery_list_item_background_selector);
            c0263a.bTY.setTextColor(color);
            c0263a.cRP.setTextColor(color);
            c0263a.cRQ.setTextColor(color2);
            c0263a.cRR.setTextColor(color);
            Drawable drawable = AppRuntime.getAppContext().getResources().getDrawable(d.f.delivery_default_used);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            c0263a.cRR.setCompoundDrawables(drawable, null, null, null);
            c0263a.cRS.setTextColor(color);
            Drawable drawable2 = AppRuntime.getAppContext().getResources().getDrawable(d.f.delivery_edit);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            c0263a.cRS.setCompoundDrawables(drawable2, null, null, null);
            c0263a.cRT.setBackgroundColor(color3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0263a extends RecyclerView.ViewHolder {
        private TextView bTY;
        private TextView cRP;
        private TextView cRQ;
        private TextView cRR;
        private TextView cRS;
        private View cRT;
        private View cRU;

        public C0263a(View view) {
            super(view);
            this.cRU = view;
            this.bTY = (TextView) view.findViewById(d.g.addr_user_name);
            this.cRP = (TextView) view.findViewById(d.g.addr_tel_number);
            this.cRQ = (TextView) view.findViewById(d.g.addr_detail_region);
            this.cRT = view.findViewById(d.g.addr_divided_line);
            this.cRR = (TextView) view.findViewById(d.g.addr_current_used);
            this.cRS = (TextView) view.findViewById(d.g.addr_edit);
        }
    }
}
