package com.baidu.tieba.account;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private View.OnClickListener akq;
    private BaseActivity mContext;
    private List<AccountData> aVq = null;
    private boolean aVp = false;

    public l(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.mContext = baseActivity;
        this.akq = onClickListener;
    }

    public void setData(List<AccountData> list) {
        this.aVq = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.aVq != null) {
            i = this.aVq.size();
        }
        return i + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aVq == null || i < 0 || i >= this.aVq.size()) {
            return null;
        }
        return this.aVq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) != null) {
            return i;
        }
        return -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [130=4] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x015e  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        try {
            try {
                try {
                    if (view != null) {
                        aVar = (a) view.getTag();
                        view2 = view;
                    } else if (getItemViewType(i) == 0) {
                        view2 = LayoutInflater.from(this.mContext.getPageContext().getContext()).inflate(w.j.account_item, (ViewGroup) null);
                        aVar = new a(this, null);
                        aVar.aVr = (TextView) view2.findViewById(w.h.account);
                        aVar.aVt = (ImageView) view2.findViewById(w.h.active);
                        aVar.aVu = (Button) view2.findViewById(w.h.delete);
                        aVar.ary = view2.findViewById(w.h.account_item_line_layout);
                        aVar.aVu.setOnClickListener(this.akq);
                        view2.setTag(aVar);
                    } else {
                        view2 = LayoutInflater.from(this.mContext.getPageContext().getContext()).inflate(w.j.account_add_item, (ViewGroup) null);
                        aVar = new a(this, null);
                        aVar.aVs = (TextView) view2.findViewById(w.h.add_text);
                        view2.setTag(aVar);
                    }
                    if (getItemViewType(i) == 0) {
                        AccountData accountData = (AccountData) getItem(i);
                        aVar.aVt.setVisibility(8);
                        aVar.aVu.setVisibility(8);
                        aVar.aVu.setTag(accountData);
                        if (accountData != null) {
                            if (StringUtils.isNull(accountData.getDisplayName())) {
                                aVar.aVr.setText(accountData.getAccount());
                            } else {
                                aVar.aVr.setText(accountData.getDisplayName());
                            }
                            if (TextUtils.equals(accountData.getID(), TbadkCoreApplication.getCurrentAccount())) {
                                aVar.aVt.setVisibility(0);
                            }
                            if (this.aVp) {
                                aVar.aVu.setVisibility(0);
                            }
                        }
                        if (i == getCount() - 2) {
                            aVar.ary.setVisibility(8);
                        } else {
                            aVar.ary.setVisibility(0);
                        }
                    }
                    this.mContext.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
                    this.mContext.getLayoutMode().t(view2);
                    return view2;
                } catch (Exception e) {
                    e = e;
                    BdLog.detailException(e);
                    this.mContext.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() != 1);
                    this.mContext.getLayoutMode().t(view);
                    return view;
                }
            } catch (Throwable th) {
                th = th;
                this.mContext.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
                this.mContext.getLayoutMode().t(view);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            BdLog.detailException(e);
            this.mContext.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() != 1);
            this.mContext.getLayoutMode().t(view);
            return view;
        } catch (Throwable th2) {
            th = th2;
            this.mContext.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
            this.mContext.getLayoutMode().t(view);
            throw th;
        }
    }

    public void setEditState(boolean z) {
        this.aVp = z;
    }

    public boolean Lz() {
        return this.aVp;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (getItemId(i) >= 0) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aVr;
        TextView aVs;
        ImageView aVt;
        Button aVu;
        View ary;

        private a() {
        }

        /* synthetic */ a(l lVar, a aVar) {
            this();
        }
    }
}
