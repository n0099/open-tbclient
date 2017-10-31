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
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private View.OnClickListener alC;
    private BaseActivity mContext;
    private List<AccountData> mData = null;
    private boolean aYJ = false;

    public a(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.mContext = baseActivity;
        this.alC = onClickListener;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [124=4, 126=4] */
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
        C0071a c0071a;
        View view5;
        try {
            try {
                if (view != null) {
                    c0071a = (C0071a) view.getTag();
                    view5 = view;
                } else if (getItemViewType(i) == 0) {
                    view5 = LayoutInflater.from(this.mContext.getPageContext().getContext()).inflate(d.h.account_item, (ViewGroup) null);
                    c0071a = new C0071a();
                    c0071a.aYK = (TextView) view5.findViewById(d.g.account);
                    c0071a.aYM = (ImageView) view5.findViewById(d.g.active);
                    c0071a.aYN = (Button) view5.findViewById(d.g.delete);
                    c0071a.mLine = view5.findViewById(d.g.account_item_line_layout);
                    c0071a.aYN.setOnClickListener(this.alC);
                    view5.setTag(c0071a);
                } else {
                    view5 = LayoutInflater.from(this.mContext.getPageContext().getContext()).inflate(d.h.account_add_item, (ViewGroup) null);
                    c0071a = new C0071a();
                    c0071a.aYL = (TextView) view5.findViewById(d.g.add_text);
                    view5.setTag(c0071a);
                }
                if (getItemViewType(i) == 0) {
                    AccountData accountData = (AccountData) getItem(i);
                    c0071a.aYM.setVisibility(8);
                    c0071a.aYN.setVisibility(8);
                    c0071a.aYN.setTag(accountData);
                    if (accountData != null) {
                        c0071a.aYK.setText(accountData.getAccountNameShow());
                        if (TextUtils.equals(accountData.getID(), TbadkCoreApplication.getCurrentAccount())) {
                            c0071a.aYM.setVisibility(0);
                        }
                        if (this.aYJ) {
                            c0071a.aYN.setVisibility(0);
                        }
                    }
                    if (i == getCount() - 2) {
                        c0071a.mLine.setVisibility(8);
                    } else {
                        c0071a.mLine.setVisibility(0);
                    }
                }
                this.mContext.getLayoutMode().ag(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.mContext.getLayoutMode().t(view5);
                return view5;
            } catch (Exception e) {
                exc = e;
                view3 = view;
                try {
                    BdLog.detailException(exc);
                    this.mContext.getLayoutMode().ag(TbadkCoreApplication.getInst().getSkinType() == 1);
                    this.mContext.getLayoutMode().t(view3);
                    return view3;
                } catch (Throwable th) {
                    view4 = view3;
                    th = th;
                    this.mContext.getLayoutMode().ag(TbadkCoreApplication.getInst().getSkinType() == 1);
                    this.mContext.getLayoutMode().t(view4);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                view4 = view;
                this.mContext.getLayoutMode().ag(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.mContext.getLayoutMode().t(view4);
                throw th;
            }
        } catch (Exception e2) {
            view3 = view2;
            exc = e2;
            BdLog.detailException(exc);
            this.mContext.getLayoutMode().ag(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.mContext.getLayoutMode().t(view3);
            return view3;
        } catch (Throwable th3) {
            th = th3;
            this.mContext.getLayoutMode().ag(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.mContext.getLayoutMode().t(view4);
            throw th;
        }
    }

    public void setEditState(boolean z) {
        this.aYJ = z;
    }

    public boolean Ly() {
        return this.aYJ;
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
    /* loaded from: classes.dex */
    private class C0071a {
        TextView aYK;
        TextView aYL;
        ImageView aYM;
        Button aYN;
        View mLine;

        private C0071a() {
        }
    }
}
