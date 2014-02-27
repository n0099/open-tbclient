package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.MsgCacheData;
import java.util.List;
/* loaded from: classes.dex */
public final class cg extends BaseAdapter {
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

    public cg(Context context, int i) {
        this.g = 0;
        this.j = null;
        this.a = context;
        this.j = new com.baidu.tieba.util.i(context);
        this.g = i;
    }

    public final void a() {
        this.c = Long.valueOf(System.currentTimeMillis() / 1000);
    }

    public final void a(com.baidu.adp.lib.b.a aVar) {
        this.h = aVar;
    }

    public final void a(com.baidu.adp.lib.b.b bVar) {
        this.i = bVar;
    }

    public final void a(long j) {
        this.d = j;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        int size;
        if (this.b == null || (size = this.b.size()) < 0) {
            return 0;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (this.b == null || i >= this.b.size()) {
            return null;
        }
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        MsgActivityView msgActivityView;
        bq bqVar;
        bp bpVar;
        MsgleftView msgleftView;
        MsgrightView msgrightView;
        MsgleftView msgleftView2;
        bi biVar = null;
        int itemViewType = getItemViewType(i);
        com.baidu.tieba.im.message.b bVar = this.b.get(i);
        if (bVar.o() == null) {
            bVar.a(new MsgCacheData());
        }
        switch (itemViewType) {
            case 0:
                if (view == null) {
                    msgleftView2 = new MsgleftView(this.a, this.g);
                    view = msgleftView2.a();
                } else {
                    msgleftView2 = (MsgleftView) view.getTag();
                }
                bVar.o().setIs_left(1);
                msgleftView2.a(this.j);
                bqVar = null;
                bpVar = null;
                msgleftView = msgleftView2;
                msgActivityView = null;
                break;
            case 1:
                if (view == null) {
                    msgrightView = new MsgrightView(this.a);
                    view = msgrightView.a();
                } else {
                    msgrightView = (MsgrightView) view.getTag();
                }
                msgrightView.a(this.j);
                bVar.o().setIs_left(0);
                bqVar = null;
                bpVar = null;
                msgleftView = msgrightView;
                msgActivityView = null;
                break;
            case 2:
                if (view == null) {
                    bp bpVar2 = new bp(this.a);
                    view = bpVar2.a();
                    bqVar = null;
                    bpVar = bpVar2;
                    msgleftView = null;
                    msgActivityView = null;
                    break;
                } else {
                    bqVar = null;
                    bpVar = (bp) view.getTag();
                    msgleftView = null;
                    msgActivityView = null;
                    break;
                }
            case 3:
                if (view == null) {
                    bq bqVar2 = new bq(this.a);
                    view = bqVar2.a();
                    bqVar = bqVar2;
                    bpVar = null;
                    msgleftView = null;
                    msgActivityView = null;
                    break;
                } else {
                    bqVar = (bq) view.getTag();
                    bpVar = null;
                    msgleftView = null;
                    msgActivityView = null;
                    break;
                }
            case 4:
                if (view == null) {
                    bi biVar2 = new bi(this.a);
                    view = biVar2.a();
                    bqVar = null;
                    bpVar = null;
                    msgleftView = null;
                    msgActivityView = null;
                    biVar = biVar2;
                    break;
                } else {
                    bqVar = null;
                    bpVar = null;
                    msgleftView = null;
                    msgActivityView = null;
                    biVar = (bi) view.getTag();
                    break;
                }
            case 5:
                if (view == null) {
                    msgActivityView = new MsgActivityView(this.a);
                    view = msgActivityView.a();
                    bqVar = null;
                    bpVar = null;
                    msgleftView = null;
                    break;
                } else {
                    msgActivityView = (MsgActivityView) view.getTag();
                    bqVar = null;
                    bpVar = null;
                    msgleftView = null;
                    break;
                }
            default:
                com.baidu.adp.lib.util.e.b(getClass().getName(), "getView", "view type error");
                msgActivityView = null;
                bqVar = null;
                bpVar = null;
                msgleftView = null;
                break;
        }
        if (msgleftView != null) {
            msgleftView.a(this.h);
            msgleftView.a(this.i);
            msgleftView.b(i);
            msgleftView.a(this.d);
            msgleftView.c(this.c.longValue());
            if (i > 0) {
                msgleftView.b(this.b.get(i - 1).p());
            } else {
                msgleftView.b(0L);
            }
            msgleftView.b(bVar);
            msgleftView.a(viewGroup, bVar);
        } else if (bpVar != null) {
            bpVar.a(bVar);
        } else if (bqVar != null) {
            bqVar.a(bVar);
        } else if (biVar != null) {
            biVar.a(bVar);
        } else if (msgActivityView != null) {
            msgActivityView.b(i);
            msgActivityView.a(this.j);
            msgActivityView.a(bVar);
            msgActivityView.a(this.h);
            msgActivityView.a(this.i);
            msgActivityView.c(this.c.longValue());
            if (i > 0) {
                msgActivityView.b(this.b.get(i - 1).p());
            } else {
                msgActivityView.b(0L);
            }
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        try {
            com.baidu.tieba.im.message.b bVar = this.b.get(i);
            if (bVar != null) {
                if (bVar.i() == 11) {
                    return 2;
                }
                if (bVar.i() == 12) {
                    return 3;
                }
                if (bVar.i() == 13) {
                    return 4;
                }
                if (bVar.i() == 6) {
                    return 5;
                }
                if (bVar.g() != null && bVar.g().getUserId() != null) {
                    return bVar.g().getUserId().equals(TiebaApplication.v()) ? 1 : 0;
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "getItemViewType", e.getMessage());
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 6;
    }

    public final List<com.baidu.tieba.im.message.b> b() {
        return this.b;
    }

    public final void c() {
        notifyDataSetChanged();
    }

    public final void a(List<com.baidu.tieba.im.message.b> list) {
        this.b = list;
        int size = this.b.size();
        if (size > 0) {
            this.f = Long.valueOf(this.b.get(size - 1).l());
            this.e = Long.valueOf(this.b.get(0).l());
            return;
        }
        this.f = null;
        this.e = null;
    }

    public final com.baidu.tieba.util.i d() {
        return this.j;
    }
}
