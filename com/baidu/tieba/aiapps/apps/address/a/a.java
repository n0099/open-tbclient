package com.baidu.tieba.aiapps.apps.address.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends RecyclerView.Adapter<C0322a> {
    private List<com.baidu.tieba.aiapps.apps.address.c.b> dmh = new ArrayList();
    private b dmi;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface b {
        void b(com.baidu.tieba.aiapps.apps.address.c.b bVar, String str);

        void lK(int i);

        void lL(int i);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void setDeliveryChooseListener(b bVar) {
        this.dmi = bVar;
    }

    public void aY(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        this.dmh = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dmh.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: h */
    public C0322a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.delivery_choose_item_layout, viewGroup, false);
        a(new C0322a(inflate));
        return new C0322a(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0322a c0322a, final int i) {
        final com.baidu.tieba.aiapps.apps.address.c.b bVar = this.dmh.get(i);
        c0322a.crw.setText(bVar.userName);
        c0322a.dmk.setText(bVar.dmK);
        c0322a.dml.setText(bVar.aFP());
        c0322a.dmm.setVisibility(bVar.dmQ ? 0 : 8);
        c0322a.dmn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dmi != null) {
                    a.this.dmi.b(bVar, IMTrack.DbBuilder.ACTION_UPDATE);
                }
            }
        });
        c0322a.dmn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.2
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
        c0322a.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dmi != null) {
                    a.this.dmi.lK(i);
                }
            }
        });
        c0322a.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (a.this.dmi != null) {
                    a.this.dmi.lL(i);
                    return false;
                }
                return false;
            }
        });
    }

    public void a(C0322a c0322a) {
        if (com.baidu.swan.apps.u.a.JE().Kd()) {
            int color = AppRuntime.getAppContext().getResources().getColor(R.color.delivery_txt_color_1);
            int color2 = AppRuntime.getAppContext().getResources().getColor(R.color.delivery_txt_color_2);
            int color3 = AppRuntime.getAppContext().getResources().getColor(R.color.delivery_txt_color_3);
            c0322a.itemView.setBackgroundResource(R.drawable.delivery_list_item_background_selector);
            c0322a.crw.setTextColor(color);
            c0322a.dmk.setTextColor(color);
            c0322a.dml.setTextColor(color2);
            c0322a.dmm.setTextColor(color);
            Drawable drawable = AppRuntime.getAppContext().getResources().getDrawable(R.drawable.delivery_default_used);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            c0322a.dmm.setCompoundDrawables(drawable, null, null, null);
            c0322a.dmn.setTextColor(color);
            Drawable drawable2 = AppRuntime.getAppContext().getResources().getDrawable(R.drawable.delivery_edit);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            c0322a.dmn.setCompoundDrawables(drawable2, null, null, null);
            c0322a.dmo.setBackgroundColor(color3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0322a extends RecyclerView.ViewHolder {
        private TextView crw;
        private TextView dmk;
        private TextView dml;
        private TextView dmm;
        private TextView dmn;
        private View dmo;
        private View dmp;

        public C0322a(View view) {
            super(view);
            this.dmp = view;
            this.crw = (TextView) view.findViewById(R.id.addr_user_name);
            this.dmk = (TextView) view.findViewById(R.id.addr_tel_number);
            this.dml = (TextView) view.findViewById(R.id.addr_detail_region);
            this.dmo = view.findViewById(R.id.addr_divided_line);
            this.dmm = (TextView) view.findViewById(R.id.addr_current_used);
            this.dmn = (TextView) view.findViewById(R.id.addr_edit);
        }
    }
}
