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
public class a extends RecyclerView.Adapter<C0295a> {
    private List<InvoiceInfo> dfj = new ArrayList();
    private b dgp;
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
        int aGC;
        if (list != null && list.size() > 0) {
            this.dfj.clear();
            this.dfj.addAll(list);
            if (this.dfj.get(0).mIsDefault != 1 && (aGC = aGC()) >= 0) {
                a(this.dfj.get(aGC), false);
            }
            notifyDataSetChanged();
        }
    }

    public void ca(long j) {
        if (this.dfj != null && this.dfj.size() > 0) {
            for (int i = 0; i < this.dfj.size(); i++) {
                InvoiceInfo invoiceInfo = this.dfj.get(i);
                if (invoiceInfo != null && invoiceInfo.mId == j) {
                    this.dfj.remove(i);
                    notifyItemRemoved(i);
                    if (i != this.dfj.size()) {
                        notifyItemRangeChanged(0, this.dfj.size());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void m(InvoiceInfo invoiceInfo) {
        if (this.dfj != null && invoiceInfo != null) {
            this.dfj.add(0, invoiceInfo);
            notifyItemInserted(0);
        }
    }

    public void cb(long j) {
        int cc;
        if (this.dfj != null && (cc = cc(j)) >= 0) {
            int aGC = aGC();
            if (aGC >= 0) {
                this.dfj.get(aGC).mIsDefault = 0;
                notifyItemChanged(aGC);
            }
            this.dfj.get(cc).mIsDefault = 1;
            notifyItemChanged(cc);
        }
    }

    public void n(InvoiceInfo invoiceInfo) {
        int cc;
        if (this.dfj != null && (cc = cc(invoiceInfo.mId)) >= 0) {
            this.dfj.set(cc, invoiceInfo);
            notifyItemChanged(cc);
            a(invoiceInfo, true);
        }
    }

    public void a(InvoiceInfo invoiceInfo, boolean z) {
        if (this.dfj != null && this.dfj.size() > 1 && invoiceInfo != null) {
            for (int i = 0; i < this.dfj.size(); i++) {
                InvoiceInfo invoiceInfo2 = this.dfj.get(i);
                if (invoiceInfo2 != null && invoiceInfo2.equals(invoiceInfo)) {
                    this.dfj.remove(i);
                    this.dfj.add(0, invoiceInfo2);
                    if (z) {
                        notifyItemMoved(i, 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private int aGC() {
        if (this.dfj == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dfj.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.dfj.get(i2);
            if (invoiceInfo == null || invoiceInfo.mIsDefault != 1) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    private int cc(long j) {
        if (this.dfj == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dfj.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.dfj.get(i2);
            if (invoiceInfo == null || invoiceInfo.mId != j) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(b bVar) {
        this.dgp = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: k */
    public C0295a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0295a c0295a = new C0295a(LayoutInflater.from(this.mContext).inflate(R.layout.invoice_list_item_view, viewGroup, false));
        if (i == 0) {
            c0295a.dgr.aGD();
        } else if (i == 1) {
            c0295a.dgr.aGE();
        }
        return c0295a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0295a c0295a, int i) {
        final InvoiceInfo invoiceInfo = this.dfj.get(i);
        if (invoiceInfo != null) {
            if (c0295a.getItemViewType() == 0) {
                c0295a.dgr.setCompanyInfo(invoiceInfo.mTitle, invoiceInfo.dfk);
            } else if (c0295a.getItemViewType() == 1) {
                c0295a.dgr.setPersonageInfo(invoiceInfo.mTitle);
            }
            if (invoiceInfo.mIsDefault == 1) {
                c0295a.dgr.gz(true);
            } else {
                c0295a.dgr.gz(false);
            }
            c0295a.dgr.setEditClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.dgp != null) {
                        a.this.dgp.b(view, invoiceInfo);
                    }
                }
            });
            c0295a.dgr.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.dgp != null) {
                        a.this.dgp.a(view, invoiceInfo);
                    }
                }
            });
            c0295a.dgr.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (a.this.dgp != null) {
                        a.this.dgp.c(view, invoiceInfo);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dfj != null) {
            return this.dfj.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.dfj != null) {
            InvoiceInfo invoiceInfo = this.dfj.get(i);
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
    public class C0295a extends RecyclerView.ViewHolder {
        InvoiceListItemView dgr;

        public C0295a(View view) {
            super(view);
            this.dgr = (InvoiceListItemView) view.findViewById(R.id.invoice_list_item);
        }
    }
}
