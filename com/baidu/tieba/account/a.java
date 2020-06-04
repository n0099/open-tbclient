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
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private View.OnClickListener dUl;
    private BaseActivity eNm;
    private List<AccountData> mData = null;
    private boolean eNn = false;

    public a(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.eNm = baseActivity;
        this.dUl = onClickListener;
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
        C0504a c0504a;
        try {
            try {
                if (view != null) {
                    c0504a = (C0504a) view.getTag();
                    view3 = view;
                } else if (getItemViewType(i) == 0) {
                    view3 = LayoutInflater.from(this.eNm.getPageContext().getContext()).inflate(R.layout.account_item, viewGroup, false);
                    c0504a = new C0504a();
                    c0504a.eNo = (TextView) view3.findViewById(R.id.account);
                    c0504a.eNq = (ImageView) view3.findViewById(R.id.active);
                    c0504a.eNr = (TextView) view3.findViewById(R.id.delete);
                    c0504a.eNr.setOnClickListener(this.dUl);
                    view3.setTag(c0504a);
                } else {
                    view3 = LayoutInflater.from(this.eNm.getPageContext().getContext()).inflate(R.layout.account_add_item, viewGroup, false);
                    c0504a = new C0504a();
                    c0504a.eNp = (TextView) view3.findViewById(R.id.add_text);
                    view3.setTag(c0504a);
                }
                if (getItemViewType(i) == 0) {
                    AccountData accountData = (AccountData) getItem(i);
                    c0504a.eNq.setVisibility(8);
                    c0504a.eNr.setVisibility(8);
                    c0504a.eNr.setTag(accountData);
                    if (accountData != null) {
                        c0504a.eNo.setText(accountData.getAccountNameShow());
                        if (TextUtils.equals(accountData.getID(), TbadkCoreApplication.getCurrentAccount())) {
                            c0504a.eNq.setVisibility(0);
                        }
                        if (this.eNn) {
                            c0504a.eNr.setVisibility(0);
                        }
                    }
                }
                this.eNm.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.eNm.getLayoutMode().onModeChanged(view3);
                return view3;
            } catch (Exception e) {
                exc = e;
                view2 = view;
                try {
                    BdLog.detailException(exc);
                    this.eNm.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                    this.eNm.getLayoutMode().onModeChanged(view2);
                    return view2;
                } catch (Throwable th) {
                    view3 = view2;
                    th = th;
                    this.eNm.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                    this.eNm.getLayoutMode().onModeChanged(view3);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                view3 = view;
                this.eNm.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.eNm.getLayoutMode().onModeChanged(view3);
                throw th;
            }
        } catch (Exception e2) {
            view2 = view3;
            exc = e2;
            BdLog.detailException(exc);
            this.eNm.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.eNm.getLayoutMode().onModeChanged(view2);
            return view2;
        } catch (Throwable th3) {
            th = th3;
            this.eNm.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.eNm.getLayoutMode().onModeChanged(view3);
            throw th;
        }
    }

    public void iY(boolean z) {
        this.eNn = z;
    }

    public boolean bmj() {
        return this.eNn;
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
    /* loaded from: classes9.dex */
    private class C0504a {
        TextView eNo;
        TextView eNp;
        ImageView eNq;
        TextView eNr;

        private C0504a() {
        }
    }
}
