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
public class a extends RecyclerView.Adapter<C0327a> {
    private List<InvoiceInfo> dnM = new ArrayList();
    private b doT;
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

    public void aY(List<InvoiceInfo> list) {
        int aGN;
        if (list != null && list.size() > 0) {
            this.dnM.clear();
            this.dnM.addAll(list);
            if (this.dnM.get(0).mIsDefault != 1 && (aGN = aGN()) >= 0) {
                a(this.dnM.get(aGN), false);
            }
            notifyDataSetChanged();
        }
    }

    public void bO(long j) {
        if (this.dnM != null && this.dnM.size() > 0) {
            for (int i = 0; i < this.dnM.size(); i++) {
                InvoiceInfo invoiceInfo = this.dnM.get(i);
                if (invoiceInfo != null && invoiceInfo.mId == j) {
                    this.dnM.remove(i);
                    notifyItemRemoved(i);
                    if (i != this.dnM.size()) {
                        notifyItemRangeChanged(0, this.dnM.size());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void m(InvoiceInfo invoiceInfo) {
        if (this.dnM != null && invoiceInfo != null) {
            this.dnM.add(0, invoiceInfo);
            notifyItemInserted(0);
        }
    }

    public void bP(long j) {
        int bQ;
        if (this.dnM != null && (bQ = bQ(j)) >= 0) {
            int aGN = aGN();
            if (aGN >= 0) {
                this.dnM.get(aGN).mIsDefault = 0;
                notifyItemChanged(aGN);
            }
            this.dnM.get(bQ).mIsDefault = 1;
            notifyItemChanged(bQ);
        }
    }

    public void n(InvoiceInfo invoiceInfo) {
        int bQ;
        if (this.dnM != null && (bQ = bQ(invoiceInfo.mId)) >= 0) {
            this.dnM.set(bQ, invoiceInfo);
            notifyItemChanged(bQ);
            a(invoiceInfo, true);
        }
    }

    public void a(InvoiceInfo invoiceInfo, boolean z) {
        if (this.dnM != null && this.dnM.size() > 1 && invoiceInfo != null) {
            for (int i = 0; i < this.dnM.size(); i++) {
                InvoiceInfo invoiceInfo2 = this.dnM.get(i);
                if (invoiceInfo2 != null && invoiceInfo2.equals(invoiceInfo)) {
                    this.dnM.remove(i);
                    this.dnM.add(0, invoiceInfo2);
                    if (z) {
                        notifyItemMoved(i, 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private int aGN() {
        if (this.dnM == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dnM.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.dnM.get(i2);
            if (invoiceInfo == null || invoiceInfo.mIsDefault != 1) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    private int bQ(long j) {
        if (this.dnM == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dnM.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.dnM.get(i2);
            if (invoiceInfo == null || invoiceInfo.mId != j) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(b bVar) {
        this.doT = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: i */
    public C0327a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0327a c0327a = new C0327a(LayoutInflater.from(this.mContext).inflate(R.layout.invoice_list_item_view, viewGroup, false));
        if (i == 0) {
            c0327a.doV.aGO();
        } else if (i == 1) {
            c0327a.doV.aGP();
        }
        return c0327a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0327a c0327a, int i) {
        final InvoiceInfo invoiceInfo = this.dnM.get(i);
        if (invoiceInfo != null) {
            if (c0327a.getItemViewType() == 0) {
                c0327a.doV.setCompanyInfo(invoiceInfo.mTitle, invoiceInfo.dnN);
            } else if (c0327a.getItemViewType() == 1) {
                c0327a.doV.setPersonageInfo(invoiceInfo.mTitle);
            }
            if (invoiceInfo.mIsDefault == 1) {
                c0327a.doV.go(true);
            } else {
                c0327a.doV.go(false);
            }
            c0327a.doV.setEditClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.doT != null) {
                        a.this.doT.b(view, invoiceInfo);
                    }
                }
            });
            c0327a.doV.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.doT != null) {
                        a.this.doT.a(view, invoiceInfo);
                    }
                }
            });
            c0327a.doV.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (a.this.doT != null) {
                        a.this.doT.c(view, invoiceInfo);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dnM != null) {
            return this.dnM.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.dnM != null) {
            InvoiceInfo invoiceInfo = this.dnM.get(i);
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
    public class C0327a extends RecyclerView.ViewHolder {
        InvoiceListItemView doV;

        public C0327a(View view) {
            super(view);
            this.doV = (InvoiceListItemView) view.findViewById(R.id.invoice_list_item);
        }
    }
}
