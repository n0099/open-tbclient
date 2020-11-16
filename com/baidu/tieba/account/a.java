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
/* loaded from: classes21.dex */
public class a extends BaseAdapter {
    private View.OnClickListener eTp;
    private BaseActivity fQJ;
    private List<AccountData> mData = null;
    private boolean fQK = false;

    public a(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.fQJ = baseActivity;
        this.eTp = onClickListener;
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
    /* JADX WARN: Removed duplicated region for block: B:35:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x012f  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        Exception exc;
        View view3;
        C0607a c0607a;
        try {
            try {
                if (view != null) {
                    c0607a = (C0607a) view.getTag();
                    view3 = view;
                } else if (getItemViewType(i) == 0) {
                    view3 = LayoutInflater.from(this.fQJ.getPageContext().getContext()).inflate(R.layout.account_item, viewGroup, false);
                    c0607a = new C0607a();
                    c0607a.fQL = (TextView) view3.findViewById(R.id.account);
                    c0607a.fQM = (ImageView) view3.findViewById(R.id.active);
                    c0607a.fQN = (TextView) view3.findViewById(R.id.delete);
                    c0607a.fQN.setOnClickListener(this.eTp);
                    view3.setTag(c0607a);
                } else {
                    view3 = LayoutInflater.from(this.fQJ.getPageContext().getContext()).inflate(R.layout.account_add_item, viewGroup, false);
                    c0607a = new C0607a();
                    c0607a.eUF = (TextView) view3.findViewById(R.id.add_text);
                    view3.setTag(c0607a);
                }
                if (getItemViewType(i) == 0) {
                    AccountData accountData = (AccountData) getItem(i);
                    c0607a.fQM.setVisibility(8);
                    c0607a.fQN.setVisibility(8);
                    c0607a.fQN.setTag(accountData);
                    if (accountData != null) {
                        c0607a.fQL.setText(accountData.getAccountNameShow());
                        if (TextUtils.equals(accountData.getID(), TbadkCoreApplication.getCurrentAccount())) {
                            c0607a.fQM.setVisibility(0);
                        }
                        if (this.fQK) {
                            c0607a.fQN.setVisibility(0);
                        }
                    }
                }
                this.fQJ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.fQJ.getLayoutMode().onModeChanged(view3);
                return view3;
            } catch (Exception e) {
                exc = e;
                view2 = view;
                try {
                    BdLog.detailException(exc);
                    this.fQJ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                    this.fQJ.getLayoutMode().onModeChanged(view2);
                    return view2;
                } catch (Throwable th) {
                    view3 = view2;
                    th = th;
                    this.fQJ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                    this.fQJ.getLayoutMode().onModeChanged(view3);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                view3 = view;
                this.fQJ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.fQJ.getLayoutMode().onModeChanged(view3);
                throw th;
            }
        } catch (Exception e2) {
            view2 = view3;
            exc = e2;
            BdLog.detailException(exc);
            this.fQJ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.fQJ.getLayoutMode().onModeChanged(view2);
            return view2;
        } catch (Throwable th3) {
            th = th3;
            this.fQJ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.fQJ.getLayoutMode().onModeChanged(view3);
            throw th;
        }
    }

    public void lk(boolean z) {
        this.fQK = z;
    }

    public boolean bIt() {
        return this.fQK;
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
    /* loaded from: classes21.dex */
    private class C0607a {
        TextView eUF;
        TextView fQL;
        ImageView fQM;
        TextView fQN;

        private C0607a() {
        }
    }
}
