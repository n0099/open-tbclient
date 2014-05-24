package com.baidu.tieba.account;

import android.view.LayoutInflater;
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
import com.baidu.tbadk.core.util.bc;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private BaseActivity a;
    private View.OnClickListener d;
    private ArrayList<AccountData> c = null;
    private boolean b = false;

    public l(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.a = baseActivity;
        this.d = onClickListener;
    }

    public void a(ArrayList<AccountData> arrayList) {
        this.c = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.c != null) {
            i = this.c.size();
        }
        return i + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.c == null || i < 0 || i >= this.c.size()) {
            return null;
        }
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) != null) {
            return i;
        }
        return -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [138=4] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x017e  */
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
                    if (view == null) {
                        LayoutInflater from = LayoutInflater.from(this.a);
                        if (getItemViewType(i) == 0) {
                            view2 = from.inflate(com.baidu.tieba.w.account_item, (ViewGroup) null);
                            mVar = new m(this, null);
                            mVar.a = (TextView) view2.findViewById(com.baidu.tieba.v.account);
                            mVar.c = (ImageView) view2.findViewById(com.baidu.tieba.v.active);
                            mVar.d = (Button) view2.findViewById(com.baidu.tieba.v.delete);
                            mVar.e = view2.findViewById(com.baidu.tieba.v.account_item_line_layout);
                            mVar.d.setOnClickListener(this.d);
                            view2.setTag(mVar);
                        } else {
                            view2 = from.inflate(com.baidu.tieba.w.account_add_item, (ViewGroup) null);
                            mVar = new m(this, null);
                            mVar.b = (TextView) view2.findViewById(com.baidu.tieba.v.add_text);
                            view2.setTag(mVar);
                        }
                    } else {
                        mVar = (m) view.getTag();
                        view2 = view;
                    }
                    if (getItemViewType(i) == 0) {
                        if (TbadkApplication.m252getInst().getSkinType() == 1) {
                            mVar.a.setTextColor(bc.a(1));
                        } else {
                            mVar.a.setTextColor(-12895429);
                        }
                        AccountData accountData = (AccountData) getItem(i);
                        mVar.c.setVisibility(8);
                        mVar.d.setVisibility(8);
                        mVar.d.setTag(accountData);
                        if (accountData != null) {
                            mVar.a.setText(accountData.getAccount());
                            if (accountData.getIsActive() == 1) {
                                mVar.c.setVisibility(0);
                            }
                            if (this.b) {
                                mVar.d.setVisibility(0);
                            }
                        }
                        if (i == getCount() - 2) {
                            mVar.e.setVisibility(8);
                        } else {
                            mVar.e.setVisibility(0);
                        }
                    } else {
                        if (TbadkApplication.m252getInst().getSkinType() == 1) {
                            mVar.b.setTextColor(bc.a(1));
                        } else {
                            mVar.b.setTextColor(-12895429);
                        }
                        mVar.e.setVisibility(8);
                    }
                    this.a.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
                    this.a.getLayoutMode().a(view2);
                    return view2;
                } catch (Throwable th) {
                    th = th;
                    this.a.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
                    this.a.getLayoutMode().a(view);
                    throw th;
                }
            } catch (Exception e) {
                e = e;
                BdLog.e(getClass().getName(), "getView", e.getMessage());
                this.a.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() != 1);
                this.a.getLayoutMode().a(view);
                return view;
            }
        } catch (Exception e2) {
            e = e2;
            BdLog.e(getClass().getName(), "getView", e.getMessage());
            this.a.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() != 1);
            this.a.getLayoutMode().a(view);
            return view;
        } catch (Throwable th2) {
            th = th2;
            this.a.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
            this.a.getLayoutMode().a(view);
            throw th;
        }
    }

    public void a(boolean z) {
        this.b = z;
    }

    public boolean a() {
        return this.b;
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
