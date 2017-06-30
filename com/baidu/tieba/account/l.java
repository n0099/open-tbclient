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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private View.OnClickListener akF;
    private BaseActivity mContext;
    private List<AccountData> aUW = null;
    private boolean aUV = false;

    public l(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.mContext = baseActivity;
        this.akF = onClickListener;
    }

    public void setData(List<AccountData> list) {
        this.aUW = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.aUW != null) {
            i = this.aUW.size();
        }
        return i + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aUW == null || i < 0 || i >= this.aUW.size()) {
            return null;
        }
        return this.aUW.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) != null) {
            return i;
        }
        return -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [126=4] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0148  */
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
                        aVar.aUX = (TextView) view2.findViewById(w.h.account);
                        aVar.aUZ = (ImageView) view2.findViewById(w.h.active);
                        aVar.aVa = (Button) view2.findViewById(w.h.delete);
                        aVar.asD = view2.findViewById(w.h.account_item_line_layout);
                        aVar.aVa.setOnClickListener(this.akF);
                        view2.setTag(aVar);
                    } else {
                        view2 = LayoutInflater.from(this.mContext.getPageContext().getContext()).inflate(w.j.account_add_item, (ViewGroup) null);
                        aVar = new a(this, null);
                        aVar.aUY = (TextView) view2.findViewById(w.h.add_text);
                        view2.setTag(aVar);
                    }
                    if (getItemViewType(i) == 0) {
                        AccountData accountData = (AccountData) getItem(i);
                        aVar.aUZ.setVisibility(8);
                        aVar.aVa.setVisibility(8);
                        aVar.aVa.setTag(accountData);
                        if (accountData != null) {
                            aVar.aUX.setText(accountData.getAccountNameShow());
                            if (TextUtils.equals(accountData.getID(), TbadkCoreApplication.getCurrentAccount())) {
                                aVar.aUZ.setVisibility(0);
                            }
                            if (this.aUV) {
                                aVar.aVa.setVisibility(0);
                            }
                        }
                        if (i == getCount() - 2) {
                            aVar.asD.setVisibility(8);
                        } else {
                            aVar.asD.setVisibility(0);
                        }
                    }
                    this.mContext.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
                    this.mContext.getLayoutMode().t(view2);
                    return view2;
                } catch (Throwable th) {
                    th = th;
                    this.mContext.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
                    this.mContext.getLayoutMode().t(view);
                    throw th;
                }
            } catch (Exception e) {
                e = e;
                BdLog.detailException(e);
                this.mContext.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() != 1);
                this.mContext.getLayoutMode().t(view);
                return view;
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
        this.aUV = z;
    }

    public boolean KH() {
        return this.aUV;
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
        TextView aUX;
        TextView aUY;
        ImageView aUZ;
        Button aVa;
        View asD;

        private a() {
        }

        /* synthetic */ a(l lVar, a aVar) {
            this();
        }
    }
}
