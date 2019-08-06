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
public class a extends RecyclerView.Adapter<C0281a> {
    private List<com.baidu.tieba.aiapps.apps.address.c.b> dbQ = new ArrayList();
    private b dbR;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface b {
        void b(com.baidu.tieba.aiapps.apps.address.c.b bVar, String str);

        void mC(int i);

        void mD(int i);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void setDeliveryChooseListener(b bVar) {
        this.dbR = bVar;
    }

    public void aF(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        this.dbQ = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dbQ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: j */
    public C0281a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.delivery_choose_item_layout, viewGroup, false);
        a(new C0281a(inflate));
        return new C0281a(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0281a c0281a, final int i) {
        final com.baidu.tieba.aiapps.apps.address.c.b bVar = this.dbQ.get(i);
        c0281a.cdg.setText(bVar.userName);
        c0281a.dbT.setText(bVar.dcv);
        c0281a.dbU.setText(bVar.aFb());
        c0281a.dbV.setVisibility(bVar.dcB ? 0 : 8);
        c0281a.dbW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dbR != null) {
                    a.this.dbR.b(bVar, "update");
                }
            }
        });
        c0281a.dbW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.2
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
        c0281a.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dbR != null) {
                    a.this.dbR.mC(i);
                }
            }
        });
        c0281a.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (a.this.dbR != null) {
                    a.this.dbR.mD(i);
                    return false;
                }
                return false;
            }
        });
    }

    public void a(C0281a c0281a) {
        if (com.baidu.swan.apps.u.a.EF().Fe()) {
            int color = AppRuntime.getAppContext().getResources().getColor(R.color.delivery_txt_color_1);
            int color2 = AppRuntime.getAppContext().getResources().getColor(R.color.delivery_txt_color_2);
            int color3 = AppRuntime.getAppContext().getResources().getColor(R.color.delivery_txt_color_3);
            c0281a.itemView.setBackgroundResource(R.drawable.delivery_list_item_background_selector);
            c0281a.cdg.setTextColor(color);
            c0281a.dbT.setTextColor(color);
            c0281a.dbU.setTextColor(color2);
            c0281a.dbV.setTextColor(color);
            Drawable drawable = AppRuntime.getAppContext().getResources().getDrawable(R.drawable.delivery_default_used);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            c0281a.dbV.setCompoundDrawables(drawable, null, null, null);
            c0281a.dbW.setTextColor(color);
            Drawable drawable2 = AppRuntime.getAppContext().getResources().getDrawable(R.drawable.delivery_edit);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            c0281a.dbW.setCompoundDrawables(drawable2, null, null, null);
            c0281a.dbX.setBackgroundColor(color3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0281a extends RecyclerView.ViewHolder {
        private TextView cdg;
        private TextView dbT;
        private TextView dbU;
        private TextView dbV;
        private TextView dbW;
        private View dbX;
        private View dbY;

        public C0281a(View view) {
            super(view);
            this.dbY = view;
            this.cdg = (TextView) view.findViewById(R.id.addr_user_name);
            this.dbT = (TextView) view.findViewById(R.id.addr_tel_number);
            this.dbU = (TextView) view.findViewById(R.id.addr_detail_region);
            this.dbX = view.findViewById(R.id.addr_divided_line);
            this.dbV = (TextView) view.findViewById(R.id.addr_current_used);
            this.dbW = (TextView) view.findViewById(R.id.addr_edit);
        }
    }
}
