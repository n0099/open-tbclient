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
    private View.OnClickListener YA;
    private BaseActivity auA;
    private ArrayList<AccountData> auC = null;
    private boolean auB = false;

    public m(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.auA = baseActivity;
        this.YA = onClickListener;
    }

    public void p(ArrayList<AccountData> arrayList) {
        this.auC = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.auC != null) {
            i = this.auC.size();
        }
        return i + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.auC == null || i < 0 || i >= this.auC.size()) {
            return null;
        }
        return this.auC.get(i);
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
                        view2 = com.baidu.adp.lib.g.b.hH().inflate(this.auA.getPageContext().getContext(), com.baidu.tieba.w.account_item, null);
                        nVar = new n(this, null);
                        nVar.auD = (TextView) view2.findViewById(com.baidu.tieba.v.account);
                        nVar.auF = (ImageView) view2.findViewById(com.baidu.tieba.v.active);
                        nVar.auG = (Button) view2.findViewById(com.baidu.tieba.v.delete);
                        nVar.acX = view2.findViewById(com.baidu.tieba.v.account_item_line_layout);
                        nVar.auG.setOnClickListener(this.YA);
                        view2.setTag(nVar);
                    } else {
                        view2 = com.baidu.adp.lib.g.b.hH().inflate(this.auA.getPageContext().getContext(), com.baidu.tieba.w.account_add_item, null);
                        nVar = new n(this, null);
                        nVar.auE = (TextView) view2.findViewById(com.baidu.tieba.v.add_text);
                        view2.setTag(nVar);
                    }
                    if (getItemViewType(i) == 0) {
                        AccountData accountData = (AccountData) getItem(i);
                        nVar.auF.setVisibility(8);
                        nVar.auG.setVisibility(8);
                        nVar.auG.setTag(accountData);
                        if (accountData != null) {
                            nVar.auD.setText(accountData.getAccount());
                            if (accountData.getIsActive() == 1) {
                                nVar.auF.setVisibility(0);
                            }
                            if (this.auB) {
                                nVar.auG.setVisibility(0);
                            }
                        }
                        if (i == getCount() - 2) {
                            nVar.acX.setVisibility(8);
                        } else {
                            nVar.acX.setVisibility(0);
                        }
                    }
                    this.auA.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
                    this.auA.getLayoutMode().h(view2);
                    return view2;
                } catch (Throwable th) {
                    th = th;
                    this.auA.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
                    this.auA.getLayoutMode().h(view);
                    throw th;
                }
            } catch (Exception e) {
                e = e;
                BdLog.detailException(e);
                this.auA.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() != 1);
                this.auA.getLayoutMode().h(view);
                return view;
            }
        } catch (Exception e2) {
            e = e2;
            BdLog.detailException(e);
            this.auA.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() != 1);
            this.auA.getLayoutMode().h(view);
            return view;
        } catch (Throwable th2) {
            th = th2;
            this.auA.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            this.auA.getLayoutMode().h(view);
            throw th;
        }
    }

    public void setEditState(boolean z) {
        this.auB = z;
    }

    public boolean Ei() {
        return this.auB;
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
