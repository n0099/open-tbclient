package com.baidu.tieba.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.ao;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.aq;
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
    private Context f959a;
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
        this.f959a = null;
        this.g = null;
        this.f959a = context;
        this.g = new com.baidu.tieba.util.a(this.f959a);
        int a2 = UtilHelper.a(this.f959a, 40.0f);
        this.g.a(a2, a2);
        this.g.b("_small");
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
                        aq.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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
        View view2;
        if (view == null) {
            View inflate = LayoutInflater.from(this.f959a).inflate(R.layout.chat_list_item, viewGroup, false);
            u uVar2 = new u(this, null);
            uVar2.f960a = (ViewGroup) inflate.findViewById(R.id.chat_item);
            uVar2.b = (ViewGroup) inflate.findViewById(R.id.list_content);
            uVar2.c = (HeadImageView) inflate.findViewById(R.id.chat_head);
            uVar2.d = (TextView) inflate.findViewById(R.id.chat_name);
            uVar2.e = (TextView) inflate.findViewById(R.id.last_chat_content);
            uVar2.f = (TextView) inflate.findViewById(R.id.chat_time);
            uVar2.g = (TextView) inflate.findViewById(R.id.new_message);
            uVar2.h = (ViewGroup) inflate.findViewById(R.id.list_control);
            uVar2.i = (TextView) inflate.findViewById(R.id.list_control_tv);
            uVar2.j = (ProgressBar) inflate.findViewById(R.id.list_control_progress);
            inflate.setTag(uVar2);
            this.f.add(uVar2.j);
            uVar = uVar2;
            view2 = inflate;
        } else {
            uVar = (u) view.getTag();
            view2 = view;
        }
        int an = TiebaApplication.g().an();
        long itemId = getItemId(i);
        if (itemId == -1) {
            ((ViewGroup) view2).setBackgroundResource(0);
            uVar.b.setVisibility(8);
            uVar.h.setVisibility(0);
            if (this.e) {
                uVar.i.setText(R.string.loading);
                uVar.j.setVisibility(0);
            } else {
                uVar.i.setText(R.string.frs_pre);
                uVar.j.setVisibility(8);
            }
            if (an == 1) {
                ao.g((View) uVar.i, (int) R.drawable.btn_w_square_1);
                uVar.i.setTextColor(-8682095);
            } else {
                ao.g((View) uVar.i, (int) R.drawable.btn_w_square);
                uVar.i.setTextColor(-14277082);
            }
        } else if (itemId == -2) {
            ((ViewGroup) view2).setBackgroundResource(0);
            uVar.b.setVisibility(8);
            uVar.h.setVisibility(0);
            if (this.d) {
                uVar.i.setText(R.string.loading);
                uVar.j.setVisibility(0);
            } else {
                uVar.i.setText(R.string.frs_next);
                uVar.j.setVisibility(8);
            }
            if (an == 1) {
                ao.g((View) uVar.i, (int) R.drawable.btn_w_square_1);
                uVar.i.setTextColor(-8682095);
            } else {
                ao.g((View) uVar.i, (int) R.drawable.btn_w_square);
                uVar.i.setTextColor(-14277082);
            }
        } else {
            if (an == 1) {
                ao.g(view2, (int) R.drawable.list_selector_1);
            } else {
                ao.g(view2, (int) R.drawable.list_selector_divider1);
            }
            uVar.b.setVisibility(0);
            uVar.h.setVisibility(8);
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
                        uVar.g.setText(f > 99 ? "" : String.valueOf(f));
                    } else {
                        uVar.g.setVisibility(8);
                    }
                    Date date = new Date();
                    date.setTime(gVar.d());
                    uVar.f.setText(ap.h(date));
                    com.baidu.adp.widget.a.b c = this.g.c(String.valueOf(gVar.c()) + "_small");
                    if (c != null) {
                        c.a(uVar.c);
                    } else {
                        uVar.c.setImageBitmap(com.baidu.tieba.util.e.a((int) R.drawable.person_photo));
                    }
                    uVar.c.setTag(gVar.c());
                    uVar.c.setUserId(gVar.b());
                    uVar.c.setUserName(gVar.g());
                    uVar.c.setOnClickListener(this.h);
                    uVar.c.invalidate();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                int f2 = gVar.f();
                if (an == 1) {
                    uVar.d.setTextColor(-8682086);
                    uVar.e.setTextColor(-11446171);
                    uVar.f.setTextColor(-8682086);
                    if (f2 < 10) {
                        uVar.g.setBackgroundResource(R.drawable.icon_news_prompt_1);
                    } else if (f2 < 100) {
                        uVar.g.setBackgroundResource(R.drawable.icon_news_head_prompt_1);
                    } else {
                        uVar.g.setBackgroundResource(R.drawable.icon_news_head_prompt_more_1);
                        uVar.g.setText("");
                    }
                    uVar.g.setTextColor(-478825);
                } else {
                    uVar.d.setTextColor(-14277082);
                    uVar.e.setTextColor(-10066330);
                    uVar.f.setTextColor(-8682086);
                    if (f2 < 10) {
                        uVar.g.setBackgroundResource(R.drawable.icon_news_prompt);
                    } else if (f2 < 100) {
                        uVar.g.setBackgroundResource(R.drawable.icon_news_head_prompt);
                    } else {
                        uVar.g.setBackgroundResource(R.drawable.icon_news_head_prompt_more);
                        uVar.g.setText("");
                    }
                    uVar.g.setTextColor(-1);
                }
            }
        }
        return view2;
    }
}
