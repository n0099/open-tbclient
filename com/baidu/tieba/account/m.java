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
import com.baidu.tbadk.core.util.bc;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    private View.OnClickListener Nr;
    private BaseActivity UG;
    private ArrayList<AccountData> amM = null;
    private boolean amL = false;

    public m(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.UG = baseActivity;
        this.Nr = onClickListener;
    }

    public void s(ArrayList<AccountData> arrayList) {
        this.amM = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.amM != null) {
            i = this.amM.size();
        }
        return i + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.amM == null || i < 0 || i >= this.amM.size()) {
            return null;
        }
        return this.amM.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) != null) {
            return i;
        }
        return -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [136=4] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017f  */
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
                        view2 = com.baidu.adp.lib.g.b.ei().inflate(this.UG.getPageContext().getContext(), com.baidu.tieba.x.account_item, null);
                        nVar = new n(this, null);
                        nVar.amN = (TextView) view2.findViewById(com.baidu.tieba.w.account);
                        nVar.amP = (ImageView) view2.findViewById(com.baidu.tieba.w.active);
                        nVar.amQ = (Button) view2.findViewById(com.baidu.tieba.w.delete);
                        nVar.Ta = view2.findViewById(com.baidu.tieba.w.account_item_line_layout);
                        nVar.amQ.setOnClickListener(this.Nr);
                        view2.setTag(nVar);
                    } else {
                        view2 = com.baidu.adp.lib.g.b.ei().inflate(this.UG.getPageContext().getContext(), com.baidu.tieba.x.account_add_item, null);
                        nVar = new n(this, null);
                        nVar.amO = (TextView) view2.findViewById(com.baidu.tieba.w.add_text);
                        view2.setTag(nVar);
                    }
                    if (getItemViewType(i) == 0) {
                        if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
                            nVar.amN.setTextColor(bc.cb(1));
                        } else {
                            nVar.amN.setTextColor(-12895429);
                        }
                        AccountData accountData = (AccountData) getItem(i);
                        nVar.amP.setVisibility(8);
                        nVar.amQ.setVisibility(8);
                        nVar.amQ.setTag(accountData);
                        if (accountData != null) {
                            nVar.amN.setText(accountData.getAccount());
                            if (accountData.getIsActive() == 1) {
                                nVar.amP.setVisibility(0);
                            }
                            if (this.amL) {
                                nVar.amQ.setVisibility(0);
                            }
                        }
                        if (i == getCount() - 2) {
                            nVar.Ta.setVisibility(8);
                        } else {
                            nVar.Ta.setVisibility(0);
                        }
                    } else if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
                        nVar.amO.setTextColor(bc.cb(1));
                    } else {
                        nVar.amO.setTextColor(-12895429);
                    }
                    this.UG.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
                    this.UG.getLayoutMode().h(view2);
                    return view2;
                } catch (Exception e) {
                    e = e;
                    BdLog.detailException(e);
                    this.UG.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() != 1);
                    this.UG.getLayoutMode().h(view);
                    return view;
                }
            } catch (Throwable th) {
                th = th;
                this.UG.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
                this.UG.getLayoutMode().h(view);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            BdLog.detailException(e);
            this.UG.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() != 1);
            this.UG.getLayoutMode().h(view);
            return view;
        } catch (Throwable th2) {
            th = th2;
            this.UG.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
            this.UG.getLayoutMode().h(view);
            throw th;
        }
    }

    public void setEditState(boolean z) {
        this.amL = z;
    }

    public boolean AT() {
        return this.amL;
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
