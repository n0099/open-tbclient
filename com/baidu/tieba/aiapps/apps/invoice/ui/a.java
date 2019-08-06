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
public class a extends RecyclerView.Adapter<C0286a> {
    private List<InvoiceInfo> ddx = new ArrayList();
    private b deE;
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
        int aFY;
        if (list != null && list.size() > 0) {
            this.ddx.clear();
            this.ddx.addAll(list);
            if (this.ddx.get(0).mIsDefault != 1 && (aFY = aFY()) >= 0) {
                a(this.ddx.get(aFY), false);
            }
            notifyDataSetChanged();
        }
    }

    public void bX(long j) {
        if (this.ddx != null && this.ddx.size() > 0) {
            for (int i = 0; i < this.ddx.size(); i++) {
                InvoiceInfo invoiceInfo = this.ddx.get(i);
                if (invoiceInfo != null && invoiceInfo.mId == j) {
                    this.ddx.remove(i);
                    notifyItemRemoved(i);
                    if (i != this.ddx.size()) {
                        notifyItemRangeChanged(0, this.ddx.size());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void m(InvoiceInfo invoiceInfo) {
        if (this.ddx != null && invoiceInfo != null) {
            this.ddx.add(0, invoiceInfo);
            notifyItemInserted(0);
        }
    }

    public void bY(long j) {
        int bZ;
        if (this.ddx != null && (bZ = bZ(j)) >= 0) {
            int aFY = aFY();
            if (aFY >= 0) {
                this.ddx.get(aFY).mIsDefault = 0;
                notifyItemChanged(aFY);
            }
            this.ddx.get(bZ).mIsDefault = 1;
            notifyItemChanged(bZ);
        }
    }

    public void n(InvoiceInfo invoiceInfo) {
        int bZ;
        if (this.ddx != null && (bZ = bZ(invoiceInfo.mId)) >= 0) {
            this.ddx.set(bZ, invoiceInfo);
            notifyItemChanged(bZ);
            a(invoiceInfo, true);
        }
    }

    public void a(InvoiceInfo invoiceInfo, boolean z) {
        if (this.ddx != null && this.ddx.size() > 1 && invoiceInfo != null) {
            for (int i = 0; i < this.ddx.size(); i++) {
                InvoiceInfo invoiceInfo2 = this.ddx.get(i);
                if (invoiceInfo2 != null && invoiceInfo2.equals(invoiceInfo)) {
                    this.ddx.remove(i);
                    this.ddx.add(0, invoiceInfo2);
                    if (z) {
                        notifyItemMoved(i, 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private int aFY() {
        if (this.ddx == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.ddx.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.ddx.get(i2);
            if (invoiceInfo == null || invoiceInfo.mIsDefault != 1) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    private int bZ(long j) {
        if (this.ddx == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.ddx.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.ddx.get(i2);
            if (invoiceInfo == null || invoiceInfo.mId != j) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(b bVar) {
        this.deE = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: k */
    public C0286a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0286a c0286a = new C0286a(LayoutInflater.from(this.mContext).inflate(R.layout.invoice_list_item_view, viewGroup, false));
        if (i == 0) {
            c0286a.deG.aFZ();
        } else if (i == 1) {
            c0286a.deG.aGa();
        }
        return c0286a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0286a c0286a, int i) {
        final InvoiceInfo invoiceInfo = this.ddx.get(i);
        if (invoiceInfo != null) {
            if (c0286a.getItemViewType() == 0) {
                c0286a.deG.setCompanyInfo(invoiceInfo.mTitle, invoiceInfo.ddy);
            } else if (c0286a.getItemViewType() == 1) {
                c0286a.deG.setPersonageInfo(invoiceInfo.mTitle);
            }
            if (invoiceInfo.mIsDefault == 1) {
                c0286a.deG.gw(true);
            } else {
                c0286a.deG.gw(false);
            }
            c0286a.deG.setEditClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.deE != null) {
                        a.this.deE.b(view, invoiceInfo);
                    }
                }
            });
            c0286a.deG.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.deE != null) {
                        a.this.deE.a(view, invoiceInfo);
                    }
                }
            });
            c0286a.deG.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.a.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (a.this.deE != null) {
                        a.this.deE.c(view, invoiceInfo);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.ddx != null) {
            return this.ddx.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.ddx != null) {
            InvoiceInfo invoiceInfo = this.ddx.get(i);
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
    public class C0286a extends RecyclerView.ViewHolder {
        InvoiceListItemView deG;

        public C0286a(View view) {
            super(view);
            this.deG = (InvoiceListItemView) view.findViewById(R.id.invoice_list_item);
        }
    }
}
