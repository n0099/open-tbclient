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
public class a extends RecyclerView.Adapter<C0190a> {
    private List<InvoiceInfo> bDB = new ArrayList();
    private b bEF;
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
        int XE;
        if (list != null && list.size() > 0) {
            this.bDB.clear();
            this.bDB.addAll(list);
            if (this.bDB.get(0).mIsDefault != 1 && (XE = XE()) >= 0) {
                a(this.bDB.get(XE), false);
            }
            notifyDataSetChanged();
        }
    }

    public void aX(long j) {
        if (this.bDB != null && this.bDB.size() > 0) {
            for (int i = 0; i < this.bDB.size(); i++) {
                InvoiceInfo invoiceInfo = this.bDB.get(i);
                if (invoiceInfo != null && invoiceInfo.mId == j) {
                    this.bDB.remove(i);
                    notifyItemRemoved(i);
                    if (i != this.bDB.size()) {
                        notifyItemRangeChanged(0, this.bDB.size());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void m(InvoiceInfo invoiceInfo) {
        if (this.bDB != null && invoiceInfo != null) {
            this.bDB.add(0, invoiceInfo);
            notifyItemInserted(0);
        }
    }

    public void aY(long j) {
        int aZ;
        if (this.bDB != null && (aZ = aZ(j)) >= 0) {
            int XE = XE();
            if (XE >= 0) {
                this.bDB.get(XE).mIsDefault = 0;
                notifyItemChanged(XE);
            }
            this.bDB.get(aZ).mIsDefault = 1;
            notifyItemChanged(aZ);
        }
    }

    public void n(InvoiceInfo invoiceInfo) {
        int aZ;
        if (this.bDB != null && (aZ = aZ(invoiceInfo.mId)) >= 0) {
            this.bDB.set(aZ, invoiceInfo);
            notifyItemChanged(aZ);
            a(invoiceInfo, true);
        }
    }

    public void a(InvoiceInfo invoiceInfo, boolean z) {
        if (this.bDB != null && this.bDB.size() > 1 && invoiceInfo != null) {
            for (int i = 0; i < this.bDB.size(); i++) {
                InvoiceInfo invoiceInfo2 = this.bDB.get(i);
                if (invoiceInfo2 != null && invoiceInfo2.equals(invoiceInfo)) {
                    this.bDB.remove(i);
                    this.bDB.add(0, invoiceInfo2);
                    if (z) {
                        notifyItemMoved(i, 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private int XE() {
        if (this.bDB == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bDB.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.bDB.get(i2);
            if (invoiceInfo == null || invoiceInfo.mIsDefault != 1) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    private int aZ(long j) {
        if (this.bDB == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bDB.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.bDB.get(i2);
            if (invoiceInfo == null || invoiceInfo.mId != j) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(b bVar) {
        this.bEF = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: i */
    public C0190a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0190a c0190a = new C0190a(LayoutInflater.from(this.mContext).inflate(e.h.invoice_list_item_view, viewGroup, false));
        if (i == 0) {
            c0190a.bEH.XF();
        } else if (i == 1) {
            c0190a.bEH.XG();
        }
        return c0190a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0190a c0190a, int i) {
        final InvoiceInfo invoiceInfo = this.bDB.get(i);
        if (invoiceInfo != null) {
            if (c0190a.getItemViewType() == 0) {
                c0190a.bEH.setCompanyInfo(invoiceInfo.mTitle, invoiceInfo.bDC);
            } else if (c0190a.getItemViewType() == 1) {
                c0190a.bEH.setPersonageInfo(invoiceInfo.mTitle);
            }
            if (invoiceInfo.mIsDefault == 1) {
                c0190a.bEH.dz(true);
            } else {
                c0190a.bEH.dz(false);
            }
            c0190a.bEH.setEditClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bEF != null) {
                        a.this.bEF.b(view, invoiceInfo);
                    }
                }
            });
            c0190a.bEH.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bEF != null) {
                        a.this.bEF.a(view, invoiceInfo);
                    }
                }
            });
            c0190a.bEH.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (a.this.bEF != null) {
                        a.this.bEF.c(view, invoiceInfo);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.bDB != null) {
            return this.bDB.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.bDB != null) {
            InvoiceInfo invoiceInfo = this.bDB.get(i);
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
    public class C0190a extends RecyclerView.ViewHolder {
        InvoiceListItemView bEH;

        public C0190a(View view) {
            super(view);
            this.bEH = (InvoiceListItemView) view.findViewById(e.g.invoice_list_item);
        }
    }
}
