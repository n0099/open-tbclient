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
    private List<com.baidu.tieba.aiapps.apps.address.c.b> dmY = new ArrayList();
    private b dmZ;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface b {
        void b(com.baidu.tieba.aiapps.apps.address.c.b bVar, String str);

        void lL(int i);

        void lM(int i);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void setDeliveryChooseListener(b bVar) {
        this.dmZ = bVar;
    }

    public void aY(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        this.dmY = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dmY.size();
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
        final com.baidu.tieba.aiapps.apps.address.c.b bVar = this.dmY.get(i);
        c0322a.csn.setText(bVar.userName);
        c0322a.dnb.setText(bVar.dnC);
        c0322a.dnc.setText(bVar.aFR());
        c0322a.dnd.setVisibility(bVar.dnI ? 0 : 8);
        c0322a.dne.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dmZ != null) {
                    a.this.dmZ.b(bVar, IMTrack.DbBuilder.ACTION_UPDATE);
                }
            }
        });
        c0322a.dne.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.2
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
                if (a.this.dmZ != null) {
                    a.this.dmZ.lL(i);
                }
            }
        });
        c0322a.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.a.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (a.this.dmZ != null) {
                    a.this.dmZ.lM(i);
                    return false;
                }
                return false;
            }
        });
    }

    public void a(C0322a c0322a) {
        if (com.baidu.swan.apps.u.a.JD().Kc()) {
            int color = AppRuntime.getAppContext().getResources().getColor(R.color.delivery_txt_color_1);
            int color2 = AppRuntime.getAppContext().getResources().getColor(R.color.delivery_txt_color_2);
            int color3 = AppRuntime.getAppContext().getResources().getColor(R.color.delivery_txt_color_3);
            c0322a.itemView.setBackgroundResource(R.drawable.delivery_list_item_background_selector);
            c0322a.csn.setTextColor(color);
            c0322a.dnb.setTextColor(color);
            c0322a.dnc.setTextColor(color2);
            c0322a.dnd.setTextColor(color);
            Drawable drawable = AppRuntime.getAppContext().getResources().getDrawable(R.drawable.delivery_default_used);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            c0322a.dnd.setCompoundDrawables(drawable, null, null, null);
            c0322a.dne.setTextColor(color);
            Drawable drawable2 = AppRuntime.getAppContext().getResources().getDrawable(R.drawable.delivery_edit);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            c0322a.dne.setCompoundDrawables(drawable2, null, null, null);
            c0322a.dnf.setBackgroundColor(color3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0322a extends RecyclerView.ViewHolder {
        private TextView csn;
        private TextView dnb;
        private TextView dnc;
        private TextView dnd;
        private TextView dne;
        private View dnf;
        private View dng;

        public C0322a(View view) {
            super(view);
            this.dng = view;
            this.csn = (TextView) view.findViewById(R.id.addr_user_name);
            this.dnb = (TextView) view.findViewById(R.id.addr_tel_number);
            this.dnc = (TextView) view.findViewById(R.id.addr_detail_region);
            this.dnf = view.findViewById(R.id.addr_divided_line);
            this.dnd = (TextView) view.findViewById(R.id.addr_current_used);
            this.dne = (TextView) view.findViewById(R.id.addr_edit);
        }
    }
}
