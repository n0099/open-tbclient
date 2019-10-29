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
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private BaseActivity cGU;
    private View.OnClickListener cpk;
    private List<AccountData> mData = null;
    private boolean dgN = false;

    public a(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.cGU = baseActivity;
        this.cpk = onClickListener;
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
        C0310a c0310a;
        try {
            try {
                if (view != null) {
                    c0310a = (C0310a) view.getTag();
                    view3 = view;
                } else if (getItemViewType(i) == 0) {
                    view3 = LayoutInflater.from(this.cGU.getPageContext().getContext()).inflate(R.layout.account_item, viewGroup, false);
                    c0310a = new C0310a();
                    c0310a.dgO = (TextView) view3.findViewById(R.id.account);
                    c0310a.dgQ = (ImageView) view3.findViewById(R.id.active);
                    c0310a.dgR = (TextView) view3.findViewById(R.id.delete);
                    c0310a.dgR.setOnClickListener(this.cpk);
                    view3.setTag(c0310a);
                } else {
                    view3 = LayoutInflater.from(this.cGU.getPageContext().getContext()).inflate(R.layout.account_add_item, viewGroup, false);
                    c0310a = new C0310a();
                    c0310a.dgP = (TextView) view3.findViewById(R.id.add_text);
                    view3.setTag(c0310a);
                }
                if (getItemViewType(i) == 0) {
                    AccountData accountData = (AccountData) getItem(i);
                    c0310a.dgQ.setVisibility(8);
                    c0310a.dgR.setVisibility(8);
                    c0310a.dgR.setTag(accountData);
                    if (accountData != null) {
                        c0310a.dgO.setText(accountData.getAccountNameShow());
                        if (TextUtils.equals(accountData.getID(), TbadkCoreApplication.getCurrentAccount())) {
                            c0310a.dgQ.setVisibility(0);
                        }
                        if (this.dgN) {
                            c0310a.dgR.setVisibility(0);
                        }
                    }
                }
                this.cGU.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.cGU.getLayoutMode().onModeChanged(view3);
                return view3;
            } catch (Exception e) {
                exc = e;
                view2 = view;
                try {
                    BdLog.detailException(exc);
                    this.cGU.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                    this.cGU.getLayoutMode().onModeChanged(view2);
                    return view2;
                } catch (Throwable th) {
                    view3 = view2;
                    th = th;
                    this.cGU.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                    this.cGU.getLayoutMode().onModeChanged(view3);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                view3 = view;
                this.cGU.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.cGU.getLayoutMode().onModeChanged(view3);
                throw th;
            }
        } catch (Exception e2) {
            view2 = view3;
            exc = e2;
            BdLog.detailException(exc);
            this.cGU.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.cGU.getLayoutMode().onModeChanged(view2);
            return view2;
        } catch (Throwable th3) {
            th = th3;
            this.cGU.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.cGU.getLayoutMode().onModeChanged(view3);
            throw th;
        }
    }

    public void gc(boolean z) {
        this.dgN = z;
    }

    public boolean aDm() {
        return this.dgN;
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
    /* loaded from: classes4.dex */
    private class C0310a {
        TextView dgO;
        TextView dgP;
        ImageView dgQ;
        TextView dgR;

        private C0310a() {
        }
    }
}
