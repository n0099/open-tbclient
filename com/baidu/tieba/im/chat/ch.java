package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.MsgCacheData;
import java.util.List;
/* loaded from: classes.dex */
public class ch extends BaseAdapter {
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

    public ch(Context context, int i) {
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
        MsgActivityView msgActivityView;
        br brVar;
        bq bqVar;
        MsgleftView msgleftView;
        MsgrightView msgrightView;
        MsgleftView msgleftView2;
        bj bjVar = null;
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
                brVar = null;
                bqVar = null;
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
                brVar = null;
                bqVar = null;
                msgleftView = msgrightView;
                msgActivityView = null;
                break;
            case 2:
                if (view == null) {
                    bq bqVar2 = new bq(this.a);
                    view = bqVar2.a();
                    brVar = null;
                    bqVar = bqVar2;
                    msgleftView = null;
                    msgActivityView = null;
                    break;
                } else {
                    brVar = null;
                    bqVar = (bq) view.getTag();
                    msgleftView = null;
                    msgActivityView = null;
                    break;
                }
            case 3:
                if (view == null) {
                    br brVar2 = new br(this.a);
                    view = brVar2.a();
                    brVar = brVar2;
                    bqVar = null;
                    msgleftView = null;
                    msgActivityView = null;
                    break;
                } else {
                    brVar = (br) view.getTag();
                    bqVar = null;
                    msgleftView = null;
                    msgActivityView = null;
                    break;
                }
            case 4:
                if (view == null) {
                    bj bjVar2 = new bj(this.a);
                    view = bjVar2.a();
                    brVar = null;
                    bqVar = null;
                    msgleftView = null;
                    msgActivityView = null;
                    bjVar = bjVar2;
                    break;
                } else {
                    brVar = null;
                    bqVar = null;
                    msgleftView = null;
                    msgActivityView = null;
                    bjVar = (bj) view.getTag();
                    break;
                }
            case 5:
                if (view == null) {
                    msgActivityView = new MsgActivityView(this.a);
                    view = msgActivityView.a();
                    brVar = null;
                    bqVar = null;
                    msgleftView = null;
                    break;
                } else {
                    msgActivityView = (MsgActivityView) view.getTag();
                    brVar = null;
                    bqVar = null;
                    msgleftView = null;
                    break;
                }
            default:
                com.baidu.adp.lib.util.f.b(getClass().getName(), "getView", "view type error");
                msgActivityView = null;
                brVar = null;
                bqVar = null;
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
            msgleftView.a(viewGroup, bVar);
            msgleftView.b(viewGroup, bVar);
        } else if (bqVar != null) {
            bqVar.a(bVar);
        } else if (brVar != null) {
            brVar.a(bVar);
        } else if (bjVar != null) {
            bjVar.a(bVar);
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
    public int getItemViewType(int i) {
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
                    return bVar.g().getUserId().equals(TiebaApplication.A()) ? 1 : 0;
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "getItemViewType", e.getMessage());
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 6;
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
            this.f = Long.valueOf(this.b.get(size - 1).l());
            this.e = Long.valueOf(this.b.get(0).l());
            return;
        }
        this.f = null;
        this.e = null;
    }

    public com.baidu.tieba.util.i c() {
        return this.j;
    }
}
