package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.data.MsgCacheData;
import java.util.List;
/* loaded from: classes.dex */
public final class cp extends BaseAdapter {
    private Context a;
    private com.baidu.tbadk.editortool.ab i;
    private List<com.baidu.tieba.im.message.a.a> b = null;
    private Long c = 0L;
    private long d = 0;
    private Long e = null;
    private Long f = null;
    private com.baidu.adp.lib.b.a g = null;
    private com.baidu.adp.lib.b.b h = null;
    private boolean j = true;

    public cp(Context context) {
        this.i = null;
        this.a = context;
        this.i = new com.baidu.tbadk.editortool.ab(context);
    }

    public final void a(boolean z) {
        this.j = z;
    }

    public final void a() {
        this.c = Long.valueOf(System.currentTimeMillis() / 1000);
    }

    public final void a(com.baidu.adp.lib.b.a aVar) {
        this.g = aVar;
    }

    public final void a(com.baidu.adp.lib.b.b bVar) {
        this.h = bVar;
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
        ca caVar;
        cc ccVar;
        cb cbVar;
        MsgleftView msgleftView;
        MsgActivityView msgActivityView;
        MsgrightView msgrightView;
        MsgleftView msgleftView2;
        MsgMultiImageTextView msgMultiImageTextView = null;
        int itemViewType = getItemViewType(i);
        com.baidu.tieba.im.message.a.a aVar = this.b.get(i);
        if (aVar.z() == null) {
            aVar.a(new MsgCacheData());
        }
        switch (itemViewType) {
            case 0:
                if (view == null) {
                    msgleftView2 = new MsgleftView(this.a);
                    view = msgleftView2.a();
                } else {
                    msgleftView2 = (MsgleftView) view.getTag();
                }
                msgleftView2.a(this.j);
                aVar.z().setIs_left(1);
                msgleftView2.a(this.i);
                caVar = null;
                ccVar = null;
                cbVar = null;
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
                msgrightView.a(this.i);
                aVar.z().setIs_left(0);
                caVar = null;
                ccVar = null;
                cbVar = null;
                msgleftView = msgrightView;
                msgActivityView = null;
                break;
            case 2:
                if (view == null) {
                    cb cbVar2 = new cb(this.a);
                    view = cbVar2.a();
                    caVar = null;
                    ccVar = null;
                    cbVar = cbVar2;
                    msgleftView = null;
                    msgActivityView = null;
                    break;
                } else {
                    caVar = null;
                    ccVar = null;
                    cbVar = (cb) view.getTag();
                    msgleftView = null;
                    msgActivityView = null;
                    break;
                }
            case 3:
                if (view == null) {
                    cc ccVar2 = new cc(this.a);
                    view = ccVar2.a();
                    caVar = null;
                    ccVar = ccVar2;
                    cbVar = null;
                    msgleftView = null;
                    msgActivityView = null;
                    break;
                } else {
                    caVar = null;
                    ccVar = (cc) view.getTag();
                    cbVar = null;
                    msgleftView = null;
                    msgActivityView = null;
                    break;
                }
            case 4:
                if (view == null) {
                    ca caVar2 = new ca(this.a);
                    view = caVar2.a();
                    caVar = caVar2;
                    ccVar = null;
                    cbVar = null;
                    msgleftView = null;
                    msgActivityView = null;
                    break;
                } else {
                    caVar = (ca) view.getTag();
                    ccVar = null;
                    cbVar = null;
                    msgleftView = null;
                    msgActivityView = null;
                    break;
                }
            case 5:
                if (view == null) {
                    msgActivityView = new MsgActivityView(this.a);
                    view = msgActivityView.a();
                    caVar = null;
                    ccVar = null;
                    cbVar = null;
                    msgleftView = null;
                    break;
                } else {
                    msgActivityView = (MsgActivityView) view.getTag();
                    caVar = null;
                    ccVar = null;
                    cbVar = null;
                    msgleftView = null;
                    break;
                }
            case 6:
                if (view == null) {
                    MsgMultiImageTextView msgMultiImageTextView2 = new MsgMultiImageTextView(this.a);
                    view = msgMultiImageTextView2.a();
                    caVar = null;
                    ccVar = null;
                    cbVar = null;
                    msgleftView = null;
                    msgActivityView = null;
                    msgMultiImageTextView = msgMultiImageTextView2;
                    break;
                } else {
                    caVar = null;
                    ccVar = null;
                    cbVar = null;
                    msgleftView = null;
                    msgActivityView = null;
                    msgMultiImageTextView = (MsgMultiImageTextView) view.getTag();
                    break;
                }
            default:
                com.baidu.adp.lib.util.f.b(getClass().getName(), "getView", "view type error");
                msgActivityView = null;
                caVar = null;
                ccVar = null;
                cbVar = null;
                msgleftView = null;
                break;
        }
        if (msgleftView != null) {
            msgleftView.a(this.g);
            msgleftView.a(this.h);
            msgleftView.b(i);
            msgleftView.a(this.d);
            msgleftView.c(this.c.longValue());
            if (i > 0) {
                msgleftView.b(this.b.get(i - 1).A());
            } else {
                msgleftView.b(0L);
            }
            msgleftView.b(aVar);
            msgleftView.a(viewGroup, aVar);
        } else if (cbVar != null) {
            cbVar.a(aVar);
        } else if (ccVar != null) {
            ccVar.a(aVar);
        } else if (caVar != null) {
            caVar.a(aVar);
        } else if (msgActivityView != null) {
            msgActivityView.b(i);
            msgActivityView.a(this.i);
            msgActivityView.a(aVar);
            msgActivityView.a(this.g);
            msgActivityView.a(this.h);
            msgActivityView.c(this.c.longValue());
            if (i > 0) {
                msgActivityView.b(this.b.get(i - 1).A());
            } else {
                msgActivityView.b(0L);
            }
        } else if (msgMultiImageTextView != null) {
            msgMultiImageTextView.a(this.h);
            msgMultiImageTextView.b(i);
            msgMultiImageTextView.c(this.c.longValue());
            if (i > 0) {
                msgMultiImageTextView.b(this.b.get(i - 1).A());
            } else {
                msgMultiImageTextView.b(0L);
            }
            msgMultiImageTextView.a(aVar, viewGroup);
        }
        ((MsglistActivity) this.a).getLayoutMode().a(false);
        ((MsglistActivity) this.a).getLayoutMode().a(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        try {
            com.baidu.tieba.im.message.a.a aVar = this.b.get(i);
            if (aVar != null) {
                if (aVar.t() == 11) {
                    return 2;
                }
                if (aVar.t() == 12) {
                    return 3;
                }
                if (aVar.t() == 13) {
                    return 4;
                }
                if (aVar.t() == 6) {
                    return 5;
                }
                if (aVar.t() == 7) {
                    return 6;
                }
                if (aVar.r() != null && aVar.r().getUserId() != null) {
                    return aVar.r().getUserId().equals(TbadkApplication.E()) ? 1 : 0;
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "getItemViewType", e.getMessage());
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 7;
    }

    public final List<com.baidu.tieba.im.message.a.a> b() {
        return this.b;
    }

    public final void c() {
        notifyDataSetChanged();
    }

    public final void a(List<com.baidu.tieba.im.message.a.a> list) {
        this.b = list;
        int size = this.b.size();
        if (size > 0) {
            this.f = Long.valueOf(this.b.get(size - 1).w());
            this.e = Long.valueOf(this.b.get(0).w());
            return;
        }
        this.f = null;
        this.e = null;
    }

    public final com.baidu.tbadk.editortool.ab d() {
        return this.i;
    }
}
