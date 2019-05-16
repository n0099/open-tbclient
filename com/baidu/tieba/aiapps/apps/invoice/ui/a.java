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
    private List<InvoiceInfo> dbM = new ArrayList();
    private b dcU;
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
        int aEC;
        if (list != null && list.size() > 0) {
            this.dbM.clear();
            this.dbM.addAll(list);
            if (this.dbM.get(0).mIsDefault != 1 && (aEC = aEC()) >= 0) {
                a(this.dbM.get(aEC), false);
            }
            notifyDataSetChanged();
        }
    }

    public void bW(long j) {
        if (this.dbM != null && this.dbM.size() > 0) {
            for (int i = 0; i < this.dbM.size(); i++) {
                InvoiceInfo invoiceInfo = this.dbM.get(i);
                if (invoiceInfo != null && invoiceInfo.mId == j) {
                    this.dbM.remove(i);
                    notifyItemRemoved(i);
                    if (i != this.dbM.size()) {
                        notifyItemRangeChanged(0, this.dbM.size());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void m(InvoiceInfo invoiceInfo) {
        if (this.dbM != null && invoiceInfo != null) {
            this.dbM.add(0, invoiceInfo);
            notifyItemInserted(0);
        }
    }

    public void bX(long j) {
        int bY;
        if (this.dbM != null && (bY = bY(j)) >= 0) {
            int aEC = aEC();
            if (aEC >= 0) {
                this.dbM.get(aEC).mIsDefault = 0;
                notifyItemChanged(aEC);
            }
            this.dbM.get(bY).mIsDefault = 1;
            notifyItemChanged(bY);
        }
    }

    public void n(InvoiceInfo invoiceInfo) {
        int bY;
        if (this.dbM != null && (bY = bY(invoiceInfo.mId)) >= 0) {
            this.dbM.set(bY, invoiceInfo);
            notifyItemChanged(bY);
            a(invoiceInfo, true);
        }
    }

    public void a(InvoiceInfo invoiceInfo, boolean z) {
        if (this.dbM != null && this.dbM.size() > 1 && invoiceInfo != null) {
            for (int i = 0; i < this.dbM.size(); i++) {
                InvoiceInfo invoiceInfo2 = this.dbM.get(i);
                if (invoiceInfo2 != null && invoiceInfo2.equals(invoiceInfo)) {
                    this.dbM.remove(i);
                    this.dbM.add(0, invoiceInfo2);
                    if (z) {
                        notifyItemMoved(i, 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private int aEC() {
        if (this.dbM == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dbM.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.dbM.get(i2);
            if (invoiceInfo == null || invoiceInfo.mIsDefault != 1) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    private int bY(long j) {
        if (this.dbM == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dbM.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.dbM.get(i2);
            if (invoiceInfo == null || invoiceInfo.mId != j) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(b bVar) {
        this.dcU = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: k */
    public C0283a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0283a c0283a = new C0283a(LayoutInflater.from(this.mContext).inflate(R.layout.invoice_list_item_view, viewGroup, false));
        if (i == 0) {
            c0283a.dcW.aED();
        } else if (i == 1) {
            c0283a.dcW.aEE();
        }
        return c0283a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0283a c0283a, int i) {
        final InvoiceInfo invoiceInfo = this.dbM.get(i);
        if (invoiceInfo != null) {
            if (c0283a.getItemViewType() == 0) {
                c0283a.dcW.setCompanyInfo(invoiceInfo.mTitle, invoiceInfo.dbN);
            } else if (c0283a.getItemViewType() == 1) {
                c0283a.dcW.setPersonageInfo(invoiceInfo.mTitle);
            }
            if (invoiceInfo.mIsDefault == 1) {
                c0283a.dcW.gs(true);
            } else {
                c0283a.dcW.gs(false);
            }
            c0283a.dcW.setEditClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.dcU != null) {
                        a.this.dcU.b(view, invoiceInfo);
                    }
                }
            });
            c0283a.dcW.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.dcU != null) {
                        a.this.dcU.a(view, invoiceInfo);
                    }
                }
            });
            c0283a.dcW.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (a.this.dcU != null) {
                        a.this.dcU.c(view, invoiceInfo);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dbM != null) {
            return this.dbM.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.dbM != null) {
            InvoiceInfo invoiceInfo = this.dbM.get(i);
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
        InvoiceListItemView dcW;

        public C0283a(View view) {
            super(view);
            this.dcW = (InvoiceListItemView) view.findViewById(R.id.invoice_list_item);
        }
    }
}
