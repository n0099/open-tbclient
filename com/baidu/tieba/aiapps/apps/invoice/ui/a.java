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
    private List<InvoiceInfo> bHV = new ArrayList();
    private b bIZ;
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

    public void al(List<InvoiceInfo> list) {
        int Zg;
        if (list != null && list.size() > 0) {
            this.bHV.clear();
            this.bHV.addAll(list);
            if (this.bHV.get(0).mIsDefault != 1 && (Zg = Zg()) >= 0) {
                a(this.bHV.get(Zg), false);
            }
            notifyDataSetChanged();
        }
    }

    public void bf(long j) {
        if (this.bHV != null && this.bHV.size() > 0) {
            for (int i = 0; i < this.bHV.size(); i++) {
                InvoiceInfo invoiceInfo = this.bHV.get(i);
                if (invoiceInfo != null && invoiceInfo.mId == j) {
                    this.bHV.remove(i);
                    notifyItemRemoved(i);
                    if (i != this.bHV.size()) {
                        notifyItemRangeChanged(0, this.bHV.size());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void m(InvoiceInfo invoiceInfo) {
        if (this.bHV != null && invoiceInfo != null) {
            this.bHV.add(0, invoiceInfo);
            notifyItemInserted(0);
        }
    }

    public void bg(long j) {
        int bh;
        if (this.bHV != null && (bh = bh(j)) >= 0) {
            int Zg = Zg();
            if (Zg >= 0) {
                this.bHV.get(Zg).mIsDefault = 0;
                notifyItemChanged(Zg);
            }
            this.bHV.get(bh).mIsDefault = 1;
            notifyItemChanged(bh);
        }
    }

    public void n(InvoiceInfo invoiceInfo) {
        int bh;
        if (this.bHV != null && (bh = bh(invoiceInfo.mId)) >= 0) {
            this.bHV.set(bh, invoiceInfo);
            notifyItemChanged(bh);
            a(invoiceInfo, true);
        }
    }

    public void a(InvoiceInfo invoiceInfo, boolean z) {
        if (this.bHV != null && this.bHV.size() > 1 && invoiceInfo != null) {
            for (int i = 0; i < this.bHV.size(); i++) {
                InvoiceInfo invoiceInfo2 = this.bHV.get(i);
                if (invoiceInfo2 != null && invoiceInfo2.equals(invoiceInfo)) {
                    this.bHV.remove(i);
                    this.bHV.add(0, invoiceInfo2);
                    if (z) {
                        notifyItemMoved(i, 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private int Zg() {
        if (this.bHV == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bHV.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.bHV.get(i2);
            if (invoiceInfo == null || invoiceInfo.mIsDefault != 1) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    private int bh(long j) {
        if (this.bHV == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bHV.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.bHV.get(i2);
            if (invoiceInfo == null || invoiceInfo.mId != j) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(b bVar) {
        this.bIZ = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: i */
    public C0200a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0200a c0200a = new C0200a(LayoutInflater.from(this.mContext).inflate(e.h.invoice_list_item_view, viewGroup, false));
        if (i == 0) {
            c0200a.bJb.Zh();
        } else if (i == 1) {
            c0200a.bJb.Zi();
        }
        return c0200a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0200a c0200a, int i) {
        final InvoiceInfo invoiceInfo = this.bHV.get(i);
        if (invoiceInfo != null) {
            if (c0200a.getItemViewType() == 0) {
                c0200a.bJb.setCompanyInfo(invoiceInfo.mTitle, invoiceInfo.bHW);
            } else if (c0200a.getItemViewType() == 1) {
                c0200a.bJb.setPersonageInfo(invoiceInfo.mTitle);
            }
            if (invoiceInfo.mIsDefault == 1) {
                c0200a.bJb.dD(true);
            } else {
                c0200a.bJb.dD(false);
            }
            c0200a.bJb.setEditClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bIZ != null) {
                        a.this.bIZ.b(view, invoiceInfo);
                    }
                }
            });
            c0200a.bJb.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bIZ != null) {
                        a.this.bIZ.a(view, invoiceInfo);
                    }
                }
            });
            c0200a.bJb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (a.this.bIZ != null) {
                        a.this.bIZ.c(view, invoiceInfo);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.bHV != null) {
            return this.bHV.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.bHV != null) {
            InvoiceInfo invoiceInfo = this.bHV.get(i);
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
        InvoiceListItemView bJb;

        public C0200a(View view) {
            super(view);
            this.bJb = (InvoiceListItemView) view.findViewById(e.g.invoice_list_item);
        }
    }
}
