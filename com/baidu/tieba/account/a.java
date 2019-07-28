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
    private View.OnClickListener bZH;
    private BaseActivity mContext;
    private List<AccountData> mData = null;
    private boolean cWs = false;

    public a(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.mContext = baseActivity;
        this.bZH = onClickListener;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [122=4, 124=4] */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00fe: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:30:0x00fd */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0154  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        Exception exc;
        View view3;
        View view4;
        C0269a c0269a;
        View view5;
        try {
            try {
                if (view != null) {
                    c0269a = (C0269a) view.getTag();
                    view5 = view;
                } else if (getItemViewType(i) == 0) {
                    view5 = LayoutInflater.from(this.mContext.getPageContext().getContext()).inflate(R.layout.account_item, viewGroup, false);
                    c0269a = new C0269a();
                    c0269a.cWt = (TextView) view5.findViewById(R.id.account);
                    c0269a.cWv = (ImageView) view5.findViewById(R.id.active);
                    c0269a.cWw = (TextView) view5.findViewById(R.id.delete);
                    c0269a.mLine = view5.findViewById(R.id.account_item_line);
                    c0269a.cWw.setOnClickListener(this.bZH);
                    view5.setTag(c0269a);
                } else {
                    view5 = LayoutInflater.from(this.mContext.getPageContext().getContext()).inflate(R.layout.account_add_item, viewGroup, false);
                    c0269a = new C0269a();
                    c0269a.cWu = (TextView) view5.findViewById(R.id.add_text);
                    view5.setTag(c0269a);
                }
                if (getItemViewType(i) == 0) {
                    AccountData accountData = (AccountData) getItem(i);
                    c0269a.cWv.setVisibility(8);
                    c0269a.cWw.setVisibility(8);
                    c0269a.cWw.setTag(accountData);
                    if (accountData != null) {
                        c0269a.cWt.setText(accountData.getAccountNameShow());
                        if (TextUtils.equals(accountData.getID(), TbadkCoreApplication.getCurrentAccount())) {
                            c0269a.cWv.setVisibility(0);
                        }
                        if (this.cWs) {
                            c0269a.cWw.setVisibility(0);
                        }
                    }
                    if (i == getCount() - 2) {
                        c0269a.mLine.setVisibility(8);
                    } else {
                        c0269a.mLine.setVisibility(0);
                    }
                }
                this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.mContext.getLayoutMode().onModeChanged(view5);
                return view5;
            } catch (Exception e) {
                view3 = view4;
                exc = e;
                try {
                    BdLog.detailException(exc);
                    this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                    this.mContext.getLayoutMode().onModeChanged(view3);
                    return view3;
                } catch (Throwable th) {
                    view2 = view3;
                    th = th;
                    this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                    this.mContext.getLayoutMode().onModeChanged(view2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.mContext.getLayoutMode().onModeChanged(view2);
                throw th;
            }
        } catch (Exception e2) {
            exc = e2;
            view3 = view;
            BdLog.detailException(exc);
            this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.mContext.getLayoutMode().onModeChanged(view3);
            return view3;
        } catch (Throwable th3) {
            th = th3;
            view2 = view;
            this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.mContext.getLayoutMode().onModeChanged(view2);
            throw th;
        }
    }

    public void gk(boolean z) {
        this.cWs = z;
    }

    public boolean aCN() {
        return this.cWs;
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
    private class C0269a {
        TextView cWt;
        TextView cWu;
        ImageView cWv;
        TextView cWw;
        View mLine;

        private C0269a() {
        }
    }
}
