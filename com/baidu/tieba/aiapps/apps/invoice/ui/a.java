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
    private List<InvoiceInfo> bHe = new ArrayList();
    private b bIi;
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
        int YH;
        if (list != null && list.size() > 0) {
            this.bHe.clear();
            this.bHe.addAll(list);
            if (this.bHe.get(0).mIsDefault != 1 && (YH = YH()) >= 0) {
                a(this.bHe.get(YH), false);
            }
            notifyDataSetChanged();
        }
    }

    public void be(long j) {
        if (this.bHe != null && this.bHe.size() > 0) {
            for (int i = 0; i < this.bHe.size(); i++) {
                InvoiceInfo invoiceInfo = this.bHe.get(i);
                if (invoiceInfo != null && invoiceInfo.mId == j) {
                    this.bHe.remove(i);
                    notifyItemRemoved(i);
                    if (i != this.bHe.size()) {
                        notifyItemRangeChanged(0, this.bHe.size());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void m(InvoiceInfo invoiceInfo) {
        if (this.bHe != null && invoiceInfo != null) {
            this.bHe.add(0, invoiceInfo);
            notifyItemInserted(0);
        }
    }

    public void bf(long j) {
        int bg;
        if (this.bHe != null && (bg = bg(j)) >= 0) {
            int YH = YH();
            if (YH >= 0) {
                this.bHe.get(YH).mIsDefault = 0;
                notifyItemChanged(YH);
            }
            this.bHe.get(bg).mIsDefault = 1;
            notifyItemChanged(bg);
        }
    }

    public void n(InvoiceInfo invoiceInfo) {
        int bg;
        if (this.bHe != null && (bg = bg(invoiceInfo.mId)) >= 0) {
            this.bHe.set(bg, invoiceInfo);
            notifyItemChanged(bg);
            a(invoiceInfo, true);
        }
    }

    public void a(InvoiceInfo invoiceInfo, boolean z) {
        if (this.bHe != null && this.bHe.size() > 1 && invoiceInfo != null) {
            for (int i = 0; i < this.bHe.size(); i++) {
                InvoiceInfo invoiceInfo2 = this.bHe.get(i);
                if (invoiceInfo2 != null && invoiceInfo2.equals(invoiceInfo)) {
                    this.bHe.remove(i);
                    this.bHe.add(0, invoiceInfo2);
                    if (z) {
                        notifyItemMoved(i, 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private int YH() {
        if (this.bHe == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bHe.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.bHe.get(i2);
            if (invoiceInfo == null || invoiceInfo.mIsDefault != 1) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    private int bg(long j) {
        if (this.bHe == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bHe.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.bHe.get(i2);
            if (invoiceInfo == null || invoiceInfo.mId != j) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(b bVar) {
        this.bIi = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: i */
    public C0200a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0200a c0200a = new C0200a(LayoutInflater.from(this.mContext).inflate(e.h.invoice_list_item_view, viewGroup, false));
        if (i == 0) {
            c0200a.bIk.YI();
        } else if (i == 1) {
            c0200a.bIk.YJ();
        }
        return c0200a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0200a c0200a, int i) {
        final InvoiceInfo invoiceInfo = this.bHe.get(i);
        if (invoiceInfo != null) {
            if (c0200a.getItemViewType() == 0) {
                c0200a.bIk.setCompanyInfo(invoiceInfo.mTitle, invoiceInfo.bHf);
            } else if (c0200a.getItemViewType() == 1) {
                c0200a.bIk.setPersonageInfo(invoiceInfo.mTitle);
            }
            if (invoiceInfo.mIsDefault == 1) {
                c0200a.bIk.dA(true);
            } else {
                c0200a.bIk.dA(false);
            }
            c0200a.bIk.setEditClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bIi != null) {
                        a.this.bIi.b(view, invoiceInfo);
                    }
                }
            });
            c0200a.bIk.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bIi != null) {
                        a.this.bIi.a(view, invoiceInfo);
                    }
                }
            });
            c0200a.bIk.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (a.this.bIi != null) {
                        a.this.bIi.c(view, invoiceInfo);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.bHe != null) {
            return this.bHe.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.bHe != null) {
            InvoiceInfo invoiceInfo = this.bHe.get(i);
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
        InvoiceListItemView bIk;

        public C0200a(View view) {
            super(view);
            this.bIk = (InvoiceListItemView) view.findViewById(e.g.invoice_list_item);
        }
    }
}
