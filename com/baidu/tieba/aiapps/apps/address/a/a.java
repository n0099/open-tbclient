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
    private List<com.baidu.tieba.aiapps.apps.address.c.b> dbJ = new ArrayList();
    private b dbK;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface b {
        void b(com.baidu.tieba.aiapps.apps.address.c.b bVar, String str);

        void mB(int i);

        void mC(int i);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void setDeliveryChooseListener(b bVar) {
        this.dbK = bVar;
    }

    public void aF(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        this.dbJ = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dbJ.size();
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
        final com.baidu.tieba.aiapps.apps.address.c.b bVar = this.dbJ.get(i);
        c0281a.ccZ.setText(bVar.userName);
        c0281a.dbM.setText(bVar.dcn);
        c0281a.dbN.setText(bVar.aEZ());
        c0281a.dbO.setVisibility(bVar.dct ? 0 : 8);
        c0281a.dbP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dbK != null) {
                    a.this.dbK.b(bVar, "update");
                }
            }
        });
        c0281a.dbP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.2
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
                if (a.this.dbK != null) {
                    a.this.dbK.mB(i);
                }
            }
        });
        c0281a.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (a.this.dbK != null) {
                    a.this.dbK.mC(i);
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
            c0281a.ccZ.setTextColor(color);
            c0281a.dbM.setTextColor(color);
            c0281a.dbN.setTextColor(color2);
            c0281a.dbO.setTextColor(color);
            Drawable drawable = AppRuntime.getAppContext().getResources().getDrawable(R.drawable.delivery_default_used);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            c0281a.dbO.setCompoundDrawables(drawable, null, null, null);
            c0281a.dbP.setTextColor(color);
            Drawable drawable2 = AppRuntime.getAppContext().getResources().getDrawable(R.drawable.delivery_edit);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            c0281a.dbP.setCompoundDrawables(drawable2, null, null, null);
            c0281a.dbQ.setBackgroundColor(color3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0281a extends RecyclerView.ViewHolder {
        private TextView ccZ;
        private TextView dbM;
        private TextView dbN;
        private TextView dbO;
        private TextView dbP;
        private View dbQ;
        private View dbR;

        public C0281a(View view) {
            super(view);
            this.dbR = view;
            this.ccZ = (TextView) view.findViewById(R.id.addr_user_name);
            this.dbM = (TextView) view.findViewById(R.id.addr_tel_number);
            this.dbN = (TextView) view.findViewById(R.id.addr_detail_region);
            this.dbQ = view.findViewById(R.id.addr_divided_line);
            this.dbO = (TextView) view.findViewById(R.id.addr_current_used);
            this.dbP = (TextView) view.findViewById(R.id.addr_edit);
        }
    }
}
