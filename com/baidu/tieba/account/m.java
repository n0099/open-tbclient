package com.baidu.tieba.account;

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
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    private View.OnClickListener ZA;
    private BaseActivity awl;
    private ArrayList<AccountData> Sk = null;
    private boolean awm = false;

    public m(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.awl = baseActivity;
        this.ZA = onClickListener;
    }

    public void setData(ArrayList<AccountData> arrayList) {
        this.Sk = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.Sk != null) {
            i = this.Sk.size();
        }
        return i + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Sk == null || i < 0 || i >= this.Sk.size()) {
            return null;
        }
        return this.Sk.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) != null) {
            return i;
        }
        return -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [123=4] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0140  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        n nVar;
        View view2;
        try {
            try {
                try {
                    if (view != null) {
                        nVar = (n) view.getTag();
                        view2 = view;
                    } else if (getItemViewType(i) == 0) {
                        view2 = com.baidu.adp.lib.g.b.hr().inflate(this.awl.getPageContext().getContext(), com.baidu.tieba.r.account_item, null);
                        nVar = new n(this, null);
                        nVar.awn = (TextView) view2.findViewById(com.baidu.tieba.q.account);
                        nVar.awp = (ImageView) view2.findViewById(com.baidu.tieba.q.active);
                        nVar.awq = (Button) view2.findViewById(com.baidu.tieba.q.delete);
                        nVar.mLine = view2.findViewById(com.baidu.tieba.q.account_item_line_layout);
                        nVar.awq.setOnClickListener(this.ZA);
                        view2.setTag(nVar);
                    } else {
                        view2 = com.baidu.adp.lib.g.b.hr().inflate(this.awl.getPageContext().getContext(), com.baidu.tieba.r.account_add_item, null);
                        nVar = new n(this, null);
                        nVar.awo = (TextView) view2.findViewById(com.baidu.tieba.q.add_text);
                        view2.setTag(nVar);
                    }
                    if (getItemViewType(i) == 0) {
                        AccountData accountData = (AccountData) getItem(i);
                        nVar.awp.setVisibility(8);
                        nVar.awq.setVisibility(8);
                        nVar.awq.setTag(accountData);
                        if (accountData != null) {
                            nVar.awn.setText(accountData.getAccount());
                            if (accountData.getIsActive() == 1) {
                                nVar.awp.setVisibility(0);
                            }
                            if (this.awm) {
                                nVar.awq.setVisibility(0);
                            }
                        }
                        if (i == getCount() - 2) {
                            nVar.mLine.setVisibility(8);
                        } else {
                            nVar.mLine.setVisibility(0);
                        }
                    }
                    this.awl.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
                    this.awl.getLayoutMode().j(view2);
                    return view2;
                } catch (Throwable th) {
                    th = th;
                    this.awl.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
                    this.awl.getLayoutMode().j(view);
                    throw th;
                }
            } catch (Exception e) {
                e = e;
                BdLog.detailException(e);
                this.awl.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() != 1);
                this.awl.getLayoutMode().j(view);
                return view;
            }
        } catch (Exception e2) {
            e = e2;
            BdLog.detailException(e);
            this.awl.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() != 1);
            this.awl.getLayoutMode().j(view);
            return view;
        } catch (Throwable th2) {
            th = th2;
            this.awl.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            this.awl.getLayoutMode().j(view);
            throw th;
        }
    }

    public void setEditState(boolean z) {
        this.awm = z;
    }

    public boolean Fb() {
        return this.awm;
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
}
