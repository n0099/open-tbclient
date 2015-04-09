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
    private View.OnClickListener YC;
    private BaseActivity auI;
    private ArrayList<AccountData> auK = null;
    private boolean auJ = false;

    public m(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.auI = baseActivity;
        this.YC = onClickListener;
    }

    public void p(ArrayList<AccountData> arrayList) {
        this.auK = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.auK != null) {
            i = this.auK.size();
        }
        return i + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.auK == null || i < 0 || i >= this.auK.size()) {
            return null;
        }
        return this.auK.get(i);
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
                        view2 = com.baidu.adp.lib.g.b.hH().inflate(this.auI.getPageContext().getContext(), com.baidu.tieba.w.account_item, null);
                        nVar = new n(this, null);
                        nVar.auL = (TextView) view2.findViewById(com.baidu.tieba.v.account);
                        nVar.auN = (ImageView) view2.findViewById(com.baidu.tieba.v.active);
                        nVar.auO = (Button) view2.findViewById(com.baidu.tieba.v.delete);
                        nVar.adg = view2.findViewById(com.baidu.tieba.v.account_item_line_layout);
                        nVar.auO.setOnClickListener(this.YC);
                        view2.setTag(nVar);
                    } else {
                        view2 = com.baidu.adp.lib.g.b.hH().inflate(this.auI.getPageContext().getContext(), com.baidu.tieba.w.account_add_item, null);
                        nVar = new n(this, null);
                        nVar.auM = (TextView) view2.findViewById(com.baidu.tieba.v.add_text);
                        view2.setTag(nVar);
                    }
                    if (getItemViewType(i) == 0) {
                        AccountData accountData = (AccountData) getItem(i);
                        nVar.auN.setVisibility(8);
                        nVar.auO.setVisibility(8);
                        nVar.auO.setTag(accountData);
                        if (accountData != null) {
                            nVar.auL.setText(accountData.getAccount());
                            if (accountData.getIsActive() == 1) {
                                nVar.auN.setVisibility(0);
                            }
                            if (this.auJ) {
                                nVar.auO.setVisibility(0);
                            }
                        }
                        if (i == getCount() - 2) {
                            nVar.adg.setVisibility(8);
                        } else {
                            nVar.adg.setVisibility(0);
                        }
                    }
                    this.auI.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
                    this.auI.getLayoutMode().h(view2);
                    return view2;
                } catch (Throwable th) {
                    th = th;
                    this.auI.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
                    this.auI.getLayoutMode().h(view);
                    throw th;
                }
            } catch (Exception e) {
                e = e;
                BdLog.detailException(e);
                this.auI.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() != 1);
                this.auI.getLayoutMode().h(view);
                return view;
            }
        } catch (Exception e2) {
            e = e2;
            BdLog.detailException(e);
            this.auI.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() != 1);
            this.auI.getLayoutMode().h(view);
            return view;
        } catch (Throwable th2) {
            th = th2;
            this.auI.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            this.auI.getLayoutMode().h(view);
            throw th;
        }
    }

    public void setEditState(boolean z) {
        this.auJ = z;
    }

    public boolean Eo() {
        return this.auJ;
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
