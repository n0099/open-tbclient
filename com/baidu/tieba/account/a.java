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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private View.OnClickListener fko;
    private BaseActivity giB;
    private List<AccountData> mData = null;
    private boolean giC = false;

    public a(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.giB = baseActivity;
        this.fko = onClickListener;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [115=4, 117=6] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0130  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        Throwable th;
        Exception e;
        View view2;
        C0610a c0610a;
        View view3;
        try {
            if (view != null) {
                c0610a = (C0610a) view.getTag();
                view3 = view;
            } else if (getItemViewType(i) == 0) {
                view = LayoutInflater.from(this.giB.getPageContext().getContext()).inflate(R.layout.account_item, viewGroup, false);
                c0610a = new C0610a();
                c0610a.giD = (TextView) view.findViewById(R.id.account);
                c0610a.giE = (ImageView) view.findViewById(R.id.active);
                c0610a.giF = (TextView) view.findViewById(R.id.delete);
                c0610a.giF.setOnClickListener(this.fko);
                view.setTag(c0610a);
                view3 = view;
            } else {
                view = LayoutInflater.from(this.giB.getPageContext().getContext()).inflate(R.layout.account_add_item, viewGroup, false);
                c0610a = new C0610a();
                c0610a.flK = (TextView) view.findViewById(R.id.add_text);
                view.setTag(c0610a);
                view3 = view;
            }
        } catch (Exception e2) {
            e = e2;
            view2 = view;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            if (getItemViewType(i) == 0) {
                AccountData accountData = (AccountData) getItem(i);
                c0610a.giE.setVisibility(8);
                c0610a.giF.setVisibility(8);
                c0610a.giF.setTag(accountData);
                if (accountData != null) {
                    c0610a.giD.setText(accountData.getAccountNameShow());
                    if (TextUtils.equals(accountData.getID(), TbadkCoreApplication.getCurrentAccount())) {
                        c0610a.giE.setVisibility(0);
                    }
                    if (this.giC) {
                        c0610a.giF.setVisibility(0);
                    }
                }
            }
            this.giB.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.giB.getLayoutMode().onModeChanged(view3);
            return view3;
        } catch (Exception e3) {
            e = e3;
            view2 = view3;
            try {
                BdLog.detailException(e);
                this.giB.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.giB.getLayoutMode().onModeChanged(view2);
                return view2;
            } catch (Throwable th3) {
                th = th3;
                view = view2;
                this.giB.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.giB.getLayoutMode().onModeChanged(view);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            view = view3;
            this.giB.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.giB.getLayoutMode().onModeChanged(view);
            throw th;
        }
    }

    public void mc(boolean z) {
        this.giC = z;
    }

    public boolean bOu() {
        return this.giC;
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
    /* loaded from: classes2.dex */
    private class C0610a {
        TextView flK;
        TextView giD;
        ImageView giE;
        TextView giF;

        private C0610a() {
        }
    }
}
