package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.MsgCacheData;
import java.util.List;
/* loaded from: classes.dex */
public class bt extends BaseAdapter {
    private Context a;
    private int g;
    private com.baidu.tieba.util.i j;
    private List<com.baidu.tieba.im.message.b> b = null;
    private Long c = 0L;
    private long d = 0;
    private Long e = null;
    private Long f = null;
    private com.baidu.adp.lib.b.a h = null;
    private com.baidu.adp.lib.b.b i = null;

    public bt(Context context, int i) {
        this.g = 0;
        this.j = null;
        this.a = context;
        this.j = new com.baidu.tieba.util.i(context);
        this.g = i;
    }

    public void a() {
        this.c = Long.valueOf(System.currentTimeMillis() / 1000);
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.h = aVar;
    }

    public void a(com.baidu.adp.lib.b.b bVar) {
        this.i = bVar;
    }

    public void a(long j) {
        this.d = j;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size;
        if (this.b == null || (size = this.b.size()) < 0) {
            return 0;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.b == null || i >= this.b.size()) {
            return null;
        }
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        as asVar;
        MsgrightView msgrightView;
        MsgleftView msgleftView;
        MsgleftView msgleftView2 = null;
        int itemViewType = getItemViewType(i);
        com.baidu.tieba.im.message.b bVar = this.b.get(i);
        if (bVar.n() == null) {
            bVar.a(new MsgCacheData());
        }
        switch (itemViewType) {
            case 0:
                if (view == null) {
                    msgleftView = new MsgleftView(this.a, this.g);
                    view = msgleftView.a();
                } else {
                    msgleftView = (MsgleftView) view.getTag();
                }
                bVar.n().setIs_left(1);
                msgleftView.a(this.j);
                msgleftView2 = msgleftView;
                asVar = null;
                break;
            case 1:
                if (view == null) {
                    msgrightView = new MsgrightView(this.a);
                    view = msgrightView.a();
                } else {
                    msgrightView = (MsgrightView) view.getTag();
                }
                msgrightView.a(this.j);
                bVar.n().setIs_left(0);
                msgleftView2 = msgrightView;
                asVar = null;
                break;
            case 2:
                if (view == null) {
                    asVar = new as(this.a);
                    view = asVar.a();
                    break;
                } else {
                    asVar = (as) view.getTag();
                    break;
                }
            default:
                com.baidu.adp.lib.h.e.b(getClass().getName(), "getView", "view type error");
                asVar = null;
                break;
        }
        if (msgleftView2 != null) {
            msgleftView2.a(this.h);
            msgleftView2.a(this.i);
            msgleftView2.b(i);
            msgleftView2.a(this.d);
            msgleftView2.c(this.c.longValue());
            if (i > 0) {
                msgleftView2.b(this.b.get(i - 1).o());
            } else {
                msgleftView2.b(0L);
            }
            msgleftView2.a(viewGroup, bVar);
            msgleftView2.b(viewGroup, bVar);
        } else if (asVar != null) {
            asVar.a(bVar);
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        try {
            com.baidu.tieba.im.message.b bVar = this.b.get(i);
            if (bVar != null) {
                if (bVar.h() == 11) {
                    return 2;
                }
                if (bVar.f() != null && bVar.f().getId() != null) {
                    return bVar.f().getId().equals(TiebaApplication.B()) ? 1 : 0;
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.b(getClass().getName(), "getItemViewType", e.getMessage());
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public List<com.baidu.tieba.im.message.b> b() {
        return this.b;
    }

    public void a(com.baidu.tieba.im.message.b bVar) {
        notifyDataSetChanged();
    }

    public void a(List<com.baidu.tieba.im.message.b> list) {
        this.b = list;
        int size = this.b.size();
        if (size > 0) {
            this.f = Long.valueOf(this.b.get(size - 1).k());
            this.e = Long.valueOf(this.b.get(0).k());
            return;
        }
        this.f = null;
        this.e = null;
    }
}
