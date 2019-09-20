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
    private View.OnClickListener caG;
    private BaseActivity mContext;
    private List<AccountData> mData = null;
    private boolean cXs = false;

    public a(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.mContext = baseActivity;
        this.caG = onClickListener;
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
        C0278a c0278a;
        try {
            try {
                if (view != null) {
                    c0278a = (C0278a) view.getTag();
                    view3 = view;
                } else if (getItemViewType(i) == 0) {
                    view3 = LayoutInflater.from(this.mContext.getPageContext().getContext()).inflate(R.layout.account_item, viewGroup, false);
                    c0278a = new C0278a();
                    c0278a.cXt = (TextView) view3.findViewById(R.id.account);
                    c0278a.cXv = (ImageView) view3.findViewById(R.id.active);
                    c0278a.cXw = (TextView) view3.findViewById(R.id.delete);
                    c0278a.cXw.setOnClickListener(this.caG);
                    view3.setTag(c0278a);
                } else {
                    view3 = LayoutInflater.from(this.mContext.getPageContext().getContext()).inflate(R.layout.account_add_item, viewGroup, false);
                    c0278a = new C0278a();
                    c0278a.cXu = (TextView) view3.findViewById(R.id.add_text);
                    view3.setTag(c0278a);
                }
                if (getItemViewType(i) == 0) {
                    AccountData accountData = (AccountData) getItem(i);
                    c0278a.cXv.setVisibility(8);
                    c0278a.cXw.setVisibility(8);
                    c0278a.cXw.setTag(accountData);
                    if (accountData != null) {
                        c0278a.cXt.setText(accountData.getAccountNameShow());
                        if (TextUtils.equals(accountData.getID(), TbadkCoreApplication.getCurrentAccount())) {
                            c0278a.cXv.setVisibility(0);
                        }
                        if (this.cXs) {
                            c0278a.cXw.setVisibility(0);
                        }
                    }
                }
                this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.mContext.getLayoutMode().onModeChanged(view3);
                return view3;
            } catch (Exception e) {
                exc = e;
                view2 = view;
                try {
                    BdLog.detailException(exc);
                    this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                    this.mContext.getLayoutMode().onModeChanged(view2);
                    return view2;
                } catch (Throwable th) {
                    view3 = view2;
                    th = th;
                    this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                    this.mContext.getLayoutMode().onModeChanged(view3);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                view3 = view;
                this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.mContext.getLayoutMode().onModeChanged(view3);
                throw th;
            }
        } catch (Exception e2) {
            view2 = view3;
            exc = e2;
            BdLog.detailException(exc);
            this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.mContext.getLayoutMode().onModeChanged(view2);
            return view2;
        } catch (Throwable th3) {
            th = th3;
            this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.mContext.getLayoutMode().onModeChanged(view3);
            throw th;
        }
    }

    public void gn(boolean z) {
        this.cXs = z;
    }

    public boolean aDd() {
        return this.cXs;
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
    private class C0278a {
        TextView cXt;
        TextView cXu;
        ImageView cXv;
        TextView cXw;

        private C0278a() {
        }
    }
}
