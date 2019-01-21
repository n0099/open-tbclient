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
import com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeHelper;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends RecyclerView.Adapter<C0193a> {
    private List<com.baidu.tieba.aiapps.apps.address.c.b> bGt = new ArrayList();
    private b bGu;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface b {
        void b(com.baidu.tieba.aiapps.apps.address.c.b bVar, String str);

        void hR(int i);

        void hS(int i);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void setDeliveryChooseListener(b bVar) {
        this.bGu = bVar;
    }

    public void al(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        this.bGt = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.bGt.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: h */
    public C0193a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.mContext).inflate(e.h.delivery_choose_item_layout, viewGroup, false);
        a(new C0193a(inflate));
        return new C0193a(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0193a c0193a, final int i) {
        final com.baidu.tieba.aiapps.apps.address.c.b bVar = this.bGt.get(i);
        c0193a.aLy.setText(bVar.userName);
        c0193a.bGw.setText(bVar.bGW);
        c0193a.bGx.setText(bVar.Yx());
        c0193a.bGy.setVisibility(bVar.bHc ? 0 : 8);
        c0193a.bGz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bGu != null) {
                    a.this.bGu.b(bVar, "update");
                }
            }
        });
        c0193a.bGz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.2
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
        c0193a.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bGu != null) {
                    a.this.bGu.hR(i);
                }
            }
        });
        c0193a.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (a.this.bGu != null) {
                    a.this.bGu.hS(i);
                    return false;
                }
                return false;
            }
        });
    }

    public void a(C0193a c0193a) {
        if (AiAppNightModeHelper.getNightModeSwitcherState()) {
            int color = AppRuntime.getAppContext().getResources().getColor(e.d.delivery_txt_color_1);
            int color2 = AppRuntime.getAppContext().getResources().getColor(e.d.delivery_txt_color_2);
            int color3 = AppRuntime.getAppContext().getResources().getColor(e.d.delivery_txt_color_3);
            c0193a.itemView.setBackgroundResource(e.f.delivery_list_item_background_selector);
            c0193a.aLy.setTextColor(color);
            c0193a.bGw.setTextColor(color);
            c0193a.bGx.setTextColor(color2);
            c0193a.bGy.setTextColor(color);
            Drawable drawable = AppRuntime.getAppContext().getResources().getDrawable(e.f.delivery_default_used);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            c0193a.bGy.setCompoundDrawables(drawable, null, null, null);
            c0193a.bGz.setTextColor(color);
            Drawable drawable2 = AppRuntime.getAppContext().getResources().getDrawable(e.f.delivery_edit);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            c0193a.bGz.setCompoundDrawables(drawable2, null, null, null);
            c0193a.bGA.setBackgroundColor(color3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0193a extends RecyclerView.ViewHolder {
        private TextView aLy;
        private View bGA;
        private View bGB;
        private TextView bGw;
        private TextView bGx;
        private TextView bGy;
        private TextView bGz;

        public C0193a(View view) {
            super(view);
            this.bGB = view;
            this.aLy = (TextView) view.findViewById(e.g.addr_user_name);
            this.bGw = (TextView) view.findViewById(e.g.addr_tel_number);
            this.bGx = (TextView) view.findViewById(e.g.addr_detail_region);
            this.bGA = view.findViewById(e.g.addr_divided_line);
            this.bGy = (TextView) view.findViewById(e.g.addr_current_used);
            this.bGz = (TextView) view.findViewById(e.g.addr_edit);
        }
    }
}
