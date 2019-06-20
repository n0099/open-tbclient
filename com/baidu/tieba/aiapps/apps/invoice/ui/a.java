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
    private List<InvoiceInfo> dbO = new ArrayList();
    private b dcW;
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
            this.dbO.clear();
            this.dbO.addAll(list);
            if (this.dbO.get(0).mIsDefault != 1 && (aEF = aEF()) >= 0) {
                a(this.dbO.get(aEF), false);
            }
            notifyDataSetChanged();
        }
    }

    public void bW(long j) {
        if (this.dbO != null && this.dbO.size() > 0) {
            for (int i = 0; i < this.dbO.size(); i++) {
                InvoiceInfo invoiceInfo = this.dbO.get(i);
                if (invoiceInfo != null && invoiceInfo.mId == j) {
                    this.dbO.remove(i);
                    notifyItemRemoved(i);
                    if (i != this.dbO.size()) {
                        notifyItemRangeChanged(0, this.dbO.size());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void m(InvoiceInfo invoiceInfo) {
        if (this.dbO != null && invoiceInfo != null) {
            this.dbO.add(0, invoiceInfo);
            notifyItemInserted(0);
        }
    }

    public void bX(long j) {
        int bY;
        if (this.dbO != null && (bY = bY(j)) >= 0) {
            int aEF = aEF();
            if (aEF >= 0) {
                this.dbO.get(aEF).mIsDefault = 0;
                notifyItemChanged(aEF);
            }
            this.dbO.get(bY).mIsDefault = 1;
            notifyItemChanged(bY);
        }
    }

    public void n(InvoiceInfo invoiceInfo) {
        int bY;
        if (this.dbO != null && (bY = bY(invoiceInfo.mId)) >= 0) {
            this.dbO.set(bY, invoiceInfo);
            notifyItemChanged(bY);
            a(invoiceInfo, true);
        }
    }

    public void a(InvoiceInfo invoiceInfo, boolean z) {
        if (this.dbO != null && this.dbO.size() > 1 && invoiceInfo != null) {
            for (int i = 0; i < this.dbO.size(); i++) {
                InvoiceInfo invoiceInfo2 = this.dbO.get(i);
                if (invoiceInfo2 != null && invoiceInfo2.equals(invoiceInfo)) {
                    this.dbO.remove(i);
                    this.dbO.add(0, invoiceInfo2);
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
        if (this.dbO == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dbO.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.dbO.get(i2);
            if (invoiceInfo == null || invoiceInfo.mIsDefault != 1) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    private int bY(long j) {
        if (this.dbO == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dbO.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.dbO.get(i2);
            if (invoiceInfo == null || invoiceInfo.mId != j) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(b bVar) {
        this.dcW = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: k */
    public C0283a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0283a c0283a = new C0283a(LayoutInflater.from(this.mContext).inflate(R.layout.invoice_list_item_view, viewGroup, false));
        if (i == 0) {
            c0283a.dcY.aEG();
        } else if (i == 1) {
            c0283a.dcY.aEH();
        }
        return c0283a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0283a c0283a, int i) {
        final InvoiceInfo invoiceInfo = this.dbO.get(i);
        if (invoiceInfo != null) {
            if (c0283a.getItemViewType() == 0) {
                c0283a.dcY.setCompanyInfo(invoiceInfo.mTitle, invoiceInfo.dbP);
            } else if (c0283a.getItemViewType() == 1) {
                c0283a.dcY.setPersonageInfo(invoiceInfo.mTitle);
            }
            if (invoiceInfo.mIsDefault == 1) {
                c0283a.dcY.gs(true);
            } else {
                c0283a.dcY.gs(false);
            }
            c0283a.dcY.setEditClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.dcW != null) {
                        a.this.dcW.b(view, invoiceInfo);
                    }
                }
            });
            c0283a.dcY.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.dcW != null) {
                        a.this.dcW.a(view, invoiceInfo);
                    }
                }
            });
            c0283a.dcY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (a.this.dcW != null) {
                        a.this.dcW.c(view, invoiceInfo);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dbO != null) {
            return this.dbO.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.dbO != null) {
            InvoiceInfo invoiceInfo = this.dbO.get(i);
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
        InvoiceListItemView dcY;

        public C0283a(View view) {
            super(view);
            this.dcY = (InvoiceListItemView) view.findViewById(R.id.invoice_list_item);
        }
    }
}
