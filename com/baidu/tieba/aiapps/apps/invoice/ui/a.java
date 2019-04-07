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
    private List<InvoiceInfo> cTt = new ArrayList();
    private b cUw;
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
            this.cTt.clear();
            this.cTt.addAll(list);
            if (this.cTt.get(0).mIsDefault != 1 && (azn = azn()) >= 0) {
                a(this.cTt.get(azn), false);
            }
            notifyDataSetChanged();
        }
    }

    public void bH(long j) {
        if (this.cTt != null && this.cTt.size() > 0) {
            for (int i = 0; i < this.cTt.size(); i++) {
                InvoiceInfo invoiceInfo = this.cTt.get(i);
                if (invoiceInfo != null && invoiceInfo.mId == j) {
                    this.cTt.remove(i);
                    notifyItemRemoved(i);
                    if (i != this.cTt.size()) {
                        notifyItemRangeChanged(0, this.cTt.size());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void m(InvoiceInfo invoiceInfo) {
        if (this.cTt != null && invoiceInfo != null) {
            this.cTt.add(0, invoiceInfo);
            notifyItemInserted(0);
        }
    }

    public void bI(long j) {
        int bJ;
        if (this.cTt != null && (bJ = bJ(j)) >= 0) {
            int azn = azn();
            if (azn >= 0) {
                this.cTt.get(azn).mIsDefault = 0;
                notifyItemChanged(azn);
            }
            this.cTt.get(bJ).mIsDefault = 1;
            notifyItemChanged(bJ);
        }
    }

    public void n(InvoiceInfo invoiceInfo) {
        int bJ;
        if (this.cTt != null && (bJ = bJ(invoiceInfo.mId)) >= 0) {
            this.cTt.set(bJ, invoiceInfo);
            notifyItemChanged(bJ);
            a(invoiceInfo, true);
        }
    }

    public void a(InvoiceInfo invoiceInfo, boolean z) {
        if (this.cTt != null && this.cTt.size() > 1 && invoiceInfo != null) {
            for (int i = 0; i < this.cTt.size(); i++) {
                InvoiceInfo invoiceInfo2 = this.cTt.get(i);
                if (invoiceInfo2 != null && invoiceInfo2.equals(invoiceInfo)) {
                    this.cTt.remove(i);
                    this.cTt.add(0, invoiceInfo2);
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
        if (this.cTt == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cTt.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.cTt.get(i2);
            if (invoiceInfo == null || invoiceInfo.mIsDefault != 1) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    private int bJ(long j) {
        if (this.cTt == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cTt.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.cTt.get(i2);
            if (invoiceInfo == null || invoiceInfo.mId != j) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(b bVar) {
        this.cUw = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: j */
    public C0269a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0269a c0269a = new C0269a(LayoutInflater.from(this.mContext).inflate(d.h.invoice_list_item_view, viewGroup, false));
        if (i == 0) {
            c0269a.cUy.azo();
        } else if (i == 1) {
            c0269a.cUy.azp();
        }
        return c0269a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0269a c0269a, int i) {
        final InvoiceInfo invoiceInfo = this.cTt.get(i);
        if (invoiceInfo != null) {
            if (c0269a.getItemViewType() == 0) {
                c0269a.cUy.setCompanyInfo(invoiceInfo.mTitle, invoiceInfo.cTu);
            } else if (c0269a.getItemViewType() == 1) {
                c0269a.cUy.setPersonageInfo(invoiceInfo.mTitle);
            }
            if (invoiceInfo.mIsDefault == 1) {
                c0269a.cUy.fV(true);
            } else {
                c0269a.cUy.fV(false);
            }
            c0269a.cUy.setEditClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.cUw != null) {
                        a.this.cUw.b(view, invoiceInfo);
                    }
                }
            });
            c0269a.cUy.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.cUw != null) {
                        a.this.cUw.a(view, invoiceInfo);
                    }
                }
            });
            c0269a.cUy.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (a.this.cUw != null) {
                        a.this.cUw.c(view, invoiceInfo);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cTt != null) {
            return this.cTt.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.cTt != null) {
            InvoiceInfo invoiceInfo = this.cTt.get(i);
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
        InvoiceListItemView cUy;

        public C0269a(View view) {
            super(view);
            this.cUy = (InvoiceListItemView) view.findViewById(d.g.invoice_list_item);
        }
    }
}
