package com.baidu.tieba.account;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.aw;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private View.OnClickListener Ie;
    private BaseActivity On;
    private ArrayList<AccountData> aew = null;
    private boolean aev = false;

    public l(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.On = baseActivity;
        this.Ie = onClickListener;
    }

    public void setData(ArrayList<AccountData> arrayList) {
        this.aew = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.aew != null) {
            i = this.aew.size();
        }
        return i + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aew == null || i < 0 || i >= this.aew.size()) {
            return null;
        }
        return this.aew.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) != null) {
            return i;
        }
        return -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [136=4] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016f  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        m mVar;
        View view2;
        try {
            try {
                try {
                    if (view != null) {
                        mVar = (m) view.getTag();
                        view2 = view;
                    } else if (getItemViewType(i) == 0) {
                        view2 = com.baidu.adp.lib.g.b.ek().inflate(this.On, com.baidu.tieba.w.account_item, null);
                        mVar = new m(this, null);
                        mVar.aex = (TextView) view2.findViewById(com.baidu.tieba.v.account);
                        mVar.aez = (ImageView) view2.findViewById(com.baidu.tieba.v.active);
                        mVar.aeA = (Button) view2.findViewById(com.baidu.tieba.v.delete);
                        mVar.MI = view2.findViewById(com.baidu.tieba.v.account_item_line_layout);
                        mVar.aeA.setOnClickListener(this.Ie);
                        view2.setTag(mVar);
                    } else {
                        view2 = com.baidu.adp.lib.g.b.ek().inflate(this.On, com.baidu.tieba.w.account_add_item, null);
                        mVar = new m(this, null);
                        mVar.aey = (TextView) view2.findViewById(com.baidu.tieba.v.add_text);
                        view2.setTag(mVar);
                    }
                    if (getItemViewType(i) == 0) {
                        if (TbadkApplication.m251getInst().getSkinType() == 1) {
                            mVar.aex.setTextColor(aw.bx(1));
                        } else {
                            mVar.aex.setTextColor(-12895429);
                        }
                        AccountData accountData = (AccountData) getItem(i);
                        mVar.aez.setVisibility(8);
                        mVar.aeA.setVisibility(8);
                        mVar.aeA.setTag(accountData);
                        if (accountData != null) {
                            mVar.aex.setText(accountData.getAccount());
                            if (accountData.getIsActive() == 1) {
                                mVar.aez.setVisibility(0);
                            }
                            if (this.aev) {
                                mVar.aeA.setVisibility(0);
                            }
                        }
                        if (i == getCount() - 2) {
                            mVar.MI.setVisibility(8);
                        } else {
                            mVar.MI.setVisibility(0);
                        }
                    } else if (TbadkApplication.m251getInst().getSkinType() == 1) {
                        mVar.aey.setTextColor(aw.bx(1));
                    } else {
                        mVar.aey.setTextColor(-12895429);
                    }
                    this.On.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
                    this.On.getLayoutMode().h(view2);
                    return view2;
                } catch (Exception e) {
                    e = e;
                    BdLog.detailException(e);
                    this.On.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() != 1);
                    this.On.getLayoutMode().h(view);
                    return view;
                }
            } catch (Throwable th) {
                th = th;
                this.On.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
                this.On.getLayoutMode().h(view);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            BdLog.detailException(e);
            this.On.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() != 1);
            this.On.getLayoutMode().h(view);
            return view;
        } catch (Throwable th2) {
            th = th2;
            this.On.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
            this.On.getLayoutMode().h(view);
            throw th;
        }
    }

    public void setEditState(boolean z) {
        this.aev = z;
    }

    public boolean xd() {
        return this.aev;
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
