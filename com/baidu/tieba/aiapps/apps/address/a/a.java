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
public class a extends RecyclerView.Adapter<C0183a> {
    private List<com.baidu.tieba.aiapps.apps.address.c.b> bCj = new ArrayList();
    private b bCk;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface b {
        void b(com.baidu.tieba.aiapps.apps.address.c.b bVar, String str);

        void hC(int i);

        void hD(int i);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void setDeliveryChooseListener(b bVar) {
        this.bCk = bVar;
    }

    public void ak(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        this.bCj = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.bCj.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: h */
    public C0183a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.mContext).inflate(e.h.delivery_choose_item_layout, viewGroup, false);
        a(new C0183a(inflate));
        return new C0183a(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0183a c0183a, final int i) {
        final com.baidu.tieba.aiapps.apps.address.c.b bVar = this.bCj.get(i);
        c0183a.aHt.setText(bVar.userName);
        c0183a.bCm.setText(bVar.bCM);
        c0183a.bCn.setText(bVar.WV());
        c0183a.bCo.setVisibility(bVar.bCS ? 0 : 8);
        c0183a.bCp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bCk != null) {
                    a.this.bCk.b(bVar, "update");
                }
            }
        });
        c0183a.bCp.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.2
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
        c0183a.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bCk != null) {
                    a.this.bCk.hC(i);
                }
            }
        });
        c0183a.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (a.this.bCk != null) {
                    a.this.bCk.hD(i);
                    return false;
                }
                return false;
            }
        });
    }

    public void a(C0183a c0183a) {
        if (AiAppNightModeHelper.getNightModeSwitcherState()) {
            int color = AppRuntime.getAppContext().getResources().getColor(e.d.delivery_txt_color_1);
            int color2 = AppRuntime.getAppContext().getResources().getColor(e.d.delivery_txt_color_2);
            int color3 = AppRuntime.getAppContext().getResources().getColor(e.d.delivery_txt_color_3);
            c0183a.itemView.setBackgroundResource(e.f.delivery_list_item_background_selector);
            c0183a.aHt.setTextColor(color);
            c0183a.bCm.setTextColor(color);
            c0183a.bCn.setTextColor(color2);
            c0183a.bCo.setTextColor(color);
            Drawable drawable = AppRuntime.getAppContext().getResources().getDrawable(e.f.delivery_default_used);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            c0183a.bCo.setCompoundDrawables(drawable, null, null, null);
            c0183a.bCp.setTextColor(color);
            Drawable drawable2 = AppRuntime.getAppContext().getResources().getDrawable(e.f.delivery_edit);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            c0183a.bCp.setCompoundDrawables(drawable2, null, null, null);
            c0183a.bCq.setBackgroundColor(color3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0183a extends RecyclerView.ViewHolder {
        private TextView aHt;
        private TextView bCm;
        private TextView bCn;
        private TextView bCo;
        private TextView bCp;
        private View bCq;
        private View bCr;

        public C0183a(View view) {
            super(view);
            this.bCr = view;
            this.aHt = (TextView) view.findViewById(e.g.addr_user_name);
            this.bCm = (TextView) view.findViewById(e.g.addr_tel_number);
            this.bCn = (TextView) view.findViewById(e.g.addr_detail_region);
            this.bCq = view.findViewById(e.g.addr_divided_line);
            this.bCo = (TextView) view.findViewById(e.g.addr_current_used);
            this.bCp = (TextView) view.findViewById(e.g.addr_edit);
        }
    }
}
