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
public class a extends RecyclerView.Adapter<C0158a> {
    private List<com.baidu.tieba.aiapps.apps.address.c.b> bBx = new ArrayList();
    private b bBy;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface b {
        void b(com.baidu.tieba.aiapps.apps.address.c.b bVar, String str);

        void hp(int i);

        void hq(int i);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void setDeliveryChooseListener(b bVar) {
        this.bBy = bVar;
    }

    public void al(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        this.bBx = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.bBx.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: h */
    public C0158a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.mContext).inflate(e.h.delivery_choose_item_layout, viewGroup, false);
        a(new C0158a(inflate));
        return new C0158a(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0158a c0158a, final int i) {
        final com.baidu.tieba.aiapps.apps.address.c.b bVar = this.bBx.get(i);
        c0158a.aGD.setText(bVar.userName);
        c0158a.bBA.setText(bVar.bCa);
        c0158a.bBB.setText(bVar.WL());
        c0158a.bBC.setVisibility(bVar.bCg ? 0 : 8);
        c0158a.bBD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bBy != null) {
                    a.this.bBy.b(bVar, "update");
                }
            }
        });
        c0158a.bBD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.2
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
        c0158a.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bBy != null) {
                    a.this.bBy.hp(i);
                }
            }
        });
        c0158a.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (a.this.bBy != null) {
                    a.this.bBy.hq(i);
                    return false;
                }
                return false;
            }
        });
    }

    public void a(C0158a c0158a) {
        if (AiAppNightModeHelper.getNightModeSwitcherState()) {
            int color = AppRuntime.getAppContext().getResources().getColor(e.d.delivery_txt_color_1);
            int color2 = AppRuntime.getAppContext().getResources().getColor(e.d.delivery_txt_color_2);
            int color3 = AppRuntime.getAppContext().getResources().getColor(e.d.delivery_txt_color_3);
            c0158a.itemView.setBackgroundResource(e.f.delivery_list_item_background_selector);
            c0158a.aGD.setTextColor(color);
            c0158a.bBA.setTextColor(color);
            c0158a.bBB.setTextColor(color2);
            c0158a.bBC.setTextColor(color);
            Drawable drawable = AppRuntime.getAppContext().getResources().getDrawable(e.f.delivery_default_used);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            c0158a.bBC.setCompoundDrawables(drawable, null, null, null);
            c0158a.bBD.setTextColor(color);
            Drawable drawable2 = AppRuntime.getAppContext().getResources().getDrawable(e.f.delivery_edit);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            c0158a.bBD.setCompoundDrawables(drawable2, null, null, null);
            c0158a.bBE.setBackgroundColor(color3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0158a extends RecyclerView.ViewHolder {
        private TextView aGD;
        private TextView bBA;
        private TextView bBB;
        private TextView bBC;
        private TextView bBD;
        private View bBE;
        private View bBF;

        public C0158a(View view) {
            super(view);
            this.bBF = view;
            this.aGD = (TextView) view.findViewById(e.g.addr_user_name);
            this.bBA = (TextView) view.findViewById(e.g.addr_tel_number);
            this.bBB = (TextView) view.findViewById(e.g.addr_detail_region);
            this.bBE = view.findViewById(e.g.addr_divided_line);
            this.bBC = (TextView) view.findViewById(e.g.addr_current_used);
            this.bBD = (TextView) view.findViewById(e.g.addr_edit);
        }
    }
}
