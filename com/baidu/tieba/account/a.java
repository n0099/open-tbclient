package com.baidu.tieba.account;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private BaseActivity dTQ;
    private View.OnClickListener dbS;
    private List<AccountData> mData = null;
    private boolean dTR = false;

    public a(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.dTQ = baseActivity;
        this.dbS = onClickListener;
    }

    public void setData(List<AccountData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.mData != null) {
            i = this.mData.size();
        }
        return i + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData == null || i < 0 || i >= this.mData.size()) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) != null) {
            return i;
        }
        return -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [115=4, 117=5] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0135  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        Exception exc;
        View view3;
        C0393a c0393a;
        try {
            try {
                if (view != null) {
                    c0393a = (C0393a) view.getTag();
                    view3 = view;
                } else if (getItemViewType(i) == 0) {
                    view3 = LayoutInflater.from(this.dTQ.getPageContext().getContext()).inflate(R.layout.account_item, viewGroup, false);
                    c0393a = new C0393a();
                    c0393a.dTS = (TextView) view3.findViewById(R.id.account);
                    c0393a.dTU = (ImageView) view3.findViewById(R.id.active);
                    c0393a.dTV = (TextView) view3.findViewById(R.id.delete);
                    c0393a.dTV.setOnClickListener(this.dbS);
                    view3.setTag(c0393a);
                } else {
                    view3 = LayoutInflater.from(this.dTQ.getPageContext().getContext()).inflate(R.layout.account_add_item, viewGroup, false);
                    c0393a = new C0393a();
                    c0393a.dTT = (TextView) view3.findViewById(R.id.add_text);
                    view3.setTag(c0393a);
                }
                if (getItemViewType(i) == 0) {
                    AccountData accountData = (AccountData) getItem(i);
                    c0393a.dTU.setVisibility(8);
                    c0393a.dTV.setVisibility(8);
                    c0393a.dTV.setTag(accountData);
                    if (accountData != null) {
                        c0393a.dTS.setText(accountData.getAccountNameShow());
                        if (TextUtils.equals(accountData.getID(), TbadkCoreApplication.getCurrentAccount())) {
                            c0393a.dTU.setVisibility(0);
                        }
                        if (this.dTR) {
                            c0393a.dTV.setVisibility(0);
                        }
                    }
                }
                this.dTQ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.dTQ.getLayoutMode().onModeChanged(view3);
                return view3;
            } catch (Exception e) {
                exc = e;
                view2 = view;
                try {
                    BdLog.detailException(exc);
                    this.dTQ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                    this.dTQ.getLayoutMode().onModeChanged(view2);
                    return view2;
                } catch (Throwable th) {
                    view3 = view2;
                    th = th;
                    this.dTQ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                    this.dTQ.getLayoutMode().onModeChanged(view3);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                view3 = view;
                this.dTQ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.dTQ.getLayoutMode().onModeChanged(view3);
                throw th;
            }
        } catch (Exception e2) {
            view2 = view3;
            exc = e2;
            BdLog.detailException(exc);
            this.dTQ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.dTQ.getLayoutMode().onModeChanged(view2);
            return view2;
        } catch (Throwable th3) {
            th = th3;
            this.dTQ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.dTQ.getLayoutMode().onModeChanged(view3);
            throw th;
        }
    }

    public void hv(boolean z) {
        this.dTR = z;
    }

    public boolean aVw() {
        return this.dTR;
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

    /* renamed from: com.baidu.tieba.account.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class C0393a {
        TextView dTS;
        TextView dTT;
        ImageView dTU;
        TextView dTV;

        private C0393a() {
        }
    }
}
