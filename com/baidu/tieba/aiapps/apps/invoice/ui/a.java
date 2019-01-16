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
    private List<InvoiceInfo> bHU = new ArrayList();
    private b bIY;
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
            this.bHU.clear();
            this.bHU.addAll(list);
            if (this.bHU.get(0).mIsDefault != 1 && (Zg = Zg()) >= 0) {
                a(this.bHU.get(Zg), false);
            }
            notifyDataSetChanged();
        }
    }

    public void bf(long j) {
        if (this.bHU != null && this.bHU.size() > 0) {
            for (int i = 0; i < this.bHU.size(); i++) {
                InvoiceInfo invoiceInfo = this.bHU.get(i);
                if (invoiceInfo != null && invoiceInfo.mId == j) {
                    this.bHU.remove(i);
                    notifyItemRemoved(i);
                    if (i != this.bHU.size()) {
                        notifyItemRangeChanged(0, this.bHU.size());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void m(InvoiceInfo invoiceInfo) {
        if (this.bHU != null && invoiceInfo != null) {
            this.bHU.add(0, invoiceInfo);
            notifyItemInserted(0);
        }
    }

    public void bg(long j) {
        int bh;
        if (this.bHU != null && (bh = bh(j)) >= 0) {
            int Zg = Zg();
            if (Zg >= 0) {
                this.bHU.get(Zg).mIsDefault = 0;
                notifyItemChanged(Zg);
            }
            this.bHU.get(bh).mIsDefault = 1;
            notifyItemChanged(bh);
        }
    }

    public void n(InvoiceInfo invoiceInfo) {
        int bh;
        if (this.bHU != null && (bh = bh(invoiceInfo.mId)) >= 0) {
            this.bHU.set(bh, invoiceInfo);
            notifyItemChanged(bh);
            a(invoiceInfo, true);
        }
    }

    public void a(InvoiceInfo invoiceInfo, boolean z) {
        if (this.bHU != null && this.bHU.size() > 1 && invoiceInfo != null) {
            for (int i = 0; i < this.bHU.size(); i++) {
                InvoiceInfo invoiceInfo2 = this.bHU.get(i);
                if (invoiceInfo2 != null && invoiceInfo2.equals(invoiceInfo)) {
                    this.bHU.remove(i);
                    this.bHU.add(0, invoiceInfo2);
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
        if (this.bHU == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bHU.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.bHU.get(i2);
            if (invoiceInfo == null || invoiceInfo.mIsDefault != 1) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    private int bh(long j) {
        if (this.bHU == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bHU.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.bHU.get(i2);
            if (invoiceInfo == null || invoiceInfo.mId != j) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(b bVar) {
        this.bIY = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: i */
    public C0200a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0200a c0200a = new C0200a(LayoutInflater.from(this.mContext).inflate(e.h.invoice_list_item_view, viewGroup, false));
        if (i == 0) {
            c0200a.bJa.Zh();
        } else if (i == 1) {
            c0200a.bJa.Zi();
        }
        return c0200a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0200a c0200a, int i) {
        final InvoiceInfo invoiceInfo = this.bHU.get(i);
        if (invoiceInfo != null) {
            if (c0200a.getItemViewType() == 0) {
                c0200a.bJa.setCompanyInfo(invoiceInfo.mTitle, invoiceInfo.bHV);
            } else if (c0200a.getItemViewType() == 1) {
                c0200a.bJa.setPersonageInfo(invoiceInfo.mTitle);
            }
            if (invoiceInfo.mIsDefault == 1) {
                c0200a.bJa.dD(true);
            } else {
                c0200a.bJa.dD(false);
            }
            c0200a.bJa.setEditClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bIY != null) {
                        a.this.bIY.b(view, invoiceInfo);
                    }
                }
            });
            c0200a.bJa.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bIY != null) {
                        a.this.bIY.a(view, invoiceInfo);
                    }
                }
            });
            c0200a.bJa.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (a.this.bIY != null) {
                        a.this.bIY.c(view, invoiceInfo);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.bHU != null) {
            return this.bHU.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.bHU != null) {
            InvoiceInfo invoiceInfo = this.bHU.get(i);
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
        InvoiceListItemView bJa;

        public C0200a(View view) {
            super(view);
            this.bJa = (InvoiceListItemView) view.findViewById(e.g.invoice_list_item);
        }
    }
}
