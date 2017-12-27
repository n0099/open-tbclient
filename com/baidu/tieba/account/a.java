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
    private View.OnClickListener aZY;
    private BaseActivity mContext;
    private List<AccountData> mData = null;
    private boolean bPV = false;

    public a(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.mContext = baseActivity;
        this.aZY = onClickListener;
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
        C0098a c0098a;
        View view5;
        try {
            try {
                if (view != null) {
                    c0098a = (C0098a) view.getTag();
                    view5 = view;
                } else if (getItemViewType(i) == 0) {
                    view5 = LayoutInflater.from(this.mContext.getPageContext().getContext()).inflate(d.h.account_item, (ViewGroup) null);
                    c0098a = new C0098a();
                    c0098a.bPW = (TextView) view5.findViewById(d.g.account);
                    c0098a.bPY = (ImageView) view5.findViewById(d.g.active);
                    c0098a.bPZ = (Button) view5.findViewById(d.g.delete);
                    c0098a.mLine = view5.findViewById(d.g.account_item_line_layout);
                    c0098a.bPZ.setOnClickListener(this.aZY);
                    view5.setTag(c0098a);
                } else {
                    view5 = LayoutInflater.from(this.mContext.getPageContext().getContext()).inflate(d.h.account_add_item, (ViewGroup) null);
                    c0098a = new C0098a();
                    c0098a.bPX = (TextView) view5.findViewById(d.g.add_text);
                    view5.setTag(c0098a);
                }
                if (getItemViewType(i) == 0) {
                    AccountData accountData = (AccountData) getItem(i);
                    c0098a.bPY.setVisibility(8);
                    c0098a.bPZ.setVisibility(8);
                    c0098a.bPZ.setTag(accountData);
                    if (accountData != null) {
                        c0098a.bPW.setText(accountData.getAccountNameShow());
                        if (TextUtils.equals(accountData.getID(), TbadkCoreApplication.getCurrentAccount())) {
                            c0098a.bPY.setVisibility(0);
                        }
                        if (this.bPV) {
                            c0098a.bPZ.setVisibility(0);
                        }
                    }
                    if (i == getCount() - 2) {
                        c0098a.mLine.setVisibility(8);
                    } else {
                        c0098a.mLine.setVisibility(0);
                    }
                }
                this.mContext.getLayoutMode().aM(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.mContext.getLayoutMode().aM(view5);
                return view5;
            } catch (Exception e) {
                exc = e;
                view3 = view;
                try {
                    BdLog.detailException(exc);
                    this.mContext.getLayoutMode().aM(TbadkCoreApplication.getInst().getSkinType() == 1);
                    this.mContext.getLayoutMode().aM(view3);
                    return view3;
                } catch (Throwable th) {
                    view4 = view3;
                    th = th;
                    this.mContext.getLayoutMode().aM(TbadkCoreApplication.getInst().getSkinType() == 1);
                    this.mContext.getLayoutMode().aM(view4);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                view4 = view;
                this.mContext.getLayoutMode().aM(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.mContext.getLayoutMode().aM(view4);
                throw th;
            }
        } catch (Exception e2) {
            view3 = view2;
            exc = e2;
            BdLog.detailException(exc);
            this.mContext.getLayoutMode().aM(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.mContext.getLayoutMode().aM(view3);
            return view3;
        } catch (Throwable th3) {
            th = th3;
            this.mContext.getLayoutMode().aM(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.mContext.getLayoutMode().aM(view4);
            throw th;
        }
    }

    public void setEditState(boolean z) {
        this.bPV = z;
    }

    public boolean TN() {
        return this.bPV;
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
    private class C0098a {
        TextView bPW;
        TextView bPX;
        ImageView bPY;
        Button bPZ;
        View mLine;

        private C0098a() {
        }
    }
}
