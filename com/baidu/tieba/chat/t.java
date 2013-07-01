package com.baidu.tieba.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes.dex */
public class t extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f737a;
    private com.baidu.tieba.util.a g;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private View.OnClickListener h = null;
    private List i = null;
    private ArrayList f = new ArrayList();

    public void a(View.OnClickListener onClickListener) {
        this.h = onClickListener;
    }

    public com.baidu.tieba.util.a a() {
        return this.g;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void b(boolean z) {
        this.e = z;
    }

    public void c(boolean z) {
        this.b = z;
    }

    public void d(boolean z) {
        this.c = z;
    }

    public t(Context context) {
        this.f737a = null;
        this.g = null;
        this.f737a = context;
        this.g = new com.baidu.tieba.util.a(this.f737a);
        int a2 = com.baidu.tieba.util.ab.a(this.f737a, 40.0f);
        this.g.a(a2, a2);
        this.g.a("_small");
    }

    public void b() {
        if (this.f != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f.size()) {
                    try {
                        ((ProgressBar) this.f.get(i2)).setVisibility(8);
                    } catch (Exception e) {
                        com.baidu.tieba.util.z.b(getClass().getName(), "releaseProgressBar", e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.f.clear();
                    return;
                }
            }
        }
    }

    public void a(List list) {
        this.i = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.i != null) {
            int size = this.i.size();
            if (this.b) {
                size++;
            }
            if (this.c) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.i.size()) {
            return null;
        }
        return this.i.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        int i2 = this.b ? i - 1 : i;
        if (this.c && i == getCount() - 1) {
            i2 = -2;
        }
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        u uVar;
        if (view == null) {
            view = LayoutInflater.from(this.f737a).inflate(R.layout.chat_list_item, (ViewGroup) null);
            uVar = new u(this, null);
            uVar.f738a = (FrameLayout) view.findViewById(R.id.chat_item);
            uVar.b = (LinearLayout) view.findViewById(R.id.list_content);
            uVar.c = (HeadImageView) view.findViewById(R.id.chat_head);
            uVar.d = (TextView) view.findViewById(R.id.chat_name);
            uVar.e = (TextView) view.findViewById(R.id.last_chat_content);
            uVar.f = (TextView) view.findViewById(R.id.chat_time);
            uVar.g = (TextView) view.findViewById(R.id.new_message);
            uVar.h = (ImageView) view.findViewById(R.id.splitter);
            uVar.i = (RelativeLayout) view.findViewById(R.id.list_control);
            uVar.j = (TextView) view.findViewById(R.id.list_control_tv);
            uVar.k = (ProgressBar) view.findViewById(R.id.list_control_progress);
            view.setTag(uVar);
            this.f.add(uVar.k);
        } else {
            uVar = (u) view.getTag();
        }
        int at = TiebaApplication.f().at();
        long itemId = getItemId(i);
        if (itemId == -1) {
            uVar.b.setVisibility(8);
            uVar.i.setVisibility(0);
            if (this.e) {
                uVar.j.setText(R.string.loading);
                uVar.k.setVisibility(0);
            } else {
                uVar.j.setText(R.string.frs_pre);
                uVar.k.setVisibility(8);
            }
            if (at == 1) {
                uVar.i.setBackgroundResource(R.drawable.bg_list_all_1);
            } else {
                uVar.i.setBackgroundResource(R.drawable.bg_list_all);
            }
            com.baidu.tieba.util.x.b(uVar.j, at);
        } else if (itemId == -2) {
            uVar.b.setVisibility(8);
            uVar.i.setVisibility(0);
            if (this.d) {
                uVar.j.setText(R.string.loading);
                uVar.k.setVisibility(0);
            } else {
                uVar.j.setText(R.string.frs_next);
                uVar.k.setVisibility(8);
            }
            if (at == 1) {
                uVar.i.setBackgroundResource(R.drawable.bg_list_all_1);
            } else {
                uVar.i.setBackgroundResource(R.drawable.bg_list_all);
            }
            com.baidu.tieba.util.x.b(uVar.j, at);
        } else {
            uVar.b.setVisibility(0);
            uVar.i.setVisibility(8);
            com.baidu.tieba.data.a.g gVar = (com.baidu.tieba.data.a.g) getItem(i);
            if (gVar != null) {
                try {
                    uVar.d.setText(gVar.g());
                    JSONArray jSONArray = new JSONArray(gVar.e());
                    if (jSONArray != null && jSONArray.length() >= 1) {
                        uVar.e.setText(jSONArray.optJSONObject(0).optString("text"));
                    } else {
                        uVar.e.setText((CharSequence) null);
                    }
                    int f = gVar.f();
                    if (f > 0) {
                        uVar.g.setVisibility(0);
                        uVar.g.setText(f > 99 ? "99+" : String.valueOf(f));
                    } else {
                        uVar.g.setVisibility(8);
                    }
                    Date date = new Date();
                    date.setTime(gVar.d());
                    uVar.f.setText(com.baidu.tieba.util.y.e(date));
                    com.baidu.adp.widget.a.b b = this.g.b(String.valueOf(gVar.c()) + "_small");
                    if (b != null) {
                        b.b(uVar.c);
                    } else {
                        uVar.c.setImageBitmap(com.baidu.tieba.util.d.a((int) R.drawable.person_photo));
                    }
                    uVar.c.setTag(gVar.c());
                    uVar.c.setUserId(gVar.b());
                    uVar.c.setUserName(gVar.g());
                    uVar.c.setOnClickListener(this.h);
                    uVar.c.invalidate();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (at == 1) {
                    uVar.f738a.setBackgroundColor(-13618114);
                    uVar.d.setTextColor(-8682086);
                    uVar.e.setTextColor(-11446171);
                    uVar.f.setTextColor(-8682086);
                    uVar.g.setBackgroundResource(R.drawable.but_icon_point);
                    uVar.g.setTextColor(-478825);
                    uVar.h.setBackgroundColor(-14210253);
                } else {
                    uVar.f738a.setBackgroundColor(-197380);
                    uVar.d.setTextColor(-14277082);
                    uVar.e.setTextColor(-10066330);
                    uVar.f.setTextColor(-8682086);
                    uVar.g.setBackgroundResource(R.drawable.but_icon_point);
                    uVar.g.setTextColor(-1);
                    uVar.h.setBackgroundColor(-1052430);
                }
            }
        }
        return view;
    }
}
