package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends RecyclerView.Adapter<C0269a> {
    private List<InvoiceInfo> cTu = new ArrayList();
    private b cUx;
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

    public void ay(List<InvoiceInfo> list) {
        int azn;
        if (list != null && list.size() > 0) {
            this.cTu.clear();
            this.cTu.addAll(list);
            if (this.cTu.get(0).mIsDefault != 1 && (azn = azn()) >= 0) {
                a(this.cTu.get(azn), false);
            }
            notifyDataSetChanged();
        }
    }

    public void bH(long j) {
        if (this.cTu != null && this.cTu.size() > 0) {
            for (int i = 0; i < this.cTu.size(); i++) {
                InvoiceInfo invoiceInfo = this.cTu.get(i);
                if (invoiceInfo != null && invoiceInfo.mId == j) {
                    this.cTu.remove(i);
                    notifyItemRemoved(i);
                    if (i != this.cTu.size()) {
                        notifyItemRangeChanged(0, this.cTu.size());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void m(InvoiceInfo invoiceInfo) {
        if (this.cTu != null && invoiceInfo != null) {
            this.cTu.add(0, invoiceInfo);
            notifyItemInserted(0);
        }
    }

    public void bI(long j) {
        int bJ;
        if (this.cTu != null && (bJ = bJ(j)) >= 0) {
            int azn = azn();
            if (azn >= 0) {
                this.cTu.get(azn).mIsDefault = 0;
                notifyItemChanged(azn);
            }
            this.cTu.get(bJ).mIsDefault = 1;
            notifyItemChanged(bJ);
        }
    }

    public void n(InvoiceInfo invoiceInfo) {
        int bJ;
        if (this.cTu != null && (bJ = bJ(invoiceInfo.mId)) >= 0) {
            this.cTu.set(bJ, invoiceInfo);
            notifyItemChanged(bJ);
            a(invoiceInfo, true);
        }
    }

    public void a(InvoiceInfo invoiceInfo, boolean z) {
        if (this.cTu != null && this.cTu.size() > 1 && invoiceInfo != null) {
            for (int i = 0; i < this.cTu.size(); i++) {
                InvoiceInfo invoiceInfo2 = this.cTu.get(i);
                if (invoiceInfo2 != null && invoiceInfo2.equals(invoiceInfo)) {
                    this.cTu.remove(i);
                    this.cTu.add(0, invoiceInfo2);
                    if (z) {
                        notifyItemMoved(i, 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private int azn() {
        if (this.cTu == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cTu.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.cTu.get(i2);
            if (invoiceInfo == null || invoiceInfo.mIsDefault != 1) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    private int bJ(long j) {
        if (this.cTu == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cTu.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.cTu.get(i2);
            if (invoiceInfo == null || invoiceInfo.mId != j) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(b bVar) {
        this.cUx = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: j */
    public C0269a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0269a c0269a = new C0269a(LayoutInflater.from(this.mContext).inflate(d.h.invoice_list_item_view, viewGroup, false));
        if (i == 0) {
            c0269a.cUz.azo();
        } else if (i == 1) {
            c0269a.cUz.azp();
        }
        return c0269a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0269a c0269a, int i) {
        final InvoiceInfo invoiceInfo = this.cTu.get(i);
        if (invoiceInfo != null) {
            if (c0269a.getItemViewType() == 0) {
                c0269a.cUz.setCompanyInfo(invoiceInfo.mTitle, invoiceInfo.cTv);
            } else if (c0269a.getItemViewType() == 1) {
                c0269a.cUz.setPersonageInfo(invoiceInfo.mTitle);
            }
            if (invoiceInfo.mIsDefault == 1) {
                c0269a.cUz.fV(true);
            } else {
                c0269a.cUz.fV(false);
            }
            c0269a.cUz.setEditClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.cUx != null) {
                        a.this.cUx.b(view, invoiceInfo);
                    }
                }
            });
            c0269a.cUz.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.cUx != null) {
                        a.this.cUx.a(view, invoiceInfo);
                    }
                }
            });
            c0269a.cUz.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (a.this.cUx != null) {
                        a.this.cUx.c(view, invoiceInfo);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cTu != null) {
            return this.cTu.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.cTu != null) {
            InvoiceInfo invoiceInfo = this.cTu.get(i);
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
    public class C0269a extends RecyclerView.ViewHolder {
        InvoiceListItemView cUz;

        public C0269a(View view) {
            super(view);
            this.cUz = (InvoiceListItemView) view.findViewById(d.g.invoice_list_item);
        }
    }
}
