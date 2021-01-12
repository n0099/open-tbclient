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
    private View.OnClickListener ffD;
    private BaseActivity gdS;
    private List<AccountData> mData = null;
    private boolean gdT = false;

    public a(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.gdS = baseActivity;
        this.ffD = onClickListener;
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
        C0593a c0593a;
        View view3;
        try {
            if (view != null) {
                c0593a = (C0593a) view.getTag();
                view3 = view;
            } else if (getItemViewType(i) == 0) {
                view = LayoutInflater.from(this.gdS.getPageContext().getContext()).inflate(R.layout.account_item, viewGroup, false);
                c0593a = new C0593a();
                c0593a.gdU = (TextView) view.findViewById(R.id.account);
                c0593a.gdV = (ImageView) view.findViewById(R.id.active);
                c0593a.gdW = (TextView) view.findViewById(R.id.delete);
                c0593a.gdW.setOnClickListener(this.ffD);
                view.setTag(c0593a);
                view3 = view;
            } else {
                view = LayoutInflater.from(this.gdS.getPageContext().getContext()).inflate(R.layout.account_add_item, viewGroup, false);
                c0593a = new C0593a();
                c0593a.fgZ = (TextView) view.findViewById(R.id.add_text);
                view.setTag(c0593a);
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
                c0593a.gdV.setVisibility(8);
                c0593a.gdW.setVisibility(8);
                c0593a.gdW.setTag(accountData);
                if (accountData != null) {
                    c0593a.gdU.setText(accountData.getAccountNameShow());
                    if (TextUtils.equals(accountData.getID(), TbadkCoreApplication.getCurrentAccount())) {
                        c0593a.gdV.setVisibility(0);
                    }
                    if (this.gdT) {
                        c0593a.gdW.setVisibility(0);
                    }
                }
            }
            this.gdS.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.gdS.getLayoutMode().onModeChanged(view3);
            return view3;
        } catch (Exception e3) {
            e = e3;
            view2 = view3;
            try {
                BdLog.detailException(e);
                this.gdS.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.gdS.getLayoutMode().onModeChanged(view2);
                return view2;
            } catch (Throwable th3) {
                th = th3;
                view = view2;
                this.gdS.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.gdS.getLayoutMode().onModeChanged(view);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            view = view3;
            this.gdS.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.gdS.getLayoutMode().onModeChanged(view);
            throw th;
        }
    }

    public void lY(boolean z) {
        this.gdT = z;
    }

    public boolean bKD() {
        return this.gdT;
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
    private class C0593a {
        TextView fgZ;
        TextView gdU;
        ImageView gdV;
        TextView gdW;

        private C0593a() {
        }
    }
}
