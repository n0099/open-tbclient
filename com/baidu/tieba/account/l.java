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
import com.baidu.tbadk.core.util.ax;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private View.OnClickListener MY;
    private BaseActivity Ud;
    private ArrayList<AccountData> mData = null;
    private boolean alV = false;

    public l(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.Ud = baseActivity;
        this.MY = onClickListener;
    }

    public void r(ArrayList<AccountData> arrayList) {
        this.mData = arrayList;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [136=4] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017f  */
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
                        view2 = com.baidu.adp.lib.g.b.ek().inflate(this.Ud.getPageContext().getContext(), com.baidu.tieba.x.account_item, null);
                        mVar = new m(this, null);
                        mVar.alW = (TextView) view2.findViewById(com.baidu.tieba.w.account);
                        mVar.alY = (ImageView) view2.findViewById(com.baidu.tieba.w.active);
                        mVar.alZ = (Button) view2.findViewById(com.baidu.tieba.w.delete);
                        mVar.mLine = view2.findViewById(com.baidu.tieba.w.account_item_line_layout);
                        mVar.alZ.setOnClickListener(this.MY);
                        view2.setTag(mVar);
                    } else {
                        view2 = com.baidu.adp.lib.g.b.ek().inflate(this.Ud.getPageContext().getContext(), com.baidu.tieba.x.account_add_item, null);
                        mVar = new m(this, null);
                        mVar.alX = (TextView) view2.findViewById(com.baidu.tieba.w.add_text);
                        view2.setTag(mVar);
                    }
                    if (getItemViewType(i) == 0) {
                        if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
                            mVar.alW.setTextColor(ax.bU(1));
                        } else {
                            mVar.alW.setTextColor(-12895429);
                        }
                        AccountData accountData = (AccountData) getItem(i);
                        mVar.alY.setVisibility(8);
                        mVar.alZ.setVisibility(8);
                        mVar.alZ.setTag(accountData);
                        if (accountData != null) {
                            mVar.alW.setText(accountData.getAccount());
                            if (accountData.getIsActive() == 1) {
                                mVar.alY.setVisibility(0);
                            }
                            if (this.alV) {
                                mVar.alZ.setVisibility(0);
                            }
                        }
                        if (i == getCount() - 2) {
                            mVar.mLine.setVisibility(8);
                        } else {
                            mVar.mLine.setVisibility(0);
                        }
                    } else if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
                        mVar.alX.setTextColor(ax.bU(1));
                    } else {
                        mVar.alX.setTextColor(-12895429);
                    }
                    this.Ud.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
                    this.Ud.getLayoutMode().h(view2);
                    return view2;
                } catch (Exception e) {
                    e = e;
                    BdLog.detailException(e);
                    this.Ud.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() != 1);
                    this.Ud.getLayoutMode().h(view);
                    return view;
                }
            } catch (Throwable th) {
                th = th;
                this.Ud.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
                this.Ud.getLayoutMode().h(view);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            BdLog.detailException(e);
            this.Ud.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() != 1);
            this.Ud.getLayoutMode().h(view);
            return view;
        } catch (Throwable th2) {
            th = th2;
            this.Ud.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
            this.Ud.getLayoutMode().h(view);
            throw th;
        }
    }

    public void setEditState(boolean z) {
        this.alV = z;
    }

    public boolean Ay() {
        return this.alV;
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
