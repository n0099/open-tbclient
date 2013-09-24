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
import com.baidu.tieba.util.as;
import com.baidu.tieba.util.at;
import com.baidu.tieba.util.av;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes.dex */
public class l extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f968a;
    private com.baidu.tieba.util.a g;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private View.OnClickListener h = null;
    private List<com.baidu.tieba.data.a.g> i = null;
    private ArrayList<ProgressBar> f = new ArrayList<>();

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

    public l(Context context) {
        this.f968a = null;
        this.g = null;
        this.f968a = context;
        this.g = new com.baidu.tieba.util.a(this.f968a);
        int a2 = UtilHelper.a(this.f968a, 40.0f);
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
                        this.f.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        av.b(getClass().getName(), "releaseProgressBar", e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.f.clear();
                    return;
                }
            }
        }
    }

    public void a(List<com.baidu.tieba.data.a.g> list) {
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
        m mVar;
        View view2;
        if (view == null) {
            View inflate = LayoutInflater.from(this.f968a).inflate(R.layout.chat_list_item, viewGroup, false);
            m mVar2 = new m(this, null);
            mVar2.f969a = (ViewGroup) inflate.findViewById(R.id.chat_item);
            mVar2.b = (ViewGroup) inflate.findViewById(R.id.list_content);
            mVar2.c = (HeadImageView) inflate.findViewById(R.id.chat_head);
            mVar2.d = (TextView) inflate.findViewById(R.id.chat_name);
            mVar2.e = (TextView) inflate.findViewById(R.id.last_chat_content);
            mVar2.f = (TextView) inflate.findViewById(R.id.chat_time);
            mVar2.g = (TextView) inflate.findViewById(R.id.new_message);
            mVar2.h = (ViewGroup) inflate.findViewById(R.id.list_control);
            mVar2.i = (TextView) inflate.findViewById(R.id.list_control_tv);
            mVar2.j = (ProgressBar) inflate.findViewById(R.id.list_control_progress);
            inflate.setTag(mVar2);
            this.f.add(mVar2.j);
            mVar = mVar2;
            view2 = inflate;
        } else {
            mVar = (m) view.getTag();
            view2 = view;
        }
        int ap = TiebaApplication.g().ap();
        long itemId = getItemId(i);
        if (itemId == -1) {
            ((ViewGroup) view2).setBackgroundResource(0);
            mVar.b.setVisibility(8);
            mVar.h.setVisibility(0);
            if (this.e) {
                mVar.i.setText(R.string.loading);
                mVar.j.setVisibility(0);
            } else {
                mVar.i.setText(R.string.frs_pre);
                mVar.j.setVisibility(8);
            }
            if (ap == 1) {
                as.e((View) mVar.i, (int) R.drawable.btn_w_square_1);
                mVar.i.setTextColor(-8682095);
            } else {
                as.e((View) mVar.i, (int) R.drawable.btn_w_square);
                mVar.i.setTextColor(-14277082);
            }
        } else if (itemId == -2) {
            ((ViewGroup) view2).setBackgroundResource(0);
            mVar.b.setVisibility(8);
            mVar.h.setVisibility(0);
            if (this.d) {
                mVar.i.setText(R.string.loading);
                mVar.j.setVisibility(0);
            } else {
                mVar.i.setText(R.string.frs_next);
                mVar.j.setVisibility(8);
            }
            if (ap == 1) {
                as.e((View) mVar.i, (int) R.drawable.btn_w_square_1);
                mVar.i.setTextColor(-8682095);
            } else {
                as.e((View) mVar.i, (int) R.drawable.btn_w_square);
                mVar.i.setTextColor(-14277082);
            }
        } else {
            if (ap == 1) {
                as.e(view2, (int) R.drawable.list_selector_1);
            } else {
                as.e(view2, (int) R.drawable.list_selector_divider1);
            }
            mVar.b.setVisibility(0);
            mVar.h.setVisibility(8);
            com.baidu.tieba.data.a.g gVar = (com.baidu.tieba.data.a.g) getItem(i);
            if (gVar != null) {
                try {
                    mVar.d.setText(gVar.g());
                    JSONArray jSONArray = new JSONArray(gVar.e());
                    if (jSONArray != null && jSONArray.length() >= 1) {
                        mVar.e.setText(jSONArray.optJSONObject(0).optString("text"));
                    } else {
                        mVar.e.setText((CharSequence) null);
                    }
                    int f = gVar.f();
                    if (f > 0) {
                        mVar.g.setVisibility(0);
                        mVar.g.setText(f > 99 ? "" : String.valueOf(f));
                    } else {
                        mVar.g.setVisibility(8);
                    }
                    Date date = new Date();
                    date.setTime(gVar.d());
                    mVar.f.setText(at.j(date));
                    com.baidu.adp.widget.a.c c = this.g.c(String.valueOf(gVar.c()) + "_small");
                    if (c != null) {
                        c.a(mVar.c);
                    } else {
                        mVar.c.setImageBitmap(com.baidu.tieba.util.e.a((int) R.drawable.person_photo));
                    }
                    mVar.c.setTag(gVar.c());
                    mVar.c.setUserId(gVar.b());
                    mVar.c.setUserName(gVar.g());
                    mVar.c.setOnClickListener(this.h);
                    mVar.c.invalidate();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                int f2 = gVar.f();
                if (ap == 1) {
                    mVar.d.setTextColor(-8682086);
                    mVar.e.setTextColor(-11446171);
                    mVar.f.setTextColor(-8682086);
                    if (f2 < 10) {
                        mVar.g.setBackgroundResource(R.drawable.icon_news_prompt_1);
                    } else if (f2 < 100) {
                        mVar.g.setBackgroundResource(R.drawable.icon_news_head_prompt_1);
                    } else {
                        mVar.g.setBackgroundResource(R.drawable.icon_news_head_prompt_more_1);
                        mVar.g.setText("");
                    }
                    mVar.g.setTextColor(-478825);
                } else {
                    mVar.d.setTextColor(-14277082);
                    mVar.e.setTextColor(-10066330);
                    mVar.f.setTextColor(-8682086);
                    if (f2 < 10) {
                        mVar.g.setBackgroundResource(R.drawable.icon_news_prompt);
                    } else if (f2 < 100) {
                        mVar.g.setBackgroundResource(R.drawable.icon_news_head_prompt);
                    } else {
                        mVar.g.setBackgroundResource(R.drawable.icon_news_head_prompt_more);
                        mVar.g.setText("");
                    }
                    mVar.g.setTextColor(-1);
                }
            }
        }
        return view2;
    }
}
