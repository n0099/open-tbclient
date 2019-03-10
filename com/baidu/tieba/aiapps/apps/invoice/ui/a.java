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
public class a extends RecyclerView.Adapter<C0230a> {
    private List<InvoiceInfo> cTv = new ArrayList();
    private b cUy;
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
        int azr;
        if (list != null && list.size() > 0) {
            this.cTv.clear();
            this.cTv.addAll(list);
            if (this.cTv.get(0).mIsDefault != 1 && (azr = azr()) >= 0) {
                a(this.cTv.get(azr), false);
            }
            notifyDataSetChanged();
        }
    }

    public void bH(long j) {
        if (this.cTv != null && this.cTv.size() > 0) {
            for (int i = 0; i < this.cTv.size(); i++) {
                InvoiceInfo invoiceInfo = this.cTv.get(i);
                if (invoiceInfo != null && invoiceInfo.mId == j) {
                    this.cTv.remove(i);
                    notifyItemRemoved(i);
                    if (i != this.cTv.size()) {
                        notifyItemRangeChanged(0, this.cTv.size());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void m(InvoiceInfo invoiceInfo) {
        if (this.cTv != null && invoiceInfo != null) {
            this.cTv.add(0, invoiceInfo);
            notifyItemInserted(0);
        }
    }

    public void bI(long j) {
        int bJ;
        if (this.cTv != null && (bJ = bJ(j)) >= 0) {
            int azr = azr();
            if (azr >= 0) {
                this.cTv.get(azr).mIsDefault = 0;
                notifyItemChanged(azr);
            }
            this.cTv.get(bJ).mIsDefault = 1;
            notifyItemChanged(bJ);
        }
    }

    public void n(InvoiceInfo invoiceInfo) {
        int bJ;
        if (this.cTv != null && (bJ = bJ(invoiceInfo.mId)) >= 0) {
            this.cTv.set(bJ, invoiceInfo);
            notifyItemChanged(bJ);
            a(invoiceInfo, true);
        }
    }

    public void a(InvoiceInfo invoiceInfo, boolean z) {
        if (this.cTv != null && this.cTv.size() > 1 && invoiceInfo != null) {
            for (int i = 0; i < this.cTv.size(); i++) {
                InvoiceInfo invoiceInfo2 = this.cTv.get(i);
                if (invoiceInfo2 != null && invoiceInfo2.equals(invoiceInfo)) {
                    this.cTv.remove(i);
                    this.cTv.add(0, invoiceInfo2);
                    if (z) {
                        notifyItemMoved(i, 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private int azr() {
        if (this.cTv == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cTv.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.cTv.get(i2);
            if (invoiceInfo == null || invoiceInfo.mIsDefault != 1) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    private int bJ(long j) {
        if (this.cTv == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cTv.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.cTv.get(i2);
            if (invoiceInfo == null || invoiceInfo.mId != j) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(b bVar) {
        this.cUy = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: j */
    public C0230a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0230a c0230a = new C0230a(LayoutInflater.from(this.mContext).inflate(d.h.invoice_list_item_view, viewGroup, false));
        if (i == 0) {
            c0230a.cUA.azs();
        } else if (i == 1) {
            c0230a.cUA.azt();
        }
        return c0230a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0230a c0230a, int i) {
        final InvoiceInfo invoiceInfo = this.cTv.get(i);
        if (invoiceInfo != null) {
            if (c0230a.getItemViewType() == 0) {
                c0230a.cUA.setCompanyInfo(invoiceInfo.mTitle, invoiceInfo.cTw);
            } else if (c0230a.getItemViewType() == 1) {
                c0230a.cUA.setPersonageInfo(invoiceInfo.mTitle);
            }
            if (invoiceInfo.mIsDefault == 1) {
                c0230a.cUA.fV(true);
            } else {
                c0230a.cUA.fV(false);
            }
            c0230a.cUA.setEditClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.cUy != null) {
                        a.this.cUy.b(view, invoiceInfo);
                    }
                }
            });
            c0230a.cUA.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.cUy != null) {
                        a.this.cUy.a(view, invoiceInfo);
                    }
                }
            });
            c0230a.cUA.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (a.this.cUy != null) {
                        a.this.cUy.c(view, invoiceInfo);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cTv != null) {
            return this.cTv.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.cTv != null) {
            InvoiceInfo invoiceInfo = this.cTv.get(i);
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
    public class C0230a extends RecyclerView.ViewHolder {
        InvoiceListItemView cUA;

        public C0230a(View view) {
            super(view);
            this.cUA = (InvoiceListItemView) view.findViewById(d.g.invoice_list_item);
        }
    }
}
