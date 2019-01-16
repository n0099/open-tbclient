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
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private View.OnClickListener aIr;
    private BaseActivity mContext;
    private List<AccountData> mData = null;
    private boolean bBB = false;

    public a(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.mContext = baseActivity;
        this.aIr = onClickListener;
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
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00f7: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:30:0x00f6 */
    /* JADX WARN: Removed duplicated region for block: B:45:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x014d  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        View view3;
        Exception exc;
        View view4;
        C0184a c0184a;
        View view5;
        try {
            try {
                if (view != null) {
                    c0184a = (C0184a) view.getTag();
                    view5 = view;
                } else if (getItemViewType(i) == 0) {
                    view5 = LayoutInflater.from(this.mContext.getPageContext().getContext()).inflate(e.h.account_item, viewGroup, false);
                    c0184a = new C0184a();
                    c0184a.bBC = (TextView) view5.findViewById(e.g.account);
                    c0184a.bBE = (ImageView) view5.findViewById(e.g.active);
                    c0184a.bBF = (TextView) view5.findViewById(e.g.delete);
                    c0184a.mLine = view5.findViewById(e.g.account_item_line);
                    c0184a.bBF.setOnClickListener(this.aIr);
                    view5.setTag(c0184a);
                } else {
                    view5 = LayoutInflater.from(this.mContext.getPageContext().getContext()).inflate(e.h.account_add_item, viewGroup, false);
                    c0184a = new C0184a();
                    c0184a.bBD = (TextView) view5.findViewById(e.g.add_text);
                    view5.setTag(c0184a);
                }
                if (getItemViewType(i) == 0) {
                    AccountData accountData = (AccountData) getItem(i);
                    c0184a.bBE.setVisibility(8);
                    c0184a.bBF.setVisibility(8);
                    c0184a.bBF.setTag(accountData);
                    if (accountData != null) {
                        c0184a.bBC.setText(accountData.getAccountNameShow());
                        if (TextUtils.equals(accountData.getID(), TbadkCoreApplication.getCurrentAccount())) {
                            c0184a.bBE.setVisibility(0);
                        }
                        if (this.bBB) {
                            c0184a.bBF.setVisibility(0);
                        }
                    }
                    if (i == getCount() - 2) {
                        c0184a.mLine.setVisibility(8);
                    } else {
                        c0184a.mLine.setVisibility(0);
                    }
                }
                this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.mContext.getLayoutMode().onModeChanged(view5);
                return view5;
            } catch (Exception e) {
                exc = e;
                view3 = view;
                try {
                    BdLog.detailException(exc);
                    this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                    this.mContext.getLayoutMode().onModeChanged(view3);
                    return view3;
                } catch (Throwable th) {
                    view4 = view3;
                    th = th;
                    this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                    this.mContext.getLayoutMode().onModeChanged(view4);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                view4 = view;
                this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.mContext.getLayoutMode().onModeChanged(view4);
                throw th;
            }
        } catch (Exception e2) {
            view3 = view2;
            exc = e2;
            BdLog.detailException(exc);
            this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.mContext.getLayoutMode().onModeChanged(view3);
            return view3;
        } catch (Throwable th3) {
            th = th3;
            this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.mContext.getLayoutMode().onModeChanged(view4);
            throw th;
        }
    }

    public void dt(boolean z) {
        this.bBB = z;
    }

    public boolean Ws() {
        return this.bBB;
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
    /* loaded from: classes5.dex */
    private class C0184a {
        TextView bBC;
        TextView bBD;
        ImageView bBE;
        TextView bBF;
        View mLine;

        private C0184a() {
        }
    }
}
