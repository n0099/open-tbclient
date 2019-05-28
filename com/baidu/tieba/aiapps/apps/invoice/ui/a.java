package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends RecyclerView.Adapter<C0283a> {
    private List<InvoiceInfo> dbN = new ArrayList();
    private b dcV;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface b {
        void a(View view, InvoiceInfo invoiceInfo);

        void b(View view, InvoiceInfo invoiceInfo);

        void c(View view, InvoiceInfo invoiceInfo);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void aF(List<InvoiceInfo> list) {
        int aEF;
        if (list != null && list.size() > 0) {
            this.dbN.clear();
            this.dbN.addAll(list);
            if (this.dbN.get(0).mIsDefault != 1 && (aEF = aEF()) >= 0) {
                a(this.dbN.get(aEF), false);
            }
            notifyDataSetChanged();
        }
    }

    public void bW(long j) {
        if (this.dbN != null && this.dbN.size() > 0) {
            for (int i = 0; i < this.dbN.size(); i++) {
                InvoiceInfo invoiceInfo = this.dbN.get(i);
                if (invoiceInfo != null && invoiceInfo.mId == j) {
                    this.dbN.remove(i);
                    notifyItemRemoved(i);
                    if (i != this.dbN.size()) {
                        notifyItemRangeChanged(0, this.dbN.size());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void m(InvoiceInfo invoiceInfo) {
        if (this.dbN != null && invoiceInfo != null) {
            this.dbN.add(0, invoiceInfo);
            notifyItemInserted(0);
        }
    }

    public void bX(long j) {
        int bY;
        if (this.dbN != null && (bY = bY(j)) >= 0) {
            int aEF = aEF();
            if (aEF >= 0) {
                this.dbN.get(aEF).mIsDefault = 0;
                notifyItemChanged(aEF);
            }
            this.dbN.get(bY).mIsDefault = 1;
            notifyItemChanged(bY);
        }
    }

    public void n(InvoiceInfo invoiceInfo) {
        int bY;
        if (this.dbN != null && (bY = bY(invoiceInfo.mId)) >= 0) {
            this.dbN.set(bY, invoiceInfo);
            notifyItemChanged(bY);
            a(invoiceInfo, true);
        }
    }

    public void a(InvoiceInfo invoiceInfo, boolean z) {
        if (this.dbN != null && this.dbN.size() > 1 && invoiceInfo != null) {
            for (int i = 0; i < this.dbN.size(); i++) {
                InvoiceInfo invoiceInfo2 = this.dbN.get(i);
                if (invoiceInfo2 != null && invoiceInfo2.equals(invoiceInfo)) {
                    this.dbN.remove(i);
                    this.dbN.add(0, invoiceInfo2);
                    if (z) {
                        notifyItemMoved(i, 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private int aEF() {
        if (this.dbN == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dbN.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.dbN.get(i2);
            if (invoiceInfo == null || invoiceInfo.mIsDefault != 1) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    private int bY(long j) {
        if (this.dbN == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dbN.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.dbN.get(i2);
            if (invoiceInfo == null || invoiceInfo.mId != j) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(b bVar) {
        this.dcV = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: k */
    public C0283a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0283a c0283a = new C0283a(LayoutInflater.from(this.mContext).inflate(R.layout.invoice_list_item_view, viewGroup, false));
        if (i == 0) {
            c0283a.dcX.aEG();
        } else if (i == 1) {
            c0283a.dcX.aEH();
        }
        return c0283a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0283a c0283a, int i) {
        final InvoiceInfo invoiceInfo = this.dbN.get(i);
        if (invoiceInfo != null) {
            if (c0283a.getItemViewType() == 0) {
                c0283a.dcX.setCompanyInfo(invoiceInfo.mTitle, invoiceInfo.dbO);
            } else if (c0283a.getItemViewType() == 1) {
                c0283a.dcX.setPersonageInfo(invoiceInfo.mTitle);
            }
            if (invoiceInfo.mIsDefault == 1) {
                c0283a.dcX.gs(true);
            } else {
                c0283a.dcX.gs(false);
            }
            c0283a.dcX.setEditClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.dcV != null) {
                        a.this.dcV.b(view, invoiceInfo);
                    }
                }
            });
            c0283a.dcX.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.dcV != null) {
                        a.this.dcV.a(view, invoiceInfo);
                    }
                }
            });
            c0283a.dcX.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (a.this.dcV != null) {
                        a.this.dcV.c(view, invoiceInfo);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dbN != null) {
            return this.dbN.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.dbN != null) {
            InvoiceInfo invoiceInfo = this.dbN.get(i);
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
    public class C0283a extends RecyclerView.ViewHolder {
        InvoiceListItemView dcX;

        public C0283a(View view) {
            super(view);
            this.dcX = (InvoiceListItemView) view.findViewById(R.id.invoice_list_item);
        }
    }
}
