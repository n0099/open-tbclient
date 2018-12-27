package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends RecyclerView.Adapter<C0200a> {
    private List<InvoiceInfo> bHh = new ArrayList();
    private b bIl;
    private Context mContext;

    /* loaded from: classes4.dex */
    interface b {
        void a(View view, InvoiceInfo invoiceInfo);

        void b(View view, InvoiceInfo invoiceInfo);

        void c(View view, InvoiceInfo invoiceInfo);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void ak(List<InvoiceInfo> list) {
        int YJ;
        if (list != null && list.size() > 0) {
            this.bHh.clear();
            this.bHh.addAll(list);
            if (this.bHh.get(0).mIsDefault != 1 && (YJ = YJ()) >= 0) {
                a(this.bHh.get(YJ), false);
            }
            notifyDataSetChanged();
        }
    }

    public void bf(long j) {
        if (this.bHh != null && this.bHh.size() > 0) {
            for (int i = 0; i < this.bHh.size(); i++) {
                InvoiceInfo invoiceInfo = this.bHh.get(i);
                if (invoiceInfo != null && invoiceInfo.mId == j) {
                    this.bHh.remove(i);
                    notifyItemRemoved(i);
                    if (i != this.bHh.size()) {
                        notifyItemRangeChanged(0, this.bHh.size());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void m(InvoiceInfo invoiceInfo) {
        if (this.bHh != null && invoiceInfo != null) {
            this.bHh.add(0, invoiceInfo);
            notifyItemInserted(0);
        }
    }

    public void bg(long j) {
        int bh;
        if (this.bHh != null && (bh = bh(j)) >= 0) {
            int YJ = YJ();
            if (YJ >= 0) {
                this.bHh.get(YJ).mIsDefault = 0;
                notifyItemChanged(YJ);
            }
            this.bHh.get(bh).mIsDefault = 1;
            notifyItemChanged(bh);
        }
    }

    public void n(InvoiceInfo invoiceInfo) {
        int bh;
        if (this.bHh != null && (bh = bh(invoiceInfo.mId)) >= 0) {
            this.bHh.set(bh, invoiceInfo);
            notifyItemChanged(bh);
            a(invoiceInfo, true);
        }
    }

    public void a(InvoiceInfo invoiceInfo, boolean z) {
        if (this.bHh != null && this.bHh.size() > 1 && invoiceInfo != null) {
            for (int i = 0; i < this.bHh.size(); i++) {
                InvoiceInfo invoiceInfo2 = this.bHh.get(i);
                if (invoiceInfo2 != null && invoiceInfo2.equals(invoiceInfo)) {
                    this.bHh.remove(i);
                    this.bHh.add(0, invoiceInfo2);
                    if (z) {
                        notifyItemMoved(i, 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private int YJ() {
        if (this.bHh == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bHh.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.bHh.get(i2);
            if (invoiceInfo == null || invoiceInfo.mIsDefault != 1) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    private int bh(long j) {
        if (this.bHh == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bHh.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.bHh.get(i2);
            if (invoiceInfo == null || invoiceInfo.mId != j) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(b bVar) {
        this.bIl = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: i */
    public C0200a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0200a c0200a = new C0200a(LayoutInflater.from(this.mContext).inflate(e.h.invoice_list_item_view, viewGroup, false));
        if (i == 0) {
            c0200a.bIn.YK();
        } else if (i == 1) {
            c0200a.bIn.YL();
        }
        return c0200a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0200a c0200a, int i) {
        final InvoiceInfo invoiceInfo = this.bHh.get(i);
        if (invoiceInfo != null) {
            if (c0200a.getItemViewType() == 0) {
                c0200a.bIn.setCompanyInfo(invoiceInfo.mTitle, invoiceInfo.bHi);
            } else if (c0200a.getItemViewType() == 1) {
                c0200a.bIn.setPersonageInfo(invoiceInfo.mTitle);
            }
            if (invoiceInfo.mIsDefault == 1) {
                c0200a.bIn.dA(true);
            } else {
                c0200a.bIn.dA(false);
            }
            c0200a.bIn.setEditClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bIl != null) {
                        a.this.bIl.b(view, invoiceInfo);
                    }
                }
            });
            c0200a.bIn.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bIl != null) {
                        a.this.bIl.a(view, invoiceInfo);
                    }
                }
            });
            c0200a.bIn.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (a.this.bIl != null) {
                        a.this.bIl.c(view, invoiceInfo);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.bHh != null) {
            return this.bHh.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.bHh != null) {
            InvoiceInfo invoiceInfo = this.bHh.get(i);
            if (invoiceInfo != null && invoiceInfo.mType == 0) {
                return 0;
            }
            if (invoiceInfo != null && invoiceInfo.mType == 1) {
                return 1;
            }
        }
        return super.getItemViewType(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.aiapps.apps.invoice.ui.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0200a extends RecyclerView.ViewHolder {
        InvoiceListItemView bIn;

        public C0200a(View view) {
            super(view);
            this.bIn = (InvoiceListItemView) view.findViewById(e.g.invoice_list_item);
        }
    }
}
