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
public class a extends RecyclerView.Adapter<C0165a> {
    private List<InvoiceInfo> bCP = new ArrayList();
    private b bDT;
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
        int Xt;
        if (list != null && list.size() > 0) {
            this.bCP.clear();
            this.bCP.addAll(list);
            if (this.bCP.get(0).mIsDefault != 1 && (Xt = Xt()) >= 0) {
                a(this.bCP.get(Xt), false);
            }
            notifyDataSetChanged();
        }
    }

    public void aV(long j) {
        if (this.bCP != null && this.bCP.size() > 0) {
            for (int i = 0; i < this.bCP.size(); i++) {
                InvoiceInfo invoiceInfo = this.bCP.get(i);
                if (invoiceInfo != null && invoiceInfo.mId == j) {
                    this.bCP.remove(i);
                    notifyItemRemoved(i);
                    if (i != this.bCP.size()) {
                        notifyItemRangeChanged(0, this.bCP.size());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void m(InvoiceInfo invoiceInfo) {
        if (this.bCP != null && invoiceInfo != null) {
            this.bCP.add(0, invoiceInfo);
            notifyItemInserted(0);
        }
    }

    public void aW(long j) {
        int aX;
        if (this.bCP != null && (aX = aX(j)) >= 0) {
            int Xt = Xt();
            if (Xt >= 0) {
                this.bCP.get(Xt).mIsDefault = 0;
                notifyItemChanged(Xt);
            }
            this.bCP.get(aX).mIsDefault = 1;
            notifyItemChanged(aX);
        }
    }

    public void n(InvoiceInfo invoiceInfo) {
        int aX;
        if (this.bCP != null && (aX = aX(invoiceInfo.mId)) >= 0) {
            this.bCP.set(aX, invoiceInfo);
            notifyItemChanged(aX);
            a(invoiceInfo, true);
        }
    }

    public void a(InvoiceInfo invoiceInfo, boolean z) {
        if (this.bCP != null && this.bCP.size() > 1 && invoiceInfo != null) {
            for (int i = 0; i < this.bCP.size(); i++) {
                InvoiceInfo invoiceInfo2 = this.bCP.get(i);
                if (invoiceInfo2 != null && invoiceInfo2.equals(invoiceInfo)) {
                    this.bCP.remove(i);
                    this.bCP.add(0, invoiceInfo2);
                    if (z) {
                        notifyItemMoved(i, 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private int Xt() {
        if (this.bCP == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bCP.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.bCP.get(i2);
            if (invoiceInfo == null || invoiceInfo.mIsDefault != 1) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    private int aX(long j) {
        if (this.bCP == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bCP.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.bCP.get(i2);
            if (invoiceInfo == null || invoiceInfo.mId != j) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(b bVar) {
        this.bDT = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: i */
    public C0165a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0165a c0165a = new C0165a(LayoutInflater.from(this.mContext).inflate(e.h.invoice_list_item_view, viewGroup, false));
        if (i == 0) {
            c0165a.bDV.Xu();
        } else if (i == 1) {
            c0165a.bDV.Xv();
        }
        return c0165a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0165a c0165a, int i) {
        final InvoiceInfo invoiceInfo = this.bCP.get(i);
        if (invoiceInfo != null) {
            if (c0165a.getItemViewType() == 0) {
                c0165a.bDV.setCompanyInfo(invoiceInfo.mTitle, invoiceInfo.bCQ);
            } else if (c0165a.getItemViewType() == 1) {
                c0165a.bDV.setPersonageInfo(invoiceInfo.mTitle);
            }
            if (invoiceInfo.mIsDefault == 1) {
                c0165a.bDV.di(true);
            } else {
                c0165a.bDV.di(false);
            }
            c0165a.bDV.setEditClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bDT != null) {
                        a.this.bDT.b(view, invoiceInfo);
                    }
                }
            });
            c0165a.bDV.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bDT != null) {
                        a.this.bDT.a(view, invoiceInfo);
                    }
                }
            });
            c0165a.bDV.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (a.this.bDT != null) {
                        a.this.bDT.c(view, invoiceInfo);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.bCP != null) {
            return this.bCP.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.bCP != null) {
            InvoiceInfo invoiceInfo = this.bCP.get(i);
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
    public class C0165a extends RecyclerView.ViewHolder {
        InvoiceListItemView bDV;

        public C0165a(View view) {
            super(view);
            this.bDV = (InvoiceListItemView) view.findViewById(e.g.invoice_list_item);
        }
    }
}
