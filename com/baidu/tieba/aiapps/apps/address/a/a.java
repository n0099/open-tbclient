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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends RecyclerView.Adapter<C0278a> {
    private List<com.baidu.tieba.aiapps.apps.address.c.b> daj = new ArrayList();
    private b dak;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface b {
        void b(com.baidu.tieba.aiapps.apps.address.c.b bVar, String str);

        void mu(int i);

        void mv(int i);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void setDeliveryChooseListener(b bVar) {
        this.dak = bVar;
    }

    public void aF(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        this.daj = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.daj.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: j */
    public C0278a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.delivery_choose_item_layout, viewGroup, false);
        a(new C0278a(inflate));
        return new C0278a(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0278a c0278a, final int i) {
        final com.baidu.tieba.aiapps.apps.address.c.b bVar = this.daj.get(i);
        c0278a.cbV.setText(bVar.userName);
        c0278a.dam.setText(bVar.daO);
        c0278a.dan.setText(bVar.aDJ());
        c0278a.dao.setVisibility(bVar.daU ? 0 : 8);
        c0278a.dap.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dak != null) {
                    a.this.dak.b(bVar, "update");
                }
            }
        });
        c0278a.dap.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.2
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
        c0278a.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dak != null) {
                    a.this.dak.mu(i);
                }
            }
        });
        c0278a.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (a.this.dak != null) {
                    a.this.dak.mv(i);
                    return false;
                }
                return false;
            }
        });
    }

    public void a(C0278a c0278a) {
        if (com.baidu.swan.apps.u.a.DW().Ev()) {
            int color = AppRuntime.getAppContext().getResources().getColor(R.color.delivery_txt_color_1);
            int color2 = AppRuntime.getAppContext().getResources().getColor(R.color.delivery_txt_color_2);
            int color3 = AppRuntime.getAppContext().getResources().getColor(R.color.delivery_txt_color_3);
            c0278a.itemView.setBackgroundResource(R.drawable.delivery_list_item_background_selector);
            c0278a.cbV.setTextColor(color);
            c0278a.dam.setTextColor(color);
            c0278a.dan.setTextColor(color2);
            c0278a.dao.setTextColor(color);
            Drawable drawable = AppRuntime.getAppContext().getResources().getDrawable(R.drawable.delivery_default_used);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            c0278a.dao.setCompoundDrawables(drawable, null, null, null);
            c0278a.dap.setTextColor(color);
            Drawable drawable2 = AppRuntime.getAppContext().getResources().getDrawable(R.drawable.delivery_edit);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            c0278a.dap.setCompoundDrawables(drawable2, null, null, null);
            c0278a.daq.setBackgroundColor(color3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0278a extends RecyclerView.ViewHolder {
        private TextView cbV;
        private TextView dam;
        private TextView dan;
        private TextView dao;
        private TextView dap;
        private View daq;
        private View dar;

        public C0278a(View view) {
            super(view);
            this.dar = view;
            this.cbV = (TextView) view.findViewById(R.id.addr_user_name);
            this.dam = (TextView) view.findViewById(R.id.addr_tel_number);
            this.dan = (TextView) view.findViewById(R.id.addr_detail_region);
            this.daq = view.findViewById(R.id.addr_divided_line);
            this.dao = (TextView) view.findViewById(R.id.addr_current_used);
            this.dap = (TextView) view.findViewById(R.id.addr_edit);
        }
    }
}
