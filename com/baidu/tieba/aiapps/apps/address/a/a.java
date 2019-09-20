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
public class a extends RecyclerView.Adapter<C0290a> {
    private List<com.baidu.tieba.aiapps.apps.address.c.b> ddE = new ArrayList();
    private b ddF;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface b {
        void b(com.baidu.tieba.aiapps.apps.address.c.b bVar, String str);

        void mG(int i);

        void mH(int i);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void setDeliveryChooseListener(b bVar) {
        this.ddF = bVar;
    }

    public void aF(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        this.ddE = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.ddE.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: j */
    public C0290a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.delivery_choose_item_layout, viewGroup, false);
        a(new C0290a(inflate));
        return new C0290a(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0290a c0290a, final int i) {
        final com.baidu.tieba.aiapps.apps.address.c.b bVar = this.ddE.get(i);
        c0290a.cdZ.setText(bVar.userName);
        c0290a.ddH.setText(bVar.deh);
        c0290a.ddI.setText(bVar.aFF());
        c0290a.ddJ.setVisibility(bVar.den ? 0 : 8);
        c0290a.ddK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ddF != null) {
                    a.this.ddF.b(bVar, "update");
                }
            }
        });
        c0290a.ddK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.2
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
        c0290a.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ddF != null) {
                    a.this.ddF.mG(i);
                }
            }
        });
        c0290a.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (a.this.ddF != null) {
                    a.this.ddF.mH(i);
                    return false;
                }
                return false;
            }
        });
    }

    public void a(C0290a c0290a) {
        if (com.baidu.swan.apps.u.a.EJ().Fi()) {
            int color = AppRuntime.getAppContext().getResources().getColor(R.color.delivery_txt_color_1);
            int color2 = AppRuntime.getAppContext().getResources().getColor(R.color.delivery_txt_color_2);
            int color3 = AppRuntime.getAppContext().getResources().getColor(R.color.delivery_txt_color_3);
            c0290a.itemView.setBackgroundResource(R.drawable.delivery_list_item_background_selector);
            c0290a.cdZ.setTextColor(color);
            c0290a.ddH.setTextColor(color);
            c0290a.ddI.setTextColor(color2);
            c0290a.ddJ.setTextColor(color);
            Drawable drawable = AppRuntime.getAppContext().getResources().getDrawable(R.drawable.delivery_default_used);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            c0290a.ddJ.setCompoundDrawables(drawable, null, null, null);
            c0290a.ddK.setTextColor(color);
            Drawable drawable2 = AppRuntime.getAppContext().getResources().getDrawable(R.drawable.delivery_edit);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            c0290a.ddK.setCompoundDrawables(drawable2, null, null, null);
            c0290a.ddL.setBackgroundColor(color3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0290a extends RecyclerView.ViewHolder {
        private TextView cdZ;
        private TextView ddH;
        private TextView ddI;
        private TextView ddJ;
        private TextView ddK;
        private View ddL;
        private View ddM;

        public C0290a(View view) {
            super(view);
            this.ddM = view;
            this.cdZ = (TextView) view.findViewById(R.id.addr_user_name);
            this.ddH = (TextView) view.findViewById(R.id.addr_tel_number);
            this.ddI = (TextView) view.findViewById(R.id.addr_detail_region);
            this.ddL = view.findViewById(R.id.addr_divided_line);
            this.ddJ = (TextView) view.findViewById(R.id.addr_current_used);
            this.ddK = (TextView) view.findViewById(R.id.addr_edit);
        }
    }
}
